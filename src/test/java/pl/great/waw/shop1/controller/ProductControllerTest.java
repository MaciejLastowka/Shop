package pl.great.waw.shop1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.great.waw.shop1.service.ProductDto;
import pl.great.waw.shop1.service.ProductServiceImpl;

import java.math.BigDecimal;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    private static final String TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999.0);
    private static final ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ProductServiceImpl productService;

    @Autowired
    private MockMvc mockMvc;

    int TEST_DATA_COUNT = 100;

    @Test
    void testPost() throws Exception {
        //given
        Faker faker = new Faker(new Locale("pl"));
        for (int i = 0; i < TEST_DATA_COUNT; i++) {
            String title = faker.food().toString();
            String description = "Description";
            BigDecimal price = BigDecimal.valueOf(faker.number().numberBetween(1, 1500));
            ProductDto productDto = new ProductDto(title, description, price);
            when(productService.create(ArgumentMatchers.any())).thenReturn(productDto);
            //when
            String json = mapper.writeValueAsString(productDto);
            mockMvc.perform(post("/product")
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("utf-8").content(json)
                            .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                    .andExpect(jsonPath("$.description", Matchers.equalTo(description)));

        }
    }

    @Test
    void testGet() throws Exception {
        //when
        ProductDto expectedProductDto = new ProductDto(TITLE, DESCRIPTION, PRICE);
        when(productService.read(ArgumentMatchers.any())).thenReturn(new ProductDto(TITLE, DESCRIPTION, PRICE));
        String json = mapper.writeValueAsString(productService.read(123L));
        //then
        MvcResult mvcResult = mockMvc.perform(get("/product/123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8").content(json)
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.description", Matchers.equalTo(DESCRIPTION)))
                .andReturn();
        //then
        ProductDto productDto = mapper.readValue(mvcResult.getResponse().getContentAsString(), ProductDto.class);
        assertEquals(expectedProductDto, productDto);
    }

    @Test
    void update() throws Exception {
        //when
        ProductDto expectedProductDto = new ProductDto(TITLE, DESCRIPTION, PRICE);
        when(productService.update(ArgumentMatchers.any())).thenReturn(new ProductDto(TITLE, DESCRIPTION, PRICE));
        String json = mapper.writeValueAsString(productService.update(expectedProductDto));
        //then
        MvcResult mvcResult = mockMvc.perform(put("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8").content(json)
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.description", Matchers.equalTo(DESCRIPTION)))
                .andReturn();
        //then
        ProductDto productDto = mapper.readValue(mvcResult.getResponse().getContentAsString(), ProductDto.class);
        assertEquals(expectedProductDto, productDto);
    }

    @Test
    void delete() throws Exception {
        //when
        when(productService.delete(123L)).thenReturn(true);
        //then
         mockMvc.perform((MockMvcRequestBuilders.delete("/product/{id}", 123L)))
                .andExpect(status().isOk());
        //then
        verify(productService, times(1)).delete(123L);
    }

}