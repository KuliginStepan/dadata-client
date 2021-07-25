![Maven Central](https://img.shields.io/maven-central/v/com.github.kuliginstepan/dadata-client)
![](https://github.com/kuliginstepan/dadata-client/workflows/Java%20CI%20with%20Gradle/badge.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/11dd4516337e4a9da32b427262e96fe7)](https://www.codacy.com/app/KuliginStepan/dadata-client?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=KuliginStepan/dadata-client&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/KuliginStepan/dadata-client/branch/master/graph/badge.svg)](https://codecov.io/gh/KuliginStepan/dadata-client)

# dadata-client

Dadata Suggestions API client for Spring (Java)

## Overview

Dadata API client based on non-blocking HTTP client of Spring WebClient. Supports all methods of Suggestion API

## [Release notes](ReleaseNotes.md)

## Add a dependency

Gradle:
	
	dependencies {
	        implementation 'com.github.kuliginstepan:dadata-client:Tag'
	}
	
Maven:
	
	<dependency>
	    <groupId>com.github.kuliginstepan</groupId>
	    <artifactId>dadata-client</artifactId>
	    <version>Tag</version>
	</dependency>

## Configuration

Dadata client provides `DadataClientAutoConfiguration` which configures `DadataClient` bean for you.

### Primary settings

It's required to add property `dadata.client.token` with your Dadata API Token.

You may add property `dadata.client.timeout` to configure dadata client request timeout, defaults to 5 seconds.

Via `dadata.client.baseUrl` you can change Dadata base url, defaults to https://suggestions.dadata.ru/suggestions/api/4_1/rs

`dadata.client.maxInMemorySize` defines max buffer size for response, defaults to 512K. You can change it if you have memory issues.

### Proxy support and SSL verification

`dadata.client.proxyType` - valid values are: HTTP, SOCKS4, SOCKS5, defaults to HTTP

`dadata.client.proxyServer` - proxy hostname or ip address

`dadata.client.proxyPort` - proxy port, positive number

If you have configured above options you can use authentication via username/password pair just setting system properties for them.

-   for HTTP proxy you should use `http.proxyUser` and `http.proxyPassword` respectively.
-   for SOCKS proxy you should use `java.net.socks.username` and `java.net.socks.password` respectively.

There is no authorization at proxy if no username defined in system environment.

`dadata.client.verifySsl` - enable/disable server SSL-certificate verification at client-side, defaults to true

## Usage

Autowire `DadataClient` in your beans and call api methods, for example:

```
@Service
public class SomeService {
    
    @Autowired
    private DadataClient client;
    
    public Flux<Suggestion<Address>> getSuggestionsForAddress(String query) {
        return client.suggestAddress(AddressRequestBuilder.create(query).build());
    }
}
```

Request builders allow filter and rank suggestions. More examples are available in the `test` module 
