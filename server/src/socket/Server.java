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
                new CreateServerThread(socket);//��������ʱ����һ���̴߳���
            }
        } catch (IOException e) {
        } finally {
            close();
        }
    }

    //�߳���
    class CreateServerThread extends Thread {
        private Socket client;
        private  DataInputStream  dataInputStream ;
        private DataOutputStream dataOutputStream;
        private BufferedReader bufferedReader;
        int length=0;//��ͷ����ȡ����ϣ�������ݳ���
       char statecode;
        int templength = 0;
        int hopelength = 0;
        char state = '1';
        int j;//�����Ե�ǰ�Ļ�ȡ��¼��ƫ��

        public CreateServerThread(Socket s) throws IOException {
            client = s;

            
            dataOutputStream = new DataOutputStream(client.getOutputStream());
           //�ͻ��˷���һ������
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
            	int pos,end,offset; //offset��¼Э�鳤��,pos��¼���˰�ͷ����ʼλ�ã�end��¼������λ��
            	//��ȡ�ͻ��˵�����
            	
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