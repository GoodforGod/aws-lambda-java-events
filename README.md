# AWS Lambda Java Events v3

![GraalVM Enabled](https://img.shields.io/badge/GraalVM-Ready-orange?style=plastic)

This is based on [official AWS Lambda Java Events v3.11.0](https://github.com/aws/aws-lambda-java-libs/tree/master/aws-lambda-java-events) that aims to provide simplified Java models **without JodaTime**.

## Dependency :rocket:

**Gradle**
```groovy
implementation "io.goodforgod:aws-lambda-java-events:2.0.0"
```

**Maven**
```xml
<dependency>
    <groupId>io.goodforgod</groupId>
    <artifactId>aws-lambda-java-events</artifactId>
    <version>2.0.0</version>
</dependency>
```

## Features

Library provides:
- All models provided as simple POJOs 
- All models have unified structure so that all models can be easily build via *ObjectMapper* or other serialization engine.
- All models are build with *Lombok* to provide boiler-less source code for easier reading and understanding of model internals.
- All models use *java.time.* classes for time serialization.
- All models are Gson/Jackson compatible

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
