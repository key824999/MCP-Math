# MCP-Math: Installation Guide for LLMs

This server provides a fast, accurate, and lightweight math toolset for MCP-compatible environments.  
It includes core arithmetic, statistics, combinatorics, sequences, geometry, and prime number utilities.

---

## ☕ Java Requirements

MCP-Math requires **Java 21 or higher** to run properly.

---

## 🔹 For Claude Desktop Users

1. Open your `claude_desktop_config.json` file and add the following configuration:

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

2. Restart Claude Desktop or refresh your MCP server list.
3. You can now use math functions like `mean`, `nCr`, `standardDeviation`, `gcd`, and more.

> ⚠️ **Note for multiple MCP servers**
>
> If you're adding more than one MCP server in your `claude_desktop_config.json`,  
> make sure each server block is separated by a comma `,`.

---

## 🔹 For MCP CLI Users

If you have [MCP CLI](https://www.npmjs.com/package/mcp) installed, you can register the tool using:

```bash
npx mcp add https://raw.githubusercontent.com/key824999/MCP-Math/refs/heads/master/manifest.json
```

---

## 🔹 Running the Server Locally

To run this server on your own machine:

```bash
git clone https://github.com/key824999/MCP-Math.git
cd MCP-Math
./gradlew bootRun
```

---

## 📌 Notes

- All tools are exposed via `@Tool` annotations
- The manifest is auto-generated from classpath scanning
- Unit test coverage and input validation are built-in
