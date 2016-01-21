import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
	private ArrayList<Date> log;
	public CounterImpl(){
		this.log = new ArrayList<Date>();
	}
	
	public CounterImpl(ArrayList<Date> log){
		this.log = log;
	}

	public void inc(){
		checkClean();
		this.log.add(new Date());
	}

	private void checkClean(){
	//todo: check if need to clean and clean log
	}

	public int countLastMin(){
		//need to count the entries in last min, but no need to count one by one, use the array’s index is great
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, -1);
		Date lastMin = cal.getTime();
		//do binary search to find the first entry in last min
		return this.log.size() - findFirstEntryIndex(lastMin, log, 0,  log.size());	
	}

	private int findFirstEntryIndex (Date lastMin, ArrayList<Date> log, int start, int end){
		if(start == end )
			return start;
		int mid = (start + end)/2;
	
		//assumption: there is no duplicates in the arrayList 
		if(lastMin.equals(log.get(mid))){
			return mid;
		} else if(lastMin.before(log.get(mid))){
			return findFirstEntryIndex (lastMin, log, start, mid );
		} else {
			return findFirstEntryIndex (lastMin, log, mid+1, end );
		}
	}
}
