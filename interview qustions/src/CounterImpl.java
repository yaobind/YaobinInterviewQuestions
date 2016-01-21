import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
interface counter {
void inc();
int countLastMin() ;
}

design:
LinkeList, not good to do binary search (!!! find later)
o-o-o-o-o-o-o-o-o-o
need add when inc(), 
count when countLastMin(), so search , so better to do double linked list
and remove or create new one the gc the old one. (!!! check if this is a better solution)

need to do both ArrayList version and LinkedList version  */


public class CounterImpl implements Counter{
	private List<Date> log;
	private int limit;
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public CounterImpl(){
		this.log = new ArrayList<Date>();
	}
	
	public List<Date> getLog() {
		return log;
	}

	public void setLog(List<Date> log) {
		this.log = log;
	}

	public void inc(){
		checkClean();
		this.log.add(new Date());
	}

	private void checkClean(){
		if(this.log.size() > this.limit){
			List<Date> newLog =  this.log.subList(findFirstEntryIndex(getLastMin(), this.log, 0, this.log.size()-1), this.log.size()-1);
			this.log = newLog;
		}
	}
	
	private Date getLastMin(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, -1);
		return cal.getTime();
	}

	public int countLastMin(){
		//need to count the entries in last min, but no need to count one by one, use the array’s index is great

		//do binary search to find the first entry in last min
		return this.log.size() - findFirstEntryIndex(getLastMin(), log, 0,  log.size()-1);	
	}

	private int findFirstEntryIndex (Date lastMin, List<Date> log, int startIndex, int endIndex){
		if(startIndex == endIndex )
			return startIndex;
		int mid = (startIndex + endIndex)/2;
	
		//assumption: there is no duplicates in the arrayList 
		if(lastMin.equals(log.get(mid))){
			return mid;
		} else if(lastMin.before(log.get(mid))){
			return findFirstEntryIndex (lastMin, log, startIndex, mid );
		} else {
			return findFirstEntryIndex (lastMin, log, mid+1, endIndex );
		}
	}
}
