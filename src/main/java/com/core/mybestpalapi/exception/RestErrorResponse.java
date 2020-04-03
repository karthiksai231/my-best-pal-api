package com.core.mybestpalapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@AllArgsConstructor
@Getter
@Setter
public class RestErrorResponse {
    private int status;
    private String message;

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof RestErrorResponse)) {
            return false;
        }

        RestErrorResponse restErrorResponse = (RestErrorResponse) o;

        return new EqualsBuilder()
                .append(status, restErrorResponse.status)
                .append(message, restErrorResponse.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(status)
                .append(message)
                .toHashCode();
    }
}
