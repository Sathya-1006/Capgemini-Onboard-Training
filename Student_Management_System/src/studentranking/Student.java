package studentranking;

public class Student {
	  private int rollNo;
	    private String name;
	    private int marks;
	    private String department;

	    public Student(int rollNo, String name, int marks, String department) {
	        this.rollNo = rollNo;
	        this.name = name;
	        this.marks = marks;
	        this.department = department;
	    }

	    public int getRollNo() {
	        return rollNo;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getMarks() {
	        return marks;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    @Override
	    public String toString() {
	        return rollNo + " " + name + " " + marks + " " + department;
	    }
}
