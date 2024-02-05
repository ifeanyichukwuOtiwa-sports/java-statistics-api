package io.wtech.statistics.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class Employee {
    private long id;
    @JsonProperty("first_name")
    private String firstname;
    @JsonProperty("last_name")
    private String lastname;
    private String email;
    private String phone;
    private String gender;
    private int age;

    @JsonProperty("job_title")
    private String jobTittle;

    @JsonProperty("years_of_experience")
    private int yearsOfExperience;
    private BigDecimal salary;
    private String department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", jobTittle='" + jobTittle + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public Employee() {
    }

    public Employee(final long id, final String firstname, final String lastname, final String email, final String phone, final String gender, final int age, final String jobTittle, final int yearsOfExperience, final BigDecimal salary, final String department) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.jobTittle = jobTittle;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getJobTittle() {
        return jobTittle;
    }

    public void setJobTittle(final String jobTittle) {
        this.jobTittle = jobTittle;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(final int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(final BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(final String department) {
        this.department = department;
    }
}
