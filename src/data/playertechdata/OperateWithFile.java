package data.playertechdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import data.DataProcessing;
import data.readFrom;
import dataservice.playertechdataservice.PlayerTechInitial;
import PO.MatchPO;
import PO.PlayerTechMPO;
import PO.PlayerTechPO;

public class OperateWithFile implements PlayerTechInitial {
	
	public static void main(String[] args){
		OperateWithFile owf = new OperateWithFile();
		owf.write();
	}
	
	public void write(){
		
		
		ArrayList<PlayerTechMPO> mpoList = calculateTeam();
		ArrayList<PlayerTechPO> poList = new ArrayList<PlayerTechPO>();

		ArrayList<ArrayList<PlayerTechMPO> > div = new ArrayList<ArrayList<PlayerTechMPO> >();
		while(mpoList.size()!=0){
			int mpoSize = mpoList.size();
			//�ݴ�ͬһ��Ա��ÿ���������ݡ�
			ArrayList<PlayerTechMPO> temp = new ArrayList<PlayerTechMPO>();
			temp.add(mpoList.get(0));
			String name = mpoList.get(0).name;
			String team = mpoList.get(0).team;
			String position = mpoList.get(0).position;
			String division = mpoList.get(0).division;
			for(int i=1;i<mpoSize;i++){
				PlayerTechMPO m = mpoList.get(i);
				if(m.name.equals(name)&&m.team.equals(team)){
					temp.add((PlayerTechMPO)m.clone());
					m.name = "";
				}
			}
			mpoList.get(0).name = "";
			//��mpoList���Ѵ������ɾ����
			Iterator<PlayerTechMPO> it = mpoList.iterator();
			while(it.hasNext()){  
			    PlayerTechMPO  tem = it.next();  
			    if(tem.name.equals("")){  
			    it.remove();  
			    }  
			} 
			div.add(temp);
			//��temp���д���
			PlayerTechPO ptp = new PlayerTechPO();
			ptp.name = name;
			ptp.team = team;
			ptp.position = position;
			ptp.division = division;
			//����������Ӷ���
			ptp.gameNum = 0;
			ptp.startingNum = 0;
			ptp.rebound = 0;
			ptp.secondaryAttack = 0;
			ptp.time = 0;
			ptp.offensiveNum = 0;
			ptp.defensiveNum = 0;
			ptp.steal = 0;
			ptp.blockShot = 0;
			ptp.fault = 0;
			ptp.foul = 0;
			ptp.score = 0;
			ptp.shotIn = 0;
			ptp.shot = 0;
			ptp.threeShotIn = 0;
			ptp.threeShot = 0;
			ptp.penaltyShotIn = 0;
			ptp.penaltyShot = 0;
			ptp.teamAllTime = 0;
			ptp.teamOffensiveRebound = 0;
			ptp.teamDefensiveRebound = 0;
			ptp.opponentOffensiveRebound = 0;
			ptp.opponentDefensiveRebound = 0;
			ptp.teamShotIn = 0;
			ptp.opponentOffensiveNum = 0;
			ptp.opponentTwoShot = 0;
			ptp.teamShot = 0;
			ptp.teamPenaltyShot = 0;
			ptp.teamFault = 0;
			
			
			int tempSize = temp.size();
			for(int i=0;i<tempSize;i++){
				PlayerTechMPO mp = temp.get(i);
				//���δ�������򲻱ؼ�������
				if(mp.ifParticipate==0)
					break;
				ptp.gameNum += mp.ifParticipate;
				ptp.startingNum += mp.ifFirstLineUp;
				ptp.rebound += mp.rebound;
				ptp.secondaryAttack += mp.secondaryAttack;
				ptp.time += mp.time;                                                 
				ptp.offensiveNum += mp.offensiveRebound;
				ptp.defensiveNum += mp.defensiveRebound;
				ptp.steal += mp.steal;
				ptp.blockShot += mp.blockShot;
				ptp.fault += mp.fault;
				ptp.foul += mp.foul;
				ptp.score += mp.score;
				ptp.shotIn += mp.shotIn;
				ptp.shot += mp.shot;
				ptp.threeShotIn += mp.threeShotIn;
				ptp.threeShot += mp.threeShot;
				ptp.penaltyShotIn += mp.penaltyShotIn;
				ptp.penaltyShot += mp.penaltyShot;
				ptp.ifDouble += ptp.ifDouble;
				
				ptp.teamAllTime = mp.teamAllTime;
				ptp.teamOffensiveRebound = mp.teamOffensiveRebound;
				ptp.teamDefensiveRebound = mp.teamDefensiveRebound;
				ptp.opponentOffensiveRebound = mp.opponentOffensiveRebound;
				ptp.opponentDefensiveRebound = mp.opponentDefensiveRebound;
				ptp.teamShotIn = mp.teamShotIn;
				ptp.opponentOffensiveNum = mp.opponentOffensiveNum;
				ptp.opponentTwoShot = mp.opponentTwoShot;
				ptp.teamShot = mp.teamShot;
				ptp.teamPenaltyShot = mp.teamPenaltyShot;
				ptp.teamFault = mp.teamFault;
			}
			
			
			if(ptp.shot==0){					
				ptp.shotInRate=0;
				}else{
					ptp.shotInRate=(double)ptp.shotIn/(double)ptp.shot;
			}
			if(ptp.threeShot==0){					
				ptp.threeShotInRate=0;
				}else{
					ptp.threeShotInRate=(double)ptp.threeShotIn/(double)ptp.threeShot;
				}
			ptp.penaltyShot=ptp.penaltyShot;
			ptp.penaltyShotIn=ptp.penaltyShotIn;
			if(ptp.penaltyShot==0){					
				ptp.penaltyShotInRate=0;
				}else{
					ptp.penaltyShotInRate=(double)ptp.penaltyShotIn/(double)ptp.penaltyShot;
				}
			ptp.efficiency=(ptp.score+ptp.rebound+ptp.secondaryAttack+ptp.steal+ptp.blockShot)-(ptp.shot-ptp.shotIn)-(ptp.penaltyShot-ptp.penaltyShotIn)-ptp.fault;
			ptp.GmScEfficiency=(double)ptp.score+0.4*(double)ptp.shotIn-0.7*(double)ptp.shot-0.4*((double)ptp.penaltyShot-(double)ptp.penaltyShotIn)+0.7*(double)ptp.offensiveNum+0.3*(double)ptp.defensiveNum+(double)ptp.steal+0.7*(double)ptp.secondaryAttack+0.7*(double)ptp.blockShot-0.4*(double)ptp.foul-(double)ptp.fault;
			if(2*((double)ptp.shot+0.44*(double)ptp.penaltyShot)==0){
					ptp.trueShotInRate=0;
				}else{
					ptp.trueShotInRate=(double)ptp.score/(2*((double)ptp.shot+0.44*(double)ptp.penaltyShot));
					}
			if((double)ptp.shot==0){
				ptp.shootingEfficiency=0;
			}else{
				ptp.shootingEfficiency=((double)ptp.shotIn+0.5*(double)ptp.threeShotIn)/(double)ptp.shot;
			}
			if(ptp.time==0){
				ptp.reboundRate=0;
			}else{
				ptp.reboundRate=(double)ptp.rebound*((double)ptp.teamAllTime/5)/(double)ptp.time/((double)ptp.teamDefensiveRebound+(double)ptp.teamOffensiveRebound+(double)ptp.opponentDefensiveRebound+(double)ptp.opponentOffensiveRebound);
			}
			if((double)ptp.time==0){
				ptp.offensiveReboundRate=0;
			}else{
				ptp.offensiveReboundRate=(double)ptp.offensiveNum*((double)ptp.teamAllTime/5)/(double)ptp.time/((double)ptp.teamOffensiveRebound+(double)ptp.opponentOffensiveRebound);
			}
			if((double)ptp.time==0){
				ptp.defensiveReboundRate=0;
			}else{
				ptp.defensiveReboundRate=(double)ptp.defensiveNum*((double)ptp.teamAllTime/5)/(double)ptp.time/((double)ptp.teamDefensiveRebound+(double)ptp.opponentDefensiveRebound);
			}
			if((double)ptp.time==0){
				ptp.secondaryAttackRate=0;
			}else{
				ptp.secondaryAttackRate=(double)ptp.secondaryAttack/((double)ptp.time/((double)ptp.teamAllTime/5)*(double)ptp.teamShotIn-(double)ptp.shotIn);
			}
			if((double)ptp.time==0){
				ptp.stealRate=0;
			}else{
				ptp.stealRate=(double)ptp.steal*((double)ptp.teamAllTime/5)/(double)ptp.time/(double)ptp.opponentOffensiveNum;
			}
			
			if(ptp.time==0){
				ptp.blockShotRate=0;
			}else{    
				ptp.blockShotRate=(double)ptp.blockShot*((double)ptp.teamAllTime/5)/(double)ptp.time/(double)ptp.opponentTwoShot;
			}
			if(((double)ptp.shot==0)){
				ptp.faultRate=0;
				}else{
					ptp.faultRate=(double)ptp.fault/((double)ptp.shot-(double)ptp.threeShot+0.44*(double)ptp.penaltyShot+(double)ptp.fault);
			}
			if((double)ptp.time==0){
				ptp.usageRate=0;
			}else{
				ptp.usageRate=((double)ptp.shot+0.44*(double)ptp.penaltyShot+(double)ptp.fault)*((double)ptp.teamAllTime/5)/(double)ptp.time/((double)ptp.teamShot+0.44*(double)ptp.teamPenaltyShot+(double)ptp.teamFault);
			}
			
			poList.add(ptp);
	   }
	  try {
		   FileOutputStream fos2 = new FileOutputStream("database/PlayerTechMPODiv.ser");
           ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
           oos2.writeObject(div);
           oos2.flush();
           oos2.close();
	          
        	FileOutputStream fos = new FileOutputStream("database/PlayerTechPO.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(calculateImproving(poList));
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	public ArrayList<PlayerTechPO> readPO(){
		ArrayList<PlayerTechPO> list = new ArrayList<PlayerTechPO>(); 
		try{
			FileInputStream fis = new FileInputStream("database/PlayerTechPO.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        list =  (ArrayList<PlayerTechPO>) ois.readObject();
	        ois.close();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return list;
	}
	
	public ArrayList<ArrayList<PlayerTechMPO>> readDiv(){
		ArrayList<ArrayList<PlayerTechMPO>> res = new ArrayList<ArrayList<PlayerTechMPO>>(); 
		try{
			FileInputStream fis = new FileInputStream("database/PlayerTechMPODiv.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        res=  (ArrayList<ArrayList<PlayerTechMPO>>) ois.readObject();
	        ois.close();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return res;
	}
	
	public ArrayList<PlayerTechMPO> readMPO(){
	    ArrayList<PlayerTechMPO> res = new ArrayList<PlayerTechMPO>(); 
		try{
			FileInputStream fis = new FileInputStream("database/PlayerTechMPO.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        res=  (ArrayList<PlayerTechMPO>) ois.readObject();
	        ois.close();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return res;
	}
	
	public ArrayList<PlayerTechMPO> calculateTeam(){
		
		ArrayList<PlayerTechMPO> res = new ArrayList<PlayerTechMPO>();
		
		readFrom rf = new DataProcessing();
		ArrayList<MatchPO> match = rf.matchRead();   
		int matchSize = match.size();
		for(int i=0;i<matchSize;i++){
			MatchPO ma = match.get(i);
			ArrayList<PlayerTechMPO> list = ma.playerStatistic;  
			
			int teamAllTime =ma.homeAllTime;                  //ȫ���ϳ�ʱ��
			int teamOffensiveRebound = ma.homeTeamOffensiveRebound;                  //ȫ�ӽ�������
			int teamDefensiveRebound = ma.homeTeamDeffensiveRebound;                //ȫ�ӷ�������
			int opponentOffensiveRebound = ma.guestTeamOffensiveRebound;                  //���ֽ�������
			int opponentDefensiveRebound =ma.guestTeamDeffensiveRebound;                //���ַ�������
		    int teamShotIn = ma.homeTwoShotIn+ma.homeThreeShotIn;                             //ȫ�ӽ�����
			double opponentOffensiveNum = ma.guestTeamOffensiveRound;                     //���ֽ�������
			int opponentTwoShot =ma.guestTwoShot;                     //���ֽ�����������ִ���
			int teamShot = ma.homeShot;                          //ȫ�ӳ��ִ���
		    int teamPenaltyShot =ma.homePenaltyShot;                   //ȫ�ӷ������
			int teamFault = ma.homeFault;                          //ȫ��ʧ�����    
			
			int listSize = list.size();
			for(int j=0;j<listSize;j++){
				PlayerTechMPO mp = list.get(j);
				mp.teamAllTime = teamAllTime;
				mp.teamOffensiveRebound = teamOffensiveRebound;
				mp.teamDefensiveRebound = teamDefensiveRebound ;
				mp.opponentOffensiveRebound = opponentOffensiveRebound;
				mp.opponentDefensiveRebound = opponentDefensiveRebound;
				mp.teamShotIn = teamShotIn;
				mp.opponentOffensiveNum = opponentOffensiveNum;
				mp.opponentTwoShot = opponentTwoShot;
				mp.teamShot = teamShot;
				mp.teamPenaltyShot = teamPenaltyShot ;
				mp.teamFault = teamFault;
				res.add(mp);
			}
		}
	
		try {
        	FileOutputStream fos = new FileOutputStream("database/PlayerTechMPO.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(res);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return res;
	}
	
	public ArrayList<PlayerTechPO> calculateImproving(ArrayList<PlayerTechPO> poList){
		 //���㰴ʱ�����򡢰���������ļ���ͳ��
		 ArrayList<ArrayList<PlayerTechMPO>> li = readDiv(); 
		 //若某球员的比赛数量小于等于5，则删除该球员
		 Iterator<ArrayList<PlayerTechMPO>> it = li.iterator();  
			while(it.hasNext()){ 
				if(it.next().size()<=5){  
					it.remove(); 
				}
			}
		int size = li.size(); 
		for(int i=0;i<size;i++){
			//每个球员的每场数据
			ArrayList<PlayerTechMPO> list = li.get(i);
			//��������
			Comparator<PlayerTechMPO> comparator = new Comparator<PlayerTechMPO>(){  
				public int compare(PlayerTechMPO p1, PlayerTechMPO p2) {   
					//��д�ȽϷ���,����Ƚ�����
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd",Locale.CHINA);
					 Date dt1;
					 Date dt2;
					try {
						dt1 = sdf.parse(p1.date);
						dt2 = sdf.parse(p2.date);
						 if(dt2.getTime()>dt1.getTime())
							 return 1;
						 else
							 return -1;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 0;
				}
			}; 
			Collections.sort(list, comparator);
		}
		
	 //按日期分割
	 for(int j=0;j<size;j++){
		ArrayList<PlayerTechMPO> list= li.get(j);
		String name = list.get(0).name;
		//每个球员的最近5场比赛存入latest
		ArrayList<PlayerTechMPO> latest = new ArrayList<PlayerTechMPO>();
		int num=0;
		while(num<5){     
			latest.add(list.get(0));
			list.remove(0);
			num++;
		}
		
		int latestScore = 0;
		int latestSteal=0;
		int latestBlockShot=0;
		int latestSecondaryAttack=0;
		int latestRebound=0;
		int score = 0;
		int steal=0;
		int blockShot=0;
		int secondaryAttack=0;
		int rebound=0;
		
		for(int i=0;i<5;i++){
			PlayerTechMPO mp =  latest.get(i);
			latestScore += mp.score;
			latestSteal += mp.steal;
			latestBlockShot += mp.blockShot;
			latestSecondaryAttack +=mp.secondaryAttack;
			latestRebound += mp.rebound;
		}
		
		int listSize = list.size();
		for(int i=0;i<listSize;i++){
			PlayerTechMPO mp =  list.get(i);
			score = mp.score;
			steal=mp.steal;
			blockShot=mp.blockShot;
			secondaryAttack=mp.secondaryAttack;
			rebound=mp.rebound;
		}
		
		double scoreImproving=(score/(double)listSize)==0?0:((((double)latestScore/5)-score/(double)listSize)/(score/(double)listSize));
	    double stealImproving=(steal/(double)listSize)==0?0:((((double)latestSteal/5)-steal/(double)listSize)/(steal/(double)listSize));
		double blockShotImproving=(blockShot/(double)listSize)==0?0:((((double)latestBlockShot/5)-blockShot/(double)listSize)/(blockShot/(double)listSize));
		double secondaryAttackImproving=(secondaryAttack/(double)listSize)==0?0:((((double)latestSecondaryAttack/5)-secondaryAttack/(double)listSize)/(secondaryAttack/(double)listSize));
		double reboundImproving=(rebound/(double)listSize)==0?0:((((double)rebound/5)-rebound/(double)listSize)/(rebound/(double)listSize));
		
		int poSize = poList.size();
		for(int m=0;m<poSize;m++){
			PlayerTechPO po = poList.get(m);
			if(po.name.equals(name)){ 
				po.scoreImproving = scoreImproving;           
				po.stealImproving = stealImproving;				
				po.blockShotImproving = blockShotImproving;			
				po.secondaryAttackImproving = secondaryAttackImproving;		
				po.reboundImproving = reboundImproving;		
			}
		}
	 }
	 return poList;
	}

}
