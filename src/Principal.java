import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Principal extends JFrame {
	
        //Background
        Desenho fundo = new Desenho("cenario.gif",1280,540);
        JLabel labelFundo = new JLabel(fundo.getImg());
          
        Desenho ef1 = new Desenho("esfera1.png",122,122);
        Desenho ef2 = new Desenho("esfera2.png",122,403);
        Desenho ef3 = new Desenho("esfera3.png",200,403);
        Desenho ef4 = new Desenho("esfera4.png",122,403);
        Desenho ef5 = new Desenho("esfera5.png",122,403);
        Desenho ef6 = new Desenho("esfera6.png",122,403);
        Desenho ef7 = new Desenho("esfera7.png",122,403);
        
        JLabel labelEf1 = new JLabel(ef1.getImg());
        JLabel labelEf2 = new JLabel(ef2.getImg());
        JLabel labelEf3 = new JLabel(ef3.getImg());
        JLabel labelEf4 = new JLabel(ef4.getImg());
        JLabel labelEf5 = new JLabel(ef5.getImg());
        JLabel labelEf6 = new JLabel(ef6.getImg());
        JLabel labelEf7 = new JLabel(ef7.getImg());
        
        DesenhoMovel jogador = new DesenhoMovel("happy.png",10,10);
        JLabel personagem = new JLabel(jogador.getImg());
        
      
        
       
        
        public boolean bateu(Component a, Component b) {
		int aX = a.getX();
		int aY = a.getY();
		int ladoDireitoA = aX+a.getWidth();
		int ladoEsquerdoA= aX;
		int ladoBaixoA= aY+a.getHeight();
		int ladoCimaA= aY;
		
		int bX = b.getX();
		int bY = b.getY();
		int ladoDireitoB = bX+b.getWidth();
		int ladoEsquerdoB= bX;
		int ladoBaixoB= bY+b.getHeight();
		int ladoCimaB= bY;
		
		boolean bateu = false;
		
		boolean cDireita=false;
		boolean cCima=false;
		boolean cBaixo=false;
		boolean cEsquerda=false;
		
		if(ladoDireitoA>=ladoEsquerdoB) {
			cDireita=true;
		}
		if(ladoCimaA<=ladoBaixoB) {
			cCima=true;
		}
		if(ladoBaixoA>=ladoCimaB) {
			cBaixo=true;
		}
		if(ladoEsquerdoA<=ladoDireitoB) {
			cEsquerda=true;
		}
		
		if(cDireita && cEsquerda && cBaixo && cCima) {
			bateu = true;
		}
			
		return bateu;
	}
        
        
       
            
        public Principal() {
            this.editarJanela();
            this.editarComponentes();
            this.addMovimento();
            new Veficação().start();
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
                   System.out.print(e.getKeyCode());
                    if(e.getKeyCode() == 38){
                       jogador.setImg("happyup.png");
                       personagem.setIcon(jogador.getImg());
                       jogador.moverCima();
                       personagem.setBounds(jogador.getX(),jogador.getY(),personagem.getWidth(),personagem.getHeight());
                    }
                     if(e.getKeyCode() == 40) {
                       jogador.setImg("happydown.png");
                       personagem.setIcon(jogador.getImg());
                       jogador.moverBaixo();
                      personagem.setBounds(jogador.getX(),jogador.getY(),personagem.getWidth(),personagem.getHeight());
                    
                    }
                      if(e.getKeyCode() == 37) {
                       jogador.setImg("happyLeft.png");
                       personagem.setIcon(jogador.getImg());
                       jogador.moverDireita();
                       personagem.setBounds(jogador.getX(),jogador.getY(),personagem.getWidth(),personagem.getHeight());
                    
                    }
                    if(e.getKeyCode() == 39) {
                          jogador.setImg("happy.png");
                       personagem.setIcon(jogador.getImg());
                        jogador.moverEsquerda();
                        personagem.setBounds(jogador.getX(),jogador.getY(),personagem.getWidth(),personagem.getHeight());
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
            this.setSize(1280,650);
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
        
        public void editarComponentes(){
            this.labelFundo.setBounds(0,0,fundo.getX(),fundo.getY());
            
            this.personagem.setBounds(jogador.getX(),jogador.getY(),128,88);
            
             this.labelEf1.setBounds(ef1.getX(),ef1.getY(),60,60);
             this.labelEf2.setBounds(ef2.getX(),ef2.getY(),60,60);
               this.labelEf3.setBounds(ef3.getX(),ef3.getY(),560,60);
             this.labelEf4.setBounds(ef4.getX(),ef4.getY(),460,60);
               this.labelEf5.setBounds(ef5.getX(),ef5.getY(),260,60);
             this.labelEf6.setBounds(ef6.getX(),ef6.getY(),160,60);
               this.labelEf7.setBounds(ef7.getX(),ef7.getY(),860,0);
       
        }
        

          public class Veficação extends Thread {
          
            public void run(){
                    System.out.print("eee");
                while(true){
                    try{
                        sleep(2);
                    } catch(Exception Erro){
                        
                    }
                    
                    if(bateu(personagem,labelEf1)) {
                        JOptionPane.showMessageDialog(null,"coletado");
                        System.exit(0);
                    }
                    
                      if(bateu(personagem,labelEf2)) {
                        JOptionPane.showMessageDialog(null,"coletado");
                        System.exit(0);
                    }
                    
                   
                    
            }
        }
          }
            
	
}
