package com.amazonaws.samples;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class ExcluirItem extends DynamoConfig{
    public static void main(String[] args) throws Exception {

        Table table = dynamoDB.getTable("Movies");

        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
                .withPrimaryKey(new PrimaryKey("year", 2015, "title", "The Big New Movie")); // setando item que será excluido

        try {
            System.out.println("Item sendo excluído...");
            table.deleteItem(deleteItemSpec);
            System.out.println("Item deletado");
        } catch (Exception e) {
            System.err.println("Erro ao deletar o item");
            System.err.println(e.getMessage());
        }
    }
}
