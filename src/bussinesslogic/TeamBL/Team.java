package bussinesslogic.TeamBL;

import java.rmi.RemoteException;

import PO.TeamPO;
import VO.TeamVO;
import blservice.teamblservice.TeamBLservice;
import bussinesslogic.Transfer.L2P.TeamL2P;
import bussinesslogic.Transfer.L2V.TeamL2V;
import bussinesslogic.Transfer.P2L.TeamP2L;
import bussinesslogic.Transfer.V2L.TeamV2L;
import data.TeamData;
import dataservice.TeamDataService;

public class Team implements TeamBLservice{
	TeamDataService tdservice = new TeamData();
	
	@Override
	public TeamVO Show(TeamVO tvo) {
		// TODO Auto-generated method stub
		TeamP2L P2L = new TeamP2L();
		TeamV2L V2L = new TeamV2L();
		TeamL2P L2P = new TeamL2P();
		TeamL2V L2V = new TeamL2V();
		
		TeamLineItem temptli = V2L.v2l(tvo);
		TeamPO tpo = L2P.l2p(temptli);
		TeamPO resultpo = new TeamPO();
		try {
			resultpo = tdservice.find(tpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TeamLineItem tli = P2L.p2l(resultpo);
		TeamVO result = L2V.l2v(tli);
		
		return result;
	}
	
	public void init(){
		tdservice.WriteIn();
	}

}
