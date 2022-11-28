import java.io.*;
import java.net.*;

public class Server {
	
public static String isPrime(int num) {
	
if(num<2) {
	
return "Not a prime number";

}

int i=2;
while(i<num) {
	
if(num%i==0) {
	
return "No";
}
i++;
}
return "Yes"; 
}


public static void main(String[] args){
	
try{
	
//connect to server
ServerSocket serversocket = new ServerSocket(8000);
Socket socket = serversocket.accept();
DataInputStream input = new DataInputStream(socket.getInputStream());
DataOutputStream output = new DataOutputStream(socket.getOutputStream());

//calling function to send back to client
int number = (int)input.readInt();
output.writeUTF(isPrime(number));
output.flush();

output.close();
serversocket.close();
}
catch(Exception e){
System.out.println(e);
}
}
}