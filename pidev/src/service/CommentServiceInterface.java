/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Comment;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface CommentServiceInterface {
    public void addComment(Comment c)throws SQLException;
    public void ModifierComment(Comment e) throws SQLException;
        public List<Comment> getAllComment()throws SQLException;
    public void delete(int id) throws SQLException;    

}
