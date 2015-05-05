package bussinesslogic.Transfer.P2L;

import PO.TeamTechPO;
import bussinesslogic.TeamTech.TeamTechLineItem;

public class TeamTechP2L {
	TeamTechLineItem ttli = new TeamTechLineItem();
	public TeamTechLineItem p2l(TeamTechPO ttpo){
		ttli.name = (ttpo.name==null) ? null : ttpo.name;
		ttli.season = (ttpo.season==null) ? null : ttpo.season;
		ttli.gameNum = ttpo.gameNum;
		ttli.shotInNum = ttpo.shotInNum;
		ttli.shotNum = ttpo.shotNum;
		ttli.threeShotInNum = ttpo.threeShotInNum;
		ttli.threeShotNum = ttpo.threeShotNum;
		ttli.penaltyShotInNum = ttpo.penaltyShotInNum;
		ttli.penaltyShotNum = ttpo.penaltyShotNum;
		ttli.offensiveRebound = ttpo.offensiveRebound;
		ttli.defensiveRebound = ttpo.defensiveRebound;
		ttli.rebound = ttpo.rebound;
		ttli.secondaryAttack = ttpo.secondaryAttack;
		ttli.steal = ttpo.steal;
		ttli.blockShot = ttpo.blockShot;
		ttli.fault = ttpo.fault;
		ttli.foul = ttpo.foul;
		ttli.score = ttpo.score;
		ttli.shotInRate = ttpo.shotInRate;
		ttli.threeShotInRate = ttpo.threeShotInRate;
		ttli.penaltyShotInRate = ttpo.penaltyShotInRate;
		ttli.winningRate = ttpo.winningRate;
		ttli.offensiveRound = ttpo.offensiveRound;
		ttli.offensiveEfficiency = ttpo.offensiveEfficiency;
		ttli.defensiveEfficiency = ttpo.defensiveEfficiency;
		ttli.reboundEfficiency = ttpo.reboundEfficiency;
		ttli.stealEfficiency = ttpo.stealEfficiency;
		ttli.secondaryAttackEfficiency = ttpo.secondaryAttackEfficiency;
		
		if(ttli.gameNum==0){
			
		}else{
			ttli.shotInNumave = ttli.shotInNum/ttli.gameNum;
			ttli.shotNumave = ttli.shotNum/ttli.gameNum;
			ttli.threeShotInNumave = ttli.threeShotInNum/ttli.gameNum;
			ttli.threeShotNumave = ttli.threeShotNum/ttli.gameNum;
			ttli.penaltyShotInNumave = ttli.penaltyShotInNum/ttli.gameNum;
			ttli.penaltyShotNumave = ttli.penaltyShotNum/ttli.gameNum;
			ttli.offensiveReboundave = ttli.offensiveRebound/ttli.gameNum;
			ttli.defensiveReboundave = ttli.defensiveRebound/ttli.gameNum;
			ttli.reboundave = ttli.rebound/ttli.gameNum;
			ttli.secondaryAttackave = ttli.secondaryAttack/ttli.gameNum;
			ttli.stealave = ttli.steal/ttli.gameNum;
			ttli.blockShotave = ttli.blockShot/ttli.gameNum;
			ttli.faultave = ttli.fault/ttli.gameNum;
			ttli.foulave = ttli.foul/ttli.gameNum;
			ttli.scoreave = ttli.score/ttli.gameNum;
			ttli.offensiveRoundave = ttli.offensiveRound/ttli.gameNum;
		}
		ttli.winningNum = ttpo.winningNum;
		return ttli;
	}
}
