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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LevelsWindow extends JPanel implements ActionListener,KeyListener  {

	JFrame window = new JFrame();
	String[] s = {"White Walkers-Level","Night King-Level","Iron Throne-Level"};
	JComboBox nameOfLevels = new JComboBox(s);
	JButton enterButton = new JButton();
	JButton backButton = new JButton();
	
	Font customFont = new Font("Bold",Font.BOLD,30);
	Font comboFont = new Font("Italic",Font.ITALIC,25);
	
	
	public LevelsWindow() 
	{
	this.setBackground(Color.BLACK);
	window.add(this);
	
	nameOfLevels.setFont(comboFont);
	nameOfLevels.setForeground(Color.DARK_GRAY);
	nameOfLevels.setBackground(Color.BLACK);
	window.add(nameOfLevels,BorderLayout.PAGE_START);
	
	backButton.setFont(customFont);
	backButton.setText("Back");
	backButton.setForeground(Color.WHITE);
	backButton.setBackground(Color.BLACK);
	backButton.addKeyListener(this);
	backButton.addActionListener(this);
	window.add(backButton);
	window.add(backButton,BorderLayout.PAGE_END);
	
	enterButton.setIcon(new ImageIcon("images//Dragon.png"));
	enterButton.addKeyListener(this);
	enterButton.addActionListener(this);
	window.add(enterButton,BorderLayout.CENTER);
	
	window.setUndecorated(true);
	window.setSize(750,550);
	window.setLocation(50,50);
	window.setVisible(true);
	}
	
	@Override
	public void keyTyped(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
		window.dispose();
		Menu m = new Menu();
		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==0)
		{
		//JOptionPane.showMessageDialog(null,"White Walkers Level is not Ready");
			WhiteWalkersLevel wl = new WhiteWalkersLevel();
		}
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==1)
		{
		JOptionPane.showMessageDialog(null,"Night King Level is not Ready");	
		}
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==3)
		{
		JOptionPane.showMessageDialog(null,"Iron Throne Level is not Ready");	
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
		if(ae.getSource()==backButton)
		{
			window.dispose();
			Menu m = new Menu();
		}
		
		else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==0) 
		{
		//JOptionPane.showMessageDialog(null,"White Walkers Level is stiil in maintenance");
			WhiteWalkersLevel wl = new WhiteWalkersLevel();
		}
		else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==1) 
		{
		JOptionPane.showMessageDialog(null,"Night King Level is stiil in maintenance");	
		}
		else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==2) 
		{
		JOptionPane.showMessageDialog(null,"Iron Throne Level is stiil in maintenance");	
		}
	}

}
