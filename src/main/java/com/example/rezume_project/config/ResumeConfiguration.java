// package com.example.rezume_project.config;

// import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.JpaVendorAdapter;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
// import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;

// import jakarta.activation.DataSource;

// @Configuration
// @EnableTransactionManagement
// @EnableJpaRepositories(basePackages = {"com.example.resume_project.repository"})
// // @EntityScan(basePackages = {"com.example.resume_project.entity"})
// public class ResumeConfiguration {
//     @Bean
//     public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//         LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//         em.setDataSource((javax.sql.DataSource) dataSource());
//         em.setPackagesToScan(new String[]{"com.example.resume.entity"});

//         JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//         em.setJpaVendorAdapter(vendorAdapter);

//         return em;
//     }

//     // @Bean
//     // public DataSource dataSource() {
//     //     DriverManagerDataSource dataSource = new DriverManagerDataSource();
//     //     dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//     //     dataSource.setUrl("jdbc:mysql://localhost:3306/resume");
//     //     dataSource.setUsername("root");
//     //     dataSource.setPassword("root");

//     //     return (DataSource) dataSource;
//     // }

//     @Bean
//     public PlatformTransactionManager transactionManager() {
//         JpaTransactionManager transactionManager = new JpaTransactionManager();
//         transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

//         return transactionManager;
//     }
// }
