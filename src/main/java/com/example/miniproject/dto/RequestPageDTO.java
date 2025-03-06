package com.example.miniproject.dto;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Getter @Setter @ToString
@NoArgsConstructor @Builder
@AllArgsConstructor
public class RequestPageDTO {

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    private String type;

    private String color;
    private String shape;
    private String usefor;
    private String texture;
    private String pattern;
    private String season;

    private  String keyword;

    private String link;

    public String[] getTypes(){
        if(type == null || type.isEmpty()){
            return null;
        }
        return  type.split("");
    }

    public String[] getCateg(String categ){
        if(categ == null || categ.isEmpty()){
            return null;
        }
        return  categ.split(",");
    }

    public Pageable getPageable(String...props){
        return PageRequest
                .of(this.page - 1, this.size, Sort.by(props).descending());
    }

    public String getLink() {

        if (link == null){
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);

            if (type != null && type.length() > 0){
                builder.append("&type=" + type);
            }

            if (keyword != null){
                try {
                  builder.append("&keyword=" + URLEncoder.encode(keyword,"UTF-8"));
                }catch (UnsupportedEncodingException e){

                }
            }
            link = builder.toString();
        }
        System.out.println(link);
        return link;
    }
}