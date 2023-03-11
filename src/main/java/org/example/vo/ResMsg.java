package org.example.vo;

//封装用于layUI的返回实体类
public class ResMsg {
    //正误代码，正确时为0
    private Integer code=0;
    //传递消息
    private String msg;
    //数据长度
    private Long count;
    //要返回的数据
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResMsg(){};

    public ResMsg(Integer code, String msg, Long count, Object data){
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
    

}
