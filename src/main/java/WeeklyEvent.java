

import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class WeeklyEvent extends CalendarEvent
{
	GregorianCalendar repeatUntil;
	
	public WeeklyEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeat)
	{
		super(desc, loc, start, end);
	}
	public void scheduleEvent(MeetingCalendar cal)
	{
		
	}
	public GregorianCalendar getRepeatUntil()
	{
		return repeatUntil;
	}
	public void setRepeatUntil(GregorianCalendar repeatUntil)
	{
		this.repeatUntil = repeatUntil;
	}
	
}
