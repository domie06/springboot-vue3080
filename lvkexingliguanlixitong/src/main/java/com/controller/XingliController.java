
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 行李托运
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xingli")
public class XingliController {
    private static final Logger logger = LoggerFactory.getLogger(XingliController.class);

    @Autowired
    private XingliService xingliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private GongzuorenyuanService gongzuorenyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("工作人员".equals(role))
            params.put("gongzuorenyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xingliService.queryPage(params);

        //字典表数据转换
        List<XingliView> list =(List<XingliView>)page.getList();
        for(XingliView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XingliEntity xingli = xingliService.selectById(id);
        if(xingli !=null){
            //entity转view
            XingliView view = new XingliView();
            BeanUtils.copyProperties( xingli , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xingli.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XingliEntity xingli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xingli:{}",this.getClass().getName(),xingli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role)){
            xingli.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            xingli.setXingliZongjine(xingli.getXingliZhongliang() * 3);


            YonghuEntity yonghuEntity = yonghuService.selectById(xingli.getYonghuId());
            if(yonghuEntity == null)
                return R.error("查不到行李托运的用户");
            double balance = yonghuEntity.getNewMoney() - xingli.getXingliZongjine();
            if(balance<0)
                return R.error("当前这次行李托运总金额是["+xingli.getXingliZongjine()+"](每公斤3元),当前账户余额是["+yonghuEntity.getNewMoney()+"],不够支付此次托运");

            xingli.setXingliZhuangtaiTypes(1);
        }
        xingli.setInsertTime(new Date());
        xingli.setXingliYesnoTypes(1);
        xingli.setCreateTime(new Date());
        xingliService.insert(xingli);
        return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XingliEntity xingli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xingli:{}",this.getClass().getName(),xingli.toString());

        if("".equals(xingli.getXingliPhoto()) || "null".equals(xingli.getXingliPhoto())){
                xingli.setXingliPhoto(null);
        }
            xingliService.updateById(xingli);//根据id更新
            return R.ok();

    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody XingliEntity xingli, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,xingli:{}",this.getClass().getName(),xingli.toString());

        if(xingli.getXingliYesnoTypes() == 2){//通过
            XingliEntity xingliEntity = xingliService.selectById(xingli);

            YonghuEntity yonghuEntity = yonghuService.selectById(xingliEntity.getYonghuId());
        if(yonghuEntity == null)
            return R.error("查不到行李托运的用户");
        double balance = yonghuEntity.getNewMoney() - xingliEntity.getXingliZongjine();
        if(balance<0)
            return R.error("当前这次行李托运总金额是["+xingliEntity.getXingliZongjine()+"](每公斤3元),当前托运的这个账户余额不够支付此次托运,请联系用户充值后再托运.");

            yonghuEntity.setNewMoney(balance);
            yonghuService.updateById(yonghuEntity);


            xingli.setXingliZhuangtaiTypes(2);
        }else if(xingli.getXingliYesnoTypes() == 3){//拒绝
            xingli.setXingliZhuangtaiTypes(3);
        }
        xingli.setXingliShenheTime(new Date());//审核时间
        xingliService.updateById(xingli);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xingliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XingliEntity> xingliList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XingliEntity xingliEntity = new XingliEntity();
//                            xingliEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xingliEntity.setXingliUuidNumber(data.get(0));                    //行李托运编号 要改的
//                            xingliEntity.setXingliName(data.get(0));                    //行李名称 要改的
//                            xingliEntity.setXingliPhoto("");//详情和图片
//                            xingliEntity.setXingliTypes(Integer.valueOf(data.get(0)));   //行李类型 要改的
//                            xingliEntity.setXingliZhongliang(data.get(0));                    //重量(公斤) 要改的
//                            xingliEntity.setXingliZongjine(data.get(0));                    //总金额 要改的
//                            xingliEntity.setXingliContent("");//详情和图片
//                            xingliEntity.setInsertTime(date);//时间
//                            xingliEntity.setXingliZhuangtaiTypes(Integer.valueOf(data.get(0)));   //行李状态 要改的
//                            xingliEntity.setXingliYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            xingliEntity.setXingliYesnoText(data.get(0));                    //审核意见 要改的
//                            xingliEntity.setXingliShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            xingliEntity.setCreateTime(date);//时间
                            xingliList.add(xingliEntity);


                            //把要查询是否重复的字段放入map中
                                //行李托运编号
                                if(seachFields.containsKey("xingliUuidNumber")){
                                    List<String> xingliUuidNumber = seachFields.get("xingliUuidNumber");
                                    xingliUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xingliUuidNumber = new ArrayList<>();
                                    xingliUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xingliUuidNumber",xingliUuidNumber);
                                }
                        }

                        //查询是否重复
                         //行李托运编号
                        List<XingliEntity> xingliEntities_xingliUuidNumber = xingliService.selectList(new EntityWrapper<XingliEntity>().in("xingli_uuid_number", seachFields.get("xingliUuidNumber")));
                        if(xingliEntities_xingliUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XingliEntity s:xingliEntities_xingliUuidNumber){
                                repeatFields.add(s.getXingliUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [行李托运编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xingliService.insertBatch(xingliList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
