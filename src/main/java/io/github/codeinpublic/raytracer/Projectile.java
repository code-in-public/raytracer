package io.github.codeinpublic.raytracer;

/*
 * A projectile has a position and velocity
 */
public class Projectile
{
    private final Point position;
    private final Tuple velocity;

	public Projectile(final Point position, final Tuple velocity) {
		this.position = position;
		this.velocity = velocity;
	}

	public Tuple getVelocity() {
		return velocity;
	}

	public Point getPosition() {
		return position;
	}
}
