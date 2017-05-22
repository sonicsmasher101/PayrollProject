import java.io.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
*Class to represent an Employee
*/
public class Employee implements Worker
{

private String name;
private int id;
private long clockInTime;
private long clockOutTime;
private double payRate;
private boolean clockable;
private File file;
public ArrayList<Long> clockTimes;
private Timer autoLogout;
private boolean showMessage;
  
  /**
  *Creates an Employee with username and password
  *@param Employee's username
  *@param Employee's password
  */
  public Employee(String name, int id, double payR) throws FileNotFoundException{
    this.name = name;
    this.id = id;
    payRate = payR;
    clockable = true;
    file = new File(name+".txt");
    PrintWriter writer = new PrintWriter(file);
    writer.println("Information for: " + name);
    autoLogout = new Timer();
    clockTimes = new ArrayList<Long>();
    showMessage = false;
  }
  
  /**
  *Gives employee's name
  *@return name
  */
  public String getName(){
    return name;
  }
   
  /**
  *Gives employee's ID
  *@return ID
  */
  public int getID(){
    return id;
  }
  
  /**
  *Clocks in Employee and refreshes clock out time
  */
  public boolean clockIn(){
    if(clockable){
    clockInTime = System.currentTimeMillis();
    clockOutTime = clockInTime;
    clockable = false;
    return true;
    }
    else 
    	return false;
  }
  
  /**
  *Clocks out Employee
  */
  public boolean clockOut(){
    if(!clockable){
    clockOutTime = System.currentTimeMillis();
    clockTimes.add(clockOutTime - clockInTime);
    clockable = true;
    clockOutTime = 0;
    clockInTime = 0;
    return true;
    }
    else return false;
  }
    
  /**
  *Gives last clock in time
  *@return Clock in time
  */
  public long getClockInTime(){
    return clockInTime;
  }
    
  /**
  *Gives last clock out time
  *@return Clock out time
  */
  public long getClockOutTime(){
    return clockOutTime;
  }
  
  /**
  *Gets the pay for all the shifts worked by employee then removes those hours from the system for the employee
  *@return pay for employee
  */
  public double getPay()
  {
    long hours = 0;
    for(long element : clockTimes) hours += element;
    for(int i = 0; i < clockTimes.size(); i++) clockTimes.remove(0);
    return (double)(hours/60000) * payRate;
  }  
  
  /**
  *Logs in employee
  */
  public void login(){
  if(clockable){
    	clockInTime = System.currentTimeMillis();
    	clockOutTime = clockInTime;
    	clockable = false;
	autoLogout.schedule(autoOut,60000 * 8);
	if(showMessage){
			JOptionPane.showMessageDialog(null, "You have been logged in, please remember to logout at the right time next time");
			showMessage = false;
			}
   		} 

}

  public void logout()
  {
  	if(!clockable){
    clockOutTime = System.currentTimeMillis();
    clockTimes.add(clockOutTime - clockInTime);
    clockable = true;
    clockOutTime = 0;
    clockInTime = 0;

  	}
  }
  
   public String toString()
  {
  	return("Name: " + this.getName() + " ID: " + this.getID() + " Pay: " + this.getPay() + " Amount to Pay: " + this.getPay());
  }
 
 
  TimerTask autoOut = new TimerTask () {
    @Override
    public void run () {
       logout();
       showMessage = true;
    }
};
}
