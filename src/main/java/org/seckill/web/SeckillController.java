package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.seckill.dto.SeckillResult;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LuoJiaQi
 * @Date 2019/10/23
 * @Time 2:47
 */

@Controller
@RequestMapping("/seckill") //url:模块/资源/{id}/细分   /seckill/list
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(name = "/list",method = RequestMethod.GET)
    public String list(Model model) {
        //获取列表页
        //list.jsp + model = ModelAndView
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        return "list"; //   /WEB-INF/jsp/list.jsp
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    //ajax json
    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(Long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }
}