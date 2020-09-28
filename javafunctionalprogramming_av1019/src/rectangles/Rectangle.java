package rectangles;

import static com.google.common.primitives.Ints.max;
import static com.google.common.primitives.Ints.min;

import java.util.Optional;

public class Rectangle {

  private final int width;
  private final int height;
  private final Point topLeft;
  private final Point topRight;
  private final Point bottomLeft;
  private final Point bottomRight;


  public Rectangle(Point corner1, Point corner2) {
    int x1 = Math.min(corner1.getX(), corner2.getX());
    int x2 = Math.max(corner1.getX(), corner2.getX());
    int y1 = Math.min(corner1.getY(), corner2.getY());
    int y2 = Math.max(corner1.getY(), corner2.getY());
    if (x1 < 0 || y1 < 0) {
      throw new IllegalArgumentException("x and y must be positive");
    }
    topLeft = new Point(x1, y1);
    topRight = new Point(x2, y1);
    bottomLeft = new Point(x1, y2);
    bottomRight = new Point(x2, y2);
    width = x2 - x1;
    height = y2 - y1;
  }

  public Rectangle(Point topLeft, int width, int height) {
    this(topLeft, new Point(topLeft.getX() + width, topLeft.getY() + height));
  }

  public Rectangle(int width, int height) {
    this(new Point(), new Point(width, height));
  }

  public int getWidth() {
    return width;
  }

  public Rectangle setWidth(int newWidth) {
    return (new Rectangle(topLeft, newWidth, height));
  }

  public int getHeight() {
    return height;
  }

  public Rectangle setHeight(int newHeight) {
    return (new Rectangle(topLeft, width, newHeight));
  }

  public Point getTopLeft() {
    return topLeft;
  }

  public Point getTopRight() {
    return topRight;
  }

  public Point getBottomLeft() {
    return bottomLeft;
  }

  public Point getBottomRight() {
    return bottomRight;
  }

  public int area() {
    return width * height;
  }

  public Boolean intersects(Rectangle otherRectangle) {
    if (bottomLeft.isAbove(otherRectangle.getTopLeft())
        || topLeft.isBelow(otherRectangle.getBottomLeft())
        || topLeft.isRightOf(otherRectangle.getTopRight())
        || topRight.isLeftOf(otherRectangle.getTopLeft())) {
      return false;
    } else {
      return true;
    }
  }

  public Optional<Rectangle> intersection(Rectangle other) {
    if (intersects(other)) {
      return Optional.of((new Rectangle(new Point(max(topLeft.getX(), other.getTopLeft().getX()),
          max(topLeft.getY(), other.getTopLeft().getY())),
          new Point(min(bottomRight.getX(), other.getBottomRight().getX()),
              min(bottomRight.getY(), other.getBottomRight().getY())))));
    } else {
      return Optional.empty();
    }
  }
}