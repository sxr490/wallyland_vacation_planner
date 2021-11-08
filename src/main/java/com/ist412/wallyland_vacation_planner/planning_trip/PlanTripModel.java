/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ist412.wallyland_vacation_planner.planning_trip;

import java.util.ArrayList;

/**
 *
 * @author jason
 */
public class PlanTripModel {
    
    private ArrayList<String> freeDates; 
    private ArrayList<String> bookedDates; 
    
    
    
    public PlanTripModel(){
    
    }
    
    public void bookDate(String date, String name)
    {
        boolean remove = false; 
        int index = 0; 
        for(int k = 0; k < freeDates.size(); k++){
            if (freeDates.get(k) == date){
                remove = true; 
                index = k; 
            }
        }
        
        if(remove == true){
            freeDates.remove(index); 
            bookedDates.add(date);
        }
    }
    
    public void cancelTrip(String date, String name)
    {
        boolean remove = false; 
        int index = 0; 
        for(int k = 0; k < freeDates.size(); k++){
            if (freeDates.get(k) == date){
                remove = true; 
                index = k; 
            }
        }
        
        if(remove == true){
            bookedDates.remove(index); 
            freeDates.add(date); 
        }
    }
    
    
    
    
}
