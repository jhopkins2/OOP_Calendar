package CalendarMain;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.UserInfo;
import Login.UserLogin;
import MonthlyCalendarPackage.MonthlyCalendar;
import CalendarPackage.Calendars;
import CalendarFactoryPackage.CalendarFactory;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CalendarMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
        private Calendars calItem = null;
        private CalendarFactory cf = new CalendarFactory();

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 269, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeBack = new JLabel("Calendar Schedule Maker");
		lblWelcomeBack.setBounds(39, 24, 207, 30);
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeBack.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		contentPane.add(lblWelcomeBack);
		
		JButton btnNewMonthlyCalendar = new JButton("New Monthly Calendar");
		btnNewMonthlyCalendar.setBounds(39, 81, 163, 23);
		contentPane.add(btnNewMonthlyCalendar);
		btnNewMonthlyCalendar.addActionListener(new ActionListener() {  //if new calendar button press
			@Override
			public void actionPerformed(ActionEvent e) {
                                calItem = cf.getCalendar("Monthly");
				calItem.makeCalendar();
			} 
		} );
                JButton btnNewWeeklyCalendar = new JButton("New Weekly Calendar");
		btnNewWeeklyCalendar.setBounds(39, 115, 163, 23);
		contentPane.add(btnNewWeeklyCalendar);
		btnNewWeeklyCalendar.addActionListener(new ActionListener() {  //if new calendar button press
			@Override
			public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(contentPane, "Weekly Calendar to be built.");                                
			} 
		} );
		JButton btnViewUserInformation = new JButton("View User Information");
		btnViewUserInformation.setBounds(39, 149, 163, 23);
		contentPane.add(btnViewUserInformation);
		btnViewUserInformation.addActionListener(new ActionListener() {  //if view user info button press
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] args = {};
				UserInfo.createUserInfoForm(args);
			} 
		} );
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(78, 406, 89, 23);
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
		
	
		
	}
}
