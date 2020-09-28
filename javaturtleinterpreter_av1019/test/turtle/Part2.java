package turtle;

import static org.junit.Assert.*;
import static turtle.TestSuiteHelper.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Part2 {

  @Rule public TemporaryFolder tmpFolder = new TemporaryFolder();

  @Test
  public void testBouncyTurtles() {
    assertEquals(
        readFile("testcases/outputs/turtles_bouncy.res"),
        runMain("testcases/inputs/turtles_bouncy.dat", tmpFolder));
  }

  @Test
  public void testReflectingTurtles() {
    assertEquals(
        readFile("testcases/outputs/turtles_reflecting.res"),
        runMain("testcases/inputs/turtles_reflecting.dat", tmpFolder));
  }

  @Test
  public void testContinuousTurtles() {
    assertEquals(
        readFile("testcases/outputs/turtles_continuous.res"),
        runMain("testcases/inputs/turtles_continuous.dat", tmpFolder));
  }

  @Test
  public void testWrappingTurtles() {
    assertEquals(
        readFile("testcases/outputs/turtles_wrapping.res"),
        runMain("testcases/inputs/turtles_wrapping.dat", tmpFolder));
  }

  @Test
  public void testBouncyIsland() {
    assertEquals(
        readFile("testcases/outputs/turtle_island.res"),
        runMain("testcases/inputs/turtle_island.dat", tmpFolder));
  }
}
