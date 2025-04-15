package mcp.math.tool;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SequenceToolTest {

    SequenceTool tool = new SequenceTool();

    @Test
    void testFibonacci() {
        assertEquals(0, tool.fibonacci(0));
        assertEquals(1, tool.fibonacci(1));
        assertEquals(5, tool.fibonacci(5));
        assertThrows(IllegalArgumentException.class, () -> tool.fibonacci(-1));
    }

    @Test
    void testArithmeticTerm() {
        assertEquals(14, tool.arithmeticTerm(2, 3, 5));
        assertThrows(IllegalArgumentException.class, () -> tool.arithmeticTerm(1, 1, 0));
    }

    @Test
    void testGeometricTerm() {
        assertEquals(54, tool.geometricTerm(2, 3, 4));
        assertThrows(IllegalArgumentException.class, () -> tool.geometricTerm(1, 1, 0));
    }

    @Test
    void testSumArithmeticSeries() {
        assertEquals(40, tool.sumArithmeticSeries(2, 3, 5));
        assertThrows(IllegalArgumentException.class, () -> tool.sumArithmeticSeries(1, 1, 0));
    }

    @Test
    void testSumGeometricSeries() {
        assertEquals(80, tool.sumGeometricSeries(2, 3, 4));
        assertEquals(10, tool.sumGeometricSeries(2, 1, 5)); // r == 1
        assertThrows(IllegalArgumentException.class, () -> tool.sumGeometricSeries(1, 2, 0));
    }

    @Test
    void testIsFibonacci() {
        assertTrue(tool.isFibonacci(21));
        assertFalse(tool.isFibonacci(4));
    }

    @Test
    void testSumFibonacci() {
        assertEquals(12, tool.sumFibonacci(5));
        assertThrows(IllegalArgumentException.class, () -> tool.sumFibonacci(0));
    }

    @Test
    void testGenerateArithmeticSequence() {
        assertEquals(List.of(2L, 5L, 8L, 11L, 14L), tool.generateArithmeticSequence(2, 3, 5));
        assertThrows(IllegalArgumentException.class, () -> tool.generateArithmeticSequence(1, 1, 0));
    }

    @Test
    void testGenerateGeometricSequence() {
        assertEquals(List.of(2L, 6L, 18L, 54L), tool.generateGeometricSequence(2, 3, 4));
        assertThrows(IllegalArgumentException.class, () -> tool.generateGeometricSequence(1, 1, 0));
    }

    @Test
    void testNthTriangularNumber() {
        assertEquals(15, tool.nthTriangularNumber(5));
        assertThrows(IllegalArgumentException.class, () -> tool.nthTriangularNumber(0));
    }

    @Test
    void testPerformance() {
        long start = System.nanoTime();

        for (int i = 1; i <= 100_000; i++) {
            tool.fibonacci(20);
            tool.sumFibonacci(20);
            tool.isFibonacci(i);
        }

        long duration = System.nanoTime() - start;

        assertTrue(duration < 1_000_000_000, "Performance test exceeded 1 second");
    }
} 