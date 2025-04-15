package mcp.math.tool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathToolTest {

    BasicMathTool tool = new BasicMathTool();

    @Test
    void testSqrt() {
        assertEquals(3.0, tool.sqrt(9.0), 0.0001);
        assertEquals(0.0, tool.sqrt(0.0), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.sqrt(-1.0));
    }

    @Test
    void testSquare() {
        assertEquals(16.0, tool.square(4.0), 0.0001);
        assertEquals(0.0, tool.square(0.0), 0.0001);
        assertEquals(9.0, tool.square(-3.0), 0.0001);
    }

    @Test
    void testPow() {
        assertEquals(8.0, tool.pow(2.0, 3.0), 0.0001);
        assertEquals(1.0, tool.pow(0.0, 0.0), 0.0001); // by convention
        assertEquals(0.0, tool.pow(0.0, 5.0), 0.0001);

        double result = tool.pow(2.0, 1000.0);
        assertTrue(Double.isFinite(result));
        assertTrue(result > 1e300);
    }

    @Test
    void testAbs() {
        assertEquals(5.0, tool.abs(-5.0), 0.0001);
        assertEquals(5.0, tool.abs(5.0), 0.0001);
        assertEquals(0.0, tool.abs(0.0), 0.0001);
    }

    @Test
    void testLog() {
        assertEquals(1.0, tool.log(Math.E), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.log(-1.0));
        assertThrows(IllegalArgumentException.class, () -> tool.log(0.0));
    }

    @Test
    void testLog10() {
        assertEquals(2.0, tool.log10(100.0), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.log10(-1.0));
        assertThrows(IllegalArgumentException.class, () -> tool.log10(0.0));
    }

    @Test
    void testSin() {
        assertEquals(1.0, tool.sin(Math.PI / 2), 0.0001);
        assertEquals(0.0, tool.sin(0), 0.0001);
    }

    @Test
    void testCos() {
        assertEquals(1.0, tool.cos(0), 0.0001);
        assertEquals(0.0, tool.cos(Math.PI / 2), 0.0001);
    }

    @Test
    void testTan() {
        assertEquals(1.0, tool.tan(Math.PI / 4), 0.0001);
        assertTrue(Double.isFinite(tool.tan(Math.PI / 4))); // π/4 is a regular point with finite tangent
        assertTrue(tool.tan(Math.PI / 2) > 1_000_000); // tan(π/2) approaches infinity (vertical asymptote)
    }

    @Test
    void testRound() {
        assertEquals(6, tool.round(5.6));
        assertEquals(5, tool.round(5.4));
        assertEquals(0, tool.round(0.0));
    }

    @Test
    void testMax() {
        assertEquals(10.0, tool.max(10.0, 5.0), 0.0001);
        assertEquals(10.0, tool.max(10.0, 10.0), 0.0001);
    }

    @Test
    void testMin() {
        assertEquals(3.0, tool.min(3.0, 9.0), 0.0001);
        assertEquals(3.0, tool.min(3.0, 3.0), 0.0001);
    }

    @Test
    void testPerformance() {
        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            tool.sqrt(256);
            tool.square(16);
            tool.pow(2, 10);
        }

        long duration = System.nanoTime() - start;

        assertTrue(duration < 1_000_000_000, "Performance test exceeded 1 second");
    }
}
