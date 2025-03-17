package com.example.miniproject.dto;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PageRequestDTO {
    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size=10;

    private String keyword;
    private String[] colors;
    private String[] shapes;
    private String[] usefors;
    private String[] textures;
    private String[] patterns;
    private String[] seasons;
    public Pageable pageable(String...props){
        return PageRequest.of(this.page-1, this.size, Sort.by(props).descending());
    }
}
