/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursePlanner.state;

import studentCoursePlanner.util.COURSE;

/**
 *
 * @author Megh Shah
 */
public class CategoryThreeState implements CoursePlannerStateI{

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
     * doAction method for Category three state.
     * @param cIn context class reference
     * @return the current state.
     */
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
        
        setCourseCurrentlyProcessing(cIn.getCourse());
        if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_L.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_I.toString())|| cIn.getAllotedCoursesList().contains(COURSE.COURSE_J.toString()) || 
                                cIn.getAllotedCoursesList().contains(COURSE.COURSE_K.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setHardCount(cIn.getHardCount()+1);
                             stateAction(state,cIn);
                        }
                        else{
                            //WaitList State
                            new CourseWaitlistState().addCourseInWaitList(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_K.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_I.toString()) || cIn.getAllotedCoursesList().contains(COURSE.COURSE_J.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setHardCount(cIn.getHardCount()+1);
                             stateAction(state,cIn);
                        }
                        else{
                           //Waitlist state
                           new CourseWaitlistState().addCourseInWaitList(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_J.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_I.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setHardCount(cIn.getHardCount()+1);
                             stateAction(state,cIn);
                        }
                        else{
                            //Waitlist State
                            new CourseWaitlistState().addCourseInWaitList(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else{
                        // Alloted state
                        state = new CourseAllocatedState();
                        //state.doAction(cIn);
                        cIn.setHardCount(cIn.getHardCount()+1);
                         stateAction(state,cIn);
                    }
        
             if(cIn.getHardCount()>=2){
                 cIn.setCategoryThreeSatisfied(true);
             }
        
        return this;
    }
    private void stateAction(CoursePlannerStateI stateIn, Context cIn){
        if(cIn.getHardCount()>=2){
                 cIn.setCategoryThreeSatisfied(true);
        }
        stateIn.doAction(cIn);
        
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
    
    @Override
    public String toString(){
    String string = "Currently processing state is "+ getCourseCurrentlyProcessing();
    return string;
    }
}
