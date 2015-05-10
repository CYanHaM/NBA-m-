package data.playertechdata;

import java.util.ArrayList;

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

}
