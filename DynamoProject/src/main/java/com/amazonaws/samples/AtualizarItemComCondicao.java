package com.amazonaws.samples;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

public class AtualizarItemComCondicao extends DynamoConfig{
    public static void main(String[] args) throws Exception {

        Table table = dynamoDB.getTable("Movies"); //puxa tabela que será utilizada

        UpdateItemSpec updateItemSpec = new UpdateItemSpec()
                .withPrimaryKey(new PrimaryKey("year", 2015, "title", "The Big New Movie")) //puxa o item que será atualizado, puxando pelas chaves
                .withUpdateExpression("remove info.actors[0]") //remove um dos campos
                .withConditionExpression("size(info.actors) >= :num").withValueMap(new ValueMap().withNumber(":num", 3)) // adiciona a condição para remover o campo
                .withReturnValues(ReturnValue.UPDATED_NEW);

        try {
            System.out.println("Atualizando item ...");
            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
            System.out.println("Item atualizado com sucesso:\n" + outcome.getItem().toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("Erro ao atualizar o item");
            System.err.println(e.getMessage());
        }
    }
}
