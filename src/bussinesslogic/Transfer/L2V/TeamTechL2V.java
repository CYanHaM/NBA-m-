package bussinesslogic.Transfer.L2V;

import VO.TeamTechVO;
import bussinesslogic.TeamTech.TeamTechLineItem;

public class TeamTechL2V {
	TeamTechVO ttvo = new TeamTechVO();
	public TeamTechVO l2v(TeamTechLineItem ttli){
		ttvo.name = (ttli.name==null) ? null : ttli.name;
		ttvo.season = (ttli.season==null) ? null : ttli.season;
		ttvo.gameNum = ttli.gameNum;
		ttvo.shotInRate = ttli.shotInRate;
		ttvo.threeShotInRate = ttli.threeShotInRate;
		ttvo.penaltyShotInRate = ttli.penaltyShotInRate;
		ttvo.winningRate = ttli.winningRate;
		ttvo.offensiveEfficiency = ttli.offensiveEfficiency;
		ttvo.defensiveEfficiency = ttli.defensiveEfficiency;
		ttvo.reboundEfficiency = ttli.reboundEfficiency;
		ttvo.stealEfficiency = ttli.stealEfficiency;
		ttvo.secondaryAttackEfficiency = ttli.secondaryAttackEfficiency;
		
		ttvo.shotInNum = ttli.shotInNum;
		ttvo.shotNum = ttli.shotNum;
		ttvo.threeShotInNum = ttli.threeShotInNum;
		ttvo.threeShotNum = ttli.threeShotNum;
		ttvo.penaltyShotInNum = ttli.penaltyShotInNum;
		ttvo.penaltyShotNum = ttli.penaltyShotNum;
		ttvo.offensiveRebound = ttli.offensiveRebound;
		ttvo.defensiveRebound = ttli.defensiveRebound;
		ttvo.rebound = ttli.rebound;
		ttvo.secondaryAttack = ttli.secondaryAttack;
		ttvo.steal = ttli.steal;
		ttvo.blockShot = ttli.blockShot;
		ttvo.fault = ttli.fault;
		ttvo.foul = ttli.foul;
		ttvo.score = ttli.score;
		ttvo.offensiveRound = ttli.offensiveRound;
		
		ttvo.shotInNumave = ttli.shotInNumave;
		ttvo.shotNumave = ttli.shotNumave;
		ttvo.threeShotInNumave = ttli.threeShotInNumave;
		ttvo.threeShotNumave = ttli.threeShotNumave;
		ttvo.penaltyShotInNumave = ttli.penaltyShotInNumave;
		ttvo.penaltyShotNumave = ttli.penaltyShotNumave;
		ttvo.offensiveReboundave = ttli.offensiveReboundave;
		ttvo.defensiveReboundave = ttli.defensiveReboundave;
		ttvo.reboundave = ttli.reboundave;
		ttvo.secondaryAttackave = ttli.secondaryAttackave;
		ttvo.stealave = ttli.stealave;
		ttvo.blockShotave = ttli.blockShotave;
		ttvo.faultave = ttli.faultave;
		ttvo.foulave = ttli.foulave;
		ttvo.scoreave = ttli.scoreave;
		ttvo.offensiveRoundave = ttli.offensiveRoundave;
		
		ttvo.winningNum = ttli.winningNum;
		return ttvo;
	}
}
