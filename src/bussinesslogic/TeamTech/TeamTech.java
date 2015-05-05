package bussinesslogic.TeamTech;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.TeamTechPO;
import TypeEnum.SortEnum;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;
import blservice.teamtechblservice.TeamTechBLService;
import bussinesslogic.Transfer.L2V.TeamTechL2V;
import bussinesslogic.Transfer.P2L.TeamTechP2L;
import data.TeamTechData;
import dataservice.TeamTechDataService;

public class TeamTech implements TeamTechBLService{

	TeamTechDataService ttdataservice = new TeamTechData();
	
	ArrayList<TeamTechLineItem> forSort = new ArrayList<TeamTechLineItem>();
	
	boolean isInt = false;
	boolean isDouble = false;
	
	ArrayList readIn(TeamTechEnum DataType, ArrayList<TeamTechPO> polist){
		ArrayList result = new ArrayList();
		switch(DataType){
			case shotInNum: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).shotInNum);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case shotNum: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).shotNum);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case threeShotInNum: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).threeShotInNum);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case threeShotNum: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).threeShotNum);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case penaltyShotInNum: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).penaltyShotInNum);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case penaltyShotNum: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).penaltyShotNum);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case offensiveRebound: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).offensiveRebound);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case defensiveRebound: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).defensiveRebound);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case rebound: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).rebound);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case secondaryAttack: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).secondaryAttack);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case steal: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).steal);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case blockShot: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).blockShot);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case fault: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).fault);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case foul: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).foul);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case score: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).score);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			case winningNum: 
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).winningNum);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isInt = true;
				return result;
			//int到这里
			case shotInRate:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).shotInRate);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case threeShotInRate:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).threeShotInRate);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case penaltyShotInRate:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).penaltyShotInRate);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case winningRate:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).winningRate);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case offensiveRound:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).offensiveRound);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case offensiveEfficiency:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).offensiveEfficiency);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case defensiveEfficiency:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).defensiveEfficiency);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case reboundEfficiency:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).reboundEfficiency);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case stealEfficiency:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).stealEfficiency);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case secondaryAttackEfficiency:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					result.add(polist.get(i).secondaryAttackEfficiency);
					forSort.add(p2l.p2l(polist.get(i)));
				}
				isDouble = true;
				return result;
			case shotInNumave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.shotInNumave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case shotNumave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.shotNumave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case threeShotInNumave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.threeShotInNumave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case threeShotNumave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.threeShotNumave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case penaltyShotInNumave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.penaltyShotInNumave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case penaltyShotNumave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.penaltyShotNumave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case offensiveReboundave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.offensiveReboundave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case defensiveReboundave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.defensiveReboundave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case reboundave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.reboundave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case secondaryAttackave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.secondaryAttackave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case stealave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.stealave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case blockShotave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.blockShotave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case faultave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.faultave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case foulave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.foulave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case scoreave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.scoreave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			case offensiveRoundave:
				for(int i = 0 ;i<30; i++){
					TeamTechP2L p2l = new TeamTechP2L();
					TeamTechLineItem ttli = new TeamTechLineItem();
					ttli = p2l.p2l(polist.get(i));
					result.add(ttli.offensiveRoundave);
					forSort.add(ttli);
				}
				isDouble = true;
				return result;
			default:
				return null;
		}
	}
	
	@Override
	public ArrayList<TeamTechVO> Ascend(TeamTechEnum DataType) {
		ArrayList<TeamTechVO> result = new ArrayList<TeamTechVO>();
		if(DataType==TeamTechEnum.name){
			ArrayList<TeamTechPO> resultlist = new ArrayList<TeamTechPO>();
			try {
				resultlist = ttdataservice.list();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			for(int i = 0; i<30; i++){
				TeamTechVO ttvo = new TeamTechVO();
				TeamTechP2L p2l = new TeamTechP2L();
				TeamTechL2V l2v = new TeamTechL2V();
				ttvo = l2v.l2v(p2l.p2l(resultlist.get(i)));
				result.add(ttvo);
			}
			return result;
		}
		
		ArrayList<TeamTechPO> middle = new ArrayList<TeamTechPO>();
		try {
			middle = ttdataservice.list();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList datalist = readIn(DataType, middle);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Double> tempd = new ArrayList<Double>();
		ArrayList<TeamTechLineItem> templi = new ArrayList<TeamTechLineItem>();
		if(isInt){
			mergeAscendInt(datalist, forSort, 0, middle.size()-1,temp, templi);
		}
		else if(isDouble){
			mergeAscendDouble(datalist, forSort, 0, middle.size()-1, tempd, templi);
		}
		
		for(int i = 0; i<30; i++){
			TeamTechL2V l2v = new TeamTechL2V();
			result.add(l2v.l2v(forSort.get(i)));
		}
		isInt = false;
		isDouble = false;
		return result;
	}
	
	void mergeAscendInt(ArrayList<Integer> datalist, ArrayList<TeamTechLineItem> polist, int first, int last, ArrayList<Integer> temp, ArrayList<TeamTechLineItem> templi){
		if(first<last){
			int mid = (first+last)/2;
			mergeAscendInt(datalist, polist, first, mid, temp, templi);
			mergeAscendInt(datalist, polist, mid+1, last, temp, templi);
			MergeITIntA(datalist, polist, first, mid, last, temp, templi);
		}
	}
	
	public void MergeITIntA(ArrayList<Integer> datalist, ArrayList<TeamTechLineItem> polist, int first, int mid, int last, ArrayList<Integer> temp, ArrayList<TeamTechLineItem> templi){
		int i = first, j = mid+1;
		int m = mid, n = last;
		
		while(i <= m && j <= n){
			if(datalist.get(i) <= datalist.get(j)){
				temp.add(datalist.get(i));
				templi.add(polist.get(i));
				i++;
			}else{
				temp.add(datalist.get(j));
				templi.add(polist.get(j));
				j++;
			}
		}
		
		while(i<=m){
			temp.add(datalist.get(i));
			templi.add(polist.get(i));
			i++;
		}
		
		while(j<=m){
			temp.add(datalist.get(j));
			templi.add(polist.get(j));
			j++;
		}
		for(int l = 0; l<temp.size(); l++){
			datalist.set(first+l, temp.get(l));
			polist.set(first+l, templi.get(l));
		}
		temp.clear();
		templi.clear();
	}
	
	void mergeAscendDouble(ArrayList<Double> datalist, ArrayList<TeamTechLineItem> polist, int first, int last, ArrayList<Double> temp, ArrayList<TeamTechLineItem> templi){
		if(first<last){
			int mid = (first+last)/2;
			mergeAscendDouble(datalist, polist, first, mid, temp, templi);
			mergeAscendDouble(datalist, polist, mid+1, last, temp, templi);
			MergeITDoubleA(datalist, polist, first, mid, last, temp, templi);
		}
	}
	
	public void MergeITDoubleA(ArrayList<Double> datalist, ArrayList<TeamTechLineItem> polist, int first, int mid, int last, ArrayList<Double> temp, ArrayList<TeamTechLineItem> templi){
		int i = first, j = mid+1;
		int m = mid, n = last;
		
		while(i <= m && j <= n){
			if(datalist.get(i) <= datalist.get(j)){
				temp.add(datalist.get(i));
				templi.add(polist.get(i));
				i++;
			}else{
				temp.add(datalist.get(j));
				templi.add(polist.get(j));
				j++;
			}
		}
		
		while(i<=m){
			temp.add(datalist.get(i));
			templi.add(polist.get(i));
			i++;
		}
		
		while(j<=m){
			temp.add(datalist.get(j));
			templi.add(polist.get(j));
			j++;
		}
		
		for(int l = 0; l<temp.size(); l++){
			datalist.set(first+l, temp.get(l));
			polist.set(first+l, templi.get(l));
		}
		temp.clear();
		templi.clear();
	}

	@Override
	public ArrayList<TeamTechVO> Descend(TeamTechEnum DataType) {
		ArrayList<TeamTechPO> middle = new ArrayList<TeamTechPO>();
		ArrayList<TeamTechLineItem> templi = new ArrayList<TeamTechLineItem>();
		ArrayList<TeamTechVO> result = new ArrayList<TeamTechVO>();

		try {
			middle = ttdataservice.list();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(DataType==TeamTechEnum.name){
			for(int i = 0; i<30; i++){
				TeamTechP2L p2l = new TeamTechP2L();
				TeamTechL2V l2v = new TeamTechL2V();
				result.add(l2v.l2v(p2l.p2l(middle.get(29-i))));
			}
			return result;
		}
		ArrayList datalist = readIn(DataType, middle);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Double> tempd = new ArrayList<Double>();
		if(isInt){
			mergeDescendInt(datalist, forSort, 0, middle.size()-1,temp, templi);
		}
		else if(isDouble){
			mergeDescendDouble(datalist, forSort, 0, middle.size()-1,tempd, templi);
		}

		for(int i = 0; i<30; i++){
			TeamTechL2V l2v = new TeamTechL2V();
			result.add(l2v.l2v(forSort.get(i)));
		}
		isInt = false;
		isDouble = false;
		return result;
	}
	
	void mergeDescendInt(ArrayList<Integer> datalist, ArrayList<TeamTechLineItem> polist, int first, int last, ArrayList<Integer> temp, ArrayList<TeamTechLineItem> templi){
		if(first<last){
			int mid = (first+last)/2;
			mergeDescendInt(datalist, polist, first, mid, temp, templi);
			mergeDescendInt(datalist, polist, mid+1, last, temp, templi);
			MergeITIntD(datalist, polist, first, mid, last, temp, templi);
		}
	}
	
	public void MergeITIntD(ArrayList<Integer> datalist, ArrayList<TeamTechLineItem> polist, int first, int mid, int last, ArrayList<Integer> temp, ArrayList<TeamTechLineItem> templi){
		int i = first, j = mid+1;
		int m = mid, n = last;
		
		while(i <= m && j <= n){
			if(datalist.get(i) >= datalist.get(j)){
				temp.add(datalist.get(i));
				templi.add(polist.get(i));
				i++;
			}else{
				temp.add(datalist.get(j));
				templi.add(polist.get(j));
				j++;
			}
		}
		
		while(i<=m){
			temp.add(datalist.get(i));
			templi.add(polist.get(i));
			i++;
		}
		
		while(j<=m){
			temp.add(datalist.get(j));
			templi.add(polist.get(j));
			j++;
		}
		
		for(int l = 0; l<temp.size(); l++){
			datalist.set(first+l, temp.get(l));
			polist.set(first+l, templi.get(l));
		}
		temp.clear();
		templi.clear();
	}
	
	void mergeDescendDouble(ArrayList<Double> datalist, ArrayList<TeamTechLineItem> polist, int first, int last, ArrayList<Double> temp, ArrayList<TeamTechLineItem> templi){
		if(first<last){
			int mid = (first+last)/2;
			mergeDescendDouble(datalist, polist, first, mid, temp, templi);
			mergeDescendDouble(datalist, polist, mid+1, last, temp, templi);
			MergeITDoubleD(datalist, polist, first, mid, last, temp, templi);
		}
	}
	
	public void MergeITDoubleD(ArrayList<Double> datalist, ArrayList<TeamTechLineItem> polist, int first, int mid, int last, ArrayList<Double> temp, ArrayList<TeamTechLineItem> templi){
		int i = first, j = mid+1;
		int m = mid, n = last;
		
		while(i <= m && j <= n){
			if(datalist.get(i) >= datalist.get(j)){
				temp.add(datalist.get(i));
				templi.add(polist.get(i));
				i++;
			}else{
				temp.add(datalist.get(j));
				templi.add(polist.get(j));
				j++;
			}
		}
		
		while(i<=m){
			temp.add(datalist.get(i));
			templi.add(polist.get(i));
			i++;
		}
		
		while(j<=m){
			temp.add(datalist.get(j));
			templi.add(polist.get(j));
			j++;
		}
		
		for(int l = 0; l<temp.size(); l++){
			datalist.set(first+l, temp.get(l));
			polist.set(first+l, templi.get(l));
		}
		temp.clear();
		templi.clear();
	}

	@Override
	public ArrayList<TeamTechVO> refresh(SortEnum sort, TeamTechEnum DataType) {
		if(sort==SortEnum.ascend){
			return Ascend(DataType);
		}else if(sort==SortEnum.descend){
			return Descend(DataType);
		}
		return null;
	}

	@Override
	public ArrayList<TeamTechVO> findSeasonHotTeam(TeamTechEnum DataType) {
		ArrayList<TeamTechVO> result = new ArrayList<TeamTechVO>();
		ArrayList<TeamTechVO> all = Descend(DataType);
		for(int i = 0; i<5 ; i++){
			result.add(all.get(i));
		}
		return result;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		ttdataservice.WriteIn();
	}
	
}
