package my_junit;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class strTest123 {

	@BeforeAll
	static void beforeAll()
	{
		System.out.println("Before All");
	}
	@BeforeEach
	void before(TestInfo ob) {
		System.out.println("Helllo "+ob.getDisplayName());
	}

	@Test
	@DisplayName("Exception Test")
	void my_test() {
		String x=null;
		assertThrows(NullPointerException.class,
				()->
		{
			x.length();
		}
		);
	}
    
	@Test
	@RepeatedTest(10)
	void checkEquals() {
		String a = "Guru";
		String b = "Guru";
		assertTrue(a.equals(b));
		System.out.println("From checkequals test");
	}
	@Test
	@Disabled
	void forloop()
	{
		assertTimeout(Duration.ofSeconds(15),
				()->
		{
		for(int i=1;i<1000;i++)
		{
			System.out.println(i);
		}
		}
		);
	}
	@AfterAll
	static void test()
	{
		System.out.println("After all");
	}
	@ParameterizedTest(name= "{0} length is{1}")
	@CsvSource(value= {"abcd,ABCD","abc,ABC","abcdef,ABCDEF","abcdefg,ABCDEFG"})
	void length(String actual,String exp)
	{
		assertEquals(actual.toUpperCase(),exp);
	}
	@ParameterizedTest
	@ValueSource(strings= {"ABC","ckcvnb","dfjbfd","dnjjn"})
	void param_test(String x)
	{
		assertTrue(x.length()>0);
	}
	

}
