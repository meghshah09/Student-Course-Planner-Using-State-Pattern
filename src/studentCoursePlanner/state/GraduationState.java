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

    @Override
    public CoursePlannerStateI doAction(Context cIn) {
        
        cIn.setGraduated(true);
        
        return this;
    }
    
}
