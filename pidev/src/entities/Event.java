/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class Event {
    private int id,nbp,nbparticipant;
    private String lieu,titre;
    private Date datedebut,datefin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbp() {
        return nbp;
    }

    public void setNbp(int nbp) {
        this.nbp = nbp;
    }

    public int getNbparticipant() {
        return nbparticipant;
    }

    public void setNbparticipant(int nbparticipant) {
        this.nbparticipant = nbparticipant;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nbp=" + nbp + ", nbparticipant=" + nbparticipant + ", lieu=" + lieu + ", titre=" + titre + ", datedebut=" + datedebut + ", datefin=" + datefin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.id;
        hash = 73 * hash + this.nbp;
        hash = 73 * hash + this.nbparticipant;
        hash = 73 * hash + Objects.hashCode(this.lieu);
        hash = 73 * hash + Objects.hashCode(this.titre);
        hash = 73 * hash + Objects.hashCode(this.datedebut);
        hash = 73 * hash + Objects.hashCode(this.datefin);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nbp != other.nbp) {
            return false;
        }
        if (this.nbparticipant != other.nbparticipant) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.datedebut, other.datedebut)) {
            return false;
        }
        if (!Objects.equals(this.datefin, other.datefin)) {
            return false;
        }
        return true;
    }

    public Event() {
    }

    public Event(int id, int nbp, int nbparticipant, String lieu, String titre, Date datedebut, Date datefin) {
        this.id = id;
        this.nbp = nbp;
        this.nbparticipant = nbparticipant;
        this.lieu = lieu;
        this.titre = titre;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }
    
    
   

    
}
