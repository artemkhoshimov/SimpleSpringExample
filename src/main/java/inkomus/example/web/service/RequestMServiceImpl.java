package inkomus.example.web.service;

import inkomus.example.web.model.RequestM;
import inkomus.example.web.repository.RequestMRepository;
import inkomus.example.web.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class RequestMServiceImpl implements RequestMService {

    @Autowired
    RequestMRepository requestMRepository;

    @Autowired
    UserDataRepository userDataRepository;


    @Override
    public List<RequestM> readAll() {
//        List<RequestM> lastRequest = new ArrayList<>();
        List<RequestM> allRequests = requestMRepository.findAll(Sort.by("dataReq").descending());
//        int countReq = allRequests.size();
//        int eqCount = countReq - 200;
//        for (RequestM requestM : allRequests) {
//            if (requestM.getId() > eqCount) {
//                requestM.setDataReq(getFormatDate(requestM.getDataReq()));
//                if (requestM.getDataRes() != null) {
//                    requestM.setDataRes(getFormatDate(requestM.getDataRes()));
//                }
//
//            }
//        }
        return allRequests;
    }


    @Override
    public RequestM read(int id) {
        return requestMRepository.getOne(id);
    }

    @Override
    public Boolean update(RequestM requestM, int id) {

        if (requestMRepository.existsById(id)) {
            setDataRequestM(requestM, id);
            requestMRepository.save(requestM);
            return true;
        } else return false;
    }

    public void setDataRequestM(RequestM requestM, int id) {

        RequestM EntityReq = requestMRepository.getOne(id);
        requestM.setId(EntityReq.getId());
        requestM.setCaid(EntityReq.getCaid());
        requestM.setIdUser(EntityReq.getIdUser());
        requestM.setDataReq(EntityReq.getDataReq());
        requestM.setDataRes(getFormatDate(LocalDateTime.now()));
        requestM.setRequest(EntityReq.getRequest());


    }

    LocalDateTime getFormatDate(LocalDateTime dateF) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String time = dateF.format(formatter);
        LocalDateTime date = LocalDateTime.parse(time, formatter);
        return date;
    }

}
