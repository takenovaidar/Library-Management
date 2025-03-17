package itsphere.dev.bookswap;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "BookSwap API",
                version = "1.0",
                description = "Документация для BookSwap API"
        )
)
public class BookSwapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSwapApplication.class, args);
    }
}

