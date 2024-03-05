package customersubscribe;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import customerpublish.ServicePublish;

public class ServiceActivator implements BundleActivator {

	ServiceReference<?> serviceReference;
	Scanner myScanner = new Scanner(System.in);
	Scanner add = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
		System.out.println("Customer Subscriber Service Start");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
		
		 int no;
			System.out.println("Welcome to Customer Registrations");
			System.out.println();
			System.out.println("1. Add New Customer");
			System.out.println("2. Display Customer Details");
			System.out.println("3. Update Customer");
			System.out.println("4. Delete Customer");
			System.out.println("5. Exit");
			System.out.println();		
			System.out.print("Enter Number: ");
			no = myScanner.nextInt();
			System.out.println();
			
			while(no < 6) {
				if(no == 1||no == 01) {
//					char result = 'y';
//					while(result == 'y' || result == 'Y') {
						try {
							String customerID;
							String customerName;
							String vehivalType;
							String vehicalNumber;
							
							System.out.print("Enter Customer ID:");
							customerID = add.nextLine();
							System.out.print("Enter Customer Name:");
							customerName = add.nextLine();
							System.out.print("Enter Vehical Type:");
							vehivalType = add.nextLine();
							System.out.print("Enter Vehical Number:");
							vehicalNumber = add.nextLine();
							System.out.println();
							
							int status = servicePublish.addCustomer(customerID,customerName,vehivalType,vehicalNumber);
							if(status == 1) {
								System.out.println("Customer added Successfully!");
								System.out.println();
							}
						} catch (Exception e) {
							System.out.println("Customer not added!");
							e.printStackTrace();
						}
										
//						System.out.print("Do you want to add a new Customer?");
//						String x = Character.toString(result);
//						x = add.nextLine();
//					}
					System.out.println("1. Add New Customer");
					System.out.println("2. Display Customer Details");
					System.out.println("3. Update Customer");
					System.out.println("4. Delete Customer");
					System.out.println("5. Exit");
					System.out.println();				
					System.out.print("Enter Number: ");
					no = myScanner.nextInt();
					System.out.println();
					
				}
				else if(no == 3||no == 03) {
					try {
						System.out.println();
						System.out.println("Index\tID\tName\tVtype\tVnumber");
						servicePublish.displayCustomerDetails();
						System.out.println();
						System.out.println("1. Add New Customer");
						System.out.println("2. Display Customer Details");
						System.out.println("3. Update Customer");
						System.out.println("4. Delete Customer");
						System.out.println("5. Exit");
						System.out.println();		
						System.out.print("Enter Number: ");
						no = myScanner.nextInt();
						System.out.println();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				else if(no == 4||no == 04) {
					try {
						System.out.println();
//						int choice;
						String customerID, newCustemorName, newVehicalType, newVehicalNumber = null;
						
						Scanner upd = new Scanner(System.in);
						
						System.out.println("Enter Customer ID: ");
						customerID = upd.nextLine();
//						System.out.println("1. Update Name");
//						System.out.println("2. Update Price");
//						System.out.println();
//						choice = upd.nextInt();

						System.out.println("Enter New Customer Name: ");
						newCustemorName = upd.nextLine();
					
						System.out.println("Enter New Vehical Type: ");
						newVehicalType = upd.nextLine();
						
						System.out.println("Enter New Vehical Number: ");
						newVehicalType = upd.nextLine();
						
			
						
						int status = servicePublish.updateCustomer(customerID, newCustemorName, newVehicalType, newVehicalNumber);
						if(status == 1) {
							System.out.println("Customer Updated Successfully!");
							System.out.println();
						}
						
						System.out.println();
						System.out.println("1. Add New Customer");
						System.out.println("2. Display Customer Details");
						System.out.println("3. Update Customer");
						System.out.println("4. Delete Customer");
						System.out.println("5. Exit");
						System.out.println();		
						System.out.print("Enter Number: ");
						no = myScanner.nextInt();
						System.out.println();
					} catch (Exception e) {
						System.out.println("Customer Not Updated!");
						e.printStackTrace();
					}
				}
				else if(no == 5||no == 05) {
					try {
						System.out.println("Enter Customer ID");
//						String id = myScanner.nextLine();
						int index = myScanner.nextInt();
						System.out.println();
						System.out.println("Customer ID: "+index+" is deleted!");
//						System.out.println("Customer ID: "+id+" is deleted!");
						System.out.println();
						servicePublish.deleteCustomerDetails(index);
//						servicePublish.deletecusromer(id);
						System.out.println("1. Add New Customer");
						System.out.println("2. Display Customer Details");
						System.out.println("3. Update Customer");
						System.out.println("4. Delete Customer");
						System.out.println("5. Exit");
						System.out.println();		
						System.out.print("Enter Number: ");
						no = myScanner.nextInt();
						System.out.println();
					} catch (Exception e) {
						System.out.println("Customer Was Not Delelted!");
						e.printStackTrace();
					}
				}
				else if(no == 5||no == 05) {
					try {
						stop(context);
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else {
						System.out.println("Enter a valid number!");
						System.out.println();
						System.out.println("1. Add New Customer");
						System.out.println("2. Display Customer Details");
						System.out.println("3. Update Customer");
						System.out.println("4. Delete Customer");
						System.out.println("5. Exit");
						System.out.println();		
						System.out.print("Enter Number: ");
						no = myScanner.nextInt();
						System.out.println();	
				}
			}	    
		}
		public void stop(BundleContext Context) throws Exception {
			try {
				System.out.println("Service ended!!!");
				Context.ungetService(serviceReference);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}