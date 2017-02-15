package group.artifact;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {
	private static final int BUFFER = 1024;
	private String zipFileName;

	public String getZipFileName() {
		return zipFileName;
	}

	public void setZipFileName(String zipFileName) {
		this.zipFileName = zipFileName;
	}

	private ZipOutputStream out;

	public void BeginZip() throws FileNotFoundException {
		FileOutputStream dest = new FileOutputStream(zipFileName);
		out = new ZipOutputStream(new BufferedOutputStream(dest));
	}

	public void AddEntry(String entry) throws IOException {
		out.putNextEntry(new ZipEntry(entry));
	}

	public void WriteToEntry(String in) throws IOException {

		byte[] data = in.getBytes();
		out.write(data);
	}
	
	public void EndZip() throws IOException{
		out.close();
	}
	
	
}
