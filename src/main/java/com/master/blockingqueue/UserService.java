package com.master.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : dingwenqiang
 * @date : 2019/8/6 22:42
 */
public class UserService {


    private ExecutorService single = Executors.newSingleThreadExecutor();

    private volatile boolean isRunning = true;

    private ArrayBlockingQueue<User> queue = new ArrayBlockingQueue<>(10);

    private void init() {
        single.execute(() -> {
            while (isRunning) {
                try {
                    User user = queue.take();
                    sendPoints(user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    {
        init();
    }

    public static void main(String[] args) {
        String name = "张三";
        UserService userService = new UserService();
        userService.register(name);
        userService.register("lisi");
        userService.register("lisi1");
        userService.register("lisi2");

    }

    private void register(String name) {
        User user = new User(name);
        addUser(user);
        queue.add(user);
    }

    private void addUser(User user) {
        System.out.println("添加用户: " + user.getName());
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sendPoints(User user) {
        System.out.println("发送积分: " + user.getName());
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
