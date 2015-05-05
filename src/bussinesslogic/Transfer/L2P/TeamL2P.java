package bussinesslogic.Transfer.L2P;

import PO.TeamPO;
import bussinesslogic.TeamBL.TeamLineItem;

public class TeamL2P {
	TeamPO tpo = new TeamPO();
	public TeamPO l2p(TeamLineItem tli){
		if(tli.abbreviation.equals("NOH")){
			tpo.abbreviation = "NOP";
			return tpo;
			}
		tpo.fullName = (tli.fullName==null) ? null : tli.fullName;
		tpo.abbreviation = (tli.abbreviation==null) ? null : tli.abbreviation;
		tpo.location = (tli.location==null) ? null : tli.location;
		tpo.division = (tli.division==null) ? null : tli.division;
		tpo.partition = (tli.partition==null) ? null : tli.partition;
		tpo.homeCourt = (tli.homeCourt==null) ? null : tli.homeCourt;
		tpo.time = (tli.time==null) ? null : tli.time;
		return tpo;
	}
}
