package turtle;

import java.util.ArrayList;
import turtle.util.Rotation;

public class ClusterTurtle implements Turtle {

  private final ArrayList<Turtle> turtles;

  public ClusterTurtle(ArrayList<Turtle> turtles) {
    this.turtles = turtles;
  }

  @Override
  public void penUp() {
    for (Turtle turtle : turtles) {
      turtle.penUp();
    }
  }

  @Override
  public void penDown() {
    for (Turtle turtle : turtles) {
      turtle.penDown();
    }
  }

  @Override
  public void setPlottingChar(char plottingChar) {
    for (Turtle turtle : turtles) {
      turtle.setPlottingChar(plottingChar);
    }
  }

  @Override
  public void rotate(Rotation rotation, int n) {
    for (Turtle turtle : turtles) {
      turtle.rotate(rotation, n);
    }
  }

  @Override
  public void mark() {
    for (Turtle turtle : turtles) {
      turtle.mark();
    }
  }

  @Override
  public void move(int distance) {
    for (Turtle turtle : turtles) {
      turtle.move(distance);
    }
  }
}
