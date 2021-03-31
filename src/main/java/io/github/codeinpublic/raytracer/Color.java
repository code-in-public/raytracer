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
}
