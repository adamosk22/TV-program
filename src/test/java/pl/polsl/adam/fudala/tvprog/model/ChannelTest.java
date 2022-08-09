/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.adam.fudala.tvprog.model;

import pl.polsl.adam.fudala.tvprog.exceptions.TVException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Class is used for testing methods in model
 *
 * @author Adam Fudala
 * @version 1.0
 */
public class ChannelTest {

    /**
     * Test of addProgram method, of class Channel with correct arguments
     *
     * @param programName name of the program
     * @param dayOfWeek day of the program
     * @param hour hour of the program
     * @param minute minute of the program
     */
    @ParameterizedTest
    @CsvSource({"test,MONDAY,10,10", "abc,FRIDAY,12,30", "ab cd,TUESDAY,0,0", ",WEDNESDAY,0,0"})
    public void testAddProgram(String programName, String dayOfWeek, int hour, int minute) {
        //given
        Channel instance = new Channel();
        //when
        instance.addProgram(programName, dayOfWeek, hour, minute);
        List<Program> programList = instance.getProgramList();
        Program program = programList.get(0);
        Time time = program.getTime();
        //then
        assertEquals(programName, program.getName(), "Names are not identical!");
        assertEquals(dayOfWeek, time.getDayOfWeek(), "Days are not identical!");
        assertEquals(hour, time.getHour(), "Hours are not identical!");
        assertEquals(minute, time.getMinute(), "Minutes are not identical!");

    }

    /**
     * Test of findProgramByName, of Class Channel with correct arguments
     *
     * @param programName name of the program
     */
    @ParameterizedTest
    @ValueSource(strings = {"", "abc", "sds"})
    public void testFindProgramByName(String programName) {
        //given
        Channel instance = new Channel();
        instance.addProgram(programName, "MONDAY", 0, 0);
        //when
        Program program = instance.findProgramByName(programName);
        //then
        assertEquals(programName, program.getName(), "Names are not identical!");
    }

    /**
     * Test of findProgramByTime method, of class Channel with correct arguments
     *
     * @param dayOfWeek day of the program
     * @param hour hour of the program
     * @param minute minute of the program
     */
    @ParameterizedTest
    @CsvSource({"MONDAY,10,10", "FRIDAY,12,30", "TUESDAY,0,0"})
    public void testFindProgramByTime(String dayOfWeek, int hour, int minute) {
        //given
        Channel instance = new Channel();
        instance.addProgram("abc", dayOfWeek, hour, minute);
        //when
        Program program = instance.findProgramByTime(dayOfWeek, hour, minute);
        Time time = program.getTime();
        //then
        assertEquals(dayOfWeek, time.getDayOfWeek(), "Days are not identical!");
        assertEquals(hour, time.getHour(), "Hours are not identical!");
        assertEquals(minute, time.getMinute(), "Minutes are not identical!");

    }

    /**
     * Test of deleteProgram method, of class Channel with correct arguments
     *
     * @param programName name of the program
     */
    @ParameterizedTest
    @ValueSource(strings = {"abc", "sds", ""})
    public void testDeleteProgram(String programName) {
        //given
        Channel instance = new Channel();
        instance.addProgram(programName, "MONDAY", 10, 10);
        //when
        instance.deleteProgram(programName);
        List<Program> programList = instance.getProgramList();
        //then
        assertTrue(programList.isEmpty(), "Program was not deleted");

    }

    /**
     * Test of rateProgram method, of class Channel
     * @param programName name of the program
     * @param rating rating of the program
     */
    @ParameterizedTest
    @CsvSource({"abc,GOOD", "test,BAD", "aa,NEUTRAL"})
    public void testRateProgram(String programName, String rating) {
        //given
        Channel instance = new Channel();
        instance.addProgram(programName, "MONDAY", 0, 0);
        //when
        instance.rateProgram(programName, rating);
        Program program = instance.findProgramByName(programName);
        //then
        assertEquals(Program.Rating.valueOf(rating), program.getRating(), "Ratings are not identical");

    }
    
    /**
     * Test of editProgram method, of class Channel
     * 
     * @param programName name of the program
     * @param dayOfWeek day of the program
     * @param hour hour of the program
     * @param minute minute of the program
     */
    @ParameterizedTest
    @CsvSource({"test,TUESDAY,10,10", "abc,FRIDAY,12,30", "ab cd,MONDAY,0,0"})
    public void testEditProgram(String programName, String dayOfWeek, int hour, int minute) {
        //given
        Channel instance = new Channel();
        //when
        instance.addProgram(programName, "MONDAY", 0, 0);
        instance.editProgram(programName, dayOfWeek, hour, minute);
        List<Program> programList = instance.getProgramList();
        Program program = programList.get(0);
        Time time = program.getTime();
        //then
        assertEquals(programName, program.getName(), "Names are not identical!");
        assertEquals(dayOfWeek, time.getDayOfWeek(), "Days are not identical!");
        assertEquals(hour, time.getHour(), "Hours are not identical!");
        assertEquals(minute, time.getMinute(), "Minutes are not identical!");

    }

