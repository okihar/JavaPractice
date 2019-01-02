
package searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 『新明解Javaで学ぶアルゴリズムとデータ構造』 
 * 第三章　探索＿二分探索 自然な順序でない配列からの探索
 * （自然な順序　natural ordering＝整数の昇順、アルファベットの昇順、日付の古→新など。
 * 自然な順序付けをしたければ　ComparableIFを実装し、compareToメソッド、equalsメソッド
 * を実装するのが定石。)
 * 
 * @author owner
 *
 */
public class PhysExamSearch {

	/**
	 * 身体検査データ
	 * 
	 * @param args
	 */
	static class PhyscData {
		private String name;
		private int height;
		private double vision;

		// コンストラクタ
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		// 文字列化
		public String toString() {
			return name + " " + height + " " + vision;
		}

		// 身長昇順用コンパレータ
		//→二分探索のジェネリクスメソッドは配列内の要素がどのような並びで大小関係をどのように判定すべきなのか分からない
		//→コンパレータで大小関係を判定し、引数として渡す
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				if (d1.height > d2.height) {
					return 1;
				} else if (d1.height < d2.height) {
					return -1;
				} else {
					return 0;
				}
			}
		}

		// 視力降順用コンパレータ
		public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

		private static class VisionOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				if (d1.vision < d2.vision) {
					return 1;
				} else if (d1.vision > d2.vision) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

	/**
	 * メインメソッド 身長の昇順に並んでいるデータからある特定の身長の人を探索
	 * 
	 * 演習3-7 視力の降順に並んでいる身体検査データからある特定の視力の人を探索
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		PhyscData[] x = { new PhyscData("今岡誠", 162, 3.0), new PhyscData("赤星憲広", 168, 2.6),
				new PhyscData("片岡篤志", 169, 2.4), new PhyscData("アリアス", 171, 2.1), new PhyscData("金本知憲", 172, 1.8),
				new PhyscData("矢野輝弘", 174, 0.3), new PhyscData("濱中おさむ", 210, 0.1), };
		System.out.println("視力いくつの人を探しますか");
		double vision = stdIn.nextDouble();
		
		//第一引数と第二引数を比較、コンパレーターにより第一引数のほうが大きければ負、小さければ正
		//【注意】二分探索なので
		int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);

		if (idx < 0) {
			System.out.println("その値の要素は存在しません");
		} else {
			System.out.println("その値はx[" + idx + "]にあります");
			System.out.println("データ：" + x[idx]);
		}
	}
}
