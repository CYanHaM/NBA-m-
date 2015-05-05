package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import dataservice.MatchDataService;
import PO.MatchPO;

public class MatchData implements MatchDataService{
	
	public ArrayList<MatchPO> read(){
		readFrom rf=new DataProcessing();
		ArrayList<MatchPO> mlist=new ArrayList<MatchPO>();
		mlist=rf.matchRead();

		return mlist;
		
	}
	
	
	public String showPresentTime(){
		String date=null;
		try {
			String encoding = "GBK";
			File file = new File("MatchData");
			File filelist[]=file.listFiles();
			ArrayList<String>info=new ArrayList<String>();
			InputStreamReader read = new InputStreamReader(new FileInputStream(filelist[filelist.length-1].getAbsolutePath()),encoding);
			BufferedReader bufferedReader = new BufferedReader(read);
			String line = null;
			while((line = bufferedReader.readLine())!=null) {
				info.add(line);
			}
			read.close();
			String[][]data=new String [info.size()][];
			for(int j=0;j<info.size();j++){
				data[j]=info.get(j).split(";");
			}
			String filename[]=filelist[filelist.length-1].getName().split("_");
			if(Integer.valueOf(filename[1].split("-")[0])<=7)
				date="20"+filename[0].split("-")[1]+"-"+filename[1];
			else
				date="20"+filename[0].split("-")[0]+"-"+filename[1];
			}catch(Exception e){
				System.out.println("读入操作出错");
				e.printStackTrace();
			}
		return date;
	}

}

