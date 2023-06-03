/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.entities;

import java.util.ArrayList;

/**
 *
 * @author baoduong
 */
public class Department extends Employee {

    private String departmentName;
    public Employee emp;
    public static ArrayList<Department> dList = new ArrayList<Department>();

    public Department() {
    }

    public Department(String departmentName, Employee emp) {
        this.departmentName = departmentName;
        this.emp = emp;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return emp.toString() + " | " + departmentName;
    }

}
