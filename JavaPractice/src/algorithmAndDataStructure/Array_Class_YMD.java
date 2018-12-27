/**
 * 
 */
package algorithmAndDataStructure;

import java.util.Calendar;

/**
 * 『新明解 Javaで学ぶアルゴリズムとデータ構造』 第二章 「配列_クラスの配列」 演習問題 問11 西暦年月日をフィールドとして持つクラスを作成
 * 
 * @author owner
 *
 */

public class Array_Class_YMD {
	int year;
	int month;
	int day;
	int[][] mdays = {
			// 平年
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			// うるう年
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };
	int[] myears = { 365, 366 };

	public Array_Class_YMD(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * 問11 n日後の年月日を返却するメソッド
	 * 
	 * @author owner
	 *
	 */
	public Array_Class_YMD after(int n) {
		// 月をまたがない場合
		if ((this.day + n) < mdays[isLeap(this.year)][this.month - 1]) {
			this.day += n;
			return this;
		}
		// 月をまたぐ場合
		// 今月初めから見て、何日後か
		int remainDays = n + this.day;

		while (remainDays > mdays[isLeap(this.year)][this.month - 1]) {
			remainDays -= mdays[isLeap(this.year)][this.month - 1];
			this.month += 1;
			if (this.month == 13) {
				this.month = 1;
				this.year += 1;
			}
		}
		;

		this.day = remainDays;
		return this;
	}

	/**
	 * 問11 n日前の年月日を返却するメソッド
	 * 
	 * @author owner
	 *
	 */
	//なぜ不正解？
	public Array_Class_YMD before(int n) {
		// 月をまたがない場合
		if (this.day - n > 0) {
			this.day -= n;
			return this;
		}
		// 月をまたぐ場合
		// 今月初めから見て、何日前か
		int remainDays = n - this.day;
		while (remainDays - mdays[isLeap(this.year)][this.month-1] > 0) {

			remainDays -= mdays[isLeap(this.year)][this.month-1];
			this.month -= 1;
			if (this.month == 0) {
				this.month = 12;
				this.year -= 1;
			}
		}
		;
		this.day = remainDays;
		return this;
	}
	
//	問11　解答例
/*	   //--- n日前の日付を返す ---//
	   YMD before(int n) {
	      YMD temp = new YMD(this.y, this.m, this.d);
	      if (n < 0)
	         return (after(-n));

	      temp.d -= n;

	      while (temp.d < 1) {
	         if (--temp.m < 1) {
	            temp.y--;
	            temp.m = 12;
	         }
	         temp.d += mdays[isLeap(temp.y)][temp.m - 1];
	      }
	      return temp;
	   }*/

	/**
	 * オリジナル 現在との日付差を返却するメソッド
	 * 
	 * @author owner
	 *
	 */

	public int dateDifference() {
		Calendar cal = Calendar.getInstance();
		int systemY = cal.get(Calendar.YEAR);
		int systemM = cal.get(Calendar.MONTH) + 1;
		int systemD = cal.get(Calendar.DATE);
		int differenceDays = 0;

		// 引数が現在より前の年の場合
		if (this.year < systemY) {
			differenceDays = leftDayOfYear(this.year, this.month, this.day) + dayOfYear(systemY, systemM, systemD);
			for (int i = this.year + 1; i < systemY; i++) {
				differenceDays += myears[isLeap(i)];
			}
		}
		// 引数が現在と同じ年の場合
		if (this.year == systemY) {
			differenceDays = leftDayOfYear(this.year, this.month, this.day) - leftDayOfYear(systemY, systemM, systemD);
			if (differenceDays < 0) {
				differenceDays = -differenceDays;
			}
		}
		// 引数が現在より後の年の場合
		if (this.year > systemY) {
			differenceDays = leftDayOfYear(systemY, systemM, systemD) + dayOfYear(this.year, this.month, this.day);
			for (int i = systemY + 1; i < this.year; i++) {
				differenceDays += myears[isLeap(i)];
			}
		}
		return differenceDays;
	}

	/**
	 * うるう年判定メソッド うるう年:1/平年:0を返却
	 * 
	 * @author owner
	 *
	 */

	int isLeap(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return 1;
		}
		return 0;
	}

	/**
	 * ある年の残り日数を返却するメソッド
	 * 
	 * @author owner
	 *
	 */

	int leftDayOfYear(int y, int m, int d) {
		// m月の残り日数
		int days = mdays[isLeap(y)][m - 1] - d;
		for (int i = 11; i >= m; i--) {
			days += mdays[isLeap(y)][i];
		}
		return days;
	}

	/**
	 * ある年の経過日数を返却するメソッド
	 * 
	 * @author owner
	 *
	 */

	int dayOfYear(int y, int m, int d) {
		int month = 0;
		while (month < m - 1) {
			d += mdays[isLeap(y)][month];
			month++;
		}
		return d;
	}
}
