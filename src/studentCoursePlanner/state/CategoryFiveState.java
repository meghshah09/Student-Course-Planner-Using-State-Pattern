/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursePlanner.state;

/**
 *
 * @author Megh Shah
 */
public class CategoryFiveState implements CoursePlannerStateI{

    private String courseCurrentlyProcessing;
    private CoursePlannerStateI state;
    
    
    /**
     * 
     * @return the currently processing course 
     */
    public String getCourseCurrentlyProcessing() {
        return courseCurrentlyProcessing;
    }

    /**
     * 
     * @param courseCurrentlyProcessingIn sets the currently processing course
     */
    public void setCourseCurrentlyProcessing(String courseCurrentlyProcessingIn) {
        this.courseCurrentlyProcessing = courseCurrentlyProcessingIn;
    }
    
    /**
     * doAction method for Category five state.
     * @param cIn context class reference
     * @return the current state.
     */
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
        
        
        state = new CourseAllocatedState();
        
        cIn.setElectiveCount(cIn.getElectiveCount()+1);
        
        if(cIn.getElectiveCount()>=2){
            cIn.setCategoryFiveSatisfied(true);
        }
        state.doAction(cIn);
        
        return this;
    }

    /*
    Action won't be invoked for this state
    */
    @Override
    public void addCourseInWaitList(String strIn, Context cIn) {
        
    }

    /*
    Action won't be invoked for this state
    */
    @Override
    public void graduated(Context cIn) {
        
    }

    /*
    Action won't be invoked for this state.
    */
    @Override
    public void notGraduated(Context cIn) {
        
    }
    
    @Override
    public String toString(){
    String string = "Currently processing state is "+ getCourseCurrentlyProcessing();
    return string;
    }
}
