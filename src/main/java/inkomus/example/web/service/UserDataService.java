package inkomus.example.web.service;


import inkomus.example.web.model.UserData;

public interface UserDataService {
 UserData read(int id);
 String getFIO(int id);
 Object getAdr(String caidId);

}
