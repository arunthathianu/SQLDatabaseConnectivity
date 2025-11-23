package sqlConnectionUtility;
import java.sql.*;

public class Sqlconnectivity {

	public static void main(String[] args) {

//		String url = "jdbc:jtds:sqlserver://localhost:1433/STUDENT_DETAILS;user=arunthathi;password=Arunthathi!87;";

		//String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=STUDENT_DETAILS;user=arunthathi;password=Arunthathi!87;";
		//String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=STUDENT_DETAILS;encrypt=false;";
		String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=STUDENT_DETAILS;";
        String user = "arunthathi";
        String password = "Arunthathi!87";
		
        String query = "SELECT * FROM STUDENT";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Print column headers
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(meta.getColumnName(i));
                if (i < columnCount) System.out.print(" | ");
            }
            System.out.println();

            // Print rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i));
                    if (i < columnCount) System.out.print(" | ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
