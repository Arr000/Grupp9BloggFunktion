/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import org.firebirdsql.jdbc.FBEscapedFunctionHelper;

/**
 *
 * @author nene5
 */
public class Meeting {
    
    private int id;
    private String plats;
    private String tid;
    private String datum;
    private int receiverID;
    private int senderID;
    private String approved;

    
    
    

    
    public Meeting(int id, String plats, String tid, String datum, int receiverID, int senderID, String approved )
    {
        this.id = id;
        this.plats = plats;
        this.tid = tid;
        this.datum = datum;
        this.receiverID = receiverID;
        this.senderID = senderID;
        this.approved = approved;
    }
    
      public Meeting(int id, String plats, String tid, String datum, int receiverID, int senderID )
    {
        this.id = id;
        this.plats = plats;
        this.tid = tid;
        this.datum = datum;
        this.receiverID = receiverID;
        this.senderID = senderID;
   
    }
      
      public int getID()
      {
          return this.id;
      }
      
      
      public String getPlats()
      {
          return this.plats;
      }
      
      
      public String getTid()
      {
          return this.tid;
      }
      
      
      public String getDatum()
      {
          return this.datum;
      }
      
      
      public int getSenderID()
      {
          return this.senderID;
      }
      
      
      public int getReceiverID()
      {
          return this.receiverID;
      }
      
      public String getAllInfo()
      {
        
          return "MötesID : " +id + " är bokat på plats : " + plats + " Tid: " + tid + " med Anställd:  " + receiverID;
      }
}

