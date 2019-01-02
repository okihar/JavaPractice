/**
 * 
 */
package stack;

/**
 * 『新・明解 Javaで学ぶアルゴリズムとデータ構造』<br>
 * 第四章 スタックとキュー_スタック 演習問題4-2<br>
 * 任意のオブジェクト型のデータを蓄えることできるジェネリックなスタッククラスを作成せよ
 * 
 * @author okihar<br>
 *
 */
public class Gstack<E> {
	private int max;
	private int ptr;
	private E[] stk;

	// コンストラクタ
	public Gstack(int capacity) {
		this.max = capacity;	
		this.ptr = 0;
		try {
			this.stk = (E[]) new Object[max]; 
		} catch (OutOfMemoryError e) {
			this.max = 0;
		}
	}
}
