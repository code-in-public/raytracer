package io.github.codeinpublic.raytracer;

public class Color extends Tuple
{
    protected Color(double red, double green, double blue) {
		super(red, green, blue, 0);
	}

	public double getRed() {
        return this.getX();
    }

    public double getGreen() {
        return this.getY();
    }

    public double getBlue() {
        return this.getZ();
    }

    public int normalizeColorValue(double colorValue, int maxColorValue) {
        int roundedValue = (int) Math.round(colorValue * maxColorValue);

        return Math.min(Math.max(0, roundedValue), maxColorValue);
    }

	public int getRed(int maxColorValue) {
        return this.normalizeColorValue(this.getRed(), maxColorValue);
	}

	public int getGreen(int maxColorValue) {
        return this.normalizeColorValue(this.getGreen(), maxColorValue);
	}

	public int getBlue(int maxColorValue) {
        return this.normalizeColorValue(this.getBlue(), maxColorValue);
	}
}
