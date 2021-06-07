package cn.zcbigdata.mybits_demo.entity;

public class chat_myson {

    private int id;
    private String chat_name;
    private String chat_myReply;

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

    public String getChat_myReply() {
        return chat_myReply;
    }

    public void setChat_myReply(String chat_myReply) {
        this.chat_myReply = chat_myReply;
    }

    @Override
    public String toString() {
        return "chat_myson{" +
                "id=" + id +
                ", chat_name='" + chat_name + '\'' +
                ", chat_myReply='" + chat_myReply + '\'' +
                '}';
    }
}
