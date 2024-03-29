/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursePlanner.state;

import java.util.Iterator;

/**
 *
 * @author Megh Shah
 */
public class CourseWaitlistState implements CoursePlannerStateI {

    private CoursePlannerStateI state;
    
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
        state = new NotGraduationState();
        /* Work From Here Currently working fine with ArrayList but need to implement queue.*/
        int i = cIn.getWaitListQueue().size();
        int j=0;
      while (j<i) {
            cIn.setCourse(cIn.getWaitListQueue().get(j));
            state.doAction(cIn);
            j++;
      }
            
            
        return new NotGraduationState();
    }
    
    public void addCourseInWaitList(String strIn, Context cIn){
        if(!(cIn.getWaitListQueue().contains(strIn)))
            cIn.getWaitListQueue().add(strIn);
    }

    @Override
    public void graduated(Context cIn) {
        
    }

    @Override
    public void notGraduated(Context cIn) {
        
    }
    
    
    
}
