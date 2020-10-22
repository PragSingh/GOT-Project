package GameofThrones;

import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Fire extends Thread{
	
	Bullet bullet;
	WhiteWalkersLevel wl;
	WhiteWalkers[][] whitewalkers;
	
	public static int score = 0;
	
	Fire(Bullet bullet,WhiteWalkersLevel wl, WhiteWalkers[][] whitewalkers)
	{
		this.bullet = bullet;
		this.wl = wl;
		this.whitewalkers = whitewalkers;
	}
	
	@Override
	public void run()
	{
		while(bullet.getyAxis()>-1000)
		{
			bullet.setyAxis(bullet.getyAxis()-10);
			checkCollision();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		wl.repaint();
		}
	}
	
	public void checkCollision()
	{
		Rectangle bulletRect = new Rectangle(bullet.getxAxis(),bullet.getyAxis(),14,28);
		
		for(int i=0;i<whitewalkers.length;i++)
		{
			for(int j=0;j<whitewalkers[i].length;j++)
			{
				Rectangle whitewalkersRect = new Rectangle(whitewalkers[i][j].getxAxis(),whitewalkers[i][j].getyAxis(),25,25);
			if(bulletRect.intersects(whitewalkersRect))
			{
				whitewalkers[i][j].setxAxis(5000000);
				bullet.setxAxis(-50000);
				score++;
				try {
					File sound = new File("sounds//DeadWhiteWalker.wav");
					AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
			        clip.start();
				}catch(Exception e) {
					System.out.println(e);
				}
				
			}
			}
		}
	}

}
