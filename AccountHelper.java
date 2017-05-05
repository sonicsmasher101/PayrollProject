import java.util.HashMap;

public class AccountHelper{
  private HashMap<String, String> admins;
  private HashMap<String, String> workers;
  
  public AccountHelper(String username, String password){
    admins.put(username, password);
  }
  
}
