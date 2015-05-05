package PO;
import java.io.Serializable;


public class TeamTechPO implements Serializable {
	
	/**
	 * 赛季球队总数据
	 */
	public static final long serialVersionUID = 1L;
	public int index ;                             //编号
	public String name;                            //球队名称
	public String season;                          //赛季
	public int gameNum;                         //比赛场数
	public int shotInNum;                       //投篮命中数
	public int shotNum;                         //投篮出手数
	public int threeShotInNum;                  //三分命中数
	public int threeShotNum;                    //三分出手数
	public int penaltyShotInNum;                //罚球命中数
	public int penaltyShotNum;                  //罚球出手数
	public int offensiveRebound;                //前场篮板数
	public int defensiveRebound;                //后场篮板数
	public int rebound;                         //总篮板数
	public int secondaryAttack;                 //助攻数
	public int steal;                           //抢断数
	public int blockShot;                       //盖帽数
	public int fault;                           //失误数
	public int foul;                            //犯规数
	public int score;                           //比赛得分
	public double shotInRate;                      //投篮命中率
	public double threeShotInRate;                 //三分命中率
	public double penaltyShotInRate;               //罚球命中率
	public double winningRate;                     //胜率
	public int winningNum;                         //胜场数
	public double offensiveRound;                  //进攻回合
	public double offensiveEfficiency;               //进攻效率
	public double defensiveEfficiency;               //防守效率
	public double reboundEfficiency;                 //篮板效率
	public double stealEfficiency;                   //抢断效率
	public double secondaryAttackEfficiency;         //助攻效率
	public int opponentDefensiveRebound;          //对方防守篮板
	public int opponentOffensiveRebound;          //对方进攻篮板
	public double opponentOffensiveRound;        //对方进攻回合
	public int opponentScore;        //对方得分


	public boolean equals(TeamTechPO ttpo){
		if(!this.name.equals(ttpo.name)){
			System.out.println("name");
			return false;
		}
	    if(!this.season.equals(ttpo.season)){
	    	System.out.println("season");
	    	return false;
	    }
	    if(this.gameNum!=ttpo.gameNum){
	    	System.out.println("gameNum");
	    	return false;
	    }
	    if(this.shotInRate!=ttpo.shotInRate){
	    	System.out.println("shotInRate");
	    	return false;
	    }
	    if(this.threeShotInRate!=ttpo.threeShotInRate){
	    	System.out.println("threeShotInRate");
	    	return false;
	    }
	    if(this.penaltyShotInRate!=ttpo.penaltyShotInRate){
	    	System.out.println("penaltyShotInRate");
	    	return false;
	    }
	    if(this.winningRate!=ttpo.winningRate){
	    	System.out.println("winningRate");
	    	return false;
	    }
	    if(this.offensiveEfficiency!=ttpo.offensiveEfficiency){
	    	System.out.println("offensiveEfficiency");
	    	return false;
	    }
	    if(this.defensiveEfficiency!=ttpo.defensiveEfficiency){
	    	System.out.println("defensiveEfficiency");
	    	return false;
	    }
	    if(this.reboundEfficiency!=ttpo.reboundEfficiency){
	    	System.out.println("reboundEfficiency");
	    	return false;
	    }
	    if(this.stealEfficiency!=ttpo.stealEfficiency){
	    	System.out.println("stealEfficiency");
	    	return false;
	    }
	    if(this.secondaryAttackEfficiency!=ttpo.secondaryAttackEfficiency){
	    	System.out.println("secondaryAttackEfficiency");
	    	return false;
	    }
	    if(this.winningNum!=ttpo.winningNum){
	    	System.out.println("winningNum");
	    	return false;
	    }
	    if(this.shotInNum!=ttpo.shotInNum){
	    	System.out.println("shotInNum");
	    	return false;
	    }
	    if(this.shotNum!=ttpo.shotNum){
	    	System.out.println("shotNum");
	    	return false;
	    }
	    if(this.threeShotInNum!=ttpo.threeShotInNum){
	    	System.out.println("threeShotInNum");
	    	return false;
	    }
	    if(this.threeShotNum!=ttpo.threeShotNum){
	    	System.out.println("threeShotNum");
	    	return false;
	    }
	    if(this.penaltyShotInNum!=ttpo.penaltyShotInNum){
	    	System.out.println("penaltyShotInNum");
	    	return false;
	    }
	    if(this.penaltyShotNum!=ttpo.penaltyShotNum){
	    	System.out.println("penaltyShotNum");
	    	return false;
	    }
	    if(this.offensiveRebound!=ttpo.offensiveRebound){
	    	System.out.println("offensiveRebound");
	    	return false;
	    }
	    if(this.defensiveRebound!=ttpo.defensiveRebound){
	    	System.out.println("defensiveRebound");
	    	return false;
	    }
	    if(this.rebound!=ttpo.rebound){
	    	System.out.println("rebound");
	    	return false;
	    }
	    if(this.secondaryAttack!=ttpo.secondaryAttack){
	    	System.out.println("TeamTech");
	    	System.out.println("secondaryAttack");
	    	return false;
	    }
	    if(this.steal!=ttpo.steal){
	    	System.out.println("steal");
	    	return false;
	    }
	    if(this.blockShot!=ttpo.blockShot){
	    	System.out.println("blockShot");
	    	return false;
	    }
	    if(this.fault!=ttpo.fault){
	    	System.out.println("fault");
	    	return false;
	    }
	    if(this.foul!=ttpo.foul){
	    	System.out.println("foul");
	    	return false;
	    }
	    if(this.score!=ttpo.score){
	    	System.out.println("score");
	    	return false;
	    }
	    if(this.offensiveRound!=ttpo.offensiveRound){
	    	System.out.println("offensiveRound");
	    	return false;
	    }
	    return true;
	}
	
}
