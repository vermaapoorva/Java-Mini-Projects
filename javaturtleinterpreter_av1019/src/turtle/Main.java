package turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner;
    PrintStream printStream;
    if (args.length == 1) {
      File in = new File(args[0]);
      scanner = new Scanner(in);
      printStream = System.out;
    } else if (args.length == 2) {
      File in = new File(args[0]);
      File out = new File(args[1]);
      scanner = new Scanner(in);
      printStream = new PrintStream(out);
    } else {
      File testfile = new File("testcases/inputs/turtle_cluster_1.dat");
      scanner = new Scanner(testfile);
      printStream = System.out;
    }

    TurtleInterpreter interpreter = new TurtleInterpreter(scanner, printStream);
    interpreter.parse();
  }
}
