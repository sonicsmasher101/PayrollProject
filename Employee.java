import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
public static ArrayList<Long> clockTimes;
private Timer autoLogout;
  
  /**
  *Creates an Employee with username and password
  *@param Employee's username
  *@param Employee's password
  */
  public Employee(String name, int id, double payR){
    this.name = name;
    this.id = id;
    payRate = payR;
    clockable = true;
    file = new File(name);
    autoLogout = new Timer();
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
  *Gets the pay for the day for the employee
  *@return the pay for the day
  */
  public double getPay()
  {
    return ((clockOutTime-clockInTime)/60000)*payRate;
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
  TimerTask autoOut = new TimerTask () {
    @Override
    public void run () {
       logout();
    }
};
}
