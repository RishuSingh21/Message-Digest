package Project;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
  
public class MD {
    public static String MD5algorithm(String input)
    {
        try {
        	//to get MD5 hashing, "MD5" is called inside getInstance
            MessageDigest md5 = MessageDigest.getInstance("MD5");
  
            // digest() method will return array of byte
            byte[] msgDigest = md5.digest(input.getBytes());
            BigInteger num = new BigInteger(1, msgDigest);
  
            //message digest is converted into hex value
            String hash = num.toString(16);
            while (hash.length() < 32) {
                hash = "0" + hash;
            }
            return hash;
        } 
  
        // error message
        catch (NoSuchAlgorithmException error) {
            throw new RuntimeException(error);
        }
    }
    public static String SHAalgorithm(String input) throws NoSuchAlgorithmException
    {
    	//to get SHA hashing, "SHA-256" is called inside getInstance
        MessageDigest SHA = MessageDigest.getInstance("SHA-256");
 
        // digest() method will return array of byte
        byte[] msgDigest = SHA.digest(input.getBytes());
        BigInteger num = new BigInteger(1, msgDigest);
        
      //message digest is converted into hex value
        String hash = num.toString(16);
        
        while (hash.length() < 64) {
            hash = "0" + hash;
        }
        return hash;
    }
  
    public static void main(String args[]) throws NoSuchAlgorithmException
    {
    	Scanner userinput = new Scanner(System.in); 
    	System.out.println("Enter a string to be hashed");
    	
        String s = userinput.nextLine();
        System.out.println("Hashes generated for the input text are as follows:");
        System.out.println("1. MD5: " + MD5algorithm(s));
        System.out.println("2. SHA: " + SHAalgorithm(s));
   
    }
}