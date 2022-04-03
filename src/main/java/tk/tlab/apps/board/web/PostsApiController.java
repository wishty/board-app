package tk.tlab.apps.board.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tk.tlab.apps.board.service.posts.PostsService;
import tk.tlab.apps.board.web.dto.PostsListResponseDto;
import tk.tlab.apps.board.web.dto.PostsResponseDto;
import tk.tlab.apps.board.web.dto.PostsSaveRequestDto;
import tk.tlab.apps.board.web.dto.PostsUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }
}
