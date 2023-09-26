package com.example.blogdemo.types;

import lombok.*;

import java.lang.String;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
  private Integer id;

  private String text;

  private Integer userId;

  private Integer postId;

}
