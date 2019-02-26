package com.company;

import com.company.FindFile;

import java.io.File;



public class Main {



    public static void main(String[] args) {
        // write your code here

        //List fileList = new ArrayList<String>();
        /*File file[] = File.listRoots();
        for (File files:file ) {
            System.out.println(files);
           if(files.getName().contains(".docx")==true){
               System.out.println(files.getAbsolutePath());
           }
            if(files.isDirectory()==true){

            }
        }
        */

        FindFile obj = new FindFile();
        obj.find(new File("C:\\"));
    }
    }





