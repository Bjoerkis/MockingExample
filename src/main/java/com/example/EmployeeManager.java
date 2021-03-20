package com.example;

import com.sun.jdi.LongValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public static int add(String... num1){

		// < Lamba to enable the addition of an unlimited amount of numbers >
		long longValue = Arrays.stream(num1)
				.filter(n -> !n.isEmpty())
				.map(n -> Integer.parseInt(n))
				.collect(Collectors.summarizingInt(Integer::intValue)).getSum();


		/* < If two numbers or less >
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
		*/

		return (int) longValue;



	}
}
