package cmdTest;

import java.io.PrintStream;

import de.tototec.cmdoption.CmdlineParser;

public class Console {
	public void execute(PrintStream out, String[]args){
		Config c = new Config();
		TeamCommond tc = new TeamCommond(out);
		PlayerCommond pc = new PlayerCommond(out);
		CmdlineParser cp = new CmdlineParser(c,tc,pc);
		cp.parse(args);
		if(cp.getParsedCommandName()==null)return;
		
		if(cp.getParsedCommandName().equals("-team")){
			TeamCommond CmdObj = (TeamCommond)cp.getParsedCommandObject();
			CmdObj.setPrintStream(out);
		}
		if(cp.getParsedCommandName().equals("-player")){
			PlayerCommond CmdObj = (PlayerCommond)cp.getParsedCommandObject();
			CmdObj.setPrintStream(out);
		}
	}
}
