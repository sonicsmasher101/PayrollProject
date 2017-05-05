/**
  Class to represent an Employee
*/
public class Employee{

private String username;
private String password;
private int clockInTime;
private int clockOutTime;
private double payRate;
  
  /**
  *Creates an Employee with username and password
  *@param Employee's username
  *@param Employee's password
  */
  public Employee(String user, String pass, double payR){
    username = user;
    password = pass;
    payRate=payR;
  }
  
  /**
  *Gives employee's username
  *@return Username
  */
  public String getUsername(){
    return username;
  }
   
  /**
  *Gives employee's password
  *@return Password
  */
  public String getPassword(){
    return password;
  }
  
  /**
  *Clocks in Employee and refreshes clock out time
  */
  public void clockIn(){
    clockInTime = System.timeInMillis();
    clockOutTime = System.timeInMillis();
  }
  
  /**
  *Clocks out Employee
  */
  public void clockOut(){
    clockOutTime = System.timeInMillis();
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
    Gets the pay for the day for the employee
    @return the pay for the day
  */
  public double getPay()
  {
    return (clockOutTime-clockInTime)*payRate;
  }  

}
