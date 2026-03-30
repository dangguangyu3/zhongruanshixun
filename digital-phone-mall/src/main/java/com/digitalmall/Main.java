package com.digitalmall;

import com.digitalmall.entity.*;
import com.digitalmall.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数码手机商城主启动类
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();
    private static PhoneService phoneService = new PhoneService();
    private static CartService cartService = new CartService();
    private static OrderService orderService = new OrderService();
    private static User currentUser = null;

    public static void main(String[] args) {
        while (true) {
            if (currentUser == null) {
                showHomeMenu();
            } else if (currentUser.getRole() == 0) {
                showUserMenu();
            } else if (currentUser.getRole() == 1) {
                showAdminMenu();
            }
        }
    }

    /**
     * 显示首页菜单
     */
    private static void showHomeMenu() {
        System.out.println("=================================");
        System.out.println("        数码手机商城");
        System.out.println("=================================");
        System.out.println("1. 注册");
        System.out.println("2. 用户登录");
        System.out.println("3. 管理员登录");
        System.out.println("4. 退出");
        System.out.println("=================================");
        System.out.print("请选择操作：");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                register();
                break;
            case 2:
                login(0);
                break;
            case 3:
                login(1);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("输入错误，请重新选择！");
        }
    }

    /**
     * 显示普通用户菜单
     */
    private static void showUserMenu() {
        System.out.println("=================================");
        System.out.println("        用户中心");
        System.out.println("=================================");
        System.out.println("1. 浏览全部手机商品");
        System.out.println("2. 查看商品详情");
        System.out.println("3. 按品牌/价格筛选搜索手机");
        System.out.println("4. 购物车管理");
        System.out.println("5. 查看历史订单");
        System.out.println("6. 修改密码");
        System.out.println("7. 退出登录");
        System.out.println("=================================");
        System.out.print("请选择操作：");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                browseAllPhones();
                break;
            case 2:
                viewPhoneDetail();
                break;
            case 3:
                searchPhones();
                break;
            case 4:
                manageCart();
                break;
            case 5:
                viewOrders();
                break;
            case 6:
                updatePassword();
                break;
            case 7:
                currentUser = null;
                System.out.println("已退出登录！");
                break;
            default:
                System.out.println("输入错误，请重新选择！");
        }
    }

    /**
     * 显示管理员菜单
     */
    private static void showAdminMenu() {
        System.out.println("=================================");
        System.out.println("        管理员中心");
        System.out.println("=================================");
        System.out.println("1. 商品管理");
        System.out.println("2. 用户管理");
        System.out.println("3. 订单管理");
        System.out.println("4. 商城数据统计");
        System.out.println("5. 修改密码");
        System.out.println("6. 退出后台");
        System.out.println("=================================");
        System.out.print("请选择操作：");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                manageProducts();
                break;
            case 2:
                manageUsers();
                break;
            case 3:
                manageOrders();
                break;
            case 4:
                statistics();
                break;
            case 5:
                updatePassword();
                break;
            case 6:
                currentUser = null;
                System.out.println("已退出后台！");
                break;
            default:
                System.out.println("输入错误，请重新选择！");
        }
    }

    /**
     * 用户注册
     */
    private static void register() {
        System.out.println("=================================");
        System.out.println("        用户注册");
        System.out.println("=================================");
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        System.out.print("请输入姓名：");
        String name = scanner.next();
        System.out.print("请输入手机号：");
        String phone = scanner.next();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);

        boolean success = userService.register(user);
        if (success) {
            System.out.println("注册成功！");
        } else {
            System.out.println("用户名已存在，注册失败！");
        }
    }

    /**
     * 用户登录
     * @param role 角色 0=普通用户 1=管理员
     */
    private static void login(int role) {
        System.out.println("=================================");
        System.out.println(role == 0 ? "        用户登录" : "        管理员登录");
        System.out.println("=================================");
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();

        User user = userService.login(username, password);
        if (user != null) {
            if (user.getRole() == role) {
                if (user.getStatus() == 1) {
                    currentUser = user;
                    System.out.println("登录成功！欢迎，" + user.getName() + "！");
                } else {
                    System.out.println("账号已被禁用！");
                }
            } else {
                System.out.println("账号类型错误！");
            }
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 浏览全部手机商品
     */
    private static void browseAllPhones() {
        System.out.println("=================================");
        System.out.println("        全部手机商品");
        System.out.println("=================================");
        List<Phone> phones = phoneService.findAllPhones();
        if (phones.isEmpty()) {
            System.out.println("暂无商品！");
        } else {
            System.out.println("ID  品牌       型号               价格      库存  状态");
            System.out.println("-------------------------------------------------------");
            for (Phone phone : phones) {
                System.out.printf("%2d  %-10s %-20s %8.2f  %4d  %s\n",
                        phone.getId(),
                        phone.getBrand(),
                        phone.getModel(),
                        phone.getPrice(),
                        phone.getStock(),
                        phone.getStatus() == 1 ? "上架" : "下架");
            }
        }
        System.out.println("=================================");
        System.out.print("是否添加商品到购物车？(1=是，0=否)：");
        int choice = getIntInput();
        if (choice == 1) {
            System.out.print("请输入商品ID：");
            int phoneId = getIntInput();
            System.out.print("请输入购买数量：");
            int quantity = getIntInput();
            addToCart(phoneId, quantity);
        }
    }

    /**
     * 查看商品详情
     */
    private static void viewPhoneDetail() {
        System.out.print("请输入商品ID：");
        int phoneId = getIntInput();
        Phone phone = phoneService.findPhoneById(phoneId);
        if (phone != null) {
            System.out.println("=================================");
            System.out.println("        商品详情");
            System.out.println("=================================");
            System.out.println("ID：" + phone.getId());
            System.out.println("品牌：" + phone.getBrand());
            System.out.println("型号：" + phone.getModel());
            System.out.println("价格：" + phone.getPrice());
            System.out.println("库存：" + phone.getStock());
            System.out.println("状态：" + (phone.getStatus() == 1 ? "上架" : "下架"));
            System.out.println("描述：" + phone.getDescription());
            System.out.println("=================================");
            System.out.print("是否添加到购物车？(1=是，0=否)：");
            int choice = getIntInput();
            if (choice == 1) {
                System.out.print("请输入购买数量：");
                int quantity = getIntInput();
                addToCart(phoneId, quantity);
            }
        } else {
            System.out.println("商品不存在！");
        }
    }

    /**
     * 按品牌/价格筛选搜索手机
     */
    private static void searchPhones() {
        System.out.println("=================================");
        System.out.println("        商品搜索");
        System.out.println("=================================");
        System.out.println("1. 按品牌搜索");
        System.out.println("2. 按价格范围搜索");
        System.out.print("请选择搜索方式：");
        int choice = getIntInput();
        List<Phone> phones = new ArrayList<>();
        switch (choice) {
            case 1:
                System.out.print("请输入品牌：");
                String brand = scanner.next();
                phones = phoneService.findPhonesByBrand(brand);
                break;
            case 2:
                System.out.print("请输入最低价格：");
                double minPrice = getDoubleInput();
                System.out.print("请输入最高价格：");
                double maxPrice = getDoubleInput();
                phones = phoneService.findPhonesByPriceRange(minPrice, maxPrice);
                break;
            default:
                System.out.println("输入错误！");
                return;
        }

        if (phones.isEmpty()) {
            System.out.println("暂无符合条件的商品！");
        } else {
            System.out.println("ID  品牌       型号               价格      库存  状态");
            System.out.println("-------------------------------------------------------");
            for (Phone phone : phones) {
                System.out.printf("%2d  %-10s %-20s %8.2f  %4d  %s\n",
                        phone.getId(),
                        phone.getBrand(),
                        phone.getModel(),
                        phone.getPrice(),
                        phone.getStock(),
                        phone.getStatus() == 1 ? "上架" : "下架");
            }
        }
    }

    /**
     * 添加商品到购物车
     * @param phoneId 手机ID
     * @param quantity 数量
     */
    private static void addToCart(int phoneId, int quantity) {
        Phone phone = phoneService.findPhoneById(phoneId);
        if (phone != null) {
            if (phone.getStatus() == 1) {
                if (phone.getStock() >= quantity) {
                    Cart cart = new Cart();
                    cart.setUserId(currentUser.getId());
                    cart.setPhoneId(phoneId);
                    cart.setQuantity(quantity);
                    boolean success = cartService.addToCart(cart);
                    if (success) {
                        System.out.println("添加成功！");
                    } else {
                        System.out.println("添加失败！");
                    }
                } else {
                    System.out.println("库存不足！");
                }
            } else {
                System.out.println("商品已下架！");
            }
        } else {
            System.out.println("商品不存在！");
        }
    }

    /**
     * 购物车管理
     */
    private static void manageCart() {
        while (true) {
            System.out.println("=================================");
            System.out.println("        购物车管理");
            System.out.println("=================================");
            List<Cart> cartList = cartService.findCartByUserId(currentUser.getId());
            if (cartList.isEmpty()) {
                System.out.println("购物车为空！");
                break;
            } else {
                double total = 0;
                System.out.println("ID  品牌       型号               价格      数量  小计");
                System.out.println("-------------------------------------------------------");
                for (Cart cart : cartList) {
                    double subtotal = cart.getPhone().getPrice() * cart.getQuantity();
                    total += subtotal;
                    System.out.printf("%2d  %-10s %-20s %8.2f  %4d  %8.2f\n",
                            cart.getId(),
                            cart.getPhone().getBrand(),
                            cart.getPhone().getModel(),
                            cart.getPhone().getPrice(),
                            cart.getQuantity(),
                            subtotal);
                }
                System.out.println("-------------------------------------------------------");
                System.out.printf("总计：%28.2f\n", total);
            }
            System.out.println("=================================");
            System.out.println("1. 修改商品数量");
            System.out.println("2. 删除商品");
            System.out.println("3. 结算");
            System.out.println("4. 返回");
            System.out.print("请选择操作：");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("请输入购物车ID：");
                    int cartId = getIntInput();
                    System.out.print("请输入新数量：");
                    int quantity = getIntInput();
                    boolean updateSuccess = cartService.updateCartQuantity(cartId, quantity);
                    if (updateSuccess) {
                        System.out.println("修改成功！");
                    } else {
                        System.out.println("修改失败！");
                    }
                    break;
                case 2:
                    System.out.print("请输入购物车ID：");
                    cartId = getIntInput();
                    boolean deleteSuccess = cartService.deleteCartItem(cartId);
                    if (deleteSuccess) {
                        System.out.println("删除成功！");
                    } else {
                        System.out.println("删除失败！");
                    }
                    break;
                case 3:
                    checkout();
                    return;
                case 4:
                    return;
                default:
                    System.out.println("输入错误，请重新选择！");
            }
        }
    }

    /**
     * 结算购物车
     */
    private static void checkout() {
        List<Cart> cartList = cartService.findCartByUserId(currentUser.getId());
        if (cartList.isEmpty()) {
            System.out.println("购物车为空！");
            return;
        }

        // 计算总金额
        double totalAmount = 0;
        List<OrderItem> orderItems = new ArrayList<>();
        for (Cart cart : cartList) {
            double subtotal = cart.getPhone().getPrice() * cart.getQuantity();
            totalAmount += subtotal;
            OrderItem orderItem = new OrderItem();
            orderItem.setPhoneId(cart.getPhoneId());
            orderItem.setQuantity(cart.getQuantity());
            orderItem.setPrice(cart.getPhone().getPrice());
            orderItem.setPhone(cart.getPhone());
            orderItems.add(orderItem);
        }

        // 创建订单
        Order order = new Order();
        order.setUserId(currentUser.getId());
        order.setTotalAmount(totalAmount);
        boolean success = orderService.createOrder(order, orderItems);
        if (success) {
            System.out.println("订单创建成功！订单号：" + order.getOrderNo());
        } else {
            System.out.println("订单创建失败！");
        }
    }

    /**
     * 查看历史订单
     */
    private static void viewOrders() {
        System.out.println("=================================");
        System.out.println("        历史订单");
        System.out.println("=================================");
        List<Order> orders = orderService.findOrdersByUserId(currentUser.getId());
        if (orders.isEmpty()) {
            System.out.println("暂无订单！");
        } else {
            for (Order order : orders) {
                System.out.println("订单号：" + order.getOrderNo());
                System.out.println("下单时间：" + order.getCreateTime());
                System.out.println("总金额：" + order.getTotalAmount());
                System.out.println("状态：" + getOrderStatusText(order.getStatus()));
                System.out.println("商品详情：");
                for (OrderItem item : order.getOrderItems()) {
                    System.out.printf("  - %s %s x %d = %.2f\n",
                            item.getPhone().getBrand(),
                            item.getPhone().getModel(),
                            item.getQuantity(),
                            item.getPrice() * item.getQuantity());
                }
                System.out.println("---------------------------------");
            }
        }
    }

    /**
     * 修改密码
     */
    private static void updatePassword() {
        System.out.print("请输入新密码：");
        String newPassword = scanner.next();
        boolean success = userService.updatePassword(currentUser.getId(), newPassword);
        if (success) {
            System.out.println("密码修改成功！");
        } else {
            System.out.println("密码修改失败！");
        }
    }

    /**
     * 商品管理
     */
    private static void manageProducts() {
        while (true) {
            System.out.println("=================================");
            System.out.println("        商品管理");
            System.out.println("=================================");
            System.out.println("1. 新增手机");
            System.out.println("2. 修改商品信息");
            System.out.println("3. 上下架商品");
            System.out.println("4. 删除商品");
            System.out.println("5. 查询所有商品");
            System.out.println("6. 返回");
            System.out.print("请选择操作：");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    updatePhone();
                    break;
                case 3:
                    changePhoneStatus();
                    break;
                case 4:
                    deletePhone();
                    break;
                case 5:
                    listAllPhones();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("输入错误，请重新选择！");
            }
        }
    }

    /**
     * 新增手机
     */
    private static void addPhone() {
        System.out.println("=================================");
        System.out.println("        新增手机");
        System.out.println("=================================");
        System.out.print("请输入品牌：");
        String brand = scanner.next();
        System.out.print("请输入型号：");
        String model = scanner.next();
        System.out.print("请输入价格：");
        double price = getDoubleInput();
        System.out.print("请输入库存：");
        int stock = getIntInput();
        System.out.print("请输入描述：");
        scanner.nextLine(); //  consume newline
        String description = scanner.nextLine();

        Phone phone = new Phone();
        phone.setBrand(brand);
        phone.setModel(model);
        phone.setPrice(price);
        phone.setStock(stock);
        phone.setDescription(description);
        phone.setStatus(1); // 默认上架

        boolean success = phoneService.addPhone(phone);
        if (success) {
            System.out.println("新增成功！");
        } else {
            System.out.println("新增失败！");
        }
    }

    /**
     * 修改商品信息
     */
    private static void updatePhone() {
        System.out.print("请输入商品ID：");
        int phoneId = getIntInput();
        Phone phone = phoneService.findPhoneById(phoneId);
        if (phone != null) {
            System.out.println("=================================");
            System.out.println("        修改商品信息");
            System.out.println("=================================");
            System.out.print("请输入品牌（当前：" + phone.getBrand() + "）：");
            String brand = scanner.next();
            System.out.print("请输入型号（当前：" + phone.getModel() + "）：");
            String model = scanner.next();
            System.out.print("请输入价格（当前：" + phone.getPrice() + "）：");
            double price = getDoubleInput();
            System.out.print("请输入库存（当前：" + phone.getStock() + "）：");
            int stock = getIntInput();
            System.out.print("请输入描述（当前：" + phone.getDescription() + "）：");
            scanner.nextLine(); //  consume newline
            String description = scanner.nextLine();

            phone.setBrand(brand);
            phone.setModel(model);
            phone.setPrice(price);
            phone.setStock(stock);
            phone.setDescription(description);

            boolean success = phoneService.updatePhone(phone);
            if (success) {
                System.out.println("修改成功！");
            } else {
                System.out.println("修改失败！");
            }
        } else {
            System.out.println("商品不存在！");
        }
    }

    /**
     * 上下架商品
     */
    private static void changePhoneStatus() {
        System.out.print("请输入商品ID：");
        int phoneId = getIntInput();
        Phone phone = phoneService.findPhoneById(phoneId);
        if (phone != null) {
            int newStatus = phone.getStatus() == 1 ? 0 : 1;
            boolean success = phoneService.updatePhoneStatus(phoneId, newStatus);
            if (success) {
                System.out.println("商品已" + (newStatus == 1 ? "上架" : "下架") + "！");
            } else {
                System.out.println("操作失败！");
            }
        } else {
            System.out.println("商品不存在！");
        }
    }

    /**
     * 删除商品
     */
    private static void deletePhone() {
        System.out.print("请输入商品ID：");
        int phoneId = getIntInput();
        boolean success = phoneService.deletePhone(phoneId);
        if (success) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    /**
     * 查询所有商品
     */
    private static void listAllPhones() {
        System.out.println("=================================");
        System.out.println("        所有商品");
        System.out.println("=================================");
        List<Phone> phones = phoneService.findAllPhones();
        if (phones.isEmpty()) {
            System.out.println("暂无商品！");
        } else {
            System.out.println("ID  品牌       型号               价格      库存  状态");
            System.out.println("-------------------------------------------------------");
            for (Phone phone : phones) {
                System.out.printf("%2d  %-10s %-20s %8.2f  %4d  %s\n",
                        phone.getId(),
                        phone.getBrand(),
                        phone.getModel(),
                        phone.getPrice(),
                        phone.getStock(),
                        phone.getStatus() == 1 ? "上架" : "下架");
            }
        }
    }

    /**
     * 用户管理
     */
    private static void manageUsers() {
        System.out.println("=================================");
        System.out.println("        用户管理");
        System.out.println("=================================");
        List<User> users = userService.findAllUsers();
        System.out.println("ID  用户名     姓名       手机号          角色      状态");
        System.out.println("-------------------------------------------------------");
        for (User user : users) {
            System.out.printf("%2d  %-10s %-10s %-15s %-8s %s\n",
                    user.getId(),
                    user.getUsername(),
                    user.getName(),
                    user.getPhone(),
                    user.getRole() == 0 ? "普通用户" : "管理员",
                    user.getStatus() == 1 ? "正常" : "禁用");
        }
        System.out.println("=================================");
        System.out.print("请输入要修改状态的用户ID：");
        int userId = getIntInput();
        System.out.print("请输入新状态（1=正常，0=禁用）：");
        int status = getIntInput();
        boolean success = userService.updateUserStatus(userId, status);
        if (success) {
            System.out.println("状态修改成功！");
        } else {
            System.out.println("状态修改失败！");
        }
    }

    /**
     * 订单管理
     */
    private static void manageOrders() {
        while (true) {
            System.out.println("=================================");
            System.out.println("        订单管理");
            System.out.println("=================================");
            System.out.println("1. 查看所有订单");
            System.out.println("2. 按状态查询订单");
            System.out.println("3. 修改订单状态");
            System.out.println("4. 返回");
            System.out.print("请选择操作：");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    listAllOrders();
                    break;
                case 2:
                    System.out.print("请输入订单状态（0=待支付，1=已支付，2=已发货，3=已完成，4=已取消）：");
                    int status = getIntInput();
                    listOrdersByStatus(status);
                    break;
                case 3:
                    System.out.print("请输入订单ID：");
                    int orderId = getIntInput();
                    System.out.print("请输入新状态（0=待支付，1=已支付，2=已发货，3=已完成，4=已取消）：");
                    status = getIntInput();
                    boolean success = orderService.updateOrderStatus(orderId, status);
                    if (success) {
                        System.out.println("状态修改成功！");
                    } else {
                        System.out.println("状态修改失败！");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("输入错误，请重新选择！");
            }
        }
    }

    /**
     * 查看所有订单
     */
    private static void listAllOrders() {
        List<Order> orders = orderService.findAllOrders();
        displayOrders(orders);
    }

    /**
     * 按状态查询订单
     * @param status 状态
     */
    private static void listOrdersByStatus(int status) {
        List<Order> orders = orderService.findOrdersByStatus(status);
        displayOrders(orders);
    }

    /**
     * 显示订单列表
     * @param orders 订单列表
     */
    private static void displayOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("暂无订单！");
        } else {
            for (Order order : orders) {
                System.out.println("订单ID：" + order.getId());
                System.out.println("订单号：" + order.getOrderNo());
                System.out.println("用户ID：" + order.getUserId());
                System.out.println("下单时间：" + order.getCreateTime());
                System.out.println("总金额：" + order.getTotalAmount());
                System.out.println("状态：" + getOrderStatusText(order.getStatus()));
                System.out.println("商品详情：");
                for (OrderItem item : order.getOrderItems()) {
                    System.out.printf("  - %s %s x %d = %.2f\n",
                            item.getPhone().getBrand(),
                            item.getPhone().getModel(),
                            item.getQuantity(),
                            item.getPrice() * item.getQuantity());
                }
                System.out.println("---------------------------------");
            }
        }
    }

    /**
     * 商城数据统计
     */
    private static void statistics() {
        System.out.println("=================================");
        System.out.println("        商城数据统计");
        System.out.println("=================================");
        // 这里可以实现销量统计和库存预警统计
        System.out.println("1. 销量统计");
        System.out.println("2. 库存预警统计");
        System.out.print("请选择操作：");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                // 销量统计逻辑
                System.out.println("销量统计功能开发中...");
                break;
            case 2:
                // 库存预警统计逻辑
                System.out.println("库存预警统计功能开发中...");
                break;
            default:
                System.out.println("输入错误！");
        }
    }

    /**
     * 获取订单状态文本
     * @param status 状态码
     * @return 状态文本
     */
    private static String getOrderStatusText(int status) {
        switch (status) {
            case 0:
                return "待支付";
            case 1:
                return "已支付";
            case 2:
                return "已发货";
            case 3:
                return "已完成";
            case 4:
                return "已取消";
            default:
                return "未知状态";
        }
    }

    /**
     * 获取整数输入
     * @return 整数
     */
    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("输入错误，请重新输入：");
            }
        }
    }

    /**
     * 获取浮点数输入
     * @return 浮点数
     */
    private static double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("输入错误，请重新输入：");
            }
        }
    }
}