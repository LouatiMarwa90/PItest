package services;

import util.Datasource;
import entities.Evenement;
import entities.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceEvenement implements IService<Evenement> {
    Connection cnx;

    public ServiceEvenement() {
        cnx = Datasource.getInstance().getCon();
    }

    @Override
    public void ajouter(Evenement eve) throws SQLException {
        String req = "INSERT INTO evenement(DateD, DateF, nbMax, Lieux, Type, image_eve) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setDate(1, new Date(eve.getDateD().getTime())); // Conversion de java.util.Date en java.sql.Date
            ps.setDate(2, new Date(eve.getDateF().getTime()));
            ps.setInt(3, eve.getNbMax());
            ps.setString(4, eve.getLieux());
            ps.setString(5, String.valueOf(eve.getType()));
            ps.setString(6, eve.getImage_eve());
            ps.executeUpdate();
            System.out.println("evenement added !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'événement : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void modifier(Evenement eve) throws SQLException {
        String req = "UPDATE evenement SET Type = ?, DateD = ?, DateF= ?," +
                " nbmax = ?, lieux = ?, image_eve = ? WHERE IdEv = ?";
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
            // Spécification de l'ID de l'événement à modifier
            preparedStatement.setDate(2, new Date(eve.getDateD().getTime()));
            preparedStatement.setDate(3, new Date(eve.getDateF().getTime()));
            preparedStatement.setString(1, String.valueOf(eve.getType()));
            preparedStatement.setInt(4, eve.getNbMax());
            preparedStatement.setString(5, eve.getLieux());
            preparedStatement.setString(6, eve.getImage_eve());
            preparedStatement.setInt(7, eve.getIdEv());
            preparedStatement.executeUpdate();
            System.out.println("Evenement updated !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       // PreparedStatement preparedStatement = cnx.prepareStatement(req);
        //preparedStatement.setString(1, String.valueOf(eve.getType()));
        //preparedStatement.setDate(2, new Date(eve.getDateD().getTime()));
        //preparedStatement.setDate(3, new Date(eve.getDateF().getTime()));
        //preparedStatement.setInt(4, eve.getNbMax());
        //preparedStatement.setString(5, eve.getLieux());
        //preparedStatement.setString(6, eve.getImage_eve());
        //preparedStatement.setInt(7, eve.getIdEv()); // Spécification de l'ID de l'événement à modifier

       // preparedStatement.executeUpdate();
      //  System.out.println("Evenement updated !");
    }

    @Override
    public void supprimer(int idEv) throws SQLException {
        String sql = "delete from evenement where IdEv = ?";

        PreparedStatement preparedStatement = cnx.prepareStatement(sql);
        preparedStatement.setInt(1, idEv);
        preparedStatement.executeUpdate();
    }

    @Override
    public Evenement getOneById(int idEv) {
        String req = "SELECT * FROM evenement WHERE idEv = ?";
        Evenement evenement = null;
        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setInt(1, idEv);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Type t = Type.valueOf(rs.getString("Type"));
                evenement = new Evenement(
                        rs.getInt("IdEV"),
                        rs.getDate("dateD"),

                        rs.getInt("nbMax"),
                        rs.getString("Lieux"),
                        t,

                        rs.getString("image_eve")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return evenement;
    }

    @Override
    public List<Evenement> getAll() throws SQLException {
        List<Evenement> evenements = new ArrayList<>();
        String req = "Select * from evenement";

        Statement st = cnx.createStatement();
        ResultSet res = st.executeQuery(req);
        while (res.next()) {

            int idEV = res.getInt(1);
            Type Type = entities.Type.valueOf(res.getString(2));
            Date DateD = res.getDate(3);
            Date DateF = res.getDate(4);
            int nbMax = res.getInt(5);
            String Lieux = res.getString(6);
            String image_eve = res.getString(7);
            Evenement evenement = new Evenement(idEV, DateD, nbMax, Lieux, Type, image_eve);
            evenements.add(evenement);
        }
        return evenements;
    }


    public Evenement getEvenementParNom(String nomEvenement) throws SQLException {

        String query = "SELECT * FROM evenement WHERE Type = ?";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setString(1, nomEvenement);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int Id = resultSet.getInt("idEv");
                Type Type = entities.Type.valueOf(resultSet.getString("Type"));
                Date DateD = resultSet.getDate("DateD");
                int nbMax = resultSet.getInt("nbMax");
                String lieux = resultSet.getString("Lieux");
                String image_eve = resultSet.getString("image_eve");
                return new Evenement(Id, DateD, nbMax, lieux, Type, image_eve);
            }
        }
        return null; // Si aucun événement trouvé avec le nom donné
    }
}


