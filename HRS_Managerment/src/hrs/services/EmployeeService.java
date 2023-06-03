/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.services;

import java.util.ArrayList;
import hrs.entities.Department;
import hrs.utils.Validation;
import static hrs.entities.Department.dList;
import hrs.entities.HourlyEmployee;
import hrs.entities.SalariedEmployee;
import hrs.entities.Employee;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author baoduong
 */
public class EmployeeService extends ArrayList {

    Scanner sc = new Scanner(System.in);

    public int checkDP(String dp) {
        if (dList.isEmpty()) {
            return -1;
        }
        for (Department d : dList) {
            if (d.getDepartmentName().equalsIgnoreCase(dp)) {
                return dList.indexOf(d);
            }
        }
        return -1;
    }

    public int checkName(String name) {
        if (dList.isEmpty()) {
            return -1;
        }
        for (Department d : dList) {

            if (d.emp.getFirstName().equalsIgnoreCase(name) || d.emp.getLastName()
                    .equalsIgnoreCase(name)) {
                return dList.indexOf(d);
            }
        }
        return -1;
    }

    public int checkSsn(String ssn) {
        for (Department d : dList) {
            if (d.emp.getSsn().equalsIgnoreCase(ssn)) {
                return dList.indexOf(d);
            }
        }
        return -1;
    }

    public void addEmployee() {
        String ssn, firstName, lastName, birthDate, phone, email, departmentName = null;
        int pos;
        do {
            ssn = Validation.getString("Enter SSN: ", "Non-Empty");
            pos = checkSsn(ssn);
            if (pos != -1) {
                System.out.println("SSN is duplicate");
            }
        } while (pos != -1);
        firstName = Validation.getString("Input First Name: ", "Non-empty");
        lastName = Validation.getString("Input Last Name: ", "Non-empty");
        birthDate = Validation.getBirthDate("Input BirthDate: ", "Non-empty");
        phone = Validation.getPhone("Input Phone Number: ", "Non-empty");
        email = Validation.getEmail("Input Email: ", "Non-empty");
        int choose;
        do {
            System.out.print("Department: (1-Marketing, 2-IT, 3-HR): ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    departmentName = "Marketing";
                    break;
                case 2:
                    departmentName = "IT";
                    break;
                case 3:
                    departmentName = "HR";
                    break;
            }
        } while (choose < 0 || choose > 3);

        System.out.println("1. HourlyEmployee");
        System.out.println("2. SalariedEmployee");
        System.out.println("You choice (1 or 2): ");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            double wage = Validation.getDouble("Input wage: ");
            double workingHours = Validation.getDouble("Input Working Hours: ");
            Employee emp = new HourlyEmployee(wage, workingHours, ssn,
                    firstName, lastName, birthDate, phone, email);
            dList.add(new Department(departmentName, emp));
        }

