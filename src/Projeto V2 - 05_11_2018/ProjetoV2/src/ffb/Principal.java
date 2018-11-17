package ffb;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class Principal extends JFrame
					implements MouseListener{

	private DesenhoMovel carro1;
	private DesenhoMovel carro2;
	private int flag1 = 0;
	private int flag2 = 0;
	
	public Principal() {
		
		this.setSize(1200, 500);
		this.setVisible(true);
		this.addMouseListener(this);
		
		carro1 = new DesenhoMovel();
		carro1.setX(50);
		carro1.setY(30);
		carro1.setImg("carro.jfif");
		
		carro2 = new DesenhoMovel();
		carro2.setX(50);
		carro2.setY(230);
		carro2.setImg("carro.jfif");
	}
	
	public static void main(String[] args) {
		Principal app = new Principal();
	}

	public void paint(Graphics g)
	{
		{
			Thread t1 = new Thread(carro1);
			t1.start();
			try {t1.sleep(1);}
			catch (InterruptedException e) {}
			g.drawImage(carro1.getImg(), carro1.getX(), carro1.getY(), null);
		}
		{
			Thread t2 = new Thread(carro2);
			t2.start();
			try {t2.sleep(1000);}
			catch (InterruptedException e) {}
			g.drawImage(carro2.getImg(), carro2.getX(), carro2.getY(), null);
		}
		
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		carro1.moverDireita();
		carro2.moverDireita();
		repaint();
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
