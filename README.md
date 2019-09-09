[![Release](https://jitpack.io/v/kuliginstepan/dadata-client.svg)](https://jitpack.io/#kuliginstepan/dadata-client)
[![CircleCI](https://circleci.com/gh/KuliginStepan/dadata-client/tree/master.svg?style=shield)](https://circleci.com/gh/KuliginStepan/dadata-client/tree/master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/11dd4516337e4a9da32b427262e96fe7)](https://www.codacy.com/app/KuliginStepan/dadata-client?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=KuliginStepan/dadata-client&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/KuliginStepan/dadata-client/branch/master/graph/badge.svg)](https://codecov.io/gh/KuliginStepan/dadata-client)

# dadata-client

Dadata Suggestions API client for Spring (Java)

## Overview

Dadata API client based on non-blocking HTTP client of Spring WebClient. Supports all methods of Suggestion API

## [Release notes](ReleaseNotes.md)

## Add a dependency

Gradle:

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.kuliginstepan:dadata-client:Tag'
	}
	
Maven:

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.kuliginstepan</groupId>
	    <artifactId>dadata-client</artifactId>
	    <version>Tag</version>
	</dependency>

## Usage

You need to add property `dadata.client.token` with your Dadata API Token.
You may add property `dadata.client.timeout` to configure dadata client request timeout.

Dadata client provides `DadataClientAutoConfiguration` which configures `DadataClient` bean for you.

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

Request builders allow to filter and rank suggestions. More examples are available in the `test` module 
