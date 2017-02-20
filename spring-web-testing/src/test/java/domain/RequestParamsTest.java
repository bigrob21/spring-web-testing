package domain;

import static org.mockito.Mockito.mock;

import java.io.InputStream;
import java.security.KeyStore;

import javax.servlet.http.HttpServletRequest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RequestParamsTest {

	private HttpServletRequest mockRequest = mock(HttpServletRequest.class);

	private static KeyStore keyStore;
	private static KeyStore trustStore;

	final static String keystoreFileName = "/test.jks";
	final static String trustStoreFileName = "/trust.jks";

	static InputStream in1 = null;
	static InputStream in2 = null;

	@BeforeClass
	public static void initClass() {
		try {
			in1 = RequestParamsTest.class.getClassLoader().getResourceAsStream(keystoreFileName);
			in2 = RequestParamsTest.class.getClassLoader().getResourceAsStream(trustStoreFileName);
			keyStore = KeyStore.getInstance("JKS");
			trustStore = KeyStore.getInstance("JKS");
			keyStore.load(in1, "".toCharArray());
			trustStore.load(in2, "".toCharArray());
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RuntimeException("Unable to load test: ", t);
		}
	}

	@AfterClass
	public static void tearDownAfter() {
		try {
			if (in1 != null)
				in1.close();
		} catch (Throwable t) {
			// do nothing
		}
		try {
			if (in2 != null)
				in2.close();
		} catch (Throwable t2) {
			// do nothing
		}
	}

	@Test
	public void test() throws Throwable {
		System.out.println(keyStore.getType());
		// X509Certificate.getInstance()
		// when(mockRequest);
		RequestParams rp1 = new RequestParams(mockRequest);
	}

}
