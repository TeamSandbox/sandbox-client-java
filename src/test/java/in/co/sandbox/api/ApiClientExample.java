package in.co.sandbox.api;

import org.json.JSONException;

import in.co.sandbox.api.auth.ApiUserCredentials;
import in.co.sandbox.api.client.ApiClient;
import in.co.sandbox.api.client.ApiClientBuilder;
import in.co.sandbox.api.exception.SandboxException;

public class ApiClientExample
{

	protected static ApiClient client;

	public static void main(String[] args)
	{

		try
		{

			client = ApiClientBuilder.basic()
			        .withCredentials(new ApiUserCredentials("key_live_la*****************************w",
			                "secret_live_ni*****************************p"))
			        .build();

			String pan = "XXXPX1234X";
			String consent = "Y";
			String reason = "For opening Demat account";

			// Get PAN details using PAN (Basic) API
			System.out.println(client.PAN.verify(pan, consent, reason).toJson().toString());
		}
		catch (final SandboxException sE)
		{
			System.out.println(sE.getMessage());
		}
		catch (final JSONException je)
		{
			// handle Exception
			je.printStackTrace();

		}
		catch (final Exception e)
		{
			// handle Exception
			e.printStackTrace();

		}

	}
}
