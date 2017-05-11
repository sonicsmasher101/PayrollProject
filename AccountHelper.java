import java.util.HashMap;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

public class AccountHelper{
  private Admin admin;
  private HashMap<String, Integer> employees;
  
  /**
  *AccountHelper class that is simply meant to store usernames and password of admins and employees seperately.
  *@param Username for first admin
  *@param Password for first admin
  */
  public AccountHelper(String username, String password){
    admin = new Admin(usernmae, password);
  }
  
   /**
  *Adds new admin to system
  *@param Username for new employee
  *@param Password for new employee
  */
  public void addEmployee(Employee e){
    employees.put(e.getUsername(), e.getID());
  }
  
  /**
  *Gives password of the admin
  *@param The admin username
  */
  public String getPasswordAdmin(){
    return admin.getPassword();
  }
  
  /**
  *Gives password of an employee given their username if the username exists, will return null otherwise
  *@param The employee username
  */
  public String getID(String user){
    if(checkUsername(user)) return employees.get(user);
    else return null;
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
