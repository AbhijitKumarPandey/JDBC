

import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        String url ="jdbc:mysql://localhost:3306/hp";
        String username = "root";
        String password = "abhijit@123";
        String query = "select * from employees where name   ? " ;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully ");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established Successfully ");

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,"Abhijit" );

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double Salary = resultSet.getDouble("Salary") ;

                System.out.println(" id " + id );
                System.out.println("name" + name);
                System.out.println("Salary" + Salary);

            }
            resultSet.close();
            preparedStatement.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed Successfully");

            }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        }
    }
