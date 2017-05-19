package payroll;

import java.util.HashMap;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

public class AccountHelper{
  private Admin admin;
  private HashMap employeePasswords;
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
    Scanner reader = new Scanner(file);
    PrintWriter writer = new PrintWriter(file);
    while(reader.hasNext()){
      writer.println(reader.next());
    }
    writer.println(info);
}
  
  /**
  *Gives index of employee searched for, or -1 if they don't exist
  *@return index
  */
  public int getEmployee(String name)
  {
      int index = -1;
      for(int i=0; i<employees.size(); i++)
      {          
          if(name.equals(employees.get(i).getName()))
          index = i;
      }
      return index;
      
  }
	
  /**
  *Gives the admin of the system
  *@return admin
  */
  public Admin getAdmin(){
	  return admin;
  }

}
