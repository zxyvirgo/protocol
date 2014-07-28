package socket;
import java.io.*;
import java.net.*;

public class Server extends ServerSocket {
    private static final int SERVER_PORT = 2013;

    public Server() throws IOException {
        super(SERVER_PORT);

        try {
            while (true) {
                Socket socket = accept();
                new CreateServerThread(socket);//当有请求时，启一个线程处理
            }
        } catch (IOException e) {
        } finally {
            close();
        }
    }

    //线程类
    class CreateServerThread extends Thread {
        private Socket client;
        private  DataInputStream  dataInputStream ;
        private DataOutputStream dataOutputStream;
        private BufferedReader bufferedReader;
        int length=0;//包头里面取到的希望的数据长度
       char statecode;
        int templength = 0;
        int hopelength = 0;
        char state = '1';
        int j;//用来对当前的获取记录的偏移

        public CreateServerThread(Socket s) throws IOException {
            client = s;

            
            dataOutputStream = new DataOutputStream(client.getOutputStream());
           //客户端发送一次请求
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Client(" + getName() + ") come in...");
            start();
        }

        public void run() {
            try {
            	
            //	try{
            	int input ; 
            	byte[] result = null;
            	int i=0;
            	int pos,end,offset; //offset记录协议长度,pos记录除了包头的起始位置，end记录结束的位置
            	//获取客户端的请求
            	
            	while ((input=bufferedReader.read())!=-1){
          		
            	System.out.print(input);
                  
            	}
            	
              
            	  System.out.println("Client(" + getName() + ") exit!");
                  dataInputStream.close();
                  dataOutputStream.close();
                  client.close();

            } catch (IOException e) {
            
            	

            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}