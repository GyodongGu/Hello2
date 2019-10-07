package project2.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project2.common.DAO;
import project2.model.Employee;

public class EmpDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertEmp(Employee emp) {
		conn = DAO.getConnection();
		String sql = "insert into employees(employee_id, first_name, last_name, email, job_id, hire_date, salary)" + 
				"values (?,?,?,?,?,?,?)";
		
		int rCnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++rCnt, emp.getEmployeeId());
			pstmt.setString(++rCnt, emp.getFirstName());
			pstmt.setString(++rCnt, emp.getLastName());
			pstmt.setString(++rCnt, emp.getEmail());
			pstmt.setString(++rCnt, emp.getJobId());
			pstmt.setString(++rCnt, emp.getHireDate());
			pstmt.setInt(++rCnt, emp.getSalary());
			
			int r = pstmt.executeUpdate();
			System.out.println(r+"건이 입력되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public Employee getEmployee(int empNo) {
		conn = DAO.getConnection();
		Employee emp = null;
		String sql = "select * from employees where employee_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				emp =  new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
			}	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return emp;
	}
	
	
	public List<Employee> getEmpList(){
		
		List<Employee> list = new ArrayList<>();
		conn = DAO.getConnection();
		String sql = "select * from employees";
		Employee emp = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				emp =  new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
				
				list.add(emp);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
