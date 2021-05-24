# AWS Lambda Java Events v3

### Event Models Supported
* `ActiveMQEvent`
* `APIGatewayCustomAuthorizerEvent`
* `APIGatewayProxyRequestEvent`
* `APIGatewayProxyResponseEvent`
* `APIGatewayV2CustomAuthorizerEvent`
* `APIGatewayV2HTTPEvent`
* `APIGatewayV2HTTPResponse`
* `APIGatewayV2WebSocketEvent`
* `APIGatewayV2WebSocketResponse`
* `ApplicationLoadBalancerRequestEvent`
* `ApplicationLoadBalancerResponseEvent`
* `CloudFormationCustomResourceEvent`
* `CloudFrontEvent`
* `CloudWatchLogsEvent`
* `CodeCommitEvent`
* `CognitoEvent`
* `ConfigEvent`
* `ConnectEvent`
* `DynamodbEvent`
* `IoTButtonEvent`
* `KafkaEvent`
* `KinesisAnalyticsFirehoseInputPreprocessingEvent`
* `KinesisAnalyticsInputPreprocessingResponse`
* `KinesisAnalyticsOutputDeliveryEvent`
* `KinesisAnalyticsOutputDeliveryResponse`
* `KinesisAnalyticsStreamsInputPreprocessingEvent`
* `KinesisEvent`
* `KinesisFirehoseEvent`
* `LambdaDestinationEvent`
* `LexEvent`
* `S3BatchEvent`
* `S3BatchResponse`
* `S3Event`
* `ScheduledEvent`
* `SecretsManagerRotationEvent`
* `SimpleIAMPolicyResponse`
* `SNSEvent`
* `SQSEvent`

*As of version `3.0.0`, users are no longer required to pull in SDK dependencies in order to use this library.*

## Dependency :rocket:

**Gradle**
```groovy
dependencies {
    compile 'com.github.goodforgod:aws-lambda-java-events:0.9.0-SNAPSHOT'
}
```

**Maven**
```xml
<dependency>
    <groupId>com.github.goodforgod</groupId>
    <artifactId>aws-lambda-java-events</artifactId>
    <version>0.9.0-SNAPSHOT</version>
</dependency>
```
