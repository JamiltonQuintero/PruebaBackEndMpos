package com.mpos.prueba.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UtilDate {
		
	public Date getCurrentDate() {
		   LocalDateTime now = LocalDateTime.now();
		   return java.util.Date
				      .from(now.atZone(ZoneId.systemDefault())
				      .toInstant());
	}

}
