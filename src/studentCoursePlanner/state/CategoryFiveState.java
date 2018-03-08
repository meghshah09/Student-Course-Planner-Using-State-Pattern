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
    
    
    
    public String getCourseCurrentlyProcessing() {
        return courseCurrentlyProcessing;
    }

    public void setCourseCurrentlyProcessing(String courseCurrentlyProcessingIn) {
        this.courseCurrentlyProcessing = courseCurrentlyProcessingIn;
    }
    
    
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
    
}
