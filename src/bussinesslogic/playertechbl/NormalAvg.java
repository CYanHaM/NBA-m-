package bussinesslogic.playertechbl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import test.data.PlayerNormalInfo;
import PO.PlayerPO;
import VO.PlayerTechVO;
import VO.PlayerVO;
import bussinesslogic.Transfer.PlayerInfoTrans;
import data.playerinfodata.PlayerInfoData;
import dataservice.playerinfodataservice.PlayerInfoDataService;

public class NormalAvg {
	
	public static void main(String[] args){
		NormalAvg na = new NormalAvg();
//		ArrayList<PlayerNormalInfo> res = na.normalAll("age.22<X<=25", "point.desc,rebound.desc", 50);
	//	for(PlayerNormalInfo i:res){
		//	System.out.println(i.getName()+" "+i.getPoint()+" "+i.getRebound());
	//	}
	}
	ShowPlayerTech sh = new ShowPlayerTech();
	
	public ArrayList<PlayerNormalInfo> normalAll(String filter, 
				String sort,int n){
		ArrayList<PlayerNormalInfo> result = new ArrayList<PlayerNormalInfo>();
		ArrayList<PlayerTechVO> all = sh.showSeasonPlayerData();
		if(filter!=null){
			Iterator<PlayerTechVO> it = all.iterator();
			
			String[] filterTemp = filter.split(","); //System.out.println(filterTemp.length);
			while(it.hasNext()){
				//field����ֵΪposition��league��age
				PlayerTechVO vo = it.next();
				for(int i=0;i<filterTemp.length;i++){
					String[] temp = filterTemp[i].split("\\."); 
					boolean rm = false;
					switch(temp[0]){
						case "position":
							if(temp[1].equals("All")){
								break;
							}
							//���������������������Ա������Ϣ���������Ը���Ա�Ĵ���
							PlayerVO info = findInfo(vo.name);
							if(info==null)
								break;
							vo.position = info.position;
							//����������λ�õ���Ա
							boolean fit= false;
							String[] pos = vo.position.split("-");
							for(int m=0;m<pos.length;m++){
								if(pos[m].equals(temp[1])){
									fit=true;
								}
							}
							if(!fit) {it.remove();rm=true;}
							break;
						case "league": 
							if(temp[1].equals("All")){
								break;
							}
							if(temp[1].equals("East")){
								if(!vo.division.equals("E")){ it.remove();rm=true;}
							}else{
								if(!vo.division.equals("W")) {it.remove();rm=true;}
							}
							
							break;
						case "age":
							if(temp[1].equals("All")){
								break;
							}
							PlayerVO pl = findInfo(vo.name);
							if(pl==null){
								it.remove();
								rm=true;
								break;
							}
							boolean age = false;
							if(temp[1].equals("<=22")){
								if(pl.age<=22){
									age = true;
									break;
								}
							}
							if(temp[1].equals("22<X<=25")){
								if(pl.age<=25&&pl.age>22){
									age = true;
									break;
								}
							}
							if(temp[1].equals("25<X<=30")){
								if(pl.age<=30&&pl.age>25){
									age=true;
									break;
								}
							}
							if(temp[1].equals(">30")){
								if(pl.age>30){
									age=true;
									break;
								}
							}
							if(!age) {it.remove();rm=true;}
							break;
						default: 
							System.out.println("wrong type");
					}
					if(rm) break;
				}
			}
		}
		
		/*��ʼ����*/
		if(sort==null){
			Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){
				public int compare(PlayerTechVO v1, PlayerTechVO v2) {
					if(v1.scoreave==v2.scoreave)
						return v1.name.compareTo(v2.name);
					else
						return (v2.scoreave-v1.scoreave)>0?1:-1;
					}
			};
			Collections.sort(all,comparator);
		}else{	
			String[] sortTemp = sort.split(",");
			int len = sortTemp.length;
			String[] sortField = new String[len];
			String[] sortBy = new String[len];
			for(int i=0;i<len;i++){
				String[] temp = sortTemp[i].split("\\.");
				sortField[i] = temp[0];
				sortBy[i] = temp[1];
			}
			Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){	
				public int compare(PlayerTechVO v1, PlayerTechVO v2) {   
					int index = 1;
					switch(sortField[0]){
					case "point":
					{	boolean equ = (v1.scoreave==v2.scoreave);
						while(equ&&index<len){
							switch(sortField[index]){
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;	break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;	break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;	break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;	break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;	break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;	break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(equ)
							return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.scoreave-v2.scoreave)>0?1:-1;
							else
								return (v2.scoreave-v1.scoreave)>0?1:-1;
						}
						break;
					}
					case "rebound":
					{	boolean equ = (v1.reboundave==v2.reboundave);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;	break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;	break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;	break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;	break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;	break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(equ)	return v1.name.compareToIgnoreCase(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.reboundave-v2.reboundave)>0?1:-1;
							else
								return (v2.reboundave-v1.reboundave)>0?1:-1;
						}
						break;
					}	
					case "assist":
					{	boolean equ = (v1.secondaryAttackave==v2.secondaryAttackave);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
						if(equ) return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
							else
								return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
						}
						break;
					}
					case "blockShot":
					{	boolean equ = (v1.blockShotave==v2.blockShotave);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;	break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;	break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
								index++;break;
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
							default:System.out.println("wrong type");	
							}
						}//while ends
						if(equ) return (v1.name.compareTo(v2.name));
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.blockShotave-v2.blockShotave)>0?1:-1;
							else
								return (v2.blockShotave-v1.blockShotave)>0?1:-1;
						}
						break;
					}
					case "steal":
					{		boolean equ = (v1.stealave==v2.stealave);
							while(equ&&index<len){
								switch(sortField[index]){
								case "point":
									equ = (v1.scoreave==v2.scoreave);
									if(!equ){
										if(sortBy[index].equals("asc"))
											return (v1.scoreave-v2.scoreave)>0?1:-1;
										else
											return (v2.scoreave-v1.scoreave)>0?1:-1;
									}
									index++;	break;
								case "rebound":
									equ = (v1.reboundave==v2.reboundave);
									if(!equ){
										if(sortBy[index].equals("asc"))
											return (v1.reboundave-v2.reboundave)>0?1:-1;
										else
											return (v2.reboundave-v1.reboundave)>0?1:-1;
									}
									index++;	break;
								case "assist":
									equ = (v1.secondaryAttackave==v2.secondaryAttackave);
									if(!equ){
										if(sortBy[index].equals("asc"))
											return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
										else
											return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
									}
									index++;	break;
								case "blockShot":
									equ = (v1.blockShotave==v2.blockShotave);
									if(!equ){
										if(sortBy[index].equals("asc"))
											return (v1.blockShotave-v2.blockShotave)>0?1:-1;
										else
											return (v2.blockShotave-v1.blockShotave)>0?1:-1;
									}
									index++;	break;
								case "foul":
									equ = (v1.foulave==v2.foulave);
									if(!equ){
										if(sortBy[index].equals("asc"))
											return (v1.foulave-v2.foulave)>0?1:-1;
										else
											return (v2.foulave-v1.foulave)>0?1:-1;
									}
									index++;	break;
								case "fault":
									equ = (v1.faultave==v2.faultave);
									if(!equ){
										if(sortBy[index].equals("asc"))
											return (v1.faultave-v2.faultave)>0?1:-1;
										else
											return (v2.faultave-v1.faultave)>0?1:-1;
									}
									index++;	break;
								case "minute":
									equ = (v1.timeave==v2.timeave);
									if(!equ){
										if(sortBy[index].equals("asc"))
											return (v1.timeave-v2.timeave)>0?1:-1;
										else
											return (v2.timeave-v1.timeave)>0?1:-1;
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
										if(sortBy[index].equals("asc"))
											return v1.ifDouble-v2.ifDouble;
										else
											return v2.ifDouble-v1.ifDouble;
									}
									index++;	break;
								default:System.out.println("wrong type");	
								}
							}//while ends
							if(equ) return v1.name.compareTo(v2.name);
							if(index==1){
								if(sortBy[0].equals("asc"))
									return (v1.stealave-v2.stealave)>0?1:-1;
								else
									return (v2.stealave-v1.stealave)>0?1:-1;
							}
							break;
						}
					case "foul":
					{	boolean equ = (v1.foulave==v2.foulave);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){;
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
						if(equ)	return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.foulave-v2.foulave)>0?1:-1;
							else
								return (v2.foulave-v1.foulave)>0?1:-1;
						}
						break;
					}
					case "fault":
					{	boolean equ = (v1.faultave==v2.faultave);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;	break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;	break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;	break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;	break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;	break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;	break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
									if(sortBy[index].equals("asc"))
										return v1.ifDouble-v2.ifDouble;
									else
										return v2.ifDouble-v1.ifDouble;
								}
								index++;break;
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(equ)	return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.faultave-v2.faultave)>0?1:-1;
							else
								return (v2.faultave-v1.faultave)>0?1:-1;
						}
						break;
					}	
					case "minute":
					{	boolean equ = (v1.timeave==v2.timeave);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
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
						if(equ)	return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.timeave-v2.timeave)>0?1:-1;
							else
								return (v2.timeave-v1.timeave)>0?1:-1;
						}
						break;
					}
					case "efficient":
					{	boolean equ = (v1.efficiency==v2.efficiency);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
						if(equ)	return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.efficiency-v2.efficiency)>0?1:-1;
							else
								return (v2.efficiency-v1.efficiency)>0?1:-1;
						}
						break;
					}
					//Ͷ��������
					case "shot":
					{	boolean equ = (v1.shotInRate==v2.shotInRate);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
								index++;	break;
							default:System.out.println("wrong type");	
							}
						}//while ends
						if(equ)	return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.shotInRate-v2.shotInRate)>0?1:-1;
							else
								return (v2.shotInRate-v1.shotInRate)>0?1:-1;
						}
						break;
					}
					//����������
					case "three":
					{	boolean equ = (v1.threeShotInRate==v2.threeShotInRate);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;	break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
								index++;	break;
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
						if(equ)	return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
							else
								return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
						}
						break;
					}		
					//����������
					case "penalty":
					{	boolean equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;
								break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
								index++;	break;
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
						if(equ)	return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
							else
								return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
						}
						break;
					}
					//��˫
					case "doubleTwo":
					{	boolean equ = (v1.ifDouble==v2.ifDouble);
						while(equ&&index<len){
							switch(sortField[index]){
							case "point":
								equ = (v1.scoreave==v2.scoreave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.scoreave-v2.scoreave)>0?1:-1;
									else
										return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
								index++;break;
							case "rebound":
								equ = (v1.reboundave==v2.reboundave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.reboundave-v2.reboundave)>0?1:-1;
									else
										return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
								index++;break;
							case "assist":
								equ = (v1.secondaryAttackave==v2.secondaryAttackave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
									else
										return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
								index++;break;
							case "blockShot":
								equ = (v1.blockShotave==v2.blockShotave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.blockShotave-v2.blockShotave)>0?1:-1;
									else
										return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
								index++;break;
							case "steal":
								equ = (v1.stealave==v2.stealave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.stealave-v2.stealave)>0?1:-1;
									else
										return (v2.stealave-v1.stealave)>0?1:-1;
								}
								index++;	break;
							case "foul":
								equ = (v1.foulave==v2.foulave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.foulave-v2.foulave)>0?1:-1;
									else
										return (v2.foulave-v1.foulave)>0?1:-1;
								}
								index++;break;
							case "fault":
								equ = (v1.faultave==v2.faultave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.faultave-v2.faultave)>0?1:-1;
									else
										return (v2.faultave-v1.faultave)>0?1:-1;
								}
								index++;break;
							case "minute":
								equ = (v1.timeave==v2.timeave);
								if(!equ){
									if(sortBy[index].equals("asc"))
										return (v1.timeave-v2.timeave)>0?1:-1;
									else
										return (v2.timeave-v1.timeave)>0?1:-1;
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
								index++;	break;
							default:System.out.println("wrong type");	
							}
						}//while ends
						if(equ)	return v1.name.compareTo(v2.name);
						if(index==1){
							if(sortBy[0].equals("asc"))
								return v1.ifDouble-v2.ifDouble;
							else
								return v2.ifDouble-v1.ifDouble;
						}
					}
					default: System.out.println("wrong type");
					}
					//δ�������з�֧
					System.out.println("δ�������з�֧��wrong field");
					return 0;
				}
			}; 
			Collections.sort(all, comparator);
		}
		
		int sz = 0;
		if(all.size()<n) sz = all.size();
		else sz = n;
		for(int i=0;i<sz;i++){
			PlayerTechVO vo = all.get(i);
			PlayerNormalInfo in = new PlayerNormalInfo();
			in.setName(vo.name);
			PlayerVO info = findInfo(vo.name);
			if(info==null)
				in.setAge(0);
			else
				in.setAge(info.age);
			in.setTeamName(vo.team);
			in.setNumOfGame(vo.gameNum);
			in.setStart(vo.startingNum);
			in.setEfficiency(vo.efficiency);
			in.setShot(vo.shotInRate);
			in.setThree(vo.threeShotInRate);
			in.setPenalty(vo.penaltyShotInRate);
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
			result.add(in);
		}
		return result;
	}
		public PlayerVO findInfo(String name) {
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
