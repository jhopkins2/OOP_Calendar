package CalendarMain;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Login.UserInfo;
import Login.UserLogin;
import MonthlyCalendarPackage.MonthlyCalendar;
import MonthlyCalendarPackage.NewEvent;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

public class CalendarMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Calendar calendar;
	private JLabel currentMonth;
	

	/**
	 * Launch the application.
	 */
	public void createCalendarMenu(String[] args) {                    //main call to calendar menu
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarMenu frame = new CalendarMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalendarMenu() {
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeBack = new JLabel("Calendar Schedule Maker");
		lblWelcomeBack.setBounds(39, 24, 207, 30);
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeBack.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		contentPane.add(lblWelcomeBack);
		
		JButton btnNewCalendar = new JButton("New Calendar");
		btnNewCalendar.setBounds(39, 81, 163, 23);
		contentPane.add(btnNewCalendar);
		btnNewCalendar.addActionListener(new ActionListener() {  //if new calendar button press
			@Override
			public void actionPerformed(ActionEvent e) {
				
			} 
		} );
		JButton btnViewUserInformation = new JButton("View User Information");
		btnViewUserInformation.setBounds(39, 115, 163, 23);
		contentPane.add(btnViewUserInformation);
		btnViewUserInformation.addActionListener(new ActionListener() {  //if view user info button press
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] args = {};
				UserInfo.createUserInfoForm(args);
			} 
		} );
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(658, 410, 89, 23);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {  //if log out button press
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] args = {};
				UserLogin.createUserLoginForm(args);
				setVisible(false);
			} 
		} );
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setToolTipText("");
		comboBox.setBounds(39, 174, 163, 23);
		contentPane.add(comboBox);
		//comboBox.addItem(new );
		//comboBox.addItem();
		
		JLabel lblViewSavedCalendars = new JLabel("View Saved Calendars");
		lblViewSavedCalendars.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewSavedCalendars.setBounds(39, 149, 163, 14);
		contentPane.add(lblViewSavedCalendars);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setBounds(95, 206, 46, 14);
		contentPane.add(lblEvents);
		
		
		JButton btnAddEvent = new JButton("Add Event");        
		btnAddEvent.setBounds(70, 410, 98, 23);
		contentPane.add(btnAddEvent);
		btnAddEvent.addActionListener(new ActionListener() {  //if add event is pressed
			@Override
			public void actionPerformed(ActionEvent e) {
	           String[] args = {};
	           NewEvent.createNewEventForm(args);
			} 
		} );
		
		JList<Object> list = new JList<Object>();
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setBounds(39, 221, 163, 178);
		contentPane.add(list);
		
		
		///start calendar
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
		table.setBounds(212, 85, 535, 318);
		contentPane.add(table);
		
		
		
		JButton rightButton = new JButton(">");
		rightButton.setBounds(695, 53, 52, 23);
		contentPane.add(rightButton);
		rightButton.addActionListener(new ActionListener() {  //if right button press
			@Override
			public void actionPerformed(ActionEvent e) {
				calendar.add(Calendar.MONTH, +1);
	            update();
	           
			} 
		} );
		
		JButton leftButton = new JButton("<");
		leftButton.setBounds(212, 53, 52, 23);
		contentPane.add(leftButton);
		leftButton.addActionListener(new ActionListener() {  //if left button press
			@Override
			public void actionPerformed(ActionEvent e) {
				 calendar.add(Calendar.MONTH, -1);
		            update();
		            
			} 
		} );
		currentMonth = new JLabel();
		currentMonth.setHorizontalAlignment(SwingConstants.CENTER);
		currentMonth.setBounds(410, 53, 125, 14);
		contentPane.add(currentMonth);
		update();
		 //end calendar
		
		
	
		
	}
	public void update() {

		        calendar.set(Calendar.DAY_OF_MONTH, 1);     
		        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
		        int numberDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		        int weeks = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
		        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
				int year = calendar.get(Calendar.YEAR);
		        currentMonth.setText(month + " " + year);
		        model.setRowCount(0);
		        model.setRowCount(weeks);

		        int i = startDay - 1;
		        for(int j = 1; j <= numberDays; j++) {
		            model.setValueAt(j, i/7, i%7);
		            i++;
		        }
		    }// End of method updateMonth
	
}
