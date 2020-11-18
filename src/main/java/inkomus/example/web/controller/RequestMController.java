package inkomus.example.web.controller;


import inkomus.example.web.model.RequestM;
import inkomus.example.web.service.RequestMService;
import inkomus.example.web.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class RequestMController {
    private final RequestMService requestMService;
    private final UserDataService userDataService;


    @Autowired
    public RequestMController(RequestMService requestMService, UserDataService userDataService) {
        this.requestMService = requestMService;
        this.userDataService = userDataService;
    }


    @GetMapping(value = "/requests")
    public String read(Model model)
    {    List<RequestM> requests= requestMService.readAll();
                 model.addAttribute("requests",requests);
                return "requestM-list";
    }


    @GetMapping(value = "/request-update/{id}")
    public String updateReqForm(@PathVariable(name = "id") int id,Model model){
       RequestM requestM= requestMService.read(id);
//       String fio=userDataService.getFIO(requestM.getIdUser());
//       Object usrAdr = userDataService.getAdr(requestM.getCaid());
//       UserData userData =userDataService.read(requestM.getIdUser());

//       model.addAttribute("userData",userData);
       model.addAttribute("requestM",requestM);
//       model.addAttribute("fio",fio);
//       model.addAttribute("usrAdr",usrAdr);
       return "requestM-update";
    }

    @PostMapping(value = "/request-update")
    public String updateReq(RequestM requestM)
    {
        requestMService.update(requestM,requestM.getId());
        return "redirect:/requests";
    }

    @PostMapping(value = "/request-update-cancel")
    public String updateReqCancel(RequestM requestM)
    {
        return "redirect:/requests";
    }
}
