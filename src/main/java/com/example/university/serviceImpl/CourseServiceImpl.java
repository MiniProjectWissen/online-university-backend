package com.example.university.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.university.dao.ICourseDao;
import com.example.university.dao.IStudentDao;
import com.example.university.dao.ITeacherDao;
import com.example.university.dao.Student_Course_MappingDao;
import com.example.university.dto.CourseDTO;
import com.example.university.dto.StudentDTO;
import com.example.university.dto.Student_Course_MappingDTO;
import com.example.university.entity.Course;
import com.example.university.entity.StudentCourseKey;
import com.example.university.entity.Student_Course_Mapping;
import com.example.university.entity.Teacher;
import com.example.university.exception.InvalidCourseException;
import com.example.university.service.ICourseService;

import jakarta.transaction.Transactional;

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
		Teacher t=teacherDao.findById(courseDTO.getTeacher_id()).get();
		course.setTeacher(t);
		return courseDao.save(course);
	}
	
	@Override
	public Course updateCourse(Integer userId,CourseDTO courseDTO)
	{
		if (courseDao.existsById(userId))
		{
			Course course =courseDao.findById(userId).get();
			Teacher t=teacherDao.findById(courseDTO.getTeacher_id()).get();
			course.setTeacher(t);
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
			throw new InvalidCourseException();
		}
	}
	
	public void deleteCourseById(Integer courseId)
	{
		if (courseDao.existsById(courseId)) {
			courseDao.deleteById(courseId);
		}else {
			throw new InvalidCourseException();
		}
	}
	
	public CourseDTO findByCourseId(Integer courseId)
	{

		if (courseDao.existsById(courseId)) {
			return courseDao.findByCourseId(courseId);
		}else {
			throw new InvalidCourseException();
		}
	}
	
	public void incrementLectureCount(Integer courseId)
	{
		if (courseDao.existsById(courseId))
		{
			Course course =courseDao.findById(courseId).get();
			course.setLectures_taken(course.getLectures_taken()+1);
			courseDao.save(course);
		}else {
			throw new InvalidCourseException();
		}
	}

	
	public List<CourseDTO> getAllCourses()
	{
		return courseDao.findAllCourses();
	}
	
	public List<CourseDTO> getAllCoursesByTeacher(int teacherID)
	{
		return courseDao.findAllCoursesByTeacher(teacherID);
	}
	
	@Transactional
	public Student_Course_Mapping addStudentCourse(Student_Course_MappingDTO student_Course_MappingDTO) {
//		
//		Student s = studentDao.findById(student_Course_MappingDTO.getId().getStud_id()).get();
//		Course c = courseDao.findById(student_Course_MappingDTO.getId().getCourse_id()).get();


		if(!student_Course_MappingDao.existsById(student_Course_MappingDTO.getId())) {
			
			Student_Course_Mapping scm = new Student_Course_Mapping();
			scm.setId(student_Course_MappingDTO.getId());
			scm.setAttendance_lecture_count(0);
			return student_Course_MappingDao.save(scm);
		}
		return null;
	}
	
	@Modifying
	@Transactional
	public void incrementStudentAttendenceCount(int stud_id,int course_id) {
//		if(student_Course_MappingDao.existsById({})) {
			StudentCourseKey sck = new StudentCourseKey(stud_id,course_id);
			Student_Course_Mapping scm = student_Course_MappingDao.findById(sck).get();
			scm.setAttendance_lecture_count(scm.getAttendance_lecture_count()+1);
			student_Course_MappingDao.save(scm);
//		}
	}
	
	@Transactional
	public double getCourseAttendence(int stud_id,int course_id) {
//		if(student_Course_MappingDao.existsById(id)) {
			
			StudentCourseKey sck = new StudentCourseKey(stud_id,course_id);

			Student_Course_Mapping scm = student_Course_MappingDao.findById(sck).get();
			Course c = courseDao.findById(sck.getCourse_id()).get();
			int total_lectures = c.getLectures_taken();
			int attended_lectures = scm.getAttendance_lecture_count();
			double att = (double) ((double)attended_lectures/total_lectures)*100d;
			double roundedValue = (double) Math.round(att * 100) / 100;

			return roundedValue;
//		}
//		return 0.0;
	}
	
	public List<StudentDTO> getAllStudentsByCourse(int course_id) {
		List<Student_Course_Mapping> list = student_Course_MappingDao.findAll();
		List<Integer> l1 = new ArrayList<Integer>();
		for(Student_Course_Mapping scm: list ) {
			if(scm.getId().getCourse_id()==course_id)
				l1.add(scm.getId().getStud_id());
		}
		System.out.println(list);
		return studentDao.findAllStudentByCourse(l1);
	}


}