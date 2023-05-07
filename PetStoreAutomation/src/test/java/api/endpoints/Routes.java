package api.endpoints;


// Here we have maintained only the URL's only

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	// User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	public static String login_url = base_url+"/user/login";
	public static String logout_url = base_url+"/user/logout";
	
		
	// Store Module 
	
	public static String postOrder_store = base_url+"/store/order";
	public static String getOrder_store = base_url+"/store/order/{id}";
	public static String deleteOrder_store = base_url+"/store/order/{id}";
	
	
	// Pet Module 
	
	public static String postNew_pet = base_url+"/pet";
	public static String get_pet = base_url+"/pet/{id}";
	public static String get_pet_find_by_Status = base_url+"/pet/findByStatus";
	public static String delete_pet = base_url+"/pet/{id}";
	
	
}
