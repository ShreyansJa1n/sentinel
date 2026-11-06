# Contributing

Build and test: `mvn clean verify` (JDK 21+).

Guidelines:
- Public types in `sentinel-sdk` follow semantic versioning. Breaking changes need an ADR.
- Every behavioral change needs a test.
- Performance claims need a reproducible benchmark (see `scripts/`).
