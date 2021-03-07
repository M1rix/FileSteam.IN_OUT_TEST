package com.mirix;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        File fileIn = new File("C:\\Users\\M_iRiX\\Desktop\\out.txt");
        try (InputStream is = new FileInputStream(fileIn)){
            long fileLength = fileIn.length();
            while(fileLength>0) {
                byte[] bytes = new byte[1024];
                int len = is.read(bytes);
                fileLength-=1024;
                write(bytes);
            }
            //System.out.println("Содержимое файла '" +fileIn.getName()+"':\n"+ new String(bytes));

        } catch (FileNotFoundException exc) {
            System.out.println("File не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }
    }

    //_________++++++++++++++++++_____________//
    public static void write(byte[] inbytes){

        File fileOut = new File("C:\\Users\\M_iRiX\\Desktop\\test.txt");
        try (OutputStream os = new FileOutputStream(fileOut,true)){

            os.write(inbytes);

        } catch (FileNotFoundException exc) {
            System.out.println("File не найден");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }
}
