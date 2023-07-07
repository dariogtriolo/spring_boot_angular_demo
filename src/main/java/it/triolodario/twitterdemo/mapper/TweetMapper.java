package it.triolodario.twitterdemo.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.triolodario.twitterdemo.controller.dto.TweetDTO;
import it.triolodario.twitterdemo.model.Tweet;

public class TweetMapper {

	private static final Logger log = LoggerFactory.getLogger(TweetMapper.class);

	private static final String DATE_TIME_FORMAT = "HH:mm z - dd/mm/yyyy";

	private TweetMapper() {
	}

	public static TweetDTO toDTO(Tweet tweet) {

		Date myDate = Date.from(tweet.getDateTime());
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		String formattedDateTime = formatter.format(myDate);

		return new TweetDTO(tweet.getId(), tweet.getAuthor(), tweet.getMessage(), formattedDateTime);
	}

	public static Tweet toEntity(TweetDTO tweetDTO) {

		SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date myDate;

		try {

			myDate = formatter.parse(tweetDTO.getDateTime());
			return new Tweet(tweetDTO.getAuthor(), tweetDTO.getMessage(), myDate.toInstant());

		} catch (ParseException e) {

			log.error(e.getMessage());

		}

		return null;
	}
}
