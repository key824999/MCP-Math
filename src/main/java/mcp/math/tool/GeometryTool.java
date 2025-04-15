package mcp.math.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class GeometryTool {

    @Tool(description = "Returns the area of a circle with given radius. For example, circleArea(2) returns approximately 12.566.")
    public double circleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be >= 0");
        }

        return Math.PI * radius * radius;
    }

    @Tool(description = "Returns the area of a triangle given base and height. For example, triangleArea(10, 5) returns 25.")
    public double triangleArea(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Base and height must be >= 0");
        }

        return 0.5 * base * height;
    }

    @Tool(description = "Returns the area of a rectangle. For example, rectangleArea(4, 5) returns 20.")
    public double rectangleArea(double width, double height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height must be >= 0");
        }

        return width * height;
    }

    @Tool(description = "Returns the circumference of a circle. For example, circleCircumference(2) returns approximately 12.566.")
    public double circleCircumference(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be >= 0");
        }

        return 2 * Math.PI * radius;
    }

    @Tool(description = "Returns the perimeter of a rectangle. For example, rectanglePerimeter(4, 5) returns 18.")
    public double rectanglePerimeter(double width, double height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height must be >= 0");
        }

        return 2 * (width + height);
    }

    @Tool(description = "Returns the length of the hypotenuse of a right triangle given the other two sides. For example, pythagorean(3, 4) returns 5.")
    public double pythagorean(double a, double b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Side lengths must be >= 0");
        }

        return Math.sqrt(a * a + b * b);
    }

    @Tool(description = "Returns the perimeter of a triangle given the lengths of its three sides. For example, trianglePerimeter(3, 4, 5) returns 12.")
    public double trianglePerimeter(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("All side lengths must be >= 0");
        }

        return a + b + c;
    }

    @Tool(description = "Returns the area of a triangle using Heron's formula. For example, heronArea(3, 4, 5) returns 6.")
    public double heronArea(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("All side lengths must be >= 0");
        }

        double s = (a + b + c) / 2.0;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Tool(description = "Returns the Euclidean distance between two points in 2D space. For example, distance2D(0, 0, 3, 4) returns 5.")
    public double distance2D(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Tool(description = "Returns the Euclidean distance between two points in 3D space. For example, distance3D(0, 0, 0, 1, 2, 2) returns 3.")
    public double distance3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }
}
