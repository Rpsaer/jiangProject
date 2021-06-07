package cn.zcbigdata.mybits_demo.service.Impl;


import cn.zcbigdata.mybits_demo.entity.Chat;
import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.entity.chat_myson;
import cn.zcbigdata.mybits_demo.entity.chat_son;
import cn.zcbigdata.mybits_demo.mapper.ChatMapper;
import cn.zcbigdata.mybits_demo.mapper.TeacherMapper;
import cn.zcbigdata.mybits_demo.service.ChatService;
import cn.zcbigdata.mybits_demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    public  List<Chat> selectAll(){
        return  this.chatMapper.selectAll();
    }

    public List<Chat> select_chatName(String chat_name){
        return this.chatMapper.select_chatName(chat_name);
    }

    public  int update(Chat CHAT){
        return this.chatMapper.update(CHAT);
    }

    public  int updateMyson(chat_myson myson){
        return this.chatMapper.updateMyson(myson);
    }

    public int insertMyson(chat_myson myson){
        return this.chatMapper.insertMyson(myson);
    }

    public int insertChat(Chat CHAT){
        return this.chatMapper.insertChat(CHAT);
    }

    public int insertChat_son(chat_son CHAT){
        return this.chatMapper.insertChat_son(CHAT);
    }
}
