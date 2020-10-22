package GameofThrones;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhiteWalkersLevel extends JPanel implements KeyListener{
	
	JFrame window = new JFrame("WhiteWalkersLevel");
	Shooter shooter = new Shooter(400,550,"images//Gun.png");
	WhiteWalkers[][] whitewalkers = new WhiteWalkers[2][16];
	
	int xAxis=0;
	int yAxis=0;
	Bullet[] bullets = new Bullet[1000];
    int count = 0;
    Dropper dropper = new Dropper(this,whitewalkers);
    private boolean fail = false;
	
		WhiteWalkersLevel()
		{
			this.setFocusable(true);
			this.addKeyListener(this);
			window.add(this);
			
			try {
				File sound = new File("sounds//NightKing.wav");
				AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
		        clip.start();
			}catch(Exception e)
			{
				System.out.println(e);
			}
			 
			for(int i=0;i<whitewalkers.length;i++)
			{
				for(int j=0;j<whitewalkers[i].length;j++)
				{
					whitewalkers[i][j] = new WhiteWalkers(xAxis, yAxis, "images//WhiteWalker.png");
					xAxis +=50;
				}
				yAxis +=50;
				xAxis=0;
			}
			dropper.start();
			
			for(int i=0;i<bullets.length;i++) {
				bullets[i] = new Bullet(420,650,"images//Bullet.png");
			}
			
			window.setSize(800,630);
			window.setLocation(40,20);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);
		}
	
		public void paint(Graphics g)
		{
			
		ImageIcon background = new ImageIcon("images//War.png");
		g.drawImage(background.getImage(),0,0,null);
		shooter.drawShooter(g);
		
		for (int i=0;i<whitewalkers.length;i++)
		{
			for(int j=0;j<whitewalkers[i].length;j++)
			{
				whitewalkers[i][j].drawWhiteWalkers(g);
			}
		}
		
		for(int i=0;i<bullets.length;i++)
		{
			bullets[i].drawBullet(g);
		}
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("",Font.BOLD,22));
		g.drawString("Score = "+Fire.score, 650, 500);
		LevelFailed();
		LevelComplete();
		}
		
		public void LevelComplete()
		{
			if(Fire.score>=10) {
				window.dispose();
				dropper.stop();
				JOptionPane.showMessageDialog(null,"Level Completed");
			}
		}
		
		public void LevelFailed()
		{
		for(int i=0;i<whitewalkers.length;i++)
		{
			for(int j=0;j<whitewalkers[i].length;j++)
			{
				if(whitewalkers[i][j].getyAxis()>350)
				{
					fail = true;
					dropper.stop();
					break;
				}
			}
		}
		if(fail==true)
		{
			window.dispose();
			JOptionPane.showMessageDialog(null,"Game over!");	
		}
		}
	
		private void WhiteWalkersLevel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(shooter.getxAxis()<805)
				shooter.setxAxis(shooter.getxAxis()+5);
		}
		else if(kp.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(shooter.getxAxis()>-2)
			{
				shooter.setxAxis(shooter.getxAxis()-5);
			}
			this.repaint();
		}
		else if(kp.getKeyCode()==KeyEvent.VK_SPACE)
		{
			try {
				File sound = new File("sounds//Gun.wav");
				AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
		        clip.start();
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			Fire f = new Fire(bullets[count],this,whitewalkers);
			bullets[count].setxAxis(shooter.getxAxis()+30);
			//bullets[count].setxAxis(shooter.getyAxis()+10);
			f.start();
			count++;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
