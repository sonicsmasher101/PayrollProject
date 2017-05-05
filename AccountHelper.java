import java.util.HashMap;

public class AccountHelper{
  private HashMap<String, String> admins;
  private HashMap<String, String> employees;
  
  /**
  *AccountHelper class that is simply meant to store usernames and password of admins and employees seperately.
  *@param Username for first admin
  *@param Password for first admin
  */
  public AccountHelper(String username, String password){
    admins.put(username, password);
  }
  
  /**
  *Adds new admin to system
  *@param Username for new admin
  *@param Password for new admin
  */
  public void addAdmin(String user, String pass){
    admins.put(user, pass);
  }
  
   /**
  *Adds new admin to system
  *@param Username for new employee
  *@param Password for new employee
  */
  public void addEmployee(String user, String pass){
    employees.put(user, pass);
  }
  
  /**
  *Gives password of an admin given their username
  *@param The admin username
  */
  public String getPasswordAdmin(String user){
    if(admins.containsKey(user)) return admins.get(user);
    else return null;
  }
  
  /**
  *Gives password of an employee given their username
  *@param The employee username
  */
  public String getPasswordEmployee(String user){
    if(employees.containsKey(user)) return employees.get(user);
    else return null;
  }
  
}
