package com.company.models;

import com.company.common.JpaConverterJson;
import com.company.common.JpaConverterJsonArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "data_sources")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class DataSource extends AbstractDatedEntity {

  protected static ObjectMapper objectMapper = new ObjectMapper();

  @Column(name = "name")
  //@ApiModelProperty(required = true, value = "Name of the DataSource")
  private String name;

  @Column(name = "description")
  //@ApiModelProperty(required = false, value = "Description of the DataSource")
  private String description;

  @Column(name = "external_system_id")
  //@ApiModelProperty(required = true, value = "Foreign key to ExternalSystem")
  private Long externalSystemId;

  // actually contains external system type
  @Column(name = "connector_type_id")
  //@ApiModelProperty(required = true, value = "Foreign key to ExternalSystemType")
  private Long connectorTypeId;

  @Column(name = "tenant_user_id")
  //@ApiModelProperty(required = true, value = "Id of the TenantUser creating the DataSource")
  private long tenantUserId;

  @Convert(converter = JpaConverterJsonArray.class)
  @Column(name = "functions")
  //@ApiModelProperty(value = "Functions")
  private JSONArray functions;

  @Column(name = "cron_schedule")
  //@ApiModelProperty(value = "Null/Empty or a valid cron format")
  private String cronSchedule;

  @Column(name = "enabled")
  //@ApiModelProperty(required = true, value = "Is the repeating schedule active for DataSource")
  private Boolean enabled;

  @Column(name = "is_public")
  //@ApiModelProperty(required = false, value = "Is public")
  private Boolean isPublic;

  @Convert(converter = JpaConverterJson.class)
  @Column(name = "input_params")
  //@ApiModelProperty(required = true, value = "Serialized JSON String. Quotes need escaping")
  private JSONObject inputParams;

  @Column(name = "start_date")
  //@ApiModelProperty(value = "Start date")
  private Timestamp startDate;

  @Column(name = "end_date")
  //@ApiModelProperty(value = "End date")
  private Timestamp endDate;

  @Column(name = "transformation_script")
  //@ApiModelProperty(value = "Javascript to transform incoming stream in webhook APIs")
  private String transformationScript;
}
