package com.example.mvcboard.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfiguration {
    @Bean
    fun openAPI() : OpenAPI = OpenAPI().components(Components())

    private fun apiInfo() = Info().title("board").description("Asdasd").version("1.0.0")

}