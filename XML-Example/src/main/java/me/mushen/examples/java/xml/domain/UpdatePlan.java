package me.mushen.examples.java.xml.domain;

import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author Remilia
 * @Create 2017-11-23
 */
@Setter
@Getter
public class UpdatePlan {
    // 更新视图名
    private String viewName;
    // 更新视图操作主键, 可能为多个
    private List<String> opkeyFields;


    private Map<String, DataSource> jdbcDatasources;
}
