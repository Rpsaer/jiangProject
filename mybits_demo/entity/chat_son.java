package cn.zcbigdata.mybits_demo.entity;

public class chat_son {

    private int id;
    private String chat_name;
    private String chat_reply;
    private String chat_person;

    public String getChat_person() {
        return chat_person;
    }

    public void setChat_person(String chat_person) {
        this.chat_person = chat_person;
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

    public String getChat_reply() {
        return chat_reply;
    }

    public void setChat_reply(String chat_reply) {
        this.chat_reply = chat_reply;
    }

    @Override
    public String toString() {
        return "chat_son{" +
                "id=" + id +
                ", chat_name='" + chat_name + '\'' +
                ", chat_reply='" + chat_reply + '\'' +
                ", chat_person='" + chat_person + '\'' +
                '}';
    }
}
