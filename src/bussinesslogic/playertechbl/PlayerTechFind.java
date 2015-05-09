package bussinesslogic.playertechbl;

import java.util.ArrayList;
import java.util.Iterator;

import bussinesslogic.Transfer.PlayerInfoTrans;
import data.playerinfodata.PlayerInfoData;
import data.playertechdata.Find;
import dataservice.playerinfodataservice.PlayerInfoDataService;
import dataservice.playertechdataservice.FindDataService;
import PO.PlayerPO;
import VO.PlayerTechVO;
import VO.PlayerVO;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;

public class PlayerTechFind {
	//位置筛选考虑多位置和没位置的
	ShowPlayerTech sh = new ShowPlayerTech();
	//返回所有球员的基本数据
	public ArrayList<PlayerNormalInfo> normalAll(String aveOrAll, String filter, 
				String sort){
		//获得所有球员数据
		ArrayList<PlayerTechVO> all = sh.showSeasonPlayerData();
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		int size = all.size();
		//拆分field.value
		String[] filterTemp = filter.split(",");
		for(int s=0;s<size;s++){
			/*
			 * field可能值为position，league，age
			 * temp[0]为field
			 * temp[1]为值：
			 * position：F、G、C、All(默认)
			 * league:West,East,All(默认)
			 * age: x<=22, 22<x<=25, 25<x<=30, x>30, All(默认)
			 */
			PlayerTechVO vo = all.get(s);
			for(int i=0;i<filterTemp.length;i++){
				String[] temp = filterTemp[i].split(".");
				switch(temp[0]){
					case "position":
						if(temp[1].equals("All")){
							res.addAll(all);
							break;
						}
						//如果根据姓名检索不到球员基本信息，则跳过对该球员的处理
						PlayerVO info = findInfo(vo.name);
						if(info==null)
							break;
						vo.position = info.position;
						//考虑有两个位置的球员
						String[] pos = vo.position.split("-");
						for(int m=0;m<pos.length;m++){
							if(pos[m].equals(temp[1])){
								res.add(vo);
								break;
							}
						}
						break;
					case "league":
						if(temp[1].equals("All")){
							res.addAll(all);
							break;
						}
						if(temp[1].equals("East")){
							if(vo.division.equals("E")) res.add(vo);
						}else{
							if(vo.division.equals("W")) res.add(vo);
						}
						break;
					case "age":
						if(temp[1].equals("All")){
							res.addAll(all);
							break;
						}
						PlayerVO pl = findInfo(vo.name);
						if(pl==null)
							break;
						if(temp[1].equals("<=22")){
							if(pl.age<=22){
								res.add(vo);
								break;
							}
						}
						if(temp[1].equals("22<X<=25")){
							if(pl.age<=25&&pl.age>22){
								res.add(vo);
								break;
							}
						}
						if(temp[1].equals("25<X<=30")){
							if(pl.age<=30&&pl.age>25){
								res.add(vo);
								break;
							}
						}
						if(temp[1].equals(">30")){
							if(pl.age>30){
								res.add(vo);
								break;
							}
						}
						break;
					default: 
						System.out.println("wrong type");
				}
			}
		}
		all.clear();
		
		return null;
	}
	//返回所有球员的高阶数据,默认ave，不过滤
	public ArrayList<PlayerHighInfo> highAll(String sort){
		return null;
	}
	
	//获得热门球员（进步最快球员），所有数据为Ave
	//field可为score，rebound，assist
	public ArrayList<PlayerHotInfo> findHotPlayer(String field){
		return null;
	}

	//获得赛季数据王
	public ArrayList<PlayerKingInfo> findSeasonKingPlayer(String field){
		return null;
	}
	
	//获得当天数据王
	public ArrayList<PlayerNormalInfo> findTodayKingPlayer(String field, int number){
		return null;
	}
	
	
	//辅助方法
	public PlayerVO findInfo(String name) {
		// TODO Auto-generated method stub
		PlayerInfoDataService fd = new PlayerInfoData();
		PlayerPO po = fd.findOne(name);
		if(po==null) 
			return null;
		else{
			PlayerInfoTrans tr = new PlayerInfoTrans();
			PlayerVO vo = tr.po2vo(po);
			return vo;
		}
	}
	
}
