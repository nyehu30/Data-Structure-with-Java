/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw1.Q4;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author n9e
 */
public class ClassStatistics{
    
    public ClassStatistics()
    {
        
    }
    
    public StudentGradeReport getBestStudent(List<StudentGradeReport> gradeReports, Map<String, AssignmentInfo> info)
    {
        List<Double> total = new ArrayList<>();
        for(int i = 0; i < gradeReports.size(); i++)
        {
            double homeworkWeightedValue = info.get("Homeworks").weight * (gradeReports.get(i).grades.get("Homeworks")/info.get("Homeworks").maxPoints);
            double examWeightedValue = info.get("Exams").weight * (gradeReports.get(i).grades.get("Exams")/info.get("Exams").maxPoints);
            double labWeightedValue = info.get("Labs").weight * (gradeReports.get(i).grades.get("Labs")/info.get("Labs").maxPoints);
            double totalWeightedValue = 100 * (homeworkWeightedValue + examWeightedValue + labWeightedValue);
            //System.out.println("homeworkWeightedValue = " + homeworkWeightedValue);
            total.add(totalWeightedValue);
        }
        int studentIndex = 0;
        double max = 0;
        for (int j = 0; j < total.size(); j++) {
            if (total.get(j) > max) {
                max = total.get(j);
                studentIndex = j;
            }
        }
    return gradeReports.get(studentIndex);
    }
}
