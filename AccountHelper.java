import java.util.HashMap;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

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
