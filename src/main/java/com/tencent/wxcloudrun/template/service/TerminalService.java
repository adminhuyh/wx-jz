package com.tencent.wxcloudrun.template.service;
import com.tencent.wxcloudrun.config.Page;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

@Service
public class TerminalService {


    /**
     * 福币动态
     * @return
     */
    public List<Map<String,String>> loadFubiAccounts(Map<String, String[]> param){
        String adminId = getParam(param, "adminId");
        List<Map<String,String>> returnList =  new ArrayList<Map<String,String>>();
        return returnList;
    }


    public List<Map<String,String>> loadFubiAccountsByPage(Map<String, String[]> param){

        List<Map<String,String>> returnList =  new ArrayList<Map<String,String>>();
        return returnList;
    }
    /**
     * 福星榜单
     * @return
     */
    public List<Map<String,String>> loadFuxingList(Map<String, String[]> param){
        List<Map<String,String>> returnList =  new ArrayList<Map<String,String>>();
        return returnList;
    }


    public List<Map<String,String>> loadMessagesCenterByPage(Map<String, String[]> param){

        List<Map<String,String>> returnList =  new ArrayList<Map<String,String>>();
        return returnList;
    }

    /**
     * 福利大厅，根据不同条件筛选不同福利
     * @param param
     * @return
     * @throws Exception
     */
    public Map<String,Object> queryWelfare(Map<String, String[]> param) throws Exception{
        Map<String, Object> result = new HashMap<String, Object>();
        return result;
    }

    /**
     * 我的--签到
     * @return lxl 不用了
     * @throws Exception
     */
    public Map<String, Object> sign(Map<String, String[]> param) throws Exception{
        Map<String, Object> result = new HashMap<String, Object>();
        return result;
    }

    /**
     * 小程序中跳转到福币商城
     * @param request
     * @param repResponse
     * @param param
     * @throws Exception
     */
    public void AppsToStore(HttpServletRequest request, HttpServletResponse repResponse, Map<String, String[]> param) throws Exception{

    }

    /**
     * 进入我的--查询当前用户福币数量和积分信息
     * @return
     * @throws Exception
     */
    public Map<String, Object> fuxingcenter(Map<String, String[]> param) throws Exception{
        Map<String,Object> result = new HashMap<String,Object>();
        return result;
    }

    /**
     * 我的--个人信息--修改完成后保存
     * @return
     */
    public Map<String, Object> savefuxingUser(Map<String, String[]> param){
        Map<String,Object> result = new HashMap<String,Object>();
        return result;
    }


    private String getParam(Map<String, String[]> map, String key) {
        if (map.get(key) == null) {
            return "";
        }
        return map.get(key)[0];
    }


    @Transactional
    public String updateOldData(){

        return "yes";
    }

    /**
     * @Title: loginAdminByUserName
     * @Description:  (商户小程序用户名密码登录)
     * @author lxl
     * @date 2018年4月19日
     * @return: Object
     * @throws Exception
     */
    @Transactional(rollbackFor=Exception.class)
    public Map<String,Object> loginAdminByUserName(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        return result;

//		Map<String, Object> result = new HashMap<String, Object>();
//		String encryptedData = getParam(map, "encryptedData");
//		String iv = getParam(map, "iv");
//		String back = getParam(map, "back");
//		String userName = map.get("userName")[0];
//		Map<String, Object> backJson = new Gson().fromJson(back, Map.class);
//		String unionid = backJson.get("unionid").toString();
//		CompanyInfo companyInfo = companyInfoRepository.loginAdminByUserName(userName,MD5Utils.StringToMD5(map.get("password")[0]));
//		AdminUser adminUser = adminUserRepository.findOne(companyInfo.getAdminId());
//        User user = userService.findUserByUnionid(unionid,adminUser.getId());
//        if(user == null){
//        	user = new User();
//        	user = userService.fxjbxcxCreateUser(user, back,adminUser.getId(),encryptedData,iv);
//        	result.put("userId", user.getId());
//        }else{
//        	user = userService.fxjbxcxUpdateUser(user, back,adminUser.getId(),encryptedData,iv);
//        	result.put("userId", user.getId());
//        }
//		if(companyInfo!=null){
//			result.put("result", "yes");
//			result.put("companyInfo", companyInfo);
//			result.put("phone",adminUser.getServicePhone());
//			result.put("amdinName", adminUser.getCustomerName());
//		}else {
//			result.put("result", "no");
//		}
//		return result;
    }

