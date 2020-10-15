package com.taomei.ideal.dao.util;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.taomei.ideal.common.util.StringUtils;

import java.util.Scanner;

/**
 *
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/26 3:15 下午
 */
public class ModuleGenerateUtils {
    public static void main(String[] args) {

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/dao/src/main/java");//定位到dao模块
        globalConfig.setAuthor("刘滔");//作者
        globalConfig.setOpen(false);//创建完毕后是否打开文件夹
        globalConfig.setSwagger2(true);//开启swagger2

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/ideal?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");


        //包信息配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(scanner("模块名"));//控制台输入模块名
        packageConfig.setParent("com.taomei.ideal.dao");//生成的模块在此包下

        //生成策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//下划线到驼峰命名
        strategyConfig.setRestControllerStyle(true);//使用RestController
        strategyConfig.setInclude(scanner("表名"));//为哪张表生成CURD代码，默认整个数据库

        //生成器配置
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(globalConfig);
        mpg.setDataSource(dataSourceConfig);
        mpg.setStrategy(strategyConfig);
        mpg.setPackageInfo(packageConfig);
        mpg.execute();


    }

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
