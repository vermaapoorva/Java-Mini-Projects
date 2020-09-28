package turtle;

import static org.junit.Assert.*;
import static turtle.TestSuiteHelper.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Part1 {

  @Rule public TemporaryFolder tmpFolder = new TemporaryFolder();

  @Test
  public void testNormalSquares() {
    assertEquals(
        readFile("testcases/outputs/turtle_normal.res"),
        runMain("testcases/inputs/turtle_normal.dat", tmpFolder));
  }

  @Test
  public void testNormalsRace() {
    assertEquals(
        readFile("testcases/outputs/turtles_normal.res"),
        runMain("testcases/inputs/turtles_normal.dat", tmpFolder));
  }
}
