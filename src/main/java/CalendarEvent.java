import java.util.ArrayList;
import java.util.GregorianCalendar;

import calendar.Meeting;
import calendar.MeetingCalendar;


public abstract class CalendarEvent
{	
	private String Description;
	private String location;
	private GregorianCalendar startTime;
	private GregorianCalendar endTime;
	
	public CalendarEvent(String Description, String location, GregorianCalendar startTime, GregorianCalendar endTime)
	{
		//super(Description, location, startTime, endTime);
		this.Description = Description;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;

	}
	public abstract void scheduleEvent(MeetingCalendar cal);
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String description)
	{
		Description = description;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	public GregorianCalendar getStartTime()
	{
		return startTime;
	}
	public void setStartTime(GregorianCalendar startTime)
	{
		this.startTime = startTime;
	}
	public GregorianCalendar getEndTime()
	{
		return endTime;
	}
	public void setEndTime(GregorianCalendar endTime)
	{
		this.endTime = endTime;
	}

}

