package Login;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;

import CalendarMain.CalendarMenu;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

public class UserLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	private JPanel contentPane;
	private String username;
	private String password;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void createUserLoginForm(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin(String user, String password){
        this.setUsername(user);
        this.setPassword(password);
    }
	public final void setUsername(String username){ //sets current username
        this.username = username;
    }
    public final void setPassword(String password){  //sets current password
        this.password = password;
    }
    
    public String getUsername(){ //Retrieves variable
        return username;
    }
    
    public String getPassword(){ 
        return password;
    }
	public UserLogin() throws IOException{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblCalendarLogin = new JLabel("Calendar Login");
		lblCalendarLogin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 14));
		lblCalendarLogin.setBounds(86, 11, 275, 83);
		lblCalendarLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCalendarLogin);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(157, 117, 33, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(155, 154, 70, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		//username=textField.getText();
		textField.setBounds(225, 114, 88, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		//password=textField_1.getText();
		textField_1.setBounds(225, 151, 88, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		 JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(182, 214, 89, 23);
		contentPane.add(btnRegister);
		
		
		btnRegister.addActionListener(new ActionListener() {  //if register button press
			@Override
			public void actionPerformed(ActionEvent e) {
				UserRegister a= new UserRegister();
				String[] args = {};
				a.mainRegister(args);
			} 
		} );
        
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(182, 180, 89, 23);
		contentPane.add(btnLogin);
		
		
		btnLogin.addActionListener(new ActionListener() {  //if login button press
			private final MemberList memberList = new MemberList();
			private Member currentUser=null;
			
			@Override
			public void actionPerformed(ActionEvent e) {     //get input from user
				username=textField.getText();
				password=textField_1.getText();
				try {
					this.memberList.populate();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				this.currentUser = this.memberList.validateMember(username, password); //calls function to validate user credentials as present in member data files
                if (this.currentUser != null){//if present     
                		CalendarMenu a= new CalendarMenu(); //call to main calendar menu
        				String[] args = {};
        				a.createCalendarMenu(args);
        				setVisible(false);
                	}
                	else {
                		ErrorMessage a= new ErrorMessage(); //call to error message pop up
                		String[] args = {};
                		a.main(args);
                		System.out.println("Credentials do not match. Try again."); //if user is not present in system error message
                	}
			}
		} );
		
		
	}
   
   //functions used to check the validity of users input to the data files
    public boolean validateUser(String user, String password){
        return (this.getUsername().equalsIgnoreCase(user) && this.getPassword().equals(password));
    }
    public boolean validateUsername(String username){
        return (this.getUsername().equalsIgnoreCase(username));
    }
}