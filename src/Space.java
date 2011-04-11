import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class Space extends JPanel implements MouseWheelListener, KeyListener, MouseListener, MouseMotionListener
{

	private static final long serialVersionUID = 1L;
	private int noParticles;
	private ArrayList<Particle> particles = new ArrayList<Particle>();
	private Random r = new Random();
	private int xSource, ySource;
	
	private static final boolean dbg = false;
	
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
				particles.add(new Particle(r.nextInt(maxSpd)-maxSpd/2+1, r.nextInt(maxSpd), .25, r.nextInt(100)+1, xSource, ySource));
			}
			revalidate();
			repaint();
		}
	});
	public Space(int particles)
	{
		this.noParticles = particles;
		xSource=0;
		ySource=50;
		for (int i = 0; i < this.noParticles; i++)
		{
			this.particles.add(new Particle(r.nextInt(maxSpd)-maxSpd/2, r.nextInt(maxSpd)-maxSpd/2-1, .25, r.nextInt(100)+1, xSource, ySource));
		}
		t.start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawString(Integer.toString(particles.size()), 2, 12);
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
				noParticles -= 5;
		}
		else if (e.getWheelRotation() < 0)
		{
			if (noParticles >= 1000)
				noParticles = 1000;
			else
				noParticles += 5;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case 37:
			if (xSource > -375)
			{
				xSource -= 25;
			}
			break;
		case 38:
			if (ySource <= 575)
			{
				ySource += 25;
			}
			break;
		case 39:
			if (xSource <= 375)
			{
				xSource += 25;
			}
			break;
		case 40:
			if (ySource >= 25)
			{
				ySource -= 25;
			}
			break;
		}
		if (dbg)
		{
			System.out.printf("Key:\t%d\n", e.getKeyCode());
			System.out.printf("pressed\nx:\t%d\ny:\t%d\n\n", xSource, ySource);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (dbg)
		{
			System.out.printf("released\nx:\t%d\ny:\t%d\n\n", xSource, ySource);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		if (dbg)
		{
			System.out.printf("x:\t%d\ny:\t%d\n\n", xSource, ySource);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		xSource = e.getX()-this.getWidth()/2;
		ySource = this.getHeight()-e.getY();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		xSource = e.getX()-this.getWidth()/2;
		ySource = this.getHeight()-e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
