# Immutable and Mutable Objects

**Instructions:**

1. Fork this repository to your GitHub account.
2. Clone the forked repository locally to your machine.
3. Create a new branch named Feature01.

## Part 1: Understanding the Objects on the Stack and Heap

**Objective:** The point of this exercise is to make sure you understand the mechanism for passing objects as parameters, and what that looks like in memory.

1. Using the [Python Tutor code visualizer](https://pythontutor.com/java.html#mode=edit) for Java, capture an image of a diagram showing the local variables and parameters of main and riddle just before riddle returns for the code below.
    * Save the image taken above to your project as Part1_2.jpg.
2. Answer the following question in the **text** block below:
    * Is the **blank** object mutable or immutable? How can you tell?

```text
PUT ANSWER TO #2 HERE
```

```java
import java.awt.Point;

public class Puzzler {
    public static int riddle(int x, Point p) {
        x = x + 7;
        return x + p.x + p.y;
    }

    public static void main(String[] args) {
        int x = 5;
        Point blank = new Point(1, 2);
        System.out.println(riddle(x, blank));
        System.out.println(x);
        System.out.println(blank.x);
        System.out.println(blank.y);
    }
}
```

3. Using the [Python Tutor code visualizer](https://pythontutor.com/java.html#mode=edit) for Java, capture a stack diagram showing the state of the below program just before **findCenter** returns.
    * Save the image taken above to your project as Part1_3.jpg.
4. Using the [Python Tutor code visualizer](https://pythontutor.com/java.html#mode=edit) for Java, capture a stack diagram showing the state of the program just before **distance** returns.
    * Save the image taken above to your project as Part1_4.jpg.
5. Answer the following question below in the **text** block below:
    * Explain how the return values from #3 and #4 differ.

```text
PUT ANSWER TO #5 HERE
```

```java
import java.awt.Point;
import java.awt.Rectangle;

public class RectangleGymnastics {
    public static double distance(Point p1, Point p2) {
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Point findCenter(Rectangle box) {
        int x = box.x + box.width / 2;
        int y = box.y + box.height / 2;
        return new Point(x, y);
    }

    public static void main(String[] args) {
        Point blank = new Point(5, 8);
        Rectangle rect = new Rectangle(0, 2, 4, 4);
        Point center = findCenter(rect);
        double dist = distance(center, blank);
        System.out.println(dist);
    }
}
```

## Part 2: Exploring Aliasing

Recall that aliases are two variables that refer to the same object.

1. Using the [Python Tutor code visualizer](https://pythontutor.com/java.html#mode=edit) for Java, capture a diagram that shows the state of the program just before the end of main.
    * Save the image taken above to your project as Part2_1.jpg.
2. What is the output of the program?
    * Put the output in the text block below

```text
PUT ANSWER TO #2 HERE
```

3. At the end of main, are p1 and p2 aliased? Why or why not?
    * Put your answer in the text block below

```text
PUT ANSWER TO #3 HERE
```

```java
import java.awt.Point;
import java.awt.Rectangle;

public class Aliasing {
    public static void printPoint(Point p) {
        System.out.println("(" + p.x + ", " + p.y + ")");
    }

    public static Point findCenter(Rectangle box) {
        int x = box.x + box.width / 2;
        int y = box.y + box.height / 2;
        return new Point(x, y);
    }

    public static void main(String[] args) {
        Rectangle box1 = new Rectangle(2, 4, 7, 9);
        Point p1 = findCenter(box1);
        printPoint(p1);
        box1.grow(1, 1);
        Point p2 = findCenter(box1);
        printPoint(p2);
    }
}
```

## Part 3: String Playground

The following code fragment traverses a string and checks whether it has the same number of opening and closing parentheses:

```java
String s = "((3 + 7) * 2)";
int count = 0;
for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    if (c == '(') { count++; }
    else if (c == ')') { count--; }
}
```

1. Encapsulate the above fragment in a method in the [StringPlayground](src/StringPlayground.java) class that takes a string argument and returns the final value of count.
2. Test your method with multiple strings, including some that are balanced and some that are not.
    * Screenshot your output and add it to your project as Part3_2.jpg
3. Generalize the code so that it works on any string.
    * What could you do to generalize it more?

## Part 4: Large Numbers

Many encryption algorithms depend on the ability to raise large integers to a power. Below is a method that implements an efficient algorithm for integer exponentiation:

```java
public static int pow(int x, int n) {
    if (n == 0) return 1;
    // find x to the n/2 recursively
    int t = pow(x, n / 2);
    // if n is even, the result is t squared
    // if n is odd, the result is t squared times x
    if (n % 2 == 0) {
        return t * t;
    } else {
        return t * t * x;
    }
}
```

The problem with this method is that it works only if the result is small enough to be represented by an int.

1. In [BigIntRewrite.java](src/BigIntRewrite.java) rewrite the above method so that the result is a **BigInteger**.
    * The **parameters** should still be **integers**, though.
    * You should use the **BigInteger** methods **add** and **multiply**.
    * Don’t use **BigInteger.pow;** that would spoil the fun.

## Submission

Follow these steps for submission:

1. Create a Feature01 branch of your code if you haven't already.
2. Commit your working code for the exercises to your local copy/Feature01 branch.
3. Push it to your Remote/origin branch (i.e., GitHub: Feature01 -> origin/Feature01).
4. Issue a Pull request to my instructor repo.
5. Make sure to COPY the Pull request URL and submit it for the lab/assignment in Canvas.