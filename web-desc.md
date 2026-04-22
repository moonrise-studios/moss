# Moss

## Portfolio Summary

**Moss** is Moonrise Studios' Spring-powered foundation for Minecraft plugin development. It brings dependency injection, lifecycle orchestration, and clean component wiring to Paper, BungeeCord, and Velocity projects without forcing developers into oversized plugin bootstrap classes or static-heavy architecture.

Instead of manually connecting listeners, commands, services, and configuration loaders, Moss embeds a Spring `ApplicationContext` inside the plugin lifecycle and gives teams a clean, modular structure from day one.

## Why It Exists

Minecraft plugins often start simple and become hard to maintain fast. Main classes become catch-alls, dependencies spread through static access patterns, and platform-specific setup makes shared architecture difficult.

Moss solves that by giving plugin teams:

- Constructor-driven dependency injection
- Clear lifecycle hooks for load, enable, reload, and disable
- Platform bootstraps for Paper, BungeeCord, and Velocity
- Consistent bean discovery and invocation across plugin modules
- A lightweight path to Spring patterns without building a custom framework per project

## What Makes It Valuable

### Clean plugin architecture

Moss keeps plugin entrypoints thin and moves real logic into managed components, making large codebases easier to grow, test, and maintain.

### Cross-platform foundation

The project supports multiple Minecraft server platforms while preserving one mental model for lifecycle and component management.

### Faster developer onboarding

Because wiring, lifecycle flow, and component registration are standardized, new contributors can understand project structure quickly and start shipping features faster.

### Production-friendly integration

Moss is designed to be shaded into plugin jars, making it practical for real deployments where teams want internal framework benefits without runtime setup complexity.

## Technical Highlights

- Java 21
- Spring `ApplicationContext` embedded in Minecraft plugin lifecycle
- Support for Paper, BungeeCord, and Velocity
- Gradle-based publishing to Moonrise Studios Maven infrastructure
- Example plugins included for each supported platform

## Ideal Use Cases

- Large Minecraft plugin projects that need stronger architecture
- Teams moving away from static singletons and tightly coupled main classes
- Shared platform tooling for a studio maintaining multiple server products
- Plugins that need lifecycle-aware initialization, reload handling, or modular services

## Portfolio Positioning

Moss represents Moonrise Studios' investment in internal-grade engineering standards for Minecraft infrastructure: reusable foundations, cleaner code organization, and tooling that scales with project complexity.

## Links

- **Source:** https://github.com/moonrise-studios/moss
- **Organization:** https://github.com/moonrise-studios
- **Packages:** https://repo.moonrise.gg
