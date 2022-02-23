package com.lf.controller;

import com.lf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);

        for(MultipartFile multipartFile:uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("F:\\upload\\" + originalFilename));
        }



    }

    @RequestMapping("/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile,MultipartFile uploadFile2) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);

        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("F:\\upload\\"+originalFilename));

        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(new File("F:\\upload\\"+originalFilename2));

    }

    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);

    }

    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username,int age) {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() {
        return "hello wa";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws Exception{
        response.getWriter().print("hello wa");
    }
    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("controller ..");
        return "success";
    }
}
