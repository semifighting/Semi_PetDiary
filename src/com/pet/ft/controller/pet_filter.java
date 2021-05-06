package com.pet.ft.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.snu.ids.kkma.ma.Eojeol;
import org.snu.ids.kkma.ma.MExpression;
import org.snu.ids.kkma.ma.MorphemeAnalyzer;
import org.snu.ids.kkma.ma.Sentence;
import org.snu.ids.kkma.util.Timer;

import com.google.gson.JsonObject;
import com.pet.ft.model.PetBiz;
import com.pet.ft.model.PetBizImpl;


public class pet_filter {
<<<<<<< HEAD
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		String  a = "존잼탱";
		
		
		System.out.println(maTest(a));


	}
	

//	public List<String> filtering(String str) throws ParseException {
	
//		List<String> list = new ArrayList<String>();
//
//		//메소드구현
//		
//		//input 필터링 Table
//		
//		
//		PetBiz biz = new PetBizImpl();
//		
//		biz.InsertFilter(list);
//		
//		
//		
//		return list;
//	}
	
=======

	public String filtering(String str) {
	
		
		return maTest(str);
	}
	
>>>>>>> main
	public static String maTest(String string){
		int space = 0;
		List<String> badW1 = badwords.badword1();
		HashMap<String, String> badP2 = badwords.badmorpheme1();
		List<String> badW3 = badwords.badword2();
		HashMap<String, String> badP4 = badwords.badmorpheme2();
		List<String> keymap = badwords.Keymap();
<<<<<<< HEAD
=======
		List<String> keymap2 = badwords.Keymap2();
>>>>>>> main

		int count = 0;
		
		for(String word :badW1) {
			while(string.indexOf(word)>=0) {
<<<<<<< HEAD
				string = string.replace(word, "뉩");	
				count++;
			}		
		}
		System.out.println("1단계 체크 :"+count);
		if(count==0) {
			String match = "[^\uAC00-\uD7A3xfea-zA-Z]";
	        String string2 =string.replaceAll(match, "");
	        System.out.println(string2);
=======
				string = string.replace(word, "%%");	
				count++;
			}		
		}
		if(count==0) {
			String match = "[^\uAC00-\uD7A3xfea-zA-Z]";
	        String string2 =string.replaceAll(match, "");
>>>>>>> main
			for(String word :badW1) {
				while(string2.indexOf(word)>=0) {
					string2 = string2.replace(word, "@@");
					count++;
				}		
			}
			System.out.println("1단계 체크/공백 및 특수문자 :"+count);
		}
		
<<<<<<< HEAD
=======

		
		
