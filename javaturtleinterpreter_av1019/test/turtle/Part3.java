package turtle;

import static org.junit.Assert.assertEquals;
import static turtle.TestSuiteHelper.readFile;
import static turtle.TestSuiteHelper.runMain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Part3 {

  @Rule public TemporaryFolder tmpFolder = new TemporaryFolder();

  @Test
  public void testClusterTurtles1() {
    assertEquals(
        readFile("testcases/outputs/turtle_cluster_1.res"),
        runMain("testcases/inputs/turtle_cluster_1.dat", tmpFolder));
  }

  @Test
  public void testClusterTurtles2() {
    assertEquals(
        readFile("testcases/outputs/turtle_cluster_2.res"),
        runMain("testcases/inputs/turtle_cluster_2.dat", tmpFolder));
  }
}


