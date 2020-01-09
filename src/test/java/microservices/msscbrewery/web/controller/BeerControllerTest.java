package microservices.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import microservices.msscbrewery.web.model.BeerDto;
import microservices.msscbrewery.web.service.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    private static final String CONTROLLER_PATH = "/api/v1/beer/";
    @MockBean
    private BeerService beerService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private BeerDto beerDto;

    @BeforeEach
    public void setUp() {
        beerDto = BeerDto.builder()
                .name("Indian Piss Ale")
                .style("Style")
                .upc(1L)
                .build();
        when(beerService.save(any())).thenReturn(beerDto);
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get(CONTROLLER_PATH + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post(CONTROLLER_PATH)
                .content(beerDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put(CONTROLLER_PATH + UUID.randomUUID())
                .content(beerDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}