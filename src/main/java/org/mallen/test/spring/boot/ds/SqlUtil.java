package org.mallen.test.spring.boot.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mallen
 * @date 4/17/19
 */
public class SqlUtil {
    private static final Logger logger = LoggerFactory.getLogger(SqlUtil.class);

    public static void execute(DataSource ds) {
        Connection conn = null;
        Statement sts = null;
        try {
            conn = ds.getConnection();
            sts = conn.createStatement();
            ResultSet rs = sts.executeQuery("select count(*) from mallen.mallen_user");
            while (rs.next()) {
                System.out.println(rs.getLong(1));
            }
        } catch (SQLException e) {
            logger.error("", e);
        } finally {
            if (null != sts) {
                try {
                    sts.close();
                } catch (SQLException e) {
                    logger.error("", e);
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error("", e);
                }
            }
        }
    }
}
