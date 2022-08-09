/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.adam.fudala.tvprog.model;
import pl.polsl.adam.fudala.tvprog.exceptions.TVException;
import java.time.DayOfWeek;

/**
 * Class represents time of the week when the program is shown
 * @author Adam Fudala
 * @version 1.0
 */
public class Time {
    /**hour of the show*/
    private int hour;
    /**minute of the show*/
    private int minute;
    /**day of the show*/
    private DayOfWeek day;
    
    /**
     * day of week getter 
     * @return day of week of the show
     */
    public String getDayOfWeek() {
        return day.toString();
    }

     /**
     * sets day of week when the program is shown and checks if it is correct
     * @param dayOfWeek day of week when the program is shown
     */
    public void setDayOfWeek(String dayOfWeek) 
    {
       day = DayOfWeek.valueOf(dayOfWeek);
    }

    

    /**
     * hour getter
     * @return hour of the show
     */
    public int getHour() {
        return hour;
    }

    /**
     * minute getter
     * @return minute of the show
     */
    public int getMinute() {
        return minute;
    }

    

    /**
     * sets hour when the program is shown and checks if it is correct
     * @param hour hour when the program is shown
     */
    public void setHour(int hour) throws TVException{
        if(hour>=24||hour<0){
            throw new TVException("Incorrect hour");
        }
        else{
        this.hour = hour; 
        }
    }
    

    /**
     * sets minute when the program is shown
     * @param minute minute when the program is shown
     */
    public void setMinute(int minute) throws TVException{
        if(minute>=60||hour<0){
            throw new TVException("Incorrect minute");
        }
        else{
            this.minute = minute;
        }
    }
    /**
     * Constructor
     */
    public Time()
    {
                
    }

    
    
}
