package com.tuapp.tuapp;

import com.tuapp.tuapp.aditionalinfo.aditionalRepo;
import com.tuapp.tuapp.aditionalinfo.aditionalinfo;
import com.tuapp.tuapp.aditionalinfo.createAditionalInfo;
import com.tuapp.tuapp.aditionalinfo.getAditional;
import com.tuapp.tuapp.basicinfo.basicinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class AditionalController {

    @Autowired
    private createAditionalInfo cai;

    @Autowired
    private getAditional ga;

    @Autowired
    private aditionalRepo ar;

    @RequestMapping(method = RequestMethod.POST,path = "/createAditional")
    public String createAditional(@PathParam("art") String art, @PathParam("music") String music,
                              @PathParam("movies") String movies,@PathParam("basicid")int basicid){

        System.out.println("create");
        return cai.createAditional(art,music,movies,basicid).toString();
    }

    @RequestMapping(method = RequestMethod.GET,path = "/findAditional")
    public List<aditionalinfo> findAditional(@PathParam("basicid")Integer basicid){
        return ga.findByBasicid(basicid);
    }



    @RequestMapping(method = RequestMethod.DELETE,path = "/deleteAditional/{basicid}")
    public void deleteBasic(@PathVariable int basicid){

        ar.delete(ga.findByBasicid(basicid).get(0));

    }

    @RequestMapping(method = RequestMethod.PUT,path = "/putAditional/{basicid}")
    public void putBasic(@RequestBody aditionalinfo ai,@PathVariable int basicid){

        System.out.println("------------------ id to change "+basicid);

        ai.setBasicid(basicid);

        ar.save(ai);

    }


}
