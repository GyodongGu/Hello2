package project2.model;

import java.util.List;

public interface EmployeeService {
	public List<Employee> getEmpList();
	public Employee getEmployee(int empNo);
	public void insertEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int empNo);
	
}
