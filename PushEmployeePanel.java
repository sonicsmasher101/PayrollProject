import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class PushEmployeePanel extends JPanel{

	public PushEmployeePanel(){
		
		setPreferredSize(new Dimension(300, 400));
		setBackground(Color.black);
	}
	
	private class ButtonListener implements ActionListener{
		//Needs to be properly completed, error code may be incorrect
		public void actionPerformed(ActionEvent event){
			JOptionPane pane = new JOptionPane();
			String username = "";
			while(!AccountHelper.checkUsername(username)) username = pane.showInputDialog("Input correct username:");
			String id;
			int idNum = AccountHelper.getID(username);
			while(AccountHelper.getID(username) != Integer.parseInt(id)){
				id = pane.showInputDialog("Enter id:");
				try{
				Integer.parseInt(id);
				}
				catch(IllegalArgumentException e){
				System.err.println("Integer not entered!");
				}
			}
		}
		
	}
}
