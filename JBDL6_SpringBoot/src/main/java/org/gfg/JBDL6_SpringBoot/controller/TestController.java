package org.gfg.JBDL6_SpringBoot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

@RestController
public class TestController {


    @RequestMapping("/get/data")
    public String getData(){
        return "This is first controller";
    }

    @PostMapping("/form/data")
    public String checkFormData(@RequestParam Map<String,Object> map){
        for (String key: map.keySet()){
            System.out.println(key+": "+map.get(key));
        }
        return "Data Recieved";
    }

    @RequestMapping("/form/data/encoded")
    public String checkFormDataEncoded(@RequestParam Map<String,Object> map,
                                       @RequestParam("File") MultipartFile multipartFile){
        for (String key: map.keySet()){
            System.out.println(key+": "+map.get(key));
        }
        System.out.println(multipartFile.getOriginalFilename());
        String s = null;
        try {
             byte[] bytes =  multipartFile.getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream(new File("C:/copy.pdf"));
            fileOutputStream.write(bytes);
        }
        catch (Exception ex){

        }
        return s;
    }
}
