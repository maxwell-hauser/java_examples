# Java Example 1: Math, Arrays, and Algorithms

[← Back to README](./README.md)

---

## Integer Square Root

Below is a method that, given an integer, $n$, returns the largest integer, $k$, where $k^2 \leq n$.

```java
public static int integerK(int n) {
    int k = 0;
    while ((k + 1)*(k + 1) <= n)
    {
        k++;
    }
    return k;
}
```

---

## Pi Approximation (Leibniz Series)

You can approximate $π$ by using the following series:

$π = 4(1 - 1/3 + 1/5 - 1/7 + ... + 1/(2i - 1) - 1/(2i + 1))$

Below is a method that, given an integer, $i$, returns the $ith$ approximation of $π$.

```java
public static double piApprox(int j) {
    double pi = 1;
    for (int i = 1; i < j; i++) {
        if (i % 2 != 0) {
            pi -= (1/(double)(2*i+1));
        } else {
            pi += (1/(double)(2*i+1));
        }
    }
    return 4*pi;
}
```

---

## Standard Deviation

Below is a method, $standardDeviation$, that, given an array of fractional numbers, returns the standard deviation of the numbers using the following formula.

Where $μ$ is the average of the array:

```java
public static double standardDeviation(double[] s) {
    double sumArray = 0.0;
    for(int i = 0; i < s.length; i++) {
        sumArray += s[i];
    }
    
    double average = sumArray/s.length;
    double sumStandardDeviation = 0.0;
    for(int i = 0; i < s.length; i++) {
        sumStandardDeviation += Math.pow(s[i] - average, 2);
    }
		
    double standardDeviation = Math.pow((sumStandardDeviation/(s.length)), 0.5);
    return standardDeviation;
}
```

---

## Array Reversal (Recursive)

Below is a method, $reverseArray1$, that, given an array of integers, returns a second array of integers containing the elements of the input argument in reverse order.

```java
public static int[] reverseArray1(int[] s) {
    if (s.length == 2) {
        int s1 = s[0];
        s[0] = s[1];
        s[1] = s1;
    }
    
    else if (s.length > 2) {
        int s1 = s[0];
        s[0] = s[s.length-1];
        s[s.length-1] = s1;
        
        int[] z = new int[s.length-2];
        System.arraycopy(s, 1, z, 0, s.length-2);
        reverseArray1(z);
        System.arraycopy(z, 0, s, 1, z.length);
    }
    return s;
}
```

---

## Array Reversal (Iterative)

Below is a variation of method $reverseArray1$, $reverseArray2$, that, given an array of integers, returns a second array of integers containing the elements of the input argument in reverse order.

```java
public static int[] reverseArray2(int[] s0) {
    int[] s1 = new int[s0.length];
    for(int i = 0; i < s0.length; i++) {
        System.arraycopy(s0, s0.length-1-i, s1, i, 1);
    }
    return s1;
}
```

---

## 2D Array Addition (Matrix Sum)

Below is a method, $addArray$, that, given two 2D arrays, $a$ and $b$, returns the sum of the two arrays, $c$, where:
$c_{ij} = a_{ij} + b_{ij}$.

```java
public static double[][] addArray(double[][] a, double[][] b) {
    double[][] c = new double[a.length][a[0].length];
    for (int row = 0; row < a.length; row++) {
        for (int col = 0; col < a[row].length; col++) {
            c[row][col] = a[row][col] + b[row][col];
        }
    }
    return c;
}
```