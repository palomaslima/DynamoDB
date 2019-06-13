package com.amazonaws.samples;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class LerItem extends DynamoConfig{
    public static void main(String[] args) throws Exception {

        Table table = dynamoDB.getTable("Movies");

        GetItemSpec spec = new GetItemSpec().withPrimaryKey("year", 2015, "title", "The Big New Movie");

        try {
            System.out.println("Procurando item...");
            Item outcome = table.getItem(spec);
            System.out.println("Item encontrado: " + outcome);

        }
        catch (Exception e) {
            System.err.println("Erro ao procurar o item");
            System.err.println(e.getMessage());
        }

    }
}
