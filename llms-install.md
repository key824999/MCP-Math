# MCP-Math: Installation Guide for LLMs

This server provides a fast, accurate, and lightweight math toolset for MCP-compatible environments.  
It includes arithmetic, statistics, combinatorics, sequences, geometry, and prime number utilities.

## 🛠 Installation & Execution

To install and run the server locally:

```bash
npx mcp add https://raw.githubusercontent.com/key824999/MCP-Math/refs/heads/master/manifest.json

git clone https://github.com/key824999/MCP-Math.git
cd MCP-Math
./gradlew bootRun
```

> ☕ Requires Java 21+ and Gradle 8+

## 🧩 Optional: Claude Desktop JSON Config

To run the server via a remote JAR (e.g., for Claude Desktop):

```json
{
  "mcpServers": {
    "mcp-math": {
      "command": "java",
      "args": [
        "-jar",
        "https://github.com/key824999/MCP-Math/releases/download/v0.1.0/mcp-math.jar"
      ]
    }
  }
}
```

## 📌 Notes

- Tools are exposed via `@Tool` annotations
- All methods are unit tested and performance-verified
- Useful for handling numeric queries, formula parsing, and precise calculations
