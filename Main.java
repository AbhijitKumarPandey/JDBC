import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String Password = "abhijit@123";
        String query = "select * from employees";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Successfully !!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }
        try {
            Connection con = DriverManager.getConnection(url, username, Password);
            System.out.println("Connection Establish Successfully");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("=============");
                System.out.println(" Id " + id);
                System.out.println(" Name " + name);
                System.out.println(" Job_title " + job_title);
                System.out.println(" Salary " + salary);
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection close successfully !!!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }


}

