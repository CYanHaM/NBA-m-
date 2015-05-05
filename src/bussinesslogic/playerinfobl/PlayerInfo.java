package bussinesslogic.playerinfobl;

import java.util.ArrayList;
import java.util.Iterator;

import data.playerinfodata.PlayerInfoData;
import dataservice.playerinfodataservice.PlayerInfoDataService;
import PO.PlayerPO;
import VO.PlayerTechVO;
import VO.PlayerVO;
import blservice.playerinfoblservice.PlayerInfoService;
import bussinesslogic.Transfer.playerinfotrans.PO2VO;
import bussinesslogic.playertechbl.ShowPlayerTech;

public class PlayerInfo implements PlayerInfoService {
	
	public static void main(String[] args){
		PlayerInfo pi = new PlayerInfo();
		PlayerVO res = pi.showPlayerInfo("Arnett Moultrie");
		System.out.println(res.name+" "+res.position+" "+res.uniformNum);
		
	}

	PlayerInfoDataService fp = new PlayerInfoData();
	PO2VO p2v = new PO2VO();
	
	@Override
	public ArrayList<PlayerVO> showAllPlayerInfo() {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> po = fp.findAll();
		ArrayList<PlayerVO> vo =  p2v.list2vo(po);
		return vo;
	}

	@Override
	public PlayerVO showPlayerInfo(String name) {
		// TODO Auto-generated method stub
		PlayerPO po = fp.findOne(name);   System.out.println(name); System.out.println(po);
		if(po==null) 
			return null;
		else{
			PlayerVO vo = p2v.po2vo(po);
			return vo;
		}
	}

	@Override
	public ArrayList<PlayerVO> findPlayerByLetter(char letter) {
		// TODO Auto-generated method stub
		ArrayList<PlayerVO> all = showAllPlayerInfo();
		ArrayList<PlayerVO> res = new ArrayList<PlayerVO>();
		int size = all.size();
		for(int i=0;i<size;i++){
			if(all.get(i).name.charAt(0)==letter)
				res.add(all.get(i));
		}
		return res;
	}

	@Override
	public ArrayList<PlayerVO> findByTeam(String team) {
		// TODO Auto-generated method stub
		ShowPlayerTech sh = new ShowPlayerTech();
		ArrayList<PlayerTechVO> tech = sh.showSeasonPlayerData();
		ArrayList<PlayerVO> res = new ArrayList<PlayerVO>();
		int s = tech.size();
		for(int i=0;i<s;i++){
			if(tech.get(i).team.equals(team)){
				res.add(showPlayerInfo(tech.get(i).name));
			}
		}
		Iterator<PlayerVO> it = res.iterator();
		while(it.hasNext()){
			if(it.next()==null){
				it.remove();
			}
		}
		return res;
	}

	@Override
	public void PlayerInfoIni() {
		// TODO Auto-generated method stub
		fp.write();
	}

}
