/**
 * 
 */
package stack;

import java.util.Scanner;

/**
 * 『新・明解 Javaで学ぶアルゴリズムとデータ構造』<br>
 * 第四章 スタックとキュー スタック<br>
 *
 * @author okihar
 *
 */
public class IntStackTester {

	/**
	 * スタッククラスIntStackを利用するプログラム<br>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);

		while (true) {
			System.out.println("現在のデータ数:" + s.size() + "/" + s.capacity());
			System.out.print("(1)プッシュ(2)ポップ(3)ピーク(4)ダンプ(5)スタックを空にする(6)スタックの容量を確認する(7)スタックが空か確認(8)スタックが満タンか確認(0)終了");
			int menu = stdIn.nextInt();
			if (menu == 0) {
				break;
			}

			int x;
			switch (menu) {
			case 1:
				System.out.println("データ：");
				x = stdIn.nextInt();
				try {
					s.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("スタックが満杯です");
				}
				break;

			case 2:
				try {
					x = s.pop();
					System.out.println("ポップしたデータは" + x + "です。");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("スタックが空です");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("ピークしたデータは" + x + "です。");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("スタックが空です");
				}
				break;
			case 4:
				s.dump();
				break;
				//演習問題4-1 使用していないメソッドを利用
			case 5:
				try {
					s.clear();
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("スタックが空です");
				}
				break;
			case 6:
				System.out.println("スタックの容量は"+s.capacity()+"です。");
				break;
			case 7:
				if(s.isEmpty()) {
					System.out.println("スタックは空です");
					break;
				}
				System.out.println("スタックは空ではありません");
				break;
			case 8:
				if(s.isFull()) {
					System.out.println("スタックは満杯です");
				}
				System.out.println("スタックは満杯ではありません");
				break;
			}
		}
	}
}
