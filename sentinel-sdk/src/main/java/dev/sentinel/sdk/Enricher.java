package dev.sentinel.sdk;

/**
 * Adds features to a transaction, typically by calling a client-owned service.
 * The host wraps every call in a timeout, circuit breaker, and bulkhead.
 */
public interface Enricher {

    PluginDescriptor describe();

    EnrichmentResult enrich(Transaction tx, EnrichmentContext ctx) throws Exception;

    /** Invoked when {@link #enrich} times out, fails, or the circuit is open. */
    EnrichmentResult fallback(Transaction tx, Throwable cause);
}
