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
public class CategoryFourState implements CoursePlannerStateI{
    
    
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
     * doAction method for Category four state.
     * @param cIn context class reference
     * @return the current state.
     */
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
        
        setCourseCurrentlyProcessing(cIn.getCourse());
        if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_P.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_M.toString())|| cIn.getAllotedCoursesList().contains(COURSE.COURSE_N.toString()) || 
                                cIn.getAllotedCoursesList().contains(COURSE.COURSE_O.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setDataCount(cIn.getDataCount()+1);
                            stateAction(state, cIn);
                        }
                        else{
                            //WaitList State
                            new CourseWaitlistState().addCourseInWaitList(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_O.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_M.toString()) || cIn.getAllotedCoursesList().contains(COURSE.COURSE_N.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setDataCount(cIn.getDataCount()+1);
                            stateAction(state, cIn);
                        }
                        else{
                           //Waitlist state
                           new CourseWaitlistState().addCourseInWaitList(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_N.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_M.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setDataCount(cIn.getDataCount()+1);
                            stateAction(state, cIn);
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
                        cIn.setDataCount(cIn.getDataCount()+1);
                        stateAction(state, cIn);
                    }
        
        
        
        
        return this;
    }
    /*
    Helper method for doAction
    */
    private void stateAction(CoursePlannerStateI stateIn, Context cIn){
        if(cIn.getDataCount()>=2){
            cIn.setCategoryFourSatisfied(true);
        }
        stateIn.doAction(cIn);
    }
    
    /*
    Action will not be invoked from this state.
    */
    @Override
    public void addCourseInWaitList(String strIn, Context cIn) {
        
    }

    /**
     * Action will not be invoked from this state.
     * @param cIn 
     */
    @Override
    public void graduated(Context cIn) {
        
    }

    /**
     * Action will not be invoked from this state.
     * @param cIn 
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
