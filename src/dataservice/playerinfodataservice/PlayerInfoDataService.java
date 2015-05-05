package dataservice.playerinfodataservice;

import java.util.ArrayList;

import PO.PlayerPO;

public interface PlayerInfoDataService {
	
	public ArrayList<PlayerPO> findAll();
	
	public PlayerPO findOne(String name);

	public void write();
}
