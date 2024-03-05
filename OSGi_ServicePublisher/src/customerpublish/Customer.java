package customerpublish;

public class Customer {
	public String customerName;
	private String customerID;
	private String vehicalType;
	private String vehicalNumber;
	
	public Customer(String cussID, String customerName, String vehicalType,String vehicalNumber ) {
		super();
		this.customerID = cussID;
		this.customerName = customerName;
		this.vehicalType = vehicalType;
		this.vehicalNumber = vehicalNumber;
	}
	public String getcustomerID() {
		return customerID;
	}

	public void setcustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getcustomerName() {
		return customerName;
	}

	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getvehicalType() {
		return vehicalType;
	}

	public void setvehicalType(String vehicalType) {
		this.vehicalType = vehicalType;
	}
	public String getvehicalNumber() {
		return vehicalNumber;
	}

	public void setvehicalNumber(String vehicalNumber) {
		this.vehicalNumber = vehicalNumber;
	}
	
	
}
	
	


