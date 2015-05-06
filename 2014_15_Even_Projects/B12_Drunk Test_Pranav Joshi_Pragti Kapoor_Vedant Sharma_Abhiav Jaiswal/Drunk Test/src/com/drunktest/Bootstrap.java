package com.drunktest;

import android.app.Application;

public class Bootstrap extends Application{

	public static String [] questionsArray = new String[6];
	public static String [][] answerOptionsArray = new String[6][4];
	public static int queCount=0;
	public static int [] answers = new int[6];
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		questionsArray[0] = " Difference between no of matchsticks?";
		questionsArray[1] = " How many triangles?";
		questionsArray[2] = " How many differences?";
		questionsArray[3] = " How many numbers can you see?";
		questionsArray[4] = " Which line is longer?";
		questionsArray[5] = " How many pairs of eyes and noses do you see?";
		
		answers[0] = 4;
		answers[1] = 3;
		answers[2] = 2;
		answers[3] = 2;
		answers[4] = 3;
		answers[5] = 2;
		
		answerOptionsArray[0][0] = "a) 2";
		answerOptionsArray[0][1] = "b) 1";
		answerOptionsArray[0][2] = "c) -2";
		answerOptionsArray[0][3] = "d) a & c";
		
		answerOptionsArray[1][0] = "a) 24";
		answerOptionsArray[1][1] = "b) 25";
		answerOptionsArray[1][2] = "c) 26";
		answerOptionsArray[1][3] = "d) 17";
		
		answerOptionsArray[2][0] = "a) 13";
		answerOptionsArray[2][1] = "b) 15";
		answerOptionsArray[2][2] = "c) 12";
		answerOptionsArray[2][3] = "d) 17";
		
		answerOptionsArray[3][0] = "a) 3";
		answerOptionsArray[3][1] = "b) 0";
		answerOptionsArray[3][2] = "c) 4";
		answerOptionsArray[3][3] = "d) 2";
		
		answerOptionsArray[4][0] = "a) A";
		answerOptionsArray[4][1] = "b) B";
		answerOptionsArray[4][2] = "c) Both are equal";
		answerOptionsArray[4][3] = "d) Wrong question";
		
		answerOptionsArray[5][0] = "a) 1 & 2";
		answerOptionsArray[5][1] = "b) 2 & 0";
		answerOptionsArray[5][2] = "c) 4 & 2";
		answerOptionsArray[5][3] = "d) Wrong question";
		
	}
}