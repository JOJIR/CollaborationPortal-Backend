package com.niit.backend.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.JobDao;
import com.niit.backend.model.Job;
import com.niit.backend.model.User;

@RestController
public class JobController {
	
	@Autowired
	private JobDao jobDao;
	@RequestMapping(value="/postJob", method=RequestMethod.POST)
	public ResponseEntity<?> postJob(@RequestBody Job job,HttpSession session)
	{
		User user=(User) session.getAttribute("user");
		if(user==null)
		{
			//Error error=new Error(1,"Unauthorized user...login using valid credentials");
			Error error=new Error();
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		else
		{
			System.out.println("Role of User: " + user.getRole());
	       // job.setPostedOn(new Date());
			jobDao.postJob(job);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	@RequestMapping(value="/getAllJobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session)
	{
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			System.out.println("User is null");
			//Error error=new Error(1,"Unauthorized user! Please login using valid credentials");
			Error error=new Error();
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);//401
		}
		System.out.println("User object: " + user.getRole());
		List<Job> jobs=jobDao.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}

}