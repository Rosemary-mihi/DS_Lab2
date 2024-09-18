

import java.util.GregorianCalendar;

import calendar.Meeting;
import calendar.MeetingCalendar;

public class WeeklyEvent extends CalendarEvent
{
	GregorianCalendar repeatUntil;
	private String desc;
	private String loc;
	private GregorianCalendar start;
	private GregorianCalendar end;
	
	public WeeklyEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeatUntil)
	{
		super(desc, loc, start, end);
		this.desc = desc;
		this.loc = loc;
		this.start = start;
		this.end = end;
		this.repeatUntil = repeatUntil;
	}
	public void scheduleEvent(MeetingCalendar cal)
	{
		GregorianCalendar newStart = (GregorianCalendar)(start.clone());
		GregorianCalendar newEnd = (GregorianCalendar)(end.clone());
		
		while (newStart.before(repeatUntil) == true)
		{
			Meeting m = new Meeting(desc, loc, newStart, newEnd);
			cal.addMeeting(m);
			newStart.add(GregorianCalendar.DAY_OF_MONTH, 7);
			newEnd.add(GregorianCalendar.DAY_OF_MONTH, 7);
		}
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
