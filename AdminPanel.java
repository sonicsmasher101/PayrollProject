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
    succ.setIcon(new ImageIcon("src//SUCC.gif"));
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

	  public void actionPerformed(ActionEvent event){
		  String eName = name.getText();
		  name.setText(null);
		  int eID = 0;
		  double ePay = 0;
		  try{
		  eID = Integer.parseInt(id.getText());
		  id.setText(null);
		  }
		  catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Error on adding employee, make sure id field is correct!", "Error on adding employee, make sure id field is correct!", JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		  }
		  try{
		  ePay = Double.parseDouble(pay.getText());
		  pay.setText(null);
		  }
		  catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Error on adding employee, make sure payrate field is correct!", "Error on adding employee, make sure payrate field is correct!", JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
		  }
		  try{
			if(!helper.checkUsername(eName)) helper.addEmployee(new Employee(eName, eID, ePay));
			}
		   catch (FileNotFoundException e) {
			System.err.println(e);
		}
		  if(helper.checkUsername(eName)) JOptionPane.showMessageDialog(null, "Employee " + eName + " already exists!");
		  else JOptionPane.showMessageDialog(null, "Succesfully added employee!");
	  }
	}
  
  private class RemoveButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event)
      {
          String name = JOptionPane.showInputDialog("Name of employee to be removed");
          String adminPass = JOptionPane.showInputDialog("Please enter admin password to continue");
          if(adminPass.equals(helper.getAdminPassword()))
          {
              if(helper.checkUsername(name)){
		      helper.removeEmployee(name);
		      JOptionPane.showMessageDialog(null, "Employee removed!");
	      }
              else JOptionPane.showMessageDialog(null, "Employee name doesn't exist!");
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
