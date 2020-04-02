package com.apesource.test;

import com.apesource.pojo.*;
import com.apesource.service.base.ICommentService;
import com.apesource.service.base.IMenuService;
import com.apesource.service.base.IUsersService;
import com.apesource.service.impl.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void show() throws IOException {
        Scanner sc = new Scanner(System.in);
        //点餐系统
        //系统登录
        System.out.println("=====欢迎进入点餐系统======");
        System.out.println("请输入用户名");
        String name = sc.next();
        IUsersService usersService = new UsersService();
        Users user = usersService.selectByName(name);
        //判断用户登录信息
        if (null == user) {
            System.out.println("该用户未注册");
            System.out.println("是否注册新账户（y/n）");
            String y1 = sc.next();
            if ("y".equalsIgnoreCase(y1)) {
                System.out.println("请输入账号名");
                String name1 = sc.next();
                System.out.println("请输入密码");
                String pwd1 = sc.next();
                Users users = new Users();
                users.setUserName(name1);
                users.setUserPassword(pwd1);
                UsersService usersService1 = new UsersService();
                int i = usersService1.insertUser(users);
                if (i == 1) {
                    System.out.println("注册成功");

                } else {
                    System.out.println("注册失败");
                }
            }
        } else {
            System.out.println("请输入用户密码");
            String pwd = sc.next();
            if (!pwd.equals(user.getUserPassword())) {
                System.out.println("密码不正确！请重新输入");

            } else {
                //获得用户id====
                int uid = user.getUserId();
                String pwd0 = user.getUserPassword();
                System.out.println("登录成功");
                System.out.println("=========================================");
                p:
                while (true) {
                    //进入菜单系统
                    System.out.println("=================欢迎来到点餐系统==================");
                    System.out.println("1.查看外卖");
                    System.out.println("2.查看我的订单");
                    System.out.println("3.我的地址信息");
                    System.out.println("4.评价");
                    System.out.println("5.修改密码");
                    System.out.println("6.退出系统");
                    System.out.println("请选择要进入的模块");
                    int m = sc.nextInt();

                    switch (m) {
                        //进入查看外卖模块
                        case 1: {
                            IMenuService menuService = new MenuService();
                            //获取菜品信息
                            List<Menu> menus = menuService.selectAll();
                            System.out.println("菜单编号\t 菜品名称\t 价格\t 评分");
                            menus.forEach(me -> System.out.println(me.getmId() + "\t" + me.getmMname() + "\t" + me.getmCost() + "\t" + me.getmPoint()));
                            System.out.println("===================================");
                            System.out.println("请选择菜品");
                            int or = sc.nextInt();
                            //选择菜品
                            Menu menu = menuService.selectById(or);
                            //菜品id=====
                            int mid = menu.getmId();
                            System.out.println("您选择的是：" + menu);
                            //选择送货地址
                            AddressService addressService = new AddressService();
                            List<Address> addresses = addressService.selectAllByUserId(uid);

                            if ( addresses.isEmpty()){

                                //添加收货地址
                                AddressService addressService3 = new AddressService();
                                System.out.println("请添加地址信息");
                                String adds = sc.next();
                                Address address = new Address();
                                address.setUserId(uid);
                                address.setAddress(adds);
                                int i = addressService3.insertAddress(address);
                                if (i == 1) {
                                    System.out.println("地址新增成功");
                                } else {
                                    System.out.println("地址新增失败");
                                }
                            }
                            AddressService addressService2 = new AddressService();
                            List<Address> addresses2 = addressService.selectAllByUserId(uid);
                            System.out.println("地址编号 地址信息 用户id 用户名");
                            addresses2.forEach(ad -> System.out.println(ad.getAddId() + "\t" + ad.getAddress() + "\t" + ad.getUserId() + "\t" + ad.getUser().getUserName()));
                            System.out.println("================================================");
                            System.out.println("请选择需要使用的地址编号");
                            //地址id====
                            int addid = sc.nextInt();
                            Address address = addressService.selectByid(addid);
                            System.out.println("您选择的地址是：" + address.getAddId() + "\t" + address.getAddress() + "\t" + address.getUserId() + "\t" + address.getUser().getUserName());


                            //处理订单时间
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            String date = sdf.format(new Date());
                            //保存订单信息
                            Order1 order1 = new Order1();
                            order1.setmId(mid);
                            order1.setUserId(uid);
                            order1.setCreateDate(date);
                            order1.setOrderType(0);

                            Order1Service order1Service = new Order1Service();
                            order1Service.insertOrder(order1);
                            //新产生的订单id
                            int oid = order1.getOrderId();
                            //System.out.println("回填订单ID "+order1.getOrderId());
                            System.out.println("确认支付吗？Y/N");
                            String yn = sc.next();
                            if (yn.equalsIgnoreCase("y")) {
                                order1.setOrderType(1);
                                order1Service.updateByOrderId(oid);
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("==============我的订单==================");
                            System.out.println("1.全部订单");
                            System.out.println("2.已支付订单");
                            System.out.println("3.未支付订单");
                            int ding = sc.nextInt();
                            switch (ding) {
                                case 1: {
                                    Order1Service order1Service = new Order1Service();
                                    List<Order1> order1s = order1Service.selectByUserId(uid);
                                    //修改订单状态

                                    System.out.println("订单编号\t 用户编号\t 用户名\t 菜单编号\t 菜品名称\t 菜单价格\t 菜品积分\t 支付状态\t 订单日期");
                                    // System.out.println(order1s);
                                    for (Order1 o : order1s
                                            ) {
                                        if (o.getOrderType() == 1) {
                                            System.out.println(o.getOrderId() + "\t" + o.getUserId() + "\t" + o.getUsers().getUserName() + "\t" + o.getmId() + "\t" + o.getMenu().getmMname() + "\t" + o.getMenu().getmCost() + "\t" + o.getMenu().getmPoint() + "\t" + "已支付" + "\t" + o.getCreateDate());
                                        } else {
                                            System.out.println(o.getOrderId() + "\t" + o.getUserId() + "\t" + o.getUsers().getUserName() + "\t" + o.getmId() + "\t" + o.getMenu().getmMname() + "\t" + o.getMenu().getmCost() + "\t" + o.getMenu().getmPoint() + "\t" + "未支付" + "\t" + o.getCreateDate());

                                        }
                                    }
                                    //System.out.println();
                                    break;
                                }
                                case 2: {
                                    Order1Service order1Service = new Order1Service();
                                    List<Order1> order1s = order1Service.selectByUserIdByType(uid);
                                    System.out.println("订单编号\t 用户编号\t 用户名\t 菜单编号\t 菜品名称\t 菜单价格\t 菜品积分\t 支付状态\t 订单日期");
                                    // System.out.println(order1s);
                                    order1s.forEach(o -> System.out.println(o.getOrderId() + "\t" + o.getUserId() + "\t" + o.getUsers().getUserName() + "\t" + o.getmId() + "\t" + o.getMenu().getmMname() + "\t" + o.getMenu().getmCost() + "\t" + o.getMenu().getmPoint() + "\t" + "已支付" + "\t" + o.getCreateDate()));
                                    //System.out.println(o.getOrderId()+"\t"+o.getUserId()+"\t"+o.getUsers().getUserName()+"\t"+o.getmId()+"\t"+o.getMenu().getmMname()+"\t"+o.getMenu().getmCost()+"\t"+o.getMenu().getmPoint() + "\t"+"未支付"+"\t"+o.getCreateDate());
                                    break;
                                }

                                case 3: {
                                    Order1Service order1Service = new Order1Service();
                                    List<Order1> order1s = order1Service.selectByUserIdByTypeNo(uid);
                                    System.out.println("订单编号\t 用户编号\t 用户名\t 菜单编号\t 菜品名称\t 菜单价格\t 菜品积分\t 支付状态\t 订单日期");
                                    order1s.forEach(o -> System.out.println(o.getOrderId() + "\t" + o.getUserId() + "\t" + o.getUsers().getUserName() + "\t" + o.getmId() + "\t" + o.getMenu().getmMname() + "\t" + o.getMenu().getmCost() + "\t" + o.getMenu().getmPoint() + "\t" + "未支付" + "\t" + o.getCreateDate()));
                                    break;
                                }

                            }

                            break;

                        }


                        case 3: {
                            System.out.println("===============地址信息===============");
                            System.out.println("1.查看已有地址");
                            System.out.println("2.新增地址");
                            System.out.println("3.修改地址");
                            System.out.println("4.删除地址");
                            System.out.println("请选择要操作的模块");
                            int add = sc.nextInt();
                            switch (add) {
                                case 1: {
                                    System.out.println("====================我的地址======================");
                                    System.out.println("地址编号 地址信息 用户id 用户名");
                                    AddressService addressService = new AddressService();
                                    List<Address> addresses = addressService.selectAllByUserId(uid);
                                    addresses.forEach(address -> System.out.println(address.getAddId() + "\t" + address.getAddress() + "\t" + address.getUserId() + "\t" + address.getUser().getUserName()));
                                    break;
                                }
                                case 2: {
                                    AddressService addressService = new AddressService();
                                    System.out.println("请输入地址信息");
                                    String adds = sc.next();
                                    Address address = new Address();
                                    address.setUserId(uid);
                                    address.setAddress(adds);
                                    int i = addressService.insertAddress(address);
                                    if (i == 1) {
                                        System.out.println("地址新增成功");
                                    } else {
                                        System.out.println("地址新增失败");
                                    }
                                    break;
                                }
                                case 3: {
                                    System.out.println("请输入要修改的地址编号");
                                    int aid = sc.nextInt();
                                    System.out.println("请重新输入地址");
                                    String add1 = sc.next();
                                    Address address = new Address();
                                    address.setAddress(add1);
                                    address.setAddId(aid);
                                    AddressService addressService = new AddressService();
                                    int i = addressService.updateAddress(address);
                                    if (i == 1) {
                                        System.out.println("修改成功");
                                    } else {
                                        System.out.println("修改失败");
                                    }
                                    break;

                                }
                                case 4: {
                                    System.out.println("请输入要删除的地址id");
                                    int ad = sc.nextInt();
                                    AddressService addressService = new AddressService();
                                    int i = addressService.deleteAddressById(ad);
                                    if (i == 1) {
                                        System.out.println("删除成功");
                                    } else {
                                        System.out.println("删除失败");
                                    }
                                    break;
                                }
                            }
                            break;
                        }

                        case 4: {
                            System.out.println("欢迎进入评价页面");
                            Order1Service order1Service = new Order1Service();
                            List<Order1> order1s = order1Service.selectByUserIdByType(uid);
                            System.out.println("订单编号\t 用户编号\t 用户名\t 菜单编号\t 菜品名称\t 菜单价格\t 菜品积分\t 支付状态\t 订单日期");
                            order1s.forEach(o -> System.out.println(o.getOrderId() + "\t" + o.getUserId() + "\t" + o.getUsers().getUserName() + "\t" + o.getmId() + "\t" + o.getMenu().getmMname() + "\t" + o.getMenu().getmCost() + "\t" + o.getMenu().getmPoint() + "\t" + o.getOrderType() + "\t" + o.getCreateDate()));
                            System.out.println("请选择您要评价的菜品编号");
                            int oid = sc.nextInt();
                            System.out.println("请输入评论内容，200字以内");
                            String comment = sc.next();
                            System.out.println("请输入评论的星级");
                            int star = sc.nextInt();

                            Comment comment1 = new Comment();
                            comment1.setComStar(star);
                            comment1.setComComment(comment);

                            ICommentService commentService = new CommentService();
                            int i = commentService.InsertComment(comment1);
                            //评论编号(评论后回填)
                            int comid = comment1.getComId();
                            System.out.println(comid);
                            //向订单添加评论id
                            Order1Service order1Service1 = new Order1Service();
                            int i1 = order1Service1.updateCommentId(comid, oid);
                            if (i1 == 1) {
                                System.out.println("评论成功");
                            }
                            break ;
                        }
                        //修改密码
                        case 5: {
                            System.out.println("请输入原始密码");
                            String pwd1 = sc.next();
                            if (pwd0.equalsIgnoreCase(pwd1)) {
                                System.out.println("请输入新密码");
                                String sp = sc.next();
                                Users users = new Users();
                                users.setUserPassword(sp);
                                users.setUserId(uid);
                                UsersService usersService1 = new UsersService();
                                int i = usersService1.updatePwd(users);
                                if (i == 1) {
                                    System.out.println("修改成功");
                                } else {
                                    System.out.println("修改失败");
                                }
                            }else{
                                System.out.println("修改失败");
                            }
                            break ;
                        }
                        case 6: {
                            System.out.println("欢迎再次使用");
                            break p;
                        }
                    }
                }
            }
        }
    }

}
