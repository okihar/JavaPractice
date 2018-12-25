package algorithmAndDataStructure;

/**
 * 『新明解 Javaで学ぶアルゴリズムとデータ構造』 
 * 第二章 「配列-素数」
 * 
 * @author owner
 *
 */

public class ArrayPrimeNumber {

	// ある整数nは2からn-1までのいずれの素数でも割り切れない場合、素数である
	public static void main(String[] args) {
		int counter = 0;
		int ptr = 0;
		// 偶数は素数ではないので、少なくとも500個分の領域を確保
		int[] prime = new int[500];
		prime[ptr++] = 2;
		for (int n = 3; n <= 1000; n += 2) {
			int i;
			for (i = 1; i < ptr; i++) {
				counter++;
				if (n % prime[i] == 0) {
					break;
				}
			}
			if (ptr == i) {
				prime[ptr++] = n;
			}
		}
		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		System.out.println("除算を行った回数" + counter);
	}

	// ある整数nは、nの平方根以下のいずれの素数でも割り切れない場合、素数である
	// ⇒prime[i]^2<=n
	static void PrimeNumber2() {
		int counter = 0;
		int ptr = 0;
		int[] prime = new int[500];
		// 偶数の素数は2だけなので、例外。i=1から回す
		prime[ptr++] = 2;
		prime[ptr++] = 3;

		for (int n = 5; n <= 1000; n += 2) {
			boolean flag = false;
			for (int i = 1; prime[i] * prime[i] <= n; i++) {
				counter += 2;
				if (n % prime[i] == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				prime[ptr++] = n;
				counter++;
			}
		}

		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		System.out.println("乗除算を行った回数" + counter);
	}
}
