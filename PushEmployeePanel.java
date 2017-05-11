import java.awt.*;
import java.awt.event.*;
import javax.swing.*;;

public class PushEmployeePanel extends JPanel{
private AccountHelper helper;
private JButton button;
	public PushEmployeePanel(AccountHelper helper){
		this.helper = helper;
		setPreferredSize(new Dimension(300, 400));
		setBackground(Color.DARK_GRAY);
		button = new JButton("Employee Login");
		button.addActionListener(new ButtonListener());
		add(button);
	}
	
	private class ButtonListener implements ActionListener{
		//Needs to be properly completed, error code may be incorrect
		public void actionPerformed(ActionEvent event){
			String username = "";
			boolean cont = true;
			while(!helper.checkUsername(username) && cont){
				username = JOptionPane.showInputDialog("Input correct username:");
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
				System.err.println("Integer not entered!");
				}
			}
			JOptionPane.showMessageDialog(null, "DERP!");
			
		}
		
	}
}
