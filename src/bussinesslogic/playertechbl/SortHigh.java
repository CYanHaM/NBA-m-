package bussinesslogic.playertechbl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import test.data.PlayerHighInfo;
import VO.PlayerTechVO;

public class SortHigh {
	public static void main(String[] args){
		SortHigh na = new SortHigh();
		ArrayList<PlayerHighInfo> res = na.highAll("realShot.desc", 50);
		for(PlayerHighInfo i:res){
			System.out.println(i.getName()+" "+i.getRealShot());
		}
	}
		ShowPlayerTech sh = new ShowPlayerTech();
		
		//返回所有球员的高阶数据,默认ave，不过滤
		public ArrayList<PlayerHighInfo> highAll(String sort, int n){
			ArrayList<PlayerHighInfo> result = new ArrayList<PlayerHighInfo>();
			ArrayList<PlayerTechVO> list = sh.showSeasonPlayerData();
			if(sort==null){
				Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){
					public int compare(PlayerTechVO v1, PlayerTechVO v2) {
						if(v1.trueShotInRate==v2.trueShotInRate){
							return v1.name.compareTo(v2.name);
						}
						else
							return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
					}
				};
				Collections.sort(list,comparator);
			}
			else{
				String[] sortTemp = sort.split(",");
				int len = sortTemp.length;
				String[] sortField = new String[len];
				String[] sortBy = new String[len];
				for(int i=0;i<len;i++){
					String[] temp = sortTemp[i].split("\\.");
					sortField[i] = temp[0];
					sortBy[i] = temp[1];
				}
	//--------------------------------------------------------------------
				Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){
					public int compare(PlayerTechVO v1, PlayerTechVO v2) {   
						int index = 1;		
						switch(sortField[0]){
						case "realShot":
						{	boolean equ = (v1.trueShotInRate==v2.trueShotInRate);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
								}
								else{
									return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "GmSc":
						{	boolean equ = (v1.GmScEfficiency==v2.GmScEfficiency);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
								}
								else{
									return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "shotEfficient":
						{	boolean equ = (v1.shootingEfficiency==v2.shootingEfficiency);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
								}
								else{
									return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "reboundEfficient":
						{	boolean equ = (v1.reboundRate==v2.reboundRate);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.reboundRate-v2.reboundRate)>0?1:-1;
								}
								else{
									return (v2.reboundRate-v1.reboundRate)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "offendReboundEfficient":
						{	boolean equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "defendReboundEfficient":
						{	boolean equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "assistEfficient":
						{	boolean equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "stealEfficient":
						{	boolean equ = (v1.stealRate==v2.stealRate);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.stealRate-v2.stealRate)>0?1:-1;
								}
								else{
									return (v2.stealRate-v1.stealRate)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "blockShotEfficient":
						{	boolean equ = (v1.blockShotRate==v2.blockShotRate);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
								}
								else{
									return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "faultEfficient":
						{	boolean equ = (v1.faultRate==v2.faultRate);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "frequency":
									equ = (v1.usageRate==v2.usageRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.usageRate-v2.usageRate)>0?1:-1;
										}
										else{
											return (v2.usageRate-v1.usageRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.faultRate-v2.faultRate)>0?1:-1;
								}
								else{
									return (v2.faultRate-v1.faultRate)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}
						case "frequency":
						{	boolean equ = (v1.usageRate==v2.usageRate);
							while(equ&&index<len){
								switch(sortField[index]){
								case "realShot":
									equ = (v1.trueShotInRate==v2.trueShotInRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.trueShotInRate-v2.trueShotInRate)>0?1:-1;
										}
										else{
											return (v2.trueShotInRate-v1.trueShotInRate)>0?1:-1;
										}
									}
									index++;	break;
								case "GmSc":
									equ = (v1.GmScEfficiency==v2.GmScEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.GmScEfficiency-v2.GmScEfficiency)>0?1:-1;
										}
										else{
											return (v2.GmScEfficiency-v1.GmScEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "shotEfficient":
									equ = (v1.shootingEfficiency==v2.shootingEfficiency);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.shootingEfficiency-v2.shootingEfficiency)>0?1:-1;
										}
										else{
											return (v2.shootingEfficiency-v1.shootingEfficiency)>0?1:-1;
										}
									}
									index++;	break;
								case "reboundEfficient":
									equ = (v1.reboundRate==v2.reboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.reboundRate-v2.reboundRate)>0?1:-1;
										}
										else{
											return (v2.reboundRate-v1.reboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "offendReboundEfficient":
									equ = (v1.offensiveReboundRate==v2.offensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.offensiveReboundRate-v2.offensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.offensiveReboundRate-v1.offensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "defendReboundEfficient":
									equ = (v1.defensiveReboundRate==v2.defensiveReboundRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.defensiveReboundRate-v2.defensiveReboundRate)>0?1:-1;
										}
										else{
											return (v2.defensiveReboundRate-v1.defensiveReboundRate)>0?1:-1;
										}
									}
									index++;	break;
								case "assistEfficient":
									equ = (v1.secondaryAttackRate==v2.secondaryAttackRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.secondaryAttackRate-v2.secondaryAttackRate)>0?1:-1;
										}
										else{
											return (v2.secondaryAttackRate-v1.secondaryAttackRate)>0?1:-1;
										}
									}
									index++;	break;
								case "stealEfficient":
									equ = (v1.stealRate==v2.stealRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.stealRate-v2.stealRate)>0?1:-1;
										}
										else{
											return (v2.stealRate-v1.stealRate)>0?1:-1;
										}
									}
									index++;	break;
								case "blockShotEfficient":
									equ = (v1.blockShotRate==v2.blockShotRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.blockShotRate-v2.blockShotRate)>0?1:-1;
										}
										else{
											return (v2.blockShotRate-v1.blockShotRate)>0?1:-1;
										}
									}
									index++;	break;
								case "faultEfficient":
									equ = (v1.faultRate==v2.faultRate);
									if(!equ){
										if(sortBy[index].equals("asc")){
											return (v1.faultRate-v2.faultRate)>0?1:-1;
										}
										else{
											return (v2.faultRate-v1.faultRate)>0?1:-1;
										}
									}
									index++;	break;
								default:	System.out.println("wrong type");	
								}
							}//while ends
							if(index==1){
								if(sortBy[0].equals("asc")){
									return (v1.usageRate-v2.usageRate)>0?1:-1;
								}
								else{
									return (v2.usageRate-v1.usageRate)>0?1:-1;
								}	
							}
							if(equ){
								return v1.name.compareTo(v2.name);
							}
							break;
						}}
						return 0;}}; 
				Collections.sort(list, comparator);
			}
			int num = 0;
			if(list.size()<n) num = list.size();
			else num = n;
			for(int i=0;i<num;i++){
				PlayerHighInfo info = new PlayerHighInfo();
				PlayerTechVO vo = list.get(i);
				info.setName(vo.name);
				info.setPosition(vo.position);
				info.setTeamName(vo.team);
				info.setLeague(vo.division);
				info.setGmSc(vo.GmScEfficiency);
				info.setRealShot(vo.trueShotInRate);
				info.setShotEfficient(vo.shootingEfficiency);
				info.setReboundEfficient(vo.reboundRate);
				info.setDefendReboundEfficient(vo.defensiveReboundRate);
				info.setAssistEfficient(vo.secondaryAttackRate);
				info.setStealEfficient(vo.stealRate);
				info.setBlockShotEfficient(vo.blockShotRate);
				info.setFaultEfficient(vo.faultRate);
				info.setFrequency(vo.usageRate);
				result.add(info);
			}
			return result;
		}

}
