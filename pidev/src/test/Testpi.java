/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Comment;
import entities.Event;
import entities.User;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.Commentservice;
import service.EventService;

/**
 *
 * @author USER
 */
public class Testpi {
   public static void main(String[] args) throws SQLException{
   
        DataSource1 db = DataSource1.getInstance();
        Date d1=new Date(5, 9, 2020);
        Date d2=new Date(6, 8, 2020);

        Event e=new Event(11,3, 2,"ariana", "tunis", d1, d2);
        Event e1=new Event(14,6, 2,"tunis", "tunis", d1, d2);
        Event e2=new Event(15,6, 2,"beja", "tunis", d1, d2);
        Event e3=new Event(22,6, 2,"beja", "kef", d1, d2);

        User u = new User (2,"heloà");

       EventService es= new EventService();
       Commentservice cs= new Commentservice();
       Comment c = new Comment(u, e1, "cvcvcv", d1,3);
       //cs.addComment(c);
      //cs.ModifierComment(c);
       
 //  es.addEvent(e);
   // es.addEvent(e1);
    //es.addEvent(e2);
    //es.addEvent(e3);
 //   es.ModifierEvent(e);
 
   //    List<Event> L=new ArrayList<Event>();
//L=es.getAllEvent();
//for (Event event : L)
//{System.out.println(e);}
 //List<Comment> L1=new ArrayList<Comment>();
//L1=cs.getAllComment();
//for (Comment comment : L1)
//{System.out.println(c);}

User U = cs.findUserById(1);
       System.out.println(U);
//Event event = es.findEventByTitre("kef");
  //     System.out.println(event);
  //es.deleteEvent(3);
  //cs.delete(3);
  
   }  
   
   
}
