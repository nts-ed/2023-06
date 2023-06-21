package com.EmployeeSystem.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

  // クロスドメインリクエストの最大有効期間 デフォルト1日
  private static final long MAX_AGE = 24 * 60 * 60;

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*"); // 1 アクセスソースアドレスの設定
    corsConfiguration.addAllowedHeader("*"); // 2 アクセスソースリクエストヘッダーの設定
    corsConfiguration.addAllowedMethod("*"); // 3 ソースリクエストメソッドへのアクセスの設定
    corsConfiguration.setMaxAge(MAX_AGE);
    source.registerCorsConfiguration("/**", corsConfiguration); // 4 インターフェイスのクロスドメイン設定
    return new CorsFilter(source);
  }
}
