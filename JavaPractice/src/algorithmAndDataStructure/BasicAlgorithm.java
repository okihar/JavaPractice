/**
 * 
 */
package algorithmAndDataStructure;

/**
 * �w�V�E�����@Java�Ŋw�ԃA���S���Y���ƃf�[�^�\���x
 * ���͉��K���
 * @author owner
 *
 */
public class BasicAlgorithm {
	public static void main (String[]a) {
		triangleLB(3);
		System.out.println("");
		triangleLU(3);
		System.out.println("");
		triangleRU(3);
		System.out.println("");
		triangleRB(3);
		System.out.println("");
		spira(5);
		System.out.println("");
		npira(8);

	}
	static void triangleLB(int b) {
		for(int tate=0;tate<b;tate++) {
			System.out.print("��");
			for(int yoko=0;yoko<tate;yoko++) {
				System.out.print(" ");
			}
			System.out.println("\\");
		}
		for(int teihen=0;teihen<b;teihen++) {
			System.out.print("_");
		}
	}

	static void triangleLU(int n) {
		System.out.print(" ");
		for(int ue=0;ue<n;ue++) {
			System.out.print("_");
		}
		System.out.println("");
		for(int tate=0;tate<=n-1;tate++) {
			System.out.print("|");
			for(int space=n-2;space>=tate;space--) {
				System.out.print(" ");
			}
			System.out.println("/");
		}
	}
	static void triangleRU(int n) {
		for(int ue=0;ue<=n;ue++) {
			System.out.print("_");
		}
		System.out.println("");
		for(int tate=n;tate>0;tate--) {
			for(int leftSpace=n-tate;leftSpace>0;leftSpace--) {
				System.out.print(" ");
			}
			System.out.print("\\");
			for(int space=tate-1;space>0;space--) {
				System.out.print(" ");
			}
			System.out.println("|");
		}

	}
	static void triangleRB(int n) {

		for(int i=0;i<n;i++) {
			for(int space=n-2;space>=i;space--) {
				System.out.print("�@");
			}
			System.out.print("/");
			for(int j=1;j<=i;j++) {
				System.out.print("�@");
			}
			System.out.println("|");
		}
		for(int k=n;k>0;k--)
			System.out.print("�P");
	}

	static void spira(int totalRow) {
		int row=1;
		for(;row<=totalRow;) {
			for(int i=0;i<=totalRow-row;i++) {
				System.out.print(" ");
			}
			for(int star=1;star<=(row-1)*2+1;star++) {
				System.out.print("*");
			}
			System.out.println("");
			row++;
		}
	}
	static void npira(int totalRow) {
		int row=1;
		for(;totalRow>0;totalRow--) {
			for(int leftSpace=totalRow-1;leftSpace>0;leftSpace--) {
				System.out.print(" ");
			}
			for(int number=1;number<=(row-1)*2+1;number++) {
				System.out.print(row%10);
			}
			System.out.println("");
			row++;
		}
	}

}
