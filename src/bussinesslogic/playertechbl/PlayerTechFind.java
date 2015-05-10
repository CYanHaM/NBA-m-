package bussinesslogic.playertechbl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import bussinesslogic.Transfer.PlayerInfoTrans;
import bussinesslogic.Transfer.P2L.MPO2MVO;
import data.playerinfodata.PlayerInfoData;
import data.playertechdata.OperateWithFile;
import dataservice.playerinfodataservice.PlayerInfoDataService;
import PO.PlayerPO;
import PO.PlayerTechMPO;
import VO.PlayerTechMVO;
import VO.PlayerTechVO;
import VO.PlayerVO;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;

public class PlayerTechFind {
	ShowPlayerTech sh = new ShowPlayerTech();
	//返回所有球员的基本数据
	public ArrayList<PlayerNormalInfo> normalAll(boolean isTotal, String filter, 
				String sort,int n){
		ArrayList<PlayerNormalInfo> result = new ArrayList<PlayerNormalInfo>();
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		if(n==0) return result;
		ArrayList<PlayerTechVO> all = sh.showSeasonPlayerData();
		int size = all.size();
		//拆分field.value
		String[] filterTemp = filter.split(",");
		for(int s=0;s<size;s++){
			//field可能值为position，league，age
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
				all.clear();
				all.addAll(res);
				res.clear();
			}
		}
		
