/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursePlanner.state;

import studentCoursePlanner.util.AllotedCoursesList;
import studentCoursePlanner.util.COURSE;
/**
 *
 * @author Megh Shah
 */



public class CategoryOneState implements CoursePlannerStateI{

    private String courseCurrentlyProcessing;
    private CoursePlannerStateI state;
    private int longCount;
   

    public int getLongCount() {
        return longCount;
    }

    public void setLongCount(int longCountIn) {
        this.longCount = longCountIn;
    }
    
    public String getCourseCurrentlyProcessing() {
        return courseCurrentlyProcessing;
    }

    public void setCourseCurrentlyProcessing(String courseCurrentlyProcessingIn) {
        this.courseCurrentlyProcessing = courseCurrentlyProcessingIn;
    }
    
    
    
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
    setCourseCurrentlyProcessing(cIn.getCourse());   
    
                    if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_D.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_A.toString())|| cIn.getAllotedCoursesList().contains(COURSE.COURSE_B.toString()) || 
                                cIn.getAllotedCoursesList().contains(COURSE.COURSE_C.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            state.doAction(cIn);
                            this.setLongCount(longCount+1);
                        }
                        else{
                            //WaitList State
                            new CourseWaitlistState().doAddition(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_C.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_A.toString()) || cIn.getAllotedCoursesList().contains(COURSE.COURSE_B.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            state.doAction(cIn);
                            this.setLongCount(longCount+1);
                        }
                        else{
                           //Waitlist state
                           new CourseWaitlistState().doAddition(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_B.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_A.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            state.doAction(cIn);
                            this.setLongCount(longCount+1);
                        }
                        else{
                            //Waitlist State
                            new CourseWaitlistState().doAddition(getCourseCurrentlyProcessing(), cIn);
                        }
                    }
                    else{
                        // Alloted state
                        state = new CourseAllocatedState();
                        state.doAction(cIn);
                        this.setLongCount(longCount+1);
                    }
    
    return this;
}
}