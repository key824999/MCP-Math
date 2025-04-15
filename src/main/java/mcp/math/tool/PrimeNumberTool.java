package mcp.math.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrimeNumberTool {

    @Tool(description = "Returns true if the given number is a prime. For example, isPrime(7) returns true.")
    public boolean isPrime(int num) {
        if (num <= 1 || (num % 2 == 0 && num != 2)) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Tool(description = "Returns the next prime number greater than the given number. For example, nextPrime(10) returns 11.")
    public int nextPrime(int num) {
        int candidate = num + 1;

        while (!this.isPrime(candidate)) {
            candidate++;
        }

        return candidate;
    }

    @Tool(description = "Returns the number of prime numbers from 2 up to n (inclusive). For example, countPrimesUpTo(10) returns 4.")
    public int countPrimesUpTo(int n) {
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (this.isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    @Tool(description = "Returns a list of prime numbers between start and end (inclusive). For example, listPrimesInRange(10, 20) returns [11, 13, 17, 19].")
    public List<Integer> listPrimesInRange(int start, int end) {
        List<Integer> primes = new ArrayList<>();

        for (int i = Math.max(2, start); i <= end; i++) {
            if (this.isPrime(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    @Tool(description = "Returns the list of prime factors of a number. For example, primeFactors(12) returns [2, 2, 3].")
    public List<Integer> primeFactors(int n) {
        final int MAX_INPUT = 10_000_000; // upper limit for performance and safety

        if (n <= 1 || n > MAX_INPUT) {
            throw new IllegalArgumentException("n must be > 1 and <= " + MAX_INPUT);
        }

        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }
} 
