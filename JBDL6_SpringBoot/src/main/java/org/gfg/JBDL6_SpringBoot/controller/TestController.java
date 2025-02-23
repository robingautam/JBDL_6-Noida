package org.gfg.JBDL6_SpringBoot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private static Logger LOGGER = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("/get/data")
    public String getData(){
        return "This is first controller";
    }

    @PostMapping("/form/data")
    public String checkFormData(@RequestParam Map<String,Object> map){
        LOGGER.info("This is INFO Logger");
        LOGGER.debug("This is DEBUG Logger");
        LOGGER.trace("This is TRACE Logger");
        LOGGER.error("This is ERROR Logger");
        LOGGER.warn("This is WARN Logger");
        for (String key: map.keySet()){
            System.out.println(key+": "+map.get(key));
        }
        LOGGER.info("Exiting the checkFormData");
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
