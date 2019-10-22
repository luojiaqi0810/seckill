package org.seckill.exception;

/**
 * 秒杀关闭异常
 *
 * @author LuoJiaQi
 * @Date 2019/10/22
 * @Time 17:15
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}