    /**
     * Test of addProgram method, of class Channel with correct arguments
     *
     * @param programName name of the program
     * @param dayOfWeek day of the program
     * @param hour hour of the program
     * @param minute minute of the program
     */
    @ParameterizedTest
    @CsvSource({"abc,FRIDAY,40,30", "ab cd,TUESDAY,0,100", ",WEDNESDAY,-2,0,", "test,THURSDAY,24,60", "sdjh,,11,38"})
    public void testAddProgramIncorrect(String programName, String dayOfWeek, int hour, int minute) {
        //given
        Channel instance = new Channel();
        //when
        try {
            instance.addProgram(programName, dayOfWeek, hour, minute);
            //then
            fail("An exception should be thrown");
        } catch (TVException err) {
            List<Program> programList = instance.getProgramList();
            assertTrue(programList.isEmpty(), "Incorrect element was added");
            assertTrue(err.getMessage().contains("Incorrect"), "Unexpected message");

        } catch (IllegalArgumentException err) {
            List<Program> programList = instance.getProgramList();
            assertTrue(programList.isEmpty(), "Incorrect element was added");
            assertTrue(err.getMessage().contains("No enum constant"), "Unexpected message");
        } catch (NullPointerException err) {
            List<Program> programList = instance.getProgramList();
            assertTrue(programList.isEmpty(), "Incorrect element was added");
            assertTrue(err.getMessage().contains("Name is null"), "Unexpected message");
        }

    }

    /**
     * Test of findProgramByName, of Class Channel with incorrect arguments
     *
     * @param addedProgramName name of the added program
     * @param searchedProgramName name of the nonexistent searched program
     */
    @ParameterizedTest
    @CsvSource({"abc,abcd", ",abc", "a,abc", "a,", ",a"})
    public void testFindProgramByNameIncorrect(String addedProgramName, String searchedProgramName) {
        //given
        Channel instance = new Channel();
        instance.addProgram(addedProgramName, "MONDAY", 0, 0);
        //when
        Program program = instance.findProgramByName(searchedProgramName);
        //then
        assertEquals(program, null, "A program is found based on incorrect parameters!");
    }

    /**
     * Test of findProgramByTime method, of class Channel with incorrect
     * arguments
     *
     * @param addedDayOfWeek day of the added program
     * @param addedHour hour of the added program
     * @param addedMinute minute of the added program
     * @param searchedDayOfWeek searched day of week that doesn't match the
     * program
     * @param searchedHour searched hour that doesn't match the program
     * @param searchedMinute searched minute
     */
    @ParameterizedTest
    @CsvSource({"MONDAY,10,10,TUESDAY,10,10", "FRIDAY,12,30,FRIDAY,13,30", "TUESDAY,0,0,TUESDAY,0,1", "WEDNESDAY,11,45,asdsd,11,45", "THURSDAY,19,25,thursday,19,25"})
    public void testFindProgramByTimeIncorrect(String addedDayOfWeek, int addedHour, int addedMinute, String searchedDayOfWeek, int searchedHour, int searchedMinute) {
        //given
        Channel instance = new Channel();
        instance.addProgram("abc", addedDayOfWeek, addedHour, addedMinute);
        //when
        Program program = instance.findProgramByTime(searchedDayOfWeek, searchedHour, searchedMinute);
        //then
        assertEquals(program, null, "A program is found based on incorrect parameters!");

    }

    /**
     * Test of findProgramByTime method, of class Channel with null argument
     * causing exception
     *
     * @param addedDayOfWeek day of the added program
     * @param addedHour hour of the added program
     * @param addedMinute minute of the added program
     * @param searchedDayOfWeek searched day of week that doesn't match the
     * program
     * @param searchedHour searched hour that doesn't match the program
     * @param searchedMinute searched minute
     */
    @ParameterizedTest
    @CsvSource({"FRIDAY,21,15,,21,15"})
    public void testFindProgramByTimeNullPointerException(String addedDayOfWeek, int addedHour, int addedMinute, String searchedDayOfWeek, int searchedHour, int searchedMinute) {
        //given
        Channel instance = new Channel();
        instance.addProgram("abc", addedDayOfWeek, addedHour, addedMinute);
        //when
        try {
            instance.findProgramByTime(searchedDayOfWeek, searchedHour, searchedMinute);
            //then
            fail("Exception should be thrown");
        } catch (NullPointerException err) {

        }

    }

    /**
     * Test of deleteProgram method, of class Channel with incorrect arguments
     *
     * @param addedProgramName name of the added program
     * @param deletedProgramName name of nonexistent program to delete
     */
    @ParameterizedTest
    @CsvSource({"abc,abcd", ",abc", "a,abc"})
    public void testDeleteProgramIncorrect(String addedProgramName, String deletedProgramName) {
        //given
        Channel instance = new Channel();
        instance.addProgram(addedProgramName, "MONDAY", 10, 10);
        //when
        instance.deleteProgram(deletedProgramName);
        List<Program> programList = instance.getProgramList();
        //then
        assertEquals(programList.get(0).getName(), addedProgramName, "Program was deleted based on incorrect parameters");

    }

