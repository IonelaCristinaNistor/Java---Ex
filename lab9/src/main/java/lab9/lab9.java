package lab9;

import java.sql.*;

public class lab9 {
    public static void actualizare(Connection connection, int id, int varsta){
        String sql="update persoane set varsta=? where id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, varsta);
            ps.setInt(2,id);
            int nr_randuri= ((PreparedStatement) ps).executeUpdate();
            System.out.println("\nNumar randuri afectate de modificare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    //public static  void actulizare_excursii(Connection connection, int id, int)
    public static void adaugare(Connection connection, String nume, int varsta) {
        String sql="insert into persoane(nume,varsta) values (?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1, nume);
            ps.setInt(2, varsta);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void adaugare_excursie(Connection connection, int id_persoana, int anul, String destinatie) {
        String sql="insert into excursii(id_persoana,anul,destinatie) values (?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,id_persoana);
            ps.setInt(2,anul);
            ps.setString(3,destinatie);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void afisare_excursii(Statement statement, String mesaj) {
        String sql ="select * from excursii";
        System.out.println("\n---" + mesaj +"---");
        try(ResultSet rs =statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id_persoana = " + rs.getInt(1) +
                        ", id_excursii = " + rs.getInt(2)
                        + ",anul = " + rs.getInt(3)
                        + "destinatie = " +rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   public static void stergere(Connection connection, int id){
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
    public static void afisare_tabela(Statement statement, String mesaj) {
        String sql ="select * from persoane";
        System.out.println("\n---" + mesaj +"---");
        try(ResultSet rs =statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id = " + rs.getInt(1) + ", nume = " + rs.getString(2)
                        + ", varsta = " + rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/lab8?serverTimezone=UTC";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "NmY67IoN");
            Statement statement = connection.createStatement();
            afisare_tabela(statement,"Continut initial");
            afisare_tabela(statement,"Dupa modificare");
            adaugare(connection,"Dana",23);
            afisare_tabela(statement,"Dupa adaugare");
            stergere(connection, 4);
            afisare_tabela(statement, "Dupa stergere: ");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, "root", "NmY67IoN");
            Statement statement = connection.createStatement();
            afisare_excursii(statement,"Continut initial");
            afisare_excursii(statement,"Dupa modificare");
            adaugare_excursie(connection,3, 2013,"Romania");
            afisare_excursii(statement,"Dupa adaugare");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

