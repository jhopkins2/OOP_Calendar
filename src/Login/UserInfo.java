package Login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class UserInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	
	public static void createUserInfoForm(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public UserInfo() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblFirstName = new JLabel("First Name:");
			lblFirstName.setBounds(91, 47, 76, 14);
			contentPane.add(lblFirstName);
			
			JLabel lblLastName = new JLabel("Last Name:");
			lblLastName.setBounds(91, 72, 76, 14);
			contentPane.add(lblLastName);
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(91, 97, 76, 14);
			contentPane.add(lblEmail);
			
			JLabel lblUsername = new JLabel("Username:");
			lblUsername.setBounds(91, 119, 76, 14);
			contentPane.add(lblUsername);
			
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setBounds(91, 144, 76, 14);
			contentPane.add(lblPassword);
			
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setBounds(177, 47, 150, 14);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel();
			lblNewLabel_1.setBounds(177, 72, 150, 14);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel();
			lblNewLabel_2.setBounds(177, 97, 150, 14);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel();
			lblNewLabel_3.setBounds(177, 119, 150, 14);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel();
			lblNewLabel_4.setBounds(177, 144, 150, 14);
			contentPane.add(lblNewLabel_4);
			
			JLabel lblUserInformation = new JLabel("User Information");
			lblUserInformation.setHorizontalAlignment(SwingConstants.CENTER);
			lblUserInformation.setBounds(157, 11, 129, 14);
			contentPane.add(lblUserInformation);
			
			JButton btnDone = new JButton("Done");
			btnDone.setBounds(177, 197, 89, 23);
			contentPane.add(btnDone);
			btnDone.addActionListener(new ActionListener() {  //if done button press
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				} 
			} );
		}
}
