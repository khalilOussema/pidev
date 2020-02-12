/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Event;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface EventServiceInterface {
    public void addEvent(Event q)throws SQLException;
    public void ModifierEvent(Event e)throws SQLException;
    public List<Event> getAllEvent()throws SQLException;
    public void deleteEvent(int id) throws SQLException;        
    
    
    
}
