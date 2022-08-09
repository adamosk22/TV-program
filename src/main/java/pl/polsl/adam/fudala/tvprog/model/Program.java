/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.adam.fudala.tvprog.model;

/**
 * Class reppresents a program with time of its emission
 * @author Adam Fudala
 * @version 2.0
 */

public class Program {
    /**name of the program*/
    private String name;
    /**time when the programs starts*/
    private Time time;
    /**
     * Enumeration type for storing program rating
     */
    public enum Rating
    {
        /**positive rating*/
        GOOD,
        /**negative rating*/
        BAD,
        /**neutral rating*/
        NEUTRAL,
        /**default rating*/
        UNRATED;
        
    }
    /** User's rating of the program */
    private Rating rating;
    
    /**
     * Rating getter
     * @return rating
     */
    public Rating getRating() {
        return rating;
    }
    
    /**
     * Rating setter
     * @param rating rating of program 
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }
    
    

    
    

    /**
     * name getter
     * @return name of the program
     */
    public String getName() {
        return name;
    }

    /**
     * name setter
     * @param name name of the program
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * time getter
     * @return time when  the program starts
     */
    public Time getTime() {
        return time;
    }

    /**
     * sets time when the program starts
     * @param time time when the program starts
     */
    public void setTime(Time time) {
        this.time = time;
    }
    /**
     * Constructor
     */
    public Program()
    {
     
    }
    
    
}