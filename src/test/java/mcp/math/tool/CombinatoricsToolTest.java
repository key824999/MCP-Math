package mcp.math.tool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombinatoricsToolTest {

    CombinatoricsTool tool = new CombinatoricsTool();

    @Test
    void testFactorial() {
        assertEquals(1, tool.factorial(0));
        assertEquals(1, tool.factorial(1));
        assertEquals(120, tool.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> tool.factorial(-1));
    }

    @Test
    void testNCr() {
        assertEquals(10, tool.nCr(5, 2));
        assertEquals(1, tool.nCr(10, 0));
        assertEquals(1, tool.nCr(10, 10));
        assertThrows(IllegalArgumentException.class, () -> tool.nCr(-1, 2));
        assertThrows(IllegalArgumentException.class, () -> tool.nCr(5, -2));
        assertThrows(IllegalArgumentException.class, () -> tool.nCr(3, 5));
    }

    @Test
    void testNPr() {
        assertEquals(20, tool.nPr(5, 2));
        assertEquals(1, tool.nPr(3, 0));
        assertThrows(IllegalArgumentException.class, () -> tool.nPr(-1, 2));
        assertThrows(IllegalArgumentException.class, () -> tool.nPr(5, -2));
        assertThrows(IllegalArgumentException.class, () -> tool.nPr(3, 5));
    }

    @Test
    void testMultiFactorial() {
        assertEquals(945, tool.multiFactorial(9, 2));
        assertEquals(6, tool.multiFactorial(3, 1));
        assertThrows(IllegalArgumentException.class, () -> tool.multiFactorial(-1, 2));
        assertThrows(IllegalArgumentException.class, () -> tool.multiFactorial(5, 0));
    }

    @Test
    void testCatalanNumber() {
        assertEquals(5, tool.catalanNumber(3));
        assertEquals(132, tool.catalanNumber(6));
        assertThrows(IllegalArgumentException.class, () -> tool.catalanNumber(-1));
    }

    @Test
    void testPerformance() {
        long start = System.nanoTime();

        for (int i = 0; i < 100_000; i++) {
            tool.factorial(10);
            tool.nCr(10, 5);
            tool.nPr(10, 5);
        }

        long duration = System.nanoTime() - start;

        assertTrue(duration < 1_000_000_000, "Performance test exceeded 1 second");
    }
}
