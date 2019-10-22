package org.seckill.exception;

/**
 * 重复秒杀异常（运行时异常），spring声明式事务只支持运行时异常回滚
 *
 * @author LuoJiaQi
 * @Date 2019/10/22
 * @Time 17:12
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}