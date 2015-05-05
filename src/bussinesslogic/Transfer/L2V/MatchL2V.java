package bussinesslogic.Transfer.L2V;

import bussinesslogic.matchbl.MatchLineItem;
import VO.MatchVO;

public class MatchL2V {

	public MatchVO l2v(MatchLineItem mli){
		MatchVO mv=new MatchVO();
		 mv.season=mli.season;                                             //����
		 mv.date=mli.date;                                                 //����
		 mv.homeTeam=mli.homeTeam;                                         //��������
		 mv.guestTeam=mli.guestTeam;                                       //�ͳ�����
		 mv.score=mli.score;                                               //�ȷ�
		 mv.score1=mli.score1;                                             //��һ�ڱȷ�
		 mv.score2=mli.score2;                                             //�ڶ��ڱȷ�
		 mv.score3=mli.score3;                                             //�����ڱȷ�
		 mv.score4=mli.score4;                                             //���Ľڱȷ�
		 mv.scoreExtra=mli.scoreExtra;                                     //��ʱ���ȷ�
		 mv.playerStatistic=mli.playerStatistic;                           //��Ա����ͳ��
		 mv.scoringChampion=mli.scoringChampion;                           //�÷���
		 mv.reboundChampion=mli.reboundChampion;                           //������
		 mv.assistChampion=mli.assistChampion;                             //������
		 mv.ifHomeTeamWin=mli.ifHomeTeamWin;                               //�����Ƿ�ʤ��
		 mv.ifGuestTeamWin=mli.ifGuestTeamWin;                             //�Ͷ��Ƿ�ʤ��
		 mv.homeTeamDeffensiveRebound=mli.homeTeamDeffensiveRebound;       //���ӷ�������
		 mv.guestTeamDeffensiveRebound=mli.guestTeamDeffensiveRebound;     //�Ͷӷ�������
		 mv.homeTeamOffensiveRebound=mli.homeTeamOffensiveRebound;         //���ӽ�������
		 mv.guestTeamOffensiveRebound=mli.guestTeamOffensiveRebound;       //�Ͷӽ�������
		 mv.homeTeamOffensiveRound=mli.homeTeamOffensiveRound;             //���ӽ����غ�
		 mv.guestTeamOffensiveRound=mli.guestTeamOffensiveRound;           //�Ͷӽ����غ�
		 mv.homeScore=mli.homeScore;                                       //���ӵ÷�
		 mv.guestScore=mli.guestScore;                                     //�Ͷӵ÷�
		 mv.homeAllTime=mli.homeAllTime;                                   //����ȫԱ�ϳ�ʱ��
		 mv.guestAllTime=mli.guestAllTime;                                 //�Ͷ�ȫԱ�ϳ�ʱ��
		 mv.homeShotIn=mli.homeShotIn;                                     //�����ܽ�����
		 mv.guestShotIn=mli.guestShotIn;                                   //�Ͷ��ܽ�����
		 mv.homeShot=mli.homeShot;                                         //���ӳ��ִ���
		 mv.guestShot=mli.guestShot;                                       //�Ͷӳ��ִ���
		 mv.homeTwoShot=mli.homeTwoShot;                                   //�������ֳ��ִ���
		 mv.guestTwoShot=mli.guestTwoShot;                                 //�Ͷ����ֳ��ִ���
		 mv.homeTwoShotIn=mli.homeTwoShotIn;                               //�������ֽ�����
		 mv.guestTwoShotIn=mli.guestTwoShotIn;                             //�Ͷ����ֽ�����
		 mv.homeThreeShot=mli.homeThreeShot;                               //�������ֳ��ִ���
		 mv.guestThreeShot=mli.guestThreeShot;                             //�Ͷ����ֳ��ִ���
		 mv.homeThreeShotIn=mli.homeThreeShotIn;                           //�������ֽ�����
		 mv.guestThreeShotIn=mli.guestThreeShotIn;                         //�Ͷ����ֽ�����
		 mv.homePenaltyShot=mli.homePenaltyShot;                           //���ӷ������
		 mv.guestPenaltyShot=mli.guestPenaltyShot;                         //�Ͷӷ������
		 mv.homePenaltyShotIn=mli.homePenaltyShotIn;                       //���ӷ��������
		 mv.guestPenaltyShotIn=mli.guestPenaltyShotIn;                     //�Ͷӷ��������
		 mv.homeFault=mli.homeFault;                                         //����ʧ�����
		 mv.guestFault=mli.guestFault;                                       //�Ͷ�ʧ�����

		
		return mv;
		
	}

}




