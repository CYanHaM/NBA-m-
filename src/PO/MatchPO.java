package PO;
import java.io.Serializable;
import java.util.ArrayList;


public class MatchPO implements Serializable{
	
	/**
	 * ÿ������������
	 */
	public static final long serialVersionUID = 1L;
	public String season;                                 //����
	public String date;                                   //����
	public String homeTeam;                               //��������
	public String guestTeam;                              //�ͳ�����
	public String score;                                  //�ȷ�
	public String score1;                                 //��һ�ڱȷ�
	public String score2;                                 //�ڶ��ڱȷ�
	public String score3;                                 //�����ڱȷ�
	public String score4;                                 //���Ľڱȷ�
	public String scoreExtra;                             //��ʱ���ȷ�
	public ArrayList<PlayerTechMPO> playerStatistic;      //��Ա����ͳ��
	public String scoringChampion;                            //�÷���
	public String reboundChampion;                          //������
	public String assistChampion;                      //������
	public int ifHomeTeamWin;                         //�����Ƿ�ʤ��
	public int ifGuestTeamWin;                        //�Ͷ��Ƿ�ʤ��
	public int homeTeamDeffensiveRebound;              //���ӷ�������
	public int guestTeamDeffensiveRebound;              //�Ͷӷ�������
	public int homeTeamOffensiveRebound;              //���ӽ�������
	public int guestTeamOffensiveRebound;              //�Ͷӽ�������
	public double homeTeamOffensiveRound;              //���ӽ����غ�
	public double guestTeamOffensiveRound;              //�Ͷӽ����غ�
	public int homeScore;               //���ӵ÷�
	public int guestScore;               //�Ͷӵ÷�
	public int homeAllTime;              //����ȫԱ�ϳ�ʱ��
	public int guestAllTime;             //�Ͷ�ȫԱ�ϳ�ʱ��
	public int homeShotIn;              //�����ܽ�����
	public int guestShotIn;              //�Ͷ��ܽ�����
	public int homeShot;             //���ӳ��ִ���
	public int guestShot;            //�Ͷӳ��ִ���
	public int homeTwoShot;             //�������ֳ��ִ���
	public int guestTwoShot;            //�Ͷ����ֳ��ִ���
	public int homeTwoShotIn;             //�������ֽ�����
	public int guestTwoShotIn;            //�Ͷ����ֽ�����
	public int homeThreeShot;             //�������ֳ��ִ���
	public int guestThreeShot;            //�Ͷ����ֳ��ִ���
	public int homeThreeShotIn;             //�������ֽ�����
	public int guestThreeShotIn;            //�Ͷ����ֽ�����
	public int homePenaltyShot;         //���ӷ������
	public int guestPenaltyShot;        //�Ͷӷ������
	public int homePenaltyShotIn;         //���ӷ��������
	public int guestPenaltyShotIn;        //�Ͷӷ��������
	public int homeFault;                //����ʧ�����
	public int guestFault;               //�Ͷ�ʧ�����

}
