package algorithmAndDataStructure;

import java.util.Scanner;

/**
 * 『新明解 Javaで学ぶアルゴリズムとデータ構造』 第二章 「配列-基数変換」 演習問題
 * 
 * @author owner
 *
 */

public class ArrayCardNo {

	// 整数値１ｘをr進数にして配列dに下位桁から格納して桁数を返却
	public static int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);
		return digits;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		// 変換する基数,基数,変換後の桁数,もう一度？
		int no, cd, dno, retry;
		char[] cno = new char[32];
		System.out.println("10進数を基数変換します");
		do {
			do {
				System.out.print("変換する非負の整数：");
				no = stdIn.nextInt();
			} while (no < 0);

			do {
				System.out.print("何進数に変換しますか(2-36):");
				cd = stdIn.nextInt();
			} while (cd < 2 || cd > 36);
			dno = cardConvProcess(no, cd, cno);

			// //上位桁から表示
			// System.out.print(cd+"進数では");
			// for(int i=dno-1;i>=0;i--) {
			// System.out.print(cno[i]);
			// }
			System.out.print(cd + "進数では");
			for (int i = 0; i < dno; i++) {
				System.out.print(cno[i]);
			}
			System.out.println("");
			System.out.println("もう一度しますか?(YES:1/NO:0）");
			retry = stdIn.nextInt();
		} while (retry == 1);
	}

	// 50p 問6 配列の先頭側に上位桁を格納するメソッド
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);

		// なぜダメ？
		// →charを宣言した時点で32個分の領域が確保される。そのため、d.lengthは32となってしまうため?
		// for(int idx=0;idx<d.length/2;idx++) {
		// char t=d[idx];
		// d[idx]=d[d.length-idx-1];
		// d[d.length-idx-1]=t;
		// }

		for (int idx = 0; idx < digits / 2; idx++) {
			char t = d[idx];
			d[idx] = d[digits - idx - 1];
			d[digits - idx - 1] = t;
		}
		return digits;
	}

	// 問7 基数変換の過程も表示する
	static int cardConvProcess(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			System.out.print(r + "|" + x);
			System.out.println("・・・" + x % r);
			System.out.println(" +-----");
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);
		
		for (int idx = 0; idx < digits / 2; idx++) {
			char t = d[idx];
			d[idx] = d[digits - idx - 1];
			d[digits - idx - 1] = t;
		}
		return digits;
	}

}
