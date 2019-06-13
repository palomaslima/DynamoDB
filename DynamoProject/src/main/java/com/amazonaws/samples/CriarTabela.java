package com.amazonaws.samples;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

import java.util.Arrays;

public class CriarTabela extends DynamoConfig{
    public static void main(String[] args) throws Exception {

        String tableName = "Movies";//setar nome da tabela

        try {
            System.out.println("A tabela esta sendo criada...");
            Table table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("year", KeyType.HASH), // chave de partição
                            new KeySchemaElement("title", KeyType.RANGE)), // chave de classificação
                    Arrays.asList(new AttributeDefinition("year", ScalarAttributeType.N), //criação atributos(campos)
                            new AttributeDefinition("title", ScalarAttributeType.S)),
                    new ProvisionedThroughput(10L, 10L));
            table.waitForActive();
            System.out.println("Tabela criada com sucesso. Status: " + table.getDescription().getTableStatus());

        }
        catch (Exception e) { //caso dê erro ao criar a tabela
            System.err.println("Erro ao criar a tabela ");
            System.err.println(e.getMessage()); // trás mensagem de erro
        }

    }
}
