# Java Examples Collection

A curated set of Java-focused study notes and code snippets in Markdown. Each file dives into core concepts with runnable snippets, informal explanations, and small exercises. Use this repo to review fundamentals quickly or copy/paste snippets into your IDE for experimentation.

## Contents

- [Example 1: Math, Arrays, and Algorithms](./java_example_1.md)
  - Integer square root (largest k where k² ≤ n)
  - Leibniz series approximation of pi
  - Standard deviation (one-pass average + variance computation)
  - Array reversal (in-place recursion and out-of-place copy)
  - 2D array (matrix) addition

- [Example 2: Memory, Graphics, and Coordinate Systems](./java_example_2.md)
  - Object layout thought exercise (fields, sizes, and values)
  - AWT/Swing paint methods: borders, grids, concentric circles
  - Practical window sizing: using current width/height

- [Example 3: OOP, Inheritance, and UML](./java_example_3.md)
  - Superclass `GeometricObject` with `color`, `filled`, and `dateCreated`
  - Subclasses: `Circle`, `Rectangle`, `Triangle` with area/perimeter
  - UML overviews for `Point` and `Polygon`
  - Access modifiers and package basics
  - Class hierarchy brainstorming for a university domain

## How To Use

- Browse the example files directly in GitHub or your editor.
- Copy a snippet into a Java class in your IDE to run it.
- For GUI/graphics snippets (AWT/Swing), create a minimal `JFrame` and override `paint(Graphics g)` to try them out.

## Quick Snippet Starters

Below are minimal starter shells for trying code quickly.

Create a file `Scratch.java`:

```java
public class Scratch {
    // Paste a method here, then call it from main
    public static void main(String[] args) {
        System.out.println(integerK(42)); // expect 6
    }

    public static int integerK(int n) {
        int k = 0;
        while ((k + 1) * (k + 1) <= n) {
            k++;
        }
        return k;
    }
}
```

Basic JFrame shell for painting examples:

```java
import javax.swing.*;
import java.awt.*;

public class PaintDemo extends JFrame {
    public PaintDemo() {
        setTitle("Paint Demo");
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
        g.drawRect(20, 40, ww - 40, wh - 60);
        // Add more drawing code here from java_example_2.md
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PaintDemo::new);
    }
}
```

## Notes and Tips

- For numeric methods (pi approximation, standard deviation), prefer `double` and cast early to avoid integer division.
- For array reversal and matrix addition, watch indices carefully and validate input sizes.
- For Swing painting, prefer measuring `getWidth()`/`getHeight()` inside `paint` or (better) `paintComponent` within a `JPanel` for flicker-free drawing.
- When extending a superclass, call `super(...)` in constructors to initialize inherited state.

## License

These notes and snippets are provided for learning and reference.
