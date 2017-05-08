import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PushCounterPanel extends JPanel{
	private int count;
	private JButton push;
	private JLabel label;
	
	public PushCounterPanel(){
		count = 0;
		
		push = new JButton("Smack dat like button!");
		push.addActionListener(new ButtonListener());
		
		label = new JLabel("Likes: " + count);
		
		add(push);
		add(label);
		setPreferredSize(new Dimension(300, 400));
		setBackground(Color.cyan);
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			count++;
			label.setText("Likes: " + count);
		}
		
	}
}
