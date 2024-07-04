package services;

import util.Datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurService {
    Connection connection;

    public UtilisateurService() {
        connection = Datasource.getInstance().getCon();
    }

  /*  public static Utilisateur getOneById(int idU) {
        return null;
    }*/

    // Ajouter un utilisateur
   /* public void ajouter(Connection connection, Utilisateur utilisateur) throws SQLException {
        String query = "INSERT INTO utilisateur (nomU, prenomU, mdp, mailU, tel, statut, Date_naissance) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, utilisateur.getNomU());
            preparedStatement.setString(2, utilisateur.getPrenomU());
            preparedStatement.setString(3, utilisateur.getMdp());
            preparedStatement.setString(4, utilisateur.getMailU());
            preparedStatement.setLong(5, utilisateur.getTel());
            preparedStatement.setBoolean(6, utilisateur.isStatut());
            preparedStatement.setDate(7, new java.sql.Date(utilisateur.getDateNaissance().getTime()));
            preparedStatement.executeUpdate();
            System.out.println("Utilisateur ajouté : " + utilisateur.getNomU());
        }
    }

    // Supprimer un utilisateur
    public void supprimer(int id) {
        String query = "DELETE FROM utilisateur WHERE idU = ?";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur supprimé avec succès, ID : " + id);
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulter un utilisateur
    public Utilisateur consulter(int id) {
        String query = "SELECT * FROM utilisateur WHERE idU = ?";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setIdU(resultSet.getInt("idU"));
                utilisateur.setNomU(resultSet.getString("nomU"));
                utilisateur.setPrenomU(resultSet.getString("prenomU"));
                utilisateur.setMdp(resultSet.getString("mdp"));
                utilisateur.setMailU(resultSet.getString("mailU"));
                utilisateur.setTel(resultSet.getLong("tel"));
                utilisateur.setStatut(resultSet.getBoolean("statut"));
                utilisateur.setDateNaissance(resultSet.getDate("Date_naissance"));
                return utilisateur;
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Rechercher des utilisateurs par nom
    public List<Utilisateur> rechercher(String nom) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String query = "SELECT * FROM utilisateur WHERE nomU LIKE ?";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + nom + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setIdU(resultSet.getInt("idU"));
                utilisateur.setNomU(resultSet.getString("nomU"));
                utilisateur.setPrenomU(resultSet.getString("prenomU"));
                utilisateur.setMdp(resultSet.getString("mdp"));
                utilisateur.setMailU(resultSet.getString("mailU"));
                utilisateur.setTel(resultSet.getLong("tel"));
                utilisateur.setStatut(resultSet.getBoolean("statut"));
                utilisateur.setDateNaissance(resultSet.getDate("Date_naissance"));
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }


    // Trier les utilisateurs par nom
    public List<Utilisateur> trierParNom() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String query = "SELECT * FROM utilisateur ORDER BY nomU";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setIdU(resultSet.getInt("idU"));
                utilisateur.setNomU(resultSet.getString("nomU"));
                utilisateur.setPrenomU(resultSet.getString("prenomU"));
                utilisateur.setMdp(resultSet.getString("mdp"));
                utilisateur.setMailU(resultSet.getString("mailU"));
                utilisateur.setTel(resultSet.getLong("tel"));
                utilisateur.setStatut(resultSet.getBoolean("statut"));
                utilisateur.setDateNaissance(resultSet.getDate("Date_naissance"));
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

    // Vérifier si l'ID existe
    public boolean verifId(int id) {
        String query = "SELECT 1 FROM utilisateur WHERE idU = ?";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Oublier mot de passe (mise à jour du mot de passe)
    public void oublierMdp(int id, String nouveauMdp) {
        String query = "UPDATE utilisateur SET mdp = ? WHERE idU = ?";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nouveauMdp);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mot de passe mis à jour avec succès pour l'utilisateur ID : " + id);
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Modifier un utilisateur
    public void modifier(Connection connection, int id, Utilisateur utilisateurModifie) throws SQLException {
        String query = "UPDATE utilisateur SET nomU = ?, prenomU = ?, mdp = ?, mailU = ?, tel = ?, statut = ?, Date_naissance = ? WHERE idU = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, utilisateurModifie.getNomU());
            preparedStatement.setString(2, utilisateurModifie.getPrenomU());
            preparedStatement.setString(3, utilisateurModifie.getMdp());
            preparedStatement.setString(4, utilisateurModifie.getMailU());
            preparedStatement.setLong(5, utilisateurModifie.getTel());
            preparedStatement.setBoolean(6, utilisateurModifie.isStatut());
            preparedStatement.setDate(7, new java.sql.Date(utilisateurModifie.getDateNaissance().getTime()));
            preparedStatement.setInt(8, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur modifié avec succès : " + utilisateurModifie.getNomU());
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID : " + id);
            }
        }
    }

    public Utilisateur getOneByEmail() {
        return null;
    }*/
}