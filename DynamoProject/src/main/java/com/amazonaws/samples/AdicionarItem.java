package com.amazonaws.samples;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class AdicionarItem extends DynamoConfig{
    public static void main(String[] args) throws Exception {

        Table table = dynamoDB.getTable("Movies");// puxa tabela que será utilizada

        final Map<String, Object> infoMap = new HashMap<String, Object>(); //criação de um 'array' de informações
        infoMap.put("plot", "Nothing happens at all.");
        infoMap.put("rating", 0);

        try {
            System.out.println("Adicionando um novo item...");
            PutItemOutcome outcome = table
                    .putItem(new Item().withPrimaryKey("year", 2015, "title", "The Big New Movie").withMap("info", infoMap));
                    // adiciona aqui o nome do atributo(campo) com o valor
            System.out.println("Item adicionado com sucesso:\n" + outcome.getPutItemResult());

        }
        catch (Exception e) {
            System.err.println("Erro ao adicionar o item");
            System.err.println(e.getMessage());
        }

    }
}
