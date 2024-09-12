

import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public class MultiDayPerWeekEvent extends CalendarEvent
{
	GregorianCalendar repeatUntil;
	int[] days;
	
	public MultiDayPerWeekEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeat, int[] days)
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
	public int[] getDays()
	{
		return days;
	}
	public void setDays(int[] days)
	{
		this.days = days;
	}
	
}
