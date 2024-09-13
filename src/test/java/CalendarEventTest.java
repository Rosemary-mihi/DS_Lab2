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
	OneTimeEvent OneTimeB;
	PriorityEvent PriorityC;
	WeeklyEvent WeeklyD;

	
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
	int[] daysA = {GregorianCalendar.MONDAY,GregorianCalendar.WEDNESDAY};

	
	@BeforeEach
	void setUp() throws Exception
	{
		calA = new MeetingCalendar();
		startA = new GregorianCalendar(2023,8,28,8,30);
		endA = new GregorianCalendar(2023,8,28,9,30);
		repeatA = new GregorianCalendar(2023,9,10,8,30);
		int[] daysA = {GregorianCalendar.MONDAY,GregorianCalendar.WEDNESDAY};
		endB = new GregorianCalendar(2023,8,28,10,30);
		endC = new GregorianCalendar(2023,8,28,11,30);
		endD = new GregorianCalendar(2023,8,28,12,30);
		repeatD = new GregorianCalendar(2023,9,15,9,30);

		
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
		assertArrayEquals(daysA, A.getDays());
		
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
		GregorianCalendar firstA = new GregorianCalendar(2023,9,2,8,30);
		B.scheduleEvent(calA); 
		C.scheduleEvent(calA);
		D.scheduleEvent(calA);
		
		assertNotNull(calA.findMeeting(firstA));
		assertNotNull(calA.findMeeting(endA));
		assertNotNull(calA.findMeeting(endB));
		assertNotNull(calA.findMeeting(endC));


		
	}
	@Test
	void testNoOverlap()
	{
		//make another meeting to test for overlap 
		A.scheduleEvent(calA);
		MultiA = new MultiDayPerWeekEvent("BadMeeting","NewALoc",startA, endA, repeatA, daysA);
		MultiA.scheduleEvent(calA);
		
		assertEquals("A",A.getDescription());
		assertEquals("ALoc",A.getLocation());
		assertEquals(startA,A.getStartTime());
		assertEquals(repeatA,A.getRepeatUntil());
		assertEquals(endA,A.getEndTime());
		assertArrayEquals(daysA, A.getDays());
		
		
		B.scheduleEvent(calA);
		OneTimeB = new OneTimeEvent("BadMeeting","NewBLoc",endA,endB);
		OneTimeB.scheduleEvent(calA);
		
		assertEquals("B",B.getDescription());
		assertEquals("BLoc",B.getLocation());
		assertEquals(endA,B.getStartTime());
		assertEquals(endB,B.getEndTime());
		
		C.scheduleEvent(calA); //the new priority event should get rid of the old one
		PriorityC = new PriorityEvent("GoodMeeting","NewCLoc",endB,endC);
		PriorityC.scheduleEvent(calA);
		
		assertEquals("GoodMeeting",PriorityC.getDescription());
		assertEquals("NewCLoc",PriorityC.getLocation());
		assertEquals(endB,PriorityC.getStartTime());
		assertEquals(endC,PriorityC.getEndTime());
		
		D.scheduleEvent(calA);
		WeeklyD = new WeeklyEvent("BadMeeting","NewDLoc",endC,endD, repeatD);
		WeeklyD.scheduleEvent(calA);

		assertEquals("D",D.getDescription());
		assertEquals("DLoc",D.getLocation());
		assertEquals(endC,D.getStartTime());
		assertEquals(repeatD,D.getRepeatUntil());
		assertEquals(endD,D.getEndTime());
		
		//assertNotEquals(MultiA, calA.findMeeting(startA));
		
	}
	@Test
	void testMultiRepeat()
	{
		A.scheduleEvent(calA);
		GregorianCalendar firstMonday = new GregorianCalendar(2023,9,2,8,30);
		GregorianCalendar firstWednesday = new GregorianCalendar(2023,9,4,8,30);
		GregorianCalendar secondMonday = new GregorianCalendar(2023,9,9,8,30);

		GregorianCalendar wrongDay1 = new GregorianCalendar(2023,8,25,8,30);
		GregorianCalendar wrongDay2 = new GregorianCalendar(2023,8,27,8,30);
		GregorianCalendar wrongDay3 = new GregorianCalendar(2023,8,28,8,30);
		GregorianCalendar wrongDay4 = new GregorianCalendar(2023,8,29,8,30);
		GregorianCalendar wrongDay5 = new GregorianCalendar(2023,9,10,8,30);
		GregorianCalendar wrongDay6 = new GregorianCalendar(2023,9,11,8,30);
		GregorianCalendar wrongDay7 = new GregorianCalendar(2023,9,16,8,30);

		assertNotNull(calA.findMeeting(firstMonday));
		assertNotNull(calA.findMeeting(firstWednesday));
		assertNotNull(calA.findMeeting(secondMonday));

		assertNull(calA.findMeeting(wrongDay1));
		assertNull(calA.findMeeting(wrongDay2));
		assertNull(calA.findMeeting(wrongDay3));
		assertNull(calA.findMeeting(wrongDay4));
		assertNull(calA.findMeeting(wrongDay5));
		assertNull(calA.findMeeting(wrongDay6));
		assertNull(calA.findMeeting(wrongDay7));
	}
	@Test
	void testWeeklyRepeat()
	{
		D.scheduleEvent(calA);
		GregorianCalendar thursday1 = new GregorianCalendar(2023,2,28,8,30);
		GregorianCalendar thursday2 = new GregorianCalendar(2023,9,5,8,30);
		GregorianCalendar thursday3 = new GregorianCalendar(2023,9,12,8,30);

		GregorianCalendar wrongDay1 = new GregorianCalendar(2023,8,21,8,30);
		GregorianCalendar wrongDay2 = new GregorianCalendar(2023,8,27,8,30);
		GregorianCalendar wrongDay3 = new GregorianCalendar(2023,8,29,8,30);
		GregorianCalendar wrongDay4 = new GregorianCalendar(2023,9,11,8,30);
		GregorianCalendar wrongDay5 = new GregorianCalendar(2023,9,13,8,30);
		GregorianCalendar wrongDay6 = new GregorianCalendar(2023,9,15,8,30);
		GregorianCalendar wrongDay7 = new GregorianCalendar(2023,9,19,8,30);

		assertNotNull(calA.findMeeting(thursday1));
		assertNotNull(calA.findMeeting(thursday2));
		assertNotNull(calA.findMeeting(thursday3));

		assertNull(calA.findMeeting(wrongDay1));
		assertNull(calA.findMeeting(wrongDay2));
		assertNull(calA.findMeeting(wrongDay3));
		assertNull(calA.findMeeting(wrongDay4));
		assertNull(calA.findMeeting(wrongDay5));
		assertNull(calA.findMeeting(wrongDay6));
		assertNull(calA.findMeeting(wrongDay7));
	}

}
