package com.sandu.erp.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sandu.erp.Enum.FailLogEnum;
import com.sandu.erp.config.map.ErrorMessageMap;
import com.sandu.erp.mongodb.config.LogAssistant;
import com.sandu.erp.service.Impl.UserErrorMessageServiceImpl;
import com.sandu.erp.service.UserErrorMessageService;
import com.sandu.erp.service.WebSocketService;
import com.sandu.erp.util.ApplicationContextUtil;
import com.sandu.erp.util.DelUserInfo;
import com.sandu.erp.util.ValidateHelper;
import com.sandu.erp.vo.*;
import com.sandu.erp.vo.FailLogVo.FailLog;
import com.sandu.erp.vo.UserErrorMessage.UserErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sandu02
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 * @ServerEndpoint 可以把当前类变成websocket服务类
 * id：当前登录对象
 */
@RestController
@ServerEndpoint(value = "/ws/{userno}", decoders = MessageDecoder.class,
        encoders = MessageEncoder.class,configurator = CustomSpringConfigurator.class)
@Component
@Slf4j
public class WebSocketServer {

    @Autowired
    @Qualifier("webSocketService")
    private WebSocketService webSocketService;


    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context){
        applicationContext=context;
    }


    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
     */
    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<String, WebSocketServer>();

    private static Map<String, Session> webSocketSet_map = new HashMap<String, Session>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session WebSocketsession;
    /**
     * 当前发消息的人员编号
     */
    private String userno = "";


    public  Message getUserInfo(@RequestParam String propertyId){

        WebSocketService service = applicationContext.getBean(WebSocketService.class);

        return service.getUserInfo(propertyId);
    }

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam(value = "userno") String param, Session session,EndpointConfig config) {
        //接收到发送消息的人员编号
        userno = param;
        this.WebSocketsession = session;
        //加入map中
        webSocketSet.put(param, this);
        webSocketSet_map.put(param,this.WebSocketsession);
        addOnlineCount();           //在线数加1
        log.info("有新连接"+param+"加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam(value = "userno") String param) {
        if (!param.equals("")) {
            //从set中删除
            webSocketSet.remove(param);
            //在线数减1
            subOnlineCount();
            log.info("有一连接"+param+"关闭！当前在线人数为" + getOnlineCount());
        }
    }


    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @SuppressWarnings("unused")
//    @OnMessage
    public void onMessage(String message, Session session,@PathParam(value = "userno") String param) {
        log.info("来自客户端的消息:" + message);
    }


    /**
     * 给指定的人发送消息
     * @param message
     */
    @OnMessage
    public  void sendToUser(String message, @PathParam(value = "userno") String param) {
        LogAssistant logAssistant = (LogAssistant) ApplicationContextUtil.getBean("logAssistant");

        log.info("进入第二步骤");
         //json字符串直接转为List<java>对象
        List<Message> messageList = JSONArray.parseArray(message, Message.class);

        messageList.stream().forEach(messageInfo->{
            //判断对象是否为空·
            ValidateHelper.isEmpty(message);
            Message userInfo = getUserInfo(messageInfo.getPropertyId());

            UserInfo userInfoMessage = messageInfo.getUserInfo();

            UserInfoKh userInfoKh=new UserInfoKh();
            userInfoKh.setId(messageInfo.getId());
            userInfoKh.setPropertyId(messageInfo.getPropertyId());
            userInfoKh.setConsultantId(userInfoMessage.getConsultantId());
            userInfoKh.setConsultantName(userInfoMessage.getConsultantName());
            userInfoKh.setUserAddress(userInfoMessage.getUserAddress());
            userInfoKh.setUserCard(userInfoMessage.getUserCard());
            userInfoKh.setUserId(userInfoMessage.getUserId());
            userInfoKh.setUserName(userInfoMessage.getUserName());
            userInfoKh.setUserPhone(userInfoMessage.getUserPhone());
            userInfoKh.setUserSex(userInfoMessage.getUserSex());
            userInfoKh.setIntentionLevel(userInfoMessage.getIntentionLevel());
            userInfoKh.setCustomerSource(userInfoMessage.getCustomerSource());
            userInfoKh.setCustomerStatus(userInfoMessage.getCustomerStatus());
            userInfoKh.setClassify(userInfoMessage.getClassify());
            //给删除提供id
            userInfoKh.setUserInfoId(messageInfo.getUserInfoId());
            userInfoKh.setJoinUserInfoId(messageInfo.getJoinUserInfoId());
            userInfoKh.setUserPropertyId(messageInfo.getUserPropertyId());
            Long errId = Long.valueOf(param.split(",")[1]);
            userInfoKh.setUserErrormessageId(errId);

            List<JoinUserInfo> joinUserInfo = messageInfo.getUserInfo().getJoinUserInfo();
            userInfoKh.setJoinUserInfo(joinUserInfo);
            // String sendUserno = message.split("[|]")[1];
            //String sendMessage = message.split("[|]")[0];
            //String now = getNowTime();
            String key = userInfoKh.getPropertyId()+":"+userInfoKh.getUserId();
            try {
                if (webSocketSet.get(userInfo.getIp()) != null) {
                    String ip = param.split(",")[0];
                    //用户不能发送给自己
                    if (!ip.equals(userInfo.getIp())) {
                        //webSocketSet.get(role).sendMessage(now + "用户" + param + "发来消息：" + " <br/> " + content);
                        webSocketSet.get(userInfo.getIp()).sendMessage(""+JSON.toJSONString(userInfoKh),userInfo.getIp());
                        //存储日志
                        logAssistant.saveFailLog(new FailLog(key,message,1,0,new Date(),FailLogEnum.SUCCESS.getStatus()));
                    }
                } else {
                    log.info("当前用户"+userInfo.getIp()+"不在线");
                    log.info("发送失败的消息为"+JSON.toJSONString(userInfoKh));
                    log.info("开始删除保存的信息");
                    DelUserInfo.deleteUserInfo(messageInfo.getUserInfo().getId(),
                            messageInfo.getUserInfo().getJoinUserInfo(),messageInfo.getUserPropertyId());

                    //将发送失败的消息保存下来
                    ErrorMessageMap.putString(userInfoKh.getPropertyId()+userInfoKh.getUserId(),message);
                    //将错误信息扒皮存到数据库
                    //先判断发送失败的信息有没有，有的话发送失败次数+1
                    //当前用户的key
                    Long id = Long.valueOf(param.split(",")[1]);
                    UserErrorMessageServiceImpl userErrorMessageService = (UserErrorMessageServiceImpl) ApplicationContextUtil.getBean("userErrorMessageService");
                    UserErrorMessage errorInfo = userErrorMessageService.getErrorMessageIsExist(id);
                    if(!ValidateHelper.isEmpty(errorInfo)){
                        //错误次数
                        int number = errorInfo.getNumber();
                        if (number>0){
                            //更新失败次数
                            number+=1;
                            userErrorMessageService.updateErrorMessageNum(number,id);
                        }
                        //存储日志
                        logAssistant.saveFailLog(new FailLog(key,message,1,0,new Date(),FailLogEnum.FAIL.getStatus()));
                    }
                    else {
                        UserErrorMessage userErrorMessage =  new UserErrorMessage();
                        userErrorMessage.setUserKey(key);
                        userErrorMessage.setUserValue(message);
                        userErrorMessage.setNumber(1);
                        userErrorMessage.setTime(new Date());
                        userErrorMessage.setStatus(0);
                        userErrorMessageService.saveInfo(userErrorMessage);
                        log.info("保存未发送信息成功");
                        //存储日志
                        logAssistant.saveFailLog(new FailLog(key,message,1,0,new Date(), FailLogEnum.SAVE_FAIL.getStatus()));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public void failLog(FailLog failLog){

    }


    /**
     * 给所有人发消息
     * @param message
     */
    private void sendAll(String message,String role) {
        String now = getNowTime();
        String sendMessage = message.split("[|]")[0];
        //遍历HashMap
        for (String key : webSocketSet.keySet()) {
            //判断接收用户是否是当前发消息的用户
            if (!userno.equals(key)) {
                try {
                    webSocketSet.get(key).sendMessage(now + "用户" + userno + "发来消息：" + " <br/> " + sendMessage,role);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                log.info("key = " + key);
            }
        }
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    private static String getNowTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }
    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.info("发生错误");
        error.printStackTrace();
    }


    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message,String role) throws IOException {
        //this.WebSocketsession.getBasicRemote().sendText(message);
        //获取当前用户的session
        Session session = webSocketSet_map.get(role);
        log.info("发生送的信息:   "+message);
        session.getBasicRemote().sendText(message);
        //s.getAsyncRemote().sendText(message);
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }


    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }


    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
