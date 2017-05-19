/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

/**
 *
 * @author Yoga Mahartayasa
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;;

public class PushPanel extends JPanel{
private AccountHelper helper;
private JButton eButton;
private JButton aButton;
private JButton eBButton;
private JButton aBButton;
private JLabel succ;
	public PushPanel(AccountHelper helper){
		this.helper = helper;
		setPreferredSize(new Dimension(300, 400));
		setBackground(Color.DARK_GRAY);
		eButton = new JButton("Employee Login");
                eBButton = new JButton("Employee Logout");
                aButton = new JButton("Admin Login");
                aBButton = new JButton("Admin Logout");
		succ = new JLabel();
		eButton.addActionListener(new EmployeeButtonListener());
		aButton.addActionListener(new AdminButtonListener());
                eBButton.addActionListener(new EmployeeButtonListenerB());
                aBButton.addActionListener(new AdminButtonListenerB());
		add(eButton);
		add(aButton);
                add(eBButton);
                add(aBButton);
		succ.setIcon(new ImageIcon("src\\SUCC.jpg"));
		succ.setText("SUCC");
		add(succ);
	}
	
	private class EmployeeButtonListener implements ActionListener{
		//Needs to be properly completed, error code may be incorrect
		public void actionPerformed(ActionEvent event){
			String username = "";
			boolean cont = true;
                        Employee t = null;
			while(!helper.checkUsername(username) && cont){
				username = JOptionPane.showInputDialog("Input valid username:");
				if(username.equals("")) cont = false;
			}

			String id = "-1";
			int idNum = helper.getID(username);
			while(helper.getID(username) != Integer.parseInt(id)){
				id = JOptionPane.showInputDialog("Enter id:");
				try{
				Integer.parseInt(id);
				}
				catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Number not entered, please enter an integer", "Number not entered, please enter an integer", JOptionPane.WARNING_MESSAGE);
				}
			}
			JOptionPane.showMessageDialog(null, "Login Successful");
                        t= helper.getEmployee(username);
                        t.login();
			
		}
	}
        
        private class EmployeeButtonListenerB implements ActionListener{
		//Needs to be properly completed, error code may be incorrect
		public void actionPerformed(ActionEvent event){
			String username = "";
			boolean cont = true;
                        Employee t = null;
			while(!helper.checkUsername(username) && cont){
				username = JOptionPane.showInputDialog("Input valid username:");
				if(username.equals("")) cont = false;
			}

			String id = "-1";
			int idNum = helper.getID(username);
			while(helper.getID(username) != Integer.parseInt(id)){
				id = JOptionPane.showInputDialog("Enter id:");
				try{
				Integer.parseInt(id);
				}
				catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Number not entered, please enter an integer", "Number not entered, please enter an integer", JOptionPane.WARNING_MESSAGE);
				}
			}
                        t =helper.getEmployee(username);
                        t.logout();
			JOptionPane.showMessageDialog(null, "Logout Successful");
                        
			
		}
	}
		
	private class AdminButtonListener implements ActionListener{
		//Needs to be properly completed, error code may be incorrect
		public void actionPerformed(ActionEvent event){
			String username = "";
			boolean cont = true;
			while(!helper.getAdminUsername().equals(username) && cont){
				username = JOptionPane.showInputDialog("Input username:");
				if(username.equals("")) cont = false;
			}

			String pass = "";
			String password = helper.getAdminPassword();
			int count = 3;
			while(!pass.equals(password) && count > 0){
				pass = JOptionPane.showInputDialog("Enter password:");
				count--;
			}
			if(count != 0){
                            JOptionPane.showMessageDialog(null, "Login successful");
                            helper.getAdmin().login();
                            
                        }
			else JOptionPane.showMessageDialog(null, "Incorrect Password Entered Too Many Times", "Incorrect Password Entered Too Many Times", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
        
        private class AdminButtonListenerB implements ActionListener{
		//Needs to be properly completed, error code may be incorrect
		public void actionPerformed(ActionEvent event){
			String username = "";
			boolean cont = true;
			while(!helper.getAdminUsername().equals(username) && cont){
				username = JOptionPane.showInputDialog("Input username:");
				if(username.equals("")) cont = false;
			}

			String pass = "";
			String password = helper.getAdminPassword();
			int count = 3;
			while(!pass.equals(password) && count > 0){
				pass = JOptionPane.showInputDialog("Enter password:");
				count--;
			}
			if(count != 0){
                            JOptionPane.showMessageDialog(null, "Logout successful");
                            helper.getAdmin().logout();
                            
                        }
			else JOptionPane.showMessageDialog(null, "Incorrect Password Entered Too Many Times", "Incorrect Password Entered Too Many Times", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
}
