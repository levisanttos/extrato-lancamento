package br.com.resource.desafiocielo.desafiocielo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {
	
	public static final String converteCalendarParaString(Calendar data) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = simpleDateFormat.format(data.getTime());
		return dataFormatada;
	}

}
