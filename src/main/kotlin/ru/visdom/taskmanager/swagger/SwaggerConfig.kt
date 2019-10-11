package ru.visdom.taskmanager.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
            .produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES)

    companion object {

        private val DEFAULT_CONTACT = springfox.documentation.service.Contact("Viktor Noskin",
                "https://github.com/vitek999",
                "vitek2012rus@gmail.com"
        )

        @Suppress("DEPRECATION")
        private val DEFAULT_API_INFO = ApiInfo("Task Manager Server API", "Task manager web service", "1.0",
                "urn:tos", DEFAULT_CONTACT.toString(), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0")

        private val DEFAULT_PRODUCES_AND_CONSUMES: Set<String> = HashSet(listOf("application/json", "application/xml"))

    }
}