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
    file.setWritable(false);
    PrintWriter writer = new PrintWriter(file);
    writer.println("");
    AccountHelper.add(toString(), file);
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
   *Gives employee's payrate
   *@return payrate
   */
   public double getPayrate(){
     return payRate;
   }
   
   /**
   *Gives employee's file
   *@return payrate
   */
   public File getFile(){
     return file;
   }
  
  /**
  *Clocks in Employee and refreshes clock out time
  */
  public boolean clockIn(){
    if(clockable){
    if(showMessage) JOptionPane.showMessageDialog(null, "WARNING: Make sure to clock out on time next time!", "WARNING: Make sure to clock out on time next time!", JOptionPane.ERROR_MESSAGE);
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
  public double getPay() throws FileNotFoundException
  {
    long hours = 0;
    for(long element : clockTimes) hours += element;
    for(int i = 0; i < clockTimes.size(); i++) clockTimes.remove(0);
    AccountHelper.add("Wages out: "+(hours/60000) * payRate,file);
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
  	return("Name: " + this.getName() + " ID: " + this.getID() + " Pay: " + this.getPayRate());
  }
   
   public File getFile(){
       return file;
   }
 
 
  TimerTask autoOut = new TimerTask () {
    @Override
    public void run () {
       logout();
       showMessage = true;
    }
};
}
