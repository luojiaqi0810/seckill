package org.seckill.exception;

/**
 * 秒杀业务相关业务异常
 *
 * @author LuoJiaQi
 * @Date 2019/10/22
 * @Time 17:16
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}