package VO;


public class TeamVO {
	public String fullName;            //球队全名
	public String abbreviation;        //缩写
	public String location;            //所在地
	public String division;            //赛区
	public String partition;           //分区
	public String homeCourt;           //主场
	public String time;                //建立时间
	
	public boolean equals(TeamVO tvo){
		if(!this.fullName.equals(tvo.fullName)){
			System.out.println("fullName");
			return false;
		}
		if(!this.abbreviation.equals(tvo.abbreviation)){
			System.out.println("abbreviation");
			return false;
		}
		if(!this.location.equals(tvo.location)){
			System.out.println("location");
			return false;
		}
		if(!this.division.equals(tvo.division)){
			System.out.println("division");
			return false;
		}
		if(!this.partition.equals(tvo.partition)){
			System.out.println("partition");
			return false;
		}
		if(!this.homeCourt.equals(tvo.homeCourt)){
			System.out.println("homeCourt");
			return false;
		}
		if(!this.time.equals(tvo.time)){
			System.out.println("time");
			return false;
		}
		return true;
	}
}