>>>>>>> main
		try {
			MorphemeAnalyzer ma = new MorphemeAnalyzer();
			ma.createLogger(null);		
			List<MExpression> ret = ma.analyze(string);
			ret = ma.postProcess(ret);
			ret = ma.leaveJustBest(ret);
			List<Sentence> stl = ma.divideToSentences(ret);	
			for(Sentence word : stl) {
				for(Eojeol res : word) {
<<<<<<< HEAD
					System.out.println(res);
=======
>>>>>>> main
						for(String K :keymap) {
							if(count==0) {
								if(res.toString().split("=>")[1].split("/")[1].trim().equals(K)) {
									space = 0;
<<<<<<< HEAD
									try {
										if(res.toString().split("=>")[1].trim().split("/")[2].indexOf(badP2.get(K))>=0) {
											System.out.println(res);
											String builder = string;
											int place = Integer.parseInt(res.toString().split("=>")[1].trim().split("/")[0].replace("[", ""));
											while(!builder.substring(place, place+K.length()).equals(K)) {
												builder = builder.replaceFirst(" ", "");
												space++;
												System.out.println(K);
												System.out.println(builder.substring(place, place+K.length()));
=======
										if(res.toString().split("=>")[1].trim().split("/")[2].indexOf(badP2.get(K))>=0) {
											String builder = string;
											int place = Integer.parseInt(res.toString().split("=>")[1].trim().split("/")[0].replace("[", ""));
											while(!builder.substring(place, place+K.length()).equals(K)) {
												if(builder.substring(place, place+K.length()).equals("존")) {
													break;
												}
												builder = builder.replaceFirst(" ", "");
												space++;
>>>>>>> main
											}					
												
											string = string.substring(0, place+space)+"#"+string.substring(place+space+K.length(), string.length());
											count++;
										}
										
<<<<<<< HEAD
									} catch (NullPointerException e) {
										e.printStackTrace();
									}
=======
>>>>>>> main
								}
								
							}
						}		
						
				}			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		
		
		try {
			MorphemeAnalyzer ma = new MorphemeAnalyzer();
			ma.createLogger(null);		
			List<MExpression> ret = ma.analyze(string);
			ret = ma.postProcess(ret);
			ret = ma.leaveJustBest(ret);
			List<Sentence> stl = ma.divideToSentences(ret);	
			for(Sentence word : stl) {
				for(Eojeol res : word) {
					System.out.println(res);
						for(String K :keymap) {
							if(count==0) {
								if(res.toString().split("=>")[1].split("/")[1].trim().equals(K)) {
									space = 0;
									try {
										if(count>0) {
											if(res.toString().split("=>")[1].trim().split("/")[1].equals(K)) {
												space = 0;
												if(res.toString().split("=>")[1].trim().split("/")[2].indexOf(badP4.get(K))>=0) {											
													String builder = string;
													int place = Integer.parseInt(res.toString().split("=>")[1].trim().split("/")[0].replace("[", ""));
													while(!builder.substring(place, place+K.length()).equals(K)) {
														builder = builder.replaceFirst(" ", "");
														space++;
														System.out.println(1);
														System.out.println(K);
														System.out.println(builder.substring(place, place+K.length()));

													}			
													string = string.substring(0, place+space)+"$"+string.substring(place+space+K.length(), string.length());
													count++;
												}
											}
											
										}
									}catch (Exception e) {
										// TODO: handle exception
									}
								
								}
							}		
						
						}			
					}
				} 
			}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		if(count>0) {
			for(String word :badW3) {
				while(string.indexOf(word)>=0) {
					string = string.replace(word, "*");	
=======

		System.out.println("2단계 체크 :"+count);
		if(count>0) {
			for(String word :badW3) {
				while(string.indexOf(word)>=0) {
					string = string.replace(word, "**");	
>>>>>>> main
					count++;
				}		
			}
			System.out.println("3단계 체크 :"+count);
		}
		
<<<<<<< HEAD
=======
		

		if(count>0) {
			try {
				MorphemeAnalyzer ma = new MorphemeAnalyzer();
				ma.createLogger(null);		
				List<MExpression> ret = ma.analyze(string);
				ret = ma.postProcess(ret);
				ret = ma.leaveJustBest(ret);
				List<Sentence> stl = ma.divideToSentences(ret);	
				for(Sentence word : stl) {
					for(Eojeol res : word) {
						for(String K :keymap2) {
								if(res.toString().split("=>")[1].trim().split("/")[1].equals(K)) {
									space = 0;
									if(res.toString().split("=>")[1].trim().split("/")[2].indexOf(badP4.get(K))>=0) {
										String builder = string;
										int place = Integer.parseInt(res.toString().split("=>")[1].trim().split("/")[0].replace("[", ""));
										while(!builder.substring(place, place+K.length()).equals(K)) {
											if(builder.substring(place, place+K.length()).equals("존")) {
												break;
											}
											builder = builder.replaceFirst(" ", "");
											space++;

										}			
										string = string.substring(0, place+space)+"$"+string.substring(place+space+K.length(), string.length());
										count++;
									}
								}
										
							}
						}		
						
					}			 
				}catch (Exception e) {
				// TODO: handle exception
			}
		}

		System.out.println("4단계 체크:"+count);
		
>>>>>>> main
		return string;	
		}
}
