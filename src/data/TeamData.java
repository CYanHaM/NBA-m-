package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.TeamPO;
import dataservice.TeamDataService;

public class TeamData implements TeamDataService, Serializable{

	readFrom rf = new DataProcessing();
	File file = new File("database/team.ser");

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void WriteIn(){
		readFrom init = new DataProcessing();
		ArrayList<TeamPO> list = new ArrayList<TeamPO>();
		list = rf.teamRead();
		try{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			oos.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	ArrayList<TeamPO> read(){
		ArrayList<TeamPO> result = new ArrayList<TeamPO>();
		try{
            FileInputStream fis = new FileInputStream("database/team.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
			result.clear();
			result = (ArrayList<TeamPO>)ois.readObject();
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
	}
	
	@Override
	public TeamPO find(TeamPO tpo) throws RemoteException {
		ArrayList<TeamPO> list = new ArrayList<TeamPO>();
		list = read();
		for(TeamPO ttpo : list){
			if(tpo.abbreviation.equals(ttpo.abbreviation)){
				return ttpo;
			}
		}
		return null;
	}

}
