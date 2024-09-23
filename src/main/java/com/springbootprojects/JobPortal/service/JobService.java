package com.springbootprojects.JobPortal.service;


import com.springbootprojects.JobPortal.model.JobPost;
import com.springbootprojects.JobPortal.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public Optional getJob(int jobId) {
        return repo.findById(jobId);
    }

    public void addJob(JobPost job) {
        repo.save(job);
    }

    public void updateJob(JobPost updatedJobPost,int id) {

        JobPost jobPost=repo.findById(id).get();

        jobPost.setPostProfile(updatedJobPost.getPostProfile());
        jobPost.setPostDesc(updatedJobPost.getPostDesc());
        jobPost.setReqExperience(updatedJobPost.getReqExperience());
        jobPost.setPostTechStack(updatedJobPost.getPostTechStack());

        repo.save(jobPost);
    }

    public void deleteJob(int jobPostId) {
        repo.deleteById(jobPostId);
    }

    public String load() {
        List<JobPost> jobPosts = Arrays.asList(
                new JobPost(1, "Software Engineer", "Develop and maintain software solutions.", 2, Arrays.asList("Java", "Spring", "SQL")),
                new JobPost(2, "Backend Developer", "Build and maintain backend services.", 3, Arrays.asList("Node.js", "Express", "MongoDB")),
                new JobPost(3, "Frontend Developer", "Create responsive web applications.", 1, Arrays.asList("React", "CSS", "JavaScript")),
                new JobPost(4, "DevOps Engineer", "Manage CI/CD pipelines and infrastructure.", 4, Arrays.asList("Docker", "Kubernetes", "AWS")),
                new JobPost(5, "Full Stack Developer", "Work on both frontend and backend.", 3, Arrays.asList("Angular", "Node.js", "MySQL")),
                new JobPost(6, "Mobile App Developer", "Develop Android and iOS apps.", 2, Arrays.asList("Flutter", "Swift", "Kotlin")),
                new JobPost(7, "QA Engineer", "Automate testing processes.", 1, Arrays.asList("Selenium", "JUnit", "Cucumber")),
                new JobPost(8, "Data Scientist", "Analyze and interpret complex data.", 4, Arrays.asList("Python", "TensorFlow", "Pandas")),
                new JobPost(9, "Machine Learning Engineer", "Develop ML models and algorithms.", 3, Arrays.asList("Python", "Scikit-learn", "PyTorch")),
                new JobPost(10, "Cloud Engineer", "Design and deploy cloud infrastructure.", 5, Arrays.asList("Azure", "AWS", "Terraform")),
                new JobPost(11, "Database Administrator", "Manage database systems and optimize queries.", 2, Arrays.asList("PostgreSQL", "Oracle", "SQL")),
                new JobPost(12, "Cybersecurity Specialist", "Ensure security of systems and data.", 4, Arrays.asList("Penetration Testing", "Firewalls", "Nmap")),
                new JobPost(13, "UI/UX Designer", "Design user-friendly interfaces.", 2, Arrays.asList("Figma", "Sketch", "Adobe XD")),
                new JobPost(14, "Tech Lead", "Lead software development teams.", 6, Arrays.asList("Java", "Microservices", "Agile")),
                new JobPost(15, "Big Data Engineer", "Work with large datasets and pipelines.", 3, Arrays.asList("Hadoop", "Spark", "Kafka")),
                new JobPost(16, "System Administrator", "Maintain and configure IT systems.", 2, Arrays.asList("Linux", "Windows Server", "Bash")),
                new JobPost(17, "Game Developer", "Develop games for multiple platforms.", 2, Arrays.asList("Unity", "C#", "Blender")),
                new JobPost(18, "AR/VR Developer", "Build augmented and virtual reality experiences.", 3, Arrays.asList("C#", "Unreal Engine", "OpenXR")),
                new JobPost(19, "Blockchain Developer", "Develop decentralized applications.", 3, Arrays.asList("Solidity", "Ethereum", "Web3.js")),
                new JobPost(20, "Site Reliability Engineer", "Ensure system reliability and uptime.", 4, Arrays.asList("Python", "Ansible", "Prometheus"))
        );

        repo.saveAll(jobPosts);
        return "Jobs added succesfully";

    }

    public List<JobPost> search(String keyword) {

        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
