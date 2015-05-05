package bussinesslogic.TeamTech;

public class TeamTechLineItem {
	public String name;                            //球队名称
	public String season;                          //赛季
	public int gameNum;                         //比赛场数
	public double shotInRate;                      //投篮命中率
	public double threeShotInRate;                 //三分命中率
	public double penaltyShotInRate;               //罚球命中率
	public double winningRate;                     //胜率
	public double offensiveEfficiency;               //进攻效率
	public double defensiveEfficiency;               //防守效率
	public double reboundEfficiency;                 //篮板效率
	public double stealEfficiency;                   //抢断效率
	public double secondaryAttackEfficiency;         //助攻效率
	public int winningNum;                      //胜场数
	
	//以下是总数据
	
	public int shotInNum;                       //投篮命中数
	public int shotNum;                         //投篮出手数
	public int threeShotInNum;                  //三分命中数
	public int threeShotNum;                    //三分出手数
	public int penaltyShotInNum;                //罚球命中数
	public int penaltyShotNum;                  //发球出手数
	public int offensiveRebound;                //前场篮板数
	public int defensiveRebound;                //后场篮板数
	public int rebound;                         //总篮板数
	public int secondaryAttack;                 //助攻数
	public int steal;                           //抢断数
	public int blockShot;                       //盖帽数
	public int fault;                           //失误数
	public int foul;                            //犯规数
	public int score;                           //比赛得分
	public double offensiveRound;                  //进攻回合
	
	//以下是场均数据
	
	public double shotInNumave;                       //投篮命中数
	public double shotNumave;                         //投篮出手数
	public double threeShotInNumave;                  //三分命中数
	public double threeShotNumave;                    //三分出手数
	public double penaltyShotInNumave;                //罚球命中数
	public double penaltyShotNumave;                  //发球出手数
	public double offensiveReboundave;                //前场篮板数
	public double defensiveReboundave;                //后场篮板数
	public double reboundave;                         //总篮板数
	public double secondaryAttackave;                 //助攻数
	public double stealave;                           //抢断数
	public double blockShotave;                       //盖帽数
	public double faultave;                           //失误数
	public double foulave;                            //犯规数
	public double scoreave;                           //比赛得分
	public double offensiveRoundave;                  //进攻回合
	
