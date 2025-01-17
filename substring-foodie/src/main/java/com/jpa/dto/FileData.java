package com.jpa.dto;

import lombok.*;
//
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class FileData {
//
//    private String fileName;
//    private String filePath;
//}


public record FileData(String fileName, String filePath){

}
