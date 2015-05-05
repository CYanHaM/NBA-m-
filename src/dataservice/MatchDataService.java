package dataservice;

import java.util.ArrayList;

import PO.MatchPO;

public interface MatchDataService {
	public ArrayList<MatchPO> read();
	public String showPresentTime();

}
