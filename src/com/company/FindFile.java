package com.company;

//import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FindFile {

   private  File file = new File("C:\\");
   private  String path ="";
   private File scanDest;
   private List<File> nameList = new ArrayList<File>();

   public FindFile(){
       File dest = new File("scanResult");
       if(!dest.exists()) {
           dest.mkdir();
           scanDest = dest;
       }
           scanDest = dest;
       }


        public  void find(File fName) {
                File []listFiles = fName.listFiles();
                if(listFiles != null) {
                    for (File singleFile : listFiles) {
                        if (singleFile.isDirectory()) {
                            //System.out.println(singleFile.getPath());
                            find(singleFile);
                        } else if(singleFile.getName().endsWith(".txt")){
                            //copyFiles( scanDest,singleFile);
                            //System.out.println(singleFile.getPath());
                            fillList(singleFile);
                            printList(singleFile);
                        }
                    }
                }
        }

        public void copyFiles(File scanDest, File source){

            //FileUtils.copyDirectory(source, scanDest);
            if(source.exists()) {
                source.renameTo(new File("scanResult/newName.txt"));
                Path sourcePath = source.toPath();
                Path scanDestPath = scanDest.toPath();
                //Path newSourcePath;
                try {
                    Files.copy(scanDestPath, sourcePath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void fillList(File newFile){
            //List<File> nmList = nameList;
            nameList.add(newFile);
        }

        public void printList(File newFile){
            for(int i=0; i<nameList.size(); i++){
                System.out.println(nameList.get(i));
            }
        }




    }

