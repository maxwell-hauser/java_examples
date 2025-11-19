import java.util.Arrays;
import java.util.Date;

/**
 * JavaExamplesDemo - Comprehensive demonstration of Java programming concepts
 * 
 * This class contains practical examples covering:
 * - Mathematical algorithms and approximations
 * - Array operations and statistical calculations
 * - Object-oriented programming with inheritance
 * - String manipulation and data processing
 */
public class JavaExamplesDemo {

    // ============================================================================
    // MATHEMATICAL ALGORITHMS
    // ============================================================================

    /**
     * Calculates the largest integer k where k^2 <= n
     * @param n the input number
     * @return the integer square root
     */
    public static int integerSquareRoot(int n) {
        int k = 0;
        while ((k + 1) * (k + 1) <= n) {
            k++;
        }
        return k;
    }

    /**
     * Approximates pi using the Leibniz series
     * pi = 4(1 - 1/3 + 1/5 - 1/7 + ... + 1/(2i-1) - 1/(2i+1))
     * @param iterations number of terms in the series
     * @return approximation of pi
     */
    public static double piApproximation(int iterations) {
        double pi = 1;
        for (int i = 1; i < iterations; i++) {
            if (i % 2 != 0) {
                pi -= (1.0 / (2 * i + 1));
            } else {
                pi += (1.0 / (2 * i + 1));
            }
        }
        return 4 * pi;
    }

    /**
     * Calculates factorial using iteration
     * @param n the number
     * @return n! (factorial of n)
     */
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // ============================================================================
    // ARRAY OPERATIONS AND STATISTICS
    // ============================================================================

    /**
     * Calculates the standard deviation of an array of numbers
     * @param numbers array of values
     * @return standard deviation
     */
    public static double standardDeviation(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0.0;
        }

        // Calculate mean
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        double mean = sum / numbers.length;

        // Calculate variance
        double variance = 0;
        for (double num : numbers) {
            variance += Math.pow(num - mean, 2);
        }
        variance /= numbers.length;

        return Math.sqrt(variance);
    }

    /**
     * Finds the maximum value in an array
     * @param numbers array of values
     * @return maximum value
     */
    public static double findMax(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    /**
     * Finds the minimum value in an array
     * @param numbers array of values
     * @return minimum value
     */
    public static double findMin(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        double min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    /**
     * Reverses an array in place
     * @param arr array to reverse
     */
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // ============================================================================
    // STRING OPERATIONS
    // ============================================================================

    /**
     * Checks if a string is a palindrome
     * @param str input string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Counts vowels in a string
     * @param str input string
     * @return number of vowels
     */
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // ============================================================================
    // GEOMETRIC OBJECT CLASSES (OOP DEMONSTRATION)
    // ============================================================================

    /**
     * Base class for geometric objects demonstrating inheritance
     */
    public static class GeometricObject {
        private String color;
        private boolean filled;
        private Date dateCreated;

        public GeometricObject() {
            this.color = "white";
            this.filled = false;
            this.dateCreated = new Date();
        }

        public GeometricObject(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
            this.dateCreated = new Date();
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isFilled() {
            return filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        @Override
        public String toString() {
            return "Created on " + dateCreated + "\nColor: " + color + 
                   "\nFilled: " + filled;
        }
    }

    /**
     * Circle class extending GeometricObject
     */
    public static class Circle extends GeometricObject {
        private double radius;

        public Circle() {
            this.radius = 1.0;
        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public Circle(double radius, String color, boolean filled) {
            super(color, filled);
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return "Circle: radius=" + radius + "\n" + super.toString();
        }
    }

    /**
     * Rectangle class extending GeometricObject
     */
    public static class Rectangle extends GeometricObject {
        private double width;
        private double height;

        public Rectangle() {
            this.width = 1.0;
            this.height = 1.0;
        }

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public Rectangle(double width, double height, String color, boolean filled) {
            super(color, filled);
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getArea() {
            return width * height;
        }

        public double getPerimeter() {
            return 2 * (width + height);
        }

        @Override
        public String toString() {
            return "Rectangle: width=" + width + ", height=" + height + "\n" + super.toString();
        }
    }

    // ============================================================================
    // MAIN METHOD - DEMONSTRATION
    // ============================================================================

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║       Java Programming Examples Demonstration          ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // Mathematical Algorithms
        System.out.println("═══ MATHEMATICAL ALGORITHMS ═══\n");
        
        int num = 50;
        System.out.println("Integer square root of " + num + ": " + integerSquareRoot(num));
        System.out.println("Expected: 7 (since 7² = 49 ≤ 50 < 8² = 64)\n");

        int iterations = 1000000;
        System.out.println("Pi approximation (" + iterations + " iterations): " + piApproximation(iterations));
        System.out.println("Actual value of Pi: " + Math.PI + "\n");

        int factNum = 10;
        System.out.println("Factorial of " + factNum + ": " + factorial(factNum) + "\n");

        // Array Operations
        System.out.println("═══ ARRAY OPERATIONS & STATISTICS ═══\n");
        
        double[] testData = {12.5, 15.3, 18.7, 22.1, 14.9, 16.8, 20.3};
        System.out.println("Test data: " + Arrays.toString(testData));
        System.out.printf("Standard deviation: %.4f%n", standardDeviation(testData));
        System.out.printf("Maximum value: %.2f%n", findMax(testData));
        System.out.printf("Minimum value: %.2f%n\n", findMin(testData));

        int[] reverseTest = {1, 2, 3, 4, 5};
        System.out.println("Before reverse: " + Arrays.toString(reverseTest));
        reverseArray(reverseTest);
        System.out.println("After reverse:  " + Arrays.toString(reverseTest) + "\n");

        // String Operations
        System.out.println("═══ STRING OPERATIONS ═══\n");
        
        String[] testStrings = {"racecar", "hello", "A man, a plan, a canal: Panama"};
        for (String str : testStrings) {
            System.out.println("\"" + str + "\" is " + 
                (isPalindrome(str) ? "" : "NOT ") + "a palindrome");
        }
        System.out.println();

        String vowelTest = "Hello World Programming";
        System.out.println("\"" + vowelTest + "\" contains " + 
            countVowels(vowelTest) + " vowels\n");

        // Object-Oriented Programming
        System.out.println("═══ OBJECT-ORIENTED PROGRAMMING ═══\n");
        
        Circle circle = new Circle(5.0, "red", true);
        System.out.println(circle);
        System.out.printf("Area: %.2f%n", circle.getArea());
        System.out.printf("Perimeter: %.2f%n\n", circle.getPerimeter());

        Rectangle rectangle = new Rectangle(4.0, 6.0, "blue", false);
        System.out.println(rectangle);
        System.out.printf("Area: %.2f%n", rectangle.getArea());
        System.out.printf("Perimeter: %.2f%n\n", rectangle.getPerimeter());

        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║            Demonstration Complete!                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
