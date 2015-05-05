package blservice.playerinfoblservice;

import java.util.ArrayList;

import VO.PlayerVO;

public interface PlayerInfoService {
	
	public ArrayList<PlayerVO> showAllPlayerInfo ();
	
	public PlayerVO showPlayerInfo (String name);
	
	public ArrayList<PlayerVO> findPlayerByLetter(char letter);   

	public ArrayList<PlayerVO> findByTeam(String team);
	
	public void PlayerInfoIni();
}
