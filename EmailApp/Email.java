package EmailApp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailBoxCapacity = 100;
    private String companySuffix = "company";
    private String alternateEmail;

    //Constructor to recieve first name and last name

    public Email(String firstName, String lastName)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        //System.out.println("Email Created "+this.firstName+" "+this.lastName);

        //Call for a method to set department
        this.department=setDepartment();
        //System.out.println(this.department);

        //Call for a method to generate password

        this.password = randomPassword(10);
        System.out.println("Your password is "+this.password);

        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix+".com";
        //System.out.println("This is your company Email: "+email);
    }

    //Ask for the department
    private String setDepartment()
    {
        System.out.print("DEPARTEMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n4 for None\nEnter the department");
        Scanner sc = new Scanner(System.in);
        int deptChoice = sc.nextInt();

        if(deptChoice==1){return "sales";}
        else if(deptChoice==2){return "development";}
        else if(deptChoice==3){return "accounting";}

        return "";

    }
    //Generate a random password
    private String randomPassword(int length)
    {
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789@$#";

        char password[] = new char[length];

        for(int i=0;i<length;i++)
        {
            int rand = (int)(Math.random() * passSet.length());
            password[i]=passSet.charAt(rand);
        }

        return new String(password);

    }
    //Set the mailbox capacity
    public void setMailCapacity(int capacity)
    {
        this.mailBoxCapacity=capacity;
    }
    //Set the alterate mail
    public void setAlternateEmail(String email)
    {
        this.alternateEmail=email;
    }

    //Change the password
    public void changePassword(String password)
    {
        this.password=password;
    }

    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo()
    {
        return "DISPLAY NAME "+firstName+" "+lastName+"\n"+
                "COMPANY EMAIL "+email+"\n"+
                "MAILBOX CAPACITY "+mailBoxCapacity+" mb";
    }
}
