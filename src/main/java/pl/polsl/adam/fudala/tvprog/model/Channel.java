/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.adam.fudala.tvprog.model;

import java.util.ArrayList;
import java.util.List;
import static pl.polsl.adam.fudala.tvprog.model.Program.Rating.*;
import pl.polsl.adam.fudala.tvprog.view.Show;

/**
 * Class represents a TV channel that contains an array of programs
 *
 * @author Adam Fudala
 * @version 2.0
 */
public class Channel {

    /**
     * Array of programs shown by the channel
     */
    private List<Program> programList;
    /**
     * Name of the channel
     */
    private String name;

    /**
     * programList getter
     *
     * @return vector with list of programs
     */
    public List<Program> getProgramList() {
        return programList;
    }

    /**
     * programList setter
     *
     * @param programList list of all programs in channel
     */
    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }

    /**
     * Channel no argument constructor
     */
    public Channel() {
        programList = new ArrayList<>();
    }

    /**
     * name getter
     *
     * @return name of channel
     */
    public String getName() {
        return name;
    }

    /**
     * name setter
     *
     * @param name name of channel
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method adds new program defined by parameters
     *
     * @param programName name of the program
     * @param dayOfWeek day of the program
     * @param hour hour of the program
     * @param minute minute of the program
     */
    public void addProgram(String programName, String dayOfWeek, int hour, int minute) {
        Program program = new Program();//initiating a program object
        program.setName(programName);
        program.setRating(UNRATED);

        Time showTime = new Time();//creating time object

        showTime.setHour(hour);//checking exception of incorrect hour

        showTime.setMinute(minute);
        showTime.setDayOfWeek(dayOfWeek);

        program.setTime(showTime);//setting the time of the program
        programList.add(program);

    }

    /**
     * Method finds and displays a program with the provided name
     *
     * @param programName name of the program
     * @return found program or null
     */
    public Program findProgramByName(String programName) {
        if (programName != null) {

            for (int i = 0; i < programList.size(); i++)//iteration through programList
            {
                Program program = programList.get(i);//initializing a Program variable
                if (programName.equals(program.getName()))//checking if the name of program is the requested name
                {
                    Show show = new Show();
                    //show.show(programList.get(i));//displaying the program with its time
                    return program;
                }
            }
            //System.out.println("There is no such program");//message if the program is not found
            return null;
        }
        return null;

    }

    /**
     * Method finds and displays a program that is shown at provided time
     *
     * @param dayOfWeek day of the program
     * @param hour hour of the program
     * @param minute minute of the program
     * @return found program or null
     */
    public Program findProgramByTime(String dayOfWeek, int hour, int minute) {

        for (int i = 0; i < programList.size(); i++)//iteration through programList
        {
            Program program = programList.get(i);//initializing a Program variable
            Time time = program.getTime();//intializing a Time variable
            if (dayOfWeek.equals(time.getDayOfWeek()) && hour == time.getHour() && minute == time.getMinute())//checking if day, hour and minute provided by user matches time of the program
            {
                Show show = new Show();
                //show.show(programList.get(i));//displaying the program
                return program;
            }
        }
        //System.out.println("There is no such program");//message if the program is not found
        return null;

    }

    /**
     * Method deletes a given program
     *
     * @param programName name of the program
     */
    public void deleteProgram(String programName) {

        for (int i = 0; i < programList.size(); i++) {
            Program program = programList.get(i);
            if (programName.equals(program.getName()))//checking if name of the program matches provided name
            {
                programList.remove(program);//removing the program from programList
                return;
            }
        }
        System.out.println("There is no such program");
    }

    /**
     * Method edits program's show time
     *
     * @param programName name of the program
     * @param dayOfWeek day of the program
     * @param hour hour of the program
     * @param minute minute of the program
     */
    public void editProgram(String programName, String dayOfWeek, int hour, int minute) {
        Program program = findProgramByName(programName);
        if (program != null) {
            Time time = new Time();
            time.setDayOfWeek(dayOfWeek);
            time.setHour(hour);
            time.setMinute(minute);
            program.setTime(time);
            int index = programList.indexOf(program);
            programList.get(index).setTime(time);
        }
    }

    /**
     * Method sets program's rating based on imput symbol
     *
     * @param programName name of the program
     * @param ratingText symbol entered by user
     */
    public void rateProgram(String programName, String ratingText) {
        Program program = findProgramByName(programName);
        if (program != null) {
            program.setRating(Program.Rating.valueOf(ratingText));
        }

    }

}
