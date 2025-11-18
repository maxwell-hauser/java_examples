Consider the following class definition:
```java
public class Rectangle
{
	String shapeType; 
	int x;
	int y;
	double width;
	double height;
}
```
Below is the structure (sequence and number of bytes for each data member) of object $t$ created using:

```java
Rectangle t = new Rectangle("Table Top", 100, 100, 300, 200);
```
| Data Member | Type | Size (B)in bytes | Content |
|-------------|------|------------------|---------|
| shapeType   | String | 18 (2 bytes per character) | Table Top |
| x           | int | 4             | 100     |
| y           | int | 4             | 100     |
| width       | double | 8             | 300     |
| height      | double | 8             | 200     |
---

Below is the structure (sequence and number of bytes for each data member) of object $p$ created using:

```java
public class Polygon {
	private int xCenter;
	private int yCenter;
	private int radius;
	private int nSides;
	private int[] x;
	private int[] y;

    public Polygon() {
        this(0, 0, 100, 6);
    }

    public Polygon(int xc, int yc, int r, int n) {
        xCenter = xc;
        yCenter = yc;
        radius  = r;
        nSides = n;
        x = new int[n];
        y = new int[n];
    }
}
```
---
Below is the structure and content of object $p$ created as follows:

```java
Polygon p = new Polygon();
```

| Data member | Type | Size in bytes | Content |
|-------------|------|---------------|---------|
| xCenter     | int  | 4             | 0       |
| yCenter     | int  | 4             | 0       |
| radius      | int  | 4             | 100     |
| nSides      | int  | 4             | 6       |
| x           | int[]| 24            | [0,0,0,0,0,0] |
| y           | int[]| 24            | [0,0,0,0,0,0] |
---
Below is a paint method that draws a shape in the middle of the screen. It leaves 20 pixels from the borders and assumes that the title bar is 80 pixels high.

```java
public void paint(Graphics g) {
    int ww = (int) this.getWidth();
    int wh = (int) this.getHeight();  	
    switch (command) {
        case "Problem 3": {
            g.drawRect(20, 40, ww - 40, wh - 60);
            g.drawLine(20, 10 + wh/2, ww/2, 40);
            g.drawLine(ww/2, 40, ww - 20, 10 + wh/2);
            g.drawLine(ww - 20, 10 + wh/2, ww/2, wh - 20);
            g.drawLine(ww/2, wh - 20, 20, 10 + wh/2);
            g.drawLine(ww/2, 40, ww/2, wh - 20);
            g.drawLine(20, 10 + wh/2, ww - 20, 10 + wh/2);
            break;
        }
        
        case "Problem 4": {
            g.drawRect(20, 40, ww - 40, wh - 60);
            g.drawLine(20, (int)((1/(double)8) * wh + 10), ww - 20, (int)((1/(double)8) * wh + 10));
            g.drawLine(20, (int)((2/(double)8) * wh + 10), ww - 20, (int)((2/(double)8) * wh + 10));
            g.drawLine(20, (int)((3/(double)8) * wh + 10), ww - 20, (int)((3/(double)8) * wh + 10));
            g.drawLine(20, (int)((4/(double)8) * wh + 10), ww - 20, (int)((4/(double)8) * wh + 10));
            g.drawLine(20, (int)((5/(double)8) * wh + 10), ww - 20, (int)((5/(double)8) * wh + 10));
            g.drawLine(20, (int)((6/(double)8) * wh + 10), ww - 20, (int)((6/(double)8) * wh + 10));
            g.drawLine(20, (int)((7/(double)8) * wh + 10), ww - 20, (int)((7/(double)8) * wh + 10));
            
            g.drawLine((int)((1/(double)8) * ww), 40, (int)((1/(double)8) * ww), wh - 20);
            g.drawLine((int)((3/(double)8) * ww), 40, (int)((3/(double)8) * ww), wh - 20);
            g.drawLine((int)((5/(double)8) * ww), 40, (int)((5/(double)8) * ww), wh - 20);
            g.drawLine((int)((7/(double)8) * ww), 40, (int)((7/(double)8) * ww), wh - 20);
            break;
        }
        
        case "Problem 5": {
            for (int r = 20; r < wh - 40 && r < ww; r += 40) {
                g.drawOval(ww/2 - r/2, wh/2 + 15 - r/2, r, r);
            }
            break;
        }
    }

    // current width of window
    int ww = (int) this.getWidth(); 
    // current height of window
    int wh = (int) this.getHeight();
}
```
---
Below is a paint method that draws a grid based on the current width and height of the visible frame. It leaves 20 pixels space around the border.

```java
public void paint(Graphics g) {
    int ww = (int) this.getWidth();
    int wh = (int) this.getHeight();

    g.drawRect (20, 20, ww-40, wh-40);

    for (int i = 1; i <= 10; i++) {
        g.drawLine(20, 20 + i * (wh - 40) / 10, ww - 20, 20 + i * (wh - 40) / 10);
    }

    for (int j = 1; j <= 10; j++) {
        g.drawLine(20 + j * (ww - 40) / 10, 20, 20 + j * (ww - 40) / 10, wh - 20);
    }
}
```
---
Below is a paint method that draws concentric circles separated by 20 pixels based on the current width and height of the visible screen. It leaves 20 pixels on the borders of visible window and considers the relationship between width and height of window.

```java
public void paint(Graphics g) {
    int ww = (int) this.getWidth();
    int wh = (int) this.getHeight();

    int diameter = Math.min(ww, wh) - 40;

    for (int r = diameter; r > 0; r -= 40) {
        g.drawOval((ww - r) / 2, (wh - r) / 2, r, r);
    }
}
```
---
