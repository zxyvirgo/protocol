package socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SocketClient {
	

	public void Client(String s){
	    try {
            Socket socket = new Socket("127.0.0.1", 2013);
            socket.setSoTimeout(60000);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
          /*  DataInputStream dataInputStream = new DataInputStream(
            		new BufferedInputStream(socket.getInputStream()));*/
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
           
            	
            try{
            	
            	byte[] output;
            	output =s.getBytes();//������ת��byte�����ͳ�ȥ
            	System.out.print(new String(output));//���Է��͵�����
            	dataOutputStream.write(output);
            	dataOutputStream.flush();

            }catch(SocketTimeoutException e){
            	
            	//��ʱ�䲻�������ݣ��Զ��ر�����
                dataOutputStream.close();
                bufferedReader.close();
                socket.close();
            }
            
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
	}
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    	
    	SocketClient client = new SocketClient();
    	
    	byte length = new Byte("10");
		byte statecode = new Byte("1");
		byte[] content = "1234567890".getBytes();
		
    	Protocol a = new Protocol(length, statecode, content);
    	//Э������л�

		client.Client(a.toString());
		System.out.println("login a="+a);
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("protocol.out"));
		o.writeObject(a);
		o.close();
		
		//�����л�
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Login.out"));
		System.out.println("Recovering object at"+new Date());
		a = (Protocol)in.readObject();
		System.out.println("Login a = "+a);
	
    }
}