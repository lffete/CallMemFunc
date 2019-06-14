package com.javalib.uselib.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalib.excel.entity.Employee;

@RestController
@RequestMapping("/test")
public class HelloController {

	private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping(value="hello")
	public String sayHello() {
		logger.info("have a hello request!");
		try {
			testOutExcel();
		} catch(Exception e) {
			logger.error("error", e);
		}
		logger.info("deal over!");
		
		return "success";
	}
	
	private void testOutExcel() throws FileNotFoundException, IOException, ParseException {
	    logger.info("Running Object Collection demo");
	    List<Employee> employees = generateSampleEmployeeData();
	    try(InputStream is = HelloController.class.getClassLoader().getResourceAsStream("templates/testOut.xls")) {
			try (OutputStream os = new FileOutputStream("target/testOutData.xls")) {
	            Context context = new Context();
	            context.putVar("employees", employees);
	            JxlsHelper.getInstance().processTemplate(is, os, context);
	        }
	    }

	}
	
	private List<Employee> generateSampleEmployeeData() throws ParseException {
        List<Employee> employees = new ArrayList<Employee>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.US);
        employees.add( new Employee("Elsaya", dateFormat.parse("1970-Jul-10"), 1500, 0.15) );
        employees.add( new Employee("Oleg", dateFormat.parse("1973-Apr-30"), 2300, 0.25) );
        employees.add( new Employee("Neil", dateFormat.parse("1975-Oct-05"), 2500, 0.00) );
        employees.add( new Employee("Maria", dateFormat.parse("1978-Jan-07"), 1700, 0.15) );
        employees.add( new Employee("John", dateFormat.parse("1969-May-30"), 2800, 0.20) );
        return employees;
	}
}