    /**
     * @Title: loadOrderByPage
     * @Description:  (获取订单order数据)
     * @author lxl
     * @date 2018年4月19日
     * @return: Object
     */
    public Page loadOrderByPage(Map<String, String[]> map) {
          return null;
    }

    /**
     * @Title: changeOrderType
     * @Description:  (改变订单状态)
     * @author lxl
     * @date 2018年4月19日
     * @return: Object
     * @throws Exception
     */
    @Transactional
    public Map<String, Object> changeOrderType(Map<String, String[]> map) throws Exception {
        Map<String,Object> result = new HashMap<String,Object>();
        return result;
    }

    /**
     * @Title: queryWelfareByCompany
     * @Description:  (根据商家companyId获取福利；列表.备注：暂时不用)
     * @author lxl
     * @date 2018年4月19日
     * @return: Map<String,Object>
     */
    public List<Map<String, Object>> queryWelfareByCompany(Map<String, String[]> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> welfareList = null;
        return welfareList;
    }

    /**
     * @Title: queryWelfareByCompanyId
     * @Description:  (根据商家companyId，根据不同条件筛选不同福利，获取福利；列表。备注：楼上的方法加了个商家id其他的一样)
     * @author lxl
     * @date 2018年4月19日
     * @return: Map<String,Object>
     * @throws Exception
     */
    public Map<String, Object> queryWelfareByCompanyId(Map<String, String[]> param) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        String longitude = getParam(param, "longitude").equals("") ? "116.36979416093112" : getParam(param, "longitude");				//经度
        String latitude = getParam(param, "latitude").equals("") ? "40.031374321027194" :getParam(param, "latitude");					//纬度
        Integer page = Integer.valueOf(getParam(param, "page"));		//分页页码

        String companyId = getParam(param, "companyId");				//商家id
        String welfareName = getParam(param, "welfareName");			//福利名称
        String billingType = getParam(param, "billingType");			//福利分类
        String region = getParam(param, "region");						//区域范围
        String type = getParam(param, "type");							//智能排序类型
        String adminId = getParam(param, "adminId");					//社的ID
        Page list = null;


