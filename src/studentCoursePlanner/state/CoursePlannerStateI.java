/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursePlanner.state;

/**
 *
 * @author Megh Shah
 */
public interface CoursePlannerStateI {

    public CoursePlannerStateI doAction(Context cIn);
    public void addCourseInWaitList(String strIn, Context cIn);
    public void graduated(Context cIn);
    public void notGraduated(Context cIn);
}
