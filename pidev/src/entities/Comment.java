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
public class Comment {
    private User idu;
    private Event ide;
    private String commentaire;
    private Date datecommentaire;
    private int Id ;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    

    public Comment(User idu, Event ide, String commentaire, Date datecommentaire, int Id) {
        this.idu = idu;
        this.ide = ide;
        this.commentaire = commentaire;
        this.datecommentaire = datecommentaire;
        this.Id = Id;
    }
    
 
    public Comment(User idu, Event ide, String commentaire, Date datecommentaire) {
        this.idu = idu;
        this.ide = ide;
        this.commentaire = commentaire;
        this.datecommentaire = datecommentaire;
    }

    public Comment() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idu);
        hash = 97 * hash + Objects.hashCode(this.ide);
        hash = 97 * hash + Objects.hashCode(this.commentaire);
        hash = 97 * hash + Objects.hashCode(this.datecommentaire);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.commentaire, other.commentaire)) {
            return false;
        }
        if (!Objects.equals(this.idu, other.idu)) {
            return false;
        }
        if (!Objects.equals(this.ide, other.ide)) {
            return false;
        }
        if (!Objects.equals(this.datecommentaire, other.datecommentaire)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "idu=" + idu + ", ide=" + ide + ", commentaire=" + commentaire + ", datecommentaire=" + datecommentaire + '}';
    }

    public User getIdu() {
        return idu;
    }

    public void setIdu(User idu) {
        this.idu = idu;
    }

    public Event getIde() {
        return ide;
    }

    public void setIde(Event ide) {
        this.ide = ide;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDatecommentaire() {
        return datecommentaire;
    }

    public void setDatecommentaire(Date datecommentaire) {
        this.datecommentaire = datecommentaire;
    }

    
    
    
}
