/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Event;
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
public class EventService implements EventServiceInterface {
private static EventService instance ;
private final Connection cnx;
public EventService(){
cnx=DataSource1.getInstance().getCnx();
}
    @Override
    public void addEvent(Event q)throws SQLException{
        DataSource1 db = DataSource1.getInstance();
         Connection cn = db.getCnx();
 String query ="INSERT INTO `event`(`id`, `titre`, `lieu`, `nbp`, `nbparticipant`,`datedebut`,`datefin`) VALUES (?,?,?,?,?,?,?)";
 
         PreparedStatement st  = cn.prepareStatement(query);
                st.setInt(1, q.getId());
                st.setString(2,q.getTitre());
                st.setString(3,q.getLieu());
                st.setInt(4,q.getNbp());
                st.setInt(5,q.getNbparticipant());
                st.setDate(6,q.getDatedebut());
                st.setDate(7,q.getDatefin());


                st.execute();
    }

    @Override
    public void ModifierEvent(Event e) throws SQLException {
     DataSource1 db = DataSource1.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `event` SET `titre`=?,`lieu`=?,`nbp`=?,`nbparticipant`=?,`datedebut`=?,`datefin`=? WHERE `id` =?";
		PreparedStatement st  = cn.prepareStatement(query);
                
                
                st.setString(1,e.getTitre());
                st.setString(2,e.getLieu());
                st.setInt(3,e.getNbp());
                st.setInt(4,e.getNbparticipant());
                st.setDate(5,e.getDatedebut());
                st.setDate(6,e.getDatefin());
                st.setInt(7,e.getId());
               st.executeUpdate();
    
    }

    @Override
    public List<Event> getAllEvent() throws SQLException {
        
        List<Event> list = new ArrayList<Event>();
        int count =0;
        
        String requete="select * from event ";
         try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Event e = new Event();
                e.setId(rs.getInt(1));
                e.setTitre(rs.getString(2));
                e.setLieu(rs.getString(3));
                e.setNbp(rs.getInt(4));
                e.setNbparticipant(rs.getInt(5));
                e.setDatedebut(rs.getDate(6));
                e.setDatefin(rs.getDate(7));
               
                   
                
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

    @Override
    public void deleteEvent(int id) throws SQLException {

        Statement st=cnx.createStatement();
         String req="DELETE FROM `event` WHERE `id`="+id;
         st.executeUpdate(req);
        
    }
    public Event findEventByTitre(String nom)
    {
        Event e = new Event();
        int count = 0;
           
        String requete="select * from Event where titre='"+nom+"'";
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
    


    
    
}
