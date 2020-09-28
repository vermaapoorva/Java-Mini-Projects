package turtle;

import turtle.util.Rotation;

public interface Turtle {

  void penUp();

  void penDown();

  void setPlottingChar(char plottingChar);

  void rotate(Rotation rotation, int n);

  void mark();

  void move(int distance);
}
