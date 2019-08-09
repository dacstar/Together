package com.ssafy.hashtag.db.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.ssafy.hashtag.db.dto.ScheduleDto;
import com.ssafy.hashtag.db.mapper.ScheduleMapper;

@Repository
public class ScheduleDao implements ScheduleMapper {
  public static final Logger logger = LoggerFactory.getLogger(ScheduleMapper.class);

  @Autowired
  private SqlSession sqlSession;

  String ns = "com.ssafy.hashtag.db.";

  @Override
  public void Add_schedule(ScheduleDto scheduledto) throws Exception {
    logger.info("**************** add ScheduleDao **********************");
    System.out.println(scheduledto.toString());
    sqlSession.insert(ns + "add_schedule", scheduledto);
  }

  @Override
  public void Delete_schedule(int schedule_pk) throws Exception {
    logger.info("**************** delete ScheduleDao **********************");
    sqlSession.insert(ns + "delete_schedule", schedule_pk);
  }

  @Override
  public List<ScheduleDto> allSchedule(int user_pk) throws Exception {
    logger.info("**************** all ScheduleDao **********************");
    return sqlSession.selectList(ns + "allschedule", user_pk);

  }
}