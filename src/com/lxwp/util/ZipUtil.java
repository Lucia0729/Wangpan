package com.lxwp.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;



/**
 * 压缩/解压
 * @author Lucia
 *
 */
public class ZipUtil {
	/**
	 * 压缩
	 * @param   zipFileName    压缩产生的zip包文件名--带路径,如果为null或空则默认按文件名生产压缩文件名
	 * @param   fileList      要打包的文件列表(包括路径)
	 * @throws IOException 
	 */
	public static void zip(String zipFileName, List<File> fileList) throws IOException {
		// TODO Auto-generated method stub
		ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFileName));
		for(File file : fileList){
			FileInputStream in=new FileInputStream(file);
			zip.putNextEntry(new ZipEntry(file.getName()));
			byte[] b=new byte[1024];
			int len=0;
			while((len=in.read(b,0,len))>0){
				zip.write(b, 0, len);
			}
			zip.closeEntry();
			in.close();
		}
		if(null!=zip){
			zip.close();
		}
		
	}
	/**
	 * @param zipFilePath
	 *            zip文件路径
	 * @param targetPath
	 *            解压缩到的位置，如果为null或空字符串则默认解压缩到跟zip包同目录跟zip包同名的文件夹下
	 * 解压
	 * @throws IOException 
	 */
	public static void unzip(String zipFilePath, String targetPath) throws IOException {
		// TODO Auto-generated method stub
		//ZipInputStream zip=new ZipInputStream(new FileInputStream(zipFilePath));
		BufferedOutputStream bufferedoutputstream = null;
		InputStream inputstream = null;
		ZipFile zipfile = null;
		try {
			zipfile = new ZipFile(zipFilePath);
		
		String directoryPath = "";
		if(null==targetPath||""==targetPath){
			directoryPath=zipFilePath.substring(0,zipFilePath.lastIndexOf("."));
		}else{
			directoryPath=targetPath;
		}
		Enumeration<? extends ZipEntry>  entryenum=zipfile.entries();
		if(null!=entryenum){
			ZipEntry zipentry=null;
			while(entryenum.hasMoreElements()){
				zipentry=entryenum.nextElement();
				if (zipentry.isDirectory()) {
					directoryPath = directoryPath + File.separator
							+ zipentry.getName();
					System.out.println(directoryPath);
					continue;
				}
				if(zipentry.getSize() > 0){
				File targetFile=buildFile(directoryPath
						+ File.separator + zipentry.getName(),false);
				bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(targetFile));
				 inputstream = zipfile.getInputStream(zipentry);
					byte[] b=new byte[1024];
					int len=0;
					while((len=inputstream.read(b, 0, len))>0){
						
						bufferedoutputstream.write(b, 0, len);
					}
					bufferedoutputstream.flush();
					bufferedoutputstream.close();
				
			    }else{
			    	buildFile(directoryPath + File.separator
							+ zipentry.getName(), true);
				
			    }
			}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (null != zipfile) {
				zipfile = null;
			}
			if (null != inputstream) {
				inputstream.close();
			}
			if (null != bufferedoutputstream) {
				bufferedoutputstream.close();
			}
		}
		 

	}
	/**
     * 生产文件 如果文件所在路径不存在则生成路径
     * 
     * @param fileName
     *            文件名 带路径
     * @param isDirectory 是否为路径
     * @return
     * @author lucia
     * @date 
     */
    public static File buildFile(String fileName, boolean isDirectory) {
        File target = new File(fileName);
        if (isDirectory) {
            target.mkdirs();
        } else {
            if (!target.getParentFile().exists()) {
                target.getParentFile().mkdirs();
                target = new File(target.getAbsolutePath());
            }
        }
        return target;
    }
	public static void main(String[] args) {//C:\Users\Administrator\Desktop\foonsun
//		String path = "C:\\Users\\Administrator\\Desktop\\foonsun\\" + "a_eHRLogo.jpg";
		String path = "C:\\Users\\Administrator\\Desktop\\foonsun";
		
		File file = new File(path);
		List<File> list = new ArrayList<File>();
		list.add(file);
		String mediaZipFileName = "C:\\Users\\Administrator\\Desktop\\"
				+ "2017-03-09" + ".media.zip";
		try {
			//zip(mediaZipFileName, list);
			unzip(mediaZipFileName,path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
}
