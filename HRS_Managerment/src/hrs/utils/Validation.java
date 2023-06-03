/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.utils;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author baoduong
 */
public class Validation {

    public static double getDouble(String number) {
        double value = 0;
        while (true) {
            try {
                System.out.print(number);
                value = Double.parseDouble(new Scanner(System.in).nextLine());
                if (value < 0) {
                    throw new Exception();
                }
                return value;
            } catch (Exception e) {
                System.out.println("value must not be less than 0!");
            }
        }
    }

    public static String getString(String input, String bug) {
        String inputter;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(input);
                inputter = sc.nextLine().trim();
                if (inputter.length() == 0 || inputter.isEmpty()) {
                    throw new Exception();
                }
                return inputter;
            } catch (Exception e) {
                System.out.println(bug);
            }
        }
    }

    public static boolean checkDate(String birthDate) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);

            df.parse(birthDate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String getBirthDate(String input, String bug) {
        boolean check = true;
        String date;
        do {
            date = getString(input, bug);
            check = checkDate(date);
            if (!check) {
                System.out.println("Your birth date must following form dd/MM/yyyy");
            }
        } while (check == false);
        return date;
    }

    public static boolean checkMail(String email) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static String getEmail(String input, String bug) {
        boolean check = true;
        String email;
        do {
            email = getString(input, bug);
            check = checkMail(email);
            if (!check) {
                System.out.println("Your email format is not accepted");
            }
        } while (check == false);
        return email;
    }

    public static boolean checkPhone(String phone) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[0-9]{7,10}$");
        Matcher matcher = pattern.matcher(phone);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static String getPhone(String input, String bug) {
        boolean check = true;
        String phone;
        do {
            phone = getString(input, bug);
            check = checkPhone(phone);
            if (!check) {
                System.out.println("Your phone format is not accepted");
                check = false;
            }
        } while (check == false);
        return phone;
    }
}
