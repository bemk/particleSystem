import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class Space extends JPanel implements MouseWheelListener
{

	private static final long serialVersionUID = 1L;
	private int noParticles;
	private ArrayList<Particle> particles = new ArrayList<Particle>();
	private Random r = new Random();
	
	private int maxSpd = 20;
	
	private Timer t = new javax.swing.Timer(1000/30, new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			for (Particle p : particles)
			{
				p.move();
			}
			Iterator<Particle> i = particles.iterator();
			while (i.hasNext())
			{
				if (i.next().getToDie())
				{
					i.remove();
				}
			}
			int shortage = noParticles - particles.size();
			for (int idx = 0; idx < shortage; idx++)
			{
				particles.add(new Particle(r.nextInt(maxSpd)-maxSpd/2+1, r.nextInt(maxSpd), .125, r.nextInt(63)+1));
			}
			revalidate();
			repaint();
		}
	});
	public Space(int particles)
	{
		this.noParticles = particles;
		for (int i = 0; i < this.noParticles; i++)
		{
			this.particles.add(new Particle(r.nextInt(maxSpd)-maxSpd/2+1, r.nextInt(maxSpd), .125, r.nextInt(63)+1));
		}
		t.start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.scale(1, -1);
		g2.translate(this.getWidth()/2, -this.getHeight());
		g2.setColor(new Color(128, 128, 255));
		for (Particle p : particles)
		{
			g2.fillOval((int)p.getX(), (int)p.getY(), 10, 10);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		if (e.getWheelRotation() > 0)
		{
			if (noParticles < 25)
				noParticles = 0;
			else
				noParticles -= 25;
		}
		else if (e.getWheelRotation() < 0)
		{
			if (noParticles > 1000)
				noParticles = 1000;
			else
				noParticles += 25;
		}
		
	}
}
