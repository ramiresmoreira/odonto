package br.edu.ifce.odonto.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.ifce.odonto.adapter.LocalDateAdapter;
import br.edu.ifce.odonto.adapter.LocalTimeAdapter;

public class GsonUtil {
	
	public static Gson getGson(){
		return new GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(LocalDateTime.class, new LocalTimeAdapter())
        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
        .create();
	}
}
