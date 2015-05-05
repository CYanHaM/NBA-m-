package bussinesslogic.Transfer;

import java.util.ArrayList;

import PO.PlayerTechPO;
import VO.PlayerTechVO;

public class PlayerTechTransfer {
	
	public ArrayList<PlayerTechVO> list2vo(ArrayList<PlayerTechPO> list){
		int size = list.size();
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		for(int i=0;i<size;i++){
			PlayerTechPO po = list.get(i);
			PlayerTechVO vo = new PlayerTechVO();
			vo.name = po.name;
			vo.season = po.season;
			vo.team = po.team;
			vo.position=po.position;
			vo.division =po.division ;
			vo.gameNum = po.gameNum;
			vo.startingNum = po.startingNum;
			vo.shotInRate = po.shotInRate;
			vo.threeShotInRate = po.threeShotInRate;
			vo.penaltyShotInRate = po.penaltyShotInRate;
			vo.efficiency = po.efficiency;
			vo.GmScEfficiency = po.GmScEfficiency;
			vo.trueShotInRate = po.trueShotInRate;
			vo.shootingEfficiency = po.shootingEfficiency;
			vo.reboundRate = po.reboundRate;
			vo.offensiveReboundRate = po.offensiveReboundRate;
			vo.defensiveReboundRate = po.defensiveReboundRate;
			vo.secondaryAttackRate = po.secondaryAttackRate;
			vo.stealRate = po.stealRate;
			vo.blockShotRate = po.blockShotRate;
			vo.faultRate = po.faultRate;
			vo.usageRate = po.usageRate;
			
			//����������
			vo.offensiveNum = po.offensiveNum;
			vo.defensiveNum = po.defensiveNum;
			vo.steal = po.steal;
			vo.blockShot = po.blockShot;
			vo.fault = po.fault;
			vo.foul = po.foul;
			vo.score = po.score;
			vo.rebound = po.rebound;
			vo.secondaryAttack = po.secondaryAttack;
			vo.time = po.time;
			vo.ifDouble=po.ifDouble;
			
			//����shuju
			if(po.gameNum==0){
				vo.offensiveNumave = 0;
				vo.defensiveNumave= 0;
				vo.stealave = 0;
				vo.blockShotave = 0;
				vo.faultave = 0;
				vo.foulave = 0;
				vo.scoreave = 0;
				vo.reboundave = 0;
				vo.secondaryAttackave = 0;
				vo.timeave = 0;
			}
			else{
				vo.offensiveNumave = po.offensiveNum/po.gameNum;
				vo.defensiveNumave= po.defensiveNum/po.gameNum;
				vo.stealave = po.steal/po.gameNum;
				vo.blockShotave =po.blockShot/po.gameNum;
				vo.faultave = po.fault/po.gameNum;
				vo.foulave = po.foul/po.gameNum;
				vo.scoreave = po.score/po.gameNum;
				vo.reboundave = po.rebound/po.gameNum;
				vo.secondaryAttackave = po.secondaryAttack/po.gameNum;
				vo.timeave = po.time/po.gameNum;
			}
			
			//������
			vo.scoreImproving = po.scoreImproving;
			vo.stealImproving = po.stealImproving;
			vo.blockShotImproving = po.blockShotImproving;
			vo.secondaryAttackImproving = po.secondaryAttackImproving;
			vo.reboundImproving = po.reboundImproving;
			
			res.add(vo);
		}	
		return res;
	}
	
	//��sift����ʹ�ã���ֻ������ؼ�����
	public PlayerTechPO vo2po(PlayerTechVO vo){
		PlayerTechPO po = new PlayerTechPO();
		po.name = vo.name;
		po.season = vo.season;
		po.team = vo.team;
		po.position=vo.position;
		po.division =vo.division ;
		po.steal = vo.steal;
		po.blockShot = vo.blockShot;
		po.score = vo.score;
		po.rebound = vo.rebound;
		po.secondaryAttack = vo.secondaryAttack;
		po.ifDouble=vo.ifDouble;

		
		return po;
	}
	
	public PlayerTechVO po2vo(PlayerTechPO po){
		PlayerTechVO vo = new PlayerTechVO();
		vo.name = po.name;
		vo.season = po.season;
		vo.team = po.team;
		vo.position=po.position;
		vo.division =po.division ;
		vo.gameNum = po.gameNum;
		vo.startingNum = po.startingNum;
		vo.shotInRate = po.shotInRate;
		vo.threeShotInRate = po.threeShotInRate;
		vo.penaltyShotInRate = po.penaltyShotInRate;
		vo.efficiency = po.efficiency;
		vo.GmScEfficiency = po.GmScEfficiency;
		vo.trueShotInRate = po.trueShotInRate;
		vo.shootingEfficiency = po.shootingEfficiency;
		vo.reboundRate = po.reboundRate;
		vo.offensiveReboundRate = po.offensiveReboundRate;
		vo.defensiveReboundRate = po.defensiveReboundRate;
		vo.secondaryAttackRate = po.secondaryAttackRate;
		vo.stealRate = po.stealRate;
		vo.blockShotRate = po.blockShotRate;
		vo.faultRate = po.faultRate;
		vo.usageRate = po.usageRate;
		
		//����������
		vo.offensiveNum = po.offensiveNum;
		vo.defensiveNum = po.defensiveNum;
		vo.steal = po.steal;
		vo.blockShot = po.blockShot;
		vo.fault = po.fault;
		vo.foul = po.foul;
		vo.score = po.score;
		vo.rebound = po.rebound;
		vo.secondaryAttack = po.secondaryAttack;
		vo.time = po.time;
		vo.ifDouble=po.ifDouble;

		//����shuju
		if(po.gameNum==0){
			vo.offensiveNumave = 0;
			vo.defensiveNumave= 0;
			vo.stealave = 0;
			vo.blockShotave = 0;
			vo.faultave = 0;
			vo.foulave = 0;
			vo.scoreave = 0;
			vo.reboundave = 0;
			vo.secondaryAttackave = 0;
			vo.timeave = 0;
		}
		else{
			vo.offensiveNumave = po.offensiveNum/po.gameNum;
			vo.defensiveNumave= po.defensiveNum/po.gameNum;
			vo.stealave = po.steal/po.gameNum;
			vo.blockShotave =po.blockShot/po.gameNum;
			vo.faultave = po.fault/po.gameNum;
			vo.foulave = po.foul/po.gameNum;
			vo.scoreave = po.score/po.gameNum;
			vo.reboundave = po.rebound/po.gameNum;
			vo.secondaryAttackave = po.secondaryAttack/po.gameNum;
			vo.timeave = po.time/po.gameNum;
		}
		
		//������
		vo.scoreImproving = po.scoreImproving;
		vo.stealImproving = po.stealImproving;
		vo.blockShotImproving = po.blockShotImproving;
		vo.secondaryAttackImproving = po.secondaryAttackImproving;
		vo.reboundImproving = po.reboundImproving;
		
		return vo;
	}
}
