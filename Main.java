import javax.swing.JFrame;

public class Main{
    public static void main(String[] args){
    JFrame frame = new JFrame("Payroll Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    public static AccountHelper Tarun = new AccountHelper("Tarun", "AD");
    Tarun.addEmployee(new Employee("Jonathan Corderdo", 6969));
    frame.add(new PushEmployeePanel(Tarun));
    frame.setVisible(true);
    //Gui code goes here
  
  }
}
