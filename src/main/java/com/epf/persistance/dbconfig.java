package com.epf.persistance;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class dbconfig {
    private static final Logger logger = LoggerFactory.getLogger(dbconfig.class);

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("epf");
        dataSource.setPassword("mot_de_passe");
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306); // Port MySQL par défaut
        dataSource.setDatabaseName("pvz");

        try {
            dataSource.getConnection().close();
            logger.info("Database connection test successful");
        } catch (SQLException e) {
            logger.error("Failed to connect to database: {}", e.getMessage());
        }

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
