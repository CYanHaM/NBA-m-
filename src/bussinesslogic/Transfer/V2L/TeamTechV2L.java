package bussinesslogic.Transfer.V2L;

import VO.TeamTechVO;
import bussinesslogic.TeamTech.TeamTechLineItem;

public class TeamTechV2L {
	TeamTechLineItem ttli = new TeamTechLineItem();
	public TeamTechLineItem v2l(TeamTechVO ttvo){
		ttli.name = (ttvo.name==null) ? null : ttvo.name;
		ttli.season = (ttvo.season==null) ? null : ttvo.season;
		ttli.gameNum = ttvo.gameNum;
		ttli.shotInRate = ttvo.shotInRate;
		ttli.threeShotInRate = ttvo.threeShotInRate;
		ttli.penaltyShotInRate = ttvo.penaltyShotInRate;
		ttli.winningRate = ttvo.winningRate;
		ttli.offensiveEfficiency = ttvo.offensiveEfficiency;
		ttli.defensiveEfficiency = ttvo.defensiveEfficiency;
		ttli.reboundEfficiency = ttvo.reboundEfficiency;
		ttli.stealEfficiency = ttvo.stealEfficiency;
		ttli.secondaryAttackEfficiency = ttvo.secondaryAttackEfficiency;
		
		ttli.shotInNum = ttvo.shotInNum;
		ttli.shotNum = ttvo.shotNum;
		ttli.threeShotInNum = ttvo.threeShotInNum;
		ttli.threeShotNum = ttvo.threeShotNum;
		ttli.penaltyShotInNum = ttvo.penaltyShotInNum;
		ttli.penaltyShotNum = ttvo.penaltyShotNum;
		ttli.offensiveRebound = ttvo.offensiveRebound;
		ttli.defensiveRebound = ttvo.defensiveRebound;
		ttli.rebound = ttvo.rebound;
		ttli.secondaryAttack = ttvo.secondaryAttack;
		ttli.steal = ttvo.steal;
		ttli.blockShot = ttvo.blockShot;
		ttli.fault = ttvo.fault;
		ttli.foul = ttvo.foul;
		ttli.score = ttvo.score;
		ttli.offensiveRound = ttvo.offensiveRound;
		
		ttli.shotInNumave = ttvo.shotInNumave;
		ttli.shotNumave = ttvo.shotNumave;
		ttli.threeShotInNumave = ttvo.threeShotInNumave;
		ttli.threeShotNumave = ttvo.threeShotNumave;
		ttli.penaltyShotInNumave = ttvo.penaltyShotInNumave;
		ttli.penaltyShotNumave = ttvo.penaltyShotNumave;
		ttli.offensiveReboundave = ttvo.offensiveReboundave;
		ttli.defensiveReboundave = ttvo.defensiveReboundave;
		ttli.reboundave = ttvo.reboundave;
		ttli.secondaryAttackave = ttvo.secondaryAttackave;
		ttli.stealave = ttvo.stealave;
		ttli.blockShotave = ttvo.blockShotave;
		ttli.faultave = ttvo.faultave;
		ttli.foulave = ttvo.foulave;
		ttli.scoreave = ttvo.scoreave;
		ttli.offensiveRoundave = ttvo.offensiveRoundave;
		
		ttli.winningNum = ttvo.winningNum;
		return ttli;
	}
}
