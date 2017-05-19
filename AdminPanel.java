import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminPanel extends JPanel{
private AccountHelper helper;
private JButton logout;
private JButton add;
private JButton remove;
private JButton calculate;
private JLabel succ;

  public AdminPanel(AccountHelper helper){
    this.helper = helper;
    setPreferredSize(new Dimension(300, 400));
    setBackground(Color.DARK_GRAY);
    setMinimumSize(new Dimension(300, 400));
    logout = new JButton("Logout");
    add = new JButton("Add Employee");
    remove = new JButton("Remove Employee");
    calculate = new JButton("Calculate Pay");
    logout.addActionListener(new LogoutListener());
    add.addActionListener(new AddButtonListener());
    remove.addActionListener(new RemoveButtonListener());
    calculate.addActionListener(new CalculateButtonListener());
    succ = new JLabel();
    succ.setIcon(new ImageIcon("src\\SUCC.gif"));
    add(add);
    add(remove);
    add(calculate);
    add(succ);
    add(logout);
  }

  private class AddButtonListener implements ActionListener{
		//Needs to be properly completed, error code may be incorrect
		public void actionPerformed(ActionEvent event){
      			String name;
			int id;
			double pay;
			name = JOptionPane.showInputDialog("Input new employee's name");
			//Add catch error stuff for int and double
			id = Integer.parseInt(JOptionPane.showInputDialog("Input new employee's id"));
			pay = Double.parseDouble(JOptionPane.showInputDialog("Input new employee's payrate"));
			helper.addEmployee(new Employee(name, id, pay));
		}
	}
  
  private class RemoveButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event)
      {
          String name = JOptionPane.showInputDialog("Name of employee to be removed");
          String adminPass = JOptionPane.showInputDialog("Please enter admin password to continue");
          if(adminPass.equals(helper.getAdminPassword()))
          {
              helper.removeEmployee(name);
          }
          else
          {
              JOptionPane.showMessageDialog(null, "Password not correct, employee not removed");
          }
      }
  }
	
  private class CalculateButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		String name = JOptionPane.showInputDialog("Name of employee to calculate pay for");
		double pay = 0;
		if(helper.checkUsername(name)){
			pay = helper.getEmployee(name).getPay();
			JOptionPane.showMessageDialog(null, name + "'s pay is: " + pay, name + "'s pay is: " + pay, JOptionPane.INFORMATION_MESSAGE);
		}
		else JOptionPane.showMessageDialog(null, name + " is not in the system, please try again", name + " is not in the system, please try again", JOptionPane.ERROR_MESSAGE);
		
	}
  }
	
  private class LogoutListener implements ActionListener{
	  public void actionPerformed(ActionEvent event){
		  JOptionPane.showMessageDialog(null, "Logged Out", "Logged Out", JOptionPane.INFORMATION_MESSAGE);
		  helper.getAdmin().logout();
	  }
  }
  
}
