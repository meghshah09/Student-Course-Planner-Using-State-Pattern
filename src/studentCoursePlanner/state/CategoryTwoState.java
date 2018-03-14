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
public class CategoryTwoState implements CoursePlannerStateI{
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
     * doAction method for Category two state.
     * @param cIn context class reference
     * @return the current state.
     */
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
        
        setCourseCurrentlyProcessing(cIn.getCourse());   
        if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_H.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_E.toString())|| cIn.getAllotedCoursesList().contains(COURSE.COURSE_F.toString()) || 
                                cIn.getAllotedCoursesList().contains(COURSE.COURSE_G.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setDSACount(cIn.getDSACount()+1);
                            stateAction(state,cIn);
                        }
                        else{
                            //WaitList State
                            new CourseWaitlistState().addCourseInWaitList(getCourseCurrentlyProcessing(), cIn);
                            
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_G.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_E.toString()) || cIn.getAllotedCoursesList().contains(COURSE.COURSE_F.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setDSACount(cIn.getDSACount()+1);
                            stateAction(state,cIn);
                        }
                        else{
                           //Waitlist state
                           new CourseWaitlistState().addCourseInWaitList(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_F.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_E.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setDSACount(cIn.getDSACount()+1);
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
                        cIn.setDSACount(cIn.getDSACount()+1);
                        stateAction(state,cIn);
                    }
        
             
        
        return this;
    }
    /**
     * Helper Method for doAction
     * @param stateIn contains the to be invoked.
     * @param cIn context class reference.
     */
    private void stateAction(CoursePlannerStateI stateIn, Context cIn){
        if(cIn.getDSACount()>=2){
                 cIn.setCategoryTwoSatisfied(true);
        }
        stateIn.doAction(cIn);
    }

    /**
     * Action will not be invoked for this state
     * @param strIn
     * @param cIn 
     */
    @Override
    public void addCourseInWaitList(String strIn, Context cIn) {
       
    }

    /**
     * Action will not be invoked for this state.
     * @param cIn 
     */
    @Override
    public void graduated(Context cIn) {
       
    }

    /**
     * Action will not be invoked for this state.
     * @param cIn 
     */
    @Override
    public void notGraduated(Context cIn) {
       
    }
}
