package io.stream.models;

import org.jetbrains.annotations.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sort {
  @NotNull
  @JsonProperty("field")
  private String field;

  @NotNull
  @JsonProperty("direction")
  private Integer direction;

  private Sort(Builder builder) {
    this.field = builder.field;
    this.direction = builder.direction;
  }

  /**
   * Creates builder to build {@link Sort}.
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Sort}.
   */
  public static final class Builder {
    private String field;
    private Integer direction;

    private Builder() {}

    @NotNull
    public Builder withField(@NotNull String field) {
      this.field = field;
      return this;
    }

    @NotNull
    public Builder withDirection(@NotNull Integer direction) {
      this.direction = direction;
      return this;
    }

    @NotNull
    public Sort build() {
      return new Sort(this);
    }
  }
  
  
}
