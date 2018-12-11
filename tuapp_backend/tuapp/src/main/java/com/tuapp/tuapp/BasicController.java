package com.tuapp.tuapp;

import com.tuapp.tuapp.basicinfo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class BasicController {

    @Autowired
    private createBasicInfo cbi;

    @Autowired
    private getBasic gb;

    @Autowired
    private getBasicEmail gbe;

    @Autowired
    private basicRepo br;

    @RequestMapping(method = RequestMethod.POST,path = "/createBasic")
    public String createBasic(@PathParam("email") String email, @PathParam("name") String name,
                              @PathParam("lastName") String lastname,@PathParam("tel")int tel,
                              @PathParam("address")String address){



        if(gbe.findByEmail(email).size()==0){
            System.out.println("create");
            return cbi.createBasic(email,name,lastname,tel,address).toString();
        }
        else{
            return "email duplicated, info discarted";
        }


    }

    @RequestMapping(method = RequestMethod.GET,path = "/findBasic")
    public Optional<basicinfo>findBasic(@PathParam("uid")Integer uid){
        return gb.findById(uid);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/getAllBasic")
    public List<basicinfo> getAllBasic(){
        return gb.findAll();
    }



    @RequestMapping(method = RequestMethod.DELETE,path = "/delete/{id}")
    public void deleteBasic(@PathVariable int id){

        br.delete(gb.findById(id).get());

    }

    @RequestMapping(method = RequestMethod.PUT,path = "/put/{id}")
    public void putBasic(@RequestBody basicinfo bi,@PathVariable int id){

        System.out.println("------------------ id to change "+id);

        bi.setId(id);

        br.save(bi);

    }


    @RequestMapping(method = RequestMethod.GET,path = "/test")
    public String test(@PathParam("test")String test){
        System.out.println("------------ "+test);
        test = "tuapp -- "+test;
        return test;
    }


}
