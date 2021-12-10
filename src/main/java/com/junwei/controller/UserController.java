package com.junwei.controller;

import com.junwei.entity.ResultData;
import com.junwei.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/abc")
    public User getUser(){
        return new User(3,"sky","1234");
    }


    // 1、直接把表单的参数写在Controller相应的方法的形参中，适用于get方式提交，不适用于post方式提交。
    // url形式：http://localhost/SSMDemo/demo/addUser1?username=lixiaoxi&password=111111
    // 提交的参数需要和Controller方法中的入参名称一致。
    /**
     * 1.直接把表单的参数写在Controller相应的方法的形参中
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/addUser1")
    public String addUser1(String username,String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "demo/index";
    }



    // 2、通过HttpServletRequest接收，post方式和get方式都可以。
    /**
     * 2、通过HttpServletRequest接收
     * @param request
     * @return
     */
    @RequestMapping("/addUser2")
    public String addUser2(HttpServletRequest request) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "demo/index";
    }

    // 3、通过一个bean来接收,post方式和get方式都可以。


    public class UserModel {

        private String username;
        private String password;
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }

    }

    /**
     * 3、通过一个bean来接收
     * @param user
     * @return
     */
    @RequestMapping("/addUser3")
    public String addUser3(UserModel user) {
        System.out.println("username is:"+user.getUsername());
        System.out.println("password is:"+user.getPassword());
        return "demo/index";
    }


    // 4、通过@PathVariable获取路径中的参数
    // 例如，访问http://localhost/SSMDemo/demo/addUser4/lixiaoxi/111111 路径时，
    // 则自动将URL中模板变量{username}和{password}绑定到通过@PathVariable注解的同名参数上，即入参后username=lixiaoxi、password=111111。

    /**
     * 4、通过@PathVariable获取路径中的参数
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/addUser4/{username}/{password}",method=RequestMethod.GET)
    public ResultData<List<User>> addUser4(@PathVariable String username, @PathVariable String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return ResultData.success(new ArrayList<User>());
    }

    // 5、使用@ModelAttribute注解获取POST请求的FORM表单数据
    // Jsp表单如下：
    //<form action ="<%=request.getContextPath()%>/demo/addUser5" method="post">
    //    用户名:&nbsp;<input type="text" name="username"/><br/>
    //    密&nbsp;&nbsp;码:&nbsp;<input type="password" name="password"/><br/>
    //     <input type="submit" value="提交"/>
    //     <input type="reset" value="重置"/>
    //</form>

    // Java Controller如下：
    /**
     * 5、使用@ModelAttribute注解获取POST请求的FORM表单数据
     * @param user
     * @return
     */
    @RequestMapping(value="/addUser5",method=RequestMethod.POST)
    public String addUser5(@ModelAttribute("user") UserModel user) {
        System.out.println("username is:"+user.getUsername());
        System.out.println("password is:"+user.getPassword());
        return "demo/index";
    }


    // 6、用注解@RequestParam绑定请求参数到方法入参

    // 当请求参数username不存在时会有异常发生,可以通过设置属性required=false解决,
    // 例如: @RequestParam(value="username", required=false)
    /**
     * 6、用注解@RequestParam绑定请求参数到方法入参
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/addUser6",method=RequestMethod.GET)
    public String addUser6(@RequestParam("username") String username,@RequestParam("password") String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "demo/index";
    }

}
