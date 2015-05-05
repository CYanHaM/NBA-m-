package bussinesslogic.Transfer.P2L;

import PO.TeamPO;
import bussinesslogic.TeamBL.TeamLineItem;

public class TeamP2L {
	TeamLineItem tli = new TeamLineItem();
	public TeamLineItem p2l(TeamPO tpo){
		tli.fullName = (tpo.fullName==null) ? null : tpo.fullName;
		tli.abbreviation = (tpo.abbreviation==null) ? null : tpo.abbreviation;
		tli.location = (tpo.location==null) ? null : tpo.location;
		tli.division = (tpo.division==null) ? null : tpo.division;
		tli.partition = (tpo.partition==null) ? null : tpo.partition;
		tli.homeCourt = (tpo.homeCourt==null) ? null : tpo.homeCourt;
		tli.time = (tpo.time==null) ? null : tpo.time;
		return tli;
	}
}
