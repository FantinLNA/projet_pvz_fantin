package com.epf.persistance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.epf")
public class dbconfig {

    @Bean
    public DataSource initdataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pvz");
        dataSource.setUsername("epf");
        dataSource.setPassword("mot_de_passe");

        return dataSource;
    }

    @Bean
    public JdbcTemplate initjdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(initdataSource());
        return jdbcTemplate;
    }
}
