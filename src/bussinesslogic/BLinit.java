package bussinesslogic;

import data.DataProcessing;
import data.TeamData;
import data.TeamTechData;

public class BLinit {
	public void init(String datasource){
		DataProcessing dp = new DataProcessing(datasource);
		dp.matchRead();
		TeamTechData ttd = new TeamTechData();
		ttd.WriteIn(datasource);
	}
}
