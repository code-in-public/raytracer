package io.github.codeinpublic.raytracer;

public class Tuple
{
	private double x;
	private double y;
	private double z;
	private double w;

	public Tuple(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double getW() {
		return w;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void setW(double w) {
		this.w = w;
	}

    public static Tuple add(Tuple a1, Tuple a2) {
        return new Vector(a1.getX() + a2.getX(),
                          a1.getY() + a2.getY(),
                          a1.getZ() + a2.getZ(),
                          a1.getW() + a2.getW());
	}

	public static Tuple subtract(Point a1, Point a2) {
        return new Vector(a1.getX() - a2.getX(),
                          a1.getY() - a2.getY(),
                          a1.getZ() - a2.getZ(),
                          a1.getW() - a2.getW());
	}
}
