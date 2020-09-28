package picture;

import static picture.Utils.loadPicture;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    switch (args[0]) {
      case "invert": {
        Picture picture = loadPicture(args[1]);
        Process process = new Process(picture);
        process.invert(args[2]);
      }
      break;
      case "grayscale": {
        Picture picture = loadPicture(args[1]);
        Process process = new Process(picture);
        process.grayscale(args[2]);
      }
      break;
      case "rotate": {
        Picture picture = loadPicture(args[2]);
        Process process = new Process(picture);
        process.rotate(Integer.parseInt(args[1]), args[3]);
      }
      break;
      case "flip": {
        Picture picture = loadPicture(args[2]);
        Process process = new Process(picture);
        process.flip(args[1], args[3]);
      }
      break;
      case "blend": {
        List<Picture> pictures = new ArrayList<>();
        for (int i = 1; i < args.length - 1; i++) {
          pictures.add(loadPicture(args[i]));
        }
        Process process = new Process(loadPicture(args[1]));
        process.blend(pictures, args[3]);
      }
      break;
      case "blur": {
        Picture picture = loadPicture(args[1]);
        Process process = new Process(picture);
        process.blur(args[2]);
      }
      break;
    }
  }
}
