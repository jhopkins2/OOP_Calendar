package Login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;



import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class UserRegister extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	static String user;
	static String password;
	static String first;
	static String last;
	static String email;
	static String middle;

	/**
	 * Launch the application.
	 */
	public void mainRegister(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegister frame = new UserRegister();
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
	public UserRegister() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 327);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(83, 80, 92, 14);
		contentPane.add(lblUsername);
		
			textField = new JTextField();
		textField.setBounds(155, 77, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(83, 111, 92, 14);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 108, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(83, 139, 92, 14);
		contentPane.add(lblFirstName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 136, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewJgoodiesLabel = new JLabel("Middle Int.");
		lblNewJgoodiesLabel.setBounds(83, 164, 92, 20);
		contentPane.add(lblNewJgoodiesLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(155, 165, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblLastname = new JLabel("LastName:");
		lblLastname.setBounds(83, 196, 92, 14);
		contentPane.add(lblLastname);
		
			textField_3 = new JTextField();
		textField_3.setBounds(155, 193, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(83, 224, 92, 14);
		contentPane.add(lblEmail);

		textField_4 = new JTextField();
		textField_4.setBounds(155, 221, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewUserRegister = new JLabel("New User Register");
		lblNewUserRegister.setBounds(111, 55, 129, 14);
		contentPane.add(lblNewUserRegister);
		
		JButton btnReigster = new JButton("Reigster");
		btnReigster.setBounds(114, 254, 89, 23);
		contentPane.add(btnReigster);
		btnReigster.addActionListener(new ActionListener() {
			private final MemberList memberList = new MemberList();
			@Override
			public void actionPerformed(ActionEvent e) {
				user=textField.getText();
				password=textField_1.getText();
				first=textField_2.getText();
				last=textField_3.getText();
				email=textField_4.getText();
				middle=textField_5.getText();
				 Member newMember = new Member(); //creates new object from Member Class to register new user
                 if (newMember.register(this.memberList))
                 {
                     int memid = this.memberList.length() + 1; 
                     newMember.setMemID(memid);

                     try {
						this.memberList.add(newMember);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					} //adds new member to memberList
                     try {
						this.memberList.updateMembersFile();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					} //adds member to member data file

                     System.out.format("\n\nSuccess! %s %s %s, you are now registered!"
                                     + "\nTo login, use:\nUsername: %s\nPassword: %s\n\n\n", 
                                     newMember.getFirst(), newMember.getInitial(), newMember.getLast(), 
                                     newMember.getUsername(), newMember.getPassword());
                 } 
			}
		} );
	}
}
