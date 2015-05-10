package cmdTest;

import java.io.PrintStream;
import java.util.ArrayList;

import bussinesslogic.playertechbl.HotAndKing;
import bussinesslogic.playertechbl.NormalAvg;
import bussinesslogic.playertechbl.NormalTotal;
import bussinesslogic.playertechbl.SortHigh;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;

@CmdCommand(names={"-player","-p"},description="Show Player Infomation")
public class PlayerCommond {
	PrintStream outhere;
	public PlayerCommond(PrintStream out){
		outhere = out;
	}
	
	public void setPrintStream(PrintStream out){
		outhere = out;
	}
	
	public ArrayList<?> result = new ArrayList();
	private boolean isTotal = false;
	private int num = 50;
	private int starNum = 5;
	boolean isSeason = false;
	boolean isAll = true;
	String filter = null;
	String sortCondition = null;
	HotAndKing hk = new HotAndKing();
	
	@CmdOption(names = {"-total"})
	public void setTotal(){
		isTotal = true;
	}
	
	@CmdOption(names={"-all"})
	public void no(){
		
	}
	
	@CmdOption(names={"-daily"})
	public void no1(){
		
	}
	
	@CmdOption(names = {"-season"}, description = "seasonKing", requires="-king", conflictsWith={"-filter","-sort","-total"})
	public void setSeason(String field){
		isSeason = true;
	}
	
	@CmdOption(names = {"-n"}, args="number", description = "numbers")
	public void setnum(String number){
		num = Integer.parseInt(number);
		starNum = Integer.parseInt(number);
	}
	
	@CmdOption(names = {"-hot"}, args="field", description = "hotPlayer", conflictsWith={"-total","-sort", "-filter"})
	public void setHot(String field){
		result = hk.findHotPlayer(field, starNum);
		for(int i = 0; i<result.size(); i++){
			outhere.print(result.get(i));
		}
	}

	@CmdOption(names = {"-king"}, args="field", description = "kingPlayer", conflictsWith={"-total","-sort", "-filter","-hot"})
	public void setKing(String field){
		if(isSeason)
			result = hk.findSeasonKingPlayer(field, starNum);
		else
			result = hk.findTodayKingPlayer(field, starNum);
		for(int i = 0; i<result.size(); i++){
			outhere.print(result.get(i));
		}
	}
			
	@CmdOption(names = {"-filter"}, args="field", conflictsWith={"-hot","-king","-high"})
	public void filter(String field){
		filter = field;
		if(num!=0){
			if(isTotal){
				NormalTotal nt = new NormalTotal();
				result = nt.normalAll(filter, sortCondition, num);
			}
			else{
				NormalAvg na = new NormalAvg();
				result = na.normalAll(filter, sortCondition, num);
			}
			for(int i = 0; i<result.size(); i++){
				outhere.print(result.get(i));
			}
		}
	}
	
	@CmdOption(names = {"-sort"}, args="sort", conflictsWith={"-hot","-king"})
	public void sort(String sort){   
		sortCondition = sort;
		if(num!=0){
			if(isTotal){
				NormalTotal nt = new NormalTotal();
				result = nt.normalAll(filter, sortCondition, num);
			}
			else{
				NormalAvg na = new NormalAvg();
				result = na.normalAll(filter, sortCondition, num);
			}
			for(int i = 0; i<result.size(); i++){
				outhere.print(result.get(i));
			}
		}
	}
	
	@CmdOption(names = {"-high"}, conflictsWith = {"-hot","-king","-filter"})
	public void setHigh(){
		if(num!=0){
			SortHigh sh = new SortHigh();
			result = sh.highAll(sortCondition, num);
			for(int i = 0; i<result.size(); i++){
				outhere.print(result.get(i));
			}
		}
		
	}
}