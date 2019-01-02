
package searching;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author owner
 *
 */
public class BinSearchTest {

	/**
	 * 
	 * {@link searching.BinSearch#serchIdx(int[], int, int, int[])} のためのテスト・メソッド。
	 */
	@Test
	public void 演習3の3返り値5() throws Exception {
		//前準備
		int[]a= {6,2,3,4,5,6,6,6,1,6,9,1};
		int[]index=new int [12];
		int key=6;
		//実行
		int actual=BinSearch.searchIdx(a, a.length, key, index);
		//検証
		assertEquals(5,actual);
	}
	@Test
	public void キーが複数の場合先頭7を返す() throws Exception {
		//前準備
		int []a= {1,3,5,7,7,7,7,8,8,9,9};
		int key=7;
		//実行
		int actual=BinSearch.binSearchX(a, a.length,key);
		//検証
		assertEquals(3,actual);
	}
	
	@Test
	public void 解答例キーが複数の場合先頭7を返す() throws Exception {
		//前準備
		int []a= {7,3,5,7,7,7,8,8,9,9,7};
		int key=7;
		//実行
		int actual=BinSearch.binSearchXAnser(a, a.length,key);
		//検証
		assertEquals(0,actual);
	}
}
