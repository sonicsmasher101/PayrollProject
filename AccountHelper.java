import java.io.*;
import java.util.*;

/**
*Makes accounthelper that stores all information on employees and the admin
*/
public class AccountHelper{
  private Admin admin;
  private HashMap<String, Integer> employeePasswords;
  private ArrayList<Employee> employees;
  
  /**
  *AccountHelper class that is simply meant to store usernames and password of admins and employees seperately.
  *@param Username for first admin
  *@param Password for first admin
  */
  public AccountHelper(String username, String password){
    admin = new Admin(username, password);
    employeePasswords = new HashMap<String, Integer>();
    employees = new ArrayList<Employee>();
  }
  
  /**
   * Gives whole arraylist of employees
   * @return employees
   */
  public ArrayList<Employee> getEmployees(){
	  return employees;
  }
  
   /**
  *Adds new employee to system
  *@param Employee object of new employee
  */
  public void addEmployee(Employee e){
    employeePasswords.put(e.getName(), (Integer)e.getID());
    employees.add(e);
  }
	
  /**
  *Removes employee from system
  *@param Name of employee to be removed
  *@return True if employee was removed, false if employee wasn't found
  */
  
  public boolean removeEmployee(String name){
    boolean found = false;
      if(checkUsername(name)){
		for(int i=0; i<employees.size(); i++)
                {
                    if(name.equals(employees.get(i).getName())){
                        employees.remove(i);
                        employeePasswords.remove(name);
                        found=true;
                    }
                }
                }
            return found;
	}
 
  
  
  
  /**
  *Gives password of the admin
  *@return The admin password
  */
  public String getAdminPassword(){
    return admin.getPassword();
  }
  
  /**
   *Gives username of the admin
   * @return The admin username
   */
  public String getAdminUsername(){
	return admin.getUsername();
  }
  
  /**
  *Gives password of an employee given their username if the username exists, will return null otherwise
  *@param The employee id
  */
  public int getID(String user){
    if(checkUsername(user)) return (Integer) employeePasswords.get(user);
    else return -1;
  }
	
  /**
  *Checks if given username exists
  *@param Test Username
  */
  public boolean checkUsername(String user){
    return employeePasswords.containsKey(user);
  }
  
  /**
  *Universal method meant for adding on extra info into a file
  *@param info to be added
  *@param file to add to
  */
  public static void add(String info, File file) throws FileNotFoundException{
    PrintWriter writer = new PrintWriter(new FileOutputStream(file, true));
    writer.println(info);
    writer.close();
}
  
  /**
  *Gives employee based on their name
  *@return employee
  */
  public Employee getEmployee(String name)
  {
	Employee e = null;
      for(int i=0; i<employees.size(); i++)
      {          
          if(name.equals(employees.get(i).getName()))
          e = employees.get(i);
      }
      return e;
      
  }
	
  /**
  *Gives the admin of the system
  *@return admin
  */
  public Admin getAdmin(){
	  return admin;
  }

}
