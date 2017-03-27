package com.wangpan.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/**
 * DeflaterOutputStream 压缩类的基类
 * InflaterInputStream  解压缩类的基类
 * gzip仅对单个文件进行压缩
 * @author Lucia
 *
 */
public class GZipUtil {
	public static void GZip(String filename) throws FileNotFoundException, IOException{
		GZIPOutputStream gzip=new GZIPOutputStream(new FileOutputStream(filename));

	}
	public static void main(String[] args) {
	}
}
