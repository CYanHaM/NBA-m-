package bussinesslogic.TeamTech;

import java.util.ArrayList;

import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;

public class littleTest {
	public static void main(String args[]){
		TeamTech tt = new TeamTech();
		ArrayList<TeamTechVO> ttv = new ArrayList<TeamTechVO>();
		ttv = tt.Ascend(TeamTechEnum.threeShotInRate);
		for(int i = 0; i<ttv.size(); i++){
			System.out.println(ttv.get(i).threeShotInRate);
		}
		ttv = tt.Ascend(TeamTechEnum.threeShotInRate);
		for(int i = 0; i<ttv.size(); i++){
			System.out.println(ttv.get(i).threeShotInRate);
		}
	}
}
