import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer1";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);

            String query1 = ""
                    + "ALTER TABLE develhope_test "
                    + "ADD country varchar(30);";

            ps = conn.prepareStatement(query1);
            ps.executeUpdate();

            ps1 = conn.prepareStatement("UPDATE develhope_test SET country = ? WHERE id = ?");

            for(int i=1; i<5; i++ ) {
                if(i<3) {
                    String country = "Italy";
                    ps1.setString(1, country);
                    ps1.setString(2, String.valueOf(i));
                    ps1.executeUpdate();
                }else{
                    String country = "Germany";
                    ps1.setString(1, country);
                    ps1.setString(2, String.valueOf(i));
                    ps1.executeUpdate();
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (ps != null)
                    ps.close();
                if (ps1 != null)
                    ps1.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }
}