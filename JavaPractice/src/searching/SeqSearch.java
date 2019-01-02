/**
 * 
 */
package searching;

import java.util.Scanner;

/**
 * 『新明解 Javaで学ぶデータ構造とアルゴリズム』 第三章 「探索_線形探索」
 * 
 * @author owner
 *
 */
public class SeqSearch {

	/**
	 * 線形探索 基本例 →2つの条件を繰り返してしまう
	 * 
	 * @param args
	 */

	static int seqSearch(int[] a, int key) {
		int i = 0;
		while (true) {
			if (i == a.length) {
				return -1;
			}
			if (a[i] == key) {
				return i;
			}
			i++;
		}
	}

	/**
	 * 線形探索 for文 演習3-1
	 * 
	 * @param args
	 */
	static int seqSearchFor(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		// 探索に失敗
		return -1;
	}

	/**
	 * 線形探索 走査過程を表示 
	 * 演習3-2
	 * 
	 * @param args
	 */
	static int SeqSearchProcess(int[] a, int n, int key) {

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

		for (int i = 0; i < a.length; i++) {

			System.out.print("   |");
			System.out.print("   ");

			for (int j = 1; j <= i; j++) {
				System.out.print("    ");
			}
			System.out.println("*");
			System.out.print("  " + i);
			System.out.print("|");
			for (int odr = 0; odr < n; odr++) {
				System.out.printf("%4d", a[odr]);
			}
			System.out.println("");
			if (a[i] == key) {
				return i;
			}
		}
		// 探索に失敗
		return -1;
	}

	/**
	 * 線形探索 番兵法(sentinel) (mainメソッドで配列を宣言する際、+1する必要) 
	 * →探索するキー値と同じ値を末尾要素に格納
	 * →探索失敗することがなくなる →繰り返しの終了判定を1つにできる 
	 * →(whileではなく、for文で書いてしまうと関係ない?)
	 * 
	 * @param args
	 */

	static int seqSearchSen(int[] a, int key) {
		int i = 0;
		a[a.length - 1] = key;

		while (true) {
			if (a[i] == key) {
				break;
			}
			i++;
		}

		if (i == a.length) {
			// 番兵を見つけた場合
			return -1;
		} else {
			return i;
		}

	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("要素数:");
		int num = stdIn.nextInt();

		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.println("x[" + i + "]:");
			x[i] = stdIn.nextInt();
		}

		System.out.println("探す値:");
		int ky = stdIn.nextInt();
		int idx = SeqSearchProcess(x, num, ky);

		if (idx == -1) {
			System.out.println("その値は存在しません");
		} else {
			System.out.println("その値はx[" + idx + "]にあります。");
		}
	}

}