	public boolean equals(TeamTechLineItem ttli){
		if(!this.name.equals(ttli.name)){
			System.out.println("name");
			return false;
		}
	    if(!this.season.equals(ttli.season)){
	    	System.out.println("season");
	    	return false;
	    }
	    if(this.gameNum!=ttli.gameNum){
	    	System.out.println("gameNum");
	    	return false;
	    }
	    if(this.shotInRate!=ttli.shotInRate){
	    	System.out.println("shotInRate");
	    	return false;
	    }
	    if(this.threeShotInRate!=ttli.threeShotInRate){
	    	System.out.println("threeShotInRate");
	    	return false;
	    }
	    if(this.penaltyShotInRate!=ttli.penaltyShotInRate){
	    	System.out.println("penaltyShotInRate");
	    	return false;
	    }
	    if(this.winningRate!=ttli.winningRate){
	    	System.out.println("winningRate");
	    	return false;
	    }
	    if(this.offensiveEfficiency!=ttli.offensiveEfficiency){
	    	System.out.println("offensiveEfficiency");
	    	return false;
	    }
	    if(this.defensiveEfficiency!=ttli.defensiveEfficiency){
	    	System.out.println("defensiveEfficiency");
	    	return false;
	    }
	    if(this.reboundEfficiency!=ttli.reboundEfficiency){
	    	System.out.println("reboundEfficiency");
	    	return false;
	    }
	    if(this.stealEfficiency!=ttli.stealEfficiency){
	    	System.out.println("stealEfficiency");
	    	return false;
	    }
	    if(this.secondaryAttackEfficiency!=ttli.secondaryAttackEfficiency){
	    	System.out.println("secondaryAttackEfficiency");
	    	return false;
	    }
	    if(this.winningNum!=ttli.winningNum){
	    	System.out.println("winningNum");
	    	return false;
	    }
	    if(this.shotInNum!=ttli.shotInNum){
	    	System.out.println("shotInNum");
	    	return false;
	    }
	    if(this.shotNum!=ttli.shotNum){
	    	System.out.println("shotNum");
	    	return false;
	    }
	    if(this.threeShotInNum!=ttli.threeShotInNum){
	    	System.out.println("threeShotInNum");
	    	return false;
	    }
	    if(this.threeShotNum!=ttli.threeShotNum){
	    	System.out.println("threeShotNum");
	    	return false;
	    }
	    if(this.penaltyShotInNum!=ttli.penaltyShotInNum){
	    	System.out.println("penaltyShotInNum");
	    	return false;
	    }
	    if(this.penaltyShotNum!=ttli.penaltyShotNum){
	    	System.out.println("penaltyShotNum");
	    	return false;
	    }
	    if(this.offensiveRebound!=ttli.offensiveRebound){
	    	System.out.println("offensiveRebound");
	    	return false;
	    }
	    if(this.defensiveRebound!=ttli.defensiveRebound){
	    	System.out.println("defensiveRebound");
	    	return false;
	    }
	    if(this.rebound!=ttli.rebound){
	    	System.out.println("rebound");
	    	return false;
	    }
	    if(this.secondaryAttack!=ttli.secondaryAttack){
	    	System.out.println("TeamTech");
	    	System.out.println("secondaryAttack");
	    	return false;
	    }
	    if(this.steal!=ttli.steal){
	    	System.out.println("steal");
	    	return false;
	    }
	    if(this.blockShot!=ttli.blockShot){
	    	System.out.println("blockShot");
	    	return false;
	    }
	    if(this.fault!=ttli.fault){
	    	System.out.println("fault");
	    	return false;
	    }
	    if(this.foul!=ttli.foul){
	    	System.out.println("foul");
	    	return false;
	    }
	    if(this.score!=ttli.score){
	    	System.out.println("score");
	    	return false;
	    }
	    if(this.offensiveRound!=ttli.offensiveRound){
	    	System.out.println("offensiveRound");
	    	return false;
	    }
	    if(this.shotInNumave!=ttli.shotInNumave){
	    	System.out.println("shotInNumave");
	    	return false;
	    }
	    if(this.shotNumave!=ttli.shotNumave){
	    	System.out.println("shotNumave");
	    	return false;
	    }
	    if(this.threeShotInNumave!=ttli.threeShotInNumave){
	    	System.out.println("threeShotInNumave");
	    	return false;
	    }
	    if(this.threeShotNumave!=ttli.threeShotNumave){
	    	System.out.println("threeShotNumave");
	    	return false;
	    }
	    if(this.penaltyShotInNumave!=ttli.penaltyShotInNumave){
	    	System.out.println("penaltyShotInNumave");
	    	return false;
	    }
	    if(this.penaltyShotNumave!=ttli.penaltyShotNumave){
	    	System.out.println("penaltyShotNumave");
	    	return false;
	    }
	    if(this.offensiveReboundave!=ttli.offensiveReboundave){
	    	System.out.println("offensiveReboundave");
	    	return false;
	    }
	    if(this.defensiveReboundave!=ttli.defensiveReboundave){
	    	System.out.println("defensiveReboundave");
	    	return false;
	    }
	    if(this.reboundave!=ttli.reboundave){
	    	System.out.println("reboundave");
	    	return false;
	    }
	    if(this.secondaryAttackave!=ttli.secondaryAttackave){
	    	System.out.println("secondaryAttackave");
	    	return false;
	    }
	    if(this.stealave!=ttli.stealave){
	    	System.out.println("stealave");
	    	return false;
	    }
	    if(this.blockShotave!=ttli.blockShotave){
	    	System.out.println("blockShotave");
	    	return false;
	    }
	    if(this.faultave!=ttli.faultave){
	    	System.out.println("faultave");
	    	return false;
	    }
	    if(this.foulave!=ttli.foulave){
	    	System.out.println("foulave");
	    	return false;
	    }
	    if(this.scoreave!=ttli.scoreave){
	    	System.out.println("scoreave");
	    	return false;
	    }
	    if(this.offensiveRoundave!=ttli.offensiveRoundave){
	    	System.out.println("offensiveRoundave");
	    	return false;
	    }
	    return true;
	}
}
