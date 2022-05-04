package sample;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection()
    {
        String databaseName = "buffallo_burger";
        String databaseUsername = "root";
        String databasePassword = "*Mahimboss32#";
        String url ="jdbc:mysql://localhost/" + databaseName;

        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseLink =DriverManager.getConnection(url, databaseUsername, databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
