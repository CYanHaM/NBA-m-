package bussinesslogic.TeamBL;

public class TeamLineItem {
	public String fullName;            //球队全名
	public String abbreviation;        //缩写
	public String location;            //所在地
	public String division;            //赛区
	public String partition;           //分区
	public String homeCourt;           //主场
	public String time;                //建立时间
	
	public boolean equals(TeamLineItem tli){
		if(!this.fullName.equals(tli.fullName)){
			System.out.println("fullName");
			return false;
		}
		if(!this.abbreviation.equals(tli.abbreviation)){
			System.out.println("abbreviation");
			return false;
		}
		if(!this.location.equals(tli.location)){
			System.out.println("location");
			return false;
		}
		if(!this.division.equals(tli.division)){
			System.out.println("division");
			return false;
		}
		if(!this.partition.equals(tli.partition)){
			System.out.println("partition");
			return false;
		}
		if(!this.homeCourt.equals(tli.homeCourt)){
			System.out.println("homeCourt");
			return false;
		}
		if(!this.time.equals(tli.time)){
			System.out.println("time");
			return false;
		}
		return true;
	}
}
