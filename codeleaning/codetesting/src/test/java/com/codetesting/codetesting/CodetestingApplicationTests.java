package com.codetesting.codetesting;

import com.codetesting.codetesting.mockingservice.ApplicationDao;
import com.codetesting.codetesting.mockingservice.ApplicationService;
import com.codetesting.codetesting.mockingservice.CollegeStudent;
import com.codetesting.codetesting.mockingservice.StudentGrades;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CodetestingApplicationTests{

	@Test
	void contextLoads() {
	}

	@Mock
	private ApplicationDao applicationDao;

	@InjectMocks
	private ApplicationService applicationService;

	@Autowired
	private CollegeStudent studentOne;
	@Autowired
	private StudentGrades studentGrades;
	@DisplayName("When & Verify")
	@Test
	public void assertEqualsTestAddGrades() {
		//setup expectation
		when(applicationDao.addGradeResultsForSingleClass(
				studentGrades.getMathGradeResults())).thenReturn(100.0);

	}

		//assert result
		//assertEquals(100.0, applicationService.addGradeResultsForSingleClass(studentOne.getStudentGrades().getMathGradeResults()))

		/*
		//Verify the DAO method
		//was called 1 time
		verify(applicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults())
		 */


		// throwing exceptions with mock
		/*
		@DisplayName("Thrown an Exception")
@Test
public void throwAnException() {
 CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");
 //When the checkNull(...) method is called ...
 //thenThrow an exceptio
 when(applicationDao.checkNull(nullStudent)).thenThrow(new RuntimeException());
   //Assert that the exception was thrown
 assertThrows(RuntimeException.class, () -> {applicationService.checkNull(nullStudent);
 });

 //2 case
 @DisplayName("Multiple Stubbing")
@Test
public void stubbingConsecutiveCalls() {
 CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");
 when(applicationDao.checkNull(nullStudent))
 .thenThrow(new RuntimeException())
 .thenReturn("Do not throw exception second time");
 assertThrows(RuntimeException.class, () -> {
 applicationService.checkNull(nullStudent);
 });
 assertEquals("Do not throw exception second time", applicationService.checkNull(nullStudent));
}

//*******************************************


}

	}

	/*

//import org.springframework.beans.factory.annotation.Value;
	@Value("${info.school.name}") //from application properties  info.school.name =
	private String schoolName;
@Value("${info.app.name}")
private String appInfo;
 @Test
 void basicTest() {
 // ...
 }
	 */


	}
