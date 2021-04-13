
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author nene5
 */
public interface IPost {
    
    public void addResearchPost(int id, String rubrik, String inlagg, String username);
    
    public int getMaxIdResearchPost();
    
    public ArrayList<ForskningsInlagg> getAllResearchPosts();
    
    public void deleteResearchPost(String rubrik);
    
}