    /**
     * Test of rateProgram method, of class Channel with incorrect ratings
     *
     * @param programName name of the program
     * @param rating rating of the program that doesn,t match the enum type
     */
    @ParameterizedTest
    @CsvSource({"abc,bsd", "test,bad", "aa,", "sas,BAd"})
    public void testRateProgramIncorrectRating(String programName, String rating) {
        //given
        Channel instance = new Channel();
        instance.addProgram(programName, "MONDAY", 0, 0);
        //when
        try {
            instance.rateProgram(programName, rating);

            //then
            fail("Exception should be thrown");
        } catch (IllegalArgumentException err) {
            Program program = instance.findProgramByName(programName);
            assertEquals(program.getRating(), Program.Rating.UNRATED, "Rating was changed based on incorrect arguments");
            assertTrue(err.getMessage().contains("No enum constant"), "Unexpected message");
        } catch (NullPointerException err) {
            Program program = instance.findProgramByName(programName);
            assertEquals(program.getRating(), Program.Rating.UNRATED, "Rating was changed based on incorrect arguments");
            assertTrue(err.getMessage().contains("Name is null"), "Unexpected message");
        }

    }

    /**
     * Test of rateProgram method, from class Channel with names that don't
     * match available programs
     *
     * @param addedProgramName name of the added program
     * @param ratedProgramName name of nonexistent program to rate
     * @param rating rating of the program
     */
    @ParameterizedTest
    @CsvSource({"abc,abd,BAD", ",abc,GOOD", "abc,ab,NEUTRAL", ",ab,GOOD", "ab,,BAD"})
    public void testRateProgramIncorrectName(String addedProgramName, String ratedProgramName, String rating) {
        //given
        Channel instance = new Channel();
        if (ratedProgramName == null) {
            instance.getName();
        }
        instance.addProgram(addedProgramName, "MONDAY", 0, 0);
        //when
        instance.rateProgram(ratedProgramName, rating);
        Program program = instance.findProgramByName(ratedProgramName);
        //then
        assertEquals(program, null, "Rating was changed based on incorrect arguments");

    }
    
    /**
     * Test of editProgram method, of class Channel incorrect values
     * 
     * @param programName name of the program
     * @param dayOfWeek day of the program
     * @param hour hour of the program
     * @param minute minute of the program
     */
    @ParameterizedTest
    @CsvSource({"test,abcd,10,10", "abc,FRIDAY,45,30", "ab cd,MONDAY,0,99"})
    public void testEditProgramIncorrect(String programName, String dayOfWeek, int hour, int minute) {
        //given
        Channel instance = new Channel();
        //when
        instance.addProgram(programName, "MONDAY", 0, 0);
        try{
        instance.editProgram(programName, dayOfWeek, hour, minute);
        //then
        fail("Exception should be thrown");
        }catch (TVException err) {
            List<Program> programList = instance.getProgramList();
            Program program = programList.get(0);
            Time time = program.getTime();
            assertEquals("MONDAY",time.getDayOfWeek(), "Incorrect edition was made");
            assertEquals(0,time.getHour(),"Incorrect edition was made");
            assertEquals(0,time.getMinute(),"Incorrect edition was made");
            assertTrue(err.getMessage().contains("Incorrect"), "Unexpected message");

        } catch (IllegalArgumentException err) {
            List<Program> programList = instance.getProgramList();
            Program program = programList.get(0);
            Time time = program.getTime();
            assertEquals("MONDAY",time.getDayOfWeek(), "Incorrect edition was made");
            assertEquals(0,time.getHour(),"Incorrect edition was made");
            assertEquals(0,time.getMinute(),"Incorrect edition was made");
            assertTrue(err.getMessage().contains("No enum constant"), "Unexpected message");
        } catch (NullPointerException err) {
            List<Program> programList = instance.getProgramList();
            Program program = programList.get(0);
            Time time = program.getTime();
            assertEquals("MONDAY",time.getDayOfWeek(), "Incorrect edition was made");
            assertEquals(0,time.getHour(),"Incorrect edition was made");
            assertEquals(0,time.getMinute(),"Incorrect edition was made");
            assertTrue(err.getMessage().contains("Name is null"), "Unexpected message");
        }
        

    }
    
    /**
     * Test of editProgram method, of class Channel incorrect names
     * @param addedProgramName name of program added to list
     * @param newProgramName name of nonexistent rated program
     * @param dayOfWeek new day
     * @param hour new hour
     * @param minute new minute
     */
    @ParameterizedTest
    @CsvSource({"abc,abd,MONDAY,5,30", ",abc,TUESDAY,7,20", "abc,ab,WEDNESDAY,19,45", ",ab,SUNDAY,17,22", "ab,,FRIDAY,23,59"})
    public void testEditProgramIncorrctName(String addedProgramName, String newProgramName, String dayOfWeek, int hour, int minute){
        //given
        Channel instance = new Channel();
        //when
        instance.addProgram(addedProgramName, "MONDAY", 0, 0);
        instance.editProgram(newProgramName, dayOfWeek, hour, minute);
        Program program = instance.findProgramByName(newProgramName);
        //then
        assertEquals(program, null, "Program was modified based on incorrect arguments");
        
    }
    
    
    
    

}
