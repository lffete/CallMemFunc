package com.javalib.excel.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
	private String name;
    private Date birthDate;
    private BigDecimal payment;
    private BigDecimal bonus;
    
    public Employee(String name, Date birthDate, int i, double d) {
        this.name = name;
        this.birthDate = birthDate;
        this.payment = BigDecimal.valueOf(i);
        this.bonus = BigDecimal.valueOf(d);
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	public BigDecimal getBonus() {
		return bonus;
	}
	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

    
}
