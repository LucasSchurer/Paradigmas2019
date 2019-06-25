import java.util.Scanner;

public class Point {
  private double x = 0;
  private double y = 0;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void movePoint (double dx, double dy) {
    this.x += dx;
    this.y += dy;
  }

  public double distance (Point p) {
    double dx = p.x - this.x;
    double dy = p.y - this.y;

    double distance = Math.sqrt(Math.pow((dx*dx), 2) + Math.pow((dy*dy), 2));

    return distance;
  }




  public static void main(String[] args) {

    Scanner p = new Scanner (System.in);

    double x, y;
    System.out.println("Digite x1: ");
    x = p.nextDouble();
    System.out.println("Digite y1: ");
    y = p.nextDouble();
    Point p1 = new Point (x, y);

    x = 0;
    y = 0;

    System.out.println("Digite x2: ");
    x = p.nextDouble();
    System.out.println("Digite y2: ");
    y = p.nextDouble();
    Point p2 = new Point (x, y);

    double distance = p1.distance(p2);

    System.out.println("Distancia " + distance);
  }
}
