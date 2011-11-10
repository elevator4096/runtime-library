/*
 * Copyright (c) 2011 NTB Interstate University of Applied Sciences of Technology Buchs.
 * All rights reserved.
 *
 * http://www.ntb.ch/inf
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of the project's author nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package ch.ntb.inf.deep.runtime.mpc555;

import ch.ntb.inf.deep.runtime.mpc555.driver.DS1302Z;

/**
 * Date and time class. This class reads on initialization the date and time
 * from the {@link mpc555.DS1302Z} real time clock. After that the time is
 * updated with a normal {@link mpc555.Task}. Each 24 hours at 24:00 the time will be
 * updated from the real time clock.<br>
 * 
 * @author 25.08.2009 simon.pertschy@ntb.ch
 * 
 */
public class DateTime extends Task {

	private int sec, min, hour, date, month, year, millisec;

	public static int maxStrLen = 21;

	private int lastCallTime;
	private static DateTime dateTime;

	private DateTime() {
		this.period = 100;
		sec = DS1302Z.getSec();
		min = DS1302Z.getMin();
		hour = DS1302Z.getHour();
		date = DS1302Z.getDate();
		month = DS1302Z.getMonth();
		year = DS1302Z.getYear();
		millisec = 0;
		lastCallTime = Task.time();
		Task.install(this);
	}

	/**
	 * Get an instance from this class.
	 * @return The instance of this class.
	 */
	public static DateTime getInstance() {
		if (dateTime == null)
			dateTime = new DateTime();
		return dateTime;
	}

	/* (non-Javadoc)
	 * @see mpc555.Task#Do()
	 */
	public void Do() {
		millisec += Task.time() - lastCallTime;
		lastCallTime = Task.time();
		if (millisec > 999) {
			sec++;
			millisec -= 1000;
			if (sec > 59) {
				min++;
				sec -= 60;
				if (min > 59) {
					min -= 60;
					hour++;
					if (hour > 23)
						update();
				}
			}
		}
	}

	/**
	 * Update the time from the {@link mpc555.DS1302Z} real time clock.
	 */
	private void  update() {
		sec = DS1302Z.getSec();
		min = DS1302Z.getMin();
		hour = DS1302Z.getHour();
		date = DS1302Z.getDate();
		month = DS1302Z.getMonth();
		year = DS1302Z.getYear();
		millisec = 0;
		lastCallTime = Task.time();
	}

	/**
	 * Read the actual seconds.
	 * @return the actual seconds.
	 */
	public int getSec() {
		return sec;
	}

	/**
	 * Read the actual minutes.
	 * @return the actual minutes.
	 */
	public int getMin() {
		return min;
	}

	/**
	 * Reads the actual hour.
	 * The hour is represented with the 24 hours format.
	 * @return the actual hour.
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Reads the actual date of the month.
	 * @return the actual date.
	 */
	public int getDate() {
		return date;
	}

	/**
	 * Reads the actual month.
	 * @return the actual month.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Reads the actual year.
	 * @return the actual year.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the actual time and writes it to the {@link mpc555.DS1302Z} real time clock.
	 * @param sec the actual seconds.
	 * @param min the actual minutes.
	 * @param hour the actual hour.
	 * @param date the actual date.
	 * @param month the actual month.
	 * @param year the actual year.
	 */
	public void setTime(int sec, int min, int hour, int date, int month,
			int year) {
		DS1302Z.setWriteProtection(false);
		DS1302Z.setSec(sec);
		DS1302Z.setMin(min);
		DS1302Z.setHour(hour);
		DS1302Z.setDate(date);
		DS1302Z.setMonth(month);
		DS1302Z.setYear(year);
		DS1302Z.setWriteProtection(true);
		this.sec = sec;
		this.min = min;
		this.hour = hour;
		this.date = date;
		this.month = month;
		this.year = year;
		this.millisec = 0;
	}

	/**
	 * Returns the actual Time as an integer.
	 * bits 0 - 4 = seconds / 2
	 * bits 5 - 10 = minutes
	 * bits 11 - 15 = hour
	 * bits 16 - 20 = date
	 * bits 21 - 24 = month
	 * bits 25 - 31 = year - 1980
	 * @return
	 */
	public int getPackedTime() {
		int time = (year - 1980) << 25;
		time |= month << 21;
		time |= date << 16;
		time |= hour << 11;
		time |= min << 5;
		time |= sec >> 1;
		return time;

	}

	/**
	 * Returns the date and time as a string.
	 * The format <i>dd.mm.yyyy hh:mm:ss</i>.
	 * @param str
	 * @return
	 */
	public int getString(char[] str) {
		int off = 0;
		if (date < 10) {
			str[off] = '0';
			off++;
			str[off] = (char) ('0' + date);
			off++;
		} else {
			off = Integer.toCharArray(str, 0, date);
		}
		str[off] = '.';
		off++;
		if (month < 10) {
			str[off] = '0';
			off++;
			str[off] = (char) ('0' + month);
			off++;
		} else {
			off = Integer.toCharArray(str, off, month);
		}
		str[off] = '.';
		off++;
		off = Integer.toCharArray(str, off, year);
		str[off] = ' ';
		off++;
		if (hour < 10) {
			str[off] = '0';
			off++;
			str[off] = (char) ('0' + hour);
			off++;
		} else {
			off = Integer.toCharArray(str, off, hour);
		}
		str[off] = ':';
		off++;
		if (min < 10) {
			str[off] = '0';
			off++;
			str[off] = (char) ('0' + min);
			off++;
		} else {
			off = Integer.toCharArray(str, off, min);
		}
		str[off] = ':';
		off++;
		if (sec < 10) {
			str[off] = '0';
			off++;
			str[off] = (char) ('0' + sec);
			off++;
		} else {
			off = Integer.toCharArray(str, off, sec);
		}
		return off;
	}

}
