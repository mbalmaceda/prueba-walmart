package com.walmart.lider.service.impl;

import static com.walmart.lider.TestUtil.getProductList;
import static com.walmart.lider.TestUtil.getProductNumeric;
import static com.walmart.lider.TestUtil.getSearchNumeric;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertArrayEquals;

import com.walmart.lider.model.Products;
import com.walmart.lider.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SearchProductServiceImplTest {

  @InjectMocks
  @Spy
  private SearchProductServiceImpl searchProductService;

  @MockBean
  private ProductRepository productRepository;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getProductByNumericSearch() {
    when(productRepository.findByCode(Mockito.anyLong()))
        .thenReturn(Optional.of(getProductNumeric()));

    List<Products> productsList = searchProductService.getProductBySearch(getSearchNumeric());
    assertNotNull(productsList);
  }

//  @Test
//  public void getProductByCharacterPalindromeSearch() {
//
//  }
//
//  @Test
//  public void getProductByCharacterNotPalindromeSearch() {
//
//  }
}
