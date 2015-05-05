package data;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.TeamPO;
import PO.TeamTechPO;

public class testForTeam {
	public static void main(String args[]){
		TeamTechData ttd = new TeamTechData();
		ttd.WriteIn();
		
		TeamData td = new TeamData();
		
		td.WriteIn();
		
		ArrayList<TeamPO> tlist = new ArrayList<TeamPO>();
		tlist = td.read();
		
		ArrayList<TeamTechPO> list = new ArrayList<TeamTechPO>();
		try {
			list = ttd.list();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<30; i++){
			System.out.println(tlist.get(i).abbreviation);
		}
	}
}
