package com.amazonaws.samples;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class DynamoConfig {

//    static BasicAWSCredentials awsCreds = new BasicAWSCredentials("ALMASWNIEXEMPLOA2BY", "TyH20XEXEMPLOCHHAXEXEMPLOlCyLXEXEMPLOh");
//    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
//            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//            .withRegion(Regions.SA_EAST_1)
//            .withClientConfiguration(clientConfig())
//            .build();

    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
            .build();

    static DynamoDB dynamoDB = new DynamoDB(client);

    static public ClientConfiguration clientConfig(){

        // Variável com as configurações do cliente
        ClientConfiguration cli_config = new ClientConfiguration();

        // Setando configurações de proxy
        cli_config.setProxyHost("proxylatam.indra.es");
        cli_config.setProxyPort(8080);

        return cli_config;
    }
}
