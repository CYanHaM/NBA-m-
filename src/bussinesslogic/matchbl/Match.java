package bussinesslogic.matchbl;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import blservice.matchblservice.MatchBLService;
import bussinesslogic.Transfer.L2V.MatchL2V;
import bussinesslogic.Transfer.P2L.MatchP2L;
import data.MatchData;
import dataservice.MatchDataService;
import PO.MatchPO;
import VO.MatchVO;

public class Match implements MatchBLService{
//查看某一天的比赛
	public ArrayList<MatchVO> showMatchList(String date){
		MatchDataService mds=new MatchData();
		ArrayList<MatchPO> mplist=new ArrayList<MatchPO>();
		ArrayList<MatchLineItem> mlilist=new ArrayList<MatchLineItem>();
		ArrayList<MatchVO> mvlist=new ArrayList<MatchVO>();
		MatchLineItem mli=new MatchLineItem();
		MatchP2L p2l=new MatchP2L();
		MatchL2V l2v=new MatchL2V();

		mplist=mds.read();
		for(MatchPO po:mplist){
			mli=p2l.p2l(po);
			mlilist.add(mli);			
		}

		for(MatchLineItem li:mlilist){
			if(li.date.equals(date))
				mvlist.add(l2v.l2v(li));
		}
		
		return mvlist;
		
	}
	
//查看某一场比赛
	public MatchVO showMatch(String team,String date){
		MatchDataService mds=new MatchData();
		ArrayList<MatchPO> mplist=new ArrayList<MatchPO>();
		ArrayList<MatchLineItem> mlilist=new ArrayList<MatchLineItem>();
		MatchVO mv=new MatchVO();
		MatchLineItem mli=new MatchLineItem();
		MatchP2L p2l=new MatchP2L();
		MatchL2V l2v=new MatchL2V();

		mplist=mds.read();
		for(MatchPO po:mplist){
			mli=p2l.p2l(po);
			mlilist.add(mli);			
		}
		String homeTeam=date.split("_")[1];
		String guestTeam=date.split("_")[0];
		for(MatchLineItem li:mlilist){
			if(li.date.equals(date)&&li.homeTeam.equals(homeTeam)&&li.guestTeam.equals(guestTeam))
				mv=l2v.l2v(li);
			break;
		}
		
		return mv;
		
	}
	
//刷新列表
	public ArrayList<MatchVO> refresh(String date){
		ArrayList<MatchVO> mvlist=new ArrayList<MatchVO>();
		mvlist=showMatchList(date);
		return mvlist;

	}
//返回当日时间
	public String returnPresentDate(){
		MatchDataService mds=new MatchData();
		String date=mds.showPresentTime();
		return date;

	}
//查看相应时间里的比赛	
	public ArrayList<MatchVO> showMatchListByTime(String date,int time){
		MatchDataService mds=new MatchData();
		ArrayList<MatchPO> mplist=new ArrayList<MatchPO>();
		ArrayList<MatchLineItem> mlilist=new ArrayList<MatchLineItem>();
		ArrayList<MatchVO> mvlist=new ArrayList<MatchVO>();
		MatchP2L p2l=new MatchP2L();
		MatchL2V l2v=new MatchL2V();

		mplist=mds.read();
		for(int k=0;k<mplist.size();k++){
			mlilist.add(p2l.p2l(mplist.get(k)));			
		}


		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date today= fmt.parse(date);
			for(int i=0;i<time;i++){
				Date selectedDay= new Date(today.getTime() - i*24*60*60*1000);
				String selectedDayS=fmt.format(selectedDay);
				for(MatchLineItem li:mlilist){
					if(li.date.equals(selectedDayS))
						mvlist.add(l2v.l2v(li));
					
				}
			}
		} catch (ParseException e) {
			System.out.println("时间出错");
			e.printStackTrace();
		}
		return mvlist;
	}
	
	
}
