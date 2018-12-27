package algorithmAndDataStructure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class YMD_test {
	
	/**
	 * 条件　
	 * (2018,12,29)
	 * 引数（100)
	 * 期待する戻り値(2019,4,8)
	 */
	@Test
	public void 百日後() throws Exception {
		//前準備
		Array_Class_YMD ymd2=new Array_Class_YMD(2018,12,29);
		//実行
		Array_Class_YMD actualY=ymd2.after(100);
		//検証
		assertEquals(actualY.year,2019);
		assertEquals(actualY.month,4);
		assertEquals(actualY.day,8);
	}

	/**
	 * 条件　
	 * (2018,12,29)
	 * 引数（368)
	 * 期待する戻り値(2020,1,1)
	 */
	@Test
	public void 二年後の正月() throws Exception {
		//前準備
		Array_Class_YMD ymd2=new Array_Class_YMD(2018,12,29);
		//実行
		Array_Class_YMD actualY=ymd2.after(368);
		//検証
		assertEquals(actualY.year,2020);
		assertEquals(actualY.month,1);
		assertEquals(actualY.day,1);
	}
	
	/**
	 * 条件　
	 * (2018,12,29)
	 * 引数（9999)
	 * 期待する戻り値(2046,5,15)
	 */
	@Test
	public void うるう年チェック() throws Exception {
		
		//前準備
		Array_Class_YMD ymd2=new Array_Class_YMD(2018,12,29);
		//実行
		Array_Class_YMD actualY=ymd2.after(9999);
		//検証
		assertEquals(actualY.year,2046);
		assertEquals(actualY.month,5);
		assertEquals(actualY.day,15);
	}

}
