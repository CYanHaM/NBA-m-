package data.playertechdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import dataservice.playertechdataservice.ShowDataService;

public class Show implements ShowDataService {

	public static void main(String[] args){
		Show sh = new Show();
	/*ArrayList<PlayerTechPO> all = sh.showSeasonPlayerData();
		for(int i=0;i<30;i++){
			PlayerTechPO mpo = all.get(i);
			System.out.println(mpo.name+" "+mpo.blockShot+" "+mpo.blockShotRate+" "+mpo.team);
		}*/
		
	/*
		PlayerTechPO po = sh.showKeyData("DeMarre Carroll", "ATL");
		System.out.println(po.name+" "+po.blockShotRate+" "+po.team);
		*/
	/*	ArrayList<PlayerTechPO> all = sh.ascend("blockshot");
		for(int i=400;i<430;i++){
			PlayerTechPO mpo = all.get(i);
			System.out.println(mpo.name+" "+mpo.blockShot+" "+mpo.blockShotRate+" "+mpo.team);
		}*/
	
	}
	OperateWithFile owf = new OperateWithFile();
	@Override
	public ArrayList<PlayerTechPO> showSeasonPlayerData() {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = owf.readPO();
		return list;
	}

	@Override
	public PlayerTechPO showKeyData(String name, String team) {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = owf.readPO();
		int size = list.size();
		for(int i=0;i<size;i++){
			PlayerTechPO po = list.get(i);
			if(po.name.equals(name)&&po.team.equals(team))
				return po;
		}
		return null;
	}
	
	public void refresh(){
		owf.write();
	}

}
