/**
*Class to represent an Employee
*/
public class Employee{

private String name;
private int id;
private int clockInTime;
private int clockOutTime;
private double payRate;
private boolean clockable;
  
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
  public String getID(){
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
    clockable = true;
    return true;
    }
    else return false;
  }
    
  /**
  *Gives last clock in time
  *@return Clock in time
  */
  public int getClockInTime(){
    return clockInTime;
  }
    
  /**
  *Gives last clock out time
  *@return Clock out time
  */
  public int getClockOutTime(){
    return clockInTime;
  }
  
  /**
  *Gets the pay for the day for the employee
  *@return the pay for the day
  */
  public double getPay()
  {
    return ((clockOutTime-clockInTime)/60000)*payRate;
  }  

}
