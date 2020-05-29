package com.poc.tenant.result;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MultipulSelectResult {
  private Integer userId;
  private String userName;
  private Integer age;
  private String associateId;
  private String fieldName;
}
