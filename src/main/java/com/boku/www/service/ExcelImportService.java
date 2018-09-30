package com.boku.www.service;

import java.io.File;
import java.io.InputStream;

public interface ExcelImportService {
	public String importExcel(File file, String fileName) throws Exception;
}
