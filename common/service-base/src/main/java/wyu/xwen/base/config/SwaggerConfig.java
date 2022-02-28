package wyu.xwen.base.config;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("xwen")
                .select()
                .apis(RequestHandlerSelectors.basePackage("wyu.xwen"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("lisi")
                .select()
                .apis(RequestHandlerSelectors.basePackage("wyu.xwen"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        Contact contact = new Contact("xwen ","www.baidu.com","xwen612@163.com");//联系作者
        return new ApiInfo(
                "xwen's api",
                "this is description",
                "v1.0",
                "xwen612@163.com", //服务条款的链接
                (springfox.documentation.service.Contact) contact,
                "Apache 2.0",  //许可证
                "http://www.apache.org/licenses/LICENSE-2.0",  //许可证链接
                new ArrayList<VendorExtension>()
        );
    }
}
