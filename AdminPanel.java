import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class AdminPanel extends JPanel{
private AccountHelper helper;
private JButton logout;
private JButton add;
private JButton remove;
private JButton calculate;
private JButton addMore;
private JButton payChange;	
private JLabel succ;
private JTextField name;
private JTextField id;
private JTextField pay;
private JLabel nameInfo;
private JLabel idInfo;
private JLabel payInfo;

  public AdminPanel(AccountHelper helper){
    this.helper = helper;
    setPreferredSize(new Dimension(300, 500));
    setBackground(Color.PINK);
    setMinimumSize(new Dimension(300, 500));
    logout = new JButton("Logout");
    add = new JButton("Add Employee");
    remove = new JButton("Remove Employee");
    calculate = new JButton("Calculate Pay");
    addMore= new JButton("Add extra employee info");
    nameInfo = new JLabel("Input name of new Employee:");
    name = new JTextField(25);
    idInfo = new JLabel("Input id of new Employee:");
    id = new JTextField(25);
    payInfo = new JLabel("Input payrate of new Employee:");
    pay = new JTextField(25);
	  payChange=new JButton("Change pay of employee");
    logout.addActionListener(new LogoutListener());
    add.addActionListener(new AddButtonListener());
    remove.addActionListener(new RemoveButtonListener());
    calculate.addActionListener(new CalculateButtonListener());
    addMore.addActionListener(new AddExtraListener());
	  payChange.addActionListener(new ChangePayListener());
    succ = new JLabel();
    succ.setIcon(new ImageIcon("SUCC.gif"));
    add(add);
    add(remove);
    add(calculate);
    add(logout);
    add(addMore);
    add(nameInfo);
    add(name);
    add(idInfo);
    add(id);
    add(payInfo);
    add(pay);
    add(succ);
    add(payChange);
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
			try{
			helper.addEmployee(new Employee(name, id, pay));
			}
			catch(FileNotFoundException e){
				System.err.println(e);
			}
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
		try{
		if(helper.checkUsername(name)){
			pay = helper.getEmployee(name).getPay();
			JOptionPane.showMessageDialog(null, name + "'s pay is: " + pay, name + "'s pay is: " + pay, JOptionPane.INFORMATION_MESSAGE);
		}
		else JOptionPane.showMessageDialog(null, name + " is not in the system, please try again", name + " is not in the system, please try again", JOptionPane.ERROR_MESSAGE);
		}
		catch(FileNotFoundException e){ System.err.println(e);}
	}
  }
	
  private class LogoutListener implements ActionListener{
	  public void actionPerformed(ActionEvent event){
		  JOptionPane.showMessageDialog(null, "Logged Out", "Logged Out", JOptionPane.INFORMATION_MESSAGE);
		  helper.getAdmin().logout();
	  }
  }
  
   private class AddExtraListener implements ActionListener{
       public void actionPerformed(ActionEvent event){
           try{
           String name = JOptionPane.showInputDialog("Name of employee to add info");
           File eFile = helper.getEmployee(name).getFile();
           PrintWriter writer = new PrintWriter(new FileOutputStream(eFile, true));
           String info = JOptionPane.showInputDialog("Extra info about employee");
           writer.println(info);
           }
           catch(FileNotFoundException e){}
           
       }
   }
	
	private class ChangePayListener implements ActionListener{
       public void actionPerformed(ActionEvent event){
           String name = JOptionPane.showInputDialog("Name of employee to change pay");
           String pay = JOptionPane.showInputDialog("New pay of employee");
           try{
               Integer.parseInt(pay);
	}
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Number not entered, please enter an integer", "Number not entered, please enter an integer", JOptionPane.WARNING_MESSAGE);
            }
           double newPay=Integer.parseInt(pay);
           helper.getEmployee(name).changePay(newPay);
           File file = helper.getEmployee(name).getFile();
           try{
           helper.add(helper.getEmployee(name).toString(),file);
           }
           catch(FileNotFoundException e){}
       }
   }
  
}
