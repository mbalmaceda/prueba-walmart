package com.walmart.lider.controller;

import static com.walmart.lider.TestUtil.getProductList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.walmart.lider.service.SearchProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class SearchEngineControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @InjectMocks
  private SearchEngineController searchEngineController;

  @Mock
  private SearchProductService searchProductService;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(searchEngineController).build();
  }

  @Test
  public void shouldGetAllProductsBySearchParam() throws Exception {
    when(searchProductService.getProductBySearch(Mockito.any())).thenReturn(getProductList());

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
        .get("/api/products/" + 181);

    this.mockMvc.perform(builder).andExpect(status().is2xxSuccessful());
  }
}
