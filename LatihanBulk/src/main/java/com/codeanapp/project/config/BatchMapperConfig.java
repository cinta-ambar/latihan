package com.codeanapp.project.config;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.codeanapp.project.mapper", sqlSessionTemplateRef = "batchSqlSessionTemplate")
public class BatchMapperConfig {

    private final DataSource dataSource;

    public BatchMapperConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean(name = "batchSqlSessionFactory")
    public SqlSessionFactory batchSqlSessionFactory()throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        SqlSessionFactory factory = bean.getObject();
        factory.getConfiguration().setMapUnderscoreToCamelCase(true);
        factory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
        return factory;
    }

    @Bean(name = "batchSqlSessionTemplate")
    public SqlSessionTemplate batchSqlSessionTemplate() throws Exception{
        return new SqlSessionTemplate(batchSqlSessionFactory(), ExecutorType.BATCH);
    }
}
