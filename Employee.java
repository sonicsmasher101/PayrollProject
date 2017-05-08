import java.util.File;
import java.util.ArrayList;

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
public static ArrayList<long> clockTimes;
  
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
    clockInTime = System.timeInMillis();
    clockOutTime = clockInTime;
    clockable = false;
    return true;
    }
    else return false;
  }
  
  /**
  *Clocks out Employee
  */
  public boolean clockOut(){
    if(!clockable){
    clockOutTime = System.timeInMillis();
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
    	clockInTime = System.timeInMillis();
    	clockOutTime = clockInTime;
    	clockable = false;
    	return true;
   		}
  else return false;
}

  public void logout()
  {
  	if(!clockable){
    clockOutTime = System.timeInMillis();
    clockTimes.add(clockOutTime - clockInTime);
    clockable = true;
    clockOutTime = 0;
    clockInTime = 0;
    return true;
    }
    else return false;
  }
}
