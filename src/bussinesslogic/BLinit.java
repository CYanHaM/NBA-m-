package bussinesslogic;

import data.DataProcessing;

public class BLinit {
	public void init(String datasource){
		DataProcessing dp = new DataProcessing(datasource);
		dp.matchRead();
	}
}
