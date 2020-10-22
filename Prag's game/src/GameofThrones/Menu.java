package GameofThrones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener,KeyListener{

	JFrame window = new JFrame();
	JButton playButton = new JButton();
	JButton exitButton = new JButton();
	JLabel infoLabel = new JLabel();
	JLabel centerImageLabel = new JLabel();
	JButton backgroundButton = new JButton();
	
	Font customFont = new Font("Italic",Font.ITALIC,22);
	
	Menu()
	{
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.DARK_GRAY);
        window.add(this);
    
    playButton.setBackground(Color.DARK_GRAY);
    playButton.setIcon(new ImageIcon("images//play.png"));
    playButton.addActionListener(this);
    playButton.addKeyListener(this);
    window.add(playButton,BorderLayout.PAGE_START);
		
    exitButton.setBackground(Color.DARK_GRAY);
    exitButton.setIcon(new ImageIcon("images//exit.png"));
    exitButton.addActionListener(this);
    exitButton.addKeyListener(this);
    window.add(exitButton,BorderLayout.PAGE_END);
    
    backgroundButton.setBackground(Color.DARK_GRAY);
    backgroundButton.setIcon(new ImageIcon("images//BackGround.png"));
    backgroundButton.addActionListener(this);
    backgroundButton.addKeyListener(this);
    window.add(backgroundButton,BorderLayout.WEST);
    
   infoLabel.setText("Press 'Space' to Shoot");
   infoLabel.setFont(customFont);
   infoLabel.setOpaque(true);
   infoLabel.setForeground(Color.red);;
   infoLabel.setBackground(Color.DARK_GRAY);
   window.add(infoLabel,BorderLayout.EAST);
    
   centerImageLabel.setBackground(Color.DARK_GRAY);
   centerImageLabel.setIcon(new ImageIcon("images//NightKing.png"));
   window.add(centerImageLabel,BorderLayout.CENTER);
   
   window.setLocation(50,50);
    window.setUndecorated(true);
    window.setSize(1000,550);
	window.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
		   window.dispose();	
		}
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER)
		{
		   window.dispose();	
		   LevelsWindow lw = new LevelsWindow();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exitButton)
		{
			window.dispose();
		}
		else if(ae.getSource()==playButton)
		{
			 window.dispose();	
			   LevelsWindow lw = new LevelsWindow();
		}
	}

}
