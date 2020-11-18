package inkomus.example.web.service;

import inkomus.example.web.model.RequestM;


import java.util.List;


public interface RequestMService {


    List<RequestM> readAll();

    RequestM read(int id);

    Boolean update(RequestM requestM,int id);

}
