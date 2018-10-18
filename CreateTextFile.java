package ru.geekbrains.J1Homework6;
import java.io.*;
import java.util.Scanner;

class CreateTextFile {
    private String fileName;
    String fileContent;

     CreateTextFile(String fileName, String fileContent) {
        this.fileName = fileName;
        this.fileContent = fileContent;
    }
    void createFile (){
        String filetxtName = fileName.concat(".txt");//создание новой строки с расширением файла
        try {
            FileOutputStream fos = new FileOutputStream(filetxtName) ;//класс для записи из программы в файлы
            fos.write(fileContent.getBytes());
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     void pastingText (String newText){
         String filetxtName = fileName.concat(".txt");//создание новой строки с расширением файла
         try {
             FileOutputStream fos = new FileOutputStream(filetxtName,true) ;//класс для записи из программы в файлы
             fos.write(newText.getBytes());
             fos.close();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
     }

    void printText (){
         String filetxtName = fileName.concat(".txt");//создание новой строки с расширением файла
         try {
             FileInputStream fis = new FileInputStream(filetxtName) ;//класс для записи из программы в файлы
//            System.out.println(fis.read());
             int b;
             while ((b = fis.read()) != -1) {//выводим в консоль символы до конца файла
                 System.out.print((char) b);
             }
         } catch (IOException ex) {
             ex.printStackTrace();
         }
     }
    boolean findWord(String word) {
        boolean result = false;
        String filetxtName = fileName.concat(".txt");//создание новой строки с расширением файла
        try {
            Scanner scannerText = new Scanner(new FileInputStream(filetxtName));//класс для записи из программы в файлы
            while (scannerText.hasNext() ) {// пока у сканера есть, что взять
                result = word.equals(scannerText.next());
                    if(result)
                        break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}