package com.spring.boot.app.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.spring.boot.app.exception.EMSException;
import com.spring.boot.app.pojo.Employee;

@Component
public class EmployeeUtility {

	private List<Employee> employees = new ArrayList<>();

	@PostConstruct
	public void initDummyValue() {
		employees.add(new Employee(143, "Basant", "IT_DEV", 10000));
		employees.add(new Employee(199, "Santosh", "IT_FS_DEV", 100000));
		employees.add(new Employee(786, "Khiladi", "IT_DEV_MASTER", 800000));
		employees.add(new Employee(719, "Manoj", "IT_UI_DEV", 20000));
	}

	public String addEmployee(Employee e) throws EMSException {
		String message;
		if (e != null) {
			employees.add(e);
			message = "Record inserted successfully.";
		} else {
			throw new EMSException("Can't be add now");
		}
		return message;
	}

	public List<Employee> getAllEmployee() {
		return employees;
	}

	public Employee getEmployeeById(int id) throws EMSException {
		Employee employee;
		employee = employees.stream().filter(e -> e.getId() == id).findFirst()
				.orElse(null);
		if (employee != null) {
			return employee;
		} else {
			throw new EMSException("Employee Not found in our DataBase");
		}
	}

	public String deleteEmployee(int id) {
		employees.removeIf(e -> e.getId() == id);
		return "Record Removed Successfully.";
	}

	public String updateEmployee(int id, Employee e) {
		for (int i = 0; i <= employees.size(); i++) {
			Employee emp = employees.get(i);
			if (emp.getId() == id) {
				employees.set(i, e);
			}
		}
		return "Record Updated Successfully..";
	}
}
