package project2.impl;

import java.util.List;

import project2.model.Employee;
import project2.model.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	EmpDAO dao = new EmpDAO();
	
	@Override
	public List<Employee> getEmpList() {
		// TODO Auto-generated method stub
		List<Employee> list= dao.getEmpList();
		
		return list;
	}

	@Override
	public Employee getEmployee(int empNo) {
		// TODO Auto-generated method stub
		Employee emp = dao.getEmployee(empNo);
		return emp;
	}

	@Override
	public void insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		dao.insertEmp(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int empNo) {
		// TODO Auto-generated method stub
		
	}

}
