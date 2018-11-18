// By Henrique Douglas 
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Principal extends JFrame implements KeyListener, Runnable {

    //Background
    Desenho background = new Desenho("images/cenario.gif", 1280, 540);
    JLabel labelFundo = new JLabel(background.getImg());
    
    //Definicação da localização das esferas
    Desenho ef1 = new Desenho("images/esferas/esfera1.png", 250, 400);
    Desenho ef2 = new Desenho("images/esferas/esfera2.png", 350, 50);
    Desenho ef3 = new Desenho("images/esferas/esfera3.png", 1150, 134);
    Desenho ef4 = new Desenho("images/esferas/esfera4.png", 700, 200);
    Desenho ef5 = new Desenho("images/esferas/esfera5.png", 400, 223);
    Desenho ef6 = new Desenho("images/esferas/esfera6.png", 100, 12);
    Desenho ef7 = new Desenho("images/esferas/esfera7.png", 550, 300);

    //Label configs
    JLabel labelEf1 = new JLabel(ef1.getImg());
    JLabel labelEf2 = new JLabel(ef2.getImg());
    JLabel labelEf3 = new JLabel(ef3.getImg());
    JLabel labelEf4 = new JLabel(ef4.getImg());
    JLabel labelEf5 = new JLabel(ef5.getImg());
    JLabel labelEf6 = new JLabel(ef6.getImg());
    JLabel labelEf7 = new JLabel(ef7.getImg());

    DesenhoMovel jogador = new DesenhoMovel("images/personagem/happy.png", 0, 0);
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

        boolean colisao = false;

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
            colisao = true;
        }

        return colisao;
    }
    

    public Principal() {
        
        addKeyListener(this);
        editarJanela();
        editarElementos();
        
        Thread t1 = new Thread(this);
        t1.start();
    }

    public static void main(String[] args) {
        Principal app = new Principal();
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

    public void editarElementos() {
        labelFundo.setBounds(0, 0, background.getX(), background.getY());
        personagem.setBounds(jogador.getX(), jogador.getY(), 128, 88);
        labelEf1.setBounds(ef1.getX(), ef1.getY(), 60, 60);
        labelEf2.setBounds(ef2.getX(), ef2.getY(), 60, 60);
        labelEf3.setBounds(ef3.getX(), ef3.getY(), 60, 60);
        labelEf4.setBounds(ef4.getX(), ef4.getY(), 60, 60);
        labelEf5.setBounds(ef5.getX(), ef5.getY(), 60, 60);
        labelEf6.setBounds(ef6.getX(), ef6.getY(), 60, 60);
        labelEf7.setBounds(ef7.getX(), ef7.getY(), 60, 60);

    }

    //------------------------- Thread para verificação de coleta de esferas ---------------------
    @Override
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
                    background.setImg("images/shei2.png");
                    labelFundo.setIcon(background.getImg());
                    labelFundo.setBounds(0, 0, labelFundo.getWidth(), labelFundo.getHeight());
                    JOptionPane.showInputDialog(null, "Qual é o seu 1º Desejo ?");
                    JOptionPane.showMessageDialog(null, "Isso é fácil . Desejo realizado !!!");
                    JOptionPane.showInputDialog(null, "Qual é seu 2º Desejo ?");
                    JOptionPane.showMessageDialog(null, "Isso é fácil . Desejo realizado !!!");
                    JOptionPane.showInputDialog(null, "Qual é seu 3º Desejo ?");
                    JOptionPane.showMessageDialog(null, "Isso é fácil . Desejo realizado !!!");
                    System.exit(0);
                }
            } catch (Exception Erro) {
            }
        }
    }

    //------------------------- Métodos para a captura do evento de teclado ---------------------
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 38) {
            jogador.setImg("images/personagem/happyup.png");
            personagem.setIcon(jogador.getImg());
            try {
                jogador.moverCima();
                personagem.setBounds(jogador.getX(), jogador.getY(), 88, 128);
            } catch (LimiteBackgroundException exception) {
                JOptionPane.showMessageDialog(null, "Forças malignas adiante !!! ");
            }
        }

        if (e.getKeyCode() == 40) {
            jogador.setImg("images/personagem/happydown.png");
            personagem.setIcon(jogador.getImg());
            try {
                jogador.moverBaixo();
                personagem.setBounds(jogador.getX(), jogador.getY(), 88, 128);
            } catch (LimiteBackgroundException exception) {
                JOptionPane.showMessageDialog(null, "Forças malignas adiante !!!");
            }
        }

        if (e.getKeyCode() == 37) {
            jogador.setImg("images/personagem/happyLeft.png");
            personagem.setIcon(jogador.getImg());
            try {
                jogador.moverDireita();
                personagem.setBounds(jogador.getX(), jogador.getY(), 128, 88);
            } catch (LimiteBackgroundException exception) {
                JOptionPane.showMessageDialog(null, "Forças malignas adiante !!! ");
            }
        }

        if (e.getKeyCode() == 39) {
            jogador.setImg("images/personagem/happy.png");
            personagem.setIcon(jogador.getImg());
            try {
                jogador.moverEsquerda();
                personagem.setBounds(jogador.getX(), jogador.getY(), 128, 88);
            } catch (LimiteBackgroundException exception) {
                JOptionPane.showMessageDialog(null, "Forças malignas adiante !!! ");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
