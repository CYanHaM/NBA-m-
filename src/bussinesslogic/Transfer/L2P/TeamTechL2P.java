package bussinesslogic.Transfer.L2P;

import PO.TeamTechPO;
import bussinesslogic.TeamTech.TeamTechLineItem;

public class TeamTechL2P {
	TeamTechPO ttpo = new TeamTechPO();
	public TeamTechPO l2p(TeamTechLineItem ttli){
		ttpo.name = (ttli.name==null) ? null : ttli.name;
		ttpo.season = (ttli.season==null) ? null : ttli.season;
		ttpo.gameNum = ttli.gameNum;
		ttpo.shotInNum = ttli.shotInNum;
		ttpo.shotNum = ttli.shotNum;
		ttpo.threeShotInNum = ttli.threeShotInNum;
		ttpo.threeShotNum = ttli.threeShotNum;
		ttpo.penaltyShotInNum = ttli.penaltyShotInNum;
		ttpo.penaltyShotNum = ttli.penaltyShotNum;
		ttpo.offensiveRebound = ttli.offensiveRebound;
		ttpo.defensiveRebound = ttli.defensiveRebound;
		ttpo.rebound = ttli.rebound;
		ttpo.secondaryAttack = ttli.secondaryAttack;
		ttpo.steal = ttli.steal;
		ttpo.blockShot = ttli.blockShot;
		ttpo.fault = ttli.fault;
		ttpo.foul = ttli.foul;
		ttpo.score = ttli.score;
		ttpo.shotInRate = ttli.shotInRate;
		ttpo.threeShotInRate = ttli.threeShotInRate;
		ttpo.penaltyShotInRate = ttli.penaltyShotInRate;
		ttpo.winningRate = ttli.winningRate;
		ttpo.offensiveRound = ttli.offensiveRound;
		ttpo.offensiveEfficiency = ttli.offensiveEfficiency;
		ttpo.defensiveEfficiency = ttli.defensiveEfficiency;
		ttpo.reboundEfficiency = ttli.reboundEfficiency;
		ttpo.stealEfficiency = ttli.stealEfficiency;
		ttpo.secondaryAttackEfficiency = ttli.secondaryAttackEfficiency;
		
		ttpo.winningNum = ttli.winningNum;
		return ttpo;
	}
}
