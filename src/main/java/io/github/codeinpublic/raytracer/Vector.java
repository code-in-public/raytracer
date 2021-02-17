package io.github.codeinpublic.raytracer;

public class Vector extends Tuple
{
	public Vector(double x, double y, double z) {
		super(x, y, z, 0.0);
	}

	public Vector(double x, double y, double z, double w) {
		super(x, y, z, w);
	}
}
