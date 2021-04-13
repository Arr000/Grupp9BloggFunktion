/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static meetingmanagergui.CalenderMeeting.datumMote;

/**
 *
 * @author nene5
 */
public interface IPostDal {
    
    public void saveResearchPost(int id, String rubrik, String inlagg, String username);
    
    public int getMaxIdResearchPost();
    
    public ArrayList<ForskningsInlagg> getAllResearchPosts();
    
    public void deleteResearchPost(String rubrik);
    
}
