package ru.geekbrains.J1Homework6;

import java.io.InputStream;
import java.io.OutputStream;


public class MainClass {
    public static boolean SerchWord(String nameword, CreateTextFile[] files) {
        boolean a = false;
        for (int i = 0; i < files.length; i++) {
            a = files[i].findWord(nameword);
            if (files[i].findWord(nameword)) {
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        //1.	Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
        InputStream in;//  для чтения внутрь программы
        OutputStream out;// для записи из программы
        // вместе они образуют поток для связи программы с консолью, с файлами и т.д.
        CreateTextFile[] createfiles = {
                new CreateTextFile(
                        "text1", "\n" +
                        "The subject of history is the life of nations and humanity . Directly catch and embrace the word - to describe the life not only of humanity , but of one people , - it seems impossible .\n"
                ),
                new CreateTextFile(
                        "text2", "\n" +
                        "All ancient historians used the same technique in order to describe and grasp the seemingly elusive - the life of the people . They described the activities of individuals who rule the people ; and this activity expressed for them the activity of the whole people ."
                ),
        };
        createfiles[0].createFile();
        createfiles[1].createFile();
        //2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
        createfiles[0].pastingText(createfiles[1].fileContent);
        //3.	* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
        System.out.println(createfiles[0].findWord("subject"));//проверка
        //4.  ** Написать метод, проверяющий, есть ли указанное слово в папке
        System.out.println(SerchWord("people", createfiles));
    }
}