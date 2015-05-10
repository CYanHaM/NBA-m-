package cmdTest;

import java.util.ArrayList;

import de.tototec.cmdoption.CmdOption;
import bussinesslogic.playertechbl.HotAndKing;
import bussinesslogic.playertechbl.NormalAvg;
import bussinesslogic.playertechbl.NormalTotal;
import bussinesslogic.playertechbl.SortHigh;

public class PlayerCommond {
	public ArrayList<?> result = new ArrayList();
	private boolean isTotal = false;
	private int num = 50;
	boolean isSeason = false;
	boolean isAll = true;
	String filter = null;
	String sortCondition = null;
	HotAndKing hk = new HotAndKing();
	
	@CmdOption(names = {"-total"}, conflictsWith = {"avg"})
	public void setTotal(){
		isTotal = true;
	}
	
	@CmdOption(names = {"-season"}, description = "seasonKing", requires="-king", conflictsWith={"daily","filter","sort","total"})
	public void setSeason(String field){
		isSeason = true;
	}
	
	@CmdOption(names = {"-daily"}, description = "dailyKing",  requires="-king",conflictsWith={"season","filter","sort","total"})
	public void setDaily(String field){
		
	}
	
	@CmdOption(names = {"-n"}, args="number", description = "numbers")
	public void setnum(String number){
		num = Integer.parseInt(number);
	}
	
	@CmdOption(names = {"-hot"}, args="field", description = "hotPlayer", conflictsWith={"total","-sort","hot", "filter"})
	public void setHot(String field){
		result = hk.findHotPlayer(field, num);
	}

	@CmdOption(names = {"-king"}, args="field", description = "kingPlayer", conflictsWith={"total","-sort", "filter","hot"})
	public void setKing(String field){
		if(isSeason)
			result = hk.findSeasonKingPlayer(field, num);
		else
			result = hk.findTodayKingPlayer(field, num);
	}
			
	@CmdOption(names = {"-filter"}, args="field", conflictsWith={"-hot","king","high"})
	public void filter(String field){
		filter = field;
	}
	
	@CmdOption(names = {"-sort"}, args="sort", conflictsWith={"-hot","king"})
	public void sort(String sort){
		sortCondition = sort;
	}
	
	@CmdOption(names = {"-player"})
	public void normal(){
		if(num!=0){
			if(isTotal){
				NormalTotal nt = new NormalTotal();
				result = nt.normalAll(filter, sortCondition, num);
			}
			else{
				NormalAvg na = new NormalAvg();
				result = na.normalAll(filter, sortCondition, num);
			}
		}		
	}
	
	@CmdOption(names = {"-high"}, conflictsWith = {"-all","-avg","-hot","-king","filter"})
	public void setHigh(){
		if(num!=0){
			SortHigh sh = new SortHigh();
			result = sh.highAll(sortCondition, num);
		}
	}
}