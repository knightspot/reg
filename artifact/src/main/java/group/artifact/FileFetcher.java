package group.artifact;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class FileFetcher {
	private String name;
	private String fileName = "" ;
	private BufferedReader buffer = null;


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		if ( buffer != null ){
			try {
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		loadBuffer();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void print() {
		System.out.println("Hello ! " + name);
		
	}
	
	public String fetch(){
		String str = "";
		if ( buffer == null ){
			buffer = getBuffer();
		}
		try {
			str =  getBuffer().readLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}
		return str;
	}
	
	private BufferedReader getBuffer(){
		return buffer;
	}
	
	private void loadBuffer() {
		Reader reader = null;
		if ( buffer != null ){
			try {
				buffer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		try {
			reader = new FileReader(getFileName());
		} catch (FileNotFoundException e) {
			System.out.println("No file with name:" + fileName);
			reader = new StringReader("");
		}
		buffer = new BufferedReader(reader);
	}
}
