package com.example.recurso;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;

public class Servicee extends Service{

	int id1[]=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
			21,22,23,24,25,26,27,28,29,30,31};
String english1[]=new String[]{"one","two","three","four","five","six","seven","eight","nine","ten",
						"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
						"good morning","good afternoon","good evening","good night","thank you","sorry","welcome","hello","good day","good",
						"bad","boy","the boy","man","the man","sir","the sir","father","the father","brother",
						"the brother","uncle","the uncle","grandfather","the grandfather","grandpa","the grandpa"};
int temp_in_db=47;
SQLiteDatabase db;
Cursor c;
	

public int onStartCommand(Intent intent, int flags, int startId) {
	
	add_germany();
	add_french();				
	add_italian();				
	
	add_German_People1();
	
	return 0;
  
 }

	private void add_German_People1() {
	
		int typ1[]=new int[]{4,2,3,1};

		String english1[]=new String[]{"aa01aa02aa03aa04","zwei","drei","one"};
		
		String german1[]=new String[]{"2","two","drei","eins"};
		
		String sentence1[]=new String[]{"select the boy","convert given word to english","type what you hear","convert given word to german"};

		int status1[]=new int[]{0,0,0,0};
		
		
		
		db = openOrCreateDatabase("WORDS", MODE_PRIVATE, null);
		try
		{
		db.execSQL("create table German_People1(_id integer primary key autoincrement,typ number(1) ,english varchar2(30) ,German varchar2(30) ,sentence varchar2(100),status number(1))");
		}
		catch(Exception e)
		{
		}
	
		c=db.query("German_People1", null, null, null, null, null, null);
		if(c.getCount()==0)
		{
			for(int j=0;j<4;j++)
			{
				
				int typ=typ1[j];
				String english=english1[j ];
				String german=german1[j];
				String sentence=sentence1[j];
				int status=status1[j];
				db.execSQL("insert into German_People1 (typ,english,German,sentence,status)values("+typ+",'"+english+"','"+ german + "','"+sentence+"',"+status+")");
			}
		}
		c.close();
		db.close();
	
		
		
		
		
	
}

	public void add_germany()
	{
		
		String germany1[]=new String[]{"eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun","zehn",
										"elf","zwölf","dreizehn","vierzehn","fünfzehn","sechszehn","siebzehn","achtzehn","neunzeh","zwanzig",
										"Guten Morgen","Guten Tag","Guten Abend","gute Nacht","danke","traurig","willkommen","Hallo","guten Tag","gut",
										"schlecht","Junge","der Junge","Mann","der Mann"," Herr","der Herr","Vater","der Vater","Bruder",
										"der Bruder"," Onkel","der Onkel","Großvater","der Großvater","Opa","der Opa"};
		
		String sentence1[]=new String[]{"eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun","zehn",
				"elf","zwölf","dreizehn","vierzehn","fünfzehn","sechszehn","siebzehn","achtzehn","neunzeh","zwanzig",
				"Guten Morgen","Guten Tag","Guten Abend","gute Nacht","danke","traurig","willkommen","Hallo","guten Tag","gut",
				"schlecht","Junge","der Junge","Mann","der Mann"," Herr","der Herr","Vater","der Vater","Bruder",
				"der Bruder"," Onkel","der Onkel","Großvater","der Großvater","Opa","der Opa"};
		
		db = openOrCreateDatabase("WORDS", MODE_PRIVATE, null);
		try
		{
		db.execSQL("create table German(_id integer primary key autoincrement ,english varchar2(30) ,German varchar2(30) ,sentence varchar2(200))");
		}
		catch(Exception e)
		{
		}
	
		c=db.query("German", null, null, null, null, null, null);
		if(c.getCount()==0)
		{
			for(int j=0;j<temp_in_db;j++)
			{
				
				String english=english1[j];
				String germany=germany1[j];
				String sentence=sentence1[j];
				db.execSQL("insert into German (english,German,sentence)values('"+english+"','"+ germany + "','"+sentence+"')");
			}
		}
		c.close();
		db.close();
	
		
	}

	public void add_french()
	{
		
		String french1[]=new String[]{"un","deux","trois","quatre","cinq","six","sept","huit","neuf","dix",
									"onze","douze","treize","quatorze","quinze","seize","dix sept","dix huit","dix neuf","vingt",
									"Bonjour","Bon apres midi","Bonsoir","bonne nuit","merci","Désolé","accueil","Bonjour","bonne journée","bon",
									"mauvais","garçon","le garçon","homme","l`homme","monsieur","le monsieur","père","le père","frère",
									"le frère","oncle","l`oncle","grand-père","le grand-père","grand-père","le grand-père"};
		
		String sentence1[]=new String[]{"un","deux","trois","quatre","cinq","six","sept","huit","neuf","dix",
				"onze","douze","treize","quatorze","quinze","seize","dix sept","dix huit","dix neuf","vingt",
				"Bonjour","Bon apres midi","Bonsoir","bonne nuit","merci","Désolé","accueil","Bonjour","bonne journée","bon",
				"mauvais","garçon","le garçon","homme","l`homme","monsieur","le monsieur","père","le père","frère",
				"le frère","oncle","l`oncle","grand-père","le grand-père","grand-père","le grand-père"};
		
		db = openOrCreateDatabase("WORDS", MODE_PRIVATE, null);
		try
		{
		db.execSQL("create table French(_id integer primary key autoincrement,english varchar2(30),French varchar2(30),sentence varchar2(200))");
		}
		catch(Exception e)
		{
		}
	
		c=db.query("French", null, null, null, null, null, null);
		if(c.getCount()==0)
		{
			for(int j=0;j<temp_in_db;j++)
			{
				
				String english=english1[j];
				String french=french1[j];
				String sentence=sentence1[j];
				
				db.execSQL("insert into French (english,French,sentence)values('"+english+"','"+ french + "','" +sentence+ "')");
			}
		}
		c.close();
		db.close();
	
		
	}
		
	public void add_italian()
	{
		
		
		
		String italian1[]=new String[]{"uno","due","tre","quattro","cinque","sei","sette","otto","nove","dieci",
						"undici","dodici","tredici","quattordici","quindici","sedici","diciassett","diciotto","diciannove","venti",
						"Buon giorno","Buon pomeriggio","Buona sera"," Buona notte","Grazie","scusate","benvenuto","ciao","buongiorno","buono",
					"male","ragazzo","il ragazzo","uomo","l`uomo","signore","il sir","padre","il padre","fratello",
					"il fratello","zio","lo zio","nonno","il nonno","nonno","il nonno"};

		String sentence1[]=new String[]{"uno","due","tre","quattro","cinque","sei","sette","otto","nove","dieci",
				"undici","dodici","tredici","quattordici","quindici","sedici","diciassett","diciotto","diciannove","venti",
				"Buon giorno","Buon pomeriggio","Buona sera"," Buona notte","Grazie","scusate","benvenuto","ciao","buongiorno","buono",
			"male","ragazzo","il ragazzo","uomo","l`uomo","signore","il sir","padre","il padre","fratello",
			"il fratello","zio","lo zio","nonno","il nonno","nonno","il nonno"};
		
		db = openOrCreateDatabase("WORDS", MODE_PRIVATE, null);
		try
		{
		db.execSQL("create table Italian(_id integer primary key autoincrement,english varchar2(30),Italian varchar2(30),sentence varchar2(200))");
		}
		catch(Exception e)
		{
		}
	
		c=db.query("Italian", null, null, null, null, null, null);
		if(c.getCount()==0)
		{
			for(int j=0;j<temp_in_db;j++)
			{
				
				String english=english1[j];
				String italian=italian1[j];
				String sentence=sentence1[j];
				
				db.execSQL("insert into Italian (english,Italian,sentence)values('"+english+"','"+ italian + "','"+sentence+"')");
			}
		}
		c.close();
		db.close();
	
		
	}

	

	
	
	
	
	
	
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		
			
		return null;
	}

	
}
