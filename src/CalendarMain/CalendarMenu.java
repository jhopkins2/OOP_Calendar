package CalendarMain;

import CalendarFactoryPackage.CalendarFactory;
import CalendarPackage.Calendars;
import Login.Member;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

public class CalendarMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Calendar calendar;
	private JLabel currentMonth;
        private Member currentUser;
        private Calendars calendarObject;
        private CalendarFactory factory = new CalendarFactory();
        int month = 0;
	

	/**
	 * Launch the application.
	 */
	public static void createCalendarMenu(Member u) {                    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarMenu frame = new CalendarMenu(u);
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
	public CalendarMenu(Member cu) {
		
                currentUser = cu;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 497);
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
		btnNewCalendar.setBounds(39, 141, 163, 23);
		contentPane.add(btnNewCalendar);
		btnNewCalendar.addActionListener(new ActionListener() {  //if new calendar button press
			@Override
			public void actionPerformed(ActionEvent e) {
				calendarObject = factory.getCalendar("Monthly", month);
                                calendarObject.makeCalendar();                         
			} 
		} );
		JButton btnViewUserInformation = new JButton("View User Information");
		btnViewUserInformation.setBounds(39, 174, 163, 23);
		contentPane.add(btnViewUserInformation);
		btnViewUserInformation.addActionListener(new ActionListener() {  //if view user info button press
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] args = {};
				UserInfo.createUserInfoForm(currentUser);
			} 
		} );
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(70, 410, 98, 23);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {  //if log out button press
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] args = {};
				UserLogin.createUserLoginForm(args);
				setVisible(false);
			} 
		} );
		String[] monthNames = { "January", "February", "March", "April", "May", 
                    "June", "July", "August", "September", "October", "November", "December" };
		JComboBox<Object> comboBox = new JComboBox<Object>(monthNames);
                comboBox.addItemListener(
                        new ItemListener(){
                            @Override
                            public void itemStateChanged(ItemEvent event){
                                if(event.getStateChange() == ItemEvent.SELECTED){
                                    month = comboBox.getSelectedIndex();
                                }
                            }
                        }
                );
		comboBox.setToolTipText("Select a month to create its corresponding calendar.");
		comboBox.setBounds(39, 110, 163, 23);
		contentPane.add(comboBox);
		//comboBox.addItem(new );
		//comboBox.addItem();
		
		JLabel lblViewSavedCalendars = new JLabel("Select Month");
		lblViewSavedCalendars.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewSavedCalendars.setBounds(39, 81, 163, 14);
		contentPane.add(lblViewSavedCalendars);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setBounds(95, 206, 46, 14);
		contentPane.add(lblEvents);
		
		
		JList<Object> list = new JList<Object>();
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setBounds(39, 221, 163, 178);
		contentPane.add(list);
		
        }
}
