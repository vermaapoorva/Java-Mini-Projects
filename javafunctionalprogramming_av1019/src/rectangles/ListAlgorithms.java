package rectangles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAlgorithms {

  /**
   * Returns a new list of rectangles by translating (moving) each rectangle according to the given
   * distance vector.
   *
   * @param rectangles The rectangles to be translated
   * @param vector     The distance vector
   * @return The translated rectangles
   */
  public static List<Rectangle> translate(List<Rectangle> rectangles, Point vector) {
    List<Rectangle> translated = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      translated.add(new Rectangle(rectangle.getTopLeft().add(vector), rectangle.getWidth(),
          rectangle.getHeight()));
    }
    return translated;
  }

  /**
   * Returns a new list of rectangles by scaling each rectangle by a given amount.
   *
   * @param rectangles The rectangles to be scaled
   * @param factor     A non-negative scale factor
   * @return The scaled rectangles
   */
  public static List<Rectangle> scale(List<Rectangle> rectangles, int factor) {
    List<Rectangle> scaled = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      scaled.add(new Rectangle(rectangle.getTopLeft(), rectangle.getWidth() * factor,
          rectangle.getHeight() * factor));
    }
    return scaled;
  }

  /**
   * Returns a list containing, in order, the bottom-left point of each input rectangle.
   */
  public static List<Point> getBottomLeftPoints(List<Rectangle> rectangles) {
    List<Point> bottomLeftPoints = new ArrayList<>();
    for (Rectangle other : rectangles) {
      bottomLeftPoints.add(other.getBottomLeft());
    }
    return bottomLeftPoints;
  }

  /**
   * Returns a list containing all rectangles that intersect with the given rectangle.
   *
   * @param rectangles A list of rectangles to be checked for intersection
   * @param rectangle  The rectangle against which intersection should be checked
   * @return All rectangles that do intersect with the given rectangle
   */
  public static List<Rectangle> getAllIntersecting(
      List<Rectangle> rectangles, Rectangle rectangle) {
    List<Rectangle> intersecting = new ArrayList<>();
    for (Rectangle other : rectangles) {
      if (other.intersects(rectangle)) {
        intersecting.add(other);
      }
    }
    return intersecting;
  }

  /**
   * Returns a list containing all rectangles with a bigger area than the given rectangle.
   *
   * @param rectangles A list of rectangles whose area is to be checked
   * @param rectangle  The rectangle against which areas are to be compared
   * @return All rectangles that have a larger area than the given rectangle
   */
  public static List<Rectangle> getAllWithBiggerAreaThan(
      List<Rectangle> rectangles, Rectangle rectangle) {
    List<Rectangle> greaterArea = new ArrayList<>();
    for (Rectangle other : rectangles) {
      if (other.area() > rectangle.area()) {
        greaterArea.add(other);
      }
    }
    return greaterArea;
  }

  /**
   * Returns the largest area among the given rectangles.
   */
  public static int findLargestArea(List<Rectangle> rectangles) {
    int largestArea = 0;
    for (Rectangle other : rectangles) {
      if (other.area() > largestArea) {
        largestArea = other.area();
      }
    }
    return largestArea;
  }

  /**
   * Returns the largest height among all the given rectangles.
   */
  public static int findMaxHeight(List<Rectangle> rectangles) {
    int largestHeight = 0;
    for (Rectangle other : rectangles) {
      if (other.getHeight() > largestHeight) {
        largestHeight = other.getHeight();
      }
    }
    return largestHeight;
  }

  /**
   * Computes the sum of areas of all the given rectangles.
   */
  public static int getSumOfAreas(List<Rectangle> rectangles) {
    int totalArea = 0;
    for (Rectangle other : rectangles) {
      totalArea += other.area();
    }
    return totalArea;
  }

  /**
   * Computes the sum of areas of all rectangles that intersect with the given rectangle.
   *
   * @param rectangles The rectangles whose areas to be considered and summed
   * @param rectangle  The rectangle with which intersection is to be checked
   * @return The sum of areas of all rectangles that do intersect with the given rectangle
   */
  public static int getSumOfAreasOfAllIntersecting(
      List<Rectangle> rectangles, Rectangle rectangle) {
    return getSumOfAreas(getAllIntersecting(rectangles, rectangle));
  }

  /**
   * Returns collection that maps each rectangle to its computed area.
   */
  public static Map<Rectangle, Integer> getAreaMap(List<Rectangle> rectangles) {
    Map<Rectangle, Integer> rectanglesArea = new HashMap<>();
    for (Rectangle rectangle : rectangles) {
      rectanglesArea.put(rectangle, rectangle.area());
    }
    return rectanglesArea;
  }
}