package io.github.codeinpublic.raytracer;

/*
 * A projectile has a position and velocity
 */
public class Projectile
{
    private final Tuple position;
    private final Tuple velocity;

	public Projectile(final Tuple position, final Tuple velocity) {
		this.position = position;
		this.velocity = velocity;
	}

	public Tuple getVelocity() {
		return velocity;
	}

	public Tuple getPosition() {
		return position;
	}
}
