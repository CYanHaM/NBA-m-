package data.playertechdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
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
	
	public void write(String dataSource){
		//calculate计算一些球员所属的球队属性
		ArrayList<PlayerTechMPO> mpoList = calculateTeam(dataSource);
		//用来存放所有的PlayerTech信息
		ArrayList<PlayerTechPO> poList = new ArrayList<PlayerTechPO>();

		//用来存放球员每场比赛的按名字分类后的信息
		ArrayList<ArrayList<PlayerTechMPO> > div = new ArrayList<ArrayList<PlayerTechMPO> >();
		while(mpoList.size()!=0){
			int mpoSize = mpoList.size();
			
			ArrayList<PlayerTechMPO> temp = new ArrayList<PlayerTechMPO>();
			temp.add((PlayerTechMPO) mpoList.get(0).clone());
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
			Iterator<PlayerTechMPO> it = mpoList.iterator();
			while(it.hasNext()){  
			    PlayerTechMPO tem = it.next();  
			    if(tem.name.equals("")){  
			    	it.remove();  
			    }  
			} 
			div.add(temp);
			PlayerTechPO ptp = new PlayerTechPO();
			//球员各人数据
			ptp.name = name;
			ptp.team = team;
			ptp.position = position;
			ptp.division = division;
			
			int tempSize = temp.size();
			for(int i=0;i<tempSize;i++){
				PlayerTechMPO mp = temp.get(i);
				if(mp.ifParticipate!=0){
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
					ptp.ifDouble += mp.ifDouble;
				}
				ptp.teamAllTime += mp.teamAllTime;
				ptp.teamOffensiveRebound += mp.teamOffensiveRebound;
				ptp.teamDefensiveRebound += mp.teamDefensiveRebound;
				ptp.opponentOffensiveRebound += mp.opponentOffensiveRebound;
				ptp.opponentDefensiveRebound += mp.opponentDefensiveRebound;
				ptp.teamShotIn += mp.teamShotIn;
				ptp.opponentOffensiveNum += mp.opponentOffensiveNum;
				ptp.opponentTwoShot += mp.opponentTwoShot;
				ptp.teamShot += mp.teamShot;
				ptp.teamPenaltyShot += mp.teamPenaltyShot;
				ptp.teamFault += mp.teamFault;
			
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
	public ArrayList<PlayerTechMPO> calculateTeam(String dataSource){
		
		ArrayList<PlayerTechMPO> res = new ArrayList<PlayerTechMPO>();
		
		readFrom rf = new DataProcessing(dataSource);
		ArrayList<MatchPO> match = rf.matchRead();   
		int matchSize = match.size();
		for(int i=0;i<matchSize;i++){
			MatchPO ma = match.get(i);
			ArrayList<PlayerTechMPO> list = ma.playerStatistic;  
			
			//一些球队数据
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
		 
		ArrayList<ArrayList<PlayerTechMPO>> li = readDiv(); 
		int size = li.size(); 
		for(int i=0;i<size;i++){
			//每个球员的每场数据
			ArrayList<PlayerTechMPO> list = li.get(i);
			Iterator<PlayerTechMPO> it2 = list.iterator();
			while(it2.hasNext()){
				if(it2.next().time==0)
					it2.remove();
			}
		/*	Comparator<PlayerTechMPO> comparator = new Comparator<PlayerTechMPO>(){  
				//逆序
				public int compare(PlayerTechMPO p1, PlayerTechMPO p2) {   
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					 Date dt1;
					 Date dt2;
					try {
						dt1 = sdf.parse(p1.date);
						dt2 = sdf.parse(p2.date);
						return dt2.compareTo(dt1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 0;
				}
			}; 
			Collections.sort(list, comparator);
			for(PlayerTechMPO mpo:list)
				System.out.println(mpo.date);
		*/
			dateSort(list);
			for(PlayerTechMPO mpo:list)
				System.out.println(mpo.date);
		}
		Iterator<ArrayList<PlayerTechMPO>> it = li.iterator();
		while(it.hasNext()){
			if(it.next().size()<=5){
				it.remove();
			}
		}
		int s = li.size();
		for(int i=0;i<s;i++){
			ArrayList<PlayerTechMPO> list= li.get(i);
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
			int latestSecondaryAttack=0;
			int latestRebound=0;
			int score = 0;
			int secondaryAttack=0;
			int rebound=0;
		
			for(int m=0;m<5;m++){
				PlayerTechMPO mp =  latest.get(m);
				latestScore += mp.score;
				latestSecondaryAttack +=mp.secondaryAttack;
				latestRebound += mp.rebound;
			}
		
			int listSize = list.size();
			for(int m=0;m<listSize;m++){
				PlayerTechMPO mp = list.get(m);
				score += mp.score;
				secondaryAttack+= mp.secondaryAttack;
				rebound += mp.rebound;
			}
			double scoreImproving=((double)score/(double)listSize)==0?0:((((double)latestScore/(double)5)-(double)score/(double)listSize)/((double)score/(double)listSize));
		    double secondaryAttackImproving=((double)secondaryAttack/(double)listSize)==0?0:((((double)latestSecondaryAttack/(double)5)-(double)secondaryAttack/(double)listSize)/((double)secondaryAttack/(double)listSize));
			double reboundImproving=((double)rebound/(double)listSize)==0?0:((((double)latestRebound/(double)5)-(double)rebound/(double)listSize)/((double)rebound/(double)listSize));
			
			int poSize = poList.size();
			for(int m=0;m<poSize;m++){
				PlayerTechPO po = poList.get(m);
				if(po.name.equals(name)){ 
					po.scoreImproving = scoreImproving;           		
					po.secondaryAttackImproving = secondaryAttackImproving;		
					po.reboundImproving = reboundImproving;		
				}
			}
		}
		return poList;
	}
	
	public void dateSort(ArrayList<PlayerTechMPO> mlist){

		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		Date d1=new Date();
		Date d2=new Date();
		PlayerTechMPO compo=new PlayerTechMPO();
		for(int i=0;i<mlist.size();i++){
			for(int j=0;j<mlist.size()-i-1;j++){
				try {
					d1=fmt.parse(mlist.get(j).date);
					d2=fmt.parse(mlist.get(j+1).date);
					if(d1.after(d2)){
						compo=mlist.get(j);
						mlist.set(j, mlist.get(j+1));
						mlist.set(j+1, compo);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		
		}
	}
}
