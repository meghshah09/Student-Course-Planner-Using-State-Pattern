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

    /**
     * 
     * @return No of Semester taken 
     */
    public int getNoOfSemester() {
        return NoOfSemester;
    }

    /**
     * 
     * @param NoOfSemester sets the count of no of semester 
     */
    public void setNoOfSemester(int NoOfSemester) {
        this.NoOfSemester = NoOfSemester;
    }

    /**
     * 
     * @return gives the count of Courses taken in Electives Category.
     */
    public int getElectiveCount() {
        return electiveCount;
    }

    /**
     * 
     * @param electiveCountIn sets the count of Courses taken in Electives Category.
     */
    public void setElectiveCount(int electiveCountIn) {
        this.electiveCount = electiveCountIn;
    }
    /**
     * 
     * @return gets the count of Courses taken in Data Analytics Category. 
     */
    public int getDataCount() {
        return dataCount;
    }

    /**
     * 
     * @param dataCountIn  sets the count of Courses taken in Data Analytics Category.
     */
    public void setDataCount(int dataCountIn) {
        this.dataCount = dataCountIn;
    }
    
    /**
     * 
     * @return gets the count of Courses taken in Hardware Sequence Category.
     */
    public int getHardCount() {
        return hardCount;
    }

    /**
     * 
     * @param hardCountIn sets the count of Courses taken in Hardware Sequence Category. 
     */
    public void setHardCount(int hardCountIn) {
        this.hardCount = hardCountIn;
    }
    
    /**
     * 
     * @return gets the count of Courses taken in Data Structures and Algorithms Category. 
     */
    public int getDSACount() {
        return DSACount;
    }

    /**
     * 
     * @param DSACountIn sets the count of Courses taken in Data Structures and Algorithms Category.
     */
    public void setDSACount(int DSACountIn) {
        this.DSACount = DSACountIn;
    }

    /**
     * 
     * @return gets the count of Courses taken in Long Programming Category.
     */
    public int getLongCount() {
        return longCount;
    }

    
    /**
     * 
     * @param longCountIn sets the count of Courses taken in Long Programming Category. 
     */
    
    public void setLongCount(int longCountIn) {
        this.longCount = longCountIn;
    }
    
    /**
     * 
     * @return gives the course which is currently in process. 
     */
    
    public String getCourse() {
        return course;
    }

    /**
     * 
     * @param courseIn sets the course to be process currently.
     */
    public void setCourse(String courseIn) {
        this.course = courseIn;
    }
    
    /**
     * 
     * @return the list of wait list Courses
     */
    public List<String> getWaitListQueue() {
        return WaitListQueue;
    }

    /**
     * 
     * @return the list of Allocated Courses
     */
    public List<String> getAllotedCoursesList() {
        return AllotedCoursesList;
    }
    
    /**
     * Parameterized Constructor
     * @param fpIn FileProcessor class reference
     * @param cpIn Interface reference
     * @param rIn Results Class reference
     */
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

    /**
     * 
     * @return the Results class reference
     */
    public Results getResult() {
        return result;
    }
    
    /**
     * 
     * @return the BU ID of the student
     */
    public int getBuID() {
        return buID;
    }

    /**
     * 
     * @return boolean value stating whether the condition for Category one is Satisfied.
     */
    public boolean isCategoryOneSatisfied() {
        return CategoryOneSatisfied;
    }
    /**
     * 
     * @param CategoryOneSatisfiedIn sets the boolean value for category one check.
     */
    public void setCategoryOneSatisfied(boolean CategoryOneSatisfiedIn) {
        this.CategoryOneSatisfied = CategoryOneSatisfiedIn;
    }

    /**
     * 
     * @return boolean value stating whether the condition for Category two is Satisfied. 
     */
    public boolean isCategoryTwoSatisfied() {
        return CategoryTwoSatisfied;
    }

    /**
     * 
     * @param CategoryTwoSatisfiedIn sets the boolean value for category two check.
     */
    public void setCategoryTwoSatisfied(boolean CategoryTwoSatisfiedIn) {
        this.CategoryTwoSatisfied = CategoryTwoSatisfiedIn;
    }

    /**
     * 
     * @return boolean value stating whether the condition for Category Three is Satisfied.
     */
    public boolean isCategoryThreeSatisfied() {
        return CategoryThreeSatisfied;
    }

    /**
     * 
     * @param CategoryThreeSatisfiedIn sets the boolean value for category three check.
     */
    public void setCategoryThreeSatisfied(boolean CategoryThreeSatisfiedIn) {
        this.CategoryThreeSatisfied = CategoryThreeSatisfiedIn;
    }

    /**
     * 
     * @return boolean value stating whether the condition for Category four is Satisfied.
     */
    public boolean isCategoryFourSatisfied() {
        return CategoryFourSatisfied;
    }

    /**
     * 
     * @param CategoryFourSatisfiedIn sets the boolean value for category four check.
     */
    public void setCategoryFourSatisfied(boolean CategoryFourSatisfiedIn) {
        this.CategoryFourSatisfied = CategoryFourSatisfiedIn;
    }

    /**
     * 
     * @return boolean value stating whether the condition for Category five is Satisfied.
     */
    public boolean isCategoryFiveSatisfied() {
        return CategoryFiveSatisfied;
    }

    /**
     * 
     * @param CategoryFiveSatisfiedIn sets the boolean value for category five check.
     */
    public void setCategoryFiveSatisfied(boolean CategoryFiveSatisfiedIn) {
        this.CategoryFiveSatisfied = CategoryFiveSatisfiedIn;
    }

    /**
     * 
     * @return boolean value stating whether a student can graduate or not
     */
    public boolean isGraduated() {
        return Graduated;
    }

    /**
     * 
     * @param GraduatedIn sets the boolean when student is ready for graduation 
     */
    public void setGraduated(boolean GraduatedIn) {
        this.Graduated = GraduatedIn;
    }
    
    /**
     * 
     * @return the count of courses processed.
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * @param countIn sets the counter after a particular course is processed.
     */
    public void setCount(int countIn) {
        this.count = countIn;
    }

    /**
     * 
     * @param buIDIn sets the BU_ID of the student which is currently in process.
     */
    public void setBuID(int buIDIn) {
        this.buID = buIDIn;
    }
    
    /**
     * 
     * @return the list of courses.
     */
    public List<String> getCourses() {
        return courses;
    }
    
    /**
     * 
     * @param sIn sets the state
     */
    public void setState(CoursePlannerStateI sIn){
        state=sIn;
    }
    
    /**
     * 
     * @return the state Object of type interface
     */
    public CoursePlannerStateI getState(){
        return state;
    }
    
    /**
     * Process the line which given in the file to be processed.
     */
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
                    }
                    else{
                       //Graduation
                        break;
                    }
                    setCount(getCount()+1);
                }
                
                if(!isGraduated()){
                    //Not GraduatedState
                    state = getState();
                    state.notGraduated(this);
                }
                else{
                    state = new GraduationState();
                    state.graduated(this);
                }
                
            }
                else{
                    System.out.println("Input File is Empty.");
                    System.out.println("Please Kindly enter the Data in the input and run it.");
                    System.exit(0);
                }
                fp.close();
    }
    
    /**
     * Function splits up the line and sets the Appropriate Value.
     * @param strIn contains the line
     */
    private void splitLine(String strIn) {
       strIn= strIn.trim(); // precaution if file contains any white spaces.
        String[] output = strIn.split(": ");
        this.setBuID(Integer.parseInt(output[0]));
        String[] c = output[1].split(" ");
        
        for(int i=0; i<c.length;i++)
            courses.add(c[i]);
    }
    
}
