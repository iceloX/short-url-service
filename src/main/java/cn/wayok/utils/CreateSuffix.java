package cn.wayok.utils;

/**
 * @author wayok
 * @date 2021/10/7
 */
public class CreateSuffix {

    private static String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static int scale = 62;

    /**
     * 根据当前时间生成唯一短链后缀
     * @return 短链后缀
     */
    public String getSuffix() {
        String  suffix = "";
        StringBuilder sb = new StringBuilder();
        long currentTime = System.currentTimeMillis();
        int index = 0;
        while(currentTime > scale - 1){
            index = (int) (currentTime % scale);
            sb.append(chars.charAt(index));
            currentTime = currentTime / scale;
        }
        suffix = sb.toString();
        //进程休眠一毫秒，防止短时间内的多个请求结果相同
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return suffix;
    }
}
