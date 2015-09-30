package com.verizon.hackathon.util;

import java.io.File;

public class HackathonUtil {
	
	public static String reverseString(String input){
		String reverse = "";
		int stringsize = input.length();
				for(int i=stringsize-2;i > -1;i--){
					reverse = reverse + input.charAt(i);	
				}
				return reverse;
	}
	
	public static String getProfileName(String path){
		File folder = new File("C:/Users/Administrator/AppData/Roaming/Mozilla/Firefox/Profiles/");
		File[] listOfFiles = folder.listFiles();
		String profileName = ".default";
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isDirectory()) {
		    	  if(listOfFiles[i].getName().indexOf(".default") > -1 ){
		    		  profileName = listOfFiles[i].getName();  
		    	  }
		      }
		      
		    }
		    return profileName;
	}

}
