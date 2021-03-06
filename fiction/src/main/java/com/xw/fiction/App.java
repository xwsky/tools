package com.xw.fiction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
	/***********************************配置项开始*****************************************/

	//文件名
	private static String title = "小说/大宇宙时代.txt";

	//每章节地址前缀
	static String url = "https://www.xxbiquge.com/2_2397/";

	/**********************************配置项结束******************************************/

	public static void main(String[] args) throws InterruptedException {
		try {
			long stime = System.currentTimeMillis();
			//清空文件内容
			clearInfoForFile();
			Document doc = Jsoup.connect(url).get();
			System.out.println("获取列表");
			Elements links = doc.select("a");
			String href = null;
			String content;
			for (Element a:links) {
				href = a.attr("abs:href");
				if(href.endsWith("html")&&href.contains("/2_2397/")){
					System.out.println("写入章节："+a.text());
					writeToFile(a.text());
					//写入内容
					content = getContent(href);
					writeToFile(content);
				}
			}
			long etime = System.currentTimeMillis();
			double useTime = (stime-etime)/1000/60;
			System.out.println("用时："+useTime+" 分钟");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取网页内容
	 * @param url
	 * @return
	 */
	private static String getContent(String url) {
		Document doc=null;
		Element content=null;
		try {
			doc = Jsoup.connect(url).get();
			content = doc.getElementById("content");
			content.html();
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				System.out.println("尝试重新下载章节："+url);
				return getContent(url);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		return content.html().replace("<br>","").replace("&nbsp;&nbsp;&nbsp;&nbsp;", "    ");
	}

	/**
	 * 向文件写入内容
	 * @param s
	 */
	private static void writeToFile(String s) {
		File file = new File(title);
		FileWriter fw = null;
		BufferedWriter writer = null;
		try {
			fw = new FileWriter(file,true);
			writer = new BufferedWriter(fw);
			writer.write(s);
			writer.newLine();//换行
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 创建并清空文件
	 */
	public static void clearInfoForFile() {
		File file =new File(title);
		try {
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter =new FileWriter(file);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