        if (choice == 2) {

            double commissionRate = Validation.getDouble("Input Commission Rate: ");
            double grossSales = Validation.getDouble("Input Gross Sales: ");
            double basicSalary = Validation.getDouble("Input Basic Salary: ");
            Employee emp = new SalariedEmployee(commissionRate, grossSales,
                    basicSalary, ssn, firstName, lastName, birthDate, phone, email);
            dList.add(new Department(departmentName, emp));

        }
        System.out.println("Added New Employee");

    }

    public void sortAscendingSsn() {
        Collections.sort(dList, new Comparator<Department>() {
            @Override
            public int compare(Department d1, Department d2) {
                return d1.emp.getSsn().compareToIgnoreCase(d2.emp.getSsn());
            }
        });
        displayAll();
    }

    public void sortAscendingName() {
        Collections.sort(dList, new Comparator<Department>() {
            @Override
            public int compare(Department d1, Department d2) {
                return d1.emp.getLastName().compareToIgnoreCase(d2.emp.getLastName());
            }
        });
        displayAll();

    }

    public void displayAll() {
        if (dList.isEmpty()) {
            System.out.println("Non-Empty");
        }
        for (Department d : dList) {
            System.out.println(d);

        }
    }

    public void searchByName() {
        String name = Validation.getString("Input Name: ", "Non-empty");
        int pos = checkName(name);
        if (pos >= 0) {
            for (Department d : dList) {
                if (d.emp.getFirstName().equalsIgnoreCase(name)
                        || d.emp.getLastName().equalsIgnoreCase(name)) {
                    System.out.println(d);
                }
            }
        } else {
            System.out.println("Non-exist employee");
        }
    }

    public void searchByDepartment() {
        String dpm = Validation.getString("Input Department: ", "Non-empty");
        int pos = checkDP(dpm);
        if (pos >= 0) {
            for (Department d : dList) {
                if (d.getDepartmentName().equalsIgnoreCase(dpm)) {
                    System.out.println(d);
                }
            }
        } else {
            System.out.println("Non-exist department");

        }
    }

    public void deleteEmployee() {
        String delete = Validation.getString("Input SSN: ", "Non-empty");
        int pos = checkSsn(delete);
        if (pos >= 0) {
            dList.remove(pos);
            System.out.println("Deleted");
        } else {
            System.out.println("Not found Employee");
        }
    }

    public void updateEmployee() {

        Scanner sc = new Scanner(System.in);
        String firstName, lastName, birthDate, phone, email, departmentName = null;
        String ssn = Validation.getString("Enter SSN: ", "Non-empty");
        int pos = checkSsn(ssn);
        System.out.println(pos);
        if (pos >= 0) {
            dList.remove(pos);
            firstName = Validation.getString("Input First Name: ", "Non-empty");
            lastName = Validation.getString("Input Last Name: ", "Non-empty");
            birthDate = Validation.getBirthDate("Input BirthDate: ", "Non-empty");
            phone = Validation.getPhone("Input Phone Number: ", "Non-empty");
            email = Validation.getEmail("Input Email: ", "Non-empty");
            int choose;
            do {
                System.out.print("Department: (1-Marketing, 2-IT, 3-HR): ");
                choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        departmentName = "Marketing";
                        break;
                    case 2:
                        departmentName = "IT";
                        break;
                    case 3:
                        departmentName = "HR";
                        break;
                }
            } while (choose < 0 || choose > 3);

            System.out.println("1. HourlyEmployee");
            System.out.println("2. SalariedEmployee");
            System.out.println("You choice (1 or 2): ");
            int choice;
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                double wage = Validation.getDouble("Input wage: ");
                double workingHours = Validation.getDouble("Input Working Hours: ");
                Employee emp = new HourlyEmployee(wage, workingHours, firstName,
                        lastName, ssn, birthDate, phone, email);
                dList.add(pos, new Department(departmentName, emp));
            }

            if (choice == 2) {
                double commissionRate = Validation.getDouble("Input Commission Rate: ");
                double grossSales = Validation.getDouble("Input Gross Sales: ");
                double basicSalary = Validation.getDouble("Input Basic Salary: ");
                Employee emp = new SalariedEmployee(commissionRate, grossSales,
                        basicSalary, ssn, firstName, lastName, birthDate, phone, email);
                dList.add(pos, new Department(departmentName, emp));
            }
            System.out.println("Updated");
        } else {
            System.out.println("Not found SSN");

        }
    }

    public void classify() {
        System.out.println("Marketing");
        for (Department d : dList) {
            if (d.getDepartmentName().equals("Marketing")) {
                System.out.println(d);
            }
        }
        System.out.println();
        System.out.println("IT");
        for (Department d : dList) {
            if (d.getDepartmentName().equals("IT")) {
                System.out.println(d);
            }
        }
        System.out.println();
        System.out.println("HR");
        for (Department d : dList) {
            if (d.getDepartmentName().equals("HR")) {
                System.out.println(d);
            }
        }
    }

    public void report() {
        int count1 = 0, count2 = 0, count3 = 0;
        System.out.println("Marketing");
        for (Department d : dList) {
            if (d.getDepartmentName().equals("Marketing")) {
                System.out.println(d);
                count1++;
            }

        }
        System.out.println();
        System.out.println("IT");
        for (Department d : dList) {
            if (d.getDepartmentName().equals("IT")) {
                System.out.println(d);
                count2++;
            }
        }
        System.out.println();
        System.out.println("HR");
        for (Department d : dList) {
            if (d.getDepartmentName().equals("HR")) {
                System.out.println(d);
                count3++;
            }
        }
        System.out.println("Department Marketing have " + count1 + " employees.");
        System.out.println("Department IT have " + count2 + " employees.");
        System.out.println("Department HR have " + count3 + " employees.");
    }

    public void loadFromFile(String fName) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fName, "r");

        String details, type, ssn, firstName, lastName, birthDate, phone, email, dpName;
        double workinghours, wage, commisionRate, grossSale, basicSalary;
        StringTokenizer stk;
        while (true) {
            details = f.readLine();
            if (details == null) {
                break;
            }
            stk = new StringTokenizer(details, "|");
            type = stk.nextToken().trim();
            if (type.equalsIgnoreCase("Hourly")) {
                ssn = stk.nextToken().trim();
                firstName = stk.nextToken().trim();
                lastName = stk.nextToken().trim();
                birthDate = stk.nextToken().trim();
                phone = stk.nextToken().trim();
                email = stk.nextToken().trim();

                workinghours = Double.parseDouble(stk.nextToken().trim());
                wage = Double.parseDouble(stk.nextToken().trim());
                dpName = stk.nextToken().trim();

                Employee emp = new HourlyEmployee(wage, workinghours, ssn,
                        firstName, lastName, birthDate, phone, email);
                dList.add(new Department(dpName, emp));
            } else {
                ssn = stk.nextToken().trim();
                firstName = stk.nextToken().trim();
                lastName = stk.nextToken().trim();
                birthDate = stk.nextToken().trim();
                phone = stk.nextToken().trim();
                email = stk.nextToken().trim();

                commisionRate = Double.parseDouble(stk.nextToken().trim());
                grossSale = Double.parseDouble(stk.nextToken().trim());
                basicSalary = Double.parseDouble(stk.nextToken().trim());
                dpName = stk.nextToken().trim();

                Employee emp = new SalariedEmployee(commisionRate, grossSale,
                        basicSalary, ssn, firstName, lastName, birthDate, phone, email);
                dList.add(new Department(dpName, emp));
            }
        }
        f.close();
        System.out.println("Load data from file " + fName + " successfully...");

    }

}
