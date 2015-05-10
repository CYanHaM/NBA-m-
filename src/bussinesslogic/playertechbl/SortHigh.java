package bussinesslogic.playertechbl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import test.data.PlayerHighInfo;
import VO.PlayerTechVO;

public class SortHigh {
		ShowPlayerTech sh = new ShowPlayerTech();
		
		//返回所有球员的高阶数据,默认ave，不过滤
		public ArrayList<PlayerHighInfo> highAll(String sort, int n){
			ArrayList<PlayerHighInfo> result = new ArrayList<PlayerHighInfo>();
			if(n==0){
				return result;
			}
			ArrayList<PlayerTechVO> list = sh.showSeasonPlayerData();
			String[] sortTemp = sort.split(",");
			int len = sortTemp.length;
			String[] sortField = new String[len];
			String[] sortBy = new String[len];
			for(int i=0;i<len;i++){
				String[] temp = sortTemp[i].split(".");
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "GmSc":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "shotEfficient":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "reboundEfficient":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "offendReboundEfficient":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "defendReboundEfficient":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "assistEfficient":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "stealEfficient":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "blockShotEfficient":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "faultEfficient":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					case "frequency":
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
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(sortBy[0].equals("asc")){
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
					}}
					return 0;}}; 
			Collections.sort(list, comparator);
//--------------------------------------------------------------------
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
