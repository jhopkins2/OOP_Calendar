package CalendarMain;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.UserInfo;
import Login.UserLogin;
import MonthlyCalendarPackage.MonthlyCalendar;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class CalendarMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public void main(String[] args) {                    //main call to calendar menu
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
	}*/

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
		
		JButton btnNewCalendar = new JButton("New Calendar");
		btnNewCalendar.setBounds(39, 81, 163, 23);
		contentPane.add(btnNewCalendar);
		btnNewCalendar.addActionListener(new ActionListener() {  //if new calendar button press
			@Override
			public void actionPerformed(ActionEvent e) {
				MonthlyCalendar i= new MonthlyCalendar();
				i.makeCalendar();
			} 
		} );
		JButton btnViewUserInformation = new JButton("View User Information");
		btnViewUserInformation.setBounds(39, 115, 163, 23);
		contentPane.add(btnViewUserInformation);
		btnViewUserInformation.addActionListener(new ActionListener() {  //if view user info button press
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] args = {};
				//UserInfo.main(args);
			} 
		} );
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(78, 406, 89, 23);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {  //if log out button press
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] args = {};
				//UserLogin.main(args);
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
