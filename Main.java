import java.util.*;
import javax.swing.*;
import java.io.*;

public class Main{
  public static JFrame adminFrame;
    public static void main(String[] args) throws FileNotFoundException{
    JFrame frame = new JFrame("Payroll Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 350);
    frame.setLocationRelativeTo(null);
    ImageIcon icon = new ImageIcon("SUCC.gif");
    frame.setIconImage(icon.getImage());
    frame.setResizable(false);
    AccountHelper Tarun = new AccountHelper("Tarun", "AD");
    adminFrame = new JFrame("Admin");
    adminFrame.add(new AdminPanel(Tarun));
    adminFrame.setSize(400, 500);
    adminFrame.setLocationRelativeTo(null);
    adminFrame.setVisible(false);
    adminFrame.setResizable(false);
    frame.add(new PushPanel(Tarun));
    frame.setVisible(true);
  }
}
