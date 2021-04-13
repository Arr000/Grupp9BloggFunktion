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
public interface IEmployee {
    
    public ArrayList<Employee> getAllEmployees();
    
    public Employee getEmployeebyUsername(String username);
    
    public Employee getEmployeeByID(int id);
    
    public ArrayList<Employee> getAllEmployeesExceptOne(String username);
    
    public Employee loginPage(String userName, String password);
    
    
    


}
