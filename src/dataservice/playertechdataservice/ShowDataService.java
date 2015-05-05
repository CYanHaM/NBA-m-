package dataservice.playertechdataservice;

import java.util.ArrayList;

import PO.PlayerTechPO;

public interface ShowDataService {
	
	   //杩斿洖璧涘鐞冨憳鏁版嵁
		public ArrayList<PlayerTechPO> showSeasonPlayerData ();
		
		//鏌ョ湅鏌愪竴鐞冨憳鍏抽敭鏁版嵁
		public PlayerTechPO showKeyData (String name,String team );


		public void refresh();
}
