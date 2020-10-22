package GameofThrones;

public class Dropper extends Thread {
	WhiteWalkersLevel wl;
	WhiteWalkers[][] whitewalkers;
	Dropper(WhiteWalkersLevel wl,WhiteWalkers[][] whitewalkers)
	{
		this.whitewalkers = whitewalkers;
		this.wl = wl;	
	}
public void run()
{
	while(whitewalkers[0][0].getyAxis()<700)
	{	
	for(int i=0;i<whitewalkers.length;i++)
	{
		for(int j=0;j<whitewalkers[i].length;j++)
		{
			whitewalkers[i][j].setyAxis(whitewalkers[i][j].getyAxis()+20);
			System.out.println(whitewalkers[i][j].getyAxis());
		}
	}
	
	try {
	Thread.sleep(800);
	}catch(Exception e)
	{
		System.out.println(e);
	}
	wl.repaint();
	}
}

}
