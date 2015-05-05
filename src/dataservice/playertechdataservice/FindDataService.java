package dataservice.playertechdataservice;

import java.util.ArrayList;

import PO.PlayerTechMPO;
import PO.PlayerTechPO;

public interface FindDataService {
	
	public ArrayList<PlayerTechMPO> findHotPlayerToday(String date, String keyword);
	
	//杩涙鏈�蹇悆鍛�
	public ArrayList<PlayerTechPO> findFastImprovingPlayer();
}
