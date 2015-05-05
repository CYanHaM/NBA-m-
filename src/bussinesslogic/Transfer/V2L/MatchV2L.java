package bussinesslogic.Transfer.V2L;

import VO.MatchVO;
import bussinesslogic.matchbl.MatchLineItem;

public class MatchV2L {

	public MatchLineItem v2l(MatchVO mv){
		MatchLineItem mli=new MatchLineItem();
		 mli.season=mv.season;                                             //����
		 mli.date=mv.date;                                                 //����
		 mli.homeTeam=mv.homeTeam;                                         //��������
		 mli.guestTeam=mv.guestTeam;                                       //�ͳ�����
		 mli.score=mv.score;                                               //�ȷ�
		 mli.score1=mv.score1;                                             //��һ�ڱȷ�
		 mli.score2=mv.score2;                                             //�ڶ��ڱȷ�
		 mli.score3=mv.score3;                                             //�����ڱȷ�
		 mli.score4=mv.score4;                                             //���Ľڱȷ�
		 mli.scoreExtra=mv.scoreExtra;                                     //��ʱ���ȷ�
		 mli.playerStatistic=mv.playerStatistic;                           //��Ա����ͳ��
		 mli.scoringChampion=mv.scoringChampion;                           //�÷���
		 mli.reboundChampion=mv.reboundChampion;                           //������
		 mli.assistChampion=mv.assistChampion;                             //������
		 mli.ifHomeTeamWin=mv.ifHomeTeamWin;                               //�����Ƿ�ʤ��
		 mli.ifGuestTeamWin=mv.ifGuestTeamWin;                             //�Ͷ��Ƿ�ʤ��
		 mli.homeTeamDeffensiveRebound=mv.homeTeamDeffensiveRebound;       //���ӷ�������
		 mli.guestTeamDeffensiveRebound=mv.guestTeamDeffensiveRebound;     //�Ͷӷ�������
		 mli.homeTeamOffensiveRebound=mv.homeTeamOffensiveRebound;         //���ӽ�������
		 mli.guestTeamOffensiveRebound=mv.guestTeamOffensiveRebound;       //�Ͷӽ�������
		 mli.homeTeamOffensiveRound=mv.homeTeamOffensiveRound;             //���ӽ����غ�
		 mli.guestTeamOffensiveRound=mv.guestTeamOffensiveRound;           //�Ͷӽ����غ�
		 mli.homeScore=mv.homeScore;                                       //���ӵ÷�
		 mli.guestScore=mv.guestScore;                                     //�Ͷӵ÷�
		 mli.homeAllTime=mv.homeAllTime;                                   //����ȫԱ�ϳ�ʱ��
		 mli.guestAllTime=mv.guestAllTime;                                 //�Ͷ�ȫԱ�ϳ�ʱ��
		 mli.homeShotIn=mv.homeShotIn;                                     //�����ܽ�����
		 mli.guestShotIn=mv.guestShotIn;                                   //�Ͷ��ܽ�����
		 mli.homeShot=mv.homeShot;                                         //���ӳ��ִ���
		 mli.guestShot=mv.guestShot;                                       //�Ͷӳ��ִ���
		 mli.homeTwoShot=mv.homeTwoShot;                                   //�������ֳ��ִ���
		 mli.guestTwoShot=mv.guestTwoShot;                                 //�Ͷ����ֳ��ִ���
		 mli.homeTwoShotIn=mv.homeTwoShotIn;                               //�������ֽ�����
		 mli.guestTwoShotIn=mv.guestTwoShotIn;                             //�Ͷ����ֽ�����
		 mli.homeThreeShot=mv.homeThreeShot;                               //�������ֳ��ִ���
		 mli.guestThreeShot=mv.guestThreeShot;                             //�Ͷ����ֳ��ִ���
		 mli.homeThreeShotIn=mv.homeThreeShotIn;                           //�������ֽ�����
		 mli.guestThreeShotIn=mv.guestThreeShotIn;                         //�Ͷ����ֽ�����
		 mli.homePenaltyShot=mv.homePenaltyShot;                           //���ӷ������
		 mli.guestPenaltyShot=mv.guestPenaltyShot;                         //�Ͷӷ������
		 mli.homePenaltyShotIn=mv.homePenaltyShotIn;                       //���ӷ��������
		 mli.guestPenaltyShotIn=mv.guestPenaltyShotIn;                     //�Ͷӷ��������
		 mli.homeFault=mv.homeFault;                                         //����ʧ�����
		 mli.guestFault=mv.guestFault;                                       //�Ͷ�ʧ�����

		
		return mli;
		
	}

}
