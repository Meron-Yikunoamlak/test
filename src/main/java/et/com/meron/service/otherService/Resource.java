package et.com.meron.service.otherService;

import java.io.*;
import java.io.FileOutputStream;
public class Resource {
//    public static void resource(String path) throws IOException {
//        FileReader fr = new FileReader(path);
//        BufferedReader br = new BufferedReader(fr);
//        String line = br.readLine();
//        br.close();
//        fr.close();
//    }


    public static void main(String args[]){
        try(    FileOutputStream fileOutputStream=
                        new FileOutputStream("C:\\Users\\memo\\Desktop\\after payback\\SafariComExam\\README.md.txt")){
            // -----------------------------Code to write data into file--------------------------------------------//
            String msg = "MY FILE";
            byte byteArray[] = msg.getBytes();  // Converting string into byte array
            fileOutputStream.write(byteArray);  // Writing  data into file
            System.out.println("Data written successfully!");
        }catch(Exception exception){
            System.out.println(exception);
        }
        finally{
            System.out.println("Finally executes after closing of declared resources.");
        }
    }
}




