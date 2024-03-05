package customerpublish;

public interface ServicePublish {
	public String publishService();
	public int addCustomer(String id,String name,String vehivalType, String vehicalNumber);
	public void displayCustomerDetails();
	public void deleteCustomerDetails(int index);
//	public void deleteVaccine(String index);
	public int updateCustomer(String id,String name,String vehivalType, String vehicalNumber);
	
}
