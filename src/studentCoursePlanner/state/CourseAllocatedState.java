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
public class CourseAllocatedState implements CoursePlannerStateI{

    private String courseCurrentlyProcessing;
    private CoursePlannerStateI state;
    
    /**
     * 
     * @return currently Processing Course for this state. 
     */
    public String getCourseCurrentlyProcessing() {
        return courseCurrentlyProcessing;
    }

    /**
     * 
     * @param courseCurrentlyProcessingIn currently to be processed course for this state 
     */
    public void setCourseCurrentlyProcessing(String courseCurrentlyProcessingIn) {
        this.courseCurrentlyProcessing = courseCurrentlyProcessingIn;
    }
    
    /**
     * 
     * @param cIn
     * @return 
     */
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
     
        setCourseCurrentlyProcessing(cIn.getCourse());
        cIn.getAllotedCoursesList().add(getCourseCurrentlyProcessing());

        if((cIn.getAllotedCoursesList().size() % 3 )==0){
            cIn.setNoOfSemester(cIn.getNoOfSemester()+1);
        }
        if(cIn.getAllotedCoursesList().size()>=10){
        if(cIn.isCategoryOneSatisfied() && cIn.isCategoryTwoSatisfied() && cIn.isCategoryThreeSatisfied() && cIn.isCategoryFourSatisfied() && cIn.isCategoryFiveSatisfied()){
            state= new GraduationState();
            state.doAction(cIn);
        }
        }
        return this;
    }

    @Override
    public void addCourseInWaitList(String strIn, Context cIn) {
        
    }

    @Override
    public void graduated(Context cIn) {
        
    }

    @Override
    public void notGraduated(Context cIn) {
        
    }
    
}
