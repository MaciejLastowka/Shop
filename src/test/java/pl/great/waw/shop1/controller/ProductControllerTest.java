package pl.great.waw.shop1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.great.waw.shop1.service.ProductDto;
import pl.great.waw.shop1.service.ProductServiceImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private static final Long PRODUCT_ID = 12L;
    private static final String PRODUCT_TITLE = "iPhone 14";
    private static final String DESCRIPTION = "The iPhone is a line of smartphones by Apple";
    private static final BigDecimal PRICE = BigDecimal.valueOf(999);


    private static final ObjectMapper mapper = new ObjectMapper();
    @MockBean
    private ProductServiceImpl productService;

    @Autowired
    private MockMvc mockMvc;

    ProductDto productDto;

    @BeforeEach
    void setUp(){
         productDto = new ProductDto(PRODUCT_TITLE, DESCRIPTION, PRICE, null, null);

    }

    @Test
    void get() throws Exception {
        //given
        when(productService.get(PRODUCT_ID)).thenReturn(this.productDto);
        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(productDto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //then
        ProductDto result = mapper.readValue(mvcResult.getResponse().getContentAsString(), ProductDto.class);
        assertEquals(result, productDto);
    }

    @Test
    void create() throws Exception {
        //given
        when(productService.create(productDto)).thenReturn(productDto);
        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(productDto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //then
        ProductDto result = mapper.readValue(mvcResult.getResponse().getContentAsString(), ProductDto.class);
        assertEquals(productDto, result);
    }

    @Test
    void delete() throws Exception {
        //given
        Long id = 1L;
        when(productService.delete(id)).thenReturn(true);
        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/products/{id}", id))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //then
        assertTrue(Boolean.parseBoolean(mvcResult.getResponse().getContentAsString()));
    }

    @Test
    void update() throws Exception {
        //given
        Long id = 1L;
        when(productService.update(productDto)).thenReturn(productDto);
        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/products/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(productDto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //then
        ProductDto result = mapper.readValue(mvcResult.getResponse().getContentAsString(),ProductDto.class);
        assertEquals(productDto, result);
    }
}