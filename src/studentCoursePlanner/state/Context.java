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
import studentCoursePlanner.util.Results;

/**
 *
 * @author Megh Shah
 */
public class Context {
    private FileProcessor fp;
    private CoursePlannerStateI state;
    private Results result;
    private int buID;
    private List<String> courses = new ArrayList<>();
    private int count=0;
    private List<String> AllotedCoursesList = new ArrayList<>();
    private List<String> WaitListQueue = new ArrayList<>();
    private String course;
    private boolean CategoryOneSatisfied;
    private boolean CategoryTwoSatisfied;
    private boolean CategoryThreeSatisfied;
    private boolean CategoryFourSatisfied;
    private boolean CategoryFiveSatisfied;
    private boolean Graduated;
    private int longCount=0;
    private int DSACount=0;
    private int hardCount=0;
    private int dataCount=0;
    private int electiveCount;
    private int NoOfSemester;

    public int getNoOfSemester() {
        return NoOfSemester;
    }

    public void setNoOfSemester(int NoOfSemester) {
        this.NoOfSemester = NoOfSemester;
    }

    public int getElectiveCount() {
        return electiveCount;
    }

    public void setElectiveCount(int electiveCountIn) {
        this.electiveCount = electiveCountIn;
    }
    
    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCountIn) {
        this.dataCount = dataCountIn;
    }
    
    public int getHardCount() {
        return hardCount;
    }

    public void setHardCount(int hardCountIn) {
        this.hardCount = hardCountIn;
    }
    
    public int getDSACount() {
        return DSACount;
    }

    public void setDSACount(int DSACountIn) {
        this.DSACount = DSACountIn;
    }

    public int getLongCount() {
        return longCount;
    }

    public void setLongCount(int longCountIn) {
        this.longCount = longCountIn;
    }
    
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
    
    public Context(FileProcessor fpIn, CoursePlannerStateI cpIn,Results rIn){
        state=cpIn;
        fp=fpIn;
        result = rIn;
        CategoryOneSatisfied=false;
        CategoryTwoSatisfied=false;
        CategoryThreeSatisfied=false;
        CategoryFourSatisfied=false;
        CategoryFiveSatisfied=false;
        Graduated = false;
    }
    
    public int getBuID() {
        return buID;
    }

    public boolean isCategoryOneSatisfied() {
        return CategoryOneSatisfied;
    }

    public void setCategoryOneSatisfied(boolean CategoryOneSatisfiedIn) {
        this.CategoryOneSatisfied = CategoryOneSatisfiedIn;
    }

    public boolean isCategoryTwoSatisfied() {
        return CategoryTwoSatisfied;
    }

    public void setCategoryTwoSatisfied(boolean CategoryTwoSatisfiedIn) {
        this.CategoryTwoSatisfied = CategoryTwoSatisfiedIn;
    }

    public boolean isCategoryThreeSatisfied() {
        return CategoryThreeSatisfied;
    }

    public void setCategoryThreeSatisfied(boolean CategoryThreeSatisfiedIn) {
        this.CategoryThreeSatisfied = CategoryThreeSatisfiedIn;
    }

    public boolean isCategoryFourSatisfied() {
        return CategoryFourSatisfied;
    }

    public void setCategoryFourSatisfied(boolean CategoryFourSatisfiedIn) {
        this.CategoryFourSatisfied = CategoryFourSatisfiedIn;
    }

    public boolean isCategoryFiveSatisfied() {
        return CategoryFiveSatisfied;
    }

    public void setCategoryFiveSatisfied(boolean CategoryFiveSatisfiedIn) {
        this.CategoryFiveSatisfied = CategoryFiveSatisfiedIn;
    }

    public boolean isGraduated() {
        return Graduated;
    }

    public void setGraduated(boolean Graduated) {
        this.Graduated = Graduated;
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
                try{
                    splitLine(str);
                }catch(NumberFormatException e){
                    System.err.println("Input File is not well Formated. Please re-run the program with proper Format.");
                    fp.close();
                    System.exit(0);
                }
                while(getCount()<courses.size()&& (!isGraduated())){
                    setCourse(getCourses().get(getCount()));
                    state = getState();
                    state = state.doAction(this);
                    if(!isGraduated()){
                        state = state.doAction(this);
                        setCount(getCount()+1);
                    }
                }
                
                if(isGraduated()){
                    String resultString = "BU ID "+this.getBuID()+" is Graduated And No. of Semester Taken is "+this.getNoOfSemester();
                    result.fileDisplay(resultString);
                    result.stdoutDisplay(resultString);
                }
                else{
                    String resultString = "BU ID "+this.getBuID()+" is Not Graduated";
                    result.fileDisplay(resultString);
                    result.stdoutDisplay(resultString);
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
