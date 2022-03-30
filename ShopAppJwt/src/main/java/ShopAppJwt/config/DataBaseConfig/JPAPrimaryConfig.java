package ShopAppJwt.config.DataBaseConfig;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(basePackages = "ShopAppJwt.dao.User", // 注意這
        entityManagerFactoryRef = "primaryEntityManager",
        transactionManagerRef = "transactionManager")
public class JPAPrimaryConfig {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    //primary
    @Primary
    @Bean(name = "primaryDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.primary")  // 注意這
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() throws SQLException {

        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(primaryDataSourceProperties().getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(primaryDataSourceProperties().getPassword());
        mysqlXaDataSource.setUser(primaryDataSourceProperties().getUsername());

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("primary");
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setMaxPoolSize(20);
        xaDataSource.setPoolSize(5);

        return xaDataSource;
    }

    @Primary
    @Bean(name = "primaryEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean primaryEntityManager() throws Throwable {

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.dialect.storage_engine", "innodb");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.hbm2ddl.import_files", "User.sql");

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(primaryDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setPackagesToScan("ShopAppJwt.model.Member"); // 這裡要修改成主要 Model 的包
        entityManager.setPersistenceUnitName("primaryPersistenceUnit");
        entityManager.setJpaPropertyMap(properties);

        return entityManager;
    }
}

