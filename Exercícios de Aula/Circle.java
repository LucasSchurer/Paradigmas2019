public class Circle {
   private double x;
   private double y;
   private double r;

   public Circle(double x, double y, double r) {
      this.x = x;
      this.y = y;
      this.r = r;

      System.out.println("New Circle");
   }
   public double area() {
      return Math.PI * r * r;
   }

   public void setRadius(double radius) {
     this.r = radius;
   }


   public static void main(String[] args) {
      Circle c = new Circle(1, 1, 1);
      System.out.println("Area do circulo: " + c.area());
      c.r = 0.5;
   }
}
