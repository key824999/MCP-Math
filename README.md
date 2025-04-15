# MCP-Math

**MCP-Math** is a Java-based [Model Context Protocol (MCP)](https://modelcontextprotocol.io) compatible tool that provides a suite of essential mathematical operations.

It is designed to be used by any AI agent or tool host that supports the MCP specification.

### ⚡ Fast, Accurate, and Lightweight
MCP-Math is engineered to deliver **fast execution**, **mathematically accurate results**, and **minimal resource overhead**. Each function is finely tuned to ensure:

- **High performance** even at scale (verified with performance tests)
- **Reliable outputs** with well-tested edge case handling
- **Minimal dependencies** for fast loading and lightweight deployment

---

## Installation

### 🔹 For Claude Desktop Users

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
3. You can now use mathematical functions like `sqrt`, `pow`, `mean`, `factorial`, and more directly through Claude.

> ⚠️ **Note for multiple MCP servers**
>
> If you're adding more than one MCP server in your `claude_desktop_config.json`,  
> make sure each server block is separated by a comma `,`.
>
> Example:
>
> ```json
> {
>   "mcpServers": {
>     "mcp-math": {
>       "command": "java",
>       "args": [
>         "-jar",
>         "https://github.com/key824999/MCP-Math/releases/download/v0.1.0/mcp-math.jar"
>       ]
>     },
>     "another-mcp-server": {
>       "command": "python",
>       "args": [
>         "another-tool.py"
>       ]
>     }
>   }
> }
> ```
> 
### 🔹 For MCP CLI Users

> If you have [MCP CLI](https://www.npmjs.com/package/mcp) installed, you can register the tool using the following command:

To install this tool using the MCP CLI:

```bash
npx mcp add https://raw.githubusercontent.com/key824999/MCP-Math/refs/heads/master/manifest.json
```

## Features by Category

### 📘 Basic Math
- `sqrt(double num)` – Square root
- `square(double num)` – Square
- `pow(double base, double exponent)` – Exponentiation
- `abs(double num)` – Absolute value
- `log(double num)` – Natural log
- `log10(double num)` – Log base 10
- `sin(double radians)`, `cos(double radians)`, `tan(double radians)` – Trigonometric functions
- `round(double num)` – Rounding
- `max(double a, double b)`, `min(double a, double b)` – Max/Min
- `mod(double a, double b)` – Modulo
- `ceil(double num)`, `floor(double num)` – Ceiling/Floor
- `gcd(int a, int b)`, `lcm(int a, int b)` – GCD/LCM
- `degToRad(double degrees)`, `radToDeg(double radians)` – Angle conversions
- `factorial(int n)` – Factorial

### 📊 Statistics
- `mean(List<Double> numbers)` – Mean
- `median(List<Double> numbers)` – Median
- `mode(List<Double> numbers)` – Mode
- `range(List<Double> numbers)` – Range
- `variance(List<Double> numbers)` – Sample Variance
- `standardDeviation(List<Double> numbers)` – Sample Standard Deviation
- `sum(List<Double> numbers)` – Sum
- `count(List<Double> numbers)` – Count

### 🔢 Combinatorics
- `factorial(int n)` – Factorial
- `nCr(int n, int r)` – Combinations
- `nPr(int n, int r)` – Permutations
- `multiFactorial(int n, int k)` – k-step Factorial
- `catalanNumber(int n)` – Catalan Number

### 🔍 Prime Numbers
- `isPrime(int num)` – Prime check
- `nextPrime(int num)` – Next prime
- `countPrimesUpTo(int n)` – Prime count up to n
- `listPrimesInRange(int start, int end)` – List primes in range
- `primeFactors(int n)` – Prime factorization

### 🔁 Sequences
- `fibonacci(int n)` – Fibonacci n-th term
- `arithmeticTerm(long a, long d, int n)` – Arithmetic n-th term
- `geometricTerm(long a, long r, int n)` – Geometric n-th term
- `sumArithmeticSeries(long a, long d, int n)` – Arithmetic sum
- `sumGeometricSeries(long a, long r, int n)` – Geometric sum
- `isFibonacci(long num)` – Fibonacci membership
- `sumFibonacci(int n)` – Fibonacci sum
- `generateArithmeticSequence(long a, long d, int n)` – Arithmetic list
- `generateGeometricSequence(long a, long r, int n)` – Geometric list
- `nthTriangularNumber(int n)` – Triangular number

### 📐 Geometry
- `circleArea(double radius)` – Circle area
- `circleCircumference(double radius)` – Circle circumference
- `triangleArea(double base, double height)` – Triangle area (base/height)
- `trianglePerimeter(double a, double b, double c)` – Triangle perimeter
- `heronArea(double a, double b, double c)` – Triangle area (Heron's formula)
- `pythagorean(double a, double b)` – Hypotenuse (Pythagorean theorem)
- `rectangleArea(double width, double height)` – Rectangle area
- `rectanglePerimeter(double width, double height)` – Rectangle perimeter
- `distance2D(double x1, double y1, double x2, double y2)` – 2D distance
- `distance3D(double x1, double y1, double z1, double x2, double y2, double z2)` – 3D distance

> ℹ️ All functions are annotated with `@Tool` and can be auto-discovered by any compliant MCP host at runtime.

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

This project is licensed under the **MIT License**.  
See the [`LICENSE`](./LICENSE) file for details.

© 2025 JUNG JE KIM  
Original author and maintainer: [JUNG JE KIM](https://github.com/key824999)

## Author

- Email: wjdwo951219@gmail.com
- GitHub: [@key824999](https://github.com/key824999)
