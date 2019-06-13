package com.amazonaws.samples;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

//essa classe atualiza o rating do filme cada vez que é rodada
public class AumentarContador extends DynamoConfig{
    public static void main(String[] args) throws Exception {

        Table table = dynamoDB.getTable("Movies");

        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("year", 2015, "title", "The Big New Movie") // item que será utilizado
                .withUpdateExpression("set info.rating = info.rating + :val") // atualiza o rating
                .withValueMap(new ValueMap().withNumber(":val", 1)).withReturnValues(ReturnValue.UPDATED_NEW);

        try {
            System.out.println("Incrementando a nota...");
            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
            System.out.println("Item atualizado:\n" + outcome.getItem().toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("Erro ao atualizar a nota");
            System.err.println(e.getMessage());
        }
    }
}
