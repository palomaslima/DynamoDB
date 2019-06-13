package com.amazonaws.samples;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class DynamoConfig {

    //    static BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIASWNI5255EKQFA2BZ", "TyH20XV2lWqYdCHHA8PWngV4lCyLNqhH9M6cBMXh");
//    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
//            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//            .withRegion(Regions.SA_EAST_1)
//            .withClientConfiguration(clientConfig())
//            .build();

    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
            .build();

    static DynamoDB dynamoDB = new DynamoDB(client);
}
