package cmdTest;

import java.io.PrintStream;
import java.util.ArrayList;

public class Console {
	public void execute(PrintStream out, String[]args){
		AnalysecmdOption cmdAnalyse = new AnalysecmdOption();
		cmdAnalyse.setArgs(args);
		cmdAnalyse.start();
		ArrayList<?>result = cmdAnalyse.getResult();
		for(int i = 0; i<result.size(); i++){
			out.print(result.get(i));
		}
	}
}
