package customerpublish;

import java.util.ArrayList;


public class ServicePublishimpl implements ServicePublish {
	private ArrayList<Customer> CustomerList = new ArrayList<Customer>();

	@Override
	public String publishService() {
		return "Execute the publish service of ServicePublisher";
	}
	
	public int addCustomer(String id,String name,String vehivalType, String vehicalNumber) {
		Customer customer = new Customer(id, name, vehivalType,vehicalNumber);
		CustomerList.add(customer);
		return 1;
	}
	
	

	@Override
	public int updateCustomer(String id,String name,String vehivalType, String vehicalNumber) {
		try {
			for(Customer cuss : CustomerList) {
				if(cuss.getcustomerID().equalsIgnoreCase(id)) {
					cuss.setcustomerName(name);
					cuss.setvehicalType(vehivalType);
					cuss.setvehicalNumber(vehicalNumber);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public void displayCustomerDetails() {
		int index = 0;
		for(Customer customer:CustomerList ) {
			index = index + 1;
			System.out.println(index+"\t"+customer.getcustomerID()+"\t"+customer.getcustomerName()+"\t"+customer.getvehicalType()+"\t"+customer.getvehicalNumber());	
		}
		if(index == 0) {
			System.out.println();
			System.out.println("No Customer Records Available");
	}
}

	

public void deleteCustomer(int id) {
		
		int a = id - 1;
		CustomerList.remove(a);
	}

@Override
public void deleteCustomerDetails(int index) {
	// TODO Auto-generated method stub
	
}


}
