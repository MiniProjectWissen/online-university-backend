package com.example.university.entity;

import org.springframework.stereotype.Component;

import com.example.university.dto.CourseDTO;

@Component
public class CourseMapper {

    public CourseDTO toDto(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setCourse_id(course.getCourse_id());
        dto.setForum_id(course.getForum_id());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setStart_date(course.getStart_date());
        dto.setEnd_date(course.getEnd_date());
        dto.setSch_days(course.getSch_days());
        dto.setSyllabus(course.getSyllabus());
        dto.setJoin_time(course.getJoin_time());
        dto.setEnd_time(course.getEnd_time());
        dto.setLectures_taken(course.getLectures_taken());
        dto.setTeacher_id(course.getTeacher().getTeacher_id());

        return dto;
    }

    public Course toEntity(CourseDTO dto) {
    	
        Course course = new Course();
        course.setCourse_id(dto.getCourse_id());
        course.setForum_id(dto.getForum_id());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setStart_date(dto.getStart_date());
        course.setEnd_date(dto.getEnd_date());
        course.setSch_days(dto.getSch_days());
        course.setSyllabus(dto.getSyllabus());
        course.setJoin_time(dto.getJoin_time());
        course.setEnd_time(dto.getEnd_time());
        course.setLectures_taken(dto.getLectures_taken());
        //course.setTeacher(dto.getTeacher_id());
        return course;
    }
}
