import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author
 * @since 2018/12/13
 */
//note4mp:<!--第三步：在测试包下面将固定的类，然后填写相关信息后运行即可，不需要部署所以放测试包里-->
public class CodeGenerator {

    @Test
    public void run() {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        //note02:修改代码存放的地方
        gc.setOutputDir("D:\\project\\15_gulixueyuan\\02_codes\\01_backend\\03_springclound\\service\\service_gzh" + "/src/main/java");

        //note02:修改作者
        gc.setAuthor("Eagle");
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(true); //重新生成时文件是否覆盖

        //UserServie
        gc.setServiceName("%sService");    //去掉Service接口的首字母I

        //note02:主键策略需要跟进实体的主键类型选择对应的枚举
        gc.setIdType(IdType.ID_WORKER_STR); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(true);//开启Swagger2模式

        mpg.setGlobalConfig(gc);

        //note02:更改数据库配置
        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/gzh?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);


        //note02:更改包配置
        // 4、包配置
        PackageConfig pc = new PackageConfig();
        //包  com.eagle.eduservice
        pc.setParent("com.eagle");
        pc.setModuleName("gzhservice"); //模块名
        //包  com.eagle.eduservice.controller
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        //note02:更改需要生成的表名称
        strategy.setInclude("t_user");
//        strategy.setInclude("edu_course", "edu_course_description", "edu_chapter", "edu_video");

        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);


        // 6、执行
        mpg.execute();
    }
}
