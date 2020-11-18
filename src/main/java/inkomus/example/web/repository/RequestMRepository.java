package inkomus.example.web.repository;


import inkomus.example.web.model.RequestM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestMRepository extends JpaRepository<RequestM,Integer> {



    String queryAddressStreet="select  s.name from accounts a\n" +
        "         join property p on p.id_property=a.id_property\n" +
        "         join flats f on f.id_flat=p.id_flat\n" +
        "         join houses h on h.id_house=f.id_house\n" +
        "         join streets s on s.id_street=h.id_street\n" +
        "         join towns tn on tn.id_town=s.id_town where caid =:IdCaid";

    String queryAddressHouse="select  h.name from accounts a\n" +
            "         join property p on p.id_property=a.id_property\n" +
            "         join flats f on f.id_flat=p.id_flat\n" +
            "         join houses h on h.id_house=f.id_house\n" +
            "         join streets s on s.id_street=h.id_street\n" +
            "         join towns tn on tn.id_town=s.id_town where caid =:IdCaid";

    String queryAddressTown="select  tn.name from accounts a\n" +
            "         join property p on p.id_property=a.id_property\n" +
            "         join flats f on f.id_flat=p.id_flat\n" +
            "         join houses h on h.id_house=f.id_house\n" +
            "         join streets s on s.id_street=h.id_street\n" +
            "         join towns tn on tn.id_town=s.id_town where caid =:IdCaid";

    String queryAddressFlat="select f.name from accounts a\n" +
            "join property p on p.id_property=a.id_property\n" +
            "join flats f on f.id_flat=p.id_flat\n" +
            "where caid =:IdCaid";




    @Query(value= queryAddressStreet,nativeQuery = true)
    Object getAdrStreet(@Param("IdCaid") String IdCaid);

    @Query(value= queryAddressHouse,nativeQuery = true)
    Object getAdrHouse(@Param("IdCaid") String IdCaid);

    @Query(value= queryAddressTown,nativeQuery = true)
    Object getAdrHomeTown(@Param("IdCaid") String IdCaid);

    @Query(value= queryAddressFlat,nativeQuery = true)
    Object getAdrHomeFlat(@Param("IdCaid") String IdCaid);

}
