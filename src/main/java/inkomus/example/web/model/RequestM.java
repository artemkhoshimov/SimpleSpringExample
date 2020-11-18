package inkomus.example.web.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "user_request",schema = "web")
@Getter
@Setter

public class RequestM {


    @Id
    @Column(name ="id_userrequest")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "request")
    private String request;

    @Column(name = "response")
    private String response;

    @Column(name = "caid")
    private String caid;

    @Column(name = "drequest")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataReq;

    @Column(name = "dresponse")
    private LocalDateTime dataRes;

//    @Column(name = "qcaption")
//    private String qcaption;




}
