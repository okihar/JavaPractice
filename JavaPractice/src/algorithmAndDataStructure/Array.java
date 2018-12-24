/**
 * 
 */
package algorithmAndDataStructure;

import java.util.Random;
import java.util.Scanner;

/**
 * 『新明解 Javaで学ぶアルゴリズムとデータ構造』 第二章 「配列」 演習問題
 * 
 * @author owner
 *
 */
public class Array {

	public static void main(String[] args) {
		rcopy(question1(), question1());
	}

	// 配列の長さも乱数に
	public static int[] question1() {
		Random rnd = new Random();
		int num = 1 + rnd.nextInt(8);
		int[] height = new int[num];

		for (int i = 0; i < num; i++) {
			height[i] = 100 + rnd.nextInt(90);
			// System.out.println("height["+i+"]:"+height[i]);
		}
		return height;
	}

	// 配列の要素の交換
	static void swap(int[] a, int idx1, int idx2) {
		System.out.println("a[" + idx1 + "]とa[" + idx2 + "]の値を交換します");
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 配列の要素の並びを反転
	static void reverse(int[] a) {
		for (int idx = 0; idx < a.length / 2; idx++) {
			swap(a, idx, a.length - idx - 1);
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println("");
		}
	}

	// 43p配列要素の並びの反転の経過を逐一表示
	public static void question2() {
		int[] a = question1();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		reverse(a);
		System.out.println("反転が終了しました");
		System.out.println("合計は" + sumOf(a));
	}

	// 43p 配列aの全要素の合計値
	public static int sumOf(int[] a) {
		int sum = 0;
		for (int idx = 0; idx < a.length; idx++) {
			sum += a[idx];
		}
		return sum;
	}

	// 問4 配列のコピー
	static void copy(int[] a, int[] b) {
		a = b;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

	// 問5 配列bの全要素を配列aに逆順にコピー
	static void rcopy(int[] a, int[] b) {
		System.out.print("元の配列a:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(+a[i] + " ");
		}
		System.out.println("");
		System.out.print("元の配列b:");
		for (int i = 0; i < b.length; i++) {
			System.out.print(+b[i] + " ");
		}
		System.out.println("");
		reverse(b);
		a = b;
		System.out.print("コピー後の配列a:");
		for (int i = 0; i < b.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		System.out.print("コピー後の配列b:");

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}
}
