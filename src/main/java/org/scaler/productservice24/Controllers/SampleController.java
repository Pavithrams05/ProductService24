package org.scaler.productservice24.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello/{name}/{noOfTimes}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("noOfTimes") int no){
        String response = "";
        for (int i=0;i<no;i++){
            String s = "hello " + name+"</br>";
            response+=s;
        }
        return response;
    }
}
