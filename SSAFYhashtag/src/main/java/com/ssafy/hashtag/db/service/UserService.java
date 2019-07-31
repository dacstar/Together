package com.ssafy.hashtag.db.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.hashtag.db.dto.PostDto;
import com.ssafy.hashtag.db.dto.UserDto;
import com.ssafy.hashtag.db.dao.PostDao;
import com.ssafy.hashtag.db.dao.UserDao;

@Service
public class UserService {
    
    @Autowired
    private PostDao postdao;
    @Autowired
    private UserDao userdao;

    public String Signup(UserDto userdto) throws Exception {
        System.out.println("****************signup userservice**********************");
        
        if(userdao.Check_email(userdto.getEmail()) == 0 && userdao.Check_name(userdto.getNickname()) == 0) {
            userdao.Signup(userdto);
            return "회원가입에 성공했습니다.";
        } else {
            return "회원가입에 실패했습니다. 이메일 또는 닉네임 중복을 확인해주세요.";
        }
    }

    public String Check_name(@RequestBody UserDto userdto) throws Exception {
        System.out.println("****************Check_name userservice**********************");
        System.out.println(userdto.getNickname());
        int flag = userdao.Check_name(userdto.getNickname());
        String msg;

        if(userdto.getNickname().length() == 0) {
            msg = "닉네임을 적어주세요.";
        } else {
            if(flag == 0) {
                msg = "사용가능한 닉네임입니다.";
            } else {
                msg = "이미있는 닉네임입니다.";
            }
        }
        return msg;
    }

    public String Check_email(@RequestBody UserDto userdto) throws Exception {
        System.out.println("****************Check_email userservice**********************");
        System.out.println(userdto.getEmail());
        int flag = userdao.Check_email(userdto.getEmail());
        String msg;

        if(userdto.getEmail().length() == 0) {
            msg = "이메일을 적어주세요.";
        } else {
            if(flag == 0) {
                msg = "사용가능한 이메일입니다.";
            } else {
                msg = "이미있는 이메일입니다.";
            }
        }
        return msg;
    }

    public Integer Login(UserDto userdto, HttpSession session) throws Exception {
        System.out.println("****************login userservice**********************");
        String email;
        String pw;
        int code;

        // 이메일 확인해서 없으면
        if((userdao.Check_email(userdto.getEmail()) == 0 )) {
            code = 404;
        }
        // 이메일이 있는 경우에 비밀번호 확인
        else {
            email = userdto.getEmail();
            pw = userdto.getPassword();
            // 비밀번호가 틀리면
            if(!userdao.Check_login(email).getPassword().equals(pw)) {
                code = 404;
            }
            // 비밀번호가 맞으면
            else {
                userdao.Login(userdto);
                code = 200;
            }
        }
        return code;
    }

    public String Update_user(UserDto userdto, HttpSession session) throws Exception {
        System.out.println("****************Update_user userservice**********************");
        userdao.Update_user(userdto);
        return "회원정보가 수정되었습니다.";
    }

    public void Delete_user(int user_pk) throws Exception {
        System.out.println("****************delete userservice**********************");
        userdao.Delete_user(user_pk);
    }
}