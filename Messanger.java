package messenger_app;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
interface Msgservices{
	void sendmessage();
}
class SMSMessagingService implements Msgservices{
	public void sendmessage() {
		Scanner scanner=new Scanner(System.in);
        System.out.println("Enter contact num  ");
        long number= scanner.nextLong();
        System.out.println("Enter msg : ");
        String smsmessage= scanner.nextLine();
        smsmessage+=scanner.nextLine();
        
        String number_str=String.valueOf(number);
        if(number_str.matches("[6-9]\\d{9}")){
            System.out.println("Sent To : "+number);
            System.out.println("Message : "+smsmessage);
        }
        else{
            System.out.println("Invalid number");
		
	}
}
}

class EmailMessaging implements Msgservices{
	
	public void sendmessage() {
		
		Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Email address: ");
        System.out.println("Enter Email address of Bb,Cc: ");
        String emailaddress= scanner.next();
        System.out.println("Enter Subject : ");
        String mailSubject= scanner.next();
        System.out.println("Enter body of mail : ");
        String mailmessage= scanner.nextLine();
        mailmessage+=scanner.nextLine(); 
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailaddress);
        if(matcher.matches()){
            System.out.println("Sent To : "+emailaddress);
            System.out.println("Subject : "+mailSubject);
            System.out.println("Mail Content : "+mailmessage);
        }
        else{
            System.out.println("Invalid Email address");
	}
		
	}
}

class WhatsappMessagingService implements Msgservices{
	public void sendmessage() {
		Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number of Reciever : ");
        long number= scanner.nextLong();
        System.out.println("Enter 1 if user exist in Whatsapp else 0");
        int whatsapp_user=scanner.nextInt();
        System.out.println("Enter Message Content : ");
        String whatsapp_message= scanner.nextLine();
        whatsapp_message+=scanner.nextLine();
        String number_str=String.valueOf(number);
        if(number_str.matches("[6-9]\\d{9}") && whatsapp_user==1){
            System.out.println("Sent To : "+number);
            System.out.println("Message : "+whatsapp_message);
        }
        else if (whatsapp_user==0){
            System.out.println("Whatasapp doesn't found with the data ");
        }
        else{
            System.out.println("Invalid number");}
	}
		//System.out.println("Whatsapp msg send");
	}


public class Messanger{
	public static void main(String[] args) {
		Msgservices sms = new SMSMessagingService();
		Msgservices mail = new EmailMessaging();
		Msgservices whatsapp = new WhatsappMessagingService();
		Scanner scanner=new Scanner(System.in);
        int ch;
        do{
        	System.out.println("MSG Menu:");
            System.out.println("1-SMS msg");
            System.out.println("2-Email msg");
            System.out.println("3-Whatsapp msg");
            System.out.println("4-Exit");
            System.out.print("Please enter your choice: ");
            ch=scanner.nextInt();
            if(ch==1){
            	sms.sendmessage();
            }
            else if(ch==2){
            	mail.sendmessage();
        		
            }
            else if(ch==3){
            	whatsapp.sendmessage();
            }
            else if(ch==4){
            	System.exit(0);
            }
            else{
                System.out.println("Invalid choice");
            }
        }
        while(true);
    }				
	}