package turtle.implementations;

import turtle.AbstractTurtle;
import turtle.Paper;

public class ContinuousTurtle extends AbstractTurtle {

  public ContinuousTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
  }

  public void move(int distance) {
    for (int i = 0; i < distance; i++) {
      moveForward();
      mark();
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
