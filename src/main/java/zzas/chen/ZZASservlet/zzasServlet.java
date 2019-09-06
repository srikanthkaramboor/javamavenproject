package zzas.chen.ZZASservlet;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.sf.json.JSONArray;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import zzas.chen.ZZASdao.TB_AA_SERVICE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "zzasServlet",urlPatterns = "/zzas")
public class zzasServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //初始化数据库连接
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            //ComboPooledDataSource dataSource = new ComboPooledDataSource("myeossql");//如果加入参数就查询指定数据源，不然查询默认数据源
            QueryRunner queryRunner = new QueryRunner(dataSource);
            String sql = "select * from tb_aa_service where id >= ? ";
            //根据自己类对象 创建一个BeanListHandler对象(返回list)PS:如果是其他对象如：BeanHandler（返回单个class对象），详情https://www.cnblogs.com/nizuimeiabc1/p/7841385.html
            BeanListHandler<TB_AA_SERVICE> tb_aa_serviceBeanListHandler = new BeanListHandler<TB_AA_SERVICE>(TB_AA_SERVICE.class);
            //将sql语句，BeanListHandler对象，查询参数进行传参，因为传入的是BeanListHandler对象，所以返回的就是一个list
            List<TB_AA_SERVICE> tb_aa_serviceBListHandler = queryRunner.query(sql, tb_aa_serviceBeanListHandler, 141);

            JSONArray jsonArray = JSONArray.fromObject(tb_aa_serviceBListHandler);//将list解析为json格式
            System.out.println(jsonArray);
            response.getWriter().write(jsonArray+"");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询错误 ");
        }
    }
}
