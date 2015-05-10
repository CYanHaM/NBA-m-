package cmdTest;

import java.util.ArrayList;

import test.data.PlayerHotInfo;
import de.tototec.cmdoption.CmdOption;
import bussinesslogic.playertechbl.HotAndKing;
import bussinesslogic.playertechbl.PlayerTechFind;

public class PlayerCommond {
	public ArrayList<?> result = new ArrayList();
	private boolean isTotal = false;
	private boolean isHigh = false;
	private int num = 50;
	boolean isSeason = false;
	boolean isAll = true;
	HotAndKing hk = new HotAndKing();
	PlayerTechFind ptf = new PlayerTechFind();
	
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
			result = hk
	}
	
	@CmdOption(names = {"-high"}, conflictsWith = {"-all","-avg","-hot","-king","filter"})
	public void setHigh(){
		isHigh = true;
	}
			
	@CmdOption(names = {"-filter"}, args="field.value", conflictsWith={"-hot","king","high"})
	public void filter(){
		
	}
	
	@CmdOption(names = {"-sort"}, args="field.sortOrder", conflictsWith={"-hot","king"})
	public void sort(){
		
	}
}
