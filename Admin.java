/**
*Class used to represent an Admin
*/
public class Admin extends Main implements Worker
{
private String username;
private String password;
public static boolean shouldWrite;

	/**
	*Consructs an Admin
	*@param user username
	*@param pass password
	*/
	public Admin(String user, String pass, boolean write)
	{
		username = user;
		password = pass;
		shouldWrite = write;
	}
	
	/**
	*Gives Admin username
	*@return Username
	*/
	public String getUsername(){
		return username;
	}
	
	/**
	*Gives Admin password
	*@return Password
	*/
	public String getPassword(){
		return password;
	}
	
	/**
	*Logs in admin
	*/
	public void login(){
	Main.adminFrame.setVisible(true);
	}
	
	public void logout(){
	Main.adminFrame.setVisible(false);
	}

}
