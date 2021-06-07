package cn.zcbigdata.mybits_demo.mapper;


import cn.zcbigdata.mybits_demo.entity.Chat;
import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.entity.chat_myson;
import cn.zcbigdata.mybits_demo.entity.chat_son;

import java.util.List;

public interface ChatMapper {

    List<Chat> selectAll();//所有话题

    List<Chat> select_chatName(String chat_name);//通过话题名称显示，有模糊查询

    int update(Chat CHAT);//热度自增专用

    int updateMyson(chat_myson myson);//修改老师自己的回复

    int insertMyson(chat_myson myson);// 新添老师的回复

    int insertChat(Chat CHAT);//学生新建立话题

    int insertChat_son(chat_son CHAT);//学生回复当前话题



}
