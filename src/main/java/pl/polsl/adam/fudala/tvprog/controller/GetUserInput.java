/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.adam.fudala.tvprog.controller;

import java.util.Scanner;

/**
 * Class contains methods that obtain specified data from user
 * @author Adam Fudala
 * @version 1.0
 */
public class GetUserInput {
    /**
     * Method ask user a specified question and return user's answear as String
     * @param question question about needed parameter
     * @return parameter obtained from user
     */
    public String getStringFromUser(String question)
    {
        System.out.println(question);//asking user about day
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (input.isEmpty())
        {
            System.out.println("You have to " + question);
            input = scan.nextLine();
        }
        return input;
    }
    /**
     * Method ask user a specified question and return user's answear as int
     * @param question question about needed parameter
     * @return parameter obtained from user
     */
    public int getIntFromUser(String question)
    {
        int input=-1;
        Scanner scan = new Scanner(System.in);
        System.out.println(question);//asking user about day
        input = scan.nextInt();
        if (input<0)
        {
            System.out.println("You have to " + question);
            input = scan.nextInt();
        }
        return input;
    }
}
