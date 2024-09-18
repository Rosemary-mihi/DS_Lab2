

import java.util.GregorianCalendar;

import calendar.Meeting;
import calendar.MeetingCalendar;

public class PriorityEvent extends CalendarEvent
{
	private String desc;
	private String loc;
	private GregorianCalendar start;
	private GregorianCalendar end;
	
	public PriorityEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end)
	{
		super(desc, loc, start, end);
		this.desc = desc;
		this.loc = loc;
		this.start = start;
		this.end = end;
	}
	public void scheduleEvent(MeetingCalendar cal)
	{
		Meeting m = new Meeting(desc, loc, start, end);
		cal.addMeeting(m, true);
	}
}
