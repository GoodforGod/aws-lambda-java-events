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

## The Why



### Events
* DynamoDB
  * `DynamodbEvent`
  * `DynamodbTimeWindowEvent`
* Gateway
  * `APIGatewayProxyEvent`
  * `APIGatewayProxyResponse`
  * `APIGatewayCustomAuthorizerEvent`
  * `APIGatewayV2CustomAuthorizerEvent`
  * `APIGatewayV2HTTPEvent`
  * `APIGatewayV2HTTPResponse`
  * `APIGatewayV2WebSocketEvent`
  * `APIGatewayV2WebSocketResponse`
* Kinesis
  * `KinesisAnalyticsFirehoseInputPreprocessingEvent`
  * `KinesisAnalyticsInputPreprocessingResponse`
  * `KinesisAnalyticsOutputDeliveryEvent`
  * `KinesisAnalyticsOutputDeliveryResponse`
  * `KinesisAnalyticsStreamsInputPreprocessingEvent`
  * `KinesisEvent`
  * `KinesisFirehoseEvent`
  * `KinesisTimeWindowEvent`
* S3
  * `S3BatchEvent`
  * `S3BatchResponse`
  * `S3Event`
  * `S3EventNotification`
  * `S3EventObjectLambdaEvent`
* System
  * `LoadBalancerRequest`
  * `LoadBalancerResponse`
  * `CloudFormationCustomResourceEvent`
  * `CloudFrontEvent`
  * `CloudWatchLogsEvent`
  * `CodeCommitEvent`
  * `ConfigEvent`
  * `LambdaDestinationEvent`
  * `IamPolicyResponse`
  * `SecretsManagerRotationEvent`
  * `SimpleIAMPolicyResponse`
* Common
  * `ActiveMQEvent`
  * `CognitoEvent`
  * `ConnectEvent`
  * `IoTButtonEvent`
  * `KafkaEvent`
  * `LexEvent`
  * `ScheduledEvent`
  * `SNSEvent`
  * `SQSEvent`
