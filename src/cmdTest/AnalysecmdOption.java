package cmdTest;

import java.util.ArrayList;

import de.tototec.cmdoption.CmdlineParser;

public class AnalysecmdOption {
	static ArrayList<?> result;
	String[] args;
	
	public void start(){
		PlayerCommond pc = new PlayerCommond();
		TeamCommond tc = new TeamCommond();
		CmdlineParser cp = new CmdlineParser(new Object[]{pc, tc});
		cp.parse(args);
	}
	
	public void setArgs(String[] args){
		this.args = args;
	}
	
	public ArrayList<?> getResult(){
		return this.result;
	}
}
