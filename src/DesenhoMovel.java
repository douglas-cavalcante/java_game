
import java.util.ArrayList;
import javax.swing.JLabel;

public class DesenhoMovel extends Desenho {

    //constructor herdado
    public DesenhoMovel(String path, int x, int y) {
        super(path, x, y);
    }

    private ArrayList<JLabel> bolsa = new ArrayList();

    public void addItem(JLabel esfera) {
        if (!(this.bolsa.contains(esfera))) {
            this.bolsa.add(esfera);
        }
    }

    public int getQuantidade() {
        return this.bolsa.size();
    }

    public void moverCima() {
        this.setY(this.getY() - 10);
    }

    public void moverBaixo() {
        this.setY(this.getY() + 10);
    }

    public void moverDireita() {
        this.setX(this.getX() - 10);
    }

    public void moverEsquerda() {
        this.setX(this.getX() + 10);
    }

}
