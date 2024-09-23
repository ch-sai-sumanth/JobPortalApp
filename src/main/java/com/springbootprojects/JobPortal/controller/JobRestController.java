package com.springbootprojects.JobPortal.controller;


import com.springbootprojects.JobPortal.model.JobPost;
import com.springbootprojects.JobPortal.service.JobService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("jobs")
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("load")
    public String loadJobs(){
        return service.load();
    }

    @GetMapping("csrf-token")
    public CsrfToken getCSRFToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{jobId}")
    public Optional getJob(@PathVariable int jobId){
        return service.getJob(jobId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost job){
        service.addJob(job);
    }

    @PutMapping("jobPost/{id}")
    public Optional updateJob(@RequestBody JobPost updatedJobPost,@PathVariable int id){
        service.updateJob(updatedJobPost,id);

        return service.getJob( updatedJobPost.getPostId());
    }

    @DeleteMapping("jobPost/{jobPostId}")
    public void deleteJobPost(@PathVariable int jobPostId){
        service.deleteJob(jobPostId);
    }
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword)
    {
        return service.search(keyword);
    }
}
