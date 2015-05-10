package bussinesslogic.playertechbl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import data.playertechdata.OperateWithFile;
import data.playertechdata.Show;
import dataservice.playertechdataservice.PlayerTechInitial;
import dataservice.playertechdataservice.ShowDataService;
import PO.PlayerTechPO;
import VO.PlayerTechVO;
import bussinesslogic.Transfer.PlayerTechTransfer;


public class ShowPlayerTech {

	ShowDataService sd = new Show();
	PlayerTechTransfer tr = new PlayerTechTransfer();
	
	public ArrayList<PlayerTechVO> showSeasonPlayerData() {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = sd.showSeasonPlayerData();
		ArrayList<PlayerTechVO> res = tr.list2vo(list);
		return res;
	}

	public PlayerTechVO showKeyData(String name, String team) {
		// TODO Auto-generated method stub
	   PlayerTechPO po = sd.showKeyData(name, team);
	   PlayerTechVO vo = tr.po2vo(po);
		return vo;
	}

	public void refresh() {
		// TODO Auto-generated method stub
		sd.refresh();
		showSeasonPlayerData();
	}

	public void PlayerTechIni() {
		// TODO Auto-generated method stub
		PlayerTechInitial ini = new OperateWithFile();
		ini.write();
	}

	public ArrayList<PlayerTechVO> ascend(final String type) {
		// TODO Auto-generated method stub
		Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){  
			public int compare(PlayerTechVO p1, PlayerTechVO p2) {   
				
				switch(type){
				case "name":
					return p1.name.compareTo(p2.name);
				case "gamenum":
					return p1.gameNum-p2.gameNum;
				case "startingnum":
					return p1.startingNum-p2.startingNum;
				case "rebound":
					return p1.rebound-p2.rebound;
				case "reboundave":
					if(p1.reboundave==p2.reboundave)
						return 0;
					else
						return (p1.reboundave-p2.reboundave)>0?1:-1;
				case "secondaryattack":
					return p1.secondaryAttack-p2.secondaryAttack;
				case "secondaryattackave":
					if(p1.secondaryAttackave==p2.secondaryAttackave)
						return 0;
					else
						return (p1.secondaryAttackave-p2.secondaryAttackave)>0?1:-1;
				case "time":
					return p1.time-p2.time;
				case "timeave":
					if(p1.timeave==p2.timeave)
						return 0;
					else
						return (p1.timeave-p2.timeave)>0?1:-1;
				case "offensivenum":
					return p1.offensiveNum-p2.offensiveNum;
				case "offensivenumave":
					if(p1.offensiveNumave==p2.offensiveNumave)
						return 0;
					else
						return (p1.offensiveNumave-p2.offensiveNumave)>0?1:-1;
				case "defensivenum":
					return p1.defensiveNum-p2.defensiveNum;
				case "defensivenumave":
					if(p1.defensiveNumave==p2.defensiveNumave)
						return 0;
					else
						return (p1.defensiveNumave-p2.defensiveNumave)>0?1:-1;
				case "steal":
					return p1.steal-p2.steal;
				case "stealave":
					if(p1.stealave==p2.stealave)
						return 0;
					else
						return (p1.stealave-p2.stealave)>0?1:-1;
				case "blockshot":
					return p1.blockShot-p2.blockShot;
				case "blockshotave":
					if(p1.blockShotave==p2.blockShotave)
						return 0;
					else
						return (p1.blockShotave-p2.blockShotave)>0?1:-1;
				case "fault":
					return p1.fault-p2.fault;
				case "faultave":
					if(p1.faultave==p2.faultave)
						return 0;
					else
						return (p1.faultave-p2.faultave)>0?1:-1;
				case "foul":
					return p1.foul-p2.foul;
				case "foulave":
					if(p1.foulave==p2.foulave)
						return 0;
					else
						return (p1.foulave-p2.foulave)>0?1:-1;
				case "score":
					return p1.score-p2.score;
				case "scoreave":
					if(p1.scoreave==p2.scoreave)
						return 0;
					else
						return (p1.scoreave-p2.scoreave)>0?1:-1;
				case "shotinrate":
					if(p1.shotInRate==p2.shotInRate)
						return 0;
					else
						return  (p1.shotInRate-p2.shotInRate)>0?1:-1;
				case "threeshotinrate":
					if(p1.threeShotInRate==p2.threeShotInRate)
						return 0;
					else
						return  (p1.threeShotInRate-p2.threeShotInRate)>0?1:-1;
				case "penaltyshotinrate":
					if(p1.penaltyShotInRate==p2.penaltyShotInRate)
						return 0;
					else
						return  (p1.penaltyShotInRate-p2.penaltyShotInRate)>0?1:-1;
				case "efficiency":
					if(p1.efficiency==p2.efficiency)
						return 0;
					else
						return  (p1.efficiency-p2.efficiency)>0?1:-1;
				case "gmscefficiency":
					if(p1.GmScEfficiency==p2.GmScEfficiency)
						return 0;
					else
						return (p1.GmScEfficiency-p2.GmScEfficiency)>0?1:-1;
				case "trueshotinrate":
					if(p1.trueShotInRate==p2.trueShotInRate)
						return 0;
					else
						return  (p1.trueShotInRate-p2.trueShotInRate)>0?1:-1;
				case "shootingefficiency":
					if(p1.shootingEfficiency==p2.shootingEfficiency)
						return 0;
					else
						return  (p1.shootingEfficiency-p2.shootingEfficiency)>0?1:-1;
				case "reboundrate":
					if(p1.reboundRate==p2.reboundRate)
						return 0;
					else
						return  (p1.reboundRate-p2.reboundRate)>0?1:-1;
				case "offensivereboundrate":
					if(p1.offensiveReboundRate==p2.offensiveReboundRate)
						return 0;
					else
						return (p1.offensiveReboundRate-p2.offensiveReboundRate)>0?1:-1;
				case "defensivereboundrate":
					if(p1.defensiveReboundRate==p2.defensiveReboundRate)
						return 0;
					else
						return  (p1.defensiveReboundRate-p2.defensiveReboundRate)>0?1:-1;
				case "secondaryattackrate":
					if(p1.secondaryAttackRate==p2.secondaryAttackRate)
						return 0;
					else
						return (p1.secondaryAttackRate-p2.secondaryAttackRate)>0?1:-1;
				case "stealrate":
					if(p1.stealRate==p2.stealRate)
						return 0;
					else
						return (p1.stealRate-p2.stealRate)>0?1:-1;
				case "blockshotrate":
					if(p1.blockShotRate==p2.blockShotRate)
						return 0;
					else
						return (p1.blockShotRate-p2.blockShotRate)>0?1:-1;
				case "faultrate":
					if(p1.faultRate==p2.faultRate)
						return 0;
					else
						return (p1.faultRate-p2.faultRate)>0?1:-1;
				case "usagerate":
					if(p1.usageRate==p2.usageRate)
						return 0;
					else
						return  (p1.usageRate-p2.usageRate)>0?1:-1;
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		ArrayList<PlayerTechVO> list = showSeasonPlayerData();
		Collections.sort(list, comparator);
		return list;
	}

	public ArrayList<PlayerTechVO> descend(final String type) {
		// TODO Auto-generated method stub
		Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){  
			public int compare(PlayerTechVO p2, PlayerTechVO p1) {   
				
				switch(type){
				case "name":
					return p1.name.compareTo(p2.name);
				case "gamenum":
					return p1.gameNum-p2.gameNum;
				case "startingnum":
					return p1.startingNum-p2.startingNum;
				case "rebound":
					return p1.rebound-p2.rebound;
				case "reboundave":
					if(p1.reboundave==p2.reboundave)
						return 0;
					else
						return (p1.reboundave-p2.reboundave)>0?1:-1;
				case "secondaryattack":
					return p1.secondaryAttack-p2.secondaryAttack;
				case "secondaryattackave":
					if(p1.secondaryAttackave==p2.secondaryAttackave)
						return 0;
					else
						return (p1.secondaryAttackave-p2.secondaryAttackave)>0?1:-1;
				case "time":
					return p1.time-p2.time;
				case "timeave":
					if(p1.timeave==p2.timeave)
						return 0;
					else
						return (p1.timeave-p2.timeave)>0?1:-1;
				case "offensivenum":
					return p1.offensiveNum-p2.offensiveNum;
				case "offensivenumave":
					if(p1.offensiveNumave==p2.offensiveNumave)
						return 0;
					else
						return (p1.offensiveNumave-p2.offensiveNumave)>0?1:-1;
				case "defensivenum":
					return p1.defensiveNum-p2.defensiveNum;
				case "defensivenumave":
					if(p1.defensiveNumave==p2.defensiveNumave)
						return 0;
					else
						return (p1.defensiveNumave-p2.defensiveNumave)>0?1:-1;
				case "steal":
					return p1.steal-p2.steal;
				case "stealave":
					if(p1.stealave==p2.stealave)
						return 0;
					else
						return (p1.stealave-p2.stealave)>0?1:-1;
				case "blockshot":
					return p1.blockShot-p2.blockShot;
				case "blockshotave":
					if(p1.blockShotave==p2.blockShotave)
						return 0;
					else
						return (p1.blockShotave-p2.blockShotave)>0?1:-1;
				case "fault":
					return p1.fault-p2.fault;
				case "faultave":
					if(p1.faultave==p2.faultave)
						return 0;
					else
						return (p1.faultave-p2.faultave)>0?1:-1;
				case "foul":
					return p1.foul-p2.foul;
				case "foulave":
					if(p1.foulave==p2.foulave)
						return 0;
					else
						return (p1.foulave-p2.foulave)>0?1:-1;
				case "score":
					return p1.score-p2.score;
				case "scoreave":
					if(p1.scoreave==p2.scoreave)
						return 0;
					else
						return (p1.scoreave-p2.scoreave)>0?1:-1;
				case "shotinrate":
					if(p1.shotInRate==p2.shotInRate)
						return 0;
					else
						return  (p1.shotInRate-p2.shotInRate)>0?1:-1;
				case "threeshotinrate":
					if(p1.threeShotInRate==p2.threeShotInRate)
						return 0;
					else
						return  (p1.threeShotInRate-p2.threeShotInRate)>0?1:-1;
				case "penaltyshotinrate":
					if(p1.penaltyShotInRate==p2.penaltyShotInRate)
						return 0;
					else
						return  (p1.penaltyShotInRate-p2.penaltyShotInRate)>0?1:-1;
				case "efficiency":
					if(p1.efficiency==p2.efficiency)
						return 0;
					else
						return  (p1.efficiency-p2.efficiency)>0?1:-1;
				case "gmscefficiency":
					if(p1.GmScEfficiency==p2.GmScEfficiency)
						return 0;
					else
						return (p1.GmScEfficiency-p2.GmScEfficiency)>0?1:-1;
				case "trueshotinrate":
					if(p1.trueShotInRate==p2.trueShotInRate)
						return 0;
					else
						return  (p1.trueShotInRate-p2.trueShotInRate)>0?1:-1;
				case "shootingefficiency":
					if(p1.shootingEfficiency==p2.shootingEfficiency)
						return 0;
					else
						return  (p1.shootingEfficiency-p2.shootingEfficiency)>0?1:-1;
				case "reboundrate":
					if(p1.reboundRate==p2.reboundRate)
						return 0;
					else
						return  (p1.reboundRate-p2.reboundRate)>0?1:-1;
				case "offensivereboundrate":
					if(p1.offensiveReboundRate==p2.offensiveReboundRate)
						return 0;
					else
						return (p1.offensiveReboundRate-p2.offensiveReboundRate)>0?1:-1;
				case "defensivereboundrate":
					if(p1.defensiveReboundRate==p2.defensiveReboundRate)
						return 0;
					else
						return  (p1.defensiveReboundRate-p2.defensiveReboundRate)>0?1:-1;
				case "secondaryattackrate":
					if(p1.secondaryAttackRate==p2.secondaryAttackRate)
						return 0;
					else
						return (p1.secondaryAttackRate-p2.secondaryAttackRate)>0?1:-1;
				case "stealrate":
					if(p1.stealRate==p2.stealRate)
						return 0;
					else
						return (p1.stealRate-p2.stealRate)>0?1:-1;
				case "blockshotrate":
					if(p1.blockShotRate==p2.blockShotRate)
						return 0;
					else
						return (p1.blockShotRate-p2.blockShotRate)>0?1:-1;
				case "faultrate":
					if(p1.faultRate==p2.faultRate)
						return 0;
					else
						return (p1.faultRate-p2.faultRate)>0?1:-1;
				case "usagerate":
					if(p1.usageRate==p2.usageRate)
						return 0;
					else
						return  (p1.usageRate-p2.usageRate)>0?1:-1;
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		ArrayList<PlayerTechVO> list = showSeasonPlayerData();
		Collections.sort(list, comparator);
		return list;
	}

}
