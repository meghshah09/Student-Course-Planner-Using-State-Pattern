/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursePlanner.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Megh Shah
 */
public class Results implements FileDisplayInterface,StdoutDisplayInterface {

    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;
    /**
     * default constructor
     */
    public Results(){
    
        
    }
    /**
     * 
     * @param fileIn opens the specified file for writing. 
     */
    public void openingOutputFile(String fileIn){
        
        try{
           fileWriter = new FileWriter(fileIn);
           bufferedWriter = new BufferedWriter(fileWriter);         
        }
        catch(IOException e){
            System.out.println("Sorry Your Output file was not found. Please Place the file properly and run it.");
            System.out.println("Exiting.....");
            System.exit(0);
        }
    }
    /**
     * closes the file.
     */
    public void closeingOutputFile(){
        try{
            bufferedWriter.close();
        }
        catch(IOException e){
            System.out.println("Problem while Closing the file : " +e.getMessage());
        }
    }

    @Override
    public void fileDisplay(String strIn) {
        try{
            bufferedWriter.write(strIn);
            bufferedWriter.newLine();
        }
        catch(IOException e){
            System.out.println("Error while writing to the file.");
        }
        
    }

    @Override
    public void stdoutDisplay(String strIn) {
        System.out.println(strIn);
    }
    
    
}
