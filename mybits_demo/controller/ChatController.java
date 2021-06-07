package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.entity.*;
import cn.zcbigdata.mybits_demo.service.ChatService;
import cn.zcbigdata.mybits_demo.service.TeacherService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/chat")
public class ChatController {
    private static Gson gson = new Gson();
    private static final Logger LOGGER = Logger.getLogger(ChatController.class);

    @Autowired
    private ChatService chatService;

    @RequestMapping("/xxx")
    public String chat(){
        LOGGER.info("Go To chat.html");
        return "chat";
    }
    //通过话题名称显示，有模糊查询
    @ResponseBody
    @RequestMapping(value="/select_chatName", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public  String select_chatName(String chat_name,String chat_hot,String id) throws Exception{
        Chat  hotAdd = new Chat();
        try{
            hotAdd.setId(dataCheck.check(id));
            hotAdd.setChat_hot(dataCheck.check1(chat_hot)+10);
        }catch(Exception e){
            LOGGER.info(e.getMessage());
        }
        hotAdd.setChat_name(chat_name);
        chatService.update(hotAdd);
        List<Chat>  CHAT = chatService.select_chatName(chat_name);
        String[] column = {"id","chat_name","chat_hot","son","myson"};
        String data = gson.toJson(CHAT);
        LOGGER.info(data);
        return data ;
    }

    @ResponseBody
    @RequestMapping(value="/selectAll", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public  String selectAll() throws Exception{
        List<Chat>  CHAT = chatService.selectAll();
        String[] column = {"id","chat_name","chat_hot","son","myson"};
        String data = gson.toJson(CHAT);
        LOGGER.info(data);
        return data ;
    }

    //修改老师自己的回复
    @ResponseBody
    @RequestMapping(value="/updateMyson", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public  String updateMyson(String chat_name,String chat_myReply,String id) throws Exception{
        chat_myson myson = new chat_myson();
        String data = "";
        try{
            myson.setId(dataCheck.check(id));
            data = "{\"data\":\"我的回复修改成功\"}";
        }catch(Exception e){
            LOGGER.info(e.getMessage());
        }
        myson.setChat_myReply(chat_myReply);
        myson.setChat_name(chat_name);
        chatService.updateMyson(myson);
        LOGGER.info(data);
        return data ;
    }

    // 新添老师的回复
    @ResponseBody
    @RequestMapping(value = "/insert" , method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String insert(String chat_name,String chat_myReply){
        chat_myson myson = new chat_myson();
        myson.setChat_name(chat_name);
        myson.setChat_myReply(chat_myReply);
        chatService.insertMyson(myson);
        String data = "{\"data\":\"教师回复插入成功\"}";
        return data;
    }

    //学生新建立话题
    @ResponseBody
    @RequestMapping(value ="/insertChat", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insertChat(String chat_name){
        Chat CHAT = new Chat();
        CHAT.setChat_hot(10);
        CHAT.setChat_name(chat_name);
        chatService.insertChat(CHAT);
        String data = "{\"data\":\"新话题建立成功\"}";
        return data;
    }

    //学生回复当前话题
    @ResponseBody
    @RequestMapping(value = "insertChat_son", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insertChat_son(String chat_name,String chat_reply,String chat_person){
        chat_son son = new chat_son();
        son.setChat_name(chat_name);
        son.setChat_person(chat_person);
        son.setChat_reply(chat_reply);
        chatService.insertChat_son(son);
        String data = "{\"data\":\"当前话题回复成功\"}";
        return data ;
    }




}
