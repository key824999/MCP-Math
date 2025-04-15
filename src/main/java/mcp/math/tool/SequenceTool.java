package mcp.math.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SequenceTool {

    @Tool(description = "Returns the n-th number in the Fibonacci sequence. For example, fibonacci(5) returns 5.")
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }

        if (n <= 1) {
            return n;
        }

        long a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    @Tool(description = "Returns the n-th term of an arithmetic sequence. For example, arithmeticTerm(2, 3, 5) returns 14.")
    public long arithmeticTerm(long a, long d, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        return a + (n - 1) * d;
    }

    @Tool(description = "Returns the n-th term of a geometric sequence. For example, geometricTerm(2, 3, 4) returns 54.")
    public long geometricTerm(long a, long r, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        return (long) (a * Math.pow(r, n - 1));
    }

    @Tool(description = "Returns the sum of the first n terms in an arithmetic sequence. For example, sumArithmeticSeries(2, 3, 5) returns 40.")
    public long sumArithmeticSeries(long a, long d, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        return n * (2 * a + (n - 1) * d) / 2;
    }

    @Tool(description = "Returns the sum of the first n terms in a geometric sequence. For example, sumGeometricSeries(2, 3, 4) returns 80.")
    public long sumGeometricSeries(long a, long r, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        if (r == 1) {
            return a * n;
        }

        return (long) (a * (1 - Math.pow(r, n)) / (1 - r));
    }

    @Tool(description = "Returns true if the number is a Fibonacci number. For example, isFibonacci(21) returns true.")
    public boolean isFibonacci(long num) {
        long x1 = 5 * num * num + 4;
        long x2 = 5 * num * num - 4;

        return this.isPerfectSquare(x1) || this.isPerfectSquare(x2);
    }

    private boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);

        return sqrt * sqrt == n;
    }

    @Tool(description = "Returns the sum of the first n Fibonacci numbers. For example, sumFibonacci(5) returns 12.")
    public long sumFibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        return this.fibonacci(n + 2) - 1;
    }

    @Tool(description = "Returns a list containing the first n terms of an arithmetic sequence. For example, generateArithmeticSequence(2, 3, 5) returns [2, 5, 8, 11, 14].")
    public List<Long> generateArithmeticSequence(long a, long d, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        List<Long> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sequence.add(a + i * d);
        }

        return sequence;
    }

    @Tool(description = "Returns a list containing the first n terms of a geometric sequence. For example, generateGeometricSequence(2, 3, 4) returns [2, 6, 18, 54].")
    public List<Long> generateGeometricSequence(long a, long r, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        List<Long> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sequence.add((long) (a * Math.pow(r, i)));
        }

        return sequence;
    }

    @Tool(description = "Returns the n-th triangular number (sum of 1 through n). For example, nthTriangularNumber(5) returns 15.")
    public long nthTriangularNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        return (long) n * (n + 1) / 2;
    }
}
