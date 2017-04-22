package com.spring.boot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.app.exception.EMSException;
import com.spring.boot.app.pojo.Employee;
import com.spring.boot.app.pojo.Response;
import com.spring.boot.app.util.EmployeeUtility;

@Service
public class EMSService {

	@Autowired(required = true)
	private EmployeeUtility utility;

	public Response add(Employee e) {
		String message;
		Response response = null;
		try {
			message = utility.addEmployee(e);
			response = new Response(true, message);
		} catch (EMSException e1) {
			response = new Response(false, e1.getMessage());
		}
		return response;
	}

	public List<Employee> getAllEmployee() {
		return utility.getAllEmployee();
	}

	public Employee findEmployeeById(int id) throws EMSException {
		return utility.getEmployeeById(id);
	}

	public Response deleteEmployee(int id) {
		String message = utility.deleteEmployee(id);
		return new Response(true, message);
	}

	public Response updateEmployee(int id, Employee e) {
		String message = utility.updateEmployee(id, e);
		return new Response(true, message);
	}
}
