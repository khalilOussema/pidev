/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Comment;
import entities.Event;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.DataSource1;

/**
 *
 * @author USER
 */
public class Commentservice implements CommentServiceInterface{
    private static Commentservice instance ;

    private final Connection cnx;
    public Commentservice(){
    cnx=DataSource1.getInstance().getCnx();
    }

    @Override
    public void addComment(Comment c) throws SQLException {
  DataSource1 db = DataSource1.getInstance();
         Connection cn = db.getCnx();
 String query ="INSERT INTO `comment`(`id`,`idu`, `ide`, `commentaire`, `datecommentaire`) VALUES (?,?,?,?,?)";
 
         PreparedStatement st  = cn.prepareStatement(query);
                st.setInt(1, c.getId());
                st.setInt(2, c.getIdu().getId());
                st.setInt(3,c.getIde().getId());
                st.setString(4,c.getCommentaire());
                st.setDate(5,c.getDatecommentaire());
                


                st.execute();

    }
    public void ModifierComment(Comment e) throws SQLException {
     DataSource1 db = DataSource1.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `comment` SET `commentaire`=? WHERE `id` =?";
		PreparedStatement st  = cn.prepareStatement(query);
                
                
                st.setString(1,e.getCommentaire());
                st.setInt(2,e.getId());
        
               st.executeUpdate();
    
    }
public List<Comment> getAllComment() throws SQLException {
        
        List<Comment> list = new ArrayList<Comment>();
        int count =0;
        
        String requete="select * from comment ";
         try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Comment e = new Comment();
                e.setIdu(findUserById(rs.getInt(1)));
                e.setIde(findEventById(rs.getInt(2)));
                e.setCommentaire(rs.getString(3));
                e.setDatecommentaire(rs.getDate(4));
                e.setId(rs.getInt(5));
                
               
                 
                
                list.add(e);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
               return list;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.ALL.SEVERE, null, ex);
            return null;
        }
   
           
}

public User findUserById(int id)
    {
        User u = new User();
        int count = 0;
           
        String requete="select * from user where id="+id;
        try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next())
            {  
                
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
               
                count++;
            }
           if(count == 0){
                return null;
           }else{
               return u;
           }  
        }
        catch (SQLException ex) {
            Logger.getLogger(Commentservice.class.getName()).log(Level.ALL.SEVERE, null, ex);
            return null;
        }
   }
public Event findEventById(int id)
    {
        Event e = new Event();
        int count = 0;
           
        String requete="select * from Event where id="+id;
        try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next())
            {  
                
                e.setId(rs.getInt(1));
                e.setTitre(rs.getString(2));
                e.setLieu(rs.getString(3));
                e.setNbp(rs.getInt(4));
                e.setNbparticipant(rs.getInt(5));
                e.setDatedebut(rs.getDate(6));
                e.setDatefin(rs.getDate(7));
               
               
                count++;
            }
           if(count == 0){
                return null;
           }else{
               return e;
           }  
        }
        catch (SQLException ex) {
            Logger.getLogger(Commentservice.class.getName()).log(Level.ALL.SEVERE, null, ex);
            return null;
        }
   }

    @Override
    public void delete(int id) throws SQLException {
         Statement st=cnx.createStatement();
         String req="DELETE FROM `comment` WHERE `id`="+id;
         st.executeUpdate(req);
        
        
        }


    
}
