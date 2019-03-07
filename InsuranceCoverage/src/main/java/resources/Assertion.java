package resources;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class Assertion {
@Test
public static void assert_result(String Actual_Result,String Expected_Result)
{
	SoftAssert softAssertion= new SoftAssert();
	softAssertion.assertEquals(Actual_Result, Expected_Result);
	softAssertion.assertAll();
	}
}
