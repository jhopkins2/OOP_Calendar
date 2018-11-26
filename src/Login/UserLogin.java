package Login;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import CalendarFactoryPackage.CalendarFactory;
import CalendarPackage.Calendars;

import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

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
	public static void main(String[] args) {
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblCalendarLogin = DefaultComponentFactory.getInstance().createTitle("Calendar Login");
		lblCalendarLogin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 14));
		lblCalendarLogin.setBounds(78, 11, 275, 83);
		lblCalendarLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCalendarLogin);
		
		JLabel lblUser = DefaultComponentFactory.getInstance().createTitle("User:");
		lblUser.setBounds(120, 117, 33, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = DefaultComponentFactory.getInstance().createLabel("Password:");
		lblPassword.setBounds(120, 154, 88, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		//username=textField.getText();
		textField.setBounds(182, 114, 88, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		//password=textField_1.getText();
		textField_1.setBounds(182, 151, 88, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		 JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(182, 214, 89, 23);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserRegister a= new UserRegister();
				String[] args = {};
				a.mainRegister(args);
			} 
		} );
        
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(182, 179, 89, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			private final MemberList memberList = new MemberList();
			private Member currentUser=null;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				username=textField.getText();
				password=textField_1.getText();
				try {
					this.memberList.populate();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				this.currentUser = this.memberList.validateMember(username, password); //calls function to validate user credentials as present in member data files
                if (this.currentUser != null)//if present 
                	{
                	CalendarFactory factory = new CalendarFactory();
                	@SuppressWarnings("resource")
					Scanner reader =  new Scanner(System.in);
                	Calendars item = null;
                	System.out.print("Type in the kind of calendar you want: "); //calls to type of calendar
                	if(reader.hasNextLine()){
                		String calendarType = reader.nextLine();
                		item = factory.getCalendar(calendarType);
                		}
                		if(item != null){
                			System.out.println("Making Calendar.");
                			item.makeCalendar();								//creates calender
                		}
                		else{
                			System.out.println("Input doesn't match."); 
                		}
				}
                else {
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