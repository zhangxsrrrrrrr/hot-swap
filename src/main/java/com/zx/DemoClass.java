package com.zx;

import jforgame.hotswap.JavaDoctor;

public class DemoClass {
    public static void main(String[] args) throws InterruptedException {
        JavaDoctor.setAgentPath("E:\\idea-workspace\\demo\\hot-swap\\agent\\jforgame-hotswap-agent-1.0.0.jar");
        User.say();
//        Thread.sleep(1000 * 15);
        HotswapManager.INSTANCE.reloadClass("hotswap");
        User.say();
    }


}
