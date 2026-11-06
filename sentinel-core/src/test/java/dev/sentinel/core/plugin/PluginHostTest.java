package dev.sentinel.core.plugin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class PluginHostTest {

    @Test
    void missingDirectoryYieldsNoPlugins(@TempDir Path tmp) throws Exception {
        PluginHost host = PluginHost.load(tmp.resolve("does-not-exist"));
        assertThat(host.enrichers()).isEmpty();
        assertThat(host.decisionHooks()).isEmpty();
    }

    @Test
    void emptyDirectoryYieldsNoPlugins(@TempDir Path tmp) throws Exception {
        PluginHost host = PluginHost.load(tmp);
        assertThat(host.enrichers()).isEmpty();
    }
}
