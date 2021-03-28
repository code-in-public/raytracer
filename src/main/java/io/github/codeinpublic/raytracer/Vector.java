package io.github.codeinpublic.raytracer;

public class Vector extends Tuple
{
	public Vector(double x, double y, double z) {
		super(x, y, z, 0.0);
	}

	public Vector(double x, double y, double z, double w) {
		super(x, y, z, w);
	}

	/*
	 * given two unit vectors, a dot product of 1 means the vectors are
	 * identical, and a dot product of -1 means they point in opposite
directions.
	 * @param a
	 * @param b
	 * @return The dot product
*/
	public static double dot(Vector a, Vector b) {
		return (a.getX() * b.getX() +
				a.getY() * b.getY() +
				a.getZ() * b.getZ() +
				a.getW() * b.getW());
	}

	public static Tuple cross(Vector a, Vector b) {
		return new Vector(a.getY() * b.getZ() - a.getZ() * b.getY(),
						  a.getZ() * b.getX() - a.getX() * b.getZ(),
						  a.getX() * b.getY() - a.getY() * b.getX());
	}
}
