package in.co.sandbox.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpClientExample
{

	protected static OkHttpClient client;

	public static void main(String[] args)
	{

		try
		{

			String accessToken;

			JSONObject pan;

			OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(1, TimeUnit.MINUTES)
			        .readTimeout(1, TimeUnit.MINUTES).writeTimeout(1, TimeUnit.MINUTES).build();

			MediaType mediaType = MediaType.parse("application/json");

			RequestBody body = RequestBody.create("", mediaType);

			Request authenticationRequest = new Request.Builder().url("https://api.quicko.com/authenticate")
			        .method("POST", body).addHeader("x-api-key", "key_live_la*****************************w")
			        .addHeader("x-api-secret", "secret_live_ni*****************************p")
			        .addHeader("x-api-version", "3.4.0").build();

			Response response = client.newCall(authenticationRequest).execute();

			if (response.header("Content-Type").contains("json"))
			{
				final JSONObject jsonObject = new JSONObject(response.body().string());

				if (response.code() != 200)
				{
					throw new Exception(jsonObject.get("message").toString());
				}

				accessToken = jsonObject.get("access_token").toString();
			}
			else
			{
				throw new Exception("Unexpected content type received from server: " + response.header("Content-Type")
				        + " " + response.body().string());
			}

			Request panRequest = new Request.Builder()
			        .url("https://api.quicko.com/pans/XXXPX1234X/verify?consent=Y&reason=For opening Demat account")
			        .method("GET", null).addHeader("Authorization", accessToken)
			        .addHeader("x-api-key", "key_live_la*****************************w")
			        .addHeader("x-api-version", "3.4.0").build();

			Response panResponse = client.newCall(panRequest).execute();

			if (panResponse.header("Content-Type").contains("json"))
			{
				final JSONObject jsonObject = new JSONObject(panResponse.body().string());

				if (panResponse.code() != 200)
				{
					throw new Exception(jsonObject.get("message").toString());
				}

				pan = jsonObject;
			}
			else
			{
				throw new Exception("Unexpected content type received from server: "
				        + panResponse.header("Content-Type") + " " + panResponse.body().string());
			}

			System.out.println(pan);

		}
		catch (final JSONException je)
		{
			// handle Exception
			je.printStackTrace();

		}
		catch (final IOException ioE)
		{
			// handle Exception
			ioE.printStackTrace();

		}
		catch (final Exception e)
		{
			// handle Exception
			e.printStackTrace();

		}

	}
}