/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursePlanner.state;

import java.util.ArrayList;
import java.util.List;
import studentCoursePlanner.util.COURSE;

/**
 *
 * @author Megh Shah
 */
public class NotGraduationState implements CoursePlannerStateI{

    private String courseCurrentlyProcessing;
    private CoursePlannerStateI state;

    /**
     * 
     * @return the currently processing course for this state
     */
    public String getCourseCurrentlyProcessing() {
        return courseCurrentlyProcessing;
    }

    /**
     * 
     * @param courseCurrentlyProcessingIn sets the currently processing course for this state.
     */
    public void setCourseCurrentlyProcessing(String courseCurrentlyProcessingIn) {
        this.courseCurrentlyProcessing = courseCurrentlyProcessingIn;
    }
    
    /**
     * Action Method for Not Graduation State.
     * @param cIn Context class object
     * @return 
     */
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
        
        setCourseCurrentlyProcessing(cIn.getCourse());
        if(!(cIn.getAllotedCoursesList().contains(getCourseCurrentlyProcessing()))){ // Same course Will not be allowed to process.
            //coursesProcessing.add(getCourseCurrentlyProcessing());
            
            if(courseCurrentlyProcessing.equals(COURSE.COURSE_A.toString()) || courseCurrentlyProcessing.equals(COURSE.COURSE_B.toString())|| 
                    courseCurrentlyProcessing.equals(COURSE.COURSE_C.toString()) || courseCurrentlyProcessing.equals(COURSE.COURSE_D.toString())){
                state = new CategoryOneState();
                state.doAction(cIn);
            }
            else if(courseCurrentlyProcessing.equals(COURSE.COURSE_E.toString()) || courseCurrentlyProcessing.equals(COURSE.COURSE_F.toString())|| 
                    courseCurrentlyProcessing.equals(COURSE.COURSE_G.toString()) || courseCurrentlyProcessing.equals(COURSE.COURSE_H.toString())){
                state = new CategoryTwoState();
                state.doAction(cIn);
            }
            else if(courseCurrentlyProcessing.equals(COURSE.COURSE_I.toString()) || courseCurrentlyProcessing.equals(COURSE.COURSE_J.toString())|| 
                    courseCurrentlyProcessing.equals(COURSE.COURSE_K.toString()) || courseCurrentlyProcessing.equals(COURSE.COURSE_L.toString())){
                state = new CategoryThreeState();
                state.doAction(cIn);
            }
            else if(courseCurrentlyProcessing.equals(COURSE.COURSE_M.toString()) || courseCurrentlyProcessing.equals(COURSE.COURSE_N.toString())|| 
                    courseCurrentlyProcessing.equals(COURSE.COURSE_O.toString()) ||courseCurrentlyProcessing.equals(COURSE.COURSE_P.toString())){
                state = new CategoryFourState();
                state.doAction(cIn);
            }
            else{
                state = new CategoryFiveState();
                state.doAction(cIn);
            }
        }
        
        if(!cIn.isGraduated()){
            return new CourseWaitlistState();
        }
        else
        {
            return new GraduationState();
        }
    }

    @Override
    public void addCourseInWaitList(String strIn, Context cIn) {
        
    }
    
    @Override
    public void graduated(Context cIn) {
       
    }

    /**
     * Invoked when a student do not Graduate
     * @param cIn Context class object
     */
    @Override
    public void notGraduated(Context cIn) {
        
        String resultString = "BU ID "+cIn.getBuID()+" will not Graduate and this is the courses Sequence which was tried "
                +cIn.getAllotedCoursesList()+" as per the requirement given by the student and Planning Policy";
        cIn.getResult().fileDisplay(resultString);
        cIn.getResult().stdoutDisplay(resultString);
    
    }
    
    
}
