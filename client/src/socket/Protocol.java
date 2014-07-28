package socket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Protocol  implements Serializable{
	
	byte length;
	byte statecode;
	byte[] content;
	/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	byte[] time;*/
	
	public Protocol(byte length, byte statecode, byte[] content){
		this.length = length;
		this.statecode = statecode;
		this.content = content;		
	}
	
	public byte getLength() {
		return length;
	}
	public void setLength(byte length) {
		this.length = length;
	}
	public byte getStatecode() {
		return statecode;
	}
	public void setStatecode(byte statecode) {
		this.statecode = statecode;
	}
/*	public byte[] getAuthor() {
		return author;
	}
	public void setAuthor(byte[] author) {
		this.author = author;
	}*/
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	/*public byte[] getTime() {
		//取当前时间
		Date date = new Date();
		this.time = simpleDateFormat.format(date).getBytes();
		return time;
	}
	*/
	//序列化
	public String toString(){	
		return "l:"+length+"s:"+statecode+"c:"+new String(content);
	}
	
	/*public static void main(String[] args) throws Exception{
		
		byte length = new Byte("10");
		byte statecode = new Byte("1");
		byte[] content = "1234567890".getBytes();
		
		Protocol a = new Protocol(length, statecode, content);
		System.out.println("login a="+a);
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("Login.out"));
		o.writeObject(a);
		o.close();
		
		TimeUnit.SECONDS.sleep(1);

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Login.out"));
		System.out.println("Recovering object at"+new Date());
		a = (Protocol)in.readObject();
		System.out.println("Login a = "+a);
		
	}
*/

	
	
	
		
}
