package algorithmAndDataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.h

import org.junit.Test;

public class Array_Class_YMDTest {
	
	/**
	 * after()　
	 * (2018,12,29)
	 * 引数（100)
	 * 期待する戻り値(2019,4,8)
	 */
	@Test
	public void test_after_百日後() throws Exception {
		//前準備
		Array_Class_YMD ymd=new Array_Class_YMD(2018,12,29);
		//実行
		Array_Class_YMD actualY=ymd.after(100);
		//検証
		assertEquals(2019,actualY.year);
		assertEquals(4,actualY.month);
		assertEquals(8,actualY.day);	
	}

	/**
	 * after()
	 * (2018,12,29)
	 * 引数（368)
	 * 期待する戻り値(2020,1,1)
	 */
	@Test
	public void test_after_二年後の正月() throws Exception {
		//前準備
		Array_Class_YMD ymd=new Array_Class_YMD(2018,12,29);
		//実行
		Array_Class_YMD actualY=ymd.after(368);
		//検証
		assertEquals(2020,actualY.year);
		assertEquals(1,actualY.month);
		assertEquals(1,actualY.day);	
	}
	
	/**
	 * after()
	 * (2018,12,29)
	 * 引数（9999)
	 * 期待する戻り値(2046,5,15)
	 */
	@Test
	public void test_after_うるう年チェック() throws Exception {
		
		//前準備
		Array_Class_YMD ymd=new Array_Class_YMD(2018,12,29);
		//実行
		Array_Class_YMD actualY=ymd.after(9999);
		//検証
		assertEquals(2046,actualY.year);
		assertEquals(5,actualY.month);
		assertEquals(15,actualY.day);	
	}
	
	/**
	 * after()　
	 * (2018,12,29)
	 * 引数（100)
	 * 期待する戻り値(2018,9,20)
	 */
	@Test
	public void test_before_100日前() throws Exception {
		
		//前準備
		Array_Class_YMD ymd=new Array_Class_YMD(2018,12,29);
		//実行
		Array_Class_YMD actualY=ymd.before(100);
		//検証
		assertEquals(2018,actualY.year);
		assertEquals(9,actualY.month);
		assertEquals(20,actualY.day);	
	}
	
	/**
	 * 
	 * dateDifference()
	 * 引数（2018.12.30)
	 * 期待する戻り値(1)
	 */
	@Test
	public void test_dateDifference_１日() throws Exception {
		//前準備
		Array_Class_YMD ymd=new Array_Class_YMD(2018,12,30);
		//実行
		int actual=ymd.dateDifference();
		//検証
		assertEquals(1,actual);
	}
	
	/**
	 * 
	 * dateDifference()
	 * 引数（1993.5.21)
	 * 期待する戻り値(9355)
	 */
	@Test
	public void test_dateDifference_9355日() throws Exception {
		//前準備
		Array_Class_YMD ymd=new Array_Class_YMD(1993,5,21);
		//実行
		int actual=ymd.dateDifference();
		//検証
		assertEquals(9355,actual);
		assertThat(9335,is(actual));
	}
	
}
