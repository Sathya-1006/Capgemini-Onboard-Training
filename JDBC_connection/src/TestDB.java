import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


class Student{

    int student_id;
    String student_name;
    int course_id;

    public Student() {

    }

    public Student(int student_id, String student_name, int course_id) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.course_id = course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}

// student data access object
class StudentDAD {
	//to load driver
	Connection con;
	PreparedStatement pst; // all meth can access the variables via this
	
	
	
	public StudentDAD() {
		
		//to load driver
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","Sathya@123");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	void storeStudent(Student student) {

	    String qry = "insert into students(student_id,student_name,course_id) values(?,?,?)";

	    try {

	        pst = con.prepareStatement(qry);

	        pst.setInt(1, student.getStudent_id());
	        pst.setString(2, student.getStudent_name());
	        pst.setInt(3, student.getCourse_id());

	        int res = pst.executeUpdate();

	        if(res > 0)
	            System.out.println(res + " row inserted.");

	    }
	    catch(SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	void updateStudent(int i, Student student) {

	    String qry = "update students set student_name=?, course_id=? where student_id=?";

	    try {

	        pst = con.prepareStatement(qry);

	        pst.setString(1, student.getStudent_name());
	        pst.setInt(2, student.getCourse_id());
	        pst.setInt(3, i);

	        int res = pst.executeUpdate();

	        if(res > 0)
	            System.out.println(res + " row updated.");

	    }
	    catch(SQLException e) {
	        e.printStackTrace();
	    }
	}       
	
	void deleteStudent(int i) {

	    String qry = "delete from students where student_id=?";

	    try {

	        pst = con.prepareStatement(qry);

	        pst.setInt(1, i);

	        int res = pst.executeUpdate();

	        if(res > 0)
	            System.out.println(res + " row deleted.");

	    }
	    catch(SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	void retrieve() {

	    String qry = "select * from students";

	    try {

	        pst = con.prepareStatement(qry);

	        ResultSet rs = pst.executeQuery();

	        System.out.println("Student ID\tStudent Name\tCourse ID");

	        while(rs.next()) {

	            Student st = new Student(
	                    rs.getInt("student_id"),
	                    rs.getString("student_name"),
	                    rs.getInt("course_id"));

	            System.out.println(st.getStudent_id() + "\t" +
	                               st.getStudent_name() + "\t" +
	                               st.getCourse_id());
	        }

	    }
	    catch(SQLException e) {
	        e.printStackTrace();
	    }
	}
	Student retrieve(int i) {

	    Student st = null;

	    String qry = "select * from students where student_id=?";

	    try {

	        pst = con.prepareStatement(qry);

	        pst.setInt(1, i);

	        ResultSet rs = pst.executeQuery();

	        if(rs.next()) {

	            st = new Student(
	                    rs.getInt("student_id"),
	                    rs.getString("student_name"),
	                    rs.getInt("course_id"));
	        }

	    }
	    catch(SQLException e) {
	        e.printStackTrace();
	    }

	    return st;
	}
	
}


public class TestDB {

    public static void main(String[] args) {

        StudentDAD obj = new StudentDAD();

        Student s1 = new Student(101, "Sathya", 1);

        obj.storeStudent(s1);

        System.out.println("\nAll Students");
        obj.retrieve();

        Student s2 = obj.retrieve(101);

        if(s2 != null) {
            System.out.println("\nStudent Found");
            System.out.println("Student ID : " + s2.getStudent_id());
            System.out.println("Student Name : " + s2.getStudent_name());
            System.out.println("Course ID : " + s2.getCourse_id());
        }
        else {
            System.out.println("Student Not Found");
        }

        Student s3 = new Student(101, "Sathya P", 2);
        obj.updateStudent(101, s3);

        System.out.println("\nAfter Update");
        obj.retrieve();

        obj.deleteStudent(101);

        System.out.println("\nAfter Delete");
        obj.retrieve();

    }

}
