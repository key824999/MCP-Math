package mcp.math.tool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GeometryToolTest {

    GeometryTool tool = new GeometryTool();

    @Test
    void testCircleArea() {
        assertEquals(Math.PI * 4, tool.circleArea(2), 0.0001);
        assertEquals(0.0, tool.circleArea(0), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.circleArea(-1));
    }

    @Test
    void testTriangleArea() {
        assertEquals(25.0, tool.triangleArea(10, 5), 0.0001);
        assertEquals(0.0, tool.triangleArea(0, 10), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.triangleArea(-1, 5));
    }

    @Test
    void testRectangleArea() {
        assertEquals(20.0, tool.rectangleArea(4, 5), 0.0001);
        assertEquals(0.0, tool.rectangleArea(0, 5), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.rectangleArea(3, -1));
    }

    @Test
    void testCircleCircumference() {
        assertEquals(2 * Math.PI * 3, tool.circleCircumference(3), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.circleCircumference(-1));
    }

    @Test
    void testRectanglePerimeter() {
        assertEquals(18.0, tool.rectanglePerimeter(4, 5), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.rectanglePerimeter(4, -2));
    }

    @Test
    void testPythagorean() {
        assertEquals(5.0, tool.pythagorean(3, 4), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.pythagorean(-3, 4));
    }

    @Test
    void testTrianglePerimeter() {
        assertEquals(12.0, tool.trianglePerimeter(3, 4, 5), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.trianglePerimeter(-3, 4, 5));
    }

    @Test
    void testHeronArea() {
        assertEquals(6.0, tool.heronArea(3, 4, 5), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> tool.heronArea(-3, 4, 5));
    }

    @Test
    void testDistance2D() {
        assertEquals(5.0, tool.distance2D(0, 0, 3, 4), 0.0001);
    }

    @Test
    void testDistance3D() {
        assertEquals(Math.sqrt(9), tool.distance3D(0, 0, 0, 1, 2, 2), 0.0001);
    }

    @Test
    void testPerformance() {
        long start = System.nanoTime();

        for (int i = 0; i < 100_000; i++) {
            tool.circleArea(10);
            tool.pythagorean(3, 4);
            tool.heronArea(3, 4, 5);
        }

        long duration = System.nanoTime() - start;

        assertTrue(duration < 1_000_000_000, "Performance test exceeded 1 second");
    }
}
