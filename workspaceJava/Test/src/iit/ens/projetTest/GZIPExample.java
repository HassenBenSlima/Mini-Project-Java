package iit.ens.projetTest;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPExample {
	
	private  String FILENAME ;

public GZIPExample( String FILENAME){
	this.FILENAME = FILENAME;

}



    
	public  String  decompressGzipFile() {
   
		 try {
	            FileInputStream fis = new FileInputStream(FILENAME);
	            FileOutputStream fos = new FileOutputStream(FILENAME.replace(".gz", ""));
	          //  GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
	            GZIPInputStream gzipOS = new GZIPInputStream(fis);
	            
	            byte[] buffer = new byte[1024];
	            int len;
	           //String s="";
	            while((len=gzipOS.read(buffer)) != -1){
	            //	System.out.println(s+=len);
	              fos.write(buffer, 0, len);
	            }

	            //close resources
	            gzipOS.close();
	            fos.close();
	            fis.close();
	            System.out.println("decomp done");
	           // return s;
	            return "";
	        } catch (IOException e) {
	           return e.toString();
	        }
       
        
    }
    
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
    
   
	public String compressGzipFile() {
        try {
            FileInputStream fis = new FileInputStream(FILENAME);
            FileOutputStream fos = new FileOutputStream(FILENAME+".gz");
            GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
           
            byte[] buffer = new byte[1024];
            int len;
            //String s="";
            while((len=fis.read(buffer)) != -1){
                gzipOS.write(buffer, 0, len);
            	
            }
            
    
    		
            //close resources
            gzipOS.close();
            fos.close();
            fis.close();
            
            System.out.println(" comp done ");
            return "";
        } catch (IOException e) {
           return e.toString();
        }
        
        
    }
	
   /* public static void main(String[] args) {
    String file = "sex.txt";
     String gzipFile = "sex.txt.gz";
     String newFile = "sex.txt";

     compressGzipFile();

     decompressGzipFile();
 }*/

}