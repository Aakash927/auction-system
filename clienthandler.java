import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clienthandler implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private int max = 100;

    public clienthandler(Socket clientSocket) throws IOException{
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream());
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        out.println("welome to the auction");
        out.flush();
        
        
       
        try {
            out.println("enter your name pls");
            out.flush();
            String z = in.readLine();

            for(int j =0; j<200; j++){
                

                
                String a = in.readLine();
                int i=Integer.parseInt(a); 

                System.out.println("amount bidded by client "+z+ " " +(a));
                System.out.println("total amount auctioned = "+ (i+100));
                String b = String.valueOf(i+100);
                out.println(b);
                out.flush();

               if((i+100) > max){
                   max = i+100;
               } 
                
            }
            System.out.println("max = "+max);
            }catch (IOException e) {
                // TODO Auto-generated catch block
                System.err.println("IO exception in client handler");
            }
    
        finally{
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
                   
    }
    
}
