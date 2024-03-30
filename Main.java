import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/hP";
        String username = "root";
        String Password = "abhijit@123";
        String query = "Insert Into employees(id,name,Salary) values (3, 'Abhijit',6000.0)";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Successfully !!!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());

        }
        try{
            Connection con = DriverManager.getConnection(url,username,Password);
            System.out.println("connection Establish Successfully");
            Statement stmt = con.createStatement();
             int rowsaffected = stmt.executeUpdate(query);
             if(rowsaffected>0) {
                 System.out.println("Insert Successfull" + rowsaffected + "roe(s) affected");
             }else{
                 System.out.println("Insertion Failed");

            }


            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection close successfully !!!!!!");

    } catch (Exception e) {
        System.out.println(e.getMessage());

    }
}



    }
