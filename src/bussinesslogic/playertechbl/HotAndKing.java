package bussinesslogic.playertechbl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import PO.PlayerTechMPO;
import VO.PlayerTechMVO;
import VO.PlayerTechVO;
import bussinesslogic.Transfer.P2L.MPO2MVO;
import data.playertechdata.OperateWithFile;

public class HotAndKing {
	ShowPlayerTech sh = new ShowPlayerTech();
	//获得热门球员（进步最快球员），所有数据为Ave
	//field可为score，rebound，assist
	public ArrayList<PlayerHotInfo> findHotPlayer(String field,int number){
		ArrayList<PlayerHotInfo> result = new ArrayList<PlayerHotInfo>();
		ArrayList<PlayerTechVO> list = sh.showSeasonPlayerData();
		list = sortImproving(list,field);
		for(int i=0;i<number;i++){
			PlayerHotInfo info = new PlayerHotInfo();
			PlayerTechVO vo = list.get(i);
			info.setName(vo.name);
			info.setTeamName(vo.team);
			//======================================================还有历史问题
			info.setPosition(vo.position);
			info.setField(field);
			switch(field){
			case "score":
				info.setValue(vo.scoreave);
				info.setUpgradeRate(vo.scoreImproving);
				break;
			case "rebound":
				info.setValue(vo.reboundave);
				info.setUpgradeRate(vo.reboundImproving);
				break;
			case "assist":
				info.setValue(vo.secondaryAttackave);
				info.setUpgradeRate(vo.secondaryAttackImproving);
			}
			result.add(info);
		}
		return result;
	}
	//获得赛季数据王
	public ArrayList<PlayerKingInfo> findSeasonKingPlayer(String field, int number){
		ArrayList<PlayerKingInfo> result = new ArrayList<PlayerKingInfo>();
		ArrayList<PlayerTechVO> list = sh.showSeasonPlayerData();
		list = sortSeason(list,field);
		for(int i=0;i<number;i++){
			PlayerKingInfo info = new PlayerKingInfo();
			PlayerTechVO vo = list.get(i);
			info.setName(vo.name);
			info.setTeamName(vo.team);
			//======================================================还有历史问题
			info.setPosition(vo.position);
			info.setField(field);
			switch(field){
			case "score":
				info.setValue(vo.scoreave);
				break;
			case "rebound":
				info.setValue(vo.reboundave);
				break;
			case "assist":
				info.setValue(vo.secondaryAttackave);
			}
			result.add(info);
		}
		return result;
	}	
	//获得当天数据王
	public ArrayList<PlayerKingInfo> findTodayKingPlayer(String field, int number){
		ArrayList<PlayerKingInfo> result = new ArrayList<PlayerKingInfo>();
		OperateWithFile owf = new OperateWithFile();
		ArrayList<PlayerTechMPO> temp = owf.readMPO();
		MPO2MVO p2v = new MPO2MVO();
		ArrayList<PlayerTechMVO> list = p2v.list2vo(temp); 
		list = sortToday(list,field);
		for(int i=0;i<number;i++){
			PlayerKingInfo info = new PlayerKingInfo();
			PlayerTechMVO vo = list.get(i);
			info.setName(vo.name);
			info.setTeamName(vo.team);
			//======================================================还有历史问题
			info.setPosition(vo.position);
			info.setField(field);
			switch(field){
			case "score":
				info.setValue(vo.score);
				break;
			case "rebound":
				info.setValue(vo.rebound);
				break;
			case "assist":
				info.setValue(vo.secondaryAttack);
			}
			result.add(info);
		}
		return result;
	}
	
	public ArrayList<PlayerTechVO> sortSeason(ArrayList<PlayerTechVO> list, String field){
		Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){  
			public int compare(PlayerTechVO v1, PlayerTechVO v2) {   
				
				switch(field){
				
				case "score":
					if(v1.score==v2.score)
						return v1.name.compareTo(v2.name);
					else
						return v2.score-v1.score;
				
				case "rebound":
					if(v1.rebound==v2.rebound)
						return v1.name.compareTo(v2.name);
					else
						return v2.rebound-v1.rebound;
					
				case "assist":
					if(v1.secondaryAttack==v2.secondaryAttack)
						return v1.name.compareTo(v2.name);
					else
						return v2.secondaryAttack-v1.secondaryAttack;
					
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		Collections.sort(list, comparator);
		return list;
	}
	public ArrayList<PlayerTechMVO> sortToday(ArrayList<PlayerTechMVO> list, String field){
		Comparator<PlayerTechMVO> comparator = new Comparator<PlayerTechMVO>(){  
			public int compare(PlayerTechMVO v1, PlayerTechMVO v2) {   
				
				switch(field){
				
				case "score":
					if(v1.score==v2.score)
						return v1.name.compareTo(v2.name);
					else
						return v2.score-v1.score;
				
				case "rebound":
					if(v1.rebound==v2.rebound)
						return v1.name.compareTo(v2.name);
					else
						return v2.rebound-v1.rebound;
					
				case "assist":
					if(v1.secondaryAttack==v2.secondaryAttack)
						return v1.name.compareTo(v2.name);
					else
						return v2.secondaryAttack-v1.secondaryAttack;
					
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		Collections.sort(list, comparator);
		return list;
	}
	public ArrayList<PlayerTechVO> sortImproving(ArrayList<PlayerTechVO> list, String field){
		Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){  
			public int compare(PlayerTechVO v1, PlayerTechVO v2) {   
				
				switch(field){
				
				case "score":
					if(v1.score==v2.score)
						return v1.name.compareTo(v2.name);
					else
						return (v2.scoreImproving-v1.scoreImproving)>0?1:-1;
				
				case "rebound":
					if(v1.rebound==v2.rebound)
						return v1.name.compareTo(v2.name);
					else
						return (v2.reboundImproving-v1.reboundImproving)>0?1:-1;
					
				case "assist":
					if(v1.secondaryAttack==v2.secondaryAttack)
						return v1.name.compareTo(v2.name);
					else
						return (v2.secondaryAttackImproving-v1.secondaryAttackImproving)>0?1:-1;
					
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		Collections.sort(list, comparator);
		return list;
	}
}
