package com.aula.udemy.cursoudemy.controller.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	private URL() {
		super();
	}
	
	public static String decodeParam(String parametro) {
		try {
			return URLDecoder.decode(parametro, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static List<Integer> decodeIntList(String idsString){
		String[] vetorStrings = idsString.split(",");
		List<Integer> listaIdsInteiros = new ArrayList<>();
		for(String id : vetorStrings) {
			listaIdsInteiros.add(Integer.parseInt(id));
		}
		return listaIdsInteiros;
	}

}
