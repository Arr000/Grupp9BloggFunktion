/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Models.Employee;
import Models.IMeetingDal;
import Models.Meeting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfException;


/**
 *
 * @author nene5
 */
public class MeetingDB implements IMeetingDal{

    @Override
    public void saveMeeting(int id, String plats, String tid, String datum, int receiverID, int senderID, String approvedMeeting) {

        try {
            DatabasAcess.Connect();
            var saveMeetingQuery = "INSERT INTO MEETING (ID,PLATS,TID,DATUM,RECEIVERID,SENDERID, APPROVED) VALUES (" +id+ "," +  DatabasAcess.MakeDBString(plats) +
                    "," + DatabasAcess.MakeDBString(tid) + "," + DatabasAcess.MakeDBString(datum) + "," + receiverID + "," + senderID + "," + DatabasAcess.MakeDBString(approvedMeeting) + ")";
            DatabasAcess.getidb().insert(saveMeetingQuery);
            
        } catch (InfException ex) {
            Logger.getLogger(MeetingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public int getMaxIDMeeting() {
        try {
            DatabasAcess.Connect();
            var getMaxIdQuery = "SELECT MAX(ID) FROM MEETING";
            var result = DatabasAcess.getidb().fetchSingle(getMaxIdQuery);
            
            return Integer.parseInt(result);
          
        } catch (InfException ex) {
            Logger.getLogger(MeetingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Meeting> getMyMeetings(int id) {
        
        try {
            DatabasAcess.Connect();
            var getMyMeetingsQuery = "SELECT * FROM MEETING WHERE RECEIVERID = " + id + " AND APPROVED = " + DatabasAcess.MakeDBString("U");
            var results = DatabasAcess.getidb().fetchRows(getMyMeetingsQuery);
            ArrayList<Meeting> Meetings = new ArrayList<>();
            
            if(results != null)
            {
                for(var result: results)
                {
                    var meetingid = Integer.parseInt(result.get("ID"));
                    var meetingsplats = result.get("PLATS");
                    var meetingtid = result.get("TID");
                    var meetingReceiverId = Integer.parseInt(result.get("RECEIVERID"));
                    var meetingSenderId = Integer.parseInt(result.get("SENDERID"));
                    var meetingApproved = result.get("APPROVED");
                    var meetingDatum = result.get("DATUM");
                    
                    var meeting = new Meeting(meetingid, meetingsplats, meetingtid, meetingDatum, meetingReceiverId,meetingSenderId, meetingApproved);
                    Meetings.add(meeting);
                    
                }
                return Meetings;
            }
            
        } catch (InfException ex) {
            Logger.getLogger(MeetingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      return null;  
    }

    @Override
    public void UpdateMeeting(int id, String approved) {
        
        try {
            DatabasAcess.Connect();
            var updateMeetingQuery = "UPDATE MEETING SET APPROVED = " + DatabasAcess.MakeDBString(approved) + " WHERE ID = " + id;
            DatabasAcess.getidb().update(updateMeetingQuery);
        } catch (InfException ex) {
            Logger.getLogger(MeetingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public ArrayList<Meeting> getMeetingByDate(String date) {
       
        try {
            DatabasAcess.Connect();
            ArrayList<Meeting> meetings = new ArrayList<>();
            
            var selectQuery = "SELECT * FROM MEETING WHERE DATUM = " + DatabasAcess.MakeDBString(date) + " AND APPROVED = " + DatabasAcess.MakeDBString("J");
            var results =DatabasAcess.getidb().fetchRows(selectQuery);
            
            if(results != null)
            {
                for(var result: results)
                {
                    var id = Integer.parseInt(result.get("ID"));
                    var plats = result.get("PLATS");
                    var tid = result.get("TID");
                    var datum = result.get("DATUM");
                    var receiverID = Integer.parseInt(result.get("RECEIVERID"));
                    var senderID = Integer.parseInt(result.get("SENDERID"));
                    
                    var meeting = new Meeting(id, plats, tid, datum, receiverID,senderID);
                    
                    meetings.add(meeting);
                    
                }
                return meetings;
            }
        
        } catch (InfException ex) {
            Logger.getLogger(MeetingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
  

