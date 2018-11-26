package Login;

/**
 * The Member class is used to initialize variables of member information
 * register new members to the list by user input, add points to the profile
 * and display this information back to the user via "view membership info" option  
 */

public class Member extends UserLogin 
{   
    /**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private String fName;
    private String lName; 
    private char mInitial;
    private String email;
    
    private int memId;
    
    
    //Default member constructor
    public Member(){
        super(null, null);
        this.setFirst(null);
        this.setLast(null);
        this.setInitial('0');
        this.setEmail(null);
        this.setMemID(0);
      
 
    }
    //Constructor used by memberList
    public Member(String user, String password, int MemID, String first, char initial, String last,  
            String email){
        super(user, password);
        this.setFirst(first);
        this.setLast(last);
        this.setInitial(initial);
        this.setEmail(email);
        this.setMemID(MemID);
       
    }
    
    //Set variable functions
    public void setFirst(String fName){
        this.fName = fName;
    }
    public void setLast(String lName){
        this.lName = lName;
    }
    public void setInitial(char mInitial){
        this.mInitial = mInitial;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setMemID(int memId){ 
        this.memId = memId;
    }
    
     
    //Get variable functions 
    public String getFirst(){
        return fName;
    }
    public String getLast(){ 
     return lName;
    }
    public char getInitial(){
        return mInitial;
    }
    public String getEmail(){
        return email;
    }
   
    public int getMemID(){
        return memId;
    }
    
   
    //Function used to register new members to the system and sends it to be written to the data file 
    public boolean register(MemberList list){ 
        
    	//user input of all member information
    	String username = UserRegister.user;
    	
        if(!list.validateMemberUsername(username))//checks that username is not already in the system
        {
            super.setUsername(username); 

            String password = UserRegister.password;
            super.setPassword(password);

            String firstName = UserRegister.first;
            this.setFirst(firstName);

            String middleInitial = UserRegister.middle;
            this.setInitial(middleInitial.charAt(0));

            String lastName = UserRegister.last; 
            this.setLast(lastName); 

            String emailAddress = UserRegister.email;
            this.setEmail(emailAddress);

            return true;
        }
        
        else //if a username is already in the system
        {
            System.out.println("\n\n**That username is already taken!**\n");
            return false;
        }
    }
    
    //used to display user information back to the user
    public void showMemberInfo(){
        
        System.out.println("---Member Information---");
        System.out.println("User: "+ this.getFirst()+" "+  this.getInitial()+" "+  this.getLast()+ "\nMember ID: "+ this.getMemID()+ "\nE-mail Address: "+ this.getEmail());

    }
}