import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;
//import java.util.*;

public class game extends JPanel implements ActionListener,KeyListener{
    int bposx=375;
    int bposy=600;
    int posx=325;
    int posy=650;
    int dirx=1;
    int diry=-2;
    int noofb=20;
    int count=0;
    int x=60;
    int y=10;
    int delay=1;
    boolean flag=false;
    int score=0;
    boolean bflag[][]=new boolean[5][4];

    public game(){
        //this.addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        Timer time=new Timer(delay, this);
        time.start();

        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                bflag[i][j]=true;
            }
        }

    }

    public void paint(Graphics g){
        if(flag){
        //bg
        g.setColor(Color.black);
        g.fillRect(0, 0, 750, 700);

        //boundary
        g.setColor(Color.red);
        g.fillRect(0, 0, 750, 2);
        g.fillRect(0, 0, 2 , 700 );
        g.fillRect(750, 0, 2, 700);
        g.fillRect(0, 700, 750, 2);
        
        //ball
        g.setColor(Color.red);
        g.fillOval(bposx, bposy, 15, 15);
        
        //slab
        g.setColor(Color.yellow);
        g.fillRect(posx, posy, 125, 8);

        //score
        g.setColor(Color.white);
        Font f = new Font("Arial", Font.PLAIN, 20);
        g.setFont(f);
        g.drawString(Integer.toString(score),10,690);
        if(score==100){
            flag=false;
        }

        //bricks
        g.setColor(Color.white);
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                if(bflag[i][j]){
                    g.fillRect(x+(160*j),y+(50*i), 150, 40);
                }
            }
        }
        // for(int i=0;i<noofb;i++){
        //     g.fillRect(x,y, 150, 40);
        //     x+=160;
        //     if(x>=740-150){
        //         x=10;
        //         y+=50;
        //     }
        // }
        // // Row 1
        // g.fillRect(x, y, 150, 40);
        // g.fillRect(x + 160, y, 150, 40);
        // g.fillRect(x + 320, y, 150, 40);
        // g.fillRect(x + 480, y, 150, 40);

        // // Row 2
        // g.fillRect(x, y + 50, 150, 40);
        // g.fillRect(x + 160, y + 50, 150, 40);
        // g.fillRect(x + 320, y + 50, 150, 40);
        // g.fillRect(x + 480, y + 50, 150, 40);

        // // Row 3
        // g.fillRect(x, y + 100, 150, 40);
        // g.fillRect(x + 160, y + 100, 150, 40);
        // g.fillRect(x + 320, y + 100, 150, 40);
        // g.fillRect(x + 480, y + 100, 150, 40);

        // // Row 4
        // g.fillRect(x, y + 150, 150, 40);
        // g.fillRect(x + 160, y + 150, 150, 40);
        // g.fillRect(x + 320, y + 150, 150, 40);
        // g.fillRect(x + 480, y + 150, 150, 40);

        // // Row 5
        // g.fillRect(x, y + 200, 150, 40);
        // g.fillRect(x + 160, y + 200, 150, 40);
        // g.fillRect(x + 320, y + 200, 150, 40);
        // g.fillRect(x + 480, y + 200, 150, 40);
    }
    if(!flag && score==100){
        g.setColor(Color.white);
        Font font = new Font("Arial", Font.PLAIN, 50);
        g.setFont(font);
        g.drawString("YOU HAVE WON!",x+140,y+400);
    }
    else if(!flag && bposy>=682){
        g.setColor(Color.red);
        Font font = new Font("Arial", Font.PLAIN, 50);
        g.setFont(font);
        g.drawString("GAME OVER!",x+140,y+400);
    }         
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        flag=true;
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            posx-=10;
            if(posx<=0){
                posx=0;
            }
            System.out.println("LEFT KEY PRESSED");
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            posx+=10;
            if(posx>=750-125){
                posx=750-125;
            }
            System.out.println("RIGHT KEY PRESSED");
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(flag){
            if(bposx<=0){
                dirx=-dirx;
            }
            if(bposx>=732){
                dirx=-dirx;
            }
            if(bposy<=0){
                diry=-diry;
            }
            // if((bposx<=posx+125 && bposx>=posx) && bposy==(posy-8)){
            //     diry=-diry;
            // }
            if(bposy>=682){
                flag=false;
                System.out.println("GAME OVER!");
                // JLabel gmstop=new JLabel();
                // gmstop.setForeground(Color.red);
                // gmstop.setHorizontalAlignment(JLabel.CENTER);
                // gmstop.setVerticalAlignment(JLabel.CENTER);
                // gmstop.setFont(new Font(null, 0, 50));
                // gmstop.setText("GAME OVER!");
                // new mainframe().add(gmstop);         
            }
            scheckcollision();
            bcheckcollision();
            bposx+=dirx;
            bposy+=diry;
            repaint();
        }
}

    public void bcheckcollision(){
        Rectangle ball=new Rectangle(bposx,bposy,15,15);
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                if(bflag[i][j]){
                    Rectangle brick=new Rectangle(x+(150*j),y+(50*i),150,40);
                    if(ball.intersects(brick)){
                        bflag[i][j]=false;
                        diry=-diry;
                        score+=5;
                    }
                }
            }
        }
    }

    public void scheckcollision(){
        Rectangle ball=new Rectangle(bposx,bposy,15,15);
        Rectangle slab=new Rectangle(posx,posy,125,8);
        if(ball.intersects(slab)){
            diry=-diry;
        }
    }

    
}
