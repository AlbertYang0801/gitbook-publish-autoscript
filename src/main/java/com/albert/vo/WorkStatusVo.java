package com.albert.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Albert
 * @date 2021/2/20 下午4:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkStatusVo {

    private Boolean status;
    private String msg;


}
