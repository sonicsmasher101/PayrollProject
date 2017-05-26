import java.util.*;   
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class Main{
  public static JFrame adminFrame;
    public static void main(String[] args) throws FileNotFoundException{
    JFrame frame = new JFrame("Payroll Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    ImageIcon icon = new ImageIcon("SUCC.jpg");
    frame.setIconImage(icon.getImage());
    frame.setResizable(false);
    AccountHelper Tarun = new AccountHelper("Tarun", "AD");
    Scanner in = new Scanner(new File("src\\input.txt"));
    	String temporary = "";
    	if(in.hasNextLine()) temporary = in.nextLine().substring(4);
    	if(!temporary.equals("")){
    	String[] sections = temporary.split(" ");
    	for(String element : sections){
    		String[] temp = element.split(",");
    		Tarun.addEmployee(new Employee(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]), Long.parseLong(temp[3])));
    	}
    	}
    in.close();
    adminFrame = new JFrame("Admin");
    adminFrame.add(new AdminPanel(Tarun));
    adminFrame.setSize(400, 500);
    adminFrame.setLocationRelativeTo(null);
    adminFrame.setVisible(false);
    adminFrame.setResizable(false);
    frame.add(new PushPanel(Tarun));
    PrintWriter writer = new PrintWriter("input.txt");
    frame.addWindowListener(new WindowAdapter() {
 	   public void windowClosing(WindowEvent event) {
 		 String list = null;
 	     for(Employee element : Tarun.getEmployees()){
 	    	 list += element.toString() + " ";
 	     }
 	     writer.println(list);
 	     writer.close();
 	     frame.setVisible(false);
 	   }
 	  });
    frame.setVisible(true);
  }
}
