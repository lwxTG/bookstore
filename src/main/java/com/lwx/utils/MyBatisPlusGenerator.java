package com.lwx.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lwx
 * @create 2022/4/1-20:35
 */
public class MyBatisPlusGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
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

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("lwx");//Mapper,Service类注解中显示创建人信息
        //gc.setBaseColumnList(true); //在Mapper.xml文件中是否生成公用SQL代码段
        //gc.setBaseResultMap(true);  //在Mapper.xml文件中是否生成公用返回集合ResultMap
        gc.setOpen(false);  //文件生成完毕后，是否需要打开所在路径
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/bookstore?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("863340557");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.lwx");  //父级公用包名，就是自动生成的文件放在项目路径下的那个包中
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义Mapper.xml文件存放的路径
                return projectPath + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setNaming(NamingStrategy.underline_to_camel);  //Entity文件名称命名规范
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //Entity字段名称
        strategy.setEntityLombokModel(true); //是否使用lombok完成Entity实体标注Getting Setting ToString 方法
        strategy.setRestControllerStyle(false); //Controller注解使用是否RestController标注,否则是否开启使用Controller标注
        strategy.setControllerMappingHyphenStyle(true);  //Controller注解名称，不使用驼峰，使用连字符
        strategy.setTablePrefix("tbl_");  //表前缀，添加该表示，则生成的实体，不会有表前缀，比如sys_dept 生成就是Dept
        //strategy.setFieldPrefix("tbl_");  //字段前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
}
}
