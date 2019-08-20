package com.boku.www.service;

public interface ImportService {
	public void readCiwFilesToList(String txtDirPath) throws Exception;
	public void insertJcrAndJournal() throws Exception;
	public void insertAreaCompanyId() throws Exception;
}
