package bussinesslogic.Transfer;

import PO.PlayerPO;
import VO.PlayerVO;

public class PlayerInfoTrans {
	
	public PlayerVO po2vo (PlayerPO po){
		
		PlayerVO vo = new PlayerVO();
		vo.name = po.name;  
		vo.uniformNum = po.uniformNum;
		vo.position = po.position;
		vo.height = po.height;
		vo.weight = po.weight;
		vo.birth = po.birth;
		vo.age = po.age;
		vo.exp = po.exp;
		vo.school = po.school;
		
		return vo;
		
	}

}
