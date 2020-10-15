package com.taomei.ideal.dao.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘滔(2389599310@qq.com)
 * @version v1.0
 * @date 2020/9/26 10:07 下午
 */
@Configuration
@MapperScan("com.taomei.ideal.dao")
public class MybatisConfiguration {


}
