package cmdTest;

import bussinesslogic.BLinit;
import de.tototec.cmdoption.CmdOption;

public class Config {
	@CmdOption(names={"--datasourse"},args={"dataSourse"})
	public void setData(String dataSourse){
		BLinit bi = new BLinit();
		bi.init(dataSourse);
	}
}
