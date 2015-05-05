package VO;
import java.io.Serializable;

public class PlayerTechMVO implements Serializable {
		/**
		 *ÿ��������Ա����ͳ�� 
		 */
		private static final long serialVersionUID = 1L;
		
		public String name;                         //����
		public String team;                         //����
		public String date;
		public String position;                     //λ��
		public String division;                     //分区
		public int time;                         //�ڳ�ʱ��
		public int shotIn;                       //Ͷ��������
		public int shot;                         //Ͷ��������
		public int threeShotIn;                  //����������
		public int threeShot;                    //���ֳ�����
		public int penaltyShotIn;                //����������
		public int penaltyShot;                  //���������
		public int offensiveRebound;             //ǰ��������
		public int defensiveRebound;             //��������
		public int rebound;                      //��������
		public int secondaryAttack;              //������
		public int steal;                        //������
		public int blockShot;                    //��ñ��
		public int fault;                        //ʧ����
		public int foul;                         //������
		public int score;                        //���˵÷�
		public int ifFirstLineUp;                 //�Ƿ��ȷ�
		public int ifParticipate;                 //�Ƿ����
		
		//�������������
		public int teamAllTime;                  //ȫ���ϳ�ʱ��
		public int teamOffensiveRebound;                  //ȫ�ӽ�������
		public int teamDefensiveRebound;                //ȫ�ӷ�������
		public int opponentOffensiveRebound;                  //���ֽ�������
		public int opponentDefensiveRebound;                //���ַ�������
		public int teamShotIn;                             //ȫ�ӽ�����
		public int opponentOffensiveNum;                     //���ֽ�������
		public int opponentTwoShot;                     //���ֽ�����������ִ���
		public int teamShot;                          //ȫ�ӳ��ִ���
		public int teamPenaltyShot;                   //ȫ�ӷ������
		public int teamFault;                          //ȫ��ʧ�����  
		public int ifDouble;
		public int scoreRatio;
		public double efficiency;
		
		public double scoreImproving;
		public double stealImproving;
		public double blockShotImproving;
		public double secondaryAttackImproving;
		public double reboundImproving;

}
