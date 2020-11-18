package inkomus.example.web.repository;


import inkomus.example.web.model.RequestM;
import inkomus.example.web.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository  extends JpaRepository<UserData,Integer> {

 UserData findByIdUser(Integer id);

}
