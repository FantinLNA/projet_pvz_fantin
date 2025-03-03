package com.epf.persistance;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Configuration

public class DataSource {
    private String nom;
    private String password;
    private URL url;

    private DataSource(String nom, String password, URL url) {
        this.nom = nom;
        this.password = password;
        this.url = url;
    }

    private Getconnection(){
        MysqlDataSource DataSource = new MysqlDataSource();
        DataSource.setUser("epf");
        DataSource.setPassword("mot_de_passe");
        DataSource.setServerName("localhost");
        DataSource.setPort(8080);
        DataSource.setDatabaseName("pvz");

    }


    
}
