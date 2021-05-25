package com.teachmeskills.calc;

import com.teachmeskills.calc.dao.InMemoryOperationDao;
import com.teachmeskills.calc.dao.InMemoryUserDao;
import com.teachmeskills.calc.dao.OperationDao;
import com.teachmeskills.calc.dao.UserDao;
import com.teachmeskills.calc.interceptor.UserIsNullInterceptor;
import com.teachmeskills.calc.interceptor.UserNotNullInterceptor;
import com.teachmeskills.calc.model.calc.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.teachmeskills")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserIsNullInterceptor()).addPathPatterns("/calc","/history","/logout");
        registry.addInterceptor(new UserNotNullInterceptor()).addPathPatterns("/reg","/auth");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/pages/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }


    @Bean
    public Map<Integer, Action> calcAction(Action add, Action sub, Action div, Action mul){
        Map<Integer,Action> calcAction = new HashMap<>();
        calcAction.put(1,add);
        calcAction.put(2,sub);
        calcAction.put(3,div);
        calcAction.put(4,mul);
        return calcAction;
    }

    @Bean
    public Action add(){
        return new Addition();
    }

    @Bean
    public Action mul(){
        return new Multiply();
    }

    @Bean
    public Action sub(){
        return new Subtract();
    }

    @Bean
    public Action div(){
        return new Divide();
    }

    @Bean
    public OperationDao operationDao(){
        return InMemoryOperationDao.getInstance();
    }

    @Bean
    public UserDao userDao(){
        return InMemoryUserDao.getInstance();
    }
}
