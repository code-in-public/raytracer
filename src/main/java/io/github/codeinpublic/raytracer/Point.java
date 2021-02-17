package io.github.codeinpublic.raytracer;

public class Point extends Tuple
{
	public Point(double x, double y, double z) {
		super(x, y, z, 1.0);
	}

	public Point(double x, double y, double z, double w) {
		super(x, y, z, w);
	}
}
