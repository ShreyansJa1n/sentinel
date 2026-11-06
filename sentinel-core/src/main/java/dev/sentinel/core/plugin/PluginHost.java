package dev.sentinel.core.plugin;

import dev.sentinel.sdk.DecisionHook;
import dev.sentinel.sdk.Enricher;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Stream;

/**
 * Discovers plugin JARs in a directory and loads each one in its own classloader,
 * so plugin dependencies never clash with the core or with each other.
 *
 * <p>TODO: timeouts, circuit breakers, bulkheads, SDK version check, unload support.
 */
public final class PluginHost {

    private final List<Enricher> enrichers = new ArrayList<>();
    private final List<DecisionHook> decisionHooks = new ArrayList<>();
    private final List<URLClassLoader> loaders = new ArrayList<>();

    private PluginHost() {}

    public static PluginHost load(Path dir) throws IOException {
        PluginHost host = new PluginHost();
        if (!Files.isDirectory(dir)) {
            return host;
        }
        try (Stream<Path> jars = Files.list(dir)) {
            for (Path jar : jars.filter(p -> p.toString().endsWith(".jar")).toList()) {
                host.loadJar(jar);
            }
        }
        return host;
    }

    private void loadJar(Path jar) throws IOException {
        // Parent = the loader that holds the SDK, so SDK types are shared and everything else is isolated.
        ClassLoader parent = Enricher.class.getClassLoader();
        URLClassLoader loader = new URLClassLoader(new URL[] {jar.toUri().toURL()}, parent);
        loaders.add(loader);
        ServiceLoader.load(Enricher.class, loader).forEach(enrichers::add);
        ServiceLoader.load(DecisionHook.class, loader).forEach(decisionHooks::add);
    }

    public List<Enricher> enrichers() { return List.copyOf(enrichers); }

    public List<DecisionHook> decisionHooks() { return List.copyOf(decisionHooks); }
}
