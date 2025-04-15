package mcp.math.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class StatisticsTool {

    @Tool(description = "Returns the average (mean) of a list of numbers. For example, mean([1, 2, 3, 4, 5]) returns 3.")
    public double mean(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(Double.NaN);
    }

    @Tool(description = "Returns the median of a list of numbers. For example, median([3, 1, 4, 2, 5]) returns 3.")
    public double median(List<Double> numbers) {
        if (numbers.isEmpty()) {
            return Double.NaN;
        }

        List<Double> sorted = numbers.stream()
                .sorted()
                .toList();

        int mid = sorted.size() / 2;

        return sorted.size() % 2 == 0
                ? (sorted.get(mid - 1) + sorted.get(mid)) / 2.0
                : sorted.get(mid);
    }

    @Tool(description = "Returns the mode (most frequent value) of a list of numbers. If multiple values tie, returns the smallest. For example, mode([1, 2, 2, 3]) returns 2.")
    public double mode(List<Double> numbers) {
        return numbers.stream()
                .distinct()
                .max((a, b) -> Long.compare(
                        numbers.stream().filter(n -> n.equals(a)).count(),
                        numbers.stream().filter(n -> n.equals(b)).count()
                ))
                .orElse(Double.NaN);
    }

    @Tool(description = "Returns the range (max - min) of the numbers.")
    public double range(List<Double> numbers) {
        return Collections.max(numbers) - Collections.min(numbers);
    }

    @Tool(description = "Returns the sample variance of the numbers.")
    public double variance(List<Double> numbers) {
        double mean = mean(numbers);

        return numbers.stream()
                .mapToDouble(n -> Math.pow(n - mean, 2))
                .sum() / (numbers.size() - 1);
    }

    @Tool(description = "Returns the sample standard deviation of the numbers.")
    public double standardDeviation(List<Double> numbers) {
        return Math.sqrt(this.variance(numbers));
    }

    @Tool(description = "Returns the sum of the numbers.")
    public double sum(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    @Tool(description = "Returns the count of elements in the list.")
    public int count(List<Double> numbers) {
        return numbers.size();
    }
}
