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
    public Calendars getCalendar(String s){
        if(s == null){
            return null;
        }        
        if(s.equals("Monthly")){
            return new MonthlyCalendar();
        }
                    
        return null;
    }
}
