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



public class CategoryOneState implements CoursePlannerStateI{

    private String courseCurrentlyProcessing;
    private CoursePlannerStateI state;
    
    /**
     * 
     * @return currently processing course.
     */
    public String getCourseCurrentlyProcessing() {
        return courseCurrentlyProcessing;
    }

    /**
     * 
     * @param courseCurrentlyProcessingIn sets the currently processing course.
     */
    public void setCourseCurrentlyProcessing(String courseCurrentlyProcessingIn) {
        this.courseCurrentlyProcessing = courseCurrentlyProcessingIn;
    }
    
    
    /**
     * doAction Method for Category one.
     * @param cIn context class object
     * @return return the particular state
     */
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
    setCourseCurrentlyProcessing(cIn.getCourse());   
    
                    if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_D.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_A.toString())|| cIn.getAllotedCoursesList().contains(COURSE.COURSE_B.toString()) || 
                                cIn.getAllotedCoursesList().contains(COURSE.COURSE_C.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setLongCount(cIn.getLongCount()+1);
                            stateAction(state,cIn);
                        }
                        else{
                            //WaitList State
                            new CourseWaitlistState().addCourseInWaitList(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_C.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_A.toString()) || cIn.getAllotedCoursesList().contains(COURSE.COURSE_B.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setLongCount(cIn.getLongCount()+1);
                            stateAction(state,cIn);
                        }
                        else{
                           //Waitlist state
                           new CourseWaitlistState().addCourseInWaitList(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_B.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_A.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            //state.doAction(cIn);
                            cIn.setLongCount(cIn.getLongCount()+1);
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
                        cIn.setLongCount(cIn.getLongCount()+1);
                        stateAction(state,cIn);
                    }
                    
                    
    
    return this;
}
    /**
     * helper method 
     * @param stateIn contains the state on which the doAction Method is to be invoked.
     * @param cIn contains the context class object
     */
    private void stateAction(CoursePlannerStateI stateIn, Context cIn){
        if(cIn.getLongCount()>=2){
            cIn.setCategoryOneSatisfied(true);
        }
        stateIn.doAction(cIn);
    }

    /**
     * Action won't be invoked from this state
     * @param strIn
     * @param cIn 
     */
    @Override
    public void addCourseInWaitList(String strIn, Context cIn) {
       
    }

    /**
     * Action won't be invoked from this state
     * @param cIn 
     */
    @Override
    public void graduated(Context cIn) {
        
    }

    /**
     * Action won't be invoked from this state
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