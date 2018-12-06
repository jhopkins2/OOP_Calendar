/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonthlyCalendarPackage;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import CalendarPackage.Calendars;
import javax.swing.border.EtchedBorder;
/**
 *
 * @author jacob
 */
public class MonthlyCalendar extends JFrame implements ActionListener, Calendars{
	public MonthlyCalendar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
    
    //Declaring variables:

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private JLabel monthLabel;
    private JButton addEvent;
    private JPanel panel;
    private Calendar calendar;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private int month;
    private int year;

    @Override
    public void makeCalendar() {

        //Setting frame:

        setTitle("Calendar");
        setSize(800,425);
       
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Setting month label:

        monthLabel = new JLabel();
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //Setting buttons:

        addEvent = new JButton("Add Event");
        //Setting panel:

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(monthLabel, BorderLayout.CENTER);
        panel.add(addEvent, BorderLayout.SOUTH);
        //Setting Calendar to table:

        String days[] = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};

        calendar = new GregorianCalendar();

        model = new DefaultTableModel(null, days) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 2L;

			@Override
            public boolean isCellEditable(int row, int column) {  //Setting the table not editable and not selectable
                table.setFocusable(true);
                table.setRowSelectionAllowed(true);
                return false;
            }
        };

        table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);
        table.setColumnSelectionAllowed(true);
        table.setRowHeight(50);
        table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(table);

        getContentPane().add(panel,BorderLayout.NORTH); 
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        //Adding ActionListener to buttons:

        addEvent.addActionListener(this);
        //Initializing the month:

        update();

        setVisible(true);
		

    }// End of Constructor

    //Updating month:
    
    private void update() {

        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
        int year = calendar.get(Calendar.YEAR);
        monthLabel.setText(month + " " + year);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int numberDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weeks = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);

        model.setRowCount(0);
        model.setRowCount(weeks);

        int i = startDay - 1;
        for(int j = 1; j <= numberDays; j++) {
            model.setValueAt(j, i/7, i%7);
            i++;
        }
    }// End of method updateMonth

    //Setting ActionLister to change the months:

    @Override
    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == addEvent ){
        	String[] args = {};
			NewEvent.createNewEventForm(args);
        }
    } 
    
       
}
