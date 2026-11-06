# Architecture

> Draft. Fill in as the implementation lands.

- Ingestion: Kafka consumer -> bounded queue (backpressure)
- Pipeline: parse -> enrich -> rules -> model -> decision
- Threading: platform pool for CPU-bound stages, virtual threads for I/O-bound stages
- Plugins: ServiceLoader + one classloader per plugin JAR
- Feature store: Cassandra with a Caffeine cache in front
