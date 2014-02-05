devconf2014-demo
================
A simple application which pulls tweets of a user, filters them and serves through REST as JSON.

Demonstrates features of Agorava, a tiny bit of DeltaSpike and some CDI features in general.

## Usage
1. Create API key and access token in your Twitter account and enter the values in prepared `pom.xml` properties.
2. In the file `src/main/resources/demo.properties`, define the twitter user and the filter words as a comma-separated list of values.
3. Build, deploy to application server and access `http://localhost:8080/devconf2014-demo/tweets

## Note
The application code does not necessarily reflect any recommended coding practices and conventions.

Also, the use of Agorava is kind of hacky, it skips the OAuth dance by directly setting the access token, which is not a real life scenario.
