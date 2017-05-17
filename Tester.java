import java.util.Scanner;

public class Tester{
  public static JFrame adminFrame;
    public static void main(String[] args){
    JFrame frame = new JFrame("Payroll Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    AccountHelper Tarun = new AccountHelper("Tarun", "AD");
    adminFrame = new JFrame("Admin");
    adminFrame.add(new AdminPanel(Tarun));
    adminFrame.setSize(400, 400);
    adminFrame.setVisible(false);
    Tarun.addEmployee(new Employee("Jonathan Cordero", 6969, 420.69));
    frame.add(new PushPanel(Tarun));
    frame.setVisible(true);
  }
}