        return result;
    }

    /**
     * @Title: findWelfareInfoByCompanyId
     * @Description:  (根据福利id查询福利详情)
     * @author lxl
     * @date 2018年4月19日
     * @return: Map<String,Object>
     * @throws Exception
     */
    public Map<String,Object> findWelfareById(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        return result;
    }

    /**
     * @Title: loginAdmin
     * @Description:  (小程序登录，自动匹配登录人和绑定列表，有就返回绑定商家，没有返回登录页面)
     * @author lxl
     * @date 2018年4月20日
     * @return: Object
     * @throws Exception
     */
    public Map<String,Object> loginAdmin(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        return result;
    }

    /**
     * 获取信息
     */
    public JSONObject getUserInfo(String encryptedData, String sessionkey, String iv) {
        // 被加密的数据

        return null;
    }


    /**
     * @Title: findRecordsView
     * @Description:  (小程序访问明细)
     * @author lxl
     * @date 2018年4月25日
     * @return: Object
     * @throws ParseException
     */
    public Page findRecordsView(Map<String, String[]> param) throws ParseException {
       return null;
    }

    /**
     * @Title: findRecordsShare
     * @Description:  (小程序分享明细)
     * @author lxl
     * @date 2018年4月25日
     * @return: Object
     */
    public Page findRecordsShare(Map<String, String[]> param) {
          return null;
    }

    /**
     * @Title: loadOrderByOrderId
     * @Description:  (订单详情)
     * @author lxl
     * @date 2018年4月25日
     * @return: Object
     * @throws ParseException
     */
    public Map<String,Object> loadOrderByOrderId(Map<String, String[]> map) throws ParseException {


        return null;
    }

    /**
     * @Title: loadEchartsId
     * @Description:  (获取echarts信息)
     * @author lxl
     * @date 2018年4月26日
     * @return: Object
     * @throws Exception
     */
    public Map<String, Object> loadEchartsId(Map<String, String[]> map) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        //echarts
        Map<String, Object> dataManagement = dataManagement(map.get("welfareId")[0],map.get("billingType")[0]);
        model.put("echartsMSG", dataManagement);
        return model;
    }

    /**
     * @Title: loadEchartsByTime
     * @Description:  (按时间获取echarts信息)
     * @author lxl
     * @date 2018年4月26日
     * @return: Object
     * @throws Exception
     */
    public Map<String, Object> loadEchartsByTime(Map<String, String[]> map) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        Map<String, Object> dataManagement = dataManagementByTime(map.get("welfareId")[0],map.get("start")[0],map.get("end")[0],map.get("billingType")[0]);
        model.put("echartsMSG", dataManagement);
        return model;
    }

    /**
     * @Title: loadExpressinformation
     * @Description:  (快递信息)
     * @author lxl
     * @date 2018年4月26日
     * @return: Object
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> loadExpressinformation(Map<String, String[]> params) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        return result;
    }
    /**
     * @Title: loadExpressinformation
     * @Description:  (快递信息(备用))
     * @author lxl
     * @date 2018年4月26日
     * @return: Object
     * @throws Exception
     */
    public String loadExpressinformationTwo(Map<String, String[]> param) {
         return "";
    }

    public  Map<String, Object>  dataManagement(String id,String billingType) throws ParseException{
        Map<String, Object> model = new HashMap<String, Object>();

        return model;
    }

    public  Map<String, Object>  dataManagementByTime(String id,String start,String end,String billingType) throws ParseException{
        Map<String, Object> model = new HashMap<String, Object>();

        return model;
    }


    @Transactional
    public Map<String,String> verification(Map<String, String[]> map) throws Exception {

        Map<String, String> result = new HashMap<>();
        String ticketCode = getParam(map, "ticketCode");		//核销的券码
        String companyId = getParam(map, "companyId");
        String verifierId = getParam(map, "verifierId");		//核销员id(账号密码登录核销员id为空)

        return result;
    }


    /**
     * 获取当前企业下核销列表
     * @param map
     * @return
     * @throws Exception
     */
    public Map<String,Object> verificationList(Map<String, String[]> map) throws Exception {

        Map<String, Object> result = new HashMap<>();

        Integer page = Integer.valueOf(getParam(map, "page"));		//分页页码
        String companyId = getParam(map, "companyId");				//商家id
        String startTime = getParam(map, "startTime");
        String endTime = getParam(map, "endTime");



        return result;
    }

    /**
     * 查询今日核销和总核销数
     * @param map
     * @return
     * @throws Exception
     */
    public Map<String,Object> queryVerification(Map<String, String[]> map) throws Exception {

        Map<String, Object> result = new HashMap<>();

        String companyId = getParam(map, "companyId");				//商家id


        return result;
    }

    /**
     * 小程序查询票券详情
     * @param map
     * @return
     * @throws Exception
     */
    public Map<String,Object> queryTickedDetail(Map<String, String[]> map) throws Exception {

        Map<String, Object> result = new HashMap<>();

        String ticketCode = getParam(map, "ticketCode");		//核销的券码
        String companyId = getParam(map, "companyId");			//企业id




        return result;
    }
    /**
     * 小程序查询企业福利福币流水表
     * @author huyuhang
     * @data 2018-05-30
     * @param map
     * @return
     * @throws Exception
     */
    public Map<String,Object> getCompanyCoinsRecord(Map<String, String[]> map) throws Exception {

        Map<String, Object> result = new HashMap<>();

        return result;
    }
    /**
     * 福星进宝小程序首页
     * @author huyuhang
     * @data 2018-07-02
     * @param map
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor=Exception.class)
    public Map<String,Object> fxjbxcxIndex(Map<String, String[]> map) throws Exception {

        Map<String, Object> result = new HashMap<>();

        return result;

    }


    /**
     * 福星进宝小程序初始化用户
     * @author huyuhang
     * @data 2018-06-20
     * @param map
     * @return
     * @throws Exception
     */
    @Transactional
    public Map<String,Object> userLoginAdmin(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "no");


        return result;
    }

    /**
     * 福星进宝小程序爆款福利
     * @author huyuhang
     * @data 2018-06-20
     * @param map
     * @return
     * @throws Exception
     * adminId 必传分社id
     * page 页数
     * welfareType 福利类型 传id 首页福利类型的id
     * paymoneySort 价格升序还是降序     0是升序 1是降序
     * coinsPrecentSort 佣金排序还是降序   0是升序 1是降序
     * sellNumSort  销量排序还是降序   0是升序 1是降序
     */
    public Map<String,Object> findfuliByReasons(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<>();
        Integer beginPage = Integer.valueOf(getParam(map, "page"));//分页查询页数
        String adminId = getParam(map, "adminId");//必传值分社id
        String  explosion="fasle";
        String welfareType = getParam(map, "welfareType");//福利分类(如果为true,则是爆款福利)
        //小程序那边点击推荐查询的是爆款福利，此时没有根据福利分类查询，所以借用 福利分类字段 传的是爆款福利的标识
        if("true".equals(welfareType)){
            explosion="true";
            welfareType=null;
        }
        //根据价格排序，0-升序 1-降序
        String paymoneySort = getParam(map, "paymoneySort");//价格
        //根据佣金比例排序，，0-升序 1-降序
        String coinsPrecentSort = getParam(map, "coinsPrecentSort");//佣金比例
        //根据销量排序 ，0-升序 1-降序
        String sellNumSort = getParam(map, "sellNumSort");//销量
        //分页多条件查询

        return result;

    }

    /**
     *
     * @Title: loadDataAnalysisViews
     * @Description: 进入数据分析详细界面
     * @author shaopeng
     * @date 2018年6月21日
     * @return: Map<String,Object>
     */
    public Map<String,Object> loadDataAnalysisViews(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<>();
        String range = getParam(map, "range");
        String userId = getParam(map, "userId");
        String adminId = getParam(map, "adminId");
        String pages = getParam(map, "page");
        Integer page = (Integer.parseInt(pages) - 1)*10;
        List<String> xlist = new ArrayList<>();
        double[] yList = null;
        Integer orderNum = 0;
        BigDecimal coinsRecords = new BigDecimal(0);
        BigDecimal totalMoney = new BigDecimal(0);
        BigDecimal totalCoins = new BigDecimal(0);
        List<Map<String, Object>> yjtopList = null;

        return result;
    }

    /**
     *
     * @Title: initStartTime
     * @Description: 时间范围控制工具(往后推时间)
     * @author shaopeng
     * @date 2018年6月20日
     * @return: String
     */
    public String initStartTime(String startDate,String num) throws Exception{
       return "";
    }

    /**
     *
     * @Title: initStartTime
     * @Description: 时间范围控制工具(往前推时间)
     * @author shaopeng
     * @date 2018年6月20日
     * @return: String
     */
    public String initStartTimeBefore(String startDate,String num) throws Exception{

        return startDate;
    }

    /**
     *
     * @Title: loadPutForwardView
     * @Description: 去到有提现按钮的界面
     * @author shaopeng
     * @date 2018年6月21日
     * @return: Object
     * @throws Exception
     */
    public Object loadPutForwardView(Map<String, String[]> map) throws Exception {

        return null;
    }

    /**
     * @Title: findMyHigherStar
     * @Description: 小程序获取上级福星数据
     * @author libingquan
     * @date 2018年6月21日
     * @return: Map<String,Object>
     */
    public Map<String,Object> findMyHigherStar(Map<String, String[]> map) throws Exception{
      return null;
    }

    /**
     *
     * @Title: loadToPutForwardView
     * @Description: 点击去体现的按钮进入选择提现的金额
     * @author shaopeng
     * @date 2018年6月21日
     * @return: Object
     * @throws Exception
     */
    @Transactional(rollbackFor=Exception.class)
    public Map<String,Object> loadToPutForwardView(Map<String, String[]> map) throws Exception {
      return null;
    }

    /**
     *
     * @Title: loadCheckPutForwardView
     * @Description: 查看提现的记录
     * @author shaopeng
     * @date 2018年6月21日
     * @return: Map<String,Object>
     * @throws Exception
     */
    public Map<String,Object> loadCheckPutForwardView(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<>();

        return result;
    }

    /**
     *
     * @Title: loadCheckMoreSZView
     * @Description: 查看更多的收支明细
     * @author shaopeng
     * @date 2018年6月21日
     * @return: Map<String,Object>
     * @throws Exception
     */
    public Map<String,Object> loadCheckMoreSZView(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<>();

        return result;
    }

    /**
     * @Title: findMyCoinsTotal
     * @Description: 进入我的页面 查询福币数
     * @author libingquan
     * @date 2018年6月22日
     * @return Map<String, Object>
     */
    public Map<String, Object> findMyTotalCoins(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<>();

        return result;
    }


    /**
     *
     * @Title: matchName
     * @Description: 用于匹配流水名
     * @author shaopeng
     * @date 2018年7月4日
     * @return: List<String>
     */
    public List<Map<String, Object>> matchName(List<Map<String, Object>> coinsRecordsList){

        return coinsRecordsList;
    }

    /**
     *
     * @Title: toReceiveFreeWelfare
     * @Description: 去领取红包中免费的礼物
     * @author shaopeng
     * @date 2018年7月23日
     * @return: String
     */
    public Map<String, Object> toReceiveFreeWelfare(Map<String, String[]> map){

        Map<String, Object> model = new HashMap<String,Object>();
        String userId = getParam(map, "userId");
        String orderNumber = getParam(map, "orderNumber");

        return model;
    }

    /**
     *
     * @Title: inputTel
     * @Description: 去判断显示弹出层还是回调显示填写收货地址
     * @author shaopeng
     * @date 2018年7月23日
     * @return: Map<String,Object>
     */
    public Map<String, Object> inputTel(Map<String, String[]> map){
        Map<String, Object> model = new HashMap<String,Object>();
        String userId = getParam(map, "userId");
        String orderNumber = getParam(map, "orderNumber");

        return model;
    }

    /**
     *
     * @Title: getFreeWelfare
     * @Description: 点击去领取按钮去的页面
     * @author shaopeng
     * @date 2018年7月33日
     * @return: ModelAndView
     */
    public Map<String, Object> getFreeWelfare(Map<String, String[]> map){
        Map<String, Object> model = new HashMap<String,Object>();
        String userId = getParam(map, "userId");
        String orderNumber = getParam(map, "orderNumber");
        //查询主订单
     return model;
    }

    /**
     *
     * @Title: toReallyGetWelfare
     * @Description: 输入完地址点击确定领取
     * @author shaopeng
     * @date 2018年7月23日
     * @return: ModelAndView
     */
    public Map<String, Object> toReallyGetWelfare(Map<String, String[]> map){
        Map<String, Object> model = new HashMap<String,Object>();
        String userId = getParam(map, "userId");
        String orderNumber = getParam(map, "orderNumber");
        String userName = getParam(map, "userName");
        String tel = getParam(map, "tel");
        String address = getParam(map, "address");

        return model;
    }


    public Map<String,Object> findListWelfareByPhp(Map<String, String[]> param) {
        Map<String, Object> result = new HashMap<String, Object>();

        return result;
    }


    /**
     * @Description: 惠客 需要的签名
     * @author WangShuo
     * @throws Exception
     */
    public Map<String,Object> getSign(Map<String, String[]> map) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String userId =  getParam(map, "userId");
        String activity_id =  getParam(map, "php_id");
        String king_id =  getParam(map, "king_id");
        String shareUserId =  getParam(map, "shareUserId");
        String appid_php = getParam(map, "adminId");	//对应福星社的 adminId
        long timestamp = System.currentTimeMillis();

        return result;
    }

    /**
     * @Description: 点击创建福利 和 数据概览  编辑福利  获取sign签
     * @author WangShuo
     * @date 2018年8月9日 下午4:50:42
     * @param map
     * @return
     */
    public Map<String,Object> getSignByCrete(Map<String, String[]> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        String openid =  getParam(map, "companyId");
        String phpId =  getParam(map, "phpId");
        String appid_php = getParam(map, "adminId");	//对应福星社的 adminId
        long timestamp = System.currentTimeMillis();

        return result;
    }



    /**
     * @Description:惠客福利 分享统计
     * @author WangShuo
     * @date 2018年8月7日 上午9:39:07
     * @param map
     */
    @Transactional(noRollbackFor=Exception.class)
    public void adddViewCountByPhp(Map<String, String[]> map){
        String phpId = getParam(map, "activity_id");
        String shareUserId =getParam(map, "shareUserId");



    }

    public Map<String, Object> loadMallIndex(Map<String, String[]> map) {
        Map<String, Object> result = new HashMap<String, Object>();

        return null;
    }

    /**
     * @Description: 惠客访问福利 增加一个访问详细记录 头像 昵称..
     * @author WangShuo
     * @date 2018年8月9日 上午10:34:10
     * @param map
     */
    public void adddViewDetailByPhp(Map<String, String[]> map) {
        String phpId = getParam(map, "phpId");
        String clickUserId = getParam(map, "userId");
        String shareUserId = getParam(map, "shareUserId");
        if("".equals(shareUserId) || null == shareUserId || "undefined".equals(shareUserId)){
            shareUserId =  clickUserId;
        }


    }



    /**
     * 商城:限时抢购--即将开始
     * @Title: findTimeWelfare
     * @author: LBQ
     * @return
     */
    public Page findTimeWelfare(Map<String, String[]> param) {
        String type = getParam(param, "type");
        String adminId = getParam(param, "adminId");
        Integer page = Integer.valueOf(getParam(param, "page"));
        Page welList = null;
        Date date = new Date();

        return welList;
    }

    /**
     * 福利列表
     * @Title: findWelfareList
     * @author: LBQ
     * @return
     */
    public Map<String, Object> findWelfareList(Map<String, String[]> param) {
        Map<String, Object> result = new HashMap<String, Object>();
        String type = getParam(param, "type");
        String adminId = getParam(param, "adminId");

        return result;
    }
    /**
     * @Description: 福星社用户订单表
     * @author huyuhang
     * @date 2018年8月7日 下午7:18:29
     * @param map
     * @return
     */
    public Map<String,Object> getOrdersByUserId(Map<String, String[]> map) {
        Map<String, Object> result = new HashMap<String, Object>();

        return result;
    }
    /**
     * @Description: 福星社企业和福利接口
     * @author huyuhang
     * @date 2018年8月7日 下午7:18:29
     * @return
     */
    public Map<String,Object> getFxsWlefareCompany(Map<String, String[]> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        Integer beginPage = Integer.valueOf(getParam(map, "page"));//分页查询页数
        String adminId = getParam(map, "adminId");//必传值分社id
        //推荐企业  业下的福利

        return result;
    }
    /**
     * @Description: 福星社企业和福利详情接口
     * @author huyuhang
     * @date 2018年8月7日 下午7:18:29
     * @return
     */
    public Map<String,Object> getFxsCompanyAndWelfare(Map<String, String[]> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        Integer beginPage = Integer.valueOf(getParam(map, "page"));//分页查询页数
        String adminId = getParam(map, "adminId");//必传值分社id
        //所有福利利企业和企业下的福利
        List<Map<String, Object>> companyList=null;

        return result;
    }




}
