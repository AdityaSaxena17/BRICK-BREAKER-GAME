import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class mainframe{
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setResizable(true);
        f.setTitle("BRICK BREAKER");
        f.getContentPane().setBackground(Color.black);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(768, 748);
        ImageIcon img=new ImageIcon("assets/brick.png");
        f.setIconImage(img.getImage());
        JLabel gmstart=new JLabel();
        gmstart.setForeground(Color.red);
        gmstart.setFont(new Font(null, 0, 50));
        gmstart.setText("PRESS ANY KEY TO START!");
        gmstart.setHorizontalAlignment(JLabel.CENTER);
        gmstart.setVerticalAlignment(JLabel.CENTER);
        f.add(gmstart);  
        f.setVisible(true);
        game g=new game();
        f.addKeyListener(g);
        f.add(g);
        f.setVisible(true);
        
    }

    

}
