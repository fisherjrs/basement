package httpclients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import classes.LocalClassSample;

public class FrameAPITest {
	private static Logger LOG = LoggerFactory.getLogger(FrameAPITest.class);
	public static void main(String[] args) {
		FrameAPITest a = new FrameAPITest();
		a.runHttpTest();
	}
	
	public void runHttpTest() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		URI uri = null;
		try {
			uri = createFrameURI();
			HttpGet httpGet = new HttpGet(uri);
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				@Override
				public String handleResponse(final HttpResponse response) throws IOException {
					int status = response.getStatusLine().getStatusCode();
					if(status >= 200 && status < 300){
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : "The response was empty";
					} else {
						throw new ClientProtocolException("Unexpected response status " + status);
					}
				}
			};
			String responseBody = httpClient.execute(httpGet, responseHandler);
			LOG.debug(responseBody);
		} catch(Exception e) {
			LOG.debug("Error", e);
		}
	}
	
	private URI createURI()  throws URISyntaxException{
		URI uri = new URIBuilder()
		.setScheme("https")
		.setHost("img.mainframe2.com")
		.setPath("/login/jostens")
		.setParameter("rel_party", "http://yearbookavenue.jostens.com/")
		.setParameter("user", "14473")
		.setParameter("session", "2upqpukhfsfgjqijikiktgoothgrofhunsuppqmtifpttohgitnqshmhfjpprljqk")
		.build();

		return uri;
	}
	
	private URI createFrameURI()  throws URISyntaxException{
		URI uri = new URIBuilder()
		.setScheme("https")
		.setHost("app.fra.me")
		.setPath("/jostens_signin")
		.setParameter("token", "pbcd91898387bc21f105")
		.build();

		return uri;
	}
}
