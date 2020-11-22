
package udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import udemy.model.Course;

import java.util.HashMap;

@RestController
public class RestEndPoints {

    @Value("${default.course.name}")
    private String name;

    @Value("${default.course.chapterCount}")
    private int chapterCount;

    @Autowired
    private CourseConfiguration courseConfiguration;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/defaultCourse", method = RequestMethod.GET)
    public Course getDefaultCourse(@RequestParam(value = "name", defaultValue = "Spring boot", required = false) String name,
                                   @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
        return new Course(this.name, this.chapterCount);
    }


    @RequestMapping(value = "/getHierarchical", method = RequestMethod.GET)
    public HashMap<String, Object> getConfigAnnotateCourse(@RequestParam(value = "name", defaultValue = "Spring boot", required = false) String name,
                                                           @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", courseConfiguration.getName());
        hashMap.put("author", courseConfiguration.getAuthor());
        hashMap.put("chapterCount", courseConfiguration.getChapterCount());
        hashMap.put("rating", courseConfiguration.getRating());

        return hashMap;
    }

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public Course getCourse(@RequestParam(value = "name", defaultValue = "Spring boot", required = false) String name,
                            @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
        return new Course(name, chapterCount);
    }

    @RequestMapping(value = "/register/course", method = RequestMethod.POST)
    public String saveCourse(@RequestBody Course course) {
        // code that uses the language variable
        return "Course saved name: " + course.getName() + "chapter: " + course.getChapterCount();
    }

}

