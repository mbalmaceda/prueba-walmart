package com.walmart.lider.controller;

import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Search {
  private String search;

  public boolean isPalindrome() {
    String temp = search.replaceAll("\\s+", "").toLowerCase();
    return IntStream.range(0, temp.length() / 2)
        .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
  }
}
