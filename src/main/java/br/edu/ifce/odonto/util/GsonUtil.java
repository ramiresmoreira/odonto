package br.edu.ifce.odonto.util;

import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.ifce.odonto.adapter.LocalDateAdapter;

public class GsonUtil {
	
	public static Gson getGson(){
		return new GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
        .create();
	}
}
