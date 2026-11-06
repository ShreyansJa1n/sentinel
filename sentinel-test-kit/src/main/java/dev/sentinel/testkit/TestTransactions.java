package dev.sentinel.testkit;

import dev.sentinel.sdk.Transaction;

import java.math.BigDecimal;
import java.time.Instant;

/** Builders for synthetic transactions. TODO: JUnit 5 extension (PluginTestKit) with latency/failure simulation. */
public final class TestTransactions {
    private TestTransactions() {}

    public static Transaction card() {
        return new Transaction("tx-1", "card-1", "merchant-1", "device-1",
                new BigDecimal("42.00"), "EUR", Instant.parse("2026-01-01T12:00:00Z"));
    }
}
