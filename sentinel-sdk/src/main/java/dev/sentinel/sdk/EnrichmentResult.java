package dev.sentinel.sdk;

import java.util.Map;

/** Features an enricher adds to the transaction. */
public record EnrichmentResult(Map<String, Double> features, boolean usedFallback) {

    public static EnrichmentResult withFeature(String name, double value) {
        return new EnrichmentResult(Map.of(name, value), false);
    }

    public static EnrichmentResult fallbackWith(String name, double value) {
        return new EnrichmentResult(Map.of(name, value), true);
    }
}
