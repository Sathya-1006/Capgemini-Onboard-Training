package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class EmployeeDAO {



	    private JdbcTemplate jdbcTemplate;

	    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	    
	    private NamedParameterJdbcTemplate namedJdbc;
	    public void setNamedJdbc(NamedParameterJdbcTemplate namedJdbc) {
	        this.namedJdbc = namedJdbc;
	    }

	    // 1. Insert Employee
	    public void insertEmployee(Employee e) {

	        String sql = "insert into employeedetails(empId,empName,department,salary,email,mobile,city) values(?,?,?,?,?,?,?)";

	        int rows = jdbcTemplate.update(sql,
	                e.getEmpId(),
	                e.getEmpName(),
	                e.getDepartment(),
	                e.getSalary(),
	                e.getEmail(),
	                e.getMobile(),
	                e.getCity());

	        if (rows > 0)
	            System.out.println("Employee Inserted Successfully");
	    }

	    // 2. Update Salary
	    public void updateSalary(int id, double salary) {

	        String sql = "update employeedetails set salary=? where empId=?";

	        int rows = jdbcTemplate.update(sql, salary, id);

	        if (rows > 0)
	            System.out.println("Salary Updated");
	        else
	            System.out.println("Employee Not Found");
	    }

	    // 3. Update Department
	    public void updateDepartment(int id, String department) {

	        String sql = "update employeedetails set department=? where empId=?";

	        int rows = jdbcTemplate.update(sql, department, id);

	        if (rows > 0)
	            System.out.println("Department Updated");
	        else
	            System.out.println("Employee Not Found");
	    }

	    // 4. Delete Employee
	    public void deleteEmployee(int id) {

	        String sql = "delete from employeedetails where empId=?";

	        int rows = jdbcTemplate.update(sql, id);

	        if (rows > 0)
	            System.out.println("Employee Deleted");
	        else
	            System.out.println("Employee Not Found");
	    }

	    // 5. Search Employee
	    public Employee searchEmployee(int id) {

	        String sql = "select * from employeedetails where empId=?";

	        try {
	            return jdbcTemplate.queryForObject(sql,
	                    new BeanPropertyRowMapper<>(Employee.class),
	                    id);
	        } catch (Exception e) {
	            return null;
	        }
	    }

	    // 6. Display All Employees
	    public List<Employee> displayAll() {

	        String sql = "select * from employeedetails";

	        return jdbcTemplate.query(sql,
	                new BeanPropertyRowMapper<>(Employee.class));
	    }

	    // 7. Display IT Employees
	    public List<Employee> displayITEmployees() {

	        String sql = "select * from employeedetails where department='IT'";

	        return jdbcTemplate.query(sql,
	                new BeanPropertyRowMapper<>(Employee.class));
	    }

	    // 8. Display Salary > 50000
	    public List<Employee> salaryGreaterThan50000() {

	        String sql = "select * from employeedetails where salary>50000";

	        return jdbcTemplate.query(sql,
	                new BeanPropertyRowMapper<>(Employee.class));
	    }

	    // 9. Total Employees
	    public int totalEmployees() {

	        String sql = "select count(*) from employeedetails";

	        return jdbcTemplate.queryForObject(sql, Integer.class);
	    }

	    // 10. Maximum Salary
	    public double maximumSalary() {

	        String sql = "select max(salary) from employeedetails";

	        return jdbcTemplate.queryForObject(sql, Double.class);
	    }

	    // 11. Minimum Salary
	    public double minimumSalary() {

	        String sql = "select min(salary) from employeedetails";

	        return jdbcTemplate.queryForObject(sql, Double.class);
	    }

	    // 12. Average Salary
	    public double averageSalary() {

	        String sql = "select avg(salary) from employeedetails";

	        return jdbcTemplate.queryForObject(sql, Double.class);
	    }

	    // 13. Search By Name
	    public List<Employee> searchByName(String name) {

	        String sql = "select * from employeedetails where empName like ?";

	        return jdbcTemplate.query(sql,
	                new BeanPropertyRowMapper<>(Employee.class),
	                "%" + name + "%");
	    }

	    // 14. Sort Salary
	    public List<Employee> sortSalary() {

	        String sql = "select * from employeedetails order by salary";

	        return jdbcTemplate.query(sql,
	                new BeanPropertyRowMapper<>(Employee.class));
	    }
	    
	    //batch insert
	    
	    public void batchInsert(List<Employee> list) {

	        String sql = "insert into employeedetails(empId, empName, department, salary, email, mobile, city) "
	                   + "values(?, ?, ?, ?, ?, ?, ?)";

	        List<Object[]> batch = new ArrayList<>();

	        for (Employee e : list) {

	            batch.add(new Object[] {
	                    e.getEmpId(),
	                    e.getEmpName(),
	                    e.getDepartment(),
	                    e.getSalary(),
	                    e.getEmail(),
	                    e.getMobile(),
	                    e.getCity()
	            });
	        }

	        jdbcTemplate.batchUpdate(sql, batch);

	        System.out.println("Batch Insert Completed Successfully.");
	    }
	    
	    //BeanPropertyRowMapper
	    public Employee getEmployeeById(int id) {

	        String sql = "select * from employeedetails where empId=?";

	        return jdbcTemplate.queryForObject(
	                sql,
	                new BeanPropertyRowMapper<Employee>(Employee.class),
	                id);
	    }
	    
	    
	    // NamedParameter
	    public void insertNP(Employee emp) {

	        String sql = "insert into employeedetails "
	                + "(empId, empName, department, salary, email, mobile, city)"
	                + " values(:empId, :empName, :department, :salary, :email, :mobile, :city)";

	        MapSqlParameterSource map = new MapSqlParameterSource();

	        map.addValue("empId", emp.getEmpId());
	        map.addValue("empName", emp.getEmpName());
	        map.addValue("department", emp.getDepartment());
	        map.addValue("salary", emp.getSalary());
	        map.addValue("email", emp.getEmail());
	        map.addValue("mobile", emp.getMobile());
	        map.addValue("city", emp.getCity());

	        namedJdbc.update(sql, map);

	        System.out.println("Employee Inserted Successfully");
	    }

	}

