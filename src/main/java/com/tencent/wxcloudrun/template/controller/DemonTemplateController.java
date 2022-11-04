package com.tencent.wxcloudrun.template.controller;

import com.tencent.wxcloudrun.template.service.TerminalService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONStringer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/xcx/demon")
public class DemonTemplateController {

    @Autowired
    private TerminalService terminalService;


    @RequestMapping("/template")
    @ResponseBody
    public Map<String,Object> xcx(HttpServletRequest request, HttpServletResponse responese){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result", "yes");

        try {
            responese.setCharacterEncoding("utf-8");
            Map<String, String[]> map = request.getParameterMap();
            log.info("接口请求：" + map.toString());
            String mode = request.getParameter("mode");
            if("1".equals(mode)){ //商户小程序登录，查看当前人信息是否绑定，吧绑定返回商家信息，没绑定返回no，跳转到登录页
                log.info("********商户小程序:	登录***************");
                result.put("data",terminalService.loginAdmin(map));
            }else if("2".equals(mode)) {
                log.info("********商户小程序:	用户名密码登录********");
                result.put("data",terminalService.loginAdminByUserName(map));
            }else if("3".equals(mode)) {
                log.info("********商户小程序:	商家福利列表*********");
                result.put("data",terminalService.queryWelfareByCompanyId(map));
            }else if("4".equals(mode)) {
                log.info("********商户小程序:	福利详情************");//缺东西
                result.put("data",terminalService.findWelfareById(map));
            }else if("8".equals(mode)) {
                log.info("********商户小程序:	订单列表************");
                result.put("data",terminalService.loadOrderByPage(map));
            }else if("5".equals(mode)) {
                log.info("********商户小程序:	改订单发货状态********");
                result.put("data",terminalService.changeOrderType(map));
            }else if ("6".equals(mode)) {
                log.info("********商户小程序:	访问量********");
                result.put("data",terminalService.findRecordsView(map));
            }else if ("7".equals(mode)) {
                log.info("********商户小程序:	分享量********");
                result.put("data",terminalService.findRecordsShare(map));
            }else if ("9".equals(mode)) {
                log.info("********商户小程序:	订单详情********");
                result.put("data",terminalService.loadOrderByOrderId(map));
            }else if ("10".equals(mode)) {
                log.info("********商户小程序:	echarts********");
                result.put("data",terminalService.loadEchartsId(map));
            }else if ("11".equals(mode)) {
                log.info("********商户小程序:	echarts(时间)********");
                result.put("data",terminalService.loadEchartsByTime(map));
            }else if ("12".equals(mode)) {
                log.info("********商户小程序:	快递信息********");
                result.put("data",terminalService.loadExpressinformation(map));
            }else if ("12.2".equals(mode)) {
                log.info("********商户小程序:	快递信息（备用）********");
                result.put("data",terminalService.loadExpressinformationTwo(map));
            }else if ("13".equals(mode)) {
                log.info("********商户小程序:	核销票券********");
                result.put("data",terminalService.verification(map));
            }else if ("14".equals(mode)) {
                log.info("********商户小程序:	票券核销列表展示********");
                result.put("data",terminalService.verificationList(map));
            }else if ("15".equals(mode)) {
                log.info("********商户小程序:	查询今日核销数和总核销数********");
                result.put("data",terminalService.queryVerification(map));
            }else if ("16".equals(mode)) {
                log.info("********商户小程序:	扫一扫--搜索券码查看详情********");
                result.put("data",terminalService.queryTickedDetail(map));
            }else if ("17".equals(mode)) {
                log.info("********商户小程序:	获取企业的福利下的福币数流水情况********");
                result.put("data",terminalService.getCompanyCoinsRecord(map));
            }else if("18".equals(mode)){
                log.info("********商户小程序:	惠客福利********");
                result.put("data",terminalService.findListWelfareByPhp(map));
            }else if("19".equals(mode)){
                log.info("********商户小程序:	点击福利详情获取sign签名********");
                result.put("data",terminalService.getSign(map));
            }else if("20".equals(mode)){
                log.info("********商户小程序:	点击创建福利 和 数据概览  编辑福利 获取sign签名********");
                result.put("data",terminalService.getSignByCrete(map));
            }else if("21".equals(mode)){
                log.info("********商户小程序:	分享惠客的福利调用分享统计********");

            }else if("22".equals(mode)){
                log.info("********商户小程序:	点击惠客详情添加一条访问详细记录********");
            }
        } catch (Exception e){
            result.put("result", "no");
            e.printStackTrace();
            log.error("接口错误:", e);
        } finally{
            log.info("接口返回："+result.toString());
        }
        return result;
    }
}
