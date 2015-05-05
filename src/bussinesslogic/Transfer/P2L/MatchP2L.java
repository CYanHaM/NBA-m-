package bussinesslogic.Transfer.P2L;

import PO.MatchPO;
import bussinesslogic.matchbl.MatchLineItem;

public class MatchP2L {

	public MatchLineItem p2l(MatchPO mp){
		MatchLineItem mli=new MatchLineItem();
		 mli.season=mp.season;                                             //����
		 mli.date=mp.date;                                                 //����
		 mli.homeTeam=mp.homeTeam;                                         //��������
		 mli.guestTeam=mp.guestTeam;                                       //�ͳ�����
		 mli.score=mp.score;                                               //�ȷ�
		 mli.score1=mp.score1;                                             //��һ�ڱȷ�
		 mli.score2=mp.score2;                                             //�ڶ��ڱȷ�
		 mli.score3=mp.score3;                                             //�����ڱȷ�
		 mli.score4=mp.score4;                                             //���Ľڱȷ�
		 mli.scoreExtra=mp.scoreExtra;                                     //��ʱ���ȷ�
		 mli.playerStatistic=mp.playerStatistic;                           //��Ա����ͳ��
		 mli.scoringChampion=mp.scoringChampion;                           //�÷���
		 mli.reboundChampion=mp.reboundChampion;                           //������
		 mli.assistChampion=mp.assistChampion;                             //������
		 mli.ifHomeTeamWin=mp.ifHomeTeamWin;                               //�����Ƿ�ʤ��
		 mli.ifGuestTeamWin=mp.ifGuestTeamWin;                             //�Ͷ��Ƿ�ʤ��
		 mli.homeTeamDeffensiveRebound=mp.homeTeamDeffensiveRebound;       //���ӷ�������
		 mli.guestTeamDeffensiveRebound=mp.guestTeamDeffensiveRebound;     //�Ͷӷ�������
		 mli.homeTeamOffensiveRebound=mp.homeTeamOffensiveRebound;         //���ӽ�������
		 mli.guestTeamOffensiveRebound=mp.guestTeamOffensiveRebound;       //�Ͷӽ�������
		 mli.homeTeamOffensiveRound=mp.homeTeamOffensiveRound;             //���ӽ����غ�
		 mli.guestTeamOffensiveRound=mp.guestTeamOffensiveRound;           //�Ͷӽ����غ�
		 mli.homeScore=mp.homeScore;                                       //���ӵ÷�
		 mli.guestScore=mp.guestScore;                                     //�Ͷӵ÷�
		 mli.homeAllTime=mp.homeAllTime;                                   //����ȫԱ�ϳ�ʱ��
		 mli.guestAllTime=mp.guestAllTime;                                 //�Ͷ�ȫԱ�ϳ�ʱ��
		 mli.homeShotIn=mp.homeShotIn;                                     //�����ܽ�����
		 mli.guestShotIn=mp.guestShotIn;                                   //�Ͷ��ܽ�����
		 mli.homeShot=mp.homeShot;                                         //���ӳ��ִ���
		 mli.guestShot=mp.guestShot;                                       //�Ͷӳ��ִ���
		 mli.homeTwoShot=mp.homeTwoShot;                                   //�������ֳ��ִ���
		 mli.guestTwoShot=mp.guestTwoShot;                                 //�Ͷ����ֳ��ִ���
		 mli.homeTwoShotIn=mp.homeTwoShotIn;                               //�������ֽ�����
		 mli.guestTwoShotIn=mp.guestTwoShotIn;                             //�Ͷ����ֽ�����
		 mli.homeThreeShot=mp.homeThreeShot;                               //�������ֳ��ִ���
		 mli.guestThreeShot=mp.guestThreeShot;                             //�Ͷ����ֳ��ִ���
		 mli.homeThreeShotIn=mp.homeThreeShotIn;                           //�������ֽ�����
		 mli.guestThreeShotIn=mp.guestThreeShotIn;                         //�Ͷ����ֽ�����
		 mli.homePenaltyShot=mp.homePenaltyShot;                           //���ӷ������
		 mli.guestPenaltyShot=mp.guestPenaltyShot;                         //�Ͷӷ������
		 mli.homePenaltyShotIn=mp.homePenaltyShotIn;                       //���ӷ��������
		 mli.guestPenaltyShotIn=mp.guestPenaltyShotIn;                     //�Ͷӷ��������
		 mli.homeFault=mp.homeFault;                                         //����ʧ�����
		 mli.guestFault=mp.guestFault;                                       //�Ͷ�ʧ�����

		
		return mli;
		
	}

}
