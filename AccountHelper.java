import java.util.HashMap;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

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
  *Adds new admin to system
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
  
  public boolean removeEmployee(String name) throws FileNotFoundException{
    boolean found = false;
      if(checkUsername(name)){
		for(int i=0; i<employees.size(); i++)
                {
                    if(name.equals(employees.get(i).getName())){
                        add("Employee was removed",getEmployee(name).getFile());
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
  *@return The admin username
  */
  public String getAdminPassword(){
    return admin.getPassword();
  }
  
  /**
   *Gives username of the admin
   * @return The admin password
   */
  public String getAdminUsername(){
	return admin.getUsername();
  }
  
  /**
  *Gives password of an employee given their username if the username exists, will return null otherwise
  *@param The employee username
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
   * Gets the employee from the employee array list
   * @param name name of employee
   * @return the employee wanted
   */
  public Employee getEmployee(String name)
  {
      Employee t = null;
      for(int i=0; i<employees.size(); i++)
      {          
          if(name.equals(employees.get(i).getName()))
          t=employees.get(i);
      }
      return t;
      
  }
  
  /**
   * returns the admin associated with this account
   * @return the admin
   */
  public Admin getAdmin()
  {
      return admin;
  }
  
  public boolean checkUniqueID(double id)
  {
      for(int i=0; i<employees.size(); i++)
      {
          if(id==employees.get(i).getID())
              return false;
      }
      return true;
  }
	  

}
