public class DesenhoMovel extends Desenho {

    public DesenhoMovel(String path, int x, int y) {
        super(path, x, y);
    }

  
	public void moverDireita()
	{
		this.setX(this.getX() + 10);
	}
}
