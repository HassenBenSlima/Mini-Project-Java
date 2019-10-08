package ney.opendevup.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class DateMethod implements Serializable{

	public Date yesterday()
	{
		final Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, +1);
		return cal.getTime();
	}
}
