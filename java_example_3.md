# Java Example 3: OOP, Inheritance, and UML

[← Back to README](./README.md)

---

## GeometricObject Hierarchy

### Base Class: GeometricObject

Consider the below inheritance hierarchy that exhibits the following behaviors:
1. The default color of the created object is "white."
2. The default filled status is false.

3. The class stores the date when the object was created.

4. Creates a GeometricObject.

5. Creates a GeometricObject with specified color and filled value.
6. Returns the color.
7. Sets new color.
8. Returns the filled property.
9. Sets a new filled property.
10. Returns the dateCreated.
11. Returns a string representation of this object.

```java
import java.util.Date;

public class GeometricObject {
    private String color;
    private boolean filled;
    private Date dateCreated;

    public GeometricObject() {
        color = "white";
        filled = false;
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        dateCreated = new Date();
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

    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}
```

### Subclasses

Classes Circle, Rectangle and Triangle inherit from GeometricObject.

#### Circle
```java
public class Circle extends GeometricObject {
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
}
```

#### Rectangle
```java
public class Rectangle extends GeometricObject {
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
}
```

#### Triangle
```java
public class Triangle extends GeometricObject {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle() {
        this.x1 = 0.0;
        this.y1 = 0.0;
        this.x2 = 1.0;
        this.y2 = 0.0;
        this.x3 = 0.0;
        this.y3 = 1.0;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, String color, boolean filled) {
        super(color, filled);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public double getArea() {
        return Math.abs((x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2)) / 2.0);
    }

    public double getPerimeter() {
        double side1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double side2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double side3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        return side1 + side2 + side3;
    }
}
```

---

## UML Diagrams

### Point and Polygon Classes

UML diagram for classes Point and Polygon:
```
-------------------------------
Point
-------------------------------
-x: double
-y: double
-z: double
-------------------------------
+Point(): void
+Point(x: double, y: double, z: double): void

+getX(): double
+setX(x: double): void

+getY(): double
+setY(y: double): void

+getZ(): double
+setZ(z: double): void

+distance(p: Point): double
+toString(): String
-------------------------------
```
```
-------------------------------
Polygon
-------------------------------
+Polygon()
+Polygon(Point)

+addPoint(Point): void
+getPoint(int): Point
+setPoint(int, Point): void
+removePoint(int): Point

+size(): int
+perimeter(): double
+area(): double
+toString(): String
-------------------------------
```

---

## OOP Concepts Q&A

### What is the purpose of defining a superclass?

A superclass is defined to encapsulate common attributes and behaviors that can be shared among multiple subclasses. It promotes code reusability, establishes a hierarchical relationship, and allows for polymorphism, enabling objects of different subclasses to be treated as objects of the superclass type.

### How do you define a subclass of class X?

By using “extends” keyword.

```java
public class Subclass extends Superclass
{
    // subclass body
}
```
Subclass is a subclass of Superclass.

### How do you explicitly invoke a superclass constructor?

By using “super” keyword.

```java
public class Student extends Person
{
    private String branch;
    private int Student_id;
    
    public Student()
    {
        this("Unknown", 0, "Unknown", 0);
    }

    public Student(String name, int age, String branch, int Student_id)
    {
        super(name, age); // invokes superclass constructor
        this.branch = branch;
        this.Student_id = Student_id;
    }
}
```

---

### What is method overloading?

When two or more methods in the same class have the same name but different parameters (different type, number, or both). It allows methods to perform similar functions with different types or numbers of inputs.

### What is method overriding?

When you create a specific implementation of a method that is already provided by its superclass, parent class, or default libraries.

You could implement your own toString() and it will override the predefined toString() method provided by the java libraries.

### What is a package?

A package is a namespace that organizes a set of related classes and interfaces. It helps to avoid name conflicts, control access, and manage the organization of classes in large projects.

Given the following definition:
```java
package p1;
public class Z {
    int a;
    public double b;
    private float c;
    protected String d;
}
```

Is `a` accessible from classes inside package `p1`?

Yes, because `a` is an unspecified int, it becomes package private.

Is `b` accessible from classes outside package `p1`?

