package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @author LuoJiaQi
 * @Date 2019/10/22
 * @Time 3:50
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细，可过滤重复，设计了seckill_id, user_phone为联合唯一主键，可以过滤重复
     *
     * @param seckillId
     * @param userPhone
     * @return 插入的行数，0表示插入失败
     */
    int insertSuccessKilled(@Param("seckillId") long  seckillId, @Param("userPhone") long userPhone);



    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}