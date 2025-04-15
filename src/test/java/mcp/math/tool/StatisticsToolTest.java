package mcp.math.tool;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StatisticsToolTest {

    StatisticsTool tool = new StatisticsTool();

    @Test
    void testMean() {
        List<Double> data = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        assertEquals(3.0, tool.mean(data), 0.0001);
        assertTrue(Double.isNaN(tool.mean(Collections.emptyList())));
    }

    @Test
    void testMedian() {
        assertEquals(3.0, tool.median(Arrays.asList(3.0, 1.0, 4.0, 2.0, 5.0)), 0.0001);
        assertEquals(3.5, tool.median(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)), 0.0001);
        assertTrue(Double.isNaN(tool.median(Collections.emptyList())));
    }

    @Test
    void testMode() {
        assertEquals(2.0, tool.mode(Arrays.asList(1.0, 2.0, 2.0, 3.0)));
        assertEquals(1.0, tool.mode(Arrays.asList(1.0, 1.0, 2.0, 2.0))); // smallest mode when tie
        assertTrue(Double.isNaN(tool.mode(Collections.emptyList())));
    }

    @Test
    void testRange() {
        assertEquals(4.0, tool.range(Arrays.asList(1.0, 2.0, 3.0, 5.0)));
    }

    @Test
    void testVariance() {
        List<Double> data = Arrays.asList(2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0);
        assertEquals(4.5714, tool.variance(data), 0.0001);
    }

    @Test
    void testStandardDeviation() {
        List<Double> data = Arrays.asList(2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0);
        assertEquals(2.138, tool.standardDeviation(data), 0.01);
    }

    @Test
    void testSum() {
        assertEquals(15.0, tool.sum(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0)), 0.0001);
        assertEquals(0.0, tool.sum(Collections.emptyList()), 0.0001);
    }

    @Test
    void testCount() {
        assertEquals(5, tool.count(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0)));
        assertEquals(0, tool.count(Collections.emptyList()));
    }

    @Test
    void testPerformance() {
        List<Double> largeData = Collections.nCopies(1_000_000, 3.0);

        long start = System.nanoTime();

        tool.mean(largeData);
        tool.variance(largeData);
        tool.standardDeviation(largeData);
        tool.sum(largeData);

        long duration = System.nanoTime() - start;

        assertTrue(duration < 1_000_000_000, "Performance test exceeded 1 second");
    }
}
