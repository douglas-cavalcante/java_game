
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Principal extends JFrame {

    //Background
    Desenho fundo = new Desenho("cenario.gif", 1280, 540);
    JLabel labelFundo = new JLabel(fundo.getImg());

    Desenho ef1 = new Desenho("esfera1.png", 122, 122);
    Desenho ef2 = new Desenho("esfera2.png", 122, 403);
    Desenho ef3 = new Desenho("esfera3.png", 200, 134);
    Desenho ef4 = new Desenho("esfera4.png", 600, 200);
    Desenho ef5 = new Desenho("esfera5.png", 188, 223);
    Desenho ef6 = new Desenho("esfera6.png", 444, 12);
    Desenho ef7 = new Desenho("esfera7.png", 122, 300);

    //Label configs
    JLabel labelEf1 = new JLabel(ef1.getImg());
    JLabel labelEf2 = new JLabel(ef2.getImg());
    JLabel labelEf3 = new JLabel(ef3.getImg());
    JLabel labelEf4 = new JLabel(ef4.getImg());
    JLabel labelEf5 = new JLabel(ef5.getImg());
    JLabel labelEf6 = new JLabel(ef6.getImg());
    JLabel labelEf7 = new JLabel(ef7.getImg());

    DesenhoMovel jogador = new DesenhoMovel("happy.png", 10, 10);
    JLabel personagem = new JLabel(jogador.getImg());

    public boolean bateu(Component a, Component b) {
        int aX = a.getX();
        int aY = a.getY();
        int ladoDireitoA = aX + a.getWidth();
        int ladoEsquerdoA = aX;
        int ladoBaixoA = aY + a.getHeight();
        int ladoCimaA = aY;

        int bX = b.getX();
        int bY = b.getY();
        int ladoDireitoB = bX + b.getWidth();
        int ladoEsquerdoB = bX;
        int ladoBaixoB = bY + b.getHeight();
        int ladoCimaB = bY;

        boolean bateu = false;

        boolean cDireita = false;
        boolean cCima = false;
        boolean cBaixo = false;
        boolean cEsquerda = false;

        if (ladoDireitoA >= ladoEsquerdoB) {
            cDireita = true;
        }
        if (ladoCimaA <= ladoBaixoB) {
            cCima = true;
        }
        if (ladoBaixoA >= ladoCimaB) {
            cBaixo = true;
        }
        if (ladoEsquerdoA <= ladoDireitoB) {
            cEsquerda = true;
        }

        if (cDireita && cEsquerda && cBaixo && cCima) {
            bateu = true;
        }

        return bateu;
    }

    public Principal() {
        editarJanela();
        editElements();
        addMovimento();
        new Veficação().start();
    }

    public static void main(String[] args) {
        Principal app = new Principal();
    }

    public void addMovimento() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == 38) {
                    jogador.setImg("happyup.png");
                    personagem.setIcon(jogador.getImg());
                    jogador.moverCima();
                    personagem.setBounds(jogador.getX(), jogador.getY(), personagem.getWidth(), personagem.getHeight());
                }
                if (e.getKeyCode() == 40) {
                    jogador.setImg("happydown.png");
                    personagem.setIcon(jogador.getImg());
                    jogador.moverBaixo();
                    personagem.setBounds(jogador.getX(), jogador.getY(), personagem.getWidth(), personagem.getHeight());

                }
                if (e.getKeyCode() == 37) {
                    jogador.setImg("happyLeft.png");
                    personagem.setIcon(jogador.getImg());
                    jogador.moverDireita();
                    personagem.setBounds(jogador.getX(), jogador.getY(), personagem.getWidth(), personagem.getHeight());

                }
                if (e.getKeyCode() == 39) {
                    jogador.setImg("happy.png");
                    personagem.setIcon(jogador.getImg());
                    jogador.moverEsquerda();
                    personagem.setBounds(jogador.getX(), jogador.getY(), personagem.getWidth(), personagem.getHeight());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //jogador.setImg("goku2.gif");
                //personagem.setIcon(jogador.getImg());
            }
        });
    }

    public void editarJanela() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280, 550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        setResizable(false);

        this.add(personagem);
        this.add(labelEf1);
        this.add(labelEf2);
        this.add(labelEf3);
        this.add(labelEf4);
        this.add(labelEf5);
        this.add(labelEf6);
        this.add(labelEf7);
        this.add(labelFundo);

    }

    public void editElements() {
        labelFundo.setBounds(0, 0, fundo.getX(), fundo.getY());
        personagem.setBounds(jogador.getX(), jogador.getY(), 128, 88);
        labelEf1.setBounds(ef1.getX(), ef1.getY(), 60, 60);
        labelEf2.setBounds(ef2.getX(), ef2.getY(), 60, 60);
        labelEf3.setBounds(ef3.getX(), ef3.getY(), 60, 60);
        labelEf4.setBounds(ef4.getX(), ef4.getY(), 60, 60);
        labelEf5.setBounds(ef5.getX(), ef5.getY(), 60, 60);
        labelEf6.setBounds(ef6.getX(), ef6.getY(), 60, 60);
        labelEf7.setBounds(ef7.getX(), ef7.getY(), 60, 60);
    }

    public class Veficação extends Thread {

        public void run() {

            while (true) {
                try {
                    sleep(10);
                    if (bateu(personagem, labelEf1)) {
                        jogador.addItem(labelEf1);
                        remove(labelEf1);

                    }
                    if (bateu(personagem, labelEf2)) {
                        jogador.addItem(labelEf2);
                        remove(labelEf2);

                    }
                    if (bateu(personagem, labelEf3)) {
                        jogador.addItem(labelEf3);
                        remove(labelEf3);

                    }
                    if (bateu(personagem, labelEf4)) {
                        jogador.addItem(labelEf4);
                        remove(labelEf4);

                    }
                    if (bateu(personagem, labelEf5)) {
                        jogador.addItem(labelEf5);
                        remove(labelEf5);

                    }
                    if (bateu(personagem, labelEf6)) {
                        jogador.addItem(labelEf6);
                        remove(labelEf6);

                    }
                    if (bateu(personagem, labelEf7)) {
                        jogador.addItem(labelEf7);
                        remove(labelEf7);
                    }

                    if (jogador.getQuantidade() == 7) {
                        System.out.print(jogador.getQuantidade());
                        jogador.setImg("happy_end.png");
                        personagem.setIcon(jogador.getImg());
                        personagem.setBounds(0, 0, personagem.getWidth(), personagem.getHeight());

                        fundo.setImg("shei2.png");
                        labelFundo.setIcon(fundo.getImg());
                        labelFundo.setBounds(0, 0, labelFundo.getWidth(), labelFundo.getHeight());

                        JOptionPane.showInputDialog(null, "Qual é seu 1 º Desejo");
                        JOptionPane.showMessageDialog(null, "Isso é fácil . Desejo realizado !!!");
                        JOptionPane.showInputDialog(null, "Qual é seu 2 º Desejo");
                        JOptionPane.showMessageDialog(null, "Isso é fácil . Desejo realizado !!!");
                        JOptionPane.showInputDialog(null, "Qual é seu 3º Desejo");
                        JOptionPane.showMessageDialog(null, "Isso é fácil . Desejo realizado !!!");
                        System.exit(0);
                    }

                } catch (Exception Erro) {
                }

            }
        }
    }

}
