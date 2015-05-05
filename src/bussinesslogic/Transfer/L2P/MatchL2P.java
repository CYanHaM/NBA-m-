package bussinesslogic.Transfer.L2P;

import bussinesslogic.matchbl.MatchLineItem;
import PO.MatchPO;

public class MatchL2P {
	public MatchPO l2p(MatchLineItem mli){
		MatchPO mp=new MatchPO();
		 mp.season=mli.season;                                             //����
		 mp.date=mli.date;                                                 //����
		 mp.homeTeam=mli.homeTeam;                                         //��������
		 mp.guestTeam=mli.guestTeam;                                       //�ͳ�����
		 mp.score=mli.score;                                               //�ȷ�
		 mp.score1=mli.score1;                                             //��һ�ڱȷ�
		 mp.score2=mli.score2;                                             //�ڶ��ڱȷ�
		 mp.score3=mli.score3;                                             //�����ڱȷ�
		 mp.score4=mli.score4;                                             //���Ľڱȷ�
		 mp.scoreExtra=mli.scoreExtra;                                     //��ʱ���ȷ�
		 mp.playerStatistic=mli.playerStatistic;                           //��Ա����ͳ��
		 mp.scoringChampion=mli.scoringChampion;                           //�÷���
		 mp.reboundChampion=mli.reboundChampion;                           //������
		 mp.assistChampion=mli.assistChampion;                             //������
		 mp.ifHomeTeamWin=mli.ifHomeTeamWin;                               //�����Ƿ�ʤ��
		 mp.ifGuestTeamWin=mli.ifGuestTeamWin;                             //�Ͷ��Ƿ�ʤ��
		 mp.homeTeamDeffensiveRebound=mli.homeTeamDeffensiveRebound;       //���ӷ�������
		 mp.guestTeamDeffensiveRebound=mli.guestTeamDeffensiveRebound;     //�Ͷӷ�������
		 mp.homeTeamOffensiveRebound=mli.homeTeamOffensiveRebound;         //���ӽ�������
		 mp.guestTeamOffensiveRebound=mli.guestTeamOffensiveRebound;       //�Ͷӽ�������
		 mp.homeTeamOffensiveRound=mli.homeTeamOffensiveRound;             //���ӽ����غ�
		 mp.guestTeamOffensiveRound=mli.guestTeamOffensiveRound;           //�Ͷӽ����غ�
		 mp.homeScore=mli.homeScore;                                       //���ӵ÷�
		 mp.guestScore=mli.guestScore;                                     //�Ͷӵ÷�
		 mp.homeAllTime=mli.homeAllTime;                                   //����ȫԱ�ϳ�ʱ��
		 mp.guestAllTime=mli.guestAllTime;                                 //�Ͷ�ȫԱ�ϳ�ʱ��
		 mp.homeShotIn=mli.homeShotIn;                                     //�����ܽ�����
		 mp.guestShotIn=mli.guestShotIn;                                   //�Ͷ��ܽ�����
		 mp.homeShot=mli.homeShot;                                         //���ӳ��ִ���
		 mp.guestShot=mli.guestShot;                                       //�Ͷӳ��ִ���
		 mp.homeTwoShot=mli.homeTwoShot;                                   //�������ֳ��ִ���
		 mp.guestTwoShot=mli.guestTwoShot;                                 //�Ͷ����ֳ��ִ���
		 mp.homeTwoShotIn=mli.homeTwoShotIn;                               //�������ֽ�����
		 mp.guestTwoShotIn=mli.guestTwoShotIn;                             //�Ͷ����ֽ�����
		 mp.homeThreeShot=mli.homeThreeShot;                               //�������ֳ��ִ���
		 mp.guestThreeShot=mli.guestThreeShot;                             //�Ͷ����ֳ��ִ���
		 mp.homeThreeShotIn=mli.homeThreeShotIn;                           //�������ֽ�����
		 mp.guestThreeShotIn=mli.guestThreeShotIn;                         //�Ͷ����ֽ�����
		 mp.homePenaltyShot=mli.homePenaltyShot;                           //���ӷ������
		 mp.guestPenaltyShot=mli.guestPenaltyShot;                         //�Ͷӷ������
		 mp.homePenaltyShotIn=mli.homePenaltyShotIn;                       //���ӷ��������
		 mp.guestPenaltyShotIn=mli.guestPenaltyShotIn;                     //�Ͷӷ��������
		 mp.homeFault=mli.homeFault;                                         //����ʧ�����
		 mp.guestFault=mli.guestFault;                                       //�Ͷ�ʧ�����

		
		return mp;
		
	}

}
