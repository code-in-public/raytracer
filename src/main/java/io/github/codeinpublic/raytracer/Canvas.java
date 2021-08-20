package io.github.codeinpublic.raytracer;

public class Canvas {
    private int width;
    private int height;
	private Color[][] pixels;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;

        this.pixels = new Color[height][width];

        for (int col = 0; col < pixels.length; col++) {
            for (int row = 0; row < pixels[0].length; row++) {
                this.pixels[col][row] = new Color(0, 0, 0);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getPixel(int row, int col) {
        return this.pixels[col][row];
    }

    public void writePixel(int row, int col, Color color) {
        this.pixels[col][row] = color;
    }

    public String toPPM() {
        String magicNumber = "P3";
        int maxColorValue = 255;

        String fileHeader = magicNumber + "\n" +
            this.width + " " + this.height + "\n" +
            maxColorValue + "\n";

        String body = fileHeader;
        int max_length = 70;

        for (int row = 0; row < pixels.length; row++) {
            String row_line = "";
            for (int col = 0; col < pixels[0].length; col++) {
                // TODO Use map operation to create and split it.
                Color pixel = this.pixels[row][col];
                row_line += pixel.getRed(maxColorValue) + " "
                    + pixel.getGreen(maxColorValue) + " "
                    + pixel.getBlue(maxColorValue) + " ";
            }

            // Add a new line character after 70 characters in the row_line
            while (row_line.length() > max_length) {
                int space_idx = row_line.indexOf(" ", 67);
                String new_line = row_line.substring(0, space_idx) + "\n";
                body += new_line;
                row_line = row_line.substring(space_idx+1);
            }

            body = body + row_line.stripTrailing() + "\n";
        }

        return body;
    }
}
