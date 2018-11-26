package CalendarMain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CalendarMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setBounds(100, 100, 800, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeBack = new JLabel("Welcome back ");
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeBack.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblWelcomeBack.setBounds(245, 26, 214, 30);
		contentPane.add(lblWelcomeBack);
		
		JButton btnViewSavedCalendars = new JButton("View Saved Calendars");
		btnViewSavedCalendars.setBounds(39, 81, 148, 23);
		contentPane.add(btnViewSavedCalendars);
		
		JButton btnNewCalendar = new JButton("New Calendar");
		btnNewCalendar.setBounds(39, 122, 148, 23);
		contentPane.add(btnNewCalendar);
		
		JButton btnViewUserInformation = new JButton("View User Information");
		btnViewUserInformation.setBounds(39, 166, 148, 23);
		contentPane.add(btnViewUserInformation);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(39, 385, 89, 23);
		contentPane.add(btnLogOut);
		
		JPanel panel = new JPanel();
		panel.setBounds(212, 81, 541, 360);
		contentPane.add(panel);
	}
}
