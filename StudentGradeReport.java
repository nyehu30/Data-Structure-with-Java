/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw1.Q4;
import java.util.Map;
/**
 *
 * @author n9e
 */
public class StudentGradeReport {
    public String name;
    public Map<String, Integer> grades;
    
    public StudentGradeReport(String name, Map<String, Integer> grades ){
       this.name = name;
       this.grades = grades;
    }
}
