package br.org.catolicasc.kabon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@SpringBootApplication
public class KabonECommerceApplication {

	@Value("${project.version}")
    private String apiVersion;

	public static void main(String[] args) {
		SpringApplication.run(KabonECommerceApplication.class, args);
	}

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Kabon E-Commerce").version(apiVersion).description(
                "Sistem de vendas de softwares e aparelhos eletrônicos"))
                .addServersItem(new Server().url("catolicasc"))
                .schemaRequirement(apiVersion, null);
    }


}
