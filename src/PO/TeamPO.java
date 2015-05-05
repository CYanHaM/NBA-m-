package PO;
import java.io.Serializable;

import VO.TeamVO;


public class TeamPO implements Serializable{
	/**
	 * 球队基本信息
	 */
	public static final long serialVersionUID = 1L;
	public String fullName;            //球队全名
	public String abbreviation;        //缩写
	public String location;            //所在地
	public String division;            //赛区
	public String partition;           //分区
	public String homeCourt;           //主场
	public String time;                //建立时间
	
	
	public boolean equals(TeamPO tpo){
		if(!this.fullName.equals(tpo.fullName)){
			System.out.println("fullName");
			return false;
		}
		if(!this.abbreviation.equals(tpo.abbreviation)){
			System.out.println("abbreviation");
			return false;
		}
		if(!this.location.equals(tpo.location)){
			System.out.println("location");
			return false;
		}
		if(!this.division.equals(tpo.division)){
			System.out.println("division");
			return false;
		}
		if(!this.partition.equals(tpo.partition)){
			System.out.println("partition");
			return false;
		}
		if(!this.homeCourt.equals(tpo.homeCourt)){
			System.out.println("homeCourt");
			return false;
		}
		if(!this.time.equals(tpo.time)){
			System.out.println("time");
			return false;
		}
		return true;
	}
}
