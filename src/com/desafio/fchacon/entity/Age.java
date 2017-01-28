package com.desafio.fchacon.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Age implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5082871329673433763L;
	private Integer years;
	private Integer months;
	private Integer days;
	
	public Age() {}
	
	public Age(int days, int months, int years) {
		this.days = new Integer(days);
		this.months = new Integer(months);
		this.years = new Integer(years);
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
	public String getReadable() {
		String response = "";
		if(years.intValue() > 0)
			response += years.intValue() + " años";
		
		if(months.intValue() > 0) {
			if(!response.isEmpty())
				response += ", ";
			
			response += months.intValue() + " meses";
		}
		
		if(days.intValue() > 0) {
			if(!response.isEmpty())
				response += " y ";
			
			response += days.intValue() + " días.";
		}
		
		if(response.isEmpty())
			response = "0 días";
		
		return response;
	} 

	@Override
	public String toString() {
		return "Age [years=" + years + ", months=" + months + ", days=" + days
				+ "]";
	}
}
