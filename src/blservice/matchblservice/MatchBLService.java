package blservice.matchblservice;

import java.util.ArrayList;

import VO.MatchVO;

public interface MatchBLService {
	public ArrayList<MatchVO> showMatchList(String date);
	public MatchVO showMatch(String team,String date);
	public ArrayList<MatchVO> refresh(String date);
	public String returnPresentDate();
	public ArrayList<MatchVO> showMatchListByTime(String date,int time);

}
