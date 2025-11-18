# Java Examples Collection

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Active-success)
![License](https://img.shields.io/badge/License-MIT-blue)

A curated collection of Java study notes and code snippets organized in Markdown. Each file explores core concepts with runnable examples, clear explanations, and practical exercises. Perfect for quick reviews, interview prep, or learning Java fundamentals.

---

## Table of Contents

- [Examples Overview](#examples-overview)
- [Quick Start](#quick-start)
- [Usage Guide](#usage-guide)
- [Contributing](#contributing)

---

## Examples Overview

### [Example 1: Math, Arrays, and Algorithms](./java_example_1.md)

Fundamental algorithms and array operations:

- **Integer Square Root** - Find largest k where k² ≤ n
- **Pi Approximation** - Leibniz series implementation
- **Standard Deviation** - Statistical computation with arrays
- **Array Reversal** - Both recursive and iterative approaches
- **Matrix Addition** - 2D array operations

### [Example 2: Memory, Graphics, and Coordinate Systems](./java_example_2.md)

Object memory models and AWT/Swing graphics:

- **Memory Layout** - Object structure and byte allocation
- **Graphics Methods** - Paint methods for shapes and patterns
- **Responsive Drawing** - Dynamic grid and circle rendering
- **Window Sizing** - Working with current dimensions

### [Example 3: OOP, Inheritance, and UML](./java_example_3.md)

Object-oriented programming fundamentals:

- **Inheritance Hierarchy** - GeometricObject base class with Circle, Rectangle, Triangle
- **UML Diagrams** - Point and Polygon class structures
- **OOP Concepts** - Method overloading, overriding, and packages
- **Access Modifiers** - Complete reference table
- **Design Patterns** - University class hierarchy case study

---

## Quick Start

### Prerequisites

- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code with Java extensions)
- Or just `javac` and a text editor

### Running Examples

1. **Clone the repository**
   ```bash
   git clone https://github.com/maxwell-hauser/java_examples_gh.git
   cd java_examples_gh
   ```

2. **Browse examples in your editor or GitHub**

3. **Copy snippets into your IDE**
   - Create a new Java class
   - Paste the method from any example
   - Add a `main` method to test it

---

## Usage Guide

### Testing Numeric Methods

Create a test file `Test.java`:

```java
public class Test {
    public static void main(String[] args) {
        // Test integer square root
        System.out.println("Integer sqrt of 42: " + integerK(42)); // Expected: 6
        
        // Test pi approximation
        System.out.println("Pi (10 terms): " + piApprox(10));
        
        // Test standard deviation
        double[] data = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        System.out.println("Std dev: " + standardDeviation(data));
    }
    
    // Paste methods from java_example_1.md here
    public static int integerK(int n) {
        int k = 0;
        while ((k + 1) * (k + 1) <= n) {
            k++;
        }
        return k;
    }
    
    // Add other methods...
}
```

Compile and run:
```bash
javac Test.java
java Test
```

### Testing Graphics Methods

Create `GraphicsDemo.java`:

```java
import javax.swing.*;
import java.awt.*;

public class GraphicsDemo extends JFrame {
    public GraphicsDemo() {
        setTitle("Graphics Demo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int ww = getWidth();
        int wh = getHeight();
        
        // Paste paint logic from java_example_2.md here
        g.drawRect(20, 40, ww - 40, wh - 60);
        
        // Example: Draw concentric circles
        int diameter = Math.min(ww, wh) - 40;
        for (int r = diameter; r > 0; r -= 40) {
            g.drawOval((ww - r) / 2, (wh - r) / 2, r, r);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraphicsDemo::new);
    }
}
```

Compile and run:
```bash
javac GraphicsDemo.java
java GraphicsDemo
```

---

## Best Practices

### For Numeric Methods

- Use `double` for fractional calculations
- Cast integers early to avoid integer division: `1.0 / 3` not `1 / 3`
- Validate array indices and lengths before operations
- Consider edge cases: empty arrays, negative numbers, zero

### For Array Operations

- Watch index boundaries carefully (`0` to `length - 1`)
- Use `System.arraycopy()` for efficient copying
- Consider whether you need in-place or out-of-place operations
- Validate input array dimensions for 2D operations

### For Graphics Programming

- Override `paintComponent()` in `JPanel` (preferred over `paint()` in `JFrame`)
- Call `super.paintComponent(g)` first to clear the background
- Get dimensions inside paint method: `getWidth()`, `getHeight()`
- Use `SwingUtilities.invokeLater()` for thread-safe GUI creation
- Consider using `Graphics2D` for advanced rendering

### For OOP Design

- Always call `super(...)` in subclass constructors to initialize inherited state
- Use access modifiers intentionally: `private` for encapsulation, `protected` for inheritance
- Override `toString()` for debugging and logging
- Implement `equals()` and `hashCode()` together when needed
- Prefer composition over inheritance when appropriate

---

## Tips and Tricks

| Topic | Tip |
|-------|-----|
| **Pi Approximation** | More terms = better accuracy, but diminishing returns after ~1000 terms |
| **Array Reversal** | Recursive approach is elegant but uses stack space; iterative is more efficient |
| **Matrix Operations** | Always validate dimensions match before operations |
| **Swing Painting** | Use `repaint()` to trigger redraws; never call `paint()` directly |
| **Inheritance** | Use `instanceof` to check object types before casting |
| **Access Modifiers** | Default (no modifier) = package-private, not the same as `public` |

---

## Contributing

Contributions welcome! To add new examples or improve existing ones:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/new-example`
3. Add your example with clear comments and documentation
4. Ensure code follows Java conventions
5. Update README.md if adding new files
6. Submit a pull request

### Style Guidelines

- Use descriptive variable names
- Include JavaDoc comments for methods
- Add inline comments for complex logic
- Use consistent indentation (4 spaces)
- Include example usage in comments

---

## Resources

- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Java Language Specification](https://docs.oracle.com/javase/specs/)
- [Effective Java by Joshua Bloch](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- [Java Tutorials by Oracle](https://docs.oracle.com/javase/tutorial/)

---

## License

This project is provided for educational purposes. Feel free to use, modify, and share.

---

**Built with ❤️ for Java learners**
