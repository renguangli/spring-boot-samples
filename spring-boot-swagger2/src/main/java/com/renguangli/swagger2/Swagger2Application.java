package com.renguangli.swagger2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.renguangli.swagger2")
public class Swagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(Swagger2Application.class, args);
	}

	@Bean
	public Docket createRestApi() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("springboot利用swagger构建api文档")
				.description("简单优雅的restful风格")
				.termsOfServiceUrl("http://blog.csdn.net/qzva1215")
				.version("1.0")
				.build();
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.renguangli.swagger2"))
				.paths(PathSelectors.any())
				.build();
	}

}
