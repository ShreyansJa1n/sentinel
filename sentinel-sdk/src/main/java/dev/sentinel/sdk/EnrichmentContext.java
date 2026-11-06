package dev.sentinel.sdk;

import java.util.Map;

/** Features computed so far, available read-only to enrichers. */
public interface EnrichmentContext {
    Map<String, Double> features();
}
