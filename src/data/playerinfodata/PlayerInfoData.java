package data.playerinfodata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import PO.PlayerPO;
import data.DataProcessing;
import data.readFrom;
import data.playertechdata.OperateWithFile;
import dataservice.playerinfodataservice.PlayerInfoDataService;

public class PlayerInfoData implements PlayerInfoDataService {

	public PlayerPO findOne(String name) {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> list = new ArrayList<PlayerPO>(); 
		try{
			FileInputStream fis = new FileInputStream("database/Player.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        list =  (ArrayList<PlayerPO>) ois.readObject();
	        ois.close();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		int size = list.size();
		for(int i=0;i<size;i++){
			if(list.get(i).name.equals(name)){
				return list.get(i);
			}
		}
		return null;
	}

	public void write(String dataSource){
		readFrom rf  = new DataProcessing(dataSource);
		ArrayList<PlayerPO> po = rf.playerRead();
		FileOutputStream fos;
        try {
            fos = new FileOutputStream("database/Player.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(po);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}	
	
	public static void main(String[] args){
		PlayerInfoData pi = new PlayerInfoData();
		pi.write("matchData");
		OperateWithFile owf = new OperateWithFile();
		owf.write("matchData");
		
		
	}

}
