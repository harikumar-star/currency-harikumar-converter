package com.crud.PasswrdChange;

import java.util.Scanner;

public class PassChangeMain {

    private static String currentPassword = "admin123"; // initial password
    public static void main(String[] args) {
        System.out.println("Password Change Starts");


        Scanner sc = new Scanner(System.in);

        System.out.print("Enter old password: ");
        String oldPassword = sc.nextLine();

        if (!oldPassword.equals(currentPassword)) {
            System.out.println("❌ Incorrect old password. Password change failed.");
            return;
        }
        System.out.println("Enter New Pass");
        String newPass = sc.next();

        System.out.println("Confirm Pass");
        String confirmPass = sc.next();

        System.out.print("Enter new password: ");
        String newPassword = sc.nextLine();

        System.out.print("Confirm new password: ");
        String confirmPassword = sc.nextLine();

        if (!newPassword.equals(confirmPassword)) {
            System.out.println("❌ New passwords do not match. Try again.");
        } else if (newPassword.length() < 6) {
            System.out.println("❌ Password must be at least 6 characters long.");
        } else {
            currentPassword = newPassword;
            System.out.println("✅ Password changed successfully!");
        }

        sc.close();





    }
}
