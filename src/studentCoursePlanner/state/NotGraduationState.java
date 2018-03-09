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
    private List<String> coursesProcessing = new ArrayList<>();
    private CourseWaitlistState waitListQueue;
    public String getCourseCurrentlyProcessing() {
        return courseCurrentlyProcessing;
    }

    public void setCourseCurrentlyProcessing(String courseCurrentlyProcessingIn) {
        this.courseCurrentlyProcessing = courseCurrentlyProcessingIn;
    }
    
    
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
        
        setCourseCurrentlyProcessing(cIn.getCourse());
        if(!(cIn.getAllotedCoursesList().contains(getCourseCurrentlyProcessing()))){ // Same course Will not be allowed.
            //coursesProcessing.add(getCourseCurrentlyProcessing());
            
            if(courseCurrentlyProcessing.equals("A") || courseCurrentlyProcessing.equals(COURSE.COURSE_B.toString())|| courseCurrentlyProcessing.equals(COURSE.COURSE_C.toString()) ||
                courseCurrentlyProcessing.equals(COURSE.COURSE_D.toString())){
                state = new CategoryOneState();
                state.doAction(cIn);
            }
            else if(courseCurrentlyProcessing.equals("E") || courseCurrentlyProcessing.equals("F")|| courseCurrentlyProcessing.equals("G") ||
                courseCurrentlyProcessing.equals("H")){
                state = new CategoryTwoState();
                state.doAction(cIn);
            }
            else if(courseCurrentlyProcessing.equals("I") || courseCurrentlyProcessing.equals("J")|| courseCurrentlyProcessing.equals("K") ||
                courseCurrentlyProcessing.equals("L")){
                state = new CategoryThreeState();
                state.doAction(cIn);
            }
            else if(courseCurrentlyProcessing.equals("M") || courseCurrentlyProcessing.equals("N")|| courseCurrentlyProcessing.equals("O") ||
                courseCurrentlyProcessing.equals("P")){
                state = new CategoryFourState();
                state.doAction(cIn);
            }
            else{
                state = new CategoryFiveState();
                state.doAction(cIn);
            }
        }   
        return new CourseWaitlistState();
    }
    
}
