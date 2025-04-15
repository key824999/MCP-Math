package mcp.math.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class CombinatoricsTool {

    @Tool(description = "Returns the factorial of n. For example, factorial(5) returns 120.")
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    @Tool(description = "Returns n choose r (nCr), the number of combinations. For example, nCr(5, 2) returns 10.")
    public long nCr(int n, int r) {
        if (n < 0 || r < 0 || r > n) {
            throw new IllegalArgumentException("Invalid n or r");
        }

        return this.factorial(n) / (this.factorial(r) * this.factorial(n - r));
    }

    @Tool(description = "Returns n permute r (nPr), the number of permutations. For example, nPr(5, 2) returns 20.")
    public long nPr(int n, int r) {
        if (n < 0 || r < 0 || r > n) {
            throw new IllegalArgumentException("Invalid n or r");
        }

        return this.factorial(n) / this.factorial(n - r);
    }

    @Tool(description = "Returns the k-step factorial of n (multi-factorial). For example, multiFactorial(9, 2) returns 945.")
    public long multiFactorial(int n, int k) {
        if (n < 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid n or k");
        }

        long result = 1;

        for (int i = n; i > 0; i -= k) {
            result *= i;
        }

        return result;
    }

    @Tool(description = "Returns the n-th Catalan number. For example, catalanNumber(3) returns 5.")
    public long catalanNumber(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }

        return this.factorial(2 * n) / (this.factorial(n + 1) * this.factorial(n));
    }


}
