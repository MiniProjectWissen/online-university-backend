package com.example.university.serviceImpl;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.dao.ICourseDao;
import com.example.university.dao.IStudentDao;
import com.example.university.dao.ITeacherDao;
import com.example.university.dao.Student_Course_MappingDao;
import com.example.university.dto.CourseDTO;
import com.example.university.dto.Student_Course_MappingDTO;
import com.example.university.entity.Course;
import com.example.university.entity.Student;
import com.example.university.entity.StudentCourseKey;
import com.example.university.entity.Student_Course_Mapping;
import com.example.university.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	ICourseDao courseDao;
	
	@Autowired
	ITeacherDao teacherDao;
	
	@Autowired
	IStudentDao studentDao;
	
	@Autowired
	Student_Course_MappingDao student_Course_MappingDao;

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
		//course.setTeacher(teacherDao.findById(courseDTO.getTeacher_id()));
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

	
	public List<CourseDTO> getAllCourses()
	{
		return courseDao.findAllCourses();
	}
	
	public Student_Course_Mapping addStudentCourse(Student_Course_MappingDTO student_Course_MappingDTO) {
		Student s = studentDao.findById(student_Course_MappingDTO.getId().getStud_id()).get();
		Course c = courseDao.findById(student_Course_MappingDTO.getId().getCourse_id()).get();
		ArrayList<Course> my_course_list=s.getCourses();
		my_course_list.add(c);
		s.setCourses(my_course_list);
		
		Student_Course_Mapping scm = new Student_Course_Mapping();
		scm.setId(student_Course_MappingDTO.getId());
		scm.setAttendance_lecture_count(0);
		return student_Course_MappingDao.save(scm);
	}
	
	public void incrementStudentAttendenceCount(StudentCourseKey id) {
		if(student_Course_MappingDao.existsById(id)) {
			
			Student_Course_Mapping scm = student_Course_MappingDao.findById(id).get();
			scm.setAttendance_lecture_count(scm.getAttendance_lecture_count()+1);
			student_Course_MappingDao.save(scm);
		}
	}
	
	public Double getCourseAttendence(StudentCourseKey id) {
		if(student_Course_MappingDao.existsById(id)) {
			
			Student_Course_Mapping scm = student_Course_MappingDao.findById(id).get();
			Course c = courseDao.findById(id.getCourse_id()).get();
			int total_lectures = c.getLectures_taken();
			int attended_lectures = scm.getAttendance_lecture_count();
			Double attendence = (attended_lectures/total_lectures)*100d;
			return attendence;
		}
		return 0.0;
	}

}
