package com.example.blogdemo.types;

import lombok.*;

import java.lang.String;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Integer id;

  private String name;

  private String email;
}
