# AWS Lambda Java Events v3

This is fork of [official AWS Lambda Java Events](https://github.com/aws/aws-lambda-java-libs) that aims to provide simplified Java models **without JodaTime**.

## Dependency :rocket:

**Gradle**
```groovy
dependencies {
    compile 'com.github.goodforgod:aws-lambda-java-events:1.0.0'
}
```

**Maven**
```xml
<dependency>
    <groupId>com.github.goodforgod</groupId>
    <artifactId>aws-lambda-java-events</artifactId>
    <version>1.0.0</version>
</dependency>
```

## The Why

Library provides:
- All models provided as simple POJOs 
- All models have unified structure so that all models can be easily build via *ObjectMapper* or other serialization engine.
- All models are build with *Lombok* to provide boiler-less source code for easier reading and understanding of model internals.
- All models use *java.time.* classes for time serialization.

## Events
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
* Cognito
  * `CognitoEvent`
  * `CognitoUserPoolCreateAuthChallengeEvent`
  * `CognitoUserPoolCustomMessageEvent`
  * `CognitoUserPoolDefineAuthChallengeEvent`
  * `CognitoUserPoolMigrateUserEvent`
  * `CognitoUserPoolPostAuthenticationEvent`
  * `CognitoUserPoolPostConfirmationEvent`
  * `CognitoUserPoolPreAuthenticationEvent`
  * `CognitoUserPoolPreSignUpEvent`
  * `CognitoUserPoolPreTokenGenerationEvent`
  * `CognitoUserPoolVerifyAuthChallengeResponseEvent`
* Common
  * `ActiveMQEvent`
  * `ConnectEvent`
  * `IoTButtonEvent`
  * `KafkaEvent`
  * `LexEvent`
  * `ScheduledEvent`
  * `SNSEvent`
  * `SQSEvent`
