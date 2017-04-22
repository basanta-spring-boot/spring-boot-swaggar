package com.spring.boot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.app.exception.EMSException;
import com.spring.boot.app.pojo.Employee;
import com.spring.boot.app.pojo.Response;
import com.spring.boot.app.service.EMSService;

@RestController
@RequestMapping(value = "/EMS")
@EnableAutoConfiguration
public class EMSController {
	@Autowired(required = true)
	private EMSService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addEmployee(@RequestBody Employee e) {
		return service.add(e);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Response updateEmployee(@RequestBody Employee e,
			@PathVariable("id") int id) {
		return service.updateEmployee(id, e);
	}

	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int id) throws EMSException {
		return service.findEmployeeById(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Response deleteEmployee(@PathVariable("id") int id) {
		return service.deleteEmployee(id);
	}
}
