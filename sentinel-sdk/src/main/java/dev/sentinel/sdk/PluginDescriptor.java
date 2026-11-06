package dev.sentinel.sdk;

import java.time.Duration;
import java.util.Objects;

/** Static metadata the host uses to wrap a plugin (timeout, id, SDK compatibility). */
public record PluginDescriptor(String id, String sdkVersion, Duration timeout) {
    public PluginDescriptor {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(sdkVersion, "sdkVersion");
        Objects.requireNonNull(timeout, "timeout");
    }
}
