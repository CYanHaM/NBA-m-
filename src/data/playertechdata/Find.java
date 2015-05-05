package data.playertechdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import dataservice.playertechdataservice.FindDataService;
import dataservice.playertechdataservice.ShowDataService;

public class Find implements FindDataService {

	ShowDataService sh = new Show();
	OperateWithFile owf = new OperateWithFile();
	
	@Override
	public ArrayList<PlayerTechMPO> findHotPlayerToday(String date, final String keyword)  {
		// TODO Auto-generated method stub
		//ɸѡ����ı�������
		ArrayList<PlayerTechMPO> list = owf.readMPO();
		ArrayList<PlayerTechMPO> res = new ArrayList<PlayerTechMPO>(); 
		int size = list.size();
		for(int i=0;i<size;i++){    
			if(list.get(i).date.equals(date)){
				res.add(list.get(i));
			}
		}
		//��������
		Comparator<PlayerTechMPO> comparator = new Comparator<PlayerTechMPO>(){  
			
			public int compare(PlayerTechMPO p2, PlayerTechMPO p1) {   
				//��д�ȽϷ���
				switch(keyword){
				case "rebound":
					return p1.rebound-p2.rebound;
				case "secondaryattack":
					return p1.secondaryAttack-p2.secondaryAttack;	
				case "steal":
					return p1.steal-p2.steal;
				case "blockshot":
					return p1.blockShot-p2.blockShot;
				case "score":
					return p1.score-p2.score;
				case "double":
					return p1.ifDouble-p2.ifDouble;
				case "scoreratio":
					int ra1 = p1.score+p1.rebound+p1.secondaryAttack;
					int ra2 = p2.score+p2.rebound+p2.secondaryAttack;
					return ra1-ra2;
				case "efficiency":
					int eff1 = (p1.score+p1.blockShot+p1.steal+p1.secondaryAttack+p1.rebound)-(p1.shot-p1.shotIn)-(p1.penaltyShot-p1.penaltyShotIn)-p1.fault;
					int eff2 = (p2.score+p2.blockShot+p2.steal+p2.secondaryAttack+p2.rebound)-(p2.shot-p2.shotIn)-(p2.penaltyShot-p2.penaltyShotIn)-p2.fault;
					return eff1-eff2;
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		Collections.sort(res, comparator);
		Iterator<PlayerTechMPO> it = res.iterator();
		ArrayList<PlayerTechMPO> result = new ArrayList<PlayerTechMPO>();
		int i=0;
		while(i<5&&it.hasNext()){
			result.add(it.next());
			i++;
		}
		return result;
	}

	@Override
	public ArrayList<PlayerTechPO> findFastImprovingPlayer() {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechPO> list = owf.readPO();
		return list;
	}

}
