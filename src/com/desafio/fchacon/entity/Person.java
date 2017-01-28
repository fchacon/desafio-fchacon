package com.desafio.fchacon.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.desafio.fchacon.util.Utils;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1645144569128571741L;
	private String run;
	private String fullName;
	private String birthDate;
	private String gender;
	private String age;
	
	public Person() {}
	
	public Person(String run, String fullName, String birthDate, String gender) {
		this.run = run.trim();
		this.fullName = fullName.trim();
		this.birthDate = birthDate.trim();
		this.gender = gender.trim();
		this.age = Utils.calculateAge(birthDate).getReadable();
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [run=" + run + ", fullName=" + fullName + ", birthDate="
				+ birthDate + ", gender=" + gender + ", age=" + age + "]";
	}
}
