import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminPanel{
private JButton add;
private JButton remove;
private JButton calculate;
private JLabel succ;

  public AdminPanel(){
    setPreferredSize(new Dimension(300, 400));
    setBackground(Color.DARK_GRAY);
    setMinimumSize(new Dimension(300, 400));
    add = new JButton("Add Employee");
    remove = new JButton("Remove Employee");
    calculate = new JButton("Calculate Pay");
    succ = new JLabel("SUCC");
    succ.setIcon(new ImageIcon("src\\SUCC.gif"));
    succ.setText("SUCC");
    add(add);
    add(remove);
    add(calculate);
    add(succ);
  }

  private class AddButtonListener implements ActionListener{
		//Needs to be properly completed, error code may be incorrect
		public void actionPerformed(ActionEvent event){
      
		}
	}
  
}
