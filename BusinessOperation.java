package com.LockersMe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
public class BusinessOperation 
{
	static void exit() {
	        System.exit(1);
	}
	
	//All methods here 
	static void listDownAllFiles() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your directory path :");
		System.out.println();
		String paths = sc.nextLine();
		File file  = new File(paths);
		String []dataarray  = file.list();
		for(int i=0; i<dataarray.length; i++)
		{
			System.out.println(dataarray[i]);
		}
		System.out.println();
		mainParttocall();
		
	}
		static void mainParttocall() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		  mainMenu();	
		  System.out.print("Enter your choice: ");
		  int ch  = sc.nextInt();
		  if(ch==1)
		  {
			  listDownAllFiles();
		  }
		  else if(ch==2)
		  {
		  System.out.println("1.Add file  2.Delete file  3.Search file  4.Move to Parent");
		   System.out.print("Enter your choice :");
		   int operationchoice  = sc.nextInt();
		businessOperations(operationchoice);
		  }
		  else if (ch==3)
		  {
			 exit();
		  }
		  else
		  {
			  System.out.println("Invalid user input !!!");
			  mainParttocall();
		  }
	}
			static void moveToParent() throws IOException
	{
		
		mainParttocall();
		
	}
				static void callBusinessOperation() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		 System.out.println("1.Add file  2.Delete file  3.Search file  4.Move to Parent");
		   System.out.println("You want go again :");
		   int value = sc.nextInt();
		   businessOperations(value);
	}
					static void searchFile()
      {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your directory where to want to search: ");
		String directoryname = sc.nextLine();
		File filedirectory = new File(directoryname);
		
		System.out.print("Enter Your file Name :");
		String filename = sc.nextLine();
		SearchFile searchfile = new SearchFile(filename);
		
		String [] flist = filedirectory.list(searchfile);
		if(flist == null)
		{
			System.out.println("  empty directory or directory doesn't exist ");
		}
		else
		{
			for(int i=0; i<flist.length;i++)
			{
			System.out.println(flist[i]+" File found");
			}
		}
	}
				static void deletefile(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your file name: ");
		String filename = sc.nextLine();
		
		System.out.print("Enter your file path: ");
		String pathoffile = sc.nextLine();
		
		String totalpaths = pathoffile+"\\"+filename;
		File file = new File(totalpaths);
		
		boolean value = file.delete();
		if(value)
		{
			System.out.println("File successfully deleted !!!");
		}
		else
		{
			System.out.println("File doesn't exist in diroctory or not valid directory ");
		}
	}
			static void addfile() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		 System.out.println("Hii add your file here ");
	  	   
	   	  System.out.println("Enter Your File Name: ");
	   	  String filename = sc.nextLine();
	   	  
	   	  System.out.println("Please add your Path to file :");
	   	  String pathfile = sc.nextLine();
	   	  
	   	  String totalpath = pathfile+"\\"+filename;
	   	 FileOutputStream  fileoutputstream = null;
	   	  try {
	   	   fileoutputstream = new FileOutputStream(totalpath,true);
	   	  }
	   	  catch(Exception e)
	   	  {
	   		  System.out.println("please provide valid path or file name ");
	   	  }
	   	  System.out.print("Please Enter your content :");
	 
	   	  String content = sc.nextLine();
	   	  
	   	 if(!filename.isEmpty() && fileoutputstream!=null)
	   	  {
	   	  byte b[] = content.getBytes();
	   	  fileoutputstream.write(b);
	   	  fileoutputstream.close();
	   	  System.out.println("File created successfully ");
	   	if(content.isEmpty())
	   	 {
	   		 System.out.println("But Nothing data have saved !!!");
	   	 }
	   	 
	   	  
	   	  }
	   	 
	   	  else
	   	  {
	   		 System.out.println("Please provide file name or directory name or both ");
	   	  }
	}
		static void mainMenu()
	{
		System.out.println("     		 	Welcome to LockersMe.com ");
		System.out.println();
	    System.out.println("1.List Down All files     2.Business Operations    3.Close Application");
	}
	static void businessOperations(int valueenter) throws IOException
	{
	   Scanner sc = new Scanner(System.in);
	   switch(valueenter)
	   {
	   case 1:
		   addfile();
		   callBusinessOperation();
	   	   break;
	   case 2:
		   deletefile();
		   callBusinessOperation();
		   break; 
		   
	   case 3:
		   searchFile();
		   callBusinessOperation();
	   
	   case 4:
		   moveToParent();
		   callBusinessOperation();
		   
		   default:
			   System.out.println("exit");
	   	  
	   }
	}
	
	public static void main(String[] args) throws IOException {
	
		mainParttocall();
		searchFile();
	
		  
	}}
class SearchFile implements FilenameFilter
{
String initials;
public SearchFile(String initials){
	this.initials = initials;
}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub	
		return name.startsWith(initials);
	}
}