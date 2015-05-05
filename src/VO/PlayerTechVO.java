package VO;

public class PlayerTechVO {
	public String name;                            //��Ա����
	public String season;                          //����
	public String team;                            //�������
	public String position;                     //位置
    public String division;                     //分区
	public int gameNum;                         //��������
	public int startingNum;                     //�ȷ�����
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
	
	//����������������
	
	public int offensiveNum;                    //������
	public int defensiveNum;                    //������
	public int steal;                           //������
	public int blockShot;                       //��ñ��
	public int fault;                           //ʧ����
	public int foul;                            //������
	public int score;                           //�÷�
	public int rebound;                         //������
	public int secondaryAttack;                 //������
	public int time;                            //�ڳ�ʱ��
	
	//�����ǳ�������
	
	public double offensiveNumave;                    //������
	public double defensiveNumave;                    //������
	public double stealave;                           //������
	public double blockShotave;                       //��ñ��
	public double faultave;                           //ʧ����
	public double foulave;                            //������
	public double scoreave;                           //�÷�
	public double reboundave;                         //������
	public double secondaryAttackave;                 //������
	public double timeave;                            //�ڳ�ʱ��
	
	//����Ϊ������
	public double scoreImproving;
	public double stealImproving;
	public double blockShotImproving;
	public double secondaryAttackImproving;
	public double reboundImproving;
	public int ifDouble;

	public boolean equals(PlayerTechVO ptvo){
		if(!this.name.equals(ptvo.name)){
			System.out.println("name");
			return false;
		}
		if(!this.season.equals(ptvo.season)){
			System.out.println("season");
			return false;
		}
		if(!this.team.equals(ptvo.team)){
			System.out.println("team");
			return false;
		}
		if(this.gameNum!=ptvo.gameNum){
			System.out.println("gameNum");
			return false;
		}
		if(this.startingNum!=ptvo.startingNum){
			System.out.println("startingNum");
			return false;
		}
		if(this.shotInRate!=ptvo.shotInRate){
			System.out.println("shotInRate");
			return false;
		}
		if(this.threeShotInRate!=ptvo.threeShotInRate){
			System.out.println("threeShotInRate");
			return false;
		}
		if(this.penaltyShotInRate!=ptvo.penaltyShotInRate){
			System.out.println("penaltyShotInRate");
			return false;
		}
		if(this.efficiency!=ptvo.efficiency){
			System.out.println("efficiency");
			return false;
		}
		if(this.GmScEfficiency!=ptvo.GmScEfficiency){
			System.out.println("GmScEfficiency");
			return false;
		}
		if(this.trueShotInRate!=ptvo.trueShotInRate){
			System.out.println("trueShotInRate");
			return false;
		}
		if(this.shootingEfficiency!=ptvo.shootingEfficiency){
			System.out.println("shootingEfficiency");
			return false;
		}
		if(this.reboundRate!=ptvo.reboundRate){
			System.out.println("reboundRate");
			return false;
		}
		if(this.offensiveReboundRate!=ptvo.offensiveReboundRate){
			System.out.println("offensiveReboundRate");
			return false;
		}
		if(this.defensiveReboundRate!=ptvo.defensiveReboundRate){
			System.out.println("defensiveReboundRate");
			return false;
		}
		if(this.secondaryAttackRate!=ptvo.secondaryAttackRate){
			System.out.println("secondaryAttackRate");
			return false;
		}
		if(this.stealRate!=ptvo.stealRate){
			System.out.println("stealRate");
			return false;
		}
		if(this.blockShotRate!=ptvo.blockShotRate){
			System.out.println("blockShotRate");
			return false;
		}
		if(this.faultRate!=ptvo.faultRate){
			System.out.println("faultRate");
			return false;
		}
		if(this.usageRate!=ptvo.usageRate){
			System.out.println("usageRate");
			return false;
		}
		if(this.offensiveNum!=ptvo.offensiveNum){
			System.out.println("offensiveNum");
			return false;
		}
		if(this.defensiveNum!=ptvo.defensiveNum){
			System.out.println("defensiveNum");
			return false;
		}
		if(this.steal!=ptvo.steal){
			System.out.println("steal");
			return false;
		}
		if(this.blockShot!=ptvo.blockShot){
			System.out.println("blockShot");
			return false;
		}
		if(this.fault!=ptvo.fault){
			System.out.println("fault");
			return false;
		}
		if(this.foul!=ptvo.foul){
			System.out.println("foul");
			return false;
		}
		if(this.score!=ptvo.score){
			System.out.println("score");
			return false;
		}
		if(this.rebound!=ptvo.rebound){
			System.out.println("rebound");
			return false;
		}
		if(this.secondaryAttack!=ptvo.secondaryAttack){
			System.out.println("secondaryAttack");
			return false;
		}
		if(this.time!=ptvo.time){
			System.out.println("time");
			return false;
		}
		if(this.offensiveNumave!=ptvo.offensiveNumave){
			System.out.println("offensiveNumave");
			return false;
		}
		if(this.defensiveNumave!=ptvo.defensiveNumave){
			System.out.println("defensiveNumave");
			return false;
		}
		if(this.stealave!=ptvo.stealave){
			System.out.println("stealave");
			return false;
		}
		if(this.blockShotave!=ptvo.blockShotave){
			System.out.println("blockShotave");
			return false;
		}
		if(this.faultave!=ptvo.faultave){
			System.out.println("faultave");
			return false;
		}
		if(this.foulave!=ptvo.foulave){
			System.out.println("foulave");
			return false;
		}
		if(this.scoreave!=ptvo.scoreave){
			System.out.println("scoreave");
			return false;
		}
		if(this.reboundave!=ptvo.reboundave){
			System.out.println("reboundave");
			return false;
		}
		if(this.secondaryAttackave!=ptvo.secondaryAttackave){
			System.out.println("secondaryAttackave");
			return false;
		}
		if(this.timeave!=ptvo.timeave){
			System.out.println("timeave");
			return false;
		}
		return true;
	}
}
