package com.lf.neo4j.test;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

import static org.neo4j.driver.Values.parameters;

public class Example {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687",
                AuthTokens.basic("neo4j","XXX"));
        try(Session session = driver.session()){
            try(Transaction tx = session.beginTransaction()){
                tx.run("create(n:A1{NAME:{NAME},TITLE:{TITLE}})",
                        parameters("NAME","james","TITLE","King"));
                //tx.success();
            }

            try (Transaction tx = session.beginTransaction()){
                Result result = tx.run("match(a:A1) WHERE a.NAME = {NAME} RETURN a.NAME AS NAME,a.TITLE AS TITLE",
                        parameters("NAME","james"));
                while(result.hasNext()){
                    //Record record = result.next();
                    //System.out.println(String.format("%s %s",record.get("TITLE").asString(),record.get("NAME").asString()));
                }

            }
        }
        driver.close();
    }
}
