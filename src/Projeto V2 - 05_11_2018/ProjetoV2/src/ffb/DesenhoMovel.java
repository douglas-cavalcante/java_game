package ffb;

public class DesenhoMovel extends Desenho
	implements Runnable {
	
	public void run() {
		this.moverDireita();
	}
	
	public void moverDireita()
	{
		this.setX(this.getX() + 1);
	}
}
