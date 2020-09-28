package turtle.implementations;

import turtle.AbstractTurtle;
import turtle.Paper;

public class WrappingTurtle extends AbstractTurtle {

  public WrappingTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
  }

  public void move(int distance) {
    for (int i = 0; i < distance; i++) {
      moveForward();
      if (position.getX() == -1) {
        position.setX(paper.getWidth() - 1);
      }
      if (position.getY() == -1) {
        position.setY(paper.getHeight() - 1);
      }
      if (position.getY() == paper.getHeight()) {
        position.setY(0);
      }
      if (position.getX() == paper.getWidth()) {
        position.setX(0);
      }
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
