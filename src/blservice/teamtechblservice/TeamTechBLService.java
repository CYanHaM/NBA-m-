package blservice.teamtechblservice;

import java.util.ArrayList;

import TypeEnum.SortEnum;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;

public interface TeamTechBLService {
    public ArrayList<TeamTechVO> Ascend(TeamTechEnum DataType);
	/* �������������
	 * �������������
	 * ����
     * */
    
    public ArrayList<TeamTechVO> Descend(TeamTechEnum DataType);
	/* �������������
	 * �������������
	 * ����
     * */
    
    public ArrayList<TeamTechVO> refresh(SortEnum sort, TeamTechEnum DataType);
    /* ������������ͣ��Լ�������ǽ���
     * */
    
    public ArrayList<TeamTechVO> findSeasonHotTeam(TeamTechEnum DataType);
    /* ����ɸѡ����
     * */
    
    public void init();
}
