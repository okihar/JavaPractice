/**
 * 
 */
package algorithmAndDataStructure;

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

	public Array_Class_YMD(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// 問 n日後の日付を返すメソッド作成
	public int YMDafter(int n) {
		if(leftDayOfYear(this.year,this.month,this.day)>n) {
			return null;
		}
		int thisMonth = mdays[isLeap(this.year)][this.month - 1];
	}

	// うるう年:1/平年:0を返却
	int isLeap(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return 1;
		}
		return 0;
	}
	//今年の残り日数
	int leftDayOfYear(int y, int m, int d) {
		// m月の残り日数
		int days = mdays[isLeap(y)][m - 1] - d;
		for (int i = 11; i >= m; i--) {
			days += mdays[isLeap(y)][i];
		}
		return days;
	}

}
