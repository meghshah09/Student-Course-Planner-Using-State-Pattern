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
public class GraduationState implements CoursePlannerStateI{

    /**
     * doAction method for Graduation state.
     * @param cIn context class reference
     * @return the current state.
     */
    @Override
    public CoursePlannerStateI doAction(Context cIn) {
        
        cIn.setGraduated(true);
        if((cIn.getAllotedCoursesList().size()%3)!=0){
            cIn.setNoOfSemester(cIn.getNoOfSemester()+1);
        }
        return this;
    }

    /**
     * Action will not be invoked from this state
     * @param strIn
     * @param cIn 
     */
    @Override
    public void addCourseInWaitList(String strIn, Context cIn) {
        
    }

    /**
     * action Called when person is ready to graduate.
     * @param cIn context class reference
     */
    @Override
    public void graduated(Context cIn) {
       String resultString = "BU ID "+cIn.getBuID()+" will Graduate with the following sequence of Courses as per the Student"
               + " requirement and Planning Policy "+ cIn.getAllotedCoursesList()+ " And No. of Semester Taken is "+cIn.getNoOfSemester();
       cIn.getResult().fileDisplay(resultString);
       cIn.getResult().stdoutDisplay(resultString);
    }

    /*
    Action will not be invoked from this state.
    */
    @Override
    public void notGraduated(Context cIn) {
        
        
    }
    
}
