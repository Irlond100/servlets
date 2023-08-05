package feature.di_annotation.netology.controller;

import com.google.gson.Gson;
import feature.di_annotation.netology.model.Post;
import feature.di_annotation.netology.service.PostService;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

@Controller
public class PostController {
    public static final String APPLICATION_JSON = "application/json";
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    public void all(HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var data = service.all();
        final var gson = new Gson();
        response.getWriter().print(gson.toJson(data));
    }

    public void getById(long id, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final Post post = service.getById(id);
        if (post != null) {
            final var gson = new Gson();
            response.getWriter().print(gson.toJson(post));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void save(Reader body, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var gson = new Gson();
        final var post = gson.fromJson(body, Post.class);
        final var data = service.save(post);
        response.getWriter().print(gson.toJson(data));
    }

    public void removeById(long id, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var removedPost = service.removeById(id);
        if (removedPost != null) {
            final var gson = new Gson();
            response.getWriter().print(gson.toJson(removedPost));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
