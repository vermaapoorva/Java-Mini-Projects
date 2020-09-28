package turtle;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import turtle.implementations.BouncyTurtle;
import turtle.implementations.ContinuousTurtle;
import turtle.implementations.NormalTurtle;
import turtle.implementations.ReflectingTurtle;
import turtle.implementations.WrappingTurtle;
import turtle.util.Rotation;

public class TurtleInterpreter {

  private Scanner scanner;
  private PrintStream printStream;
  private Paper paper = new Paper();
  private final HashMap<String, Turtle> turtles = new HashMap<>();
  private String name;
  private String clusterName;
  private int count = 0;
  private String clusterNames;

  public TurtleInterpreter(Scanner scanner, PrintStream printStream) {
    this.scanner = scanner;
    this.printStream = printStream;
  }

  public void parse() {

    while (scanner.hasNext()) {
      String command = scanner.next();
      Turtle turtle;
      switch (command) {
        case "paper":
          paper = new Paper(scanner.nextInt(), scanner.nextInt());
          break;
        case "new":
          String type = scanner.next();
          String name = scanner.next();
          turtle = makeTurtle(name, type);
          turtles.put(name, turtle);
          break;
        case "pen":
          turtle = turtles.get(scanner.next());
          String state = scanner.next();
          if (state.equals("up")) {
            turtle.penUp();
          } else if (state.equals("down")) {
            turtle.penDown();
          } else {
            turtle.setPlottingChar(state.charAt(0));
          }
          break;
        case "move":
          turtle = turtles.get(scanner.next());
          turtle.move(scanner.nextInt());
          break;
        case "right":
          turtle = turtles.get(scanner.next());
          turtle.rotate(Rotation.RIGHT, scanner.nextInt() / 45);
          break;
        case "left":
          turtle = turtles.get(scanner.next());
          turtle.rotate(Rotation.LEFT, scanner.nextInt() / 45);
          break;
        case "show":
          printStream.println(paper.toString());
          break;
      }
    }
  }

  private Turtle makeTurtle(String prefix, String type) {
    Turtle turtle = null;
    switch (type) {
      case ("cluster"):
        ArrayList<Turtle> clusterTurtles = new ArrayList<>();
        int clusterSize = scanner.nextInt();
        for (int i = 0; i < clusterSize; i++) {
          if (scanner.next().equals("new")) {
            String newType = scanner.next();
            String newPrefix = prefix + "." + scanner.next();
            turtle = makeTurtle(newPrefix, newType);
            clusterTurtles.add(turtle);
            turtles.put(newPrefix, turtle);
          } else {
            throw new IllegalArgumentException("Construction of turtle incomplete");
          }
        }
        turtle = new ClusterTurtle(clusterTurtles);
        break;
      case ("normal"):
        turtle = new NormalTurtle(scanner.nextInt(), scanner.nextInt(), paper);
        break;
      case ("bouncy"):
        turtle = new BouncyTurtle(scanner.nextInt(), scanner.nextInt(), paper);
        break;
      case ("continuous"):
        turtle = new ContinuousTurtle(scanner.nextInt(), scanner.nextInt(), paper);
        break;
      case ("reflecting"):
        turtle = new ReflectingTurtle(scanner.nextInt(), scanner.nextInt(), paper);
        break;
      case ("wrapping"):
        turtle = new WrappingTurtle(scanner.nextInt(), scanner.nextInt(), paper);
        break;
    }
    return turtle;
  }
}
