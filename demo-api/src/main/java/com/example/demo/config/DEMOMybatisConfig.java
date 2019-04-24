package com.example.demo.config;

import static com.example.demo.config.DatasourceConfig.DEMO_DATASOURCE;
import static com.example.demo.config.DatasourceConfig.DEMO_SESSION_FACTORY;
import static com.example.demo.config.DatasourceConfig.DEMO_SESSION_TEMPLATE;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.annotation.UseDemoDatasource;

@Configuration
@MapperScan(
		basePackages = "com.example.demo",
		annotationClass = UseDemoDatasource.class,
		sqlSessionFactoryRef = DEMO_SESSION_FACTORY
)
public class DEMOMybatisConfig {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@Bean(name = DEMO_DATASOURCE)
	@Primary
	@ConfigurationProperties(prefix = "spring.multi-datasource.demo")
	public DataSource DEMODataSource() {		
		return DataSourceBuilder.create().build();
	}

	@Bean(name = DEMO_SESSION_FACTORY)
	@Primary
	public SqlSessionFactory DEMOSqlSessionFactory(@Qualifier(DEMO_DATASOURCE) final DataSource DEMODataSource) throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		sqlSessionFactoryBean.setDataSource(DEMODataSource);
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mapper/mybatis-config.xml"));
		// mybatis mapper 위치 설정
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/demo/*Mapper.xml"));

		return sqlSessionFactoryBean.getObject();

	}

	@Bean(name = DEMO_SESSION_TEMPLATE)
	@Primary
	public SqlSessionTemplate DEMOSqlSessionTemplate(SqlSessionFactory DEMOSqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(DEMOSqlSessionFactory);
	}

}