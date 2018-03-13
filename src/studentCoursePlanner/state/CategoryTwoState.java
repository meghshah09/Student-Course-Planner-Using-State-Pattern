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
    
    
    public String getCourseCurrentlyProcessing() {
        return courseCurrentlyProcessing;
    }

    public void setCourseCurrentlyProcessing(String courseCurrentlyProcessingIn) {
        this.courseCurrentlyProcessing = courseCurrentlyProcessingIn;
    }
   
    
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
                            new CourseWaitlistState().doAddition(getCourseCurrentlyProcessing(), cIn);
                            
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
                           new CourseWaitlistState().doAddition(getCourseCurrentlyProcessing(), cIn);
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
                            new CourseWaitlistState().doAddition(getCourseCurrentlyProcessing(), cIn);
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
    private void stateAction(CoursePlannerStateI stateIn, Context cIn){
        if(cIn.getDSACount()>=2){
                 cIn.setCategoryTwoSatisfied(true);
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
