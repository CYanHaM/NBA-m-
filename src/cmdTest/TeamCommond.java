package cmdTest;

import java.util.ArrayList;

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
		ArrayList<TeamTechLineItem> temp = new ArrayList<TeamTechLineItem>();
		TeamTechEnum dataType;
		switch(condition){
		case "point": 
			if(isTotal){
				dataType = TeamTechEnum.score;
			}else{
				dataType = TeamTechEnum.scoreave;
			}
		case "rebound":
			if(isTotal){
				dataType = TeamTechEnum.rebound;
			}else{
				dataType = TeamTechEnum.reboundave;
			}
		case 
		}
	}
	
	@CmdOption(names = {"-hot"}, args="field", description = "hotteams", maxCount = 1, minCount = 0, conflictsWith={"-sort", "-total"})
	public void setHot(String field){
		ArrayList<TeamTechLineItem> temp = new ArrayList<TeamTechLineItem>();
	}
	
	@CmdOption(names = {"-n"}, args="number", description = "numbers", maxCount = 1, minCount = 0)
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

