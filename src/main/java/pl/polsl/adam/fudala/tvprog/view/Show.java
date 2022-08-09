/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.adam.fudala.tvprog.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import pl.polsl.adam.fudala.tvprog.model.Channel;
import pl.polsl.adam.fudala.tvprog.model.Program;
import pl.polsl.adam.fudala.tvprog.model.Time;
import static pl.polsl.adam.fudala.tvprog.model.Program.Rating.*;

/**
 * Class displays a program and the time when it is displayed
 *
 * @author Adam Fudala
 * @version 2.0
 */
public class Show {

    /**
     * Method shows program's name and time
     *
     * @param program program that is displayed
     */
    public void show(Program program) {
        Time time = program.getTime();
        System.out.println(program.getName() + " " + time.getDayOfWeek() + " " + time.getHour() + ":" + time.getMinute());//display of the program name and time
        if (program.getRating() != UNRATED) {
            System.out.println(program.getName() + " was rated " + program.getRating());
        }

    }

    /**
     * Method displays all available programs from channel
     *
     * @param programList list of programs
     */
    public void showAll(List<Program> programList) {
        for (Program program : programList) {
            show(program);
        }
    }

    /**
     * Method displays shows with given rate
     *
     * @param channel channel that contains the program
     * @param rate searched rate
     */
    public void showAllWithRate(Channel channel, String rate) {
        List<Program> programList = channel.getProgramList();
        List<Program> filtered = programList
                .stream()
                .filter(p -> (p.getRating() == Program.Rating.valueOf(rate)))
                .collect(Collectors.toList());
        showAll(filtered);

    }

    /**
     * Method shows menu and returns user's choice
     *
     * @return number of user's choice
     */
    public int menu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Add program");
        System.out.println("     2. Delete program");
        System.out.println("     3. Search by time");
        System.out.println("     4. Search by name");
        System.out.println("     5. Show all programs");
        System.out.println("     6. Rate program");
        System.out.println("     7. Filter programs by rating");
        System.out.println("     0. Exit");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }

    /**
     * Constructor
     */
    public Show() {
    }

}
