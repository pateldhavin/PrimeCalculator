import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	
	
public static void main(String[] args) {
	
	
Scanner scan = new Scanner(System.in);

try{
	
Socket socket = new Socket("localhost",8000);
DataInputStream input = new DataInputStream(socket.getInputStream());
DataOutputStream output = new DataOutputStream(socket.getOutputStream());


// Asking user to input number
System.out.print("\nEnter a number to see if it's prime : ");
int number = scan.nextInt();


// Sending input to server
output.writeInt(number);
String answer = (String)input.readUTF();
System.out.println("\nIs "+number+
" a prime number? : "+answer);
output.flush();
output.close();
socket.close();
}
catch(Exception e){
	
System.out.println(e);

}
scan.close();
}
}