package lab8;

import java.sql.*;

public class MainApp {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/lab8?serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(url, "root", "NmY67IoN");
        Statement sql = connection.createStatement();
        ResultSet rs;
        rs = sql.executeQuery("select * from persoane");
        /*while (rs.next()) {
            System.out.println("id=" + rs.getInt("id") + ", nume= " + rs.getString("nume") + ",varsta=" + rs.getInt("varsta"));
        }*/
        Persoane pers = new Persoane(3, "Octa", 69);
        // adaugarePers(connection, pers.getId(), pers.getNume(), pers.getVarsta());
        //adaugareExcursie(connection, 3, 4, "Carcea", 2034);
        afisareID(connection,3);
        afisarePers(connection,"'Calin'");
        afisareAn(connection,2034);
        afisareDestinatia(connection,"'Arad'");
    }
    public static void afisareID(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM PERSOANE a LEFT JOIN EXCURSII b ON a.id=b.id WHERE a.id="+id;
        Statement sql = connection.createStatement();
        ResultSet rs;
        rs = sql.executeQuery(query);
        while (rs.next()) {
            System.out.println("id=" + rs.getInt("id") + ", nume= "
                    + rs.getString("nume") + ",varsta=" + rs.getInt("varsta") +rs.getString("destinatia"));
        }
    }
    public static void afisarePers(Connection connection, String pers) throws SQLException {
        String query = "SELECT * FROM PERSOANE a LEFT JOIN EXCURSII b ON a.id=b.id WHERE a.nume="+pers;
        Statement sql = connection.createStatement();
        ResultSet rs;
        rs = sql.executeQuery(query);
        while (rs.next()) {
            System.out.println("id=" + rs.getInt("id") + ", nume= " + rs.getString("nume") + ",varsta=" + rs.getInt("varsta") +rs.getString("destinatia"));
        }
    }
    public static void afisareDestinatia(Connection connection, String destinatia) throws SQLException {
        String query = "SELECT * FROM PERSOANE a LEFT JOIN EXCURSII b ON a.id=b.id WHERE b.destinatia="+destinatia;
        Statement sql = connection.createStatement();
        ResultSet rs;
        rs = sql.executeQuery(query);
        while (rs.next()) {
            System.out.println("id=" + rs.getInt("id") + ", nume= " + rs.getString("nume") + ",varsta=" + rs.getInt("varsta") +rs.getString("destinatia"));
        }
    }
    public static void afisareAn(Connection connection, int an) throws SQLException {
        String query = "SELECT * FROM PERSOANE a LEFT JOIN EXCURSII b ON a.id=b.id WHERE b.an="+an;
        Statement sql = connection.createStatement();
        ResultSet rs;
        rs = sql.executeQuery(query);
        while (rs.next()) {
            System.out.println("id=" + rs.getInt("id") + ", nume= " + rs.getString("nume") + ",varsta=" + rs.getInt("varsta") +rs.getString("destinatia")+ rs.getInt("an"));
        }
    }
    public static void adaugarePers(Connection connection, int id, String nume, int varsta) {
        String sql = "insert into persoane values (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nume);
            ps.setInt(3, varsta);
            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare=" + nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void stergere(Connection connection,int id){
        String sql="delete from persoane where id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de modificare="+nr_randuri);
        }
        catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void adaugareExcursie(Connection con, int idPers, int excursie, String destinatia, int an) {
        String query = "SELECT * FROM persoane WHERE id" + "=" + idPers;
        try (Statement sql = con.createStatement()) {
            ResultSet rs;
            rs = sql.executeQuery(query);
            if (!rs.next()) {
                System.out.println("NICIUN REZULTAT NU A FOST GASIT");
                return;
            }
            rs.beforeFirst();
            String query2 = "insert into excursii values (?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query2)) {
                ps.setInt(1, excursie);
                ps.setInt(2, idPers);
                ps.setString(3, destinatia);
                ps.setInt(4, an);
                int nr_randuri = ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}