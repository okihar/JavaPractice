/**
 * 
 */
package searching;

import java.util.Scanner;

/**
 * 
 * 『新明解 Javaで学ぶデータ構造とアルゴリズム』 第三章 「探索_二分探索」
 * 
 * @author owner
 *
 */
public class BinSearch {

	/**
	 * 配列aの先頭n個の要素からkeyと一致する要素を二分探索
	 * 
	 * @param args
	 */
	static int binSearch(int[] a, int n, int key) {
		// 探索範囲 先頭と末尾
		int pl = 0;
		int pr = n - 1;

		do {
			int pc = (pl + pr) / 2;
			if (a[pc] == key) {
				return pc;
			} else if (a[pc] < key) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
		} while (pl <= pr);
		return -1;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);

		System.out.print("要素数:");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		System.out.println("昇順に入力してください");

		System.out.println("x[0]:");
		x[0] = stdIn.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.println("x[" + i + "]:");
				x[i] = stdIn.nextInt();
			} while (x[i] < x[i - 1]);
		}

		System.out.println("探す値:");
		int ky = stdIn.nextInt();
		int idx = binSearch(x,num, ky);

		if (idx == -1) {
			System.out.println("その値は存在しません");
		} else {
			System.out.println("その値はx[" + idx + "]にあります。");
		}

	}

}
