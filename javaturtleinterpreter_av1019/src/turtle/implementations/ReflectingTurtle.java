package turtle.implementations;

import turtle.AbstractTurtle;
import turtle.Paper;
import turtle.Position;
import turtle.util.Direction;

public class ReflectingTurtle extends AbstractTurtle {

  public ReflectingTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
  }

  public void move(int distance) {
    for (int i = 0; i < distance; i++) {
      Position oldPosition = new Position(position.getX(), position.getY());
      moveForward();
      if (!paper.check(position)) {
        position = oldPosition;
        reflect();
        moveForward();
        mark();
      }
      mark();
    }
  }

  private void reflect() {
    switch (direction) {
      case NORTH:
        direction = Direction.SOUTH;
        break;
      case EAST:
        direction = Direction.WEST;
        break;
      case SOUTH:
        direction = Direction.NORTH;
        break;
      case WEST:
        direction = Direction.EAST;
        break;
      case NORTHEAST:
        if (position.getY() == paper.getHeight() - 1) {
          direction = Direction.SOUTHEAST;
          position.changeY(1);
        } else {
          direction = Direction.NORTHWEST;
          position.changeX(1);
        }
        break;
      case SOUTHEAST:
        if (position.getY() == 0) {
          direction = Direction.NORTHEAST;
          position.changeY(-1);
        } else {
          direction = Direction.SOUTHWEST;
          position.changeX(1);
        }
        break;
      case SOUTHWEST:
        if (position.getX() == 0) {
          direction = Direction.SOUTHEAST;
          position.changeX(-1);
        } else {
          direction = Direction.NORTHWEST;
          position.changeY(-1);
        }
        break;
      case NORTHWEST:
        if (position.getX() == 0) {
          direction = Direction.NORTHEAST;
          position.changeX(-1);
        } else {
          direction = Direction.SOUTHWEST;
          position.changeY(1);
        }
        break;
    }
  }

  private void moveForward() {
    switch (direction) {
      case NORTHEAST:
        position.changeX(1);
      case NORTH:
        position.changeY(1);
        break;
      case SOUTHEAST:
        position.changeY(-1);
      case EAST:
        position.changeX(1);
        break;
      case SOUTHWEST:
        position.changeX(-1);
      case SOUTH:
        position.changeY(-1);
        break;
      case NORTHWEST:
        position.changeY(1);
      case WEST:
        position.changeX(-1);
        break;
    }
  }
}
