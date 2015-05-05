package bussinesslogic.Transfer.L2V;

import VO.TeamVO;
import bussinesslogic.TeamBL.TeamLineItem;

public class TeamL2V {
	TeamVO tvo = new TeamVO();
	public TeamVO l2v(TeamLineItem tli){
		tvo.fullName = (tli.fullName==null) ? null : tli.fullName;
		tvo.abbreviation = (tli.abbreviation==null) ? null : tli.abbreviation;
		tvo.location = (tli.location==null) ? null : tli.location;
		tvo.division = (tli.division==null) ? null : tli.division;
		tvo.partition = (tli.partition==null) ? null : tli.partition;
		tvo.homeCourt = (tli.homeCourt==null) ? null : tli.homeCourt;
		tvo.time = (tli.time==null) ? null : tli.time;
		return tvo;
	}
}
