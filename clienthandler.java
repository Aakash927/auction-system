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
        out.println("enter your name pls");
        out.flush();
        
    out.println("following are the rules for the auction, please read them carefully");
    out.println(" ");
    out.println("1 "+ "The auction will start after all the bidders have joined");
    out.println("2 "+ "Each bidder will recieve 60 seconds to bid, a timer will be displayed for the same");
    out.println("3 "+ "The bidder shall not bid lesser than the previous bid, any such bid will be considered invalid");
    out.println("4 "+ "In case the bidder chooses not to bid for the item presented, just wait for the timer to run out");
    out.println("5 "+ "There will be 10 rounds in all for all the bidders, the last bid will be the maximum and hence the respective bidder would be declared a winner");
    out.println("6 "+ "A base price would be set for the item by the organiser, the bid shall be added to base price to make a total");
    out.flush();
       
        try {
            
            //out.flush();
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
