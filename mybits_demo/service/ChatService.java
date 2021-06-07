package cn.zcbigdata.mybits_demo.service;



import cn.zcbigdata.mybits_demo.entity.Chat;
import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.entity.chat_myson;
import cn.zcbigdata.mybits_demo.entity.chat_son;

import java.util.List;


public interface ChatService {

    public List<Chat> selectAll();

    public  List<Chat> select_chatName(String chat_name);

    public  int update(Chat CHAT);

    public int updateMyson(chat_myson myson);

    public int insertMyson(chat_myson myson);

    public int insertChat(Chat CHAT);

    public int insertChat_son(chat_son CHAT);
}
