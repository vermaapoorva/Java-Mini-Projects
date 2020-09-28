package turtle;

import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public abstract class AbstractTurtle implements Turtle {

  protected Position position;
  protected Direction direction;
  protected Pen penState;
  protected String name;
  protected Paper paper;
  protected char plottingChar;

  public AbstractTurtle(int x, int y, Paper paper) {
    position = new Position(x, y);
    this.direction = Direction.NORTH;
    this.penState = Pen.UP;
    this.paper = paper;
    this.plottingChar = '*';
  }

  public void penUp() {
    penState = Pen.UP;
  }

  public void penDown() {
    penState = Pen.DOWN;
  }

  public void setPlottingChar(char plottingChar) {
    this.plottingChar = plottingChar;
  }

  public void rotate(Rotation rotation, int n) {
    for (int i = 0; i < n; i++) {
      direction = direction.rotate(rotation);
    }
  }

  public void mark() {
    if (penState == Pen.DOWN) {
      paper.mark(position, plottingChar);
    }
  }

  public abstract void move(int distance);
}
