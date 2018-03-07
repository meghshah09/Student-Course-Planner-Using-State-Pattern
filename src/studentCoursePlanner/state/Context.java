/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursePlanner.state;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import studentCoursePlanner.util.FileProcessor;

/**
 *
 * @author Megh Shah
 */
public class Context {
    private FileProcessor fp;
    private CoursePlannerStateI state;
    private int buID;
    private List<String> courses = new ArrayList<>();
    private int count=0;
    private List<String> AllotedCoursesList = new ArrayList<>();
    private List<String> WaitListQueue = new ArrayList<>();
    private String course;

    public String getCourse() {
        return course;
    }

    public void setCourse(String courseIn) {
        this.course = courseIn;
    }
    
    public List<String> getWaitListQueue() {
        return WaitListQueue;
    }

    public List<String> getAllotedCoursesList() {
        return AllotedCoursesList;
    }
    
    public Context(FileProcessor fpIn, CoursePlannerStateI cpIn){
        state=cpIn;
        fp=fpIn;
    }
    public int getBuID() {
        return buID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int countIn) {
        this.count = countIn;
    }

    public void setBuID(int buIDIn) {
        this.buID = buIDIn;
    }

    public List<String> getCourses() {
        return courses;
    }
    public void setState(CoursePlannerStateI sIn){
        state=sIn;
    }
    public CoursePlannerStateI getState(){
        return state;
    }
    public void ProcessingLine(){
        
                String str = fp.readLine();
                if(str != null){
                    splitLine(str);
                
                while(getCount()<courses.size()){
                    setCourse(getCourses().get(getCount()));
                    state = getState();
                    state = state.doAction(this);
                    state = state.doAction(this);
                    setCount(getCount()+1);
                }
                
                }
                else{
                    System.out.println("Input File is Empty.");
                    System.out.println("Please Kindly enter the Data in the input and run it.");
                    System.exit(0);
                }
                fp.close();
        
    }
    
    private void splitLine(String strIn) {
       strIn= strIn.trim(); // precaution if file contains any white spaces.
        String[] output = strIn.split(":");
        
        this.setBuID(Integer.parseInt(output[0]));
        String[] c = output[1].split(" ");
        
        for(int i=0; i<c.length;i++)
            courses.add(c[i]);
    }
    
}
