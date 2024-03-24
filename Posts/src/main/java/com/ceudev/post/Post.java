package com.ceudev.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {

    private Long id;

    private String title;

    private String description;

    private Long userId;

}
