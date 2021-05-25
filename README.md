# AWS Lambda Java Events v3

This is fork of [official AWS Lambda Java Events](https://github.com/aws/aws-lambda-java-libs) that aims to provide simplified Java models **without JodaTime**.

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

### Events
* `ActiveMQEvent`
* `APIGatewayCustomAuthorizerEvent`
* `APIGatewayProxyRequest`
* `APIGatewayProxyResponse`
* `APIGatewayV2CustomAuthorizerEvent`
* `APIGatewayV2HTTPEvent`
* `APIGatewayV2HTTPResponse`
* `APIGatewayV2WebSocketEvent`
* `APIGatewayV2WebSocketResponse`
* `LoadBalancerRequest`
* `LoadBalancerResponse`
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
