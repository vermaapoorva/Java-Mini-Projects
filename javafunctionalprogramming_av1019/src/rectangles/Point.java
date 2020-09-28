package rectangles;

public class Point {

  private int x = 0;
  private int y = 0;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point() {
    this(0, 0);
  }

  public Point(int x) {
    this(x, 0);
  }

  public int getX() {
    return x;
  }

  public Point setX(int newX) {
    if (newX < 0) {
      throw new IllegalArgumentException("x must be positive");
    }
    return (new Point(newX, y));
  }

  public int getY() {
    return y;
  }

  public Point setY(int newY) {
    if (newY < 0) {
      throw new IllegalArgumentException("y must be positive");
    }
    return (new Point(x, newY));
  }

  public boolean isLeftOf(Point point) {
    return (point.getX() > x);
  }

  public boolean isRightOf(Point point) {
    return (point.getX() < x);
  }

  public boolean isBelow(Point point) {
    return (point.getY() < y);
  }

  public boolean isAbove(Point point) {
    return (point.getY() > y);
  }

  public Point add(Point point) {
    return (new Point(x + point.getX(), y + point.getY()));
  }
}
