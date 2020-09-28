package turtle.util;

public enum Direction {
  NORTH,
  NORTHEAST,
  EAST,
  SOUTHEAST,
  SOUTH,
  SOUTHWEST,
  WEST,
  NORTHWEST;

  public Direction rotate(Rotation rotation) {
    int index = this.ordinal();
    Direction[] direction = Direction.values();
    if (rotation == Rotation.LEFT) {
      index = ((index - 1) + 8) % 8;
    } else {
      index = (index + 1) % 8;
    }
    return direction[index];
  }
}
