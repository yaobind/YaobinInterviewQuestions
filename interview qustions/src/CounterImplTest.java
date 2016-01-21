import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class CounterImplTest {

	@Test
	public void test() {
		ArrayList<Date> log = new ArrayList<Date>();
		
		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date());

		
		cal.add(Calendar.MINUTE, -30);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		
		cal.setTime(new Date());
		
		cal.add(Calendar.SECOND, -30);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		cal.add(Calendar.SECOND, 5);
		log.add(cal.getTime());
		
		CounterImpl ct = new CounterImpl();
		ct.setLog(log);
		ct.setLimit(10);
		assertEquals(13, ct.getLog().size());
		assertEquals(7, ct.countLastMin());
		ct.inc();
		assertEquals(7, ct.getLog().size());
		assertEquals(7, ct.countLastMin());
		
	}

}
