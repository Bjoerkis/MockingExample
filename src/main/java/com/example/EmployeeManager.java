package com.example;

import java.util.List;

public class EmployeeManager {

	private final EmployeeRepository employeeRepository;
	private final BankService bankService;

	public EmployeeManager(EmployeeRepository employeeRepository, BankService bankService) {
		this.employeeRepository = employeeRepository;
		this.bankService = bankService;
	}

	public int payEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		int payments = 0;
		for (Employee employee : employees) {
			try {
				bankService.pay(employee.getId(), employee.getSalary());
				employee.setPaid(true);
				payments++;
			} catch (RuntimeException e) {
				employee.setPaid(false);
			}
		}
		return payments;
	}

	public static int add(String num1, String num2){

		if(num1.isEmpty() && num2.isEmpty()){
			return 0;
		}
		else if(num1.isEmpty()) {
			return Integer.parseInt(num2);
		}
		else if (num2.isEmpty()){
			return Integer.parseInt(num1);
		}
		return Integer.parseInt(num1) + Integer.parseInt(num2);

	}
}
