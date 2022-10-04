package db.parsers.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisFactory {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisFactory.class.getName());
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            LOGGER.error("Can't connect to resources");
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
