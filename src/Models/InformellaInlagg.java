/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author gabri
 */
public class InformellaInlagg {
    public int Id;
    public String rubrik;
    public String inlagg;
    public String username;
    
    public InformellaInlagg(int id, String rubrik, String inlagg, String username)
    {
        this.Id = id;
        this.rubrik = rubrik;
        this.inlagg = inlagg;
        this.username = username;
    }
    
    public int getID()
    {
        return Id;
    }
    
    public String getRubrik()
    {
        return rubrik;
    }
    
    public String getInlagg()
    {
        return inlagg;
    }
    
    public String getUsername()
    {
        return username;
    }
    
}


