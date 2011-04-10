
public class Particle {
	double x;
	double xOld = 0;
	double y;
	double yOld = 60;
	int span = 0;
	double grav;
	int lifeTime;
	public Particle(int x, int y, double grav, int life)
	{
		this.x = x;
		this.y = y + 60;
		this.grav = grav;
		this.lifeTime = life;
	}
	
	void move()
	{
		double xSpeed = x - xOld;
		xOld = x;
		x += xSpeed;
		double ySpeed = y - yOld- grav;
		yOld = y;
		y += ySpeed;
		
		span ++;
	}
	
	boolean getToDie()
	{
		return span>=lifeTime ? true : false;
	}
	
	double getX()
	{
		return this.x;
	}
	double getY()
	{
		return this.y;
	}

	public int getSpan()
	{
		return this.span;
	}

	public int getLife()
	{
		return this.lifeTime;
	}
}
