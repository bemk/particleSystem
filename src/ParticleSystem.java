import java.awt.Dimension;
import java.util.*;

import javax.swing.JFrame;


public class ParticleSystem
{
	
	public ParticleSystem(int particles)
	{	
		JFrame frame = new JFrame("Particle System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Space s = new Space(particles);
		frame.add(s);
		
		frame.setPreferredSize(new Dimension(800,600));
		frame.pack();
		frame.setVisible(true);
		
		frame.addMouseWheelListener(s);
	}
	public ParticleSystem()
	{
		this(50);
	}
	
	public static void main(String[] args)
	{
		new ParticleSystem();
	}

}
