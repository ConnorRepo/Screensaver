//This program creates a black window with a green circle bouncing around the edges infinitely

import javax.swing.*;
import java.awt.*;

public class ScreenSaver {
  int x = 0;
  int y = 10;
  int last_x = 0;
  int last_y = 10;
  String last_side = "t";

  public static void main(String[] args) {
    ScreenSaver gui = new ScreenSaver();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MyDrawPanel drawPanel = new MyDrawPanel();

    frame.getContentPane().add(drawPanel);
    frame.setSize(1375, 875);
    frame.setVisible(true);

    while(x != 0 || y != 0) {
    //Trigger for the left side of the window
      if(x == 0){
      //DEBUG  System.out.println("left " + x + " " + y);
      //Move the circle until it hits one of the other walls
        while(x != 1265 && y != 0 && y != 740) {
        //Test which wall was hit last to see which direction the circle should bounce towards
          if(last_side.equals("t")) {
            x++;
            y++;
            drawPanel.repaint();
            try{
              Thread.sleep(5);
            } catch (Exception ex) {  }
          }

          if(last_side.equals("b")) {
            x++;
            y--;
            drawPanel.repaint();
            try{
              Thread.sleep(5);
            } catch (Exception ex) {  }
          }
        }
        last_side = "l";
      }
    //Trigger for the bottom side of the window
      if(y == 740) {
      //DEBUG System.out.println("bottom" + x + " " + y);
        last_x = x;
      //Move the circle until it hits one of the other walls
        while(x != 0 && x != 1265 && y != 0) {
        //Test which wall was hit last to see which direction the circle should bounce towards
          if(last_side.equals("l") || last_side.equals("t") && last_x > 630) {
            x++;
            y--;
            drawPanel.repaint();
            try{
              Thread.sleep(5);
            } catch (Exception ex) {  }
          }
          if(last_side.equals("r") || last_side.equals("t") && last_x < 630) {
            x--;
            y--;
            drawPanel.repaint();
            try{
              Thread.sleep(5);
            } catch (Exception ex) {  }
          }
        }
        last_side = "b";
      }
    //Trigger for the right side of the window
      if(x == 1265) {
      //DEBUG System.out.println("right " + x + " " + y);
      //Move the circle until it hits one of the other walls
        while(x != 0 && y != 0 && y != 740) {
        //Test which wall was hit last to see which direction the circle should bounce towards
          if(last_side.equals("b")) {
            x--;
            y--;
            drawPanel.repaint();
            try{
              Thread.sleep(5);
            } catch (Exception ex) {  }
          }

          if(last_side.equals("t")) {
            x--;
            y++;
            drawPanel.repaint();
            try{
              Thread.sleep(5);
            } catch (Exception ex) {  }
          }
        }
        last_side = "r";
      }
    //Trigger for the top side of the window
      if(y == 0) {
        //DEBUG System.out.println("top " + x + " " + y);
        last_x = x;
      //Move the circle until it hits one of the other walls
        while(x != 0 && x != 1265 && y != 740) {
        //Test which wall was hit last to see which direction the circle should bounce towards
          if(last_side.equals("r") || last_side.equals("b") && last_x < 630) {
            x--;
            y++;
            drawPanel.repaint();
            try{
              Thread.sleep(5);
            } catch (Exception ex) {  }
          }

          if(last_side.equals("l") || last_side.equals("b") && last_x > 630) {
            x++;
            y++;
            drawPanel.repaint();
            try{
              Thread.sleep(5);
            } catch (Exception ex) {  }
          }
        }
        last_side = "t";
      }
    }
  }

  class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
      g.setColor(Color.black);
      g.fillRect(0, 0, 1375, 875);

      g.setColor(Color.green);
      g.fillRect(x,y,100,100);
    }
  }
}
