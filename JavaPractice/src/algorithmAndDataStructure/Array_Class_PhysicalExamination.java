/**
 * 
 */
package algorithmAndDataStructure;

import java.util.Scanner;

/**
 * 『新明解 Javaで学ぶアルゴリズムとデータ構造』 第二章 「配列_クラスの配列」 演習問題
 * 
 * @author owner
 *
 */
public class Array_Class_PhysicalExamination {

	static final int VMAX = 21;

	static class PhyscData {
		String name;
		int height;
		double vision;

		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
	}

	static double aveHeight(PhyscData[] dat) {
		double sum = 0;

		for (int i = 0; i < dat.length; i++) {
			sum += dat[i].height;
		}
		return sum / dat.length;
	}

	static void distVision(PhyscData[] dat, int[] dist) {
		int i = 0;
		dist[i] = 0;
		for (i = 0; i < dat.length; i++) {
			if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
				dist[(int) (dat[i].vision * 10)]++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		PhyscData[] x = { new PhyscData("月正日", 110, 0.2), new PhyscData("火正日", 120, 0.4),
				new PhyscData("水正日", 140, 0.5), new PhyscData("木正日", 160, 1.0), new PhyscData("金正日", 230, 2.0),
				new PhyscData("土正日", 230, 2.0), new PhyscData("日正日", 230, 0.5), };
		int[] vdist = new int[VMAX];

		System.out.println("身体検査一覧表");
		System.out.println("氏名　　　　　　身長　視力");
		System.out.println("-------------------");

		for (int i = 0; i < x.length; i++) {
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
		}
		System.out.printf("\n平均身長:%5.1fcm\n", aveHeight(x));

		distVision(x, vdist);
		// 問10 視力の分布をグラフで出力
		System.out.println("\n視力の分布");
		for (int i = 0; i < VMAX; i++) {
			System.out.printf("%3.1f～:", i / 10.0, vdist[i]);
			for (int star = 0; star < vdist[i]; star++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
