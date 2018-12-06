/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalendarFactoryPackage;
import CalendarPackage.Calendars;
import MonthlyCalendarPackage.MonthlyCalendar;

/**
 *
 * @author jacob
 */
public class CalendarFactory {
    public CalendarFactory(){
        
    }
    
    public Calendars getCalendar(String s, int m){
       /* if(s == null){
            return null;
        }        
        String sUpper=s.toUpperCase();
        if(sUpper.equals("MONTHLY")){*/
            return new MonthlyCalendar(m);
        //}
                    
        //return null;
    }
}
