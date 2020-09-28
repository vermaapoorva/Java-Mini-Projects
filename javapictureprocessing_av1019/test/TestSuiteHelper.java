import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.junit.rules.TemporaryFolder;
import picture.Main;
import picture.Picture;
import picture.Utils;

public class TestSuiteHelper {

  public static Picture runMain(TemporaryFolder folder, String... inputArguments)
      throws IOException {

    File outputFile = folder.newFile("out.png");

    String[] arguments = Arrays.copyOf(inputArguments, inputArguments.length + 1);

    arguments[arguments.length - 1] = outputFile.getAbsolutePath();

    for (int i = 0; i < arguments.length; i++) {
      arguments[i] = new String(arguments[i]);
    }

    Main.main(arguments);

    return Utils.loadPicture(outputFile.getAbsolutePath());
  }
}
