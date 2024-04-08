package com.example.university.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.dao.ICourseDao;
import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;
import com.example.university.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	ICourseDao courseDao;
	
	
	@Override
	public Course addCourse(CourseDTO courseDTO)
	{
		Course course =new Course();
		course.setForum_id(courseDTO.getForum_id());
		course.setTitle(courseDTO.getTitle());
		course.setDescription(courseDTO.getDescription());
		course.setStart_date(courseDTO.getStart_date());
		course.setEnd_date(courseDTO.getEnd_date());
		course.setSch_days(courseDTO.getSch_days());
		course.setSyllabus(courseDTO.getSyllabus());
		course.setJoin_time(courseDTO.getJoin_time());
		course.setEnd_time(courseDTO.getEnd_time());
		course.setLectures_taken(courseDTO.getLectures_taken());
		
		return courseDao.save(course);	
	}
	
	@Override
	public Course updateCourse(Integer userId,CourseDTO courseDTO)
	{
		if (courseDao.existsById(userId))
		{
			Course course =courseDao.findById(userId).get();
			//course.setTeacher(courseDTO.getTeacher_id());
			course.setForum_id(courseDTO.getForum_id());
			course.setTitle(courseDTO.getTitle());
			course.setDescription(courseDTO.getDescription());
			course.setStart_date(courseDTO.getStart_date());
			course.setEnd_date(courseDTO.getEnd_date());
			course.setSch_days(courseDTO.getSch_days());
			course.setSyllabus(courseDTO.getSyllabus());
			course.setJoin_time(courseDTO.getJoin_time());
			course.setEnd_time(courseDTO.getEnd_time());
			course.setLectures_taken(courseDTO.getLectures_taken());
			
			return courseDao.save(course);	
		}else {
			//throw new Exception();
		}
		return null;
	}
	
	public void deleteCourseById(Integer courseId)
	{
		if (courseDao.existsById(courseId)) {
			courseDao.deleteById(courseId);
			//throw new InvalidStudentException();
		}
	}
	
	public CourseDTO findByCourseId(Integer courseId)
	{
		if (courseDao.existsById(courseId)) {
			return courseDao.findByCourseId(courseId);
		}
		return null;
	}
	
	public void incrementLectureCount(Integer courseId)
	{
		if (courseDao.existsById(courseId))
		{
			Course course =courseDao.findById(courseId).get();
			course.setLectures_taken(course.getLectures_taken()+1);
			courseDao.save(course);
		}
	}
}
