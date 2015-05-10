package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import PO.MatchPO;
import PO.PlayerPO;
import PO.PlayerTechMPO;
import PO.TeamPO;

/*
 * 原始信息的处理（包括比赛信息，球员基本信息和球队基本信息）
 * @cao
 * 2015-3-20 01:34:53
 *修改次数5
 */
public class DataProcessing implements readFrom{
	
	ArrayList<MatchPO>mlist=new ArrayList<MatchPO>();
	ArrayList<PlayerPO>plist=new ArrayList<PlayerPO>();
	ArrayList<TeamPO>tlist=new ArrayList<TeamPO>();
	//比赛信息读入
	public ArrayList<MatchPO> matchRead(){
		try {
			String encoding = "GBK";
			File file = new File("MatchData");
			File filelist[]=file.listFiles();
			for(int i=0;i<filelist.length;i++){
				
				MatchPO matchpo=new MatchPO();
				ArrayList<String>info=new ArrayList<String>();
				
				InputStreamReader read = new InputStreamReader(new FileInputStream(filelist[i].getAbsolutePath()),encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String line = null;
				while((line = bufferedReader.readLine())!=null) {
					info.add(line);
					
				}
				read.close();
				String[][]data=new String [info.size()][];
				for(int j=0;j<info.size();j++){
					data[j]=info.get(j).split(";");
				}
				String filename[]=filelist[i].getName().split("_");

				if(Integer.valueOf(filename[1].split("-")[0])<=7)
					matchpo.date="20"+filename[0].split("-")[1]+"-"+filename[1];
				else
					matchpo.date="20"+filename[0].split("-")[0]+"-"+filename[1];
				matchpo.guestTeam=data[0][1].split("-")[0];
				matchpo.homeTeam=data[0][1].split("-")[1];
				if(matchpo.guestTeam.equals("NOH"))
					matchpo.guestTeam="NOP";
				if(matchpo.homeTeam.equals("NOH"))
					matchpo.homeTeam="NOP";
				matchpo.score=data[0][2];
				matchpo.guestScore=Integer.parseInt(data[0][2].split("-")[0]);
				matchpo.homeScore=Integer.parseInt(data[0][2].split("-")[1]);
				matchpo.score1=data[1][0];
				matchpo.score2=data[1][1];
				matchpo.score3=data[1][2];
				matchpo.score4=data[1][3];
				if(data[1].length>4){
					matchpo.scoreExtra=data[1][data[1].length-1];
				}else{
					matchpo.scoreExtra=null;
				}
				matchpo.season=filelist[i].getName().split("-")[0];
				
				//录入胜负情况
				int guestTeamScore=Integer.parseInt(matchpo.score.split("-")[0]);
				int homeTeamScore=Integer.parseInt(matchpo.score.split("-")[1]);
				if(homeTeamScore>guestTeamScore){
					matchpo.ifHomeTeamWin=1;
					matchpo.ifGuestTeamWin=0;
				}
				else if(homeTeamScore<guestTeamScore){
					matchpo.ifHomeTeamWin=0;
					matchpo.ifGuestTeamWin=1;
				}else if(homeTeamScore==guestTeamScore){
					matchpo.ifHomeTeamWin=0;
					matchpo.ifGuestTeamWin=0;
				}
				
				//录入球员技术信息（标记第二个队的行数）
				int homeTeamTip=0;
				for(int j=0;j<info.size();j++){
					if(data[j].length==1&&j!=2){
						homeTeamTip=j;
						break;
					}
					
				}
				ArrayList<PlayerTechMPO>ptmlist =new ArrayList<PlayerTechMPO>();
				matchpo.playerStatistic=ptmlist;
				for(int k=3;k<homeTeamTip;k++){
					
					PlayerTechMPO ptmp=new PlayerTechMPO();
					ptmp.name=data[k][0];
					ptmp.position=data[k][1];
					try{
						ptmp.time=Integer.parseInt(data[k][2].split(":")[0]);
					}catch (NumberFormatException e){
						ptmp.time=0;
					}
				//	System.out.println(ptmp.time);
					if(matchpo.guestTeam.equals("DAL")||matchpo.guestTeam.equals("DEN")||matchpo.guestTeam.equals("GSW")||matchpo.guestTeam.equals("HOU")||matchpo.guestTeam.equals("LAC")||matchpo.guestTeam.equals("LAL")||matchpo.guestTeam.equals("MEM")||matchpo.guestTeam.equals("MIN")||matchpo.guestTeam.equals("NOP")||matchpo.guestTeam.equals("OKC")||matchpo.guestTeam.equals("PHX")||matchpo.guestTeam.equals("POR")||matchpo.guestTeam.equals("SAC")||matchpo.guestTeam.equals("SAS")||matchpo.guestTeam.equals("UTA"))
						ptmp.division="W";
					else
						ptmp.division="E";
					ptmp.date=matchpo.date;
					ptmp.shotIn=Integer.parseInt(data[k][3]);
					ptmp.shot=Integer.parseInt(data[k][4]);
					ptmp.threeShotIn=Integer.parseInt(data[k][5]);
					ptmp.threeShot=Integer.parseInt(data[k][6]);
					ptmp.penaltyShotIn=Integer.parseInt(data[k][7]);
					ptmp.penaltyShot=Integer.parseInt(data[k][8]);
					ptmp.offensiveRebound=Integer.parseInt(data[k][9]);
					ptmp.defensiveRebound=Integer.parseInt(data[k][10]);
					ptmp.rebound=Integer.parseInt(data[k][11]);
					ptmp.secondaryAttack=Integer.parseInt(data[k][12]);
					ptmp.steal=Integer.parseInt(data[k][13]);
					ptmp.blockShot=Integer.parseInt(data[k][14]);
					ptmp.fault=Integer.parseInt(data[k][15]);
					ptmp.foul=Integer.parseInt(data[k][16]);
					try{
						ptmp.score=Integer.parseInt(data[k][17]);
					}catch(NumberFormatException e){
						ptmp.score=0;
						
					}
					ptmp.team=matchpo.guestTeam;
					
					if(k>=3&&k<=7)
						ptmp.ifFirstLineUp=1;
					else
						ptmp.ifFirstLineUp=0;
					
					if(ptmp.time>0)
						ptmp.ifParticipate=1;
					else
						ptmp.ifParticipate=0;
					if((ptmp.score>=10&&ptmp.rebound>=10)||(ptmp.score>=10&&ptmp.secondaryAttack>=10)||(ptmp.score>=10&&ptmp.steal>=10)||(ptmp.score>=10&&ptmp.blockShot>=10)||(ptmp.rebound>=10&&ptmp.secondaryAttack>=10)||(ptmp.rebound>=10&&ptmp.steal>=10)||(ptmp.rebound>=10&&ptmp.blockShot>=10)||(ptmp.secondaryAttack>=10&&ptmp.steal>=10)||(ptmp.secondaryAttack>=10&&ptmp.blockShot>=10)||(ptmp.steal>=10&&ptmp.blockShot>=10))
						ptmp.ifDouble=1;
					else
						ptmp.ifDouble=0;
					matchpo.playerStatistic.add(ptmp);
					
				}
				
				for(int k=homeTeamTip+1;k<info.size();k++){
					
					PlayerTechMPO ptmp=new PlayerTechMPO();
					ptmp.name=data[k][0];
					ptmp.position=data[k][1];
					try{
						ptmp.time=Integer.parseInt(data[k][2].split(":")[0]);
					}catch (NumberFormatException e){
						ptmp.time=0;
					}	
					if(matchpo.homeTeam.equals("DAL")||matchpo.homeTeam.equals("DEN")||matchpo.homeTeam.equals("GSW")||matchpo.homeTeam.equals("HOU")||matchpo.homeTeam.equals("LAC")||matchpo.homeTeam.equals("LAL")||matchpo.homeTeam.equals("MEM")||matchpo.homeTeam.equals("MIN")||matchpo.homeTeam.equals("NOP")||matchpo.homeTeam.equals("OKC")||matchpo.homeTeam.equals("PHX")||matchpo.homeTeam.equals("POR")||matchpo.homeTeam.equals("SAC")||matchpo.homeTeam.equals("SAS")||matchpo.homeTeam.equals("UTA"))
						ptmp.division="W";
					else
						ptmp.division="E";
					ptmp.date=matchpo.date;
					ptmp.shotIn=Integer.parseInt(data[k][3]);
					ptmp.shot=Integer.parseInt(data[k][4]);
					ptmp.threeShotIn=Integer.parseInt(data[k][5]);
					ptmp.threeShot=Integer.parseInt(data[k][6]);
					ptmp.penaltyShotIn=Integer.parseInt(data[k][7]);
					ptmp.penaltyShot=Integer.parseInt(data[k][8]);
					ptmp.offensiveRebound=Integer.parseInt(data[k][9]);
					ptmp.defensiveRebound=Integer.parseInt(data[k][10]);
					ptmp.rebound=Integer.parseInt(data[k][11]);
					ptmp.secondaryAttack=Integer.parseInt(data[k][12]);
					ptmp.steal=Integer.parseInt(data[k][13]);
					ptmp.blockShot=Integer.parseInt(data[k][14]);
					ptmp.fault=Integer.parseInt(data[k][15]);
					ptmp.foul=Integer.parseInt(data[k][16]);
					try{
						ptmp.score=Integer.parseInt(data[k][17]);
					}catch(NumberFormatException e){
						ptmp.score=0;
						
					}
					ptmp.team=matchpo.homeTeam;
					
					if(k>=homeTeamTip+1&&k<=homeTeamTip+5)
						ptmp.ifFirstLineUp=1;
					else
						ptmp.ifFirstLineUp=0;
					
					if(ptmp.time>0)
						ptmp.ifParticipate=1;
					else
						ptmp.ifParticipate=0;
					if((ptmp.score>=10&&ptmp.rebound>=10)||(ptmp.score>=10&&ptmp.secondaryAttack>=10)||(ptmp.score>=10&&ptmp.steal>=10)||(ptmp.score>=10&&ptmp.blockShot>=10)||(ptmp.rebound>=10&&ptmp.secondaryAttack>=10)||(ptmp.rebound>=10&&ptmp.steal>=10)||(ptmp.rebound>=10&&ptmp.blockShot>=10)||(ptmp.secondaryAttack>=10&&ptmp.steal>=10)||(ptmp.secondaryAttack>=10&&ptmp.blockShot>=10)||(ptmp.steal>=10&&ptmp.blockShot>=10))
						ptmp.ifDouble=1;
					else
						ptmp.ifDouble=0;
					matchpo.playerStatistic.add(ptmp);
				}
				//计算主客队进攻防守篮板数
				int homeDeRebound=0;
				int guestDeRebound=0;
				int homeOfRebound=0;
				int guestOfRebound=0;
				int homeShot=0;
				int guestShot=0;
				int homeShotin=0;
				int guestShotin=0;
				int homethreeshot=0;
				int guestthreeshot=0;
				int homethreeshotIn=0;
				int guestthreeshotIn=0;
				int homePShot=0;
				int guestPShot=0;
				int homePShotIn=0;
				int guestPShotIn=0;
				int homeFault=0;
				int guestFault=0;
				int homeTime=0;
				int guestTime=0;
				int homeTeamFoul=0;                     //主队犯规
				int guestTeamFoul=0;                     //客队犯规
				int homeTeamSteal=0;                     //主队抢断
				int guestTeamSteal=0;                     //客队抢断
				int homeTeamSecondaryAttack=0;                     //主队助攻
				int guestTeamSecondaryAttack=0;                     //客队助攻
				int homeTeamBlockShot=0;                     //主队盖帽
				int guestTeamBlockShot=0;                     //客队盖帽
				
				for(int j=0;j<homeTeamTip-3;j++){
					guestDeRebound=guestDeRebound+matchpo.playerStatistic.get(j).defensiveRebound;
					guestOfRebound=guestOfRebound+matchpo.playerStatistic.get(j).offensiveRebound;
					guestShot=guestShot+matchpo.playerStatistic.get(j).shot;
					guestShotin=guestShotin+matchpo.playerStatistic.get(j).shotIn;
					guestthreeshot=guestthreeshot+matchpo.playerStatistic.get(j).threeShot;
					guestthreeshotIn=guestthreeshotIn+matchpo.playerStatistic.get(j).threeShotIn;
					guestPShot=guestPShot+matchpo.playerStatistic.get(j).penaltyShot;
					guestPShotIn=guestPShotIn+matchpo.playerStatistic.get(j).penaltyShotIn;
					guestFault=guestFault+matchpo.playerStatistic.get(j).fault;
					guestTime=guestTime+matchpo.playerStatistic.get(j).time;
					guestTeamFoul=guestTeamFoul+matchpo.playerStatistic.get(j).foul;
					guestTeamSteal=guestTeamSteal+matchpo.playerStatistic.get(j).steal;
					guestTeamSecondaryAttack=guestTeamSecondaryAttack+matchpo.playerStatistic.get(j).secondaryAttack;
					guestTeamBlockShot=guestTeamBlockShot+matchpo.playerStatistic.get(j).blockShot;


					
				}
				
				for(int j=homeTeamTip-3;j<info.size()-4;j++){
					homeDeRebound=homeDeRebound+matchpo.playerStatistic.get(j).defensiveRebound;
					homeOfRebound=homeOfRebound+matchpo.playerStatistic.get(j).offensiveRebound;
					homeShot=homeShot+matchpo.playerStatistic.get(j).shot;
					homeShotin=homeShotin+matchpo.playerStatistic.get(j).shotIn;
					homethreeshot=homethreeshot+matchpo.playerStatistic.get(j).threeShot;
					homethreeshotIn=homethreeshotIn+matchpo.playerStatistic.get(j).threeShotIn;
					homePShot=homePShot+matchpo.playerStatistic.get(j).penaltyShot;
					homePShotIn=homePShotIn+matchpo.playerStatistic.get(j).penaltyShotIn;
					homeFault=homeFault+matchpo.playerStatistic.get(j).fault;
					homeTime=homeTime+matchpo.playerStatistic.get(j).time;
					homeTeamFoul=homeTeamFoul+matchpo.playerStatistic.get(j).foul;
					homeTeamSteal=homeTeamSteal+matchpo.playerStatistic.get(j).steal;
					homeTeamSecondaryAttack=homeTeamSecondaryAttack+matchpo.playerStatistic.get(j).secondaryAttack;
					homeTeamBlockShot=homeTeamBlockShot+matchpo.playerStatistic.get(j).blockShot;
				}
				matchpo.homeShot=homeShot;
				matchpo.guestShot=guestShot;
				matchpo.homeShotIn=homeShotin;
				matchpo.guestShotIn=guestShotin;
				matchpo.homeTwoShot=homeShot-homethreeshot;
				matchpo.guestTwoShot=guestShot-guestthreeshot;
				matchpo.homeTwoShotIn=homeShotin-homethreeshotIn;
				matchpo.guestTwoShotIn=guestShotin-guestthreeshotIn;
				matchpo.homeThreeShot=homethreeshot;
				matchpo.guestThreeShot=guestthreeshot;
				matchpo.homeThreeShotIn=homethreeshotIn;
				matchpo.guestThreeShotIn=guestthreeshotIn;
				matchpo.homePenaltyShot=homePShot;
				matchpo.guestPenaltyShot=guestPShot;
				matchpo.homePenaltyShotIn=homePShotIn;
				matchpo.guestPenaltyShotIn=guestPShotIn;
				matchpo.homeFault=homeFault;
				matchpo.guestFault=guestFault;
				matchpo.guestTeamDeffensiveRebound=guestDeRebound;
				matchpo.homeTeamDeffensiveRebound=homeDeRebound;
				matchpo.guestTeamOffensiveRebound=guestOfRebound;
				matchpo.homeTeamOffensiveRebound=homeOfRebound;
				matchpo.homeAllTime=homeTime;
				matchpo.guestAllTime=guestTime;
				matchpo.homeTeamFoul=homeTeamFoul;
				matchpo.guestTeamFoul=guestTeamFoul;
				matchpo.homeTeamSteal=homeTeamSteal;
				matchpo.guestTeamSteal=guestTeamSteal;
				matchpo.homeTeamSecondaryAttack=homeTeamSecondaryAttack;
				matchpo.guestTeamSecondaryAttack=guestTeamSecondaryAttack;
				matchpo.homeTeamBlockShot=homeTeamBlockShot;
				matchpo.guestTeamBlockShot=guestTeamBlockShot;
				//计算主客队进攻回合
				matchpo.homeTeamOffensiveRound=(double)homeShot+0.4*(double)homePShot-1.07*((double)homeOfRebound/((double)homeOfRebound+(double)guestDeRebound)*((double)homeShot-(double)homeShotin))+1.07*(double)homeFault;
				matchpo.guestTeamOffensiveRound=(double)guestShot+0.4*(double)guestPShot-1.07*((double)guestOfRebound/((double)guestOfRebound+(double)homeDeRebound)*((double)guestShot-(double)guestShotin))+1.07*(double)guestFault;
				int scoreKing=0;
				int reboundKing=0;
				int assistKing=0;
				int mostScore=matchpo.playerStatistic.get(0).score;
				int mostRebound=matchpo.playerStatistic.get(0).rebound;
				int mostSecondaryAttack=matchpo.playerStatistic.get(0).secondaryAttack;

				for(int k=0;k<matchpo.playerStatistic.size()-1;k++){
					if(matchpo.playerStatistic.get(k+1).score>mostScore){
						mostScore=matchpo.playerStatistic.get(k+1).score;
						scoreKing=k+1;
					}
					if(matchpo.playerStatistic.get(k+1).rebound>mostRebound){
						mostRebound=matchpo.playerStatistic.get(k+1).rebound;
						reboundKing=k+1;
					}
					if(matchpo.playerStatistic.get(k+1).secondaryAttack>mostSecondaryAttack){
						mostSecondaryAttack=matchpo.playerStatistic.get(k+1).secondaryAttack;
						assistKing=k+1;
					}
				}
				matchpo.scoringChampion=matchpo.playerStatistic.get(scoreKing).name+"_"+Integer.toString(matchpo.playerStatistic.get(scoreKing).score)+"_"+matchpo.playerStatistic.get(scoreKing).team;
				matchpo.assistChampion=matchpo.playerStatistic.get(assistKing).name+"_"+Integer.toString(matchpo.playerStatistic.get(assistKing).secondaryAttack)+"_"+matchpo.playerStatistic.get(assistKing).team;;
				matchpo.reboundChampion=matchpo.playerStatistic.get(reboundKing).name+"_"+Integer.toString(matchpo.playerStatistic.get(reboundKing).rebound)+"_"+matchpo.playerStatistic.get(reboundKing).team;


				mlist.add(matchpo);
				
			}


		}catch(Exception e) {
			System.out.println("操作出错");
			e.printStackTrace();
		}
		return mlist;
		
	}
	
	//球员基本信息输入
	@SuppressWarnings("resource")
	public ArrayList<PlayerPO> playerRead(){
		try {
			File file = new File("playerData");
			File filelist[]=file.listFiles();
			for(int i=0;i<filelist.length;i++){
				
				PlayerPO playerpo=new PlayerPO();
				ArrayList<String>info=new ArrayList<String>();
				
				BufferedReader bufferedReader = new BufferedReader(new FileReader(filelist[i].getAbsolutePath()));
				String line = null;
				while((line = bufferedReader.readLine())!=null) {
					info.add(line);
				//	System.out.println(line);
				}
				
				String[][]data=new String [9][];
				for(int j=1;j<19;j=j+2){
					data[(j-1)/2]=info.get(j).split("║");
				}
				
				playerpo.name=data[0][1].split("│")[1].trim();
				try{
					playerpo.uniformNum=Integer.parseInt((data[1][1].split("│")[1]).trim());
				}catch(NumberFormatException e){
					playerpo.uniformNum=0;
				}
				playerpo.position=data[2][1].split("│")[1].trim();
				playerpo.height=data[3][1].split("│")[1].trim();
				playerpo.weight=Double.valueOf((data[4][1].split("│")[1]).trim());
				playerpo.birth=data[5][1].split("│")[1].trim();
				playerpo.age=Integer.parseInt((data[6][1].split("│")[1]).trim());
				try{
					playerpo.exp=Integer.parseInt((data[7][1].split("│")[1]).trim());
				}catch(NumberFormatException e){
					playerpo.exp=0;
				}
				playerpo.school=data[8][1].split("│")[1];
				plist.add(playerpo);
				
			}
		}catch(Exception e) {
			System.out.println("操作出错");
			e.printStackTrace();
		}
		return plist;
		
	}
	
	//球队基本信息输入
	@SuppressWarnings("resource")
	public ArrayList<TeamPO> teamRead(){
		try {
			File file = new File("teamData/teams");
			ArrayList<String>info=new ArrayList<String>();					
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = bufferedReader.readLine())!=null) {
				info.add(line);
			//	System.out.println(line);
				
			}
			
			for(int j=1;j<info.size()-1;j++){
				TeamPO teampo=new TeamPO();
				String data[]=info.get(j).split("║")[1].split("│");
				teampo.fullName=data[0].trim();
				teampo.abbreviation=data[1].trim();
				teampo.location=data[2].trim();
				teampo.division=data[3].trim();
				teampo.partition=data[4].trim();
				teampo.homeCourt=data[5].trim();
				teampo.time=data[6].trim();
				tlist.add(teampo);
			}
			
		}catch(Exception e) {
			System.out.println("操作出错");
			e.printStackTrace();
		}
		return tlist;
		
	}
	
	
	
	
}

