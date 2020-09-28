package turtle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.rules.TemporaryFolder;

public class TestSuiteHelper {

  public static String runMain(String inputFile, TemporaryFolder tmpFolder) {
    File outFile;
    try {
      outFile = tmpFolder.newFile("out.res");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    try {
      Main.main(new String[] {inputFile, outFile.getPath()});
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    return readFile(outFile.getPath());
  }

  public static String readFile(String inputFile) {
    StringBuilder sb = new StringBuilder();

    try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line);
        sb.append("\n");
      }

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return sb.toString();
  }
}
