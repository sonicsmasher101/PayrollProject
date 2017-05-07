/**
*Class used to represent an Admin, which is subclass of Employee
*/
public class Admin implements Worker
{
private String username;
private String password;

	/**
	*Consructs an Admin
	*@param user username
	*@param pass password
	*/
	public Admin(String user, String pass)
	{
		username = user;
		password = pass;
	}
	
	/**
	*Gives Admin username
	*@return Username
	*/
	public String getUsername(){
		return username;;
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
	//To be implemented
	}
}
