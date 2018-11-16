import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal extends JFrame{
	
        Desenho fundo = new Desenho("cenario.gif",1280,540);
           Desenho ef1 = new Desenho("ef1.png",12,12);
        Desenho jogador = new DesenhoMovel("gafanhoto.gif",10,10);
      
        JLabel labelFundo = new JLabel(fundo.getImg());
        JLabel labelEf1 = new JLabel(ef1.getImg());
        JLabel personagem = new JLabel(jogador.getImg());
        
        public Principal() {
            this.editarJanela();
            this.editarComponentes();
            this.addMovimento();
	}
	
                
        public static void main(String[] args) {
		Principal app = new Principal();
	}
        
        public void addMovimento() {
            addKeyListener(new KeyListener(){
                @Override
                public void keyTyped(KeyEvent e) {
                    
                   }

                @Override
                public void keyPressed(KeyEvent e) {
                   
                    
                     
                    if(e.getKeyCode() == 38) {
                         jogador.setImg("hollowVirado.gif");
                        personagem.setIcon(jogador.getImg());
                       jogador.setY(jogador.getY()-10);
                       personagem.setBounds(jogador.getX(),jogador.getY(),320,256);
                    }
                     if(e.getKeyCode() == 40) {
                       jogador.setY(jogador.getY()+10);
                       personagem.setBounds(jogador.getX(),jogador.getY(),320,256);
                    }
                      if(e.getKeyCode() == 37) {
                       jogador.setX(jogador.getX()-10);
                       personagem.setBounds(jogador.getX(),jogador.getY(),320,256);
                    }
                        if(e.getKeyCode() == 39) {
                       jogador.setX(jogador.getX()+10);
                       personagem.setBounds(jogador.getX(),jogador.getY(),320,256);
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
            this.setSize(1240,580);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setLayout(null);
            this.add(personagem);
            this.add(labelEf1);
            this.add(labelFundo);
           
           
        }
        
        public void editarComponentes(){
            this.labelFundo.setBounds(0,0,fundo.getX(),fundo.getY());
            this.personagem.setBounds(jogador.getX(),jogador.getY(),1280,540);
             this.labelEf1.setBounds(ef1.getX(),ef1.getY(),12,12);
        }
        

	
}
