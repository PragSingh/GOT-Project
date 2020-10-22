package GameofThrones;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OpeningWindow extends JPanel{
	
	JFrame window = new JFrame();	
	 OpeningWindow()
	{
		window.add(this);
		
		try {
			File sound = new File("sounds//OpeningSound.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
	        clip.start();
	        }catch(Exception e)
		{
			System.out.println(e);
		}
		
		window.setLocation(50,50);
		window.setUndecorated(true);
		window.setSize(978,550);
		window.setVisible(true);
		
		try {
			Thread.sleep(10000);
			window.dispose();
			Menu m = new Menu();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void paint(Graphics g)
	{
		ImageIcon background = new ImageIcon("images//openingImg.png");
		g.drawImage(background.getImage(),0,0,null);
	}

}
