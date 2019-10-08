package TP1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ex1 {
	
	
	public static void testOutputStream(){
		 try {
			 File f1= new File("file.txt");
			 
				OutputStream os= new FileOutputStream(f1);
	
				/*byte[] bytes={97,98};
				os.write(bytes);*/
				for(int i = 97; i <123;i++) 
				    os.write(i);
					os.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	}

	
	public static void testOutputStreamEuro(){
		 try {
			 File f1= new File("file.txt");
			 
				OutputStream os= new FileOutputStream(f1);
	
				 os.write(8364);
					os.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	}

	public static void testIntput(){
		 try {
			 File f1= new File("file.txt");
			 
				InputStream os= new FileInputStream(f1);
				int a;	
				while((a=os.read())!=-1){
			//		System.out.print((char)a);
				System.out.write(a);
				}
				System.out.flush();
				
				os.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
	}
	/*c la meilleur avec available*/
	public static void testIntput2(){
		 try {
			 File f1= new File("file.txt");
			 
				InputStream in= new FileInputStream(f1);
				int a;	
				while((in.available())!=0){
					System.out.print((char)in.read());
					System.out.print("available :"+in.available());
					
				}
				
				in.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
	}
	public static void testWriter(){
		 try {
			 File f1= new File("file.txt");
			 
				FileWriter wr= new FileWriter(f1);
				for(int i = 97; i <123;i++) 		
				wr.write(i);
				wr.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
	}
	public static void testReader(){
		 try {
			 File f1= new File("file.txt");
			 
				FileReader r= new FileReader(f1);
			int a;
				while((a=r.read())!=-1){
					//		System.out.print((char)a);
						System.out.write(a);
						}
						System.out.flush();
						
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
	}
	
	
	public static void main(String args[]){
	
		testOutputStreamEuro();
		testReader();
	}

}
