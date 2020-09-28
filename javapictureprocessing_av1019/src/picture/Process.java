package picture;

import static picture.Utils.createPicture;
import static picture.Utils.savePicture;

import java.util.List;

public class Process {

  private Picture picture;

  public Process(Picture picture) {
    this.picture = picture;
  }

  public void invert(String outputLocation) {
    int width = picture.getWidth();
    int height = picture.getHeight();

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Color color = picture.getPixel(x, y);
        color.setRed(255 - (color.getRed()));
        color.setBlue(255 - (color.getBlue()));
        color.setGreen(255 - (color.getGreen()));
        picture.setPixel(x, y, color);
      }
    }
    savePicture(picture, outputLocation);
  }

  public void grayscale(String outputLocation) {
    int width = picture.getWidth();
    int height = picture.getHeight();

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Color color = picture.getPixel(x, y);
        int total = color.getRed() + color.getBlue() + color.getGreen();
        avg(total, total, total, 3, color);
        picture.setPixel(x, y, color);
      }
    }
    savePicture(picture, outputLocation);
  }

  public void rotate(int deg, String outputLocation) {
    Picture picture2 = null;
    switch (deg) {
      case 90:
        picture2 = rotateHelper(picture);
        break;
      case 180:
        picture2 = rotateHelper((rotateHelper(picture)));
        break;
      case 270:
        picture2 = rotateHelper((rotateHelper(rotateHelper(picture))));
        break;
    }
    savePicture(picture2, outputLocation);
  }

  private Picture rotateHelper(Picture picture) {
    int width = picture.getWidth();
    int height = picture.getHeight();
    Picture picture1 = createPicture(height, width);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Color color = picture.getPixel(x, y);
        int y1 = x;
        int x1 = height - y - 1;
        picture1.setPixel(x1, y1, color);
      }
    }
    return picture1;
  }

  public void flip(String direction, String outputLocation) {
    int width = picture.getWidth();
    int height = picture.getHeight();
    Picture picture1 = createPicture(width, height);
    switch (direction) {
      case ("H"):
        for (int x = 0; x < width; x++) {
          for (int y = 0; y < height; y++) {
            Color color = picture.getPixel(x, y);
            int x1 = width - x - 1;
            picture1.setPixel(x1, y, color);
          }
        }
        break;
      case ("V"):
        for (int x = 0; x < width; x++) {
          for (int y = 0; y < height; y++) {
            Color color = picture.getPixel(x, y);
            int y1 = height - y - 1;
            picture1.setPixel(x, y1, color);
          }
        }
        break;
    }
    savePicture(picture1, outputLocation);
  }

  public void blend(List<Picture> pictures, String outputLocation) {
    int width = pictures.get(0).getWidth();
    int height = pictures.get(0).getHeight();
    for (Picture pic : pictures) {
      if (pic.getWidth() < width) {
        width = pic.getWidth();
      }
      if (pic.getHeight() < height) {
        height = pic.getHeight();
      }
    }
    Picture picture = createPicture(width, height);
    Color color = picture.getPixel(0, 0);
    int len = pictures.size();
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        int red = 0;
        int blue = 0;
        int green = 0;
        for (Picture pic : pictures) {
          Color color1 = pic.getPixel(x, y);
          red += color1.getRed();
          blue += color1.getBlue();
          green += color1.getGreen();
        }
        color = avg(red, blue, green, len, color);
        picture.setPixel(x, y, color);
      }
    }
    savePicture(picture, outputLocation);
  }

  public void blur(String outputLocation) {
    int width = picture.getWidth();
    int height = picture.getHeight();
    Picture picture1 = createPicture(width, height);
    Color color = picture.getPixel(0, 0);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
          picture1.setPixel(x, y, picture.getPixel(x, y));
        } else {
          int red = 0;
          int blue = 0;
          int green = 0;
          for (int x1 = -1; x1 < 2; x1++) {
            for (int y1 = -1; y1 < 2; y1++) {
              Color color1 = picture.getPixel(x + x1, y + y1);
              red += color1.getRed();
              blue += color1.getBlue();
              green += color1.getGreen();
            }
          }
          color = avg(red, blue, green, 9, color);
          picture1.setPixel(x, y, color);
        }
      }
    }
    savePicture(picture1, outputLocation);
  }

  private Color avg(int r, int b, int g, int num, Color c) {
    c.setRed(r / num);
    c.setBlue(b / num);
    c.setGreen(g / num);
    return c;
  }
}
