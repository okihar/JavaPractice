/**
 * 
 */
package stack;

import java.util.EmptyStackException;

/**
 * 『新・明解 Javaで学ぶアルゴリズムとデータ構造』 第四章 スタックとキュー_スタック
 *
 * @author okihar
 *
 */
public class IntStack {
	// スタックの容量=stkの要素数
	private int max;
	// スタックのポインタ=スタックに積まれているデータの個数
	private int ptr;
	// スタックの本体(を参照する配列変数)
	private int[] stk;

	// 実行時例外：スタックが空
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// 実行時例外:スタックが満杯
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// コンストラクタ
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			// スタック本体用の配列を生成
			stk = new int[max];
		} catch (OutOfMemoryError e) {
			// 生成できなかった
			max = 0;
		}
	}

	// スタックにxをプッシュ
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= max) {
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x;
	}

	// スタックからデータをポップ
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) {
			throw new EmptyStackException();
		}
		return stk[--ptr];
	}

	// スタックからデータをピーク（覗き見
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr - 1];
	}

	// スタックからxを探してインデックス（見つからなければ-1)を探す
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x) {
				return i;
			}
		}
		return -1;
	}

	// スタックを空にする
	public void clear() {
		ptr = 0;
	}

	// スタックの容量を返す
	public int capacity() {
		return max;
	}

	// スタックに積まれているデータ数を返す
	public int size() {
		return ptr;
	}

	// スタック派からであるか
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	//スタックは満杯か
	public boolean isFull() {
		return ptr >= max;
	}
	
	//スタック内の全データを底→頂上の順に表示
	public void dump() {
		if(ptr <= 0) {
			System.out.println("スタックは空です");
		}else {
			for(int i=0;i<ptr;i++) {
				System.out.print(stk[i]+" ");
			}
			System.out.println();
		}
	}
}
