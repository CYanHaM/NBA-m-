package bussinesslogic.TeamTech;

import java.util.ArrayList;

import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import data.TeamData;
import data.TeamTechData;

public class littleTest {
	public static void main(String args[]){
		TeamTech tt = new TeamTech();
		ArrayList<TeamHighInfo> thi = new ArrayList<TeamHighInfo>();
		ArrayList<TeamNormalInfo> tni = new ArrayList<TeamNormalInfo>();
		ArrayList<TeamHotInfo> hoti = new ArrayList<TeamHotInfo>();
		TeamData td = new TeamData();
		td.WriteIn();
		TeamTechData ttd = new TeamTechData();
		ttd.WriteIn("matchData");
//		thi = tt.sortHigh("winRate.asc", 30);
//		for(int i = 0; i<30; i++){
//			System.out.println(thi.get(i).toString());
//		}
		tni = tt.sortNorm("point.des", 30, true);
		for(int i = 0; i<30; i++){
			System.out.println(tni.get(i).getFoul());
		}
		for(int i = 0; i<30;i++){
			System.out.println(tni.get(i).getFault());
		}

	}
}
