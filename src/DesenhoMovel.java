public class DesenhoMovel extends Desenho {
    
    //constructor herdado
    public DesenhoMovel(String path, int x, int y) {
        super(path, x, y);
    }

  
    public void moverCima(){
	this.setY(this.getY() - 10);
    }
    
    public void moverBaixo(){
	this.setY(this.getY() + 10);
    }
    
    public void moverDireita(){
	this.setX(this.getX() - 10);
    }

    public void moverEsquerda(){
	this.setX(this.getX() + 10);
    }

    
}
