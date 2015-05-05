package PO;
import java.io.Serializable;


public class PlayerTechPO implements Serializable{
	/**
	 * ������Ա������
	 */
	public static final long serialVersionUID = 1L;
	public String name;                            //��Ա����
	public String season;                          //����
	public String team;                            //�������
	
	//���ݳ����������
	public String position;                     //位置
    public String division;                     //分区
	public int gameNum;                         //��������
	public int startingNum;                     //�ȷ�����
	public int rebound;                         //������
	public int secondaryAttack;                 //������
	public int time;                            //�ڳ�ʱ��
	public int offensiveNum;                    //������
	public int defensiveNum;                    //������
	public int steal;                           //������
	public int blockShot;                       //��ñ��
	public int fault;                           //ʧ����
	public int foul;                            //������
	public int score;                           //�÷�
	public int shotIn;                       //Ͷ��������
	public int shot;                         //Ͷ��������
	public int threeShotIn;                  //����������
	public int threeShot;                    //���ֳ�����
	public int penaltyShotIn;                //����������
	public int penaltyShot;                  //���������
	
	//���ݹ�ʽ����
	public double shotInRate;                      //Ͷ��������
	public double threeShotInRate;                 //����������
	public double penaltyShotInRate;               //����������
	public double efficiency;                        //Ч��
	public double GmScEfficiency;                    //GmScЧ��ֵ
	public double trueShotInRate;                  //��ʵ������
	public double shootingEfficiency;                //Ͷ��Ч��
	public double reboundRate;                     //������
	public double offensiveReboundRate;            //����������
	public double defensiveReboundRate;            //����������
	public double secondaryAttackRate;             //������
	public double stealRate;                       //������
	public double blockShotRate;                   //��ñ��
	public double faultRate;                       //ʧ����	
	public double usageRate;                       //ʹ����
	
	public int teamAllTime;                  //ȫ���ϳ�ʱ��
	public int teamOffensiveRebound;                  //ȫ�ӽ�������
	public int teamDefensiveRebound;                //ȫ�ӷ�������
	public int opponentOffensiveRebound;                  //���ֽ�������
	public int opponentDefensiveRebound;                //���ַ�������
	public int teamShotIn;                             //ȫ�ӽ�����
	public double opponentOffensiveNum;                     //���ֽ�������
	public int opponentTwoShot;                     //���ֽ�����������ִ���
	public int teamShot;                          //ȫ�ӳ��ִ���
	public int teamPenaltyShot;                   //ȫ�ӷ������
	public int teamFault;                          //ȫ��ʧ�����    
	public int ifDouble;
	//����Ϊ������
		public double scoreImproving;
		public double stealImproving;
		public double blockShotImproving;
		public double secondaryAttackImproving;
		public double reboundImproving;
	
	public boolean equals(PlayerTechPO ptpo){
		if(!this.name.equals(ptpo.name)){
			System.out.println("name");
			return false;
		}
		if(!this.season.equals(ptpo.season)){
			System.out.println("season");
			return false;
		}
		if(!this.team.equals(ptpo.team)){
			System.out.println("team");
			return false;
		}
		if(this.gameNum!=ptpo.gameNum){
			System.out.println("gameNum");
			return false;
		}
		if(this.startingNum!=ptpo.startingNum){
			System.out.println("startingNum");
			return false;
		}
		if(this.shotInRate!=ptpo.shotInRate){
			System.out.println("shotInRate");
			return false;
		}
		if(this.threeShotInRate!=ptpo.threeShotInRate){
			System.out.println("threeShotInRate");
			return false;
		}
		if(this.penaltyShotInRate!=ptpo.penaltyShotInRate){
			System.out.println("penaltyShotInRate");
			return false;
		}
		if(this.efficiency!=ptpo.efficiency){
			System.out.println("efficiency");
			return false;
		}
		if(this.GmScEfficiency!=ptpo.GmScEfficiency){
			System.out.println("GmScEfficiency");
			return false;
		}
		if(this.trueShotInRate!=ptpo.trueShotInRate){
			System.out.println("trueShotInRate");
			return false;
		}
		if(this.shootingEfficiency!=ptpo.shootingEfficiency){
			System.out.println("shootingEfficiency");
			return false;
		}
		if(this.reboundRate!=ptpo.reboundRate){
			System.out.println("reboundRate");
			return false;
		}
		if(this.offensiveReboundRate!=ptpo.offensiveReboundRate){
			System.out.println("offensiveReboundRate");
			return false;
		}
		if(this.defensiveReboundRate!=ptpo.defensiveReboundRate){
			System.out.println("defensiveReboundRate");
			return false;
		}
		if(this.secondaryAttackRate!=ptpo.secondaryAttackRate){
			System.out.println("secondaryAttackRate");
			return false;
		}
		if(this.stealRate!=ptpo.stealRate){
			System.out.println("stealRate");
			return false;
		}
		if(this.blockShotRate!=ptpo.blockShotRate){
			System.out.println("blockShotRate");
			return false;
		}
		if(this.faultRate!=ptpo.faultRate){
			System.out.println("faultRate");
			return false;
		}
		if(this.usageRate!=ptpo.usageRate){
			System.out.println("usageRate");
			return false;
		}
		if(this.offensiveNum!=ptpo.offensiveNum){
			System.out.println("offensiveNum");
			return false;
		}
		if(this.defensiveNum!=ptpo.defensiveNum){
			System.out.println("defensiveNum");
			return false;
		}
		if(this.steal!=ptpo.steal){
			System.out.println("steal");
			return false;
		}
		if(this.blockShot!=ptpo.blockShot){
			System.out.println("blockShot");
			return false;
		}
		if(this.fault!=ptpo.fault){
			System.out.println("fault");
			return false;
		}
		if(this.foul!=ptpo.foul){
			System.out.println("foul");
			return false;
		}
		if(this.score!=ptpo.score){
			System.out.println("score");
			return false;
		}
		if(this.rebound!=ptpo.rebound){
			System.out.println("rebound");
			return false;
		}
		if(this.secondaryAttack!=ptpo.secondaryAttack){
			System.out.println("secondaryAttack");
			return false;
		}
		if(this.time!=ptpo.time){
			System.out.println("time");
			return false;
		}
		return true;
	}
}