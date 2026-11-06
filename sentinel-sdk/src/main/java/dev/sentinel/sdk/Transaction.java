package dev.sentinel.sdk;

import java.math.BigDecimal;
import java.time.Instant;

/** Immutable view of a payment event as seen by plugins. */
public record Transaction(
        String id,
        String cardId,
        String merchantId,
        String deviceId,
        BigDecimal amount,
        String currency,
        Instant timestamp) {
}
