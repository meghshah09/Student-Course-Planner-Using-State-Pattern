/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCourseplanner.driver;

import java.util.Scanner;
import studentCoursePlanner.util.FileProcessor;
import studentCoursePlanner.state.Context;
import studentCoursePlanner.state.CoursePlannerStateI;
import studentCoursePlanner.state.NotGraduationState;
import studentCoursePlanner.util.Results;

/**
 *
 * @author Megh Shah
 */
public class Driver {
    public static void main(String[] args){
        if(args.length==2 && args[0].endsWith("input.txt") && args[1].endsWith("output.txt")){
            System.out.println("================================================");
            System.out.println("            Student Courses Planner             ");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("Starting the Process......");
                System.out.println("Trying to See Student Courses Planning from the given input file : "+ args[0]+" given.....");
                System.out.println("");
                Scanner scan = new Scanner(System.in);
                FileProcessor fp = new FileProcessor(scan);
                fp.setFileName(args[0]);
                fp.setCount(0);
                CoursePlannerStateI s = new NotGraduationState();
                Results r = new Results();
                Context c = new Context(fp,s,r);
                r.openingOutputFile(args[1]);
                c.ProcessingLine();
                r.closeingOutputFile();
                //System.out.println(c.toString());
                //fp.setFileName(args[1]);
                //fp.setCount(0);
                
                System.out.println("Done Planning Student Courses.....");
        }
        else{
            
            System.out.println("Please Kindly re-run the program with Correct Command line Arguments");
            System.exit(0);
            
        }
}
}
