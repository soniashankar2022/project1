package com.vcentry.lab.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class optimizer {

	public static void optimize() throws IOException {
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
		String name=sf.format(date);
		File src=new File("C:\\daily practise  java Vcentry\\G1_ddTest\\screenshot");
		File dst=new File("C:\\daily practise  java Vcentry\\G1_ddTest\\archeive/old_"+name);

		FileUtils.copyDirectory(src, dst);
		FileUtils.cleanDirectory(src);
		
	}
}
