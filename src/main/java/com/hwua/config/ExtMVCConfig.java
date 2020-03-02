package com.hwua.config;

import com.hwua.interceptor.ValidateUserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class ExtMVCConfig {
    //创建一个实现WebMVCConfigurer接口的对象放倒容器中
    @Bean
    public WebMvcConfigurer extWebMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //注册映射路径到指定的视图
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/update_add.html").setViewName("update_add");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //注册自定义的拦截器,对/**所有请求进行拦截,排除登录相关页面的请求
                registry.addInterceptor(new ValidateUserInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/login.html","/user/login");
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new LocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest request) {
                String lan = request.getParameter("lan");
                Locale locale = Locale.getDefault();
                //假如请求头中没有Accept-Language,就是用默认的区域对象(封装了国家语言代号和国家代号)
                if(locale!=null&&request.getHeader("Accept-Language")==null){
                    return locale;
                }
                //假如请求头为空,且lan为空
                if(StringUtils.isEmpty(lan)){
                    locale=request.getLocale();//从请求头中获取区域对象
                }else{
                    //lan不为空,就用自己封装的区域对象
                    String[] s = lan.split("_");
                    locale = new Locale(s[0],s[1]);
                }
                return locale;
            }

            @Override
            public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

            }
        };
    }
}
