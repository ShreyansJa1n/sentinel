# ADR-001: Isolate plugins with one classloader per JAR

- Status: proposed
- Date: 2026-11-06

## Context
Client extensions bring their own dependencies. Sharing one classpath risks version clashes and makes leaks hard to attribute.

## Decision
Load each plugin JAR in its own `URLClassLoader` whose parent holds only the SDK.

## Alternatives considered
- Shared classpath (simple, fragile)
- Separate processes (strongest isolation, higher latency and ops cost)
- JPMS layers (strong boundaries, heavier authoring burden)

## Consequences
Plugins cannot clash with the core. Unloading requires dropping all classloader references, so leak tests are needed (see postmortems).
