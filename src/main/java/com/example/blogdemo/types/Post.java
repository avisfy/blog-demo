package com.example.blogdemo.types;

import lombok.*;

import java.lang.Integer;
import java.lang.String;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
  private Integer id;

  private String title;

  private String text;

  private Integer likes;

  private Integer authorId;
}