Yes, because it is public.

Is `c` accessible from classes inside package `p1`?

No, since `c` is a private variable it is accessible only by the class it is within.

Is `d` accessible from classes outside package `p1`?

Yes and no, since `d` is a protected variable, it is accessible by the package it is within and by the subclass(es) that inherit(s) `Z`.

---

## Access Modifiers Reference

### Access Specifiers Summary
| Access Specifier | Within Class | Within Package | Subclass (same package) | Subclass (different package) | Outside Package |
|------------------|--------------|----------------|------------------------|------------------------------|-----------------|
| private          | Yes          | No             | No                     | No                           | No              |
| default          | Yes          | Yes            | Yes                    | No                           | No              |
| protected        | Yes          | Yes            | Yes                    | Yes                          | No              |
| public           | Yes          | Yes            | Yes                    | Yes                          | Yes             |  
---

## Case Study: University Class Hierarchy

Below is a class hierarchy for university members that includes:

Students (part-time and full-time)

Faculty (part-time and full-time)

Staff

Donors

It identifies attributes common to all persons (data members in superclass Person),
identifies attributes distinguishing each category of people SCSU deals with (attributes
of individual subclasses), and identifies all methods including constructors for each class.

Complete UML diagram for the entire class hierarchy:
```
--------------------
Person
--------------------
-name: String
-address: String
-dateOfBirth: String
--------------------
+Person()
+Person(name: String, address: String, dateOfBirth: String)
--------------------
+getName(): String
+setName(name: String): void

+getAddress(): String
+setAddress(address: String): void

+getDOB(): String
+setDOB(dateOfBirth: String): void
--------------------
```
```
--------------------
Student
--------------------
-fullTime: boolean
-major: String
-minor: String
-registered: boolean
-credits: int
-studentId: long
--------------------
+Student()
+Student(studentID: long, fullTime: boolean, major: String, minor: String, registered: boolean, credits: int)
--------------------
+getFullTime(): boolean
+setFullTime(fullTime: boolean): void

+getMajor(): String
+setMajor(major: String): void

+getMinor(): String
+setMinor(minor: String): void

+isRegistered(): boolean
+setRegistered(registered: boolean): void

+getCredits(): int
+setCredits(credits: int): void

+getStudentId(): int
+setStudentId(studentId: int): void
```
```
--------------------
Faculty
--------------------
-facultyId: int
-department: String
-fullTime: boolean
-numberOfClasses: int
-salary: int
-office: String
--------------------------
+Faculty()
+Faculty(department: String, fullTime: boolean, numberOfClasses: int, salary: int, office: String)
--------------------------
+getFacultyId(): int
+setFacultyId(facultyId: int): void

+getDepartment(): String
+setDepartment(department: String): void

+getFullTime(): boolean
+setFullTime(fullTime: boolean): void

+getClasses(): int
+setClasses(numberOfClasses: int): void

+getSalary(): int
+setSalary(salary: int): void

+getOffice(): String
+setOffice(office: String): void
```
```
------------------------
Staff
------------------------
-staffId: int
-position: String
-staffType: String
-fullTime: boolean
-hours: int
------------------------
+Staff()
+Staff(staffType: String, fullTime: boolean, hours: int)
-----------------------
+getStaffId(): int
+setStaffId(staffId: int): void

+getPosition(): String
+setPosition(position: String): void

+getStaffType(): String
+setStaffType(staffType: String): void

+getFullTime(): boolean
+setFullTime(fullTime: boolean): void

+getHours(): int
+setHours(hours: int): void
```
```
--------------------
Donor
--------------------
-donorId: int
-numberDonations: int
-largestDonation: long
-totalAmount: long
-----------------------
+Donor()
+Donor(numberDonations: int, largestDonation: long, totalAmount: long)
-----------------------
+getDonorId(): int
+setDonorId(donorId: int): void

getNumberDonations(): int
setNumberDonations(numberDonations: int): void

getLargestDonation(): long
setLargestDonation(largestDonation: long): void

getTotalAmount(): long
setTotalAmount(totalAmount: long): void
```
