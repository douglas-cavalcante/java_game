import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Desenho {
	
        private ImageIcon img;
	private int x;
	private int y;
        
       Desenho(String path ,int x , int y) {
          this.img = new ImageIcon(getClass().getResource(path));
          this.x = x;
          this.y = y;
       }
       
	public ImageIcon getImg() {
		return img;
	}
	
	public void setImg(String path) {
            this.img = new ImageIcon(getClass().getResource(path));
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
