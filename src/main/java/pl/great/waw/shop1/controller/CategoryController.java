package pl.great.waw.shop1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.great.waw.shop1.Mapper.CategoryMapper;
import pl.great.waw.shop1.controller.dto.CategoryDto;
import pl.great.waw.shop1.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("category")

public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper mapper;

    //FIXME use SERVICE

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(category -> mapper.map(category)).collect(Collectors.toList());
    }
}
