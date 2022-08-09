/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.adam.fudala.tvprog.controller;

import pl.polsl.adam.fudala.tvprog.model.Channel;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * Class that reads from input file and creates a vector of Programs
 *
 * @author Adam Fudala
 * @version 2.0
 */
public class ReadFromFile {

    /**
     * Method reads from input file and creates a vector of programs in an
     * object of class Channel
     *
     * @param fileName name of the input file
     * @param channel channel where the programs will be stored
     */
    public void read(String fileName, Channel channel) {
        ArrayList<String> records = new ArrayList<String>();
        boolean found = false;
        String name, day, record;
        int hour, minute;
        try {
            Scanner x;
            x = new Scanner(new File(fileName));
            while (x.hasNextLine()) {
                found = true;
                name = x.nextLine();
                day = x.nextLine();
                hour = Integer.parseInt(x.nextLine());
                minute = Integer.parseInt(x.nextLine());

                channel.addProgram(name, day, hour, minute);

            }
            if (!found) {
                //System.out.println("No records found");
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

    }

    /**
     * Constructor
     */
    public ReadFromFile() {
    }

}
