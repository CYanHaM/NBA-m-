package bussinesslogic.Transfer.playerinfotrans;

import java.util.ArrayList;

import PO.PlayerPO;
import VO.PlayerVO;

public class PO2VO {
	
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
	
	public ArrayList<PlayerVO> list2vo (ArrayList<PlayerPO> list){
		int size = list.size();
		ArrayList<PlayerVO> res = new ArrayList<PlayerVO>();
		for(int i=0;i<size;i++){
			//�������ֱ�ӵ��ÿ컹�Ƕ����ֵ�죿��
			PlayerVO vo = po2vo(list.get(i));
			res.add(vo);
		}
		return res;
	}

}
