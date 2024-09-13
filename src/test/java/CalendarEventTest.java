import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calendar.Meeting;
import calendar.MeetingCalendar;

class CalendarEventTest
{
	
	MeetingCalendar calA;
	MultiDayPerWeekEvent MultiA;
	Meeting OneTimeB;
	Meeting PriorityC;
	Meeting WeeklyD;

	
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
	GregorianCalendar repeatD;
	int[] daysA = {0,1,2};

	
	@BeforeEach
	void setUp() throws Exception
	{
		calA = new MeetingCalendar();
		startA = new GregorianCalendar(2023,8,28,8,30);
		endA = new GregorianCalendar(2023,8,28,9,30);
		repeatA = new GregorianCalendar(2024,8,28,9,30);
		int[] daysA = {0,1,2};
		endB = new GregorianCalendar(2023,8,28,10,30);
		endC = new GregorianCalendar(2023,8,28,11,30);
		endD = new GregorianCalendar(2023,8,28,12,30);
		repeatD = new GregorianCalendar(2024,8,28,9,30);

		
		A = new MultiDayPerWeekEvent("A","ALoc",startA,endA, repeatA, daysA);
		B = new OneTimeEvent("B","BLoc",endA,endB);
		C = new PriorityEvent("C","CLoc",endB,endC);
		D = new WeeklyEvent("D","DLoc",endC,endD, repeatD);

	}
	@Test
	void testGetters()
	{
		assertEquals("A",A.getDescription());
		assertEquals("ALoc",A.getLocation());
		assertEquals(startA,A.getStartTime());
		assertEquals(repeatA,A.getRepeatUntil());
		assertEquals(endA,A.getEndTime());
		assertEquals(daysA,A.getDays());

		
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
		assertEquals(repeatD,D.getRepeatUntil());
		assertEquals(endD,D.getEndTime());
		
	}
	
	@Test
	void testscheduleEvent()
	{
		A.scheduleEvent(calA);
		B.scheduleEvent(calA); 
		C.scheduleEvent(calA);
		D.scheduleEvent(calA);
		
		assertNotNull(calA.findMeeting(startA));//ask why did i do this 
		assertNotNull(calA.findMeeting(endA));
		assertNotNull(calA.findMeeting(endB));
		assertNotNull(calA.findMeeting(endC));


		//assertNull(calA.findMeeting(startA));//when you dont want an event to be there
		//can't do assertEquals
		//newMeeting = new Meeting(a.getMeetingName(),)
		//assertNotEquals(newMeeting, calA.findMeeting()))		
	}
	@Test
	void testNoOverlap()
	{
		//make another meeting to test for overlap 
		A.scheduleEvent(calA);
		MultiA = new MultiDayPerWeekEvent("A","ALoc",startA, endA, repeatA, daysA);
		MultiA.scheduleEvent(calA);
		B.scheduleEvent(calA);
		C.scheduleEvent(calA);
		D.scheduleEvent(calA);
		
		assertNotEquals(MultiA, calA.findMeeting(startA));
		assertNull(MultiA);
		//assertNull(calA.findMeeting(startA));//when you dont want an event to be there
		//can't do assertEquals
		//newMeeting = new Meeting(a.getMeetingName(),)

		
	}
	

}
