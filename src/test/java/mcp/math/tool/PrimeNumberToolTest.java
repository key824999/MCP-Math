package mcp.math.tool;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumberToolTest {

    PrimeNumberTool tool = new PrimeNumberTool();

    @Test
    void testIsPrime() {
        assertTrue(tool.isPrime(2));
        assertTrue(tool.isPrime(3));
        assertFalse(tool.isPrime(4));
        assertFalse(tool.isPrime(1));
        assertFalse(tool.isPrime(0));
        assertFalse(tool.isPrime(-7));
    }

    @Test
    void testNextPrime() {
        assertEquals(2, tool.nextPrime(0));
        assertEquals(5, tool.nextPrime(4));
        assertEquals(101, tool.nextPrime(100));
    }

    @Test
    void testCountPrimesUpTo() {
        assertEquals(4, tool.countPrimesUpTo(10)); // 2, 3, 5, 7
        assertEquals(0, tool.countPrimesUpTo(1));
    }

    @Test
    void testListPrimesInRange() {
        List<Integer> primes = tool.listPrimesInRange(10, 20);
        assertEquals(List.of(11, 13, 17, 19), primes);
        assertTrue(tool.listPrimesInRange(0, 1).isEmpty());
    }

    @Test
    void testPrimeFactors() {
        assertEquals(List.of(2, 2, 3), tool.primeFactors(12));
        assertEquals(List.of(5, 5), tool.primeFactors(25));
        assertThrows(IllegalArgumentException.class, () -> tool.primeFactors(0));
        assertThrows(IllegalArgumentException.class, () -> tool.primeFactors(-10));
        assertThrows(IllegalArgumentException.class, () -> tool.primeFactors(10_000_001));
    }

    @Test
    void testPerformance() {
        long start = System.nanoTime();

        for (int i = 0; i < 10_000; i++) {
            tool.isPrime(i);
            tool.countPrimesUpTo(100);
            tool.nextPrime(i);
        }

        long duration = System.nanoTime() - start;

        assertTrue(duration < 1_000_000_000, "Performance test exceeded 1 second");
    }
}
