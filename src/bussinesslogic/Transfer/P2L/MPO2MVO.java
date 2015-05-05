package bussinesslogic.Transfer.P2L;

import java.util.ArrayList;

import PO.PlayerTechMPO;
import VO.PlayerTechMVO;

public class MPO2MVO {
	
	public ArrayList<PlayerTechMVO> list2vo (ArrayList<PlayerTechMPO> list){
		ArrayList<PlayerTechMVO> res = new ArrayList<PlayerTechMVO>();
		int size = list.size();
		for(int i=0;i<size;i++){
			PlayerTechMPO po = list.get(i);
			PlayerTechMVO vo = new PlayerTechMVO();
			vo.name = po.name;
			vo.team = po.team;
			vo.date = po.date;
			vo.position = po.position;
			vo.time = po.time;
			vo.shotIn = po.shotIn;
			vo.shot = po.shot;
			vo.threeShotIn = po.threeShotIn;
			vo.threeShot = po.threeShot;
			vo.penaltyShotIn = po.penaltyShotIn;
			vo.penaltyShot = po.penaltyShot;
			vo.offensiveRebound = po.offensiveRebound;
			vo.defensiveRebound = po.defensiveRebound;
			vo.rebound = po.rebound;
			vo.secondaryAttack = po.secondaryAttack;
			vo.steal = po.steal;
			vo.blockShot = po.blockShot;
			vo.fault = po.fault;
			vo.foul = po.foul;
			vo.score = po.score;
			vo.ifParticipate = po.ifParticipate;
			vo.ifFirstLineUp = po.ifFirstLineUp;
			vo.scoreRatio = po.score+po.rebound+po.secondaryAttack;
			vo.efficiency = (po.score+po.blockShot+po.steal+po.secondaryAttack+po.rebound)-(po.shot-po.shotIn)-(po.penaltyShot-po.penaltyShotIn)-po.fault;
			vo.ifDouble = po.ifDouble;
			res.add(vo);
		}
		return res;
	}
}
