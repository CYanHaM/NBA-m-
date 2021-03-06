package data;

import java.util.ArrayList;

import PO.MatchPO;
import PO.PlayerPO;
import PO.TeamPO;

public interface readFrom {
	public ArrayList<MatchPO> matchRead();
	public ArrayList<PlayerPO> playerRead();
	public ArrayList<TeamPO> teamRead();
}
