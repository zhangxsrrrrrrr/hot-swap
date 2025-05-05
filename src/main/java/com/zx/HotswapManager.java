package com.zx;

import jforgame.hotswap.JavaDoctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

/**
 * 以javaAgent的方式热更文件 只能修改java文件的方法体
 *
 * @author kinson
 */
public enum HotswapManager {

    /**
     * 枚举单例
     */
    INSTANCE;

    /**
     * 热更拓展参数
     */
    private Map<String, Object> extendParams;

    private Logger logger = LoggerFactory.getLogger(HotswapManager.class);


    /**
     * use jdk instrument to hotswap a loaded class you can only modify a class's
     * method!!
     *
     * @param path 热更目录
     * @return
     */
    public String reloadClass(String path) {
        try {
            if (JavaDoctor.hotSwap(getFilePath(path))) {
                return "热更成功";
            } else {
                return "热更失败";
            }
        } catch (Exception e) {
            logger.error("", e);
            return e.getMessage();
        }
    }

    private String getFilePath(String dir) {
        String defaultDir = System.getProperty("scriptDir");
        defaultDir = "E:\\idea-workspace\\demo\\hot-swap";
        String fullPath = dir;
        if (defaultDir == null || defaultDir.isEmpty()) {
            fullPath = dir + File.separator + dir;
        }
        return fullPath;
    }

}