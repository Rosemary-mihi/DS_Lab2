import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import calendar.Meeting;
import calendar.MeetingCalendar;

class CalendarEventTest
{
	
	MeetingCalendar calA;
	Meeting MultiA;
	Meeting MultiB;
	Meeting MultiC;
	Meeting MultiD;

	
	MultiDayPerWeekEvent A;
	OneTimeEvent B;
	PriorityEvent C;
	WeeklyEvent D;
	
	GregorianCalendar startA;
	GregorianCalendar endA;
	GregorianCalendar repeatA;
	GregorianCalendar startAB;
	GregorianCalendar endB;
	GregorianCalendar endC;
	GregorianCalendar endD;

	
	@BeforeEach
	void setUp() throws Exception
	{
		calA = new MeetingCalendar;
		startA = new GregorianCalendar(2023,8,28,8,30);
		endA = new GregorianCalendar(2023,8,28,9,30);
		repeatA = new GregorianCalendar(2024,8,28,9,30);
		endB = new GregorianCalendar(2023,8,28,10,30);
		endC = new GregorianCalendar(2023,8,28,11,30);
		endD = new GregorianCalendar(2023,8,28,12,30);
		
		A = new MultiDayPerWeekEvent("A","ALoc",startA,endA);
		B = new OneTimeEvent("B","BLoc",endA,endB);
		C = new PriorityEvent("C","CLoc",endB,endC);
		D = new WeeklyEvent("D","DLoc",endC,endD);

	}
	@Test
	void testGetters()
	{
		assertEquals("A",A.getDescription());
		assertEquals("ALoc",A.getLocation());
		assertEquals(startA,A.getStartTime());
		assertEquals(repeatA,A.getRepeatUntil());
		assertEquals(endA,A.getEndTime());
		
		assertEquals("B",B.getDescription());
		assertEquals("BLoc",B.getLocation());
		assertEquals(endA,B.getStartTime());
		assertEquals(endB,B.getEndTime());
		
		assertEquals("C",C.getDescription());
		assertEquals("CLoc",C.getLocation());
		assertEquals(endB,C.getStartTime());
		assertEquals(endC,C.getEndTime());
		
		assertEquals("D",D.getDescription());
		assertEquals("DLoc",D.getLocation());
		assertEquals(endC,D.getStartTime());
		assertEquals(endD,D.getEndTime());
	}
	@Test
	void testscheduleEvent()
	{
		A.scheduleEvent(calA);
		MultiA = calA.findMeeting(startA);
		assertEquals(MultiA.getDescription(), A.getDescription());
		assertEquals(MultiA.getLocation(), A.getLocation());
		assertEquals(MultiA.getStartTime(),A.getStartTime());
		assertEquals(MultiA.getRepeatUntil(),A.getRepeatUntil());
		assertEquals(MultiA.getEndTime(),A.getEndTime()); \\still need days
		
		B.scheduleEvent(calA);
		MultiB = calA.findMeeting(endA);
		
		
	}
	

}
