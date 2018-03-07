/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursePlanner.state;

import studentCoursePlanner.util.AllotedCoursesList;

/**
 *
 * @author Megh Shah
 */
public class CourseAllocatedState implements CoursePlannerStateI{

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
        cIn.getAllotedCoursesList().add(getCourseCurrentlyProcessing());
        return this;
    }
    
}
