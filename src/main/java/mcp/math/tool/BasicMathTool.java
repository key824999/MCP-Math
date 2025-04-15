package mcp.math.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class BasicMathTool {

    @Tool(description = "Returns the square root of the given number. For example, sqrt(9) returns 3.")
    public double sqrt(double num) {
        return Math.sqrt(num);
    }

    @Tool(description = "Calculates the square of the given number. For example, square(4) returns 16.")
    public double square(double num) {
        return Math.pow(num, 2);
    }

    @Tool(description = "Raises a number to the power of n. For example, pow(2, 3) returns 8.")
    public double pow(double num, double n) {
        return Math.pow(num, n);
    }

    @Tool(description = "Returns the absolute value of a number. For example, abs(-5) returns 5.")
    public double abs(double num) {
        return Math.abs(num);
    }

    @Tool(description = "Returns the natural logarithm (base e) of a number. For example, log(2.718) returns approximately 1.")
    public double log(double num) {
        return Math.log(num);
    }

    @Tool(description = "Returns the base-10 logarithm of a number. For example, log10(100) returns 2.")
    public double log10(double num) {
        return Math.log10(num);
    }

    @Tool(description = "Returns the sine of an angle in radians. For example, sin(Math.PI/2) returns 1.")
    public double sin(double radians) {
        return Math.sin(radians);
    }

    @Tool(description = "Returns the cosine of an angle in radians. For example, cos(0) returns 1.")
    public double cos(double radians) {
        return Math.cos(radians);
    }

    @Tool(description = "Returns the tangent of an angle in radians. For example, tan(Math.PI/4) returns approximately 1.")
    public double tan(double radians) {
        return Math.tan(radians);
    }

    @Tool(description = "Rounds the given number to the nearest integer. For example, round(4.7) returns 5.")
    public long round(double num) {
        return Math.round(num);
    }

    @Tool(description = "Returns the maximum of two numbers. For example, max(10, 15) returns 15.")
    public double max(double a, double b) {
        return Math.max(a, b);
    }

    @Tool(description = "Returns the minimum of two numbers. For example, min(10, 15) returns 10.")
    public double min(double a, double b) {
        return Math.min(a, b);
    }

    @Tool(description = "Returns a modulo b. For example, mod(10, 3) returns 1.")
    public double mod(double a, double b) {
        return a % b;
    }

    @Tool(description = "Returns the smallest integer greater than or equal to the given number. For example, ceil(4.2) returns 5.")
    public double ceil(double num) {
        return Math.ceil(num);
    }

    @Tool(description = "Returns the greatest integer less than or equal to the given number. For example, floor(4.8) returns 4.")
    public double floor(double num) {
        return Math.floor(num);
    }

    @Tool(description = "Returns the greatest common divisor of two integers. For example, gcd(12, 18) returns 6.")
    public int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    @Tool(description = "Returns the least common multiple of two integers. For example, lcm(4, 6) returns 12.")
    public int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    @Tool(description = "Converts degrees to radians. For example, degToRad(180) returns π.")
    public double degToRad(double degrees) {
        return Math.toRadians(degrees);
    }

    @Tool(description = "Converts radians to degrees. For example, radToDeg(π) returns 180.")
    public double radToDeg(double radians) {
        return Math.toDegrees(radians);
    }

    @Tool(description = "Returns the factorial of a non-negative integer. For example, factorial(5) returns 120.")
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial only defined for non-negative integers.");
        }

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
