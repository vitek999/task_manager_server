package ru.visdom.taskmanager.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
open class SwaggerConfig {

    @Bean
    open fun api(): Docket = Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
            .produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES)

    companion object {

        private val DEFAULT_CONTACT = springfox.documentation.service.Contact("V.I.S.D.O.M Lab",
                "https://gitlab.com/POASLab/",
                "vitek2012rus@gmail.com"
        )

        private val DEFAULT_API_INFO = ApiInfo("Notes Server API", "Notes web service", "1.0",
                "urn:tos", DEFAULT_CONTACT.toString(), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0")

        private val DEFAULT_PRODUCES_AND_CONSUMES: Set<String> = HashSet(listOf("application/json", "application/xml"))

    }
}