package br.pucminas.api.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.util.StringUtils;

public final class Utils {

	final static DateTimeFormatter FORMAT_PT_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	final static DateTimeFormatter FORMAT_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static Date converterDataLocal(String data) throws Exception {
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		try {
			return Date.valueOf(LocalDate.parse(data, FORMAT_PT_BR));
		} catch (Exception e) {
			try {
				return Date.valueOf(LocalDate.parse(data, FORMAT_EN));
			} catch (Exception ex) {
				throw new Exception(ex.getMessage());
			}
		}
	}

	public static String converterDataLocal(Date data) throws Exception {
		if (data == null) {
			return null;
		}
		try {
			return FORMAT_PT_BR.format(data.toLocalDate());
		} catch (Exception e) {
			try {
				return FORMAT_EN.format(data.toLocalDate());
			} catch (Exception ex) {
				throw new Exception(ex.getMessage());
			}
		}
	}
	
}
