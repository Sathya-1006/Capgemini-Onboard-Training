package studentranking;

import java.util.*;

public class StudentOperations {
	
	 ArrayList<Student> list = new ArrayList<>();

	    public void addStudent(Student s) {
	        list.add(s);
	    }

	    public void displayStudents() {
	        for(Student s : list) {
	            System.out.println(s);
	        }
	    }
	    
	    //Highest marks
	    public void sortByMarks() {

	        Collections.sort(list, (s1, s2) ->
	                s2.getMarks() - s1.getMarks());

	        displayStudents();
	    }
	    
	    //sort by name
	    public void sortByName() {

	        Collections.sort(list, (s1, s2) ->
	                s1.getName().compareTo(s2.getName()));

	        displayStudents();
	    }
	    
	    
	    //Sort by Roll number
	    public void sortByRollNo() {

	        Collections.sort(list, (s1, s2) ->
	                s1.getRollNo() - s2.getRollNo());

	        displayStudents();
	    }
	    
	    
	    //top 5
	    public void topFiveStudents() {

	        Collections.sort(list, (s1, s2) ->
	                s2.getMarks() - s1.getMarks());

	        int limit = Math.min(5, list.size());

	        for(int i=0;i<limit;i++) {
	            System.out.println(list.get(i));
	        }
	    }
	    
	    //department wise topper
	    public void departmentTopper() {

	        HashMap<String, Student> map = new HashMap<>();

	        for(Student s : list) {

	            if(!map.containsKey(s.getDepartment())) {
	                map.put(s.getDepartment(), s);
	            }

	            else {

	                Student old = map.get(s.getDepartment());

	                if(s.getMarks() > old.getMarks()) {
	                    map.put(s.getDepartment(), s);
	                }
	            }
	        }

	        for(String dept : map.keySet()) {

	            System.out.println(dept + " -> " + map.get(dept));

	        }
	    }
	    
	    
	    //above 80
	    public void countAbove80() {

	        int count = 0;

	        for(Student s : list) {

	            if(s.getMarks() > 80) {
	                count++;
	            }

	        }

	        System.out.println("Students above 80 = " + count);

	    }

	}
	    
	    

