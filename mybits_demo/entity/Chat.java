package cn.zcbigdata.mybits_demo.entity;

import java.util.List;

public class Chat {

    private int id;
    private String chat_name;
    private int chat_hot;
    private List<chat_son>  son;
    private List<chat_myson>  myson;

    public List<chat_myson> getMyson() {
        return myson;
    }

    public void setMyson(List<chat_myson> myson) {
        this.myson = myson;
    }

    public List<chat_son> getSon() {
        return son;
    }

    public void setSon(List<chat_son> son) {
        this.son = son;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public int getChat_hot() {
        return chat_hot;
    }

    public void setChat_hot(int chat_hot) {
        this.chat_hot = chat_hot;
    }


    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", chat_name='" + chat_name + '\'' +
                ", chat_hot=" + chat_hot +
                ", son=" + son +
                ", myson=" + myson +
                '}';
    }
}
