package cmdTest;

import java.util.ArrayList;

import test.data.TeamHotInfo;
import TypeEnum.TeamTechEnum;
import bussinesslogic.TeamTech.TeamTech;
import bussinesslogic.TeamTech.TeamTechLineItem;
import de.tototec.cmdoption.CmdOption;

public class TeamCommond {
	public ArrayList<?> result = new ArrayList();
	private boolean isTotal = false;
	private boolean isHigh = false;
	private int num = 30;
	TeamTech tt = new TeamTech();
	
	@CmdOption(names = {"-sort"}, description = "sort", args = "condition", maxCount = 1, minCount = 0, conflictsWith={"-hot"})
	public void sort (String condition){
		if(isHigh){
			this.result = tt.sortHigh(condition, num);
		}else{
			this.result = tt.sortNorm(condition, num, isTotal);
		}
	}
	
	@CmdOption(names = {"-hot"}, args="field", description = "hotteams", maxCount = 1, minCount = 0, conflictsWith={"-sort", "-total"})
	public void setHot(String field){
		TeamTechEnum dataType = null;
		switch(field){
		case "point": 
			dataType = TeamTechEnum.scoreave;
		case "rebound":
			dataType = TeamTechEnum.reboundave;
		case "assist":
			dataType = TeamTechEnum.secondaryAttackave;
		case "blockShot":
			dataType = TeamTechEnum.blockShotave;
		case "steal":
			dataType = TeamTechEnum.stealave;
		case "foul":
			dataType = TeamTechEnum.foulave;
		case "fault":
			dataType = TeamTechEnum.faultave;
		case "shot":
			dataType = TeamTechEnum.shotInRate;
		case "three":
			dataType = TeamTechEnum.threeShotInRate;
		case "penalty":
			dataType = TeamTechEnum.penaltyShotInRate;
		case "defendRebound":
			dataType = TeamTechEnum.defensiveReboundave;
		case "offendRebound":
			dataType = TeamTechEnum.offensiveReboundave;
		}
		result = tt.findSeasonHotTeam(dataType, field, num);
	}
		
	
	@CmdOption(names = ("-n"), args="number", description = "numbers", maxCount = 1, minCount = 0)
	public void setnum(String number){
		num = Integer.parseInt(number);
	}
	
	@CmdOption(names = {"-total"}, maxCount = 1, minCount = 0, conflictsWith = {"avg"})
	public void setTotal(){
		isTotal = true;
	}
	
	@CmdOption(names = {"-high"}, maxCount = 1, minCount = 0, requires = {"-sort","-n"})
	public void setHigh(){
		isHigh = true;
	}
}
