
public class Particle {
	double x;
	double xOld;
	double y;
	double yOld;
	int span = 0;
	double grav;
	int lifeTime;
	public Particle(int x, int y, double grav, int life, int xSource, int ySource)
	{
		this.x = x + xSource;
		this.xOld = xSource;
		this.y = y + ySource;
		this.yOld = ySource;
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
