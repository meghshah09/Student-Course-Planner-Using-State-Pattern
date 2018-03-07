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
public class CategoryTwoState implements CoursePlannerStateI{
    private String courseCurrentlyProcessing;
    private CoursePlannerStateI state;
    private int DSACount=0;

    
    public int getDSACount() {
        return DSACount;
    }

    public void setDSACount(int DSACountIn) {
        this.DSACount = DSACountIn;
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
        if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_H.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_E.toString())|| cIn.getAllotedCoursesList().contains(COURSE.COURSE_F.toString()) || 
                                cIn.getAllotedCoursesList().contains(COURSE.COURSE_G.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            state.doAction(cIn);
                            this.setDSACount(DSACount+1);
                        }
                        else{
                            //WaitList State
                            
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_G.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_E.toString()) || cIn.getAllotedCoursesList().contains(COURSE.COURSE_F.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            state.doAction(cIn);
                            this.setDSACount(DSACount+1);
                        }
                        else{
                           //Waitlist state
                        }
                    }
                    else if(getCourseCurrentlyProcessing().equals(COURSE.COURSE_F.toString())){
                        if(cIn.getAllotedCoursesList().contains(COURSE.COURSE_E.toString())){
                            //Alloted State
                            state = new CourseAllocatedState();
                            state.doAction(cIn);
                            this.setDSACount(DSACount+1);
                        }
                        else{
                            //Waitlist State
                        }
                    }
                    else{
                        // Alloted state
                        state = new CourseAllocatedState();
                        state.doAction(cIn);
                        this.setDSACount(DSACount+1);
                    }
        
        return this;
    }
    
}
