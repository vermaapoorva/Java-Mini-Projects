package turtle;

public class Paper {

  private final int width;
  private final int height;
  private final char[][] paper;

  public Paper(int width, int height) {
    this.width = width;
    this.height = height;
    this.paper = new char[height][width];
    initialise();
  }

  public Paper() {
    this.width = 10;
    this.height = 10;
    this.paper = new char[height][width];
    initialise();
  }

  private void initialise() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        paper[i][j] = ' ';
      }
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public boolean check(Position position) {
    return position.getX() >= 0
        && position.getX() < width
        && position.getY() >= 0
        && position.getY() < height;
  }

  public void mark(Position position, char c) {
    if (check(position)) {
      paper[position.getY()][position.getX()] = c;
    }
  }

  private char getChar(int x, int y) {
    return paper[y][x];
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    for (int i = height - 1; i >= 0; i--) {
      for (int j = 0; j < width; j++) {
        output.append(getChar(j, i));
      }
      output.append("\n");
    }
    return output.toString();
  }
}
