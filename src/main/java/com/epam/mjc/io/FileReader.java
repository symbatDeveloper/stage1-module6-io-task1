package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile =new Profile();
        String absolutePath ="/Users/symbatzinatova/IdeaProjects/stage1-module6-io-task1/src/main/resources/Profile.txt";

        try(FileInputStream fileInputStream =new FileInputStream(file)){
        int result;
        while((result=fileInputStream.read()) !=-1){
        System.out.print((char)result);

    }
    }catch (IOException e) {
            throw new TestFileIncorrectException(e.getMessage());
     }

        try(FileOutputStream fileOutputStream=new FileOutputStream(absolutePath)){
            String content =profile.toString();
            fileOutputStream.write(content.getBytes());
            String[] contents ="".split("\n");
            for(String cont : contents){
              String [] answer =cont.split(": ");
                switch (answer[0]) {
                    case "Name":
                        profile.setName(answer[1]);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(answer[2]));
                        break;
                    case "Email":
                        profile.setEmail(answer[3]);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(answer[4]));
                        break;
                    default:
                        break;

            }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return profile;
         }
         }
