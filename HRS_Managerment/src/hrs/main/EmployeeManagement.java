/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.main;

import hrs.services.EmployeeService;
import java.util.Scanner;

/**
 *
 * @author baoduong
 */
public class EmployeeManagement {
    public static void main(String[] args) {
        int choice;

        Scanner sc = new Scanner(System.in);
        EmployeeService pList = new EmployeeService();
        try {
            pList.loadFromFile("data.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
        do {

            System.out.println("====== EMPLOYEE MANAGEMENT SYSTEM ======");
            System.out.println("1. Add an employee");
            System.out.println("2. Display employees (order by SSN or Name)");
            System.out.println("3. Classify employees");
            System.out.println("4. Search employee by (department, emp's name)");
            System.out.println("5. Update an employee");
            System.out.println("6. Delete an employee");
            System.out.println("7. Report");
            System.out.println("0. Quit");
            System.out.print("Please choose function you'd like to do: ");
            choice = sc.nextInt();

            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    pList.addEmployee();
                    break;

                case 2:
                    int choosee;
                    System.out.println("1. Order by Name");
                    System.out.println("2. Oder by SSN");
                    System.out.println("Your choose: ");
                    choosee = sc.nextInt();
                    switch (choosee) {
                        case 1:
                            pList.sortAscendingName();
                            break;
                        case 2:
                            pList.sortAscendingSsn();
                            break;
                    }
                    break;
                case 3:
                    pList.classify();
                    break;

                case 4:
                    int choose;
                    System.out.println("1. Search employee by Department");
                    System.out.println("2. Search employee by Name");
                    System.out.println("Your choose: ");
                    choose = sc.nextInt();
                    switch (choose) {
                        case 1:
                            pList.searchByDepartment();
                            break;
                        case 2:
                            pList.searchByName();
                            break;
                    }
                    break;
                case 5:
                    pList.updateEmployee();
                    break;
                case 6:
                    pList.deleteEmployee();
                    break;
                case 7:
                    pList.report();
                    break;
            }

        } while (true);
    }

}
