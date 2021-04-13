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
public interface IMeetingDal {
    
    public void saveMeeting(int id, String plats, String tid, String datum, int receiverID, int senderID, String approvedMeeting);
    
    public int getMaxIDMeeting();
    
    public ArrayList<Meeting> getMyMeetings(int id);
    
    public void UpdateMeeting(int id, String approved);
    
    public ArrayList<Meeting> getMeetingByDate(String date);

    
}
