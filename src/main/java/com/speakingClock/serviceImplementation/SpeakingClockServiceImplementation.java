package com.speakingClock.serviceImplementation;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.speakingClock.service.SpeakingClockService;

@Service
public class SpeakingClockServiceImplementation implements SpeakingClockService {

	@Override
	public String getCurrentTimingsInWords() {

		try {

			String[] oneDigit = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
					"nine", "ten", "eleven", "twelve" };

			String[] twoDigits = new String[] { "", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
					"sixteen", "seventeen", "eighteen", "nineteen" };

			String[] multipleOfTens = new String[] { "", "", "twenty", "thirty", "forty", "fifty" };

			LocalTime currentTime = LocalTime.now();

			String midDay = "It's Midday";
			String midNight = "It's Midnight";

			if (currentTime.getHour() == 12 && currentTime.getMinute() == 00) {
				return midDay;
			} else if (currentTime.getHour() == 00 && currentTime.getMinute() == 00) {
				return midNight;
			}

			int hour = currentTime.getHour();
			int minutes = currentTime.getMinute();

			String finalHour = oneDigit[hour];
			String finalMinute = null;

			if (minutes == 00) {
				finalMinute = "o'clock";

			} else if (minutes < 13) {
				finalMinute = oneDigit[minutes];
			}

			else if (minutes > 12 && minutes < 20) {

				int m = minutes - 10;
				finalMinute = twoDigits[m + 1];

			} else if (minutes == 20) {

				finalMinute = multipleOfTens[2];
			}

			else if (minutes > 20 && minutes < 30) {

				String tens = multipleOfTens[2];
				int unit = minutes - 20;
				String units = oneDigit[unit];
				finalMinute = tens + " " + units;

			} else if (minutes == 30) {
				finalMinute = multipleOfTens[3];

			} else if (minutes > 30 && minutes < 40) {

				String tens = multipleOfTens[3];
				int unit = minutes - 30;
				String units = oneDigit[unit];
				finalMinute = tens + " " + units;

			} else if (minutes == 40) {
				finalMinute = multipleOfTens[4];

			} else if (minutes > 40 && minutes < 50) {

				String tens = multipleOfTens[4];
				int unit = minutes - 40;
				String units = oneDigit[unit];
				finalMinute = tens + " " + units;

			} else if (minutes == 50) {
				finalMinute = multipleOfTens[5];

			} else if (minutes > 50 && minutes < 60) {

				String tens = multipleOfTens[5];
				int unit = minutes - 50;
				String units = oneDigit[unit];
				finalMinute = tens + " " + units;
			}

			String finalResult = "Its " + finalHour + " " + finalMinute;

			return finalResult;
		} catch (Exception e) {
			return null;
		}
	}

}
