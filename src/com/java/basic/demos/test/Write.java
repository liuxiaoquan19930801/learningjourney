package com.java.basic.demos.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
	
	String pathString = null;
	File file = null;
	FileOutputStream outstr = null;
	
	public void WriteToFlie(String path,String contents){
		try{
			if(file == null){
				file = new File(path);
			}
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(outstr == null){
				outstr = new FileOutputStream(file);
			}
			byte[] contentsBytes = contents.getBytes();
			outstr.write(contentsBytes);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void closeOutputStream(){
		if(outstr != null){
			try {
				outstr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void cutBigFile(String sourceFile,String targetPath,int fileCount) throws IOException{
		FileReader sourcefile = new FileReader(sourceFile);
		BufferedReader reader = new BufferedReader(sourcefile);
		//ÿ���ļ��Ĵ�С\��֪Ŀ��1����
		int rowsTotal = 100000000;
		//�����ֽ�����
		//byte[] bytearr = new byte[50];
		//����ļ�·�����ļ���
		
		
		String str;
		for(int i=1;i<fileCount+1;i++){
			String filename = "randomFiles" + i + ".txt";
			//ÿ���ļ�������
			BufferedWriter desfile = new BufferedWriter(new FileWriter(targetPath + filename));
			for(int j=0;j<rowsTotal/fileCount;j++){
				if(!(str = reader.readLine()).equals("")){
					desfile.write(str);
					desfile.newLine();
				}
			}
			desfile.flush();
			desfile.close();
		}
	}

}
