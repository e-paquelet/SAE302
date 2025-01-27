/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serveurudp;

import java.util.ArrayList;


/**
 *
 * @author xknoepf //dans ce fichier classe, on est en train de vraiment vérifier tout les différentes donner sur un utilisateur.
 */

public class Utilisateur {
    private String user,mdp; //le surnom est le moyen d'identifier un utilisateur
    boolean connected=false;
    private ArrayList<Utilisateur> ListeAmis;
    private ArrayList<Message> ListeMessage;
    private ArrayList <Utilisateur> ListeAttente;
    
    public Utilisateur(String mail, String password){ //Dans celui ci, on est en train de vérifier toutes les donners basic sur un utilisateur:
        user=mail;                                  //on montre alors l'utilisateur, écrit email, le mot de passe mdp et les différentes listes de cette utilisateur
        mdp=password;                               //décrit par les ArrayList, on à une Liste Amis, une liste de Message et la liste d'attente.
        ListeAmis=new ArrayList();
        ListeMessage=new ArrayList();
        ListeAttente=new ArrayList();
    }
    
    public String getEmail(){ //retourner nom user
        return user;
    }
    
    public String getPassword(){ //retourner mdp
        return mdp;
    }
    
    public ArrayList<Utilisateur> getAmis(){//obtenir liste
        return ListeAmis;
    }
    
public void setAmis(Utilisateur u, boolean statut) {
    if (ListeAttente.contains(u) && ListeAmis.size() < 100) { //Ici, on verfie plusieurs choses:
        if (statut) {                                   //Si l'utilisateur u est dans la liste d'attente, et si la liste d'amis est inférieur à 10 valeurs
            ListeAttente.remove(u);
            ListeAmis.add(u);
            u.ListeAmis.add(this); //On ajoute l'utilisateur à la liste d'amis
        } else {
            ListeAttente.remove(u); //et on enleve l'utilisateur de la liste d'attente
        }
    }
}

    public ArrayList <Utilisateur> getAttente(){ //liste d'attente des amis
        return ListeAttente;
    }
    
    public void setAttente(Utilisateur u){//ajt en attente
        if(!ListeAttente.contains(u) && !ListeAmis.contains(u) && ListeAmis.size()<10 && ListeAttente.size()<10){
            ListeAttente.add(u);
        }
    }
    
    public void setConnexion(boolean state){//savoir si user en ligne ou non
        connected=state;
    }
    
    public boolean getConnexion(){//retourne état de connexion
        return connected;
    }
    
    public ArrayList<Message> getMessageList(){//retourne liste message
        return ListeMessage;
    }

    public void setMessage(Message message){ //ajoute message à la liste
        ListeMessage.add(message);
    }   

    public boolean isFriendWith(Utilisateur other){//vérif si l'user est ami avec verif dans la liste, retourn booleen pour savoir oui ou non
        if(ListeAmis.contains(other)){
            return true;
        }
        return false;
    }    
}