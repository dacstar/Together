package com.ssafy.hashtag.db.controller;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;

import com.ssafy.hashtag.db.dto.PostDto;
import com.ssafy.hashtag.db.service.PostService;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
@RequestMapping("/api/post")
@Api(value="SSAFY", description="Board Resouces Management 2019")
public class PostController { 
    public static final Logger logger = 
        LoggerFactory.getLogger(PostController.class);

    String ns = "com.ssafy.hashtag.db.";
    
    @Autowired
    private PostService postservice;
    

    @RequestMapping(value = "/addlocationBasedList", method = RequestMethod.POST)
    public void addlocationBasedList() throws Exception {
        logger.info("\n****************add Controller**********************");
        postservice.locationBasedList();
    }
    
    @RequestMapping(value = "/areacode/{areacode}", method = RequestMethod.GET)
    public ResponseEntity<List<PostDto>> Areacode(@PathVariable int areacode) throws Exception {
        logger.info("****************AreaCode Controller**********************");
        List<PostDto> posts = postservice.Areacode(areacode);
        
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }
}