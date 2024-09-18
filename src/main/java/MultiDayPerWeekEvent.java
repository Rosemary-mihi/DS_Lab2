import java.util.GregorianCalendar;

import calendar.Meeting;
import calendar.MeetingCalendar;

public class MultiDayPerWeekEvent extends CalendarEvent
{
	GregorianCalendar repeatUntil;
	int[] days;
	private String desc;
	private String loc;
	private GregorianCalendar start;
	private GregorianCalendar end;
	
	public MultiDayPerWeekEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeatUntil, int[] days)
	{
		super(desc, loc, start, end);
		this.desc = desc;
		this.loc = loc;
		this.start = start;
		this.end = end;
		this.repeatUntil = repeatUntil;
		this.days = days;
	}
	public void scheduleEvent(MeetingCalendar cal)
	{
		GregorianCalendar newStart = (GregorianCalendar)(start.clone());
		GregorianCalendar newEnd = (GregorianCalendar)(end.clone());
		
		for (int i =0; i< days.length; i++)
		{
			if(newStart.get(GregorianCalendar.DAY_OF_WEEK)==days[i])
			{
				while (newStart.before(repeatUntil) == true)
				{
					Meeting m = new Meeting(desc, loc, newStart, newEnd);
					cal.addMeeting(m);
					newStart.add(GregorianCalendar.DAY_OF_MONTH, 7);
					newEnd.add(GregorianCalendar.DAY_OF_MONTH, 7);
				}
			}
			newStart.add(GregorianCalendar.DAY_OF_MONTH, 1);
			newEnd.add(GregorianCalendar.DAY_OF_MONTH, 1);
			if(newStart.get(GregorianCalendar.DAY_OF_WEEK)==days[i])
			{
				while (newStart.before(repeatUntil) == true)
				{
					Meeting m = new Meeting(desc, loc, newStart, newEnd);
					cal.addMeeting(m);
					newStart.add(GregorianCalendar.DAY_OF_MONTH, 7);
					newEnd.add(GregorianCalendar.DAY_OF_MONTH, 7);
				}
			}
			newStart.add(GregorianCalendar.DAY_OF_MONTH, 1);
			newEnd.add(GregorianCalendar.DAY_OF_MONTH, 1);
			if(newStart.get(GregorianCalendar.DAY_OF_WEEK)==days[i])
			{
				while (newStart.before(repeatUntil) == true)
				{
					Meeting m = new Meeting(desc, loc, newStart, newEnd);
					cal.addMeeting(m);
					newStart.add(GregorianCalendar.DAY_OF_MONTH, 7);
					newEnd.add(GregorianCalendar.DAY_OF_MONTH, 7);
				}
			}
			newStart.add(GregorianCalendar.DAY_OF_MONTH, 1);
			newEnd.add(GregorianCalendar.DAY_OF_MONTH, 1);
			if(newStart.get(GregorianCalendar.DAY_OF_WEEK)==days[i])
			{
				while (newStart.before(repeatUntil) == true)
				{
					Meeting m = new Meeting(desc, loc, newStart, newEnd);
					cal.addMeeting(m);
					newStart.add(GregorianCalendar.DAY_OF_MONTH, 7);
					newEnd.add(GregorianCalendar.DAY_OF_MONTH, 7);
				}
			}
			newStart.add(GregorianCalendar.DAY_OF_MONTH, 1);
			newEnd.add(GregorianCalendar.DAY_OF_MONTH, 1);
			if(newStart.get(GregorianCalendar.DAY_OF_WEEK)==days[i])
			{
				while (newStart.before(repeatUntil) == true)
				{
					Meeting m = new Meeting(desc, loc, newStart, newEnd);
					cal.addMeeting(m);
					newStart.add(GregorianCalendar.DAY_OF_MONTH, 7);
					newEnd.add(GregorianCalendar.DAY_OF_MONTH, 7);
				}
			}
			newStart.add(GregorianCalendar.DAY_OF_MONTH, 1);
			newEnd.add(GregorianCalendar.DAY_OF_MONTH, 1);
			if(newStart.get(GregorianCalendar.DAY_OF_WEEK)==days[i])
			{
				while (newStart.before(repeatUntil) == true)
				{
					Meeting m = new Meeting(desc, loc, newStart, newEnd);
					cal.addMeeting(m);
					newStart.add(GregorianCalendar.DAY_OF_MONTH, 7);
					newEnd.add(GregorianCalendar.DAY_OF_MONTH, 7);
				}
			}
			newStart.add(GregorianCalendar.DAY_OF_MONTH, 1);
			newEnd.add(GregorianCalendar.DAY_OF_MONTH, 1);
			if(newStart.get(GregorianCalendar.DAY_OF_WEEK)==days[i])
			{
				while (newStart.before(repeatUntil) == true)
				{
					Meeting m = new Meeting(desc, loc, newStart, newEnd);
					cal.addMeeting(m);
					newStart.add(GregorianCalendar.DAY_OF_MONTH, 7);
					newEnd.add(GregorianCalendar.DAY_OF_MONTH, 7);
				}
			}
			newStart = (GregorianCalendar)(start.clone());
			newEnd = (GregorianCalendar)(start.clone());
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
	public int[] getDays()
	{
		return days;
	}
	public void setDays(int[] days)
	{
		this.days = days;
	}
	
}
