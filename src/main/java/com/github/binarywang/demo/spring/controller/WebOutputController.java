package com.github.binarywang.demo.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/wechat/web")
public class WebOutputController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView  get(@RequestParam(name = "code", required = false) String code) {
        this.logger.info("\n接收到消息：[{}]", code);
        String s = searchMovie(code);
//        Pattern pattern = Pattern.compile("\\s*|\t|\r|\n"); //去掉空格符合换行符
//        Matcher matcher = pattern.matcher(s);
//        String result = matcher.replaceAll("");
        ModelAndView mav = new ModelAndView("Index");
        //将参数返回给页面
        mav.addObject("detail",s);
        return mav;
    }

    private String searchMovie(String code) {
        Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建javademo数据库
        String url = "jdbc:mysql://localhost:3306/Movie_db?"
                + "user=yanglong&password=123456&useUnicode=true&characterEncoding=gbk";

        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or：
            // new com.mysql.jdbc.Driver();

            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();
//			sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
//			int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
//			if (result != -1) {
//				System.out.println("创建数据表成功");
//				sql = "insert into student(NO,name) values('2012001','陶伟基')";
//				result = stmt.executeUpdate(sql);
//      sql = "insert into tb_movie(code,detail,title) values('"+bean.getCode()+"','"+bean.getDetail()+"','"+bean.getTitle()+"')";
//      int result = stmt.executeUpdate(sql);
            StringBuffer sbSql = new StringBuffer("select * from tb_movie where  code ="+code);
//            sbSql.append("select * from tb_movie where  ");
//            int length = movieName.length();
//            for (int i = 0; i < length; i++) {
//                char c = movieName.charAt(i);
//                if (i != 0) {
//                    sbSql.append("and title like '%" + c + "%'");
//                } else {
//
//                    sbSql.append("title like '%" + c + "%'");
//                }
//            }
//            sql = "select * from tb_movie where title like '" + movieName + "%'";
            ResultSet rs = stmt.executeQuery(sbSql.toString());// executeQuery会返回结果的集合，否则返回空值
            System.out.println("code\t地址\t标题");
            String s = "sorry！没有找到该影剧！";
            while (rs.next()) {
                System.out
                        .println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));// 入如果返回的是int类型可以用getInt()
                s = rs.getString(3) + "\n" + rs.getString(2);

                if (rs.getString(2)!=null) {
                    return rs.getString(2);
                }
            }

//            if ("sorry！没有找到该影剧！".equals(s)) {
//                sql = "insert into tb_error_name(name) values('" + movieName + "')";
//                int result = stmt.executeUpdate(sql);
//            }

            return s;
//			}
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";

    }
}
