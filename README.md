# MCP-Math

**MCP-Math** is a Java-based [Model Context Protocol (MCP)](https://modelcontextprotocol.io) compatible tool that provides a suite of essential mathematical operations.

It is designed to be used by any AI agent or tool host that supports the MCP specification.

## Features

- `sqrt(num)` – Square root
- `pow(num, n)` – Power
- `abs(num)`, `round(num)`, `log(num)`, `log10(num)`
- `sin(radians)`, `cos(radians)`, `tan(radians)`
- `max(a, b)`, `min(a, b)`

All functions are annotated with `@Tool` and are auto-discovered by MCP hosts.

## Installation

To install this tool using the MCP CLI:

```bash
npx mcp add https://raw.githubusercontent.com/YOUR_USERNAME/mcp-math/main/manifest.json
```

> Replace `YOUR_USERNAME` with your actual GitHub username.

## Usage Examples

Once installed in an MCP-compatible host:

- `sqrt(25)` returns `5`
- `pow(2, 4)` returns `16`
- `round(3.7)` returns `4`
- `cos(0)` returns `1`

## Technical Details

- Built with Spring Boot and `spring-ai-mcp-server-spring-boot-starter`
- MCP-compatible methods are annotated with `@Tool`
- `manifest.json` is automatically generated using ClassGraph to scan the tool package
- Executable jar is placed under `./libs` for use by MCP hosts

## Build Instructions

```bash
./gradlew clean build
```

This will:
- Build the executable Spring Boot jar
- Generate `manifest.json`
- Copy the jar to `./libs` for publication

## Output

The following files will be generated and should be committed:

- `libs/mcp-math-0.0.1-SNAPSHOT.jar`
- `manifest.json`

## License

MIT

## Author

GitHub: [@YOUR_USERNAME](https://github.com/YOUR_USERNAME)
