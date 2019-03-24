package com.edwin.backendquiro.models.service;
import java.io.File;
import java.util.Locale;

public interface IFacturaService {
	
	public File getPdfFacturas(Locale locale, Long id) throws Exception;

}
