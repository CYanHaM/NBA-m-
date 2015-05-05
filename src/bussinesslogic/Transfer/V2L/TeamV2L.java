package bussinesslogic.Transfer.V2L;

import VO.TeamVO;
import bussinesslogic.TeamBL.TeamLineItem;

public class TeamV2L {
	TeamLineItem tli = new TeamLineItem();
	public TeamLineItem v2l (TeamVO tvo){
		tli.fullName = (tvo.fullName==null) ? null : tvo.fullName;
		tli.abbreviation = (tvo.abbreviation==null) ? null : tvo.abbreviation;
		tli.location = (tvo.location==null) ? null : tvo.location;
		tli.division = (tvo.division==null) ? null : tvo.division;
		tli.partition = (tvo.partition==null) ? null : tvo.partition;
		tli.homeCourt = (tvo.homeCourt==null) ? null : tvo.homeCourt;
		tli.time = (tvo.time==null) ? null : tvo.time;
		return tli;
	}
}
