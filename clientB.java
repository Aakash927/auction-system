import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clientB {
    public static void main(String[] args)throws IOException {
       
        Socket socket = new Socket("localhost",9090 );
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        String serverResponse = input.readLine();
        System.out.println("host :"+ serverResponse);

        String serverrequest_name = input.readLine();
        System.out.println("host:" + serverrequest_name);
        String name = keyboard.readLine();
        out.println(name);
        out.flush();

        String serverResponse2;
        for(int i = 0; i< 8; i++){
            serverResponse2 = input.readLine();
            System.out.println("host : "+ serverResponse2);
        }

        for(int i =0; i< 2 ;i++){
           
            System.out.println("client enter your bid");
            String bid = keyboard.readLine();
            //String s = String.valueOf(bid);
            out.println(bid);
            out.flush();

            String response = input.readLine();
            System.out.println("amount bidded = "+ response);

            //if((bid == "quit") || bid == "0"){
            //  out.println("");
            // socket.close();
            //}

        }
           
        
        socket.close();


    }
}
