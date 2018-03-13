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
    
    
    public String getCourseCurrentlyProcessing() {
        return courseCurrentlyProcessing;
    }

    public void setCourseCurrentlyProcessing(String courseCurrentlyProcessingIn) {
        this.courseCurrentlyProcessing = courseCurrentlyProcessingIn;
    }

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
                            new CourseWaitlistState().doAddition(getCourseCurrentlyProcessing(), cIn);
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
                           new CourseWaitlistState().doAddition(getCourseCurrentlyProcessing(), cIn);
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
                            new CourseWaitlistState().doAddition(getCourseCurrentlyProcessing(), cIn);
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
    
    private void stateAction(CoursePlannerStateI stateIn, Context cIn){
        if(cIn.getDataCount()>=2){
            cIn.setCategoryFourSatisfied(true);
        }
        stateIn.doAction(cIn);
    }

    @Override
    public void doAddition(String strIn, Context cIn) {
        
    }

    @Override
    public void graduated(Context cIn) {
        
    }

    @Override
    public void notGraduated(Context cIn) {
        
    }
}
