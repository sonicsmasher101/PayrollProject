import javax.swing.JFrame;

public class Main{

  public static void main(String[] args){
    JFrame frame = new JFrame("Payroll Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    frame.add(new PushCounterPanel());
    frame.setVisible(true);
  }
}
