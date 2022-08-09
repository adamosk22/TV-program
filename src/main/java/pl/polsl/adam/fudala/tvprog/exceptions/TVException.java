/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.adam.fudala.tvprog.exceptions;

/**
 * Excerption thrown when hour in Time object doesn't match any real hour of the day
 * @author Adam Fudala
 * @version 1.0
 */
public class TVException
        extends RuntimeException
{

    /**
     * Constructor with one argument
     * @param errorMessage message explaining the error
     */
    public TVException(String errorMessage) {
        super(errorMessage);
     }
}