		/*开始排序*/
		String[] sortTemp = sort.split(",");
		int len = sortTemp.length;
		String[] sortField = new String[len];
		String[] sortBy = new String[len];
		for(int i=0;i<len;i++){
			String[] temp = sortTemp[i].split(".");
			sortField[i] = temp[0];
			sortBy[i] = temp[1];
		}
		
		Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){
			
			public int compare(PlayerTechVO v1, PlayerTechVO v2) {   
				int index = 1;
				switch(sortField[0]){
				case "point":
				{	boolean equ = (v1.score==v2.score);
					while(equ&&index<len){
						switch(sortField[index]){
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.rebound-v2.rebound;
								else
									return v2.rebound-v1.rebound;
							}
							index++;	break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.secondaryAttack-v2.secondaryAttack;
								else
									return v2.secondaryAttack-v1.secondaryAttack;
							}
							index++;	break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.blockShot-v2.blockShot;
								else
									return v2.blockShot-v1.blockShot;
							}
							index++;	break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.steal-v2.steal;
								else
									return v2.steal-v1.steal;
							}
							index++;	break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.foul-v2.foul;
								else
									return v2.foul-v1.foul;
							}
							index++;	break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.fault-v2.fault;
								else
									return v2.fault-v1.fault;
							}
							index++;	break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.time-v2.time;
								else
									return v2.time-v1.time;
							}
							index++;	break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								else
									return (v2.efficiency-v1.efficiency)>0?1:-1;
							}
							index++;	break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								else
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
							}
							index++;	break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								else
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
							}
							index++;	break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								else
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
							}
							index++;	break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc"))
									return v1.ifDouble-v2.ifDouble;
								else
									return v2.ifDouble-v1.ifDouble;
							}
							index++;	break;
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==1){
						if(sortBy[0].equals("asc"))
							return v1.score-v2.score;
						else
							return v2.score-v1.score;
					}
					if(equ)
						return v1.name.compareTo(v2.name);
					break;
				}
				case "rebound":
				{	boolean equ = (v1.rebound==v2.rebound);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.score-v2.score;
								else
									return v2.score-v1.score;
							}
							index++;	break;
						
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.secondaryAttack-v2.secondaryAttack;
								else
									return v2.secondaryAttack-v1.secondaryAttack;
							}
							index++;	break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.blockShot-v2.blockShot;
								else
									return v2.blockShot-v1.blockShot;
							}
							index++;break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.steal-v2.steal;
								else
									return v2.steal-v1.steal;
							}
							index++;	break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.foul-v2.foul;
								else
									return v2.foul-v1.foul;
							}
							index++;	break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.fault-v2.fault;
								else
									return v2.fault-v1.fault;
							}
							index++;	break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.time-v2.time;
								else
									return v2.time-v1.time;
							}
							index++;	break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								else
									return (v2.efficiency-v1.efficiency)>0?1:-1;
							}
							index++;	break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;	
								else
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
							}
							index++;break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								else
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
							}
							index++;	break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								else
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
							}
							index++;	break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.ifDouble-v2.ifDouble;
								else
									return v2.ifDouble-v1.ifDouble;
							}
							index++;	break;
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==1){
						if(sortBy[0].equals("asc"))
							return v1.score-v2.score;
						else
							return v2.score-v1.score;
					}
					if(equ)
						return v1.name.compareTo(v2.name);
					break;
				}	
				case "assist":
				{	boolean equ = (v1.secondaryAttack==v2.secondaryAttack);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.score-v2.score;
								else
									return v2.score-v1.score;
							}
							index++;break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.rebound-v2.rebound;
								else
									return v2.rebound-v1.rebound;
							}
							index++;break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.blockShot-v2.blockShot;
								else
									return v2.blockShot-v1.blockShot;
							}
							index++;break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.steal-v2.steal;
								else
									return v2.steal-v1.steal;
							}
							index++;break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.foul-v2.foul;
								else
									return v2.foul-v1.foul;
							}
							index++;break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.fault-v2.fault;
								else
									return v2.fault-v1.fault;
							}
							index++;break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.time-v2.time;
								else
									return v2.time-v1.time;
							}
							index++;break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){;
								if(sortBy[index].equals("asc"))
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								else
									return (v2.efficiency-v1.efficiency)>0?1:-1;
							}
							index++;break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								else
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
							}
							index++;break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								else
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
							}
							index++;break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								else
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
							}
							index++;break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.ifDouble-v2.ifDouble;
								else
									return v2.ifDouble-v1.ifDouble;
							}
							index++;break;
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==1){
						if(sortBy[0].equals("asc"))
							return v1.score-v2.score;
						else
							return v2.score-v1.score;
					}
					if(equ) return v1.name.compareTo(v2.name);
					break;
				}
					
				case "blockShot":
				{	boolean equ = (v1.blockShot==v2.blockShot);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.score-v2.score;
								else
									return v2.score-v1.score;
							}
							index++;break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.rebound-v2.rebound;
								else
									return v2.rebound-v1.rebound;
							}
							index++;break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.secondaryAttack-v2.secondaryAttack;
								else
									return v2.secondaryAttack-v1.secondaryAttack;
							}
							index++;break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.steal-v2.steal;
								else
									return v2.steal-v1.steal;
							}
							index++;break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.foul-v2.foul;
								else
									return v2.foul-v1.foul;
							}
							index++;break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.fault-v2.fault;
								else
									return v2.fault-v1.fault;
							}
							index++;break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.time-v2.time;
								else
									return v2.time-v1.time;
							}
							index++;break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								else
									return (v2.efficiency-v1.efficiency)>0?1:-1;
							}
							index++;break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								else
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
							}
							index++;break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								else
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
							}
							index++;break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								else
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
							}
							index++;break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.ifDouble-v2.ifDouble;
								else
									return v2.ifDouble-v1.ifDouble;
							}
							index++;break;
						default:System.out.println("wrong type");	
						}
					}//while ends
					if(index==1){
						if(sortBy[0].equals("asc"))
							return v1.score-v2.score;
						else
							return v2.score-v1.score;
					}
					if(equ) return v1.name.compareTo(v2.name);
					break;
				}
				case "steal":
					{	boolean equ = (v1.steal==v2.steal);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.score==v2.score);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return v1.score-v2.score;
									else
										return v2.score-v1.score;
								}
								index++;break;
							case "rebound":
								equ = (v1.rebound==v2.rebound);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return v1.rebound-v2.rebound;
									else
										return v2.rebound-v1.rebound;
								}
								index++;break;
							case "assist":
								equ = (v1.secondaryAttack==v2.secondaryAttack);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return v1.secondaryAttack-v2.secondaryAttack;
									else
										return v2.secondaryAttack-v1.secondaryAttack;
								}
								index++;break;
							case "blockShot":
								equ = (v1.blockShot==v2.blockShot);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return v1.blockShot-v2.blockShot;
									else
										return v2.blockShot-v1.blockShot;
								}
								index++;break;
							case "foul":
								equ = (v1.foul==v2.foul);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return v1.foul-v2.foul;
									else
										return v2.foul-v1.foul;
								}
								index++;break;
							case "fault":
								equ = (v1.fault==v2.fault);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return v1.fault-v2.fault;
									else
										return v2.fault-v1.fault;
								}
								index++;break;
							case "minute":
								equ = (v1.time==v2.time);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return v1.time-v2.time;
									else
										return v2.time-v1.time;
								}
								index++;break;
							case "efficient":
								equ = (v1.efficiency==v2.efficiency);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.efficiency-v2.efficiency)>0?1:-1;
									else
										return (v2.efficiency-v1.efficiency)>0?1:-1;
								}
								index++;break;
							case "shot":
								equ = (v1.shotInRate==v2.shotInRate);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.shotInRate-v2.shotInRate)>0?1:-1;
									else
										return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
								index++;break;
							case "three":
								equ = (v1.threeShotInRate==v2.threeShotInRate);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
									else
										return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
								index++;break;
							case "penalty":
								equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
									else
										return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
								index++;break;
							case "doubleTwo":
								equ = (v1.ifDouble==v2.ifDouble);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return v1.ifDouble-v2.ifDouble;
									else
										return v2.ifDouble-v1.ifDouble;
								}
								index++;break;
							default:System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[1].equals("asc"))
								return v1.score-v2.score;
							else
								return v2.score-v1.score;
						}
						if(equ) return v1.name.compareTo(v2.name);
						break;
					}
				case "foul":
				{	boolean equ = (v1.foul==v2.foul);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){;
								if(sortBy[index].equals("asc"))
									return v1.score-v2.score;
								else
									return v2.score-v1.score;
							}
							index++;break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.rebound-v2.rebound;
								else
									return v2.rebound-v1.rebound;
							}
							index++;break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.secondaryAttack-v2.secondaryAttack;
								else
									return v2.secondaryAttack-v1.secondaryAttack;
							}
							index++;break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.blockShot-v2.blockShot;
								else
									return v2.blockShot-v1.blockShot;
							}
							index++;break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.steal-v2.steal;
								else
									return v2.steal-v1.steal;
							}
							index++;break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.fault-v2.fault;
								else
									return v2.fault-v1.fault;
							}
							index++;break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.time-v2.time;
								else
									return v2.time-v1.time;
							}
							index++;break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								else
									return (v2.efficiency-v1.efficiency)>0?1:-1;
							}
							index++;break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								else
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
							}
							index++;break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								else
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
							}
							index++;break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								else
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
							}
							index++;break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								if(sortBy[index].equals("asc"))
									return v1.ifDouble-v2.ifDouble;
								else
									return v2.ifDouble-v1.ifDouble;
							}
							index++;break;
						default:System.out.println("wrong type");	
						}
					}//while ends
					if(index==1){
						if(sortBy[0].equals("asc"))
							return v1.score-v2.score;
						else
							return v2.score-v1.score;
					}
					if(equ)	return v1.name.compareTo(v2.name);
					break;
				}
				case "fault":
				{	boolean equ = (v1.fault==v2.fault);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;
							break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;
							break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;
							break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;
							break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;
							break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;
							break;
					
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.time-v2.time;
								}
								else{
									return v2.time-v1.time;
								}
							}
							index++;
							break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								}
								else{
									return (v2.efficiency-v1.efficiency)>0?1:-1;
								}
							}
							index++;
							break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.ifDouble-v2.ifDouble;
								}
								else{
									return v2.ifDouble-v1.ifDouble;
								}
							}
							index++;
							break;
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==0){
						String ord = sortBy[0];
						if(ord.equals("asc")){
							return v1.score-v2.score;
						}
						else{
							return v2.score-v1.score;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
					
				case "minute":
				{
					boolean equ = (v1.time==v2.time);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;
							break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;
							break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;
							break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;
							break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;
							break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;
							break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;
							break;
						
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								}
								else{
									return (v2.efficiency-v1.efficiency)>0?1:-1;
								}
							}
							index++;
							break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.ifDouble-v2.ifDouble;
								}
								else{
									return v2.ifDouble-v1.ifDouble;
								}
							}
							index++;
							break;
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==0){
						String ord = sortBy[0];
						if(ord.equals("asc")){
							return v1.score-v2.score;
						}
						else{
							return v2.score-v1.score;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				
				case "efficient":
				{
					boolean equ = (v1.efficiency==v2.efficiency);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;
							break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;
							break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;
							break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;
							break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;
							break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;
							break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;
							break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.time-v2.time;
								}
								else{
									return v2.time-v1.time;
								}
							}
							index++;
							break;
					
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.ifDouble-v2.ifDouble;
								}
								else{
									return v2.ifDouble-v1.ifDouble;
								}
							}
							index++;
							break;
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==0){
						String ord = sortBy[0];
						if(ord.equals("asc")){
							return v1.score-v2.score;
						}
						else{
							return v2.score-v1.score;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				
				//投篮命中率
				case "shot":
				{
					boolean equ = (v1.shotInRate==v2.shotInRate);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;
							break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;
							break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;
							break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;
							break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;
							break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;
							break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;
							break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.time-v2.time;
								}
								else{
									return v2.time-v1.time;
								}
							}
							index++;
							break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								}
								else{
									return (v2.efficiency-v1.efficiency)>0?1:-1;
								}
							}
							index++;
							break;
					
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.ifDouble-v2.ifDouble;
								}
								else{
									return v2.ifDouble-v1.ifDouble;
								}
							}
							index++;
							break;
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==0){
						String ord = sortBy[0];
						if(ord.equals("asc")){
							return v1.score-v2.score;
						}
						else{
							return v2.score-v1.score;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				//三分命中率
				case "three":
				{
					boolean equ = (v1.threeShotInRate==v2.threeShotInRate);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;
							break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;
							break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;
							break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;
							break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;
							break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;
							break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;
							break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.time-v2.time;
								}
								else{
									return v2.time-v1.time;
								}
							}
							index++;
							break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								}
								else{
									return (v2.efficiency-v1.efficiency)>0?1:-1;
								}
							}
							index++;
							break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;
							break;
					
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.ifDouble-v2.ifDouble;
								}
								else{
									return v2.ifDouble-v1.ifDouble;
								}
							}
							index++;
							break;
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==0){
						String ord = sortBy[0];
						if(ord.equals("asc")){
							return v1.score-v2.score;
						}
						else{
							return v2.score-v1.score;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					
					break;
				}
						
				//罚球命中率
				case "penalty":
				{
					boolean equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;
							break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;
							break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;
							break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;
							break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;
							break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;
							break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;
							break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.time-v2.time;
								}
								else{
									return v2.time-v1.time;
								}
							}
							index++;
							break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								}
								else{
									return (v2.efficiency-v1.efficiency)>0?1:-1;
								}
							}
							index++;
							break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						
						case "doubleTwo":
							equ = (v1.ifDouble==v2.ifDouble);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.ifDouble-v2.ifDouble;
								}
								else{
									return v2.ifDouble-v1.ifDouble;
								}
							}
							index++;
							break;
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==0){
						String ord = sortBy[0];
						if(ord.equals("asc")){
							return v1.score-v2.score;
						}
						else{
							return v2.score-v1.score;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				//两双
				case "doubleTwo":
				{
					boolean equ = (v1.ifDouble==v2.ifDouble);
					while(equ&&index<len){
						switch(sortField[index]){
						case "point":
							equ = (v1.score==v2.score);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;
							break;
						case "rebound":
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;
							break;
						case "assist":
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;
							break;
						case "blockShot":
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;
							break;
						case "steal":
							equ = (v1.steal==v2.steal);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;
							break;
						case "foul":
							equ = (v1.foul==v2.foul);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;
							break;
						case "fault":
							equ = (v1.fault==v2.fault);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;
							break;
						case "minute":
							equ = (v1.time==v2.time);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return v1.time-v2.time;
								}
								else{
									return v2.time-v1.time;
								}
							}
							index++;
							break;
						case "efficient":
							equ = (v1.efficiency==v2.efficiency);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.efficiency-v2.efficiency)>0?1:-1;
								}
								else{
									return (v2.efficiency-v1.efficiency)>0?1:-1;
								}
							}
							index++;
							break;
						case "shot":
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "three":
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
						case "penalty":
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								String ord = sortBy[index];
								if(ord.equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;
							break;
					
						default:
							System.out.println("wrong type");	
						}
					}//while ends
					if(index==0){
						String ord = sortBy[0];
						if(ord.equals("asc")){
							return v1.score-v2.score;
						}
						else{
							return v2.score-v1.score;
						}	
					}
					if(equ) return v1.name.compareTo(v2.name);
				}
				default: System.out.println("wrong type");
				}
				//未经过所有分支
				System.out.println("未经过所有分支，wrong field");
				return 0;
			}
		}; 
		Collections.sort(res, comparator);
		int sz = res.size();
		for(int i=0;i<sz;i++){
			PlayerTechVO vo = res.get(i);
			PlayerNormalInfo in = new PlayerNormalInfo();
			in.setName(vo.name);
			PlayerVO info = findInfo(vo.name);
			in.setAge(info.age);
			in.setTeamName(vo.team);
			in.setNumOfGame(vo.gameNum);
			in.setStart(vo.startingNum);
			in.setEfficiency(vo.efficiency);
			in.setShot(vo.shotInRate);
			in.setThree(vo.threeShotInRate);
			in.setPenalty(vo.penaltyShotInRate);
			if(isTotal){
				in.setRebound(vo.rebound);
				in.setAssist(vo.secondaryAttack);
				in.setMinute(vo.time);
				in.setOffend(vo.offensiveNum);
				in.setDefend(vo.defensiveNum);
				in.setSteal(vo.steal);
				in.setBlockShot(vo.blockShot);
				in.setFault(vo.fault);
				in.setFoul(vo.foul);
				in.setPoint(vo.score);	
			}else{
				in.setRebound(vo.reboundave);
				in.setAssist(vo.secondaryAttackave);
				in.setMinute(vo.timeave);
				in.setOffend(vo.offensiveNumave);
				in.setDefend(vo.defensiveNumave);
				in.setSteal(vo.stealave);
				in.setBlockShot(vo.blockShotave);
				in.setFault(vo.faultave);
				in.setFoul(vo.foulave);
				in.setPoint(vo.scoreave);
			}
			result.add(in);
		}
		return result;
	}
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