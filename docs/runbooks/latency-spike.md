# Runbook: latency spike

**Symptoms:** p99 above budget, decision latency alert firing.

## First checks
1. Consumer lag: growing means the pipeline is saturated.
2. GC logs: long pauses or allocation-rate jump.
3. Plugin metrics: any circuit open, any plugin latency elevated.
4. Cassandra read latency and cache hit rate.

## Likely causes
TODO

## Escalate when
TODO
