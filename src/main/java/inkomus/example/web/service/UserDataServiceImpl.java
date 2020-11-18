package inkomus.example.web.service;

import inkomus.example.web.model.UserAddress;
import inkomus.example.web.model.UserData;
import inkomus.example.web.repository.RequestMRepository;
import inkomus.example.web.repository.UserDataRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserDataServiceImpl implements  UserDataService {

    @Autowired
    UserDataRepository userDataRepository;

    @Autowired
    RequestMRepository requestMRepository;


    @Override
    public UserData read(int id) {
        return userDataRepository.findByIdUser(id);
    }

    @Override
    public String getFIO(int id){
      String fio=  read(id).getFirstName()+" "+read(id).getSecondName()+" "+read(id).getLastName();
      return fio;
    }

    @Override
    public Object getAdr(String caidId) {
         return caidId!=null&&!caidId.equals("")?"г. "+requestMRepository.getAdrHomeTown(caidId)+
                 ", улица "+requestMRepository.getAdrStreet(caidId)+" "
                +requestMRepository.getAdrHouse(caidId)+" кв. "+requestMRepository.getAdrHomeFlat(caidId):"";
    }




}
