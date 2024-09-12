

import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class PriorityEvent extends CalendarEvent
{
	public PriorityEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end)
	{
		super(desc, loc, start, end);
	}
	public void scheduleEvent(MeetingCalendar cal)
	{
		
	}
}
