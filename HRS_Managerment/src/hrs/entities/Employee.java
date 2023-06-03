/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.entities;

/**
 *
 * @author baoduong
 */
public abstract class Employee {

    String ssn;
    String firstName;
    String lastName;
    String birthDate;
    String phone;
    String email;

    public Employee() {
    }

    public Employee(String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display() {
        System.out.println("SSN: " + ssn);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Birthday: " + birthDate);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);

    }

    @Override
    public String toString() {
        return ssn + " | " + firstName + " |  " + lastName + " | " + birthDate + " | " + phone + " | " + email;
    }

}
