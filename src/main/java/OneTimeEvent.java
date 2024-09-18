import java.util.GregorianCalendar;
import calendar.MeetingCalendar;
import calendar.Meeting;

//stub

public class OneTimeEvent extends CalendarEvent
{
	private String desc;
	private String loc;
	private GregorianCalendar start;
	private GregorianCalendar end;
	//why?
	//issue
	public OneTimeEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end)
	{
		super(desc, loc, start, end);
		this.desc = desc;
		this.loc = loc;
		this.start = start;
		this.end = end;
		//how does super work?
	}
	public void scheduleEvent(MeetingCalendar cal)
	{
		Meeting m = new Meeting(desc, loc, start, end);
		cal.addMeeting(m);
	}

}
