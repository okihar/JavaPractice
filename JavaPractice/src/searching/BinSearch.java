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
	 * メインメソッド
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);

		System.out.print("要素数:");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		int[] index = new int[num];
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
		int idx = binsearchProcess(x, num, ky);

		if (idx == -1) {
			System.out.println("その値は存在しません");
		} else {
			System.out.println("その値はx[" + idx + "]にあります。");
		}
	}

	/**
	 * 演習3-3 要素数がnである配列aからkeyと一致する全要素のインデックスを、配列idxの先頭から 順に格納し、一致した要素数を返却するメソッド
	 * 
	 * @param args
	 */
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == key) {
				idx[counter] = i;
				counter++;
			}
		}
		return counter;
	}

	/**
	 * 演習3-4 二分探索 過程を表示
	 * 
	 * @param args
	 */

	static int binsearchProcess(int[] a, int n, int key) {
		// 表の型つくり
		System.out.print("   |");
		for (int i = 0; i < n; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();
		System.out.print("---+");
		for (int i = 0; i < n; i++) {
			System.out.print("----");
		}
		System.out.println("");

		// 探索範囲 先頭と末尾
		int pl = 0;
		int pr = n - 1;

		System.out.print("   |");
		System.out.print("  ");
		do {
			int pc = (pl + pr) / 2;
			// 探索範囲左端
			for (int leftSpace = 0; leftSpace < pl; leftSpace++) {
				System.out.print("    ");
			}
			System.out.print("<-");

			// 選択範囲中央
			for (int centerSpace = 0; centerSpace < pc - pl; centerSpace++) {
				System.out.print("    ");
			}
			System.out.print("+");

			// 選択範囲左端
			for (int rightSpace = 0; rightSpace < pr - pc; rightSpace++) {
				System.out.print("    ");
			}
			System.out.println("->");

			System.out.print("  " + pc + "|");

			// 配列要素
			for (int i = 0; i < n; i++) {
				System.out.printf("%4d", a[i]);
			}
			System.out.println("");

			System.out.print("   |");

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
	 * 演習3-5 
	 *  二分探索 探索すべきキー値と同じ値を持つ要素が複数存在する場合に
	 *  最も先頭側に位置する要素のインデックスを返却するメソッド
	 * →間違い、連続していない場合を考えていなかった
	 * @param args
	 */

	static int binSearchX(int[] a, int n, int key) {

		// 探索範囲 先頭と末尾
		int pl = 0;
		int pr = n - 1;

		do {
			int pc = (pl + pr) / 2;
			if (a[pc] == key) {
				while(a[pc]==a[pc-1]) {
					pc=pc-1;
				}
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
	 * 演習3-5 
	 * 解答例
	 * →解答例もキーが非連続の場合を考えていなかった
	 * @param args
	 */
	  //--- 配列aの先頭n個の要素からkeyと一致する要素を２分探索 ---//
	   static int binSearchXAnser(int[] a, int n, int key) {
	      int pl = 0;            // 探索範囲先頭のインデックス
	      int pr = n - 1;      // 　 〃 　末尾のインデックス

	      do {
	         int   pc = (pl + pr) / 2;   // 中央要素のインデックス
	         if (a[pc] == key) {
	            for ( ; pc > pl; pc--)   // keyと等しい先頭の要素を探す
	               if (a[pc - 1] < key)
	                  break;
	            return pc;               // 探索成功
	         } else if (a[pc] < key)
	            pl = pc + 1;            // 探索範囲を前半に絞り込む
	         else
	            pr = pc - 1;            // 探索範囲を後半に絞り込む
	      } while (pl <= pr);

	      return -1;               // 探索失敗
	   }
}
