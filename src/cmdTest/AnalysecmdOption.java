package cmdTest;

import java.util.ArrayList;

import TypeEnum.TeamTechEnum;
import bussinesslogic.BLinit;
import bussinesslogic.TeamTech.TeamTech;
import bussinesslogic.playertechbl.HotAndKing;
import bussinesslogic.playertechbl.NormalAvg;
import bussinesslogic.playertechbl.NormalTotal;
import bussinesslogic.playertechbl.SortHigh;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;

public class AnalysecmdOption {
	static ArrayList result;
	String[] args;
	
	public void start(){
		PlayerCommond pc = new PlayerCommond();
		TeamCommond tc = new TeamCommond();
		CmdlineParser cp = new CmdlineParser(pc, tc);
		cp.parse(args);
		if(cp.getParsedCommandName()==null)return;
		if(cp.getParsedCommandName().equals("-player")){
			pc = (PlayerCommond)cp.getParsedCommandObject();
			setResult(pc.result);
		}else if(cp.getParsedCommandName().equals("-team")){
			tc = (TeamCommond)cp.getParsedCommandObject();
			setResult(tc.result);
		}
	}
	
	public void setArgs(String[] args){
		this.args = args;
	}
	
	public ArrayList getResult(){
		return this.result;
	}
	public void setResult(ArrayList set){
		this.result = set;
	}
	
	@CmdOption(names = {"--datasource"}, args = "source", maxCount = 1, minCount = 0)
	public void setSource(String source){
		BLinit bi = new BLinit();
		bi.init(source);
	}
	
	@CmdCommand(names = {"-team"})
	class TeamCommond {
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
	
	@CmdCommand(names = {"-player"})	
	class PlayerCommond {
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
}
