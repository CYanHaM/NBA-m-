package bussinesslogic.playertechbl;

import java.util.ArrayList;

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
}
