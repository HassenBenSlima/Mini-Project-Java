package iit.ens.projetTest;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class CipherSample {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    
	private  String FILENAME ;
	
	public CipherSample( String FILENAME){
		this.FILENAME = FILENAME;	
	}
	
	public String  encrypt() {
		 try{
		Reader r =new FileReader(FILENAME);
		StringBuffer buf= new StringBuffer();
		
		int octet = 0;
		while(octet!=-1){
			octet=r.read();
				if(octet== -1)break;
				buf.append((char)octet);
		}

		r.close();
		String s =buf.toString();
		System.out.println(s);
		
      /*byte[] key = ("dalijallouli").getBytes("UTF-8");
      MessageDigest sha = MessageDigest.getInstance("SHA-1");
       key = sha.digest(key);
       key = Arrays.copyOf(key, 16);
       SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");*/
		final String secret = "ssshhhhhhhhhhh!!!!";
		setKey(secret);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        s= Base64.getEncoder().encodeToString(cipher.doFinal(s.getBytes("UTF-8")));

       /* byte[] decodedKey = Base64.getDecoder().decode("CSF1EZ511154455TYUDwdfdf564");
        decodedKey = Arrays.copyOf(decodedKey, 16);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES"); 
		
        // Create Cipher instance and initialize it to encrytion mode
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  // Transformation of the algorithm
        cipher.init(Cipher.ENCRYPT_MODE, originalKey);
        
        byte[] cipherBytes = cipher.doFinal( buf.toString().getBytes() );
        
        s=cipherBytes.toString();*/
        
	   Writer w =new FileWriter(FILENAME);
		w.write(s);  
        w.close();
		
		//System.out.println(cipherBytes);
      
        System.out.println("CRUPTED DATA : "+s);
        return "";
        
		  }catch(Exception ex){
			  return  ex.toString();
	        }
		 
		 
	}
	
	
	public String  decrypt() {
	    try{
	    	
			Reader r =new FileReader(FILENAME);
			StringBuffer buf= new StringBuffer();
			
			int octet = 0;
			while(octet!=-1){
				octet=r.read();
					if(octet== -1)break;
					buf.append((char)octet);
			}

			r.close();
			//System.out.println(buf.toString());
			final String secret = "ssshhhhhhhhhhh!!!!";
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            String s= new String(cipher.doFinal(Base64.getDecoder().decode(buf.toString())));
	    	
            //byte[] cipherBytes = buf.toString().getBytes();
             
           // byte[] key = ("dalijallouli").getBytes("UTF-8");
           // MessageDigest sha = MessageDigest.getInstance("SHA-1");
            //key = sha.digest(key);
           // key = Arrays.copyOf(key, 16);
            //SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            /*
            byte[] decodedKey = Base64.getDecoder().decode("dalijalloulidalijalloulidalijallouli");
            decodedKey = Arrays.copyOf(decodedKey, 16);
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES"); 
            // Create Cipher instance and initialize it to encrytion mode
            
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  // Transformation of the algorithm
	    cipher.init(Cipher.DECRYPT_MODE,originalKey, cipher.getParameters());
        byte[] plainBytesDecrypted = cipher.doFinal(cipherBytes);
         */
        System.out.println("DECRUPTED DATA : "+s);    
   
	    Writer w =new FileWriter(FILENAME);
		w.write(s);
		w.close();
		
        return "";
	    
	    }catch(Exception ex){
	    	 System.out.println("Error while decrypting: " + ex.toString());
       return ex.toString();
    }
	    }
	
	
	
    /*public static void main(String[] args){
        try{
            byte[] plainBytes = "HELLO JCE".getBytes();
             
          // Generate the key first
           
           // KeyGenerator keyGen = KeyGenerator.getInstance("AES");
           // keyGen.init(128);  // Key size
           // Key key = keyGen.generateKey();
       
            byte[] key = ("dalijallouli").getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            
            
            // Create Cipher instance and initialize it to encrytion mode
            
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  // Transformation of the algorithm
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] cipherBytes = cipher.doFinal(plainBytes);
            System.out.println("DECRUPTED DATA : "+new String(cipherBytes));
            
          //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
            
            // Reinitialize the Cipher to decryption mode
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec, cipher.getParameters());
            byte[] plainBytesDecrypted = cipher.doFinal(cipherBytes);
             
            System.out.println("DECRUPTED DATA : "+new String(plainBytesDecrypted));    
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }*/
	
	
	 public static void setKey(String myKey)
	    {
	        MessageDigest sha = null;
	        try {
	            key = myKey.getBytes("UTF-8");
	            sha = MessageDigest.getInstance("SHA-1");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16);
	            secretKey = new SecretKeySpec(key, "AES");
	        }
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	    }
}