package neuhoff.projectile;

public class Projectile {
	private double angle;
	private double velocity;
	private double time;
	private double radians;

	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		radians = Math.toRadians(angle);
	}

	public double getX() {
		return Math.sin(radians) * velocity * time;
	}

	public double getY() {
		return Math.cos(radians) * velocity * time - (.5 * 9.8 * time * time);
	}
	
}
