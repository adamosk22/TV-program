/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.adam.fudala.tvprog.controller;

import java.util.List;
import pl.polsl.adam.fudala.tvprog.model.Channel;
import java.util.Scanner;
import pl.polsl.adam.fudala.tvprog.model.Program;
import pl.polsl.adam.fudala.tvprog.view.Show;
import pl.polsl.adam.fudala.tvprog.exceptions.TVException;
import javax.swing.*;
import pl.polsl.adam.fudala.tvprog.view.GraphicalDisplay;

/**
 * Main class
 *
 * @author Adam Fudala
 * @version 2.0
 */
public class Main {

    /**
     * Main method
     *
     * @param args args[0] input file name (an example file named programs.txt
     * can be found in folder tvprog)
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String fileName;
        Channel channel = new Channel();
        if (args.length > 0) {
            fileName = args[0];
        } else {
            //System.out.println("You didn't' provide file path. Enter file path");
            //fileName = scan.nextLine();
            fileName = "C:\\Users\\aadam\\Documents\\JWIUM\\Projekt\\tvprog\\programs.txt";

        }
        ReadFromFile reader = new ReadFromFile();
        Show show = new Show();
        reader.read(fileName, channel);
        int choice = show.menu();
        GetUserInput input = new GetUserInput();
        String programName, dayOfWeek, rating;
        int minute, hour;
        Program program;
        
        
        
        
        while (choice != 0) {
            switch (choice) {
                case 1:
                    programName = input.getStringFromUser("enter name:");
                    dayOfWeek = input.getStringFromUser("enter day of week(all caps):");
                    hour = input.getIntFromUser("enter hour:");
                    minute = input.getIntFromUser("enter minute");
                    try {
                        channel.addProgram(programName, dayOfWeek, hour, minute);
                    } catch (TVException err) {
                        System.err.println(err.getMessage());
                    } catch (IllegalArgumentException err) {
                        System.err.println(err.getMessage());
                    }
                    break;
                case 2:
                    programName = input.getStringFromUser("enter name:");
                    channel.deleteProgram(programName);
                    break;
                case 3:
                    dayOfWeek = input.getStringFromUser("enter day of week(all caps):");
                    hour = input.getIntFromUser("enter hour:");
                    minute = input.getIntFromUser("enter minute");
                    program = channel.findProgramByTime(dayOfWeek, hour, minute);
                    break;
                case 4:
                    programName = input.getStringFromUser("enter name:");
                    program = channel.findProgramByName(programName);
                    break;
                case 5:
                    List<Program> programList = channel.getProgramList();
                    show.showAll(programList);
                    break;
                case 6:
                    programName = input.getStringFromUser("enter name:");
                    System.out.println("Possible rating: GOOD,NEUTRAL,BAD");
                    rating = input.getStringFromUser("enter rating:");
                    try {
                        channel.rateProgram(programName, rating);
                    } catch (IllegalArgumentException err) {
                        System.err.println(err.getMessage());
                    } catch (NullPointerException err) {
                        System.err.println(err.getMessage());
                    }

                    break;
                case 7:
                    System.out.println("Possible rating: GOOD,NEUTRAL,BAD");
                    rating = input.getStringFromUser("enter rating:");
                    show.showAllWithRate(channel, rating);
                case 8:
                    /*String oldProgramName = input.getStringFromUser("enter name:");
                    programName = input.getStringFromUser("enter new name:");
                    dayOfWeek = input.getStringFromUser("enter new day of week(all caps):");
                    hour = input.getIntFromUser("enter new hour:");
                    minute = input.getIntFromUser("enter new minute");
                    try{
                        channel.editProgram(programName, programName, dayOfWeek, hour, minute);
                    }
                    catch(TVException err){
                        System.err.println(err.getMessage());
                    }*/

            }
            choice = show.menu();
        }

    }
    
        
    

}
