package com.example.sgr.mymvpframework.app.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/13/013.
 */

public class ListBean {
    private int status;
    private ArrayList<DataList> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<DataList> getData() {
        return data;
    }

    public void setData(ArrayList<DataList> data) {
        this.data = data;
    }
    /*
	"data": [{
        "doc_size": "109104",
                "img": "/u/img/2017/0420/0931088412.png",
                "create_time": "2017-04-20 09:31:10",
                "c_down": "110",
                "title": "窗帘教学课程第一课",
                "status2": "上架",
                "type_c": "窗帘",
                "manager_id": "1",
                "rownumber": "1",
                "doc": "/u/doc/2017/0420/0933507888.zip",
                "id": "11615",
                "customer_id": null,
                "table": "app_mat",
                "status": "1"
    }],
            "status": "1"*/
}
