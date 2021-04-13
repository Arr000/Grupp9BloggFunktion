package DB;


import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabasAcess{
     
    private static InfDB idb;
    //Denna metod kopplar upp sig emot databasen.
    public static void Connect()
    {
        try
        {
            if(idb == null)
            {
                idb = new InfDB("C:\\db\\BloggApplication\\drivrutin\\BLOGGDB.FDB");  
            }
        }
        catch(InfException ex)
        {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }
    //Denna metod returnerar databasen.
    public static InfDB getidb()
    {
        return idb;
    }
    
     public static String MakeDBString(String s)
    {
        return "'" + s + "'";
    }
}
            
            
    

