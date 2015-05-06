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
					ttpo.gameNum++;																					//姣旇禌鍦烘
					if(match.ifHomeTeamWin==1)ttpo.winningNum++;													//鑳滃満
					ttpo.shotInNum = ttpo.shotInNum+match.homeShotIn;												//鍛戒腑鏁�
					ttpo.shotNum = ttpo.shotNum+match.homeShot;														//鍑烘墜鏁�
					ttpo.threeShotInNum = ttpo.threeShotInNum+match.homeThreeShotIn;								//涓夊垎鍛戒腑鏁�
					ttpo.threeShotNum = ttpo.threeShotNum+match.homeThreeShot;										//涓夊垎鍑烘墜鏁�
					ttpo.penaltyShotInNum = ttpo.penaltyShotInNum+match.homePenaltyShotIn;							//缃氱悆鍛戒腑鏁�
					ttpo.penaltyShotNum = ttpo.penaltyShotNum+match.homePenaltyShot;								//缃氱悆鍑烘墜鏁�
					ttpo.offensiveRebound = ttpo.offensiveRebound+match.homeTeamOffensiveRebound;					//杩涙敾绡澘
					ttpo.defensiveRebound = ttpo.defensiveRebound+match.homeTeamDeffensiveRebound;					//闃插畧绡澘
					ttpo.score = ttpo.score+match.homeScore;														//寰楀垎
					ttpo.offensiveRound = ttpo.offensiveRound+match.homeTeamOffensiveRound;							//杩涙敾鍥炲悎
					ttpo.opponentDefensiveRebound = ttpo.opponentDefensiveRebound+match.guestTeamDeffensiveRebound;	//瀵规墜闃插畧绡澘
					ttpo.opponentOffensiveRebound = ttpo.opponentOffensiveRebound+match.guestTeamOffensiveRebound;	//瀵规墜杩涙敾绡澘
					ttpo.opponentOffensiveRound = ttpo.opponentOffensiveRound+match.guestTeamOffensiveRound;		//瀵规墜杩涙敾鍥炲悎
					ttpo.opponentScore = ttpo.opponentScore+match.guestScore;										//瀵规墜寰楀垎
					for(int k = 0; k<match.playerStatistic.size();k++){												
						if(match.playerStatistic.get(k).team.equals(ttpo.name)){
							ttpo.secondaryAttack = ttpo.secondaryAttack+match.playerStatistic.get(k).secondaryAttack;//鍔╂敾
							ttpo.steal = ttpo.steal+match.playerStatistic.get(k).steal;								//鎶㈡柇
							ttpo.blockShot = ttpo.blockShot+match.playerStatistic.get(k).blockShot;					//鐩栧附
							ttpo.fault = ttpo.fault+match.playerStatistic.get(k).fault;								//澶辫
							ttpo.foul = ttpo.foul+match.playerStatistic.get(k).foul;
						}
					}
				}else if(match.guestTeam.equals(ttpo.name)){
					ttpo.gameNum++;																					//姣旇禌鍦烘
					if(match.ifGuestTeamWin==1)ttpo.winningNum++;													//鑳滃満
					ttpo.shotInNum = ttpo.shotInNum+match.guestShotIn;												//鍛戒腑鏁�
					ttpo.shotNum = ttpo.shotNum+match.guestShot;													//鍑烘墜鏁�
					ttpo.threeShotInNum = ttpo.threeShotInNum+match.guestThreeShotIn;								//涓夊垎鍛戒腑鏁�
					ttpo.threeShotNum = ttpo.threeShotNum+match.guestThreeShot;										//涓夊垎鍑烘墜鏁�
					ttpo.penaltyShotInNum = ttpo.penaltyShotInNum+match.guestPenaltyShotIn;							//缃氱悆鍛戒腑鏁�
					ttpo.penaltyShotNum = ttpo.penaltyShotNum+match.guestPenaltyShot;								//缃氱悆鍑烘墜鏁�
					ttpo.offensiveRebound = ttpo.offensiveRebound+match.guestTeamOffensiveRebound;					//杩涙敾绡澘
					ttpo.defensiveRebound = ttpo.defensiveRebound+match.guestTeamDeffensiveRebound;					//闃插畧绡澘
					ttpo.score = ttpo.score+match.guestScore;														//寰楀垎
					ttpo.offensiveRound = ttpo.offensiveRound+match.guestTeamOffensiveRound;						//杩涙敾鍥炲悎
					ttpo.opponentDefensiveRebound = ttpo.opponentDefensiveRebound+match.homeTeamDeffensiveRebound;	//瀵规墜闃插畧绡澘
					ttpo.opponentOffensiveRebound = ttpo.opponentOffensiveRebound+match.homeTeamOffensiveRebound;	//瀵规墜杩涙敾绡澘
					ttpo.opponentOffensiveRound = ttpo.opponentOffensiveRound+match.homeTeamOffensiveRound;			//瀵规墜杩涙敾鍥炲悎
					ttpo.opponentScore = ttpo.opponentScore+match.homeScore;										//瀵规墜鎬诲緱鍒�
					for(int k = 0; k<match.playerStatistic.size();k++){
						if(match.playerStatistic.get(k).team.equals(ttpo.name)){
							ttpo.secondaryAttack = ttpo.secondaryAttack+match.playerStatistic.get(k).secondaryAttack;
							ttpo.steal = ttpo.steal+match.playerStatistic.get(k).steal;
							ttpo.blockShot = ttpo.blockShot+match.playerStatistic.get(k).blockShot;
							ttpo.fault = ttpo.fault+match.playerStatistic.get(k).fault;
							ttpo.foul = ttpo.foul+match.playerStatistic.get(k).foul;
						}
					}
				}
			}
			ttpo.rebound = ttpo.offensiveRebound + ttpo.defensiveRebound;											//鎬荤鏉�
			ttpo.shotInRate = (double)ttpo.shotInNum/(double)ttpo.shotNum;											//鎶曠鍛戒腑鐜�
			ttpo.threeShotInRate = (double)ttpo.threeShotInNum/(double)ttpo.threeShotNum;							//涓夊垎鍛戒腑鐜�
			ttpo.penaltyShotInRate = (double)ttpo.penaltyShotInNum/(double)ttpo.penaltyShotNum;						//缃氱悆鍛戒腑鐜�
			ttpo.winningRate = (double)ttpo.winningNum/(double)ttpo.gameNum;										//鑳滅巼
			ttpo.offensiveEfficiency = (double)ttpo.score/((double)ttpo.offensiveRound/100);						//杩涙敾鏁堢巼
			ttpo.defensiveEfficiency = (double)ttpo.score/((double)ttpo.opponentOffensiveRound/100);				//闃插畧鏁堢巼
			ttpo.reboundEfficiency = (double)ttpo.rebound/((double)ttpo.rebound+(double)ttpo.opponentDefensiveRebound+(double)ttpo.opponentOffensiveRebound);
			ttpo.stealEfficiency = (double)ttpo.steal/((double)ttpo.opponentOffensiveRound/100);					//鎶㈡柇鏁堢巼
			ttpo.secondaryAttackEfficiency = (double)ttpo.secondaryAttack/((double)ttpo.offensiveRound/100);		//鍔╂敾鏁堢巼
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
