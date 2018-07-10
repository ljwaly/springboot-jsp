package com.ljw.sb.jsp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;



@SpringBootApplication
public class ServerJsp {

	private static final Logger log = LoggerFactory.getLogger(ServerJsp.class);

	public static void main(String[] args) {

		// SpringApplication.run(Server.class, args);//只是启动的话，此句与下边的一样

		SpringApplication app = new SpringApplication(ServerJsp.class);

		Environment env = app.run(args).getEnvironment();
		log.info("\n----------------------------------------------------------\n\t"
				+ "Application {} is running! Access URLs:\n\t" + // 大括号1
				"Local: \t\thttp://localhost:{}\n\t" + // 大括号2
				"{}\n\t" + // 大括号3
				"\n----------------------------------------------------------",

				env.getProperty("spring.application.name"), // 大括号1对应的内容
				env.getProperty("server.port"), // 大括号2对应的内容
				"Thank You!"// 大括号3对应的内容

		);

	}
	
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

	   return (container -> {//lambda表达式
	        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.jsp");
	        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.jsp");
	        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.jsp");

	        container.addErrorPages(error401Page, error404Page, error500Page);
	   });
	}
	
	
	
	
}
