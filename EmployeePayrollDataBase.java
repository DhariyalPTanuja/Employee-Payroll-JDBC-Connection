import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;

public class EmployeePayrollDataBase {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll";
		String userName = "root";
		String password = "root";
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loades!!");
			
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("can not find the driver in the classpath:", e);
		}
		listDrivers();
		try {
			System.out.println("Connecting to database: " + jdbcURL);
			conn = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is sucessfull!!! " + conn);
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from payroll_employee");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " ");
				System.out.print(resultSet.getDouble(3) + " ");
				System.out.print(resultSet.getString(4) + " ");
				System.out.print(resultSet.getString(5) + " ");
				System.out.print(resultSet.getString(6) + " ");
				System.out.println();

			}
		} catch (Exception e) {

		}
	}

	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}
	}

