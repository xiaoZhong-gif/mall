package com.example.mall.app;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

public class EntityGenerator {

    @Test
    public void execute() {
        //参数
        String outDic = "D:";
        String[] tableName = new String[]{"address","admin","category",
                "category_second","goods","goods_image","goods_number","user"};

        //
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(outDic);
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(false);
        globalConfig.setBaseResultMap(false);
        globalConfig.setIdType(IdType.NONE);
        globalConfig.setServiceName("%sService");
        globalConfig.setAuthor("");
        globalConfig.setDateType(DateType.ONLY_DATE);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mall?serverTimezone=GMT%2B8&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8");
        dsc.setUsername("root");
        dsc.setPassword("123456");

        //
        StrategyConfig strategy = new StrategyConfig();
        if (!ArrayUtils.isEmpty(tableName)) {
            strategy.setInclude(tableName); // 需要生成的表
        }
        strategy.setSkipView(true);
        strategy.setCapitalMode(true);
        strategy.setSuperServiceClass("com.example.mall.app.service.BaseService");
        strategy.setSuperServiceImplClass("com.example.mall.app.service.impl.BaseServiceImpl");
        strategy.setRestControllerStyle(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);

        //自动增加
        strategy.setTableFillList(Arrays.asList(
                new TableFill("created_date", FieldFill.INSERT)
        ));


        //
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example.mall.app");
        packageConfig.setXml("resources");

        //
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dsc);
        autoGenerator.setStrategy(strategy);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setCfg(new InjectionConfig() {
            @Override
            public void initMap() {
                getConfig().getTableInfoList().forEach(t -> {
                    t.setConvert(true);
                });
            }
        });


        autoGenerator.execute();
    }
}
