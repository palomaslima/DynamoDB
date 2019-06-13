package com.amazonaws.samples;

import com.amazonaws.services.dynamodbv2.document.Table;

public class ExcluirTabela extends DynamoConfig {
    public static void main(String[] args) {

        Table table = dynamoDB.getTable("MusicCollection");

        try {
            System.out.println("Excluindo tabela...");
            table.delete(); // deleta tabela
            table.waitForDelete();
            System.out.print("Tabela excluida com sucesso");

        }
        catch (Exception e) {
            System.err.println("Erro ao excluir a tabela ");
            System.err.println(e.getMessage());
        }
    }
}
