package org.example;

import entities.Evenement;
import entities.Type;
import services.ServiceEvenement;

import java.sql.SQLException;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ServiceEvenement se = new ServiceEvenement();
        Date date = new Date();
        Date date2 = new Date();
       Evenement e = new Evenement();
        //Evenement evenement = new Evenement("Concert", java.sql.Date.valueOf("2024-07-01"), java.sql.Date.valueOf("2024-07-02"), 100, "Paris", "concert.jpg");

       /* try {
            se.ajouter(e);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
          e.setIdEv(2);
          e.setDateD(new Date());
          e.setDateF(new Date());
          e.setType(Type.MARATHON);
          e.setNbMax(100);
          e.setLieux("Lieu modifié");
          e.setImage_eve("Image modifiée");

          /*  try {
                se.modifier(e);
               // System.out.println("Evenement modifié !");
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            }*/

          /*  se.supprimer(e.getIdEv());
            System.out.println("Événement supprimé !");

            /*List<Evenement> evenements = se.getAll();
            for (Evenement ev : evenements) {
                System.out.println(ev);
            }


            ServiceParticipation sp = new ServiceParticipation();

            // Ajout d'une participation
            Evenement evenement = new Evenement(new Date(), new Date(), 3, "lieux", Type.TENNIS, "image");
            Utilisateur user = new Utilisateur();
            user.setIdU(1);
            Participation p =
                   new Participation("Nom", "Prenom", 20, "email@example.com", evenement, user);
            Participation p2 =
                    new Participation(2,"Nom", "Prenom", 20, "email@example.com", user, evenement);
          //  sp.ajouter(p);
            System.out.println("Participation ajoutée !");

            //Récupération de la participation par ID
            Participation participation = sp.getOneById(p2.getId_p());
            System.out.println("Participation récupérée : " + participation.getNom_p());

            // Modification de la participation
            participation.setNom_p("Nom modifié");
           //// sp.modifier(participation);
            System.out.println("Participation modifiée !");

            // Suppression de la participation
            sp.supprimer(p.getId_p());
            System.out.println("Participation supprimée !");

            // Récupération de toutes les participations
           // List<Participation> participations = sp.getAll();
           // for (Participation ppp : participations)
                System.out.println(p2);*/
          }
        }













