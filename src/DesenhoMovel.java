import java.util.ArrayList;
import javax.swing.JLabel;

public class DesenhoMovel extends Desenho {

    private ArrayList<JLabel> bolsa = new ArrayList();

    public DesenhoMovel(String path, int x, int y) {
        super(path, x, y);
    }

    public void moverCima() throws LimiteBackgroundException {
        if ((this.getY() - 10) > 0) {
            this.setY(this.getY() - 10);
        } else {
            throw new LimiteBackgroundException();
        }
    }

    public void moverBaixo() throws LimiteBackgroundException {
        if ((this.getY() + 10) < 410) {
            this.setY(this.getY() + 10);
        } else {
            throw new LimiteBackgroundException();
        }
    }

    public void moverEsquerda() throws LimiteBackgroundException {
        if ((this.getX() + 10) <= 1150) {
            this.setX(this.getX() + 10);
        } else {
            throw new LimiteBackgroundException();
        }
    }

    public void moverDireita() throws LimiteBackgroundException {
        if ((this.getX() - 10) >= 0) {
            this.setX(this.getX() - 10);
        } else {
            throw new LimiteBackgroundException();
        }
    }

    public void addItem(JLabel esfera) {
        if (!(this.bolsa.contains(esfera))) {
            this.bolsa.add(esfera);
        }
    }

    public int getQuantidade() {
        return this.bolsa.size();
    }
    
}
