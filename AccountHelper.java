import java.util.HashMap;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

public class AccountHelper{
  private Admin admin;
  private HashMap employees;
  
  /**
  *AccountHelper class that is simply meant to store usernames and password of admins and employees seperately.
  *@param Username for first admin
  *@param Password for first admin
  */
  public AccountHelper(String username, String password){
    admin = new Admin(username, password);
    employees = new HashMap<String, Integer>();
  }
  
   /**
  *Adds new admin to system
  *@param Username for new employee
  *@param Password for new employee
  */
  public void addEmployee(Employee e){
    employees.put(e.getName(), (Integer)e.getID());
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
    if(checkUsername(user)) return (Integer) employees.get(user);
    else return -1;
  }
	
  /**
  *Checks if given username exists
  *@param Test Username
  */
  public boolean checkUsername(String user){
    return employees.containsKey(user);
  }
  
  /**
  *Universal method meant for adding on extra info into a file
  *@param info to be added
  *@param file to add to
  */
  public static void add(String info, File file){
    try{
    Scanner reader = new Scanner(file);
    PrintWriter writer = new PrintWriter(file);
    while(reader.hasNext()){
      writer.println(reader.next());
    }
    writer.println(info);
	  }
	  catch(FileNotFoundException e){}
	  }
	  

}
