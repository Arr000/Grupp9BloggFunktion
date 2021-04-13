/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Models.ForskningsInlagg;
import Models.IPostDal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfException;

/**
 *
 * @author nene5
 */
public class PostDB implements IPostDal{

    @Override
    public void saveResearchPost(int id, String rubrik, String inlagg, String username) {
        
        try {
            DatabasAcess.Connect();
            var researchPostQuery = "INSERT INTO FORSKNINGSINLAGG (ID, RUBRIK, INLAGG, USERNAME) VALUES (  " + id + "," + DatabasAcess.MakeDBString(rubrik) + "," + DatabasAcess.MakeDBString(inlagg) + "," + DatabasAcess.MakeDBString(username) + ")";
            DatabasAcess.getidb().insert(researchPostQuery);
            
            
        } catch (InfException ex) {
            Logger.getLogger(PostDB.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

    @Override
    public int getMaxIdResearchPost() {
        try {
            DatabasAcess.Connect();
            var getMaxIdQuery = "SELECT MAX(ID) FROM FORSKNINGSINLAGG ";
            var result = DatabasAcess.getidb().fetchSingle(getMaxIdQuery);
            
            if(result != null)
            {
                return Integer.parseInt(result);
            }
        } catch (InfException ex) {
            Logger.getLogger(PostDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<ForskningsInlagg> getAllResearchPosts() {
        try {
            DatabasAcess.Connect();
            
            var getAllResearchPostsQuery = "SELECT * FROM FORSKNINGSINLAGG";
            var results = DatabasAcess.getidb().fetchRows(getAllResearchPostsQuery);
            ArrayList<ForskningsInlagg> forskningsinlagglist = new ArrayList<>();
            
            if(results!= null)
            {
                for(var result: results)
                {
                    var id = Integer.parseInt(result.get("ID"));
                    var rubrik = result.get("RUBRIK");
                    var inlagg = result.get("INLAGG");
                    var username = result.get("USERNAME");
  
                    var forskningsinlagg = new ForskningsInlagg(id, rubrik, inlagg, username);
                  
                    forskningsinlagglist.add(forskningsinlagg);
                }
                return forskningsinlagglist;
            }
        } catch (InfException ex) {
            Logger.getLogger(PostDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }   
    
    @Override
    public void deleteResearchPost(String rubrik){
        try{
            DatabasAcess.Connect();
            var dbidb = DatabasAcess.getidb();
            dbidb.delete("DELETE FROM FORSKNINGSINLAGG WHERE RUBRIK = '" + rubrik + "'" );
            
        } catch (InfException ex){
        Logger.getLogger(PostDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
