package dev.sentinel.core;

import dev.sentinel.core.plugin.PluginHost;

import java.nio.file.Path;

public final class Main {
    public static void main(String[] args) throws Exception {
        Path pluginDir = Path.of(args.length > 0 ? args[0] : "plugins-dist");
        PluginHost host = PluginHost.load(pluginDir);
        System.out.printf("Sentinel starting: %d enricher(s), %d decision hook(s) loaded%n",
                host.enrichers().size(), host.decisionHooks().size());
        // TODO: Kafka ingestion -> bounded queue -> staged pipeline (see docs/architecture.md)
    }
}
