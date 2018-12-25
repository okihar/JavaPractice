package algorithmAndDataStructure;

import java.util.Scanner;

/**
 * 『新明解 Javaで学ぶアルゴリズムとデータ構造』 
 * 第二章 「配列-多次元配列」演習問題 
 * 
 * @author owner
 *
 */

public class Array2D_DayOfYear {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int retry;
		System.out.println("年内の経過日数を求めます");
		do {
			System.out.println("年:"); int year=stdIn.nextInt();
			System.out.println("月:"); int month=stdIn.nextInt();
			System.out.println("日:"); int day=stdIn.nextInt();
			System.out.printf("年内で%d日目です。\n",dayOfYear(year,month,day));
			System.out.printf("年内残り日数は%d日です。\n",leftDayOfYear(year,month,day));
			System.out.printf("年内残り日数は%d日です。\n",leftDayOfYear2(year,month,day));
			System.out.println("もう一度しますか？YES:1/NO:0");retry=stdIn.nextInt();
		}while(retry==1);
	}
	
	static int[][] mdays= {
			//平年
			{31,28,31,30,31,30,31,31,30,31,30,31},
			//うるう年
			{31,29,31,30,31,30,31,31,30,31,30,31}
	};
	
	static int isLeap(int year) {
		if(year%4==0&&year%100!=0||year%400==0) {
			return 1;
		}
		return 0;
	}
	//問8 y年m月d日の年内経過日数を求める
	static int dayOfYear(int y,int m,int d) {
		int month=0;
			while(month<m-1) {
				d+=mdays[isLeap(y)][month];
				month++;
			}
			return d;
	}
	
	//問9 y年m月d日の残り日数を求めるメソッドの作成(さぼり)
	static int leftDayOfYear(int y,int m,int d) {
		int days=dayOfYear(y,m,d);
		int isLeap=isLeap(y);
		if(isLeap==1) {
			return 366-days;
		}else {
			return 365-days;
		}
	}
	
	//問9 y年m月d日の残り日数を求めるメソッドの作成(真面目)
	static int leftDayOfYear2(int y,int m,int d) {
		//m月の残り日数
		int days=mdays[isLeap(y)][m-1]-d;
		for(int i=11;i>=m;i--) {
			days +=mdays[isLeap(y)][i];
		}
		return days;
	}
}
