import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	private int id;
	private String name;
	private double rate;
	
	public Employee(final int id, final String name, final double rate) {
		this.id = id;
		this.name = name;
		this.rate = rate;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setRate(final Double rate) {
		this.rate = rate;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getRate() {
		return rate;
	}
}

class Test {
	public static void main(final String[] args) {
		final ArrayList<Employee> employees = new ArrayList<Employee>();
		final Scanner scan = new Scanner(System.in);
		int id = 0;
		boolean exit = false;
		Employee e;
		
		do {
			System.out.println("Select Activity: ");
			System.out.println("1. Add Employee");
			System.out.println("2. Display all Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit Console");

			System.out.print("Option: ");
			final int option = scan.nextInt();
			
			switch(option) {
				case 1: 
					int last_id = employees.isEmpty() ? 0 : 1 + employees.get(employees.size() - 1).getID();
					System.out.print(last_id);
					employees.add(addEmployee(last_id)); 
				break;
				case 2: displayEmployees(employees); break;
				case 3: 
					System.out.print("Enter Employee ID: ");
					id = scan.nextInt();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						updateEmployee(e);
					}
				break;
				case 4: 
					System.out.print("Enter Employee ID: ");
					id = scan.nextInt();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						employees.remove(e);
					}
				break;
				case 5: exit = true; break;
			}
		} while(!exit);
		scan.close();
	}

	public static Employee addEmployee(final int last_id) {
		final Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee Name: ");
		final String name = scan.nextLine();
		System.out.print("Enter Employee Rate: ");
		final double rate = scan.nextDouble();
		return new Employee(last_id, name, rate);
	}

	public static void updateEmployee(final Employee employee) {
		final Scanner scan = new Scanner(System.in);
		System.out.println("Select Field to Update: ");
		System.out.println("1. Name");
		System.out.println("2. Rate");
		System.out.print("Option: ");
		final int option = scan.nextInt();
		
		System.out.print("Enter new value: ");
		String update = scan.next();
		switch(option) {
			case 1: employee.setName(update); break;
			case 2: employee.setRate(Double.parseDouble(update)); break;
		}

	}

	public static Employee searchEmployee(final int id, final ArrayList<Employee> employees) {
		for (final Employee employee : employees) {
			if (employee.getID() == id) {
				return employee;
			}
		}
		return null;
	}

	public static void displayEmployees(final ArrayList<Employee> employees) {
		if (employees.isEmpty()) {
			System.out.println("Cannot find employe record.");
			return;
		}
		System.out.println("List of Employees:");
		for (final Employee employee : employees) {
			System.out.println("ID: " + employee.getID() + ", Name: " + employee.getName() + ", Rate: " + employee.getRate());
		}
	}
}


