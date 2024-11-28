
# Sandbox API Client

The official repository of SDK to communicate with Sandbox APIs.

Sandbox API is a set of REST APIs provides digital infrastructure you will need to quickly build and scale your fintech application in banking, savings, wealth, financial wellness, and insurance.

Sandbox Financial Technologies Private Limited (c) 2024.

## Documentation

[Sandbox API documentation](http://developer.sandbox.co.in/)

## Installation
### Requirements

- Java 1.8 or later

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>in.co.sandbox</groupId>
    <artifactId>api-client-java</artifactId>
    <version>2.1.0-BUILD-RELEASE</version>
</dependency>
```

### Others

You'll need to manually install the following JARs:

- The Sandbox API Client JAR from <https://github.com/in-co-sandbox/sandbox-client-java/releases/latest>

  
## Usage

### API Authentication

Instantiate `ApiClient` with `api_key` & `api_secret`. Use this ApiClient to call Paid APIs or to access resources on server for api user. You can obtain the key from the dashboard. <https://dashboard.sandbox.co.in>

```java
// Initialize ApiUserCredentials
ApiUserCredentials credentials = new ApiUserCredentials("api_key", "api_secret");

// Initialize ApiClient with API session
ApiClient client =
       ApiClientBuilder.basic().withCredentials(credentials).build();
	   
// Use ApiClient to call Paid APIs or to access resources on server for api user
JSONObject gstin = client.GST.COMPLIANCE.PUBLIC.searchGstin(gstin);
```
