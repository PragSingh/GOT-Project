package GameofThrones;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class WhiteWalkers {
 private int xAxis;
 private int yAxis;
 private String imagePath;

 public int getxAxis() {
	return xAxis;
}
public void setxAxis(int xAxis) {
	this.xAxis = xAxis;
}
public int getyAxis() {
	return yAxis;
}
public void setyAxis(int yAxis) {
	this.yAxis = yAxis;
}
public String getImagePath() {
	return imagePath;
}
public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}
public WhiteWalkers(int xAxis, int yAxis, String imagePath) {
	super();
	this.xAxis = xAxis;
	this.yAxis = yAxis;
	this.imagePath = imagePath;
}
public void drawWhiteWalkers(Graphics g) {
	ImageIcon WhiteWalkers = new ImageIcon(imagePath);
	g.drawImage(WhiteWalkers.getImage(),xAxis, yAxis, null);
}

}
