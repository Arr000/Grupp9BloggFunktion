/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BloggManager;

import Models.Employee;
import Models.ForskningsInlagg;
import Models.IEmployee;
import Models.IEmployeeDAL;
import Models.IMeeting;
import Models.IMeetingDal;
import Models.IPost;
import Models.IPostDal;
import Models.Meeting;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nene5
 */
public class BloggService implements IMeeting, IEmployee, IPost{
 
    private IMeetingDal _meetingdb;
    private IEmployeeDAL _employeedb;
    private IPostDal _postdb;
    
    public BloggService(IMeetingDal meetingdb)
    {
        this._meetingdb = meetingdb;
    }
     public BloggService(IEmployeeDAL employedb)
    {
        this._employeedb = employedb;
    }
    
     public BloggService(IPostDal postdb)
     {
         this._postdb = postdb;
     }
     

    @Override
    public ArrayList<Meeting> getMyMeetings(int id) {
        var meetings = _meetingdb.getMyMeetings(id);
        return meetings;
    }

    @Override
    public ArrayList<Employee> getAllEmployees()
    {
       var allEmployees = _employeedb.getAllEmployees();
       
       return allEmployees;
    }   

    @Override
    public Employee getEmployeebyUsername(String username) {
       
       var employee = _employeedb.getEmployeeByUserName(username);
       return employee;
    }

    @Override
    public ArrayList<Employee> getAllEmployeesExceptOne(String username) {
        
        var EmployeeList = _employeedb.getAllEmployeesExceptOne(username);
        return EmployeeList;
    }

    @Override
    public void addMeeting(int id, String plats, String tid, String datum, int receiverID, int senderID, String approvedMeeting) {
        _meetingdb.saveMeeting(id, plats, tid, datum, receiverID, senderID, approvedMeeting);
    }

    @Override
    public int getMaxIdMeeting() {
        var maxId =  _meetingdb.getMaxIDMeeting();
        return maxId+1;
    }

    @Override
    public Employee getEmployeeByID(int id) {
        var employee = _employeedb.getEmployeeByID(id);
        return employee;
    }

    @Override
    public void UpdateMeeting(int id, String approved) {
        _meetingdb.UpdateMeeting(id, approved);
    }

    @Override
    public Employee loginPage(String userName, String password) {
        var employee = _employeedb.checkLogin(userName, password);
        if(employee != null)
        {
            return employee;
        }
        else
        {
             return null;
        }
    
    }
    
    @Override
    public void addResearchPost(int id, String rubrik, String inlagg, String username) {
        
        _postdb.saveResearchPost(id, rubrik, inlagg, username);
        
    }

    @Override
    public int getMaxIdResearchPost() {
      var maxId = _postdb.getMaxIdResearchPost();
      return maxId+1;
      
    }

    @Override
    public ArrayList<ForskningsInlagg> getAllResearchPosts() {
        var allResearchPosts = _postdb.getAllResearchPosts();
        return allResearchPosts;
    }

    @Override
    public ArrayList<Meeting> getMeetingbyDate(String date) {
      var meetings = _meetingdb.getMeetingByDate(date);
      return meetings;
    }

    @Override
    public void deleteResearchPost(String rubrik){
        _postdb.deleteResearchPost(rubrik);
    }

}
