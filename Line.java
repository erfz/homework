import java.awt.geom.Point2D;

/**
 * Created by Period12 on 11/13/17.
 */
public class Line {
    public static void main(String[] args) {
        Line l1 = new Line(3.0, new Point2D.Double(5.0, -900));
        Line l2 = new Line(7.0);
        System.out.println("Expected to be equal: false" + "\nEqual: " + l1.equals(l2));
        System.out.println("Expected to intersect: true" + "\nIntersect: " + l1.intersects(l2));
        System.out.println("Expected to be parallel: false" + "\nParallel: " + l1.isParallel(l2));
    }

    private double m = Double.POSITIVE_INFINITY; // slope
    private double b = Double.POSITIVE_INFINITY; // y-intercept
    private double a = Double.POSITIVE_INFINITY; // defines vertical line x = a

    public Line(double m, Point2D.Double p) {
        if (Double.isFinite(m)) {
            this.m = m;
            this.b = p.y - m * p.x;
        } else {
            this.a = p.x;
        }
    }

    public Line(Point2D.Double p1, Point2D.Double p2) {
        if (p1.x != p2.x) {
            this.m = (p2.y - p1.y) / (p2.x - p1.x);
            this.b = p1.y - m * p1.x;
        } else {
            this.a = p1.x;
        }
    }

    public Line(double m, double b) {
        this.m = m;
        this.b = b;
    }

    public Line(double a) {
        this.a = a;
    }

    private boolean equals(Line l) {
        return this.m == l.m && this.b == l.b && this.a == l.a;
    }

    private boolean intersects(Line l) {
        if (this.equals(l)) {
            return false;
        } else {
            return this.m != l.m;
        }
    }

    private boolean isParallel(Line l) {
        if (this.equals(l)) {
            return false;
        } else {
            return this.m == l.m;
        }
    }
}
/*
"C:\Program Files\Java\jdk-9.0.1\bin\java" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2017.2.5\lib\idea_rt.jar=51401:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2017.2.5\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\zfrs\Downloads\SlopeProgram-20171116T021432Z-001\SlopeProgram\out\production\SlopeProgram Line
Expected to be equal: false
Equal: false
Expected to intersect: true
Intersect: true
Expected to be parallel: false
Parallel: false

Process finished with exit code 0
 */