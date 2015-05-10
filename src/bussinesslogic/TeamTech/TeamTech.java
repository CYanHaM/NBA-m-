package bussinesslogic.TeamTech;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import PO.TeamPO;
import PO.TeamTechPO;
import TypeEnum.TeamTechEnum;
import bussinesslogic.Transfer.P2L.TeamTechP2L;
import data.TeamData;
import data.TeamTechData;
import dataservice.TeamDataService;
import dataservice.TeamTechDataService;

public class TeamTech {
	TeamTechDataService ttds = new TeamTechData();
	TeamDataService tds = new TeamData();
	
	public ArrayList<TeamHighInfo> sortHigh(String sort, int n) {
		
		String[] term = sort.split(",");
		String[][] clear = new String[term.length][2];
		int numOfcondition = term.length;
		TeamTechEnum[] dataType = new TeamTechEnum[numOfcondition];
		for(int i = 0; i<numOfcondition; i++){
			clear[i] = term[i].split("\\.");
			//clear[][0]�зŵ�������������clear[][1]�зŵ����������
			switch(clear[i][0]){
			case "winRate":
				dataType[i] = TeamTechEnum.winningRate;
				break;
			case "offendRound":
				dataType[i] = TeamTechEnum.offensiveRound;
				break;
			case "offendEfficient":
				dataType[i] = TeamTechEnum.offensiveEfficiency;
				break;
			case "defendEfficient":
				dataType[i] = TeamTechEnum.defensiveEfficiency;
				break;
			case "offendReboundEfficient":
				dataType[i] = TeamTechEnum.offensiveReboundEfficiency;
				break;
			case "defendReboundEfficient":
				dataType[i] = TeamTechEnum.defensiveReboundEfficiency;
				break;
			case "stealEfficient":
				dataType[i] = TeamTechEnum.stealEfficiency;
				break;
			case "assistEfficient":
				dataType[i] = TeamTechEnum.secondaryAttackEfficiency;
				break;
			}
		}
		ArrayList<TeamTechPO> list = new ArrayList<TeamTechPO>();	
		try {
			list = ttds.list();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<TeamTechLineItem> forSort = new ArrayList<TeamTechLineItem>();
		for(int i = 0; i<30; i++){
			TeamTechP2L p2l = new TeamTechP2L();
			forSort.add(p2l.p2l(list.get(i)));
		}
		
		ArrayList<TeamHighInfo> result = new ArrayList<TeamHighInfo>();
		
		
		//--------------------------------------------------------------------
		Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
			
			public int compare(TeamTechLineItem v1, TeamTechLineItem v2) {   
				int index = 1;		
				switch(dataType[0]){
				case winningRate:
				{	boolean equ = (v1.winningRate==v2.winningRate);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case winningRate:
							equ = (v1.winningRate==v2.winningRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.winningRate-v2.winningRate)>0?1:-1;
								}
								else{
									return (v2.winningRate-v1.winningRate)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRound:
							equ = (v1.offensiveRound==v2.offensiveRound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveRound-v2.offensiveRound)>0?1:-1;
								}
								else{
									return (v2.offensiveRound-v1.offensiveRound)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveReboundEfficiency:
							equ = (v1.offensiveReboundEfficiency==v2.offensiveReboundEfficiency);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundEfficiency-v2.offensiveReboundEfficiency)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundEfficiency-v1.offensiveReboundEfficiency)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveReboundEfficiency:
							equ = (v1.defensiveReboundEfficiency==v2.defensiveReboundEfficiency);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundEfficiency-v2.defensiveReboundEfficiency)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundEfficiency-v1.defensiveReboundEfficiency)>0?1:-1;
								}
							}
							index++;	break;
						case stealEfficiency:
							equ = (v1.stealEfficiency==v2.stealEfficiency);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealEfficiency-v2.stealEfficiency)>0?1:-1;
								}
								else{
									return (v2.stealEfficiency-v1.stealEfficiency)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttackEfficiency:
							equ = (v1.secondaryAttackEfficiency==v2.secondaryAttackEfficiency);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackEfficiency-v2.secondaryAttackEfficiency)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackEfficiency-v1.secondaryAttackEfficiency)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveEfficiency:
							equ = (v1.offensiveEfficiency==v2.offensiveEfficiency);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveEfficiency-v2.offensiveEfficiency)>0?1:-1;
								}
								else{
									return (v2.offensiveEfficiency-v1.offensiveEfficiency)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveEfficiency:
							equ = (v1.defensiveEfficiency==v2.defensiveEfficiency);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveEfficiency-v2.defensiveEfficiency)>0?1:-1;
								}
								else{
									return (v2.defensiveEfficiency-v1.defensiveEfficiency)>0?1:-1;
								}
							}
							index++;	break;
						default:	System.out.println("wrong type");	
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.winningRate-v2.winningRate)>0?1:-1;
						}
						else{
							return (v2.winningRate-v1.winningRate)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
					}
					case offensiveRound:{
						boolean equ = (v1.offensiveRound==v2.offensiveRound);
						while(equ&&index<numOfcondition){
							switch(dataType[index]){
							case winningRate:
								equ = (v1.winningRate==v2.winningRate);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.winningRate-v2.winningRate)>0?1:-1;
									}
									else{
										return (v2.winningRate-v1.winningRate)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveRound:
								equ = (v1.offensiveRound==v2.offensiveRound);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveRound-v2.offensiveRound)>0?1:-1;
									}
									else{
										return (v2.offensiveRound-v1.offensiveRound)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveReboundEfficiency:
								equ = (v1.offensiveReboundEfficiency==v2.offensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveReboundEfficiency-v2.offensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveReboundEfficiency-v1.offensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveReboundEfficiency:
								equ = (v1.defensiveReboundEfficiency==v2.defensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveReboundEfficiency-v2.defensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveReboundEfficiency-v1.defensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case stealEfficiency:
								equ = (v1.stealEfficiency==v2.stealEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.stealEfficiency-v2.stealEfficiency)>0?1:-1;
									}
									else{
										return (v2.stealEfficiency-v1.stealEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case secondaryAttackEfficiency:
								equ = (v1.secondaryAttackEfficiency==v2.secondaryAttackEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.secondaryAttackEfficiency-v2.secondaryAttackEfficiency)>0?1:-1;
									}
									else{
										return (v2.secondaryAttackEfficiency-v1.secondaryAttackEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveEfficiency:
								equ = (v1.offensiveEfficiency==v2.offensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveEfficiency-v2.offensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveEfficiency-v1.offensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveEfficiency:
								equ = (v1.defensiveEfficiency==v2.defensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveEfficiency-v2.defensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveEfficiency-v1.defensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(clear[0][1].equals("asc")){
								return (v1.offensiveRound-v2.offensiveRound)>0?1:-1;
							}
							else{
								return (v2.offensiveRound-v1.offensiveRound)>0?1:-1;
							}	
						}
						if(equ){
							return v1.name.compareTo(v2.name);
						}
						break;
					}
					case offensiveEfficiency:{

						boolean equ = (v1.offensiveEfficiency==v2.offensiveEfficiency);
						while(equ&&index<numOfcondition){
							switch(dataType[index]){
							case winningRate:
								equ = (v1.winningRate==v2.winningRate);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.winningRate-v2.winningRate)>0?1:-1;
									}
									else{
										return (v2.winningRate-v1.winningRate)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveRound:
								equ = (v1.offensiveRound==v2.offensiveRound);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveRound-v2.offensiveRound)>0?1:-1;
									}
									else{
										return (v2.offensiveRound-v1.offensiveRound)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveReboundEfficiency:
								equ = (v1.offensiveReboundEfficiency==v2.offensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveReboundEfficiency-v2.offensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveReboundEfficiency-v1.offensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveReboundEfficiency:
								equ = (v1.defensiveReboundEfficiency==v2.defensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveReboundEfficiency-v2.defensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveReboundEfficiency-v1.defensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case stealEfficiency:
								equ = (v1.stealEfficiency==v2.stealEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.stealEfficiency-v2.stealEfficiency)>0?1:-1;
									}
									else{
										return (v2.stealEfficiency-v1.stealEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case secondaryAttackEfficiency:
								equ = (v1.secondaryAttackEfficiency==v2.secondaryAttackEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.secondaryAttackEfficiency-v2.secondaryAttackEfficiency)>0?1:-1;
									}
									else{
										return (v2.secondaryAttackEfficiency-v1.secondaryAttackEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveEfficiency:
								equ = (v1.offensiveEfficiency==v2.offensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveEfficiency-v2.offensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveEfficiency-v1.offensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveEfficiency:
								equ = (v1.defensiveEfficiency==v2.defensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveEfficiency-v2.defensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveEfficiency-v1.defensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(clear[0][1].equals("asc")){
								return (v1.offensiveEfficiency-v2.offensiveEfficiency)>0?1:-1;
							}
							else{
								return (v2.offensiveEfficiency-v1.offensiveEfficiency)>0?1:-1;
							}	
						}
						if(equ){
							return v1.name.compareTo(v2.name);
						}
						break;
					}
					case defensiveEfficiency:{

						boolean equ = (v1.defensiveEfficiency==v2.defensiveEfficiency);
						while(equ&&index<numOfcondition){
							switch(dataType[index]){
							case winningRate:
								equ = (v1.winningRate==v2.winningRate);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.winningRate-v2.winningRate)>0?1:-1;
									}
									else{
										return (v2.winningRate-v1.winningRate)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveRound:
								equ = (v1.offensiveRound==v2.offensiveRound);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveRound-v2.offensiveRound)>0?1:-1;
									}
									else{
										return (v2.offensiveRound-v1.offensiveRound)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveReboundEfficiency:
								equ = (v1.offensiveReboundEfficiency==v2.offensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveReboundEfficiency-v2.offensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveReboundEfficiency-v1.offensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveReboundEfficiency:
								equ = (v1.defensiveReboundEfficiency==v2.defensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveReboundEfficiency-v2.defensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveReboundEfficiency-v1.defensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case stealEfficiency:
								equ = (v1.stealEfficiency==v2.stealEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.stealEfficiency-v2.stealEfficiency)>0?1:-1;
									}
									else{
										return (v2.stealEfficiency-v1.stealEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case secondaryAttackEfficiency:
								equ = (v1.secondaryAttackEfficiency==v2.secondaryAttackEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.secondaryAttackEfficiency-v2.secondaryAttackEfficiency)>0?1:-1;
									}
									else{
										return (v2.secondaryAttackEfficiency-v1.secondaryAttackEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveEfficiency:
								equ = (v1.offensiveEfficiency==v2.offensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveEfficiency-v2.offensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveEfficiency-v1.offensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveEfficiency:
								equ = (v1.defensiveEfficiency==v2.defensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveEfficiency-v2.defensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveEfficiency-v1.defensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(clear[0][1].equals("asc")){
								return (v1.defensiveEfficiency-v2.defensiveEfficiency)>0?1:-1;
							}
							else{
								return (v2.defensiveEfficiency-v1.defensiveEfficiency)>0?1:-1;
							}	
						}
						if(equ){
							return v1.name.compareTo(v2.name);
						}
						break;
					}
					case offensiveReboundEfficiency:{

						boolean equ = (v1.offensiveReboundEfficiency==v2.offensiveReboundEfficiency);
						while(equ&&index<numOfcondition){
							switch(dataType[index]){
							case winningRate:
								equ = (v1.winningRate==v2.winningRate);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.winningRate-v2.winningRate)>0?1:-1;
									}
									else{
										return (v2.winningRate-v1.winningRate)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveRound:
								equ = (v1.offensiveRound==v2.offensiveRound);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveRound-v2.offensiveRound)>0?1:-1;
									}
									else{
										return (v2.offensiveRound-v1.offensiveRound)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveReboundEfficiency:
								equ = (v1.offensiveReboundEfficiency==v2.offensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveReboundEfficiency-v2.offensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveReboundEfficiency-v1.offensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveReboundEfficiency:
								equ = (v1.defensiveReboundEfficiency==v2.defensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveReboundEfficiency-v2.defensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveReboundEfficiency-v1.defensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case stealEfficiency:
								equ = (v1.stealEfficiency==v2.stealEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.stealEfficiency-v2.stealEfficiency)>0?1:-1;
									}
									else{
										return (v2.stealEfficiency-v1.stealEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case secondaryAttackEfficiency:
								equ = (v1.secondaryAttackEfficiency==v2.secondaryAttackEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.secondaryAttackEfficiency-v2.secondaryAttackEfficiency)>0?1:-1;
									}
									else{
										return (v2.secondaryAttackEfficiency-v1.secondaryAttackEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveEfficiency:
								equ = (v1.offensiveEfficiency==v2.offensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveEfficiency-v2.offensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveEfficiency-v1.offensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveEfficiency:
								equ = (v1.defensiveEfficiency==v2.defensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveEfficiency-v2.defensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveEfficiency-v1.defensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(clear[0][1].equals("asc")){
								return (v1.offensiveReboundEfficiency-v2.offensiveReboundEfficiency)>0?1:-1;
							}
							else{
								return (v2.offensiveReboundEfficiency-v1.offensiveReboundEfficiency)>0?1:-1;
							}	
						}
						if(equ){
							return v1.name.compareTo(v2.name);
						}
						break;
					}
					case defensiveReboundEfficiency:{
						boolean equ = (v1.defensiveReboundEfficiency==v2.defensiveReboundEfficiency);
						while(equ&&index<numOfcondition){
							switch(dataType[index]){
							case winningRate:
								equ = (v1.winningRate==v2.winningRate);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.winningRate-v2.winningRate)>0?1:-1;
									}
									else{
										return (v2.winningRate-v1.winningRate)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveRound:
								equ = (v1.offensiveRound==v2.offensiveRound);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveRound-v2.offensiveRound)>0?1:-1;
									}
									else{
										return (v2.offensiveRound-v1.offensiveRound)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveReboundEfficiency:
								equ = (v1.offensiveReboundEfficiency==v2.offensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveReboundEfficiency-v2.offensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveReboundEfficiency-v1.offensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveReboundEfficiency:
								equ = (v1.defensiveReboundEfficiency==v2.defensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveReboundEfficiency-v2.defensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveReboundEfficiency-v1.defensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case stealEfficiency:
								equ = (v1.stealEfficiency==v2.stealEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.stealEfficiency-v2.stealEfficiency)>0?1:-1;
									}
									else{
										return (v2.stealEfficiency-v1.stealEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case secondaryAttackEfficiency:
								equ = (v1.secondaryAttackEfficiency==v2.secondaryAttackEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.secondaryAttackEfficiency-v2.secondaryAttackEfficiency)>0?1:-1;
									}
									else{
										return (v2.secondaryAttackEfficiency-v1.secondaryAttackEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveEfficiency:
								equ = (v1.offensiveEfficiency==v2.offensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveEfficiency-v2.offensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveEfficiency-v1.offensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveEfficiency:
								equ = (v1.defensiveEfficiency==v2.defensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveEfficiency-v2.defensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveEfficiency-v1.defensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(clear[0][1].equals("asc")){
								return (v1.defensiveReboundEfficiency-v2.defensiveReboundEfficiency)>0?1:-1;
							}
							else{
								return (v2.defensiveReboundEfficiency-v1.defensiveReboundEfficiency)>0?1:-1;
							}	
						}
						if(equ){
							return v1.name.compareTo(v2.name);
						}
						break;
					}
					case stealEfficiency:{
						boolean equ = (v1.stealEfficiency==v2.stealEfficiency);
						while(equ&&index<numOfcondition){
							switch(dataType[index]){
							case winningRate:
								equ = (v1.winningRate==v2.winningRate);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.winningRate-v2.winningRate)>0?1:-1;
									}
									else{
										return (v2.winningRate-v1.winningRate)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveRound:
								equ = (v1.offensiveRound==v2.offensiveRound);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveRound-v2.offensiveRound)>0?1:-1;
									}
									else{
										return (v2.offensiveRound-v1.offensiveRound)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveReboundEfficiency:
								equ = (v1.offensiveReboundEfficiency==v2.offensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveReboundEfficiency-v2.offensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveReboundEfficiency-v1.offensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveReboundEfficiency:
								equ = (v1.defensiveReboundEfficiency==v2.defensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveReboundEfficiency-v2.defensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveReboundEfficiency-v1.defensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case stealEfficiency:
								equ = (v1.stealEfficiency==v2.stealEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.stealEfficiency-v2.stealEfficiency)>0?1:-1;
									}
									else{
										return (v2.stealEfficiency-v1.stealEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case secondaryAttackEfficiency:
								equ = (v1.secondaryAttackEfficiency==v2.secondaryAttackEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.secondaryAttackEfficiency-v2.secondaryAttackEfficiency)>0?1:-1;
									}
									else{
										return (v2.secondaryAttackEfficiency-v1.secondaryAttackEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveEfficiency:
								equ = (v1.offensiveEfficiency==v2.offensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveEfficiency-v2.offensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveEfficiency-v1.offensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveEfficiency:
								equ = (v1.defensiveEfficiency==v2.defensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveEfficiency-v2.defensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveEfficiency-v1.defensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(clear[0][1].equals("asc")){
								return (v1.stealEfficiency-v2.stealEfficiency)>0?1:-1;
							}
							else{
								return (v2.stealEfficiency-v1.stealEfficiency)>0?1:-1;
							}	
						}
						if(equ){
							return v1.name.compareTo(v2.name);
						}
						break;
					}
					case secondaryAttackEfficiency:{
						boolean equ = (v1.secondaryAttackEfficiency==v2.secondaryAttackEfficiency);
						while(equ&&index<numOfcondition){
							switch(dataType[index]){
							case winningRate:
								equ = (v1.winningRate==v2.winningRate);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.winningRate-v2.winningRate)>0?1:-1;
									}
									else{
										return (v2.winningRate-v1.winningRate)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveRound:
								equ = (v1.offensiveRound==v2.offensiveRound);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveRound-v2.offensiveRound)>0?1:-1;
									}
									else{
										return (v2.offensiveRound-v1.offensiveRound)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveReboundEfficiency:
								equ = (v1.offensiveReboundEfficiency==v2.offensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveReboundEfficiency-v2.offensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveReboundEfficiency-v1.offensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveReboundEfficiency:
								equ = (v1.defensiveReboundEfficiency==v2.defensiveReboundEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveReboundEfficiency-v2.defensiveReboundEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveReboundEfficiency-v1.defensiveReboundEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case stealEfficiency:
								equ = (v1.stealEfficiency==v2.stealEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.stealEfficiency-v2.stealEfficiency)>0?1:-1;
									}
									else{
										return (v2.stealEfficiency-v1.stealEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case secondaryAttackEfficiency:
								equ = (v1.secondaryAttackEfficiency==v2.secondaryAttackEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.secondaryAttackEfficiency-v2.secondaryAttackEfficiency)>0?1:-1;
									}
									else{
										return (v2.secondaryAttackEfficiency-v1.secondaryAttackEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case offensiveEfficiency:
								equ = (v1.offensiveEfficiency==v2.offensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.offensiveEfficiency-v2.offensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.offensiveEfficiency-v1.offensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							case defensiveEfficiency:
								equ = (v1.defensiveEfficiency==v2.defensiveEfficiency);
								if(!equ){
									if(clear[index][1].equals("asc")){
										return (v1.defensiveEfficiency-v2.defensiveEfficiency)>0?1:-1;
									}
									else{
										return (v2.defensiveEfficiency-v1.defensiveEfficiency)>0?1:-1;
									}
								}
								index++;	break;
							default:	System.out.println("wrong type");	
							}
						}//while ends
						if(index==1){
							if(clear[0][1].equals("asc")){
								return (v1.secondaryAttackEfficiency-v2.secondaryAttackEfficiency)>0?1:-1;
							}
							else{
								return (v2.secondaryAttackEfficiency-v1.secondaryAttackEfficiency)>0?1:-1;
							}	
						}
						if(equ){
							return v1.name.compareTo(v2.name);
						}
						break;
					}
				}
				return 0;}}; 
		Collections.sort(forSort, comparator);
		//--------------------------------------------------------------------
		
		int num = 0;
		if(list.size()<n) num = list.size();
		else num = n;
		for(int i=0;i<num;i++){
			TeamHighInfo info = new TeamHighInfo();
			TeamTechLineItem ttli= forSort.get(i);
			info.setAssistEfficient(ttli.secondaryAttackEfficiency);
			info.setDefendEfficient(ttli.defensiveEfficiency);
			info.setDefendReboundEfficient(ttli.defensiveReboundEfficiency);
			info.setOffendEfficient(ttli.offensiveEfficiency);
			info.setOffendReboundEfficient(ttli.offensiveReboundEfficiency);
			info.setOffendRound(ttli.offensiveRound);
			info.setStealEfficient(ttli.stealEfficiency);
			info.setTeamName(ttli.name);
			info.setWinRate(ttli.winningRate);
			result.add(info);
		}
		return result;
	}

	public ArrayList<TeamNormalInfo> sortNorm(String sort, int n, boolean isTotal) {
		String[] term = sort.split(",");
		String[][] clear = new String[term.length][2];
		int numOfcondition = term.length;
		for(int i = 0; i<numOfcondition; i++){
			clear[i][0] = term[i];
		}
		TeamTechEnum[] dataType = new TeamTechEnum[numOfcondition];
		
		for(int i = 0; i<numOfcondition; i++){
			clear[i] = term[i].split("\\.");
			//clear[][0]�зŵ�������������clear[][1]�зŵ����������
			switch(clear[i][0]){
			case "point": 
				if(isTotal){
					dataType[i] = TeamTechEnum.score;
				}else{
					dataType[i] = TeamTechEnum.scoreave;
				}
				break;
			case "rebound":
				if(isTotal){
					dataType[i] = TeamTechEnum.rebound;
				}else{
					dataType[i] = TeamTechEnum.reboundave;
				}
				break;
			case "assist":
				if(isTotal){
					dataType[i] = TeamTechEnum.secondaryAttack;
				}else{
					dataType[i] = TeamTechEnum.secondaryAttackave;
				}
				break;
			case "blockShot":
				if(isTotal){
					dataType[i] = TeamTechEnum.blockShot;
				}else{
					dataType[i] = TeamTechEnum.blockShotave;
				}
				break;
			case "steal":
				if(isTotal){
					dataType[i] = TeamTechEnum.steal;
				}else{
					dataType[i] = TeamTechEnum.stealave;
				}
				break;
			case "foul":
				if(isTotal){
					dataType[i] = TeamTechEnum.foul;
				}else{
					dataType[i] = TeamTechEnum.foulave;
				}
				break;
			case "fault":
				if(isTotal){
					dataType[i] = TeamTechEnum.fault;
				}else{
					dataType[i] = TeamTechEnum.faultave;
				}
				break;
			case "shot":
				dataType[i] = TeamTechEnum.shotInRate;
				break;
			case "three":
				dataType[i] = TeamTechEnum.threeShotInRate;
				break;
			case "penalty":
				dataType[i] = TeamTechEnum.penaltyShotInRate;
				break;
			case "defendRebound":
				if(isTotal){
					dataType[i] = TeamTechEnum.defensiveRebound;
				}else{
					dataType[i] = TeamTechEnum.defensiveReboundave;
				}
				break;
			case "offendRebound":
				if(isTotal){
					dataType[i] = TeamTechEnum.offensiveRebound;
				}else{
					dataType[i] = TeamTechEnum.offensiveReboundave;
				}
				break;
			}
		}
		ArrayList<TeamTechPO> list = new ArrayList<TeamTechPO>();	
		try {
			list = ttds.list();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<TeamTechLineItem> forSort = new ArrayList<TeamTechLineItem>();
		for(int i = 0; i<30; i++){
			TeamTechP2L p2l = new TeamTechP2L();
			forSort.add(p2l.p2l(list.get(i)));
		}
		
		ArrayList<TeamNormalInfo> result = new ArrayList<TeamNormalInfo>();
		
		
		//--------------------------------------------------------------------
		Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
			
			public int compare(TeamTechLineItem v1, TeamTechLineItem v2) {   
				int index = 1;		
				switch(dataType[0]){
				case score:
				{	boolean equ = (v1.score==v2.score);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.score-v2.score)>0?1:-1;
						}
						else{
							return (v2.score-v1.score)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
					}
				case scoreave:{
					boolean equ = (v1.scoreave==v2.scoreave);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.scoreave-v2.scoreave)>0?1:-1;
						}
						else{
							return (v2.scoreave-v1.scoreave)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case rebound:{
					boolean equ = (v1.rebound==v2.rebound);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.rebound-v2.rebound)>0?1:-1;
						}
						else{
							return (v2.rebound-v1.rebound)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case reboundave:{
					boolean equ = (v1.reboundave==v2.reboundave);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.reboundave-v2.reboundave)>0?1:-1;
						}
						else{
							return (v2.reboundave-v1.reboundave)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case secondaryAttack:{
					boolean equ = (v1.secondaryAttack==v2.secondaryAttack);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.secondaryAttack-v2.secondaryAttack)>0?1:-1;
						}
						else{
							return (v2.secondaryAttack-v1.secondaryAttack)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case secondaryAttackave:{
					boolean equ = (v1.secondaryAttackave==v2.secondaryAttackave);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
						}
						else{
							return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case blockShot:{
					boolean equ = (v1.blockShot==v2.blockShot);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.blockShot-v2.blockShot)>0?1:-1;
						}
						else{
							return (v2.blockShot-v1.blockShot)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case blockShotave:{
					boolean equ = (v1.blockShotave==v2.blockShotave);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.blockShotave-v2.blockShotave)>0?1:-1;
						}
						else{
							return (v2.blockShotave-v1.blockShotave)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case steal:{
					boolean equ = (v1.steal==v2.steal);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.steal-v2.steal)>0?1:-1;
						}
						else{
							return (v2.steal-v1.steal)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case stealave:{
					boolean equ = (v1.stealave==v2.stealave);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.stealave-v2.stealave)>0?1:-1;
						}
						else{
							return (v2.stealave-v1.stealave)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case foul:{
					boolean equ = (v1.foul==v2.foul);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.foul-v2.foul)>0?1:-1;
						}
						else{
							return (v2.foul-v1.foul)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case foulave:{
					boolean equ = (v1.foulave==v2.foulave);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.foulave-v2.foulave)>0?1:-1;
						}
						else{
							return (v2.foulave-v1.foulave)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case fault:{
					boolean equ = (v1.fault==v2.fault);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.fault-v2.fault)>0?1:-1;
						}
						else{
							return (v2.fault-v1.fault)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case faultave:{
					boolean equ = (v1.faultave==v2.faultave);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.faultave-v2.faultave)>0?1:-1;
						}
						else{
							return (v2.faultave-v1.faultave)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case shotInRate:{
					boolean equ = (v1.shotInRate==v2.shotInRate);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.shotInRate-v2.shotInRate)>0?1:-1;
						}
						else{
							return (v2.shotInRate-v1.shotInRate)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case threeShotInRate:{
					boolean equ = (v1.threeShotInRate==v2.threeShotInRate);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
						}
						else{
							return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case penaltyShotInRate:{
					boolean equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
						}
						else{
							return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case defensiveRebound:{
					boolean equ = (v1.defensiveRebound==v2.defensiveRebound);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.defensiveRebound-v2.defensiveRebound)>0?1:-1;
						}
						else{
							return (v2.defensiveRebound-v1.defensiveRebound)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case defensiveReboundave:{
					boolean equ = (v1.defensiveReboundave==v2.defensiveReboundave);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
						}
						else{
							return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case offensiveRebound:{
					boolean equ = (v1.offensiveRebound==v2.offensiveRebound);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.offensiveRebound-v2.offensiveRebound)>0?1:-1;
						}
						else{
							return (v2.offensiveRebound-v1.offensiveRebound)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				case offensiveReboundave:{
					boolean equ = (v1.offensiveReboundave==v2.offensiveReboundave);
					while(equ&&index<numOfcondition){
						switch(dataType[index]){
						case score:
							equ = (v1.score==v2.score);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.score-v2.score;
								}
								else{
									return v2.score-v1.score;
								}
							}
							index++;	break;
						case scoreave:
							equ = (v1.scoreave==v2.scoreave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.scoreave-v2.scoreave)>0?1:-1;
								}
								else{
									return (v2.scoreave-v1.scoreave)>0?1:-1;
								}
							}
							index++;	break;
						case rebound:
							equ = (v1.rebound==v2.rebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.rebound-v2.rebound;
								}
								else{
									return v2.rebound-v1.rebound;
								}
							}
							index++;	break;
						case reboundave:
							equ = (v1.reboundave==v2.reboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.reboundave-v2.reboundave)>0?1:-1;
								}
								else{
									return (v2.reboundave-v1.reboundave)>0?1:-1;
								}
							}
							index++;	break;
						case secondaryAttack:
							equ = (v1.secondaryAttack==v2.secondaryAttack);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.secondaryAttack-v2.secondaryAttack;
								}
								else{
									return v2.secondaryAttack-v1.secondaryAttack;
								}
							}
							index++;	break;
						case secondaryAttackave:
							equ = (v1.secondaryAttackave==v2.secondaryAttackave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.secondaryAttackave-v2.secondaryAttackave)>0?1:-1;
								}
								else{
									return (v2.secondaryAttackave-v1.secondaryAttackave)>0?1:-1;
								}
							}
							index++;	break;
						case blockShot:
							equ = (v1.blockShot==v2.blockShot);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.blockShot-v2.blockShot;
								}
								else{
									return v2.blockShot-v1.blockShot;
								}
							}
							index++;	break;
						case blockShotave:
							equ = (v1.blockShotave==v2.blockShotave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.blockShotave-v2.blockShotave)>0?1:-1;
								}
								else{
									return (v2.blockShotave-v1.blockShotave)>0?1:-1;
								}
							}
							index++;	break;
						case steal:
							equ = (v1.steal==v2.steal);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.steal-v2.steal;
								}
								else{
									return v2.steal-v1.steal;
								}
							}
							index++;	break;
						case stealave:
							equ = (v1.stealave==v2.stealave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.stealave-v2.stealave)>0?1:-1;
								}
								else{
									return (v2.stealave-v1.stealave)>0?1:-1;
								}
							}
							index++;	break;
						case foul:
							equ = (v1.foul==v2.foul);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.foul-v2.foul;
								}
								else{
									return v2.foul-v1.foul;
								}
							}
							index++;	break;
						case foulave:
							equ = (v1.foulave==v2.foulave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.foulave-v2.foulave)>0?1:-1;
								}
								else{
									return (v2.foulave-v1.foulave)>0?1:-1;
								}
							}
							index++;	break;
						case fault:
							equ = (v1.fault==v2.fault);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.fault-v2.fault;
								}
								else{
									return v2.fault-v1.fault;
								}
							}
							index++;	break;
						case faultave:
							equ = (v1.faultave==v2.faultave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.faultave-v2.faultave)>0?1:-1;
								}
								else{
									return (v2.faultave-v1.faultave)>0?1:-1;
								}
							}
							index++;	break;
						case shotInRate:
							equ = (v1.shotInRate==v2.shotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.shotInRate-v2.shotInRate)>0?1:-1;
								}
								else{
									return (v2.shotInRate-v1.shotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case penaltyShotInRate:
							equ = (v1.penaltyShotInRate==v2.penaltyShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.penaltyShotInRate-v2.penaltyShotInRate)>0?1:-1;
								}
								else{
									return (v2.penaltyShotInRate-v1.penaltyShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case threeShotInRate:
							equ = (v1.threeShotInRate==v2.threeShotInRate);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.threeShotInRate-v2.threeShotInRate)>0?1:-1;
								}
								else{
									return (v2.threeShotInRate-v1.threeShotInRate)>0?1:-1;
								}
							}
							index++;	break;
						case defensiveRebound:
							equ = (v1.defensiveRebound==v2.defensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.defensiveRebound-v2.defensiveRebound;
								}
								else{
									return v2.defensiveRebound-v1.defensiveRebound;
								}
							}
							index++;	break;
						case defensiveReboundave:
							equ = (v1.defensiveReboundave==v2.defensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.defensiveReboundave-v2.defensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.defensiveReboundave-v1.defensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						case offensiveRebound:
							equ = (v1.offensiveRebound==v2.offensiveRebound);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return v1.offensiveRebound-v2.offensiveRebound;
								}
								else{
									return v2.offensiveRebound-v1.offensiveRebound;
								}
							}
							index++;	break;
						case offensiveReboundave:
							equ = (v1.offensiveReboundave==v2.offensiveReboundave);
							if(!equ){
								if(clear[index][1].equals("asc")){
									return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
								}
								else{
									return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
								}
							}
							index++;	break;
						}
					}//while ends
					if(index==1){
						if(clear[0][1].equals("asc")){
							return (v1.offensiveReboundave-v2.offensiveReboundave)>0?1:-1;
						}
						else{
							return (v2.offensiveReboundave-v1.offensiveReboundave)>0?1:-1;
						}	
					}
					if(equ){
						return v1.name.compareTo(v2.name);
					}
					break;
				}
				}
				return 0;}}; 
		Collections.sort(forSort, comparator);
		//--------------------------------------------------------------------
		
		int num = 0;
		if(list.size()<n) num = list.size();
		else num = n;
		if(isTotal){
			for(int i=0;i<num;i++){
				TeamNormalInfo info = new TeamNormalInfo();
				TeamTechLineItem ttli= forSort.get(i);
				info.setAssist(ttli.secondaryAttack);
				info.setBlockShot(ttli.blockShot);
				info.setDefendRebound(ttli.defensiveRebound);
				info.setFault(ttli.fault);
				info.setFoul(ttli.foul);
				info.setNumOfGame(ttli.gameNum);
				info.setOffendRebound(ttli.offensiveRebound);
				info.setPenalty(ttli.penaltyShotInRate);
				info.setPoint(ttli.score);
				info.setRebound(ttli.rebound);
				info.setShot(ttli.shotInRate);
				info.setSteal(ttli.steal);
				info.setTeamName(ttli.name);
				info.setThree(ttli.threeShotInRate);
				result.add(info);
			}
		}
		
		return result;
		
	}

	public ArrayList<TeamHotInfo> findSeasonHotTeam(TeamTechEnum DataType, String field, int num) {
		ArrayList<TeamTechPO> list = new ArrayList<TeamTechPO>();
		ArrayList<TeamTechLineItem> forSort = new ArrayList<TeamTechLineItem>();
		for(int i = 0; i<30; i++){
			TeamTechP2L p2l = new TeamTechP2L();
			forSort.add(p2l.p2l(list.get(i)));
		}
		Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
			public int compare(TeamTechLineItem t2, TeamTechLineItem t1){
				switch(DataType){
				case score:
					return (t1.scoreave-t2.scoreave)>0?1:-1;
				case rebound:
					return (t1.reboundave-t2.reboundave)>0?1:-1;
				case secondaryAttack:
					return (t1.secondaryAttackave-t2.secondaryAttackave)>0?1:-1;
				case blockShot:
					return (t1.blockShotave-t2.blockShotave)>0?1:-1;
				case steal:
					return (t1.stealave-t2.stealave)>0?1:-1;
				case foul:
					return (t1.foulave-t2.foulave)>0?1:-1;
				case fault:
					return (t1.faultave-t2.faultave)>0?1:-1;
				case shotInRate:
					return (t1.shotInRate-t2.shotInRate)>0?1:-1;
				case threeShotInRate:
					return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
				case penaltyShotInRate:
					return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
				case offensiveRebound:
					return (t1.offensiveReboundave-t2.offensiveReboundave)>0?1:-1;
				case defensiveRebound:
					return (t1.defensiveReboundave-t2.defensiveReboundave)>0?1:-1;
				default:return 0;
				}
			}
		};
		Collections.sort(forSort, comparator);
		ArrayList<TeamHotInfo> result = new ArrayList<TeamHotInfo>();
		for(int i = 0; i<num; i++){
			TeamHotInfo thi = new TeamHotInfo();
			TeamPO tpo = new TeamPO();
			tpo.abbreviation = forSort.get(i).name;
			TeamPO findout = new TeamPO();
			try {
				findout = tds.find(tpo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			thi.setField(field);
			thi.setLeague(tpo.division);
			thi.setTeamName(tpo.abbreviation);
			switch(DataType){
			case score:
				thi.setValue(forSort.get(i).scoreave);
				break;
			case rebound:
				thi.setValue(forSort.get(i).reboundave);
				break;
			case secondaryAttack:
				thi.setValue(forSort.get(i).secondaryAttackave);
				break;
			case blockShot:
				thi.setValue(forSort.get(i).blockShotave);
				break;
			case steal:
				thi.setValue(forSort.get(i).stealave);
				break;
			case foul:
				thi.setValue(forSort.get(i).foulave);
				break;
			case fault:
				thi.setValue(forSort.get(i).faultave);
				break;
			case shotInRate:
				thi.setValue(forSort.get(i).shotInRate);
				break;
			case threeShotInRate:
				thi.setValue(forSort.get(i).threeShotInRate);
				break;
			case penaltyShotInRate:
				thi.setValue(forSort.get(i).penaltyShotInRate);
				break;
			case offensiveRebound:
				thi.setValue(forSort.get(i).offensiveReboundave);
				break;
			case defensiveRebound:
				thi.setValue(forSort.get(i).defensiveReboundave);
				break;
			}
			result.add(thi);
		}
		return result;
	}	
	
	public void init() {
		// TODO Auto-generated method stub
		ttds.WriteIn("matchData");
	}

}
