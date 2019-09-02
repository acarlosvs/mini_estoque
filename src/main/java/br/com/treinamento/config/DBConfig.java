package br.com.treinamento.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("br.com.treinamento.mapper")
public class DBConfig {
}