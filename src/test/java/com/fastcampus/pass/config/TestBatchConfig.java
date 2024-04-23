package com.fastcampus.pass.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaAuditing // JPA Auditing을 활성화하는 애노테이션으로, 엔티티 변경 시간 추적을 가능하게 합니다.
@EnableAutoConfiguration // 스프링 부트의 자동 구성을 활성화합니다.
@EnableBatchProcessing
@EntityScan("com.fastcampus.pass.repository") // 엔티티를 검색하기 위한 패키지를 설정합니다.
@EnableJpaRepositories("com.fastcampus.pass.repository") // JPA 리포지토리를 활성화하고, 리포지토리를 검색하기 위한 패키지를 설정합니다.
@EnableTransactionManagement // 트랜잭션 관리를 활성화하는 애노테이션입니다.@Transactional 애노테이션이 동작하도록 해줍니다.
public class TestBatchConfig {
}