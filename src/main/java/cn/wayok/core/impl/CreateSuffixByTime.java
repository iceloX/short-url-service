package cn.wayok.core.impl;

import cn.wayok.core.ICreateSuffix;

/**
 * @author wayok
 * @date 2021/10/7
 */
public class CreateSuffixByTime implements ICreateSuffix {

    private static String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static int scale = 62;

    /**
     * 根据当前时间生成唯一短链后缀
     * @return 短链后缀
     */
    @Override
    public String getSuffix() throws InterruptedException {
        StringBuilder suffix = new StringBuilder();
        long currentTime = System.currentTimeMillis();
        int index = 0;
        while(currentTime > scale - 1){
            index = (int) (currentTime % scale);
            suffix.append(chars.charAt(index));
            currentTime = currentTime / scale;
        }
        //进程休眠一毫秒，防止短时间内的多个请求结果相同
        Thread.sleep(1);
        return suffix.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        CreateSuffixByTime createSuffixByTime = new CreateSuffixByTime();
        createSuffixByTime.getSuffix();
    }
}
