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

import java.util.Arrays;

public class AtualizarItem extends DynamoConfig{
    public static void main(String[] args) throws Exception {

        Table table = dynamoDB.getTable("Movies"); //puxa tabela que será utilizada

        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("year", 2015, "title", "The Big New Movie") //puxa os campos e valores que deseja atualizar
                .withUpdateExpression("set info.rating = :r, info.plot=:p, info.actors=:a") //cria apelido para campos do array de informações
                .withValueMap(new ValueMap().withNumber(":r", 5.5).withString(":p", "Everything happens all at once.")// adiciona valores atualizados
                        .withList(":a", Arrays.asList("Larry", "Moe", "Curly"))) //adiciona os valores para o campo vazio
                .withReturnValues(ReturnValue.UPDATED_NEW);

        try {
            System.out.println("Atualizando item...");
            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
            System.out.println("Item atualizado com sucesso:\n" + outcome.getItem().toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("Erro ao atualizar o item");
            System.err.println(e.getMessage());
        }
    }
}
