package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.MatchPO;
import PO.TeamPO;
import PO.TeamTechPO;
import dataservice.TeamTechDataService;

public class TeamTechData implements TeamTechDataService{

	readFrom rf = new DataProcessing();
	File file = new File("database/teamtech.ser");
	
	public void WriteIn(){
		ArrayList<MatchPO> source = new ArrayList<MatchPO>();
		source = rf.matchRead();
		ArrayList<TeamPO> teams = rf.teamRead();
		ArrayList<TeamTechPO> result = new ArrayList<TeamTechPO>();
		for(int i = 0; i<teams.size(); i++){
			TeamTechPO ttpo = new TeamTechPO();
			ttpo.name = teams.get(i).abbreviation;
			
			for(int j = 0; j<source.size(); j++){
				MatchPO match = new MatchPO();
				match = source.get(j);
				if(match.homeTeam.equals(ttpo.name)){
					ttpo.gameNum++;																					//比赛场次
					if(match.ifHomeTeamWin==1)ttpo.winningNum++;													//胜场
					ttpo.shotInNum = ttpo.shotInNum+match.homeShotIn;												//命中数
					ttpo.shotNum = ttpo.shotNum+match.homeShot;														//出手数
					ttpo.threeShotInNum = ttpo.threeShotInNum+match.homeThreeShotIn;								//三分命中数
					ttpo.threeShotNum = ttpo.threeShotNum+match.homeThreeShot;										//三分出手数
					ttpo.penaltyShotInNum = ttpo.penaltyShotInNum+match.homePenaltyShotIn;							//罚球命中数
					ttpo.penaltyShotNum = ttpo.penaltyShotNum+match.homePenaltyShot;								//罚球出手数
					ttpo.offensiveRebound = ttpo.offensiveRebound+match.homeTeamOffensiveRebound;					//进攻篮板
					ttpo.defensiveRebound = ttpo.defensiveRebound+match.homeTeamDeffensiveRebound;					//防守篮板
					ttpo.score = ttpo.score+match.homeScore;														//得分
					ttpo.offensiveRound = ttpo.offensiveRound+match.homeTeamOffensiveRound;							//进攻回合
					ttpo.opponentDefensiveRebound = ttpo.opponentDefensiveRebound+match.guestTeamDeffensiveRebound;	//对手防守篮板
					ttpo.opponentOffensiveRebound = ttpo.opponentOffensiveRebound+match.guestTeamOffensiveRebound;	//对手进攻篮板
					ttpo.opponentOffensiveRound = ttpo.opponentOffensiveRound+match.guestTeamOffensiveRound;		//对手进攻回合
					ttpo.opponentScore = ttpo.opponentScore+match.guestScore;										//对手得分
					for(int k = 0; k<match.playerStatistic.size();k++){												
						if(match.playerStatistic.get(k).team.equals(ttpo.name)){
							ttpo.secondaryAttack = ttpo.secondaryAttack+match.playerStatistic.get(k).secondaryAttack;//助攻
							ttpo.steal = ttpo.steal+match.playerStatistic.get(k).steal;								//抢断
							ttpo.blockShot = ttpo.blockShot+match.playerStatistic.get(k).blockShot;					//盖帽
							ttpo.fault = ttpo.fault+match.playerStatistic.get(k).fault;								//失误
						}
					}
				}else if(match.guestTeam.equals(ttpo.name)){
					ttpo.gameNum++;																					//比赛场次
					if(match.ifGuestTeamWin==1)ttpo.winningNum++;													//胜场
					ttpo.shotInNum = ttpo.shotInNum+match.guestShotIn;												//命中数
					ttpo.shotNum = ttpo.shotNum+match.guestShot;													//出手数
					ttpo.threeShotInNum = ttpo.threeShotInNum+match.guestThreeShotIn;								//三分命中数
					ttpo.threeShotNum = ttpo.threeShotNum+match.guestThreeShot;										//三分出手数
					ttpo.penaltyShotInNum = ttpo.penaltyShotInNum+match.guestPenaltyShotIn;							//罚球命中数
					ttpo.penaltyShotNum = ttpo.penaltyShotNum+match.guestPenaltyShot;								//罚球出手数
					ttpo.offensiveRebound = ttpo.offensiveRebound+match.guestTeamOffensiveRebound;					//进攻篮板
					ttpo.defensiveRebound = ttpo.defensiveRebound+match.guestTeamDeffensiveRebound;					//防守篮板
					ttpo.score = ttpo.score+match.guestScore;														//得分
					ttpo.offensiveRound = ttpo.offensiveRound+match.guestTeamOffensiveRound;						//进攻回合
					ttpo.opponentDefensiveRebound = ttpo.opponentDefensiveRebound+match.homeTeamDeffensiveRebound;	//对手防守篮板
					ttpo.opponentOffensiveRebound = ttpo.opponentOffensiveRebound+match.homeTeamOffensiveRebound;	//对手进攻篮板
					ttpo.opponentOffensiveRound = ttpo.opponentOffensiveRound+match.homeTeamOffensiveRound;			//对手进攻回合
					ttpo.opponentScore = ttpo.opponentScore+match.homeScore;										//对手总得分
					for(int k = 0; k<match.playerStatistic.size();k++){
						if(match.playerStatistic.get(k).team.equals(ttpo.name)){
							ttpo.secondaryAttack = ttpo.secondaryAttack+match.playerStatistic.get(k).secondaryAttack;
							ttpo.steal = ttpo.steal+match.playerStatistic.get(k).steal;
							ttpo.blockShot = ttpo.blockShot+match.playerStatistic.get(k).blockShot;
							ttpo.fault = ttpo.fault+match.playerStatistic.get(k).fault;
						}
					}
				}
			}
			ttpo.rebound = ttpo.offensiveRebound + ttpo.defensiveRebound;											//总篮板
			ttpo.shotInRate = (double)ttpo.shotInNum/(double)ttpo.shotNum;											//投篮命中率
			ttpo.threeShotInRate = (double)ttpo.threeShotInNum/(double)ttpo.threeShotNum;							//三分命中率
			ttpo.penaltyShotInRate = (double)ttpo.penaltyShotInNum/(double)ttpo.penaltyShotNum;						//罚球命中率
			ttpo.winningRate = (double)ttpo.winningNum/(double)ttpo.gameNum;										//胜率
			ttpo.offensiveEfficiency = (double)ttpo.score/((double)ttpo.offensiveRound/100);						//进攻效率
			ttpo.defensiveEfficiency = (double)ttpo.score/((double)ttpo.opponentOffensiveRound/100);				//防守效率
			ttpo.reboundEfficiency = (double)ttpo.rebound/((double)ttpo.rebound+(double)ttpo.opponentDefensiveRebound+(double)ttpo.opponentOffensiveRebound);
			ttpo.stealEfficiency = (double)ttpo.steal/((double)ttpo.opponentOffensiveRound/100);					//抢断效率
			ttpo.secondaryAttackEfficiency = (double)ttpo.secondaryAttack/((double)ttpo.offensiveRound/100);		//助攻效率
			result.add(ttpo);
		}
		try{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(result);
			oos.close();
			oos.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<TeamTechPO> readin(){
		ArrayList<TeamTechPO> result = new ArrayList<TeamTechPO>();
		try{
            FileInputStream fis = new FileInputStream("database/teamtech.ser");
            @SuppressWarnings("resource")
			ObjectInputStream ois = new ObjectInputStream(fis);
			result.clear();
			result = (ArrayList<TeamTechPO>)ois.readObject();
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
	}

	@Override
	public ArrayList<TeamTechPO> list() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<TeamTechPO> result = new ArrayList<TeamTechPO>();
		result = readin();
		return result;
	}
	


